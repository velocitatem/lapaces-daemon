/**************************************************************************
  AstronomicalAlgorithms

  A portable ANSI C implementation of some of the algorithms published in

        Astronomical Algorithms
        by Jean Meeus
        2nd edition (December 1998)
        Willmann-Bell
        ISBN: 0943396638

  by Christophe DAVID (christophe.david@christophedavid.org)

  You may use parts of this source code as long as

       - you mention clearly that its latest version can be obtained
         free of charge at

         http://www.christophedavid.org/

       AND

      - you send me a free copy of whatever you make using this code.

     Comments and suggestions welcome.

**************************************************************************/

/*!
@file
@brief       calculates the julian day for a given date
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double *JulianDay
@param double  year
@param double  month
@param double  day
@param short   calendar : 0 for julian, 1 for gregorian

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4
- 5 : error in parameter 5
- 101 : error in day (february 29 for non leap year)
- 901 : internal call to AstroAlgo_IsLeapYear failed

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?JulianDay.c
@endif

*/

/* see page 59 */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShJulianDay(double *pdoJD, double doY, double doM, double doD, short shCalendar)
            /* shCalendar JULIAN for julian, GREGORIAN for gregorian */
   {
   short  shReturnValue      = (short) 0;
   short  shIsLeap           = (short) 0;
   double adoDaysInMonth[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

   if (pdoJD != NULL)
      {
      *pdoJD = (double) 0;
      }

   if (pdoJD == NULL)
      {
      shReturnValue = (short) 1;
      }

   else if ((doM < 1) || (doM > 12))
      {
      shReturnValue = (short) 3;
      }

   else if ((doD < 1) || (doD > adoDaysInMonth[(int) doM - 1]))
      {
      shReturnValue = (short) 4;
      }

   else if (   (shCalendar != (short) JULIAN)
            && (shCalendar != (short) GREGORIAN)
          )
      {
      shReturnValue = (short) 5;
      }

   /* leap year validation */
   else if (ShIsLeapYear(&shIsLeap, (short) doY, shCalendar) != 0)
      {
      shReturnValue = (short) 901;
      }

   else if ((doM == 2) && (doD == 29) && (shIsLeap != 1))
      {
      shReturnValue = (short) 101;
      }

   else
      {
      double doA = (double) 0;
      double doB = (double) 0;

      if (doM <= 2)
         {
         doY -= (double)  1;
         doM += (double) 12;
         }

      doA = floor(doY / (double) 100);
      if (shCalendar == GREGORIAN)
         {
         doB = (double) 2 - doA + floor(doA / (double) 4);
         }

      #if 0
      (void) fprintf(stdout, "doA = %f, doB = %f\n", doA, doB);
      #endif

      *pdoJD =   floor((double) 365.25   * (doY + (double) 4716))
              + floor((double)  30.6001 * (doM + (double)    1))
              + doD + doB - (double) 1524.5;
      }

   return shReturnValue;
   }

