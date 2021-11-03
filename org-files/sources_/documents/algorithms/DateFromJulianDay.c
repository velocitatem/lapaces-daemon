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
@brief       calculates a date from a julian day
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double JulianDay,
@param double *year,
@param double *month,
@param double *day
@param double *hours
@param double *minutes
@param double *seconds

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4
- 5 : error in parameter 5
- 6 : error in parameter 6
- 7 : error in parameter 7

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?DateFromJulianDay.c
@endif
*/

/* see page 63 */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShDateFromJulianDay(double doJD, double *pdoY, double *pdoMonth, double *pdoD,
                                 double *pdoH, double *pdoMin,   double *pdoS)
   {
   short shReturnValue = (short) 0;

   if (pdoY != NULL)
      {
      *pdoY = (double) -1;
      }

   if (pdoMonth != NULL)
      {
      *pdoMonth = (double) -1;
      }

   if (pdoD != NULL)
      {
      *pdoD = (double) -1;
      }

   if (doJD < 0)
      {
      shReturnValue = (short) 1;
      }

   else if (pdoY == NULL)
      {
      shReturnValue = (short) 2;
      }

   else if (pdoMonth == NULL)
      {
      shReturnValue = (short) 3;
      }

   else if (pdoD == NULL)
      {
      shReturnValue = (short) 4;
      }

   else if (pdoH == NULL)
      {
      shReturnValue = (short) 5;
      }

   else if (pdoMin == NULL)
      {
      shReturnValue = (short) 6;
      }

   else if (pdoS == NULL)
      {
      shReturnValue = (short) 7;
      }
   else
      {
      double do1     = (double) 0;
      double do2     = (double) 0;
      double doZ     = floor(doJD + (double) 0.5);
      double doF     = doJD + (double) 0.5 - doZ;
      double doA     = (double) 0;
      double doAlpha = (double) 0;
      double doB     = (double) 0;
      double doC     = (double) 0;
      double doD     = (double) 0;
      double doE     = (double) 0;

      if (doZ < (double) 2299161)
         {
         doA = doZ;
         }
      else
         {
         doAlpha = floor((doZ - (double) 1867216.25) / (double) 36524.25);
         doA = doZ + (double) 1 + doAlpha - floor(doAlpha / (double) 4);
         }

      doB = doA + (double) 1524;
      doC = floor((doB - (double) 122.1) / (double) 365.25);
      doD = floor(doC * (double) 365.25);
      doE = floor((doB - doD) / (double) 30.6001);

      *pdoD = doB - doD - floor(doE * (double) 30.6001) + doF;
      *pdoMonth = (double) (doE < (double) 14 ? doE - (double)  1
                                              : doE - (double) 13);

      *pdoY = (double) (*pdoMonth > (double) 2 ? doC - (double) 4716
                                               : doC - (double) 4715);


      /* drop fractional parts */
      *pdoY      = floor(*pdoY);
      *pdoMonth  = floor(*pdoMonth);
      *pdoD      = floor(*pdoD);

      /* time */
      do1      = modf(doJD - (double) 0.5, &do2) * (double) 86400;
      *pdoH    = floor(do1 / (double) 3600);
      do1     -= (*pdoH * (double) 3600);
      *pdoMin  = floor(do1 / (double) 60);
      *pdoS    = do1 - (*pdoMin * (double) 60);
      }

   return shReturnValue;
   }

