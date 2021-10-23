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
@brief       calculates the day of the week for a given date
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double * DayOfWeek
@param double   year
@param double   month
@param double   day

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?DayOfWeek.c
@endif
*/

/* see page 65 */

/* DOW = 0 for Sunday, ..., 6 for Saturday */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShDayOfWeek(short *pshDOW, double doY, double doM, double doD)
   {
   short  shReturnValue = (short)  0;

   if (pshDOW == NULL)
      {
      shReturnValue = (short) 1;
      }

   else
      {
      double doJD = (double) 0;

      *pshDOW = (short) -1;
      shReturnValue = ShJulianDay(&doJD, doY, doM, doD, (short) GREGORIAN);
      if (shReturnValue == 0)
         {
         doJD += (double) 1.5;
         *pshDOW = (short) ((unsigned long) doJD % (unsigned long) 7);
         }
      }

   return shReturnValue;
   }

