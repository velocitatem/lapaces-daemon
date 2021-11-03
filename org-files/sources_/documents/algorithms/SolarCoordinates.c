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
@brief       calculates the solar coordinates
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug
@todo        implement "higher accuracy" algorithm

@param double  JulianDay
@param double *alpha
@param double *delta
@param short   method

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?SolarCoordinates.c
@endif
*/

/* see page 163 */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShSolarCoordinates(double doJD, double *pdoalpha, double *pdodelta,
                   short shMethod)
           /* method = 1 : "low accuracy",    p.163
              method = 2 : "higher accuracy", p.166 */

   {
   short  shReturnValue = (short) 0;

   if (pdoalpha != NULL)
      {
      *pdoalpha = (double) 0;
      }

   if (pdodelta != NULL)
      {
      *pdodelta = (double) 0;
      }

   if (   ((shMethod == 1) && (doJD < 0) || (doJD > 9999999))
       || ((shMethod == 2) && (doJD < 0) || (doJD > 9999999))
      )
      {
      shReturnValue = (short) 1;
      }

   else if (pdoalpha == NULL)
      {
      shReturnValue = (short) 2;
      }

   else if (pdodelta == NULL)
      {
      shReturnValue = (short) 3;
      }

   else if ((shMethod != 1) && (shMethod != 2))
      {
      shReturnValue = (short) 4;
      }

   else if (shMethod == 1)
      {
      double doT     = (double) 0; /* Julian Centuries */
      double doLo    = (double) 0; /* geometric mean longitude of the sun */
      double doM     = (double) 0; /* mean anomaly */
      double doC     = (double) 0; /* Sun's equation of center */
      double doLong  = (double) 0; /* true longitude of the sun */
      double doomega = (double) 0; /* nutation */
      double dolamda = (double) 0; /* apparent longitude of the sun */
      double doe     = (double) 0; /* mean obliquity of the ecliptic */

      /* Julian Centuries */
      doT = DO_JULIAN_CENTURIES(doJD);
      #ifdef DEBUG_SHSOLAR_COORDINATES
      (void) fprintf(stdout, "doT = %f\n", doT);
      #endif

      /* geometric mean longitude of the sun */
      doLo =     (double)   280.46646
              + ((double) 36000.76983   * doT)
              + ((double)     0.0003032 * doT * doT);

      /* mean anomaly of the sun */
      doM =     (double)   357.52911
             + ((double) 35999.05029    * doT)
             - ((double)     0.0001537  * doT * doT);

      /* Sun's equation of center */
      doC =    (  (    (double) 1.914602
                    - ((double) 0.004817 * doT)
                    - ((double) 0.000014 * doT * doT)
                  )
                * sin(DEGREES2RADIAN(doM))
               )
            +  (  (    (double) 0.019993
                    - ((double) 0.000101 * doT)
                  )
                * sin(DEGREES2RADIAN((2 * doM)))
               )
            + ((double) 0.000289 * sin(DEGREES2RADIAN((3 * doM))));

      /* Sun's true longitude */
      doLong = doLo + doC;

      doomega = (double) 125.04 - ((double) 1934.136 * doT);

      /* apparent longitude of the sun */
      dolamda = REDUCE360(  doLong
                          -  (double) 0.00569
                          - ((double) 0.00478 * sin(DEGREES2RADIAN(doomega)))
                         );

      /* mean obliquity of the ecliptic */
      doe =   (((double) 23 * (double) 3600) + ((double) 26 * (double) 60))
            +  (double) 21.448
            - ((double) 46.8150  * doT)
            - ((double) 0.00059  * doT * doT)
            + ((double) 0.001813 * doT * doT * doT);
      doe /= (double) 3600;

      /* correct mean obliquity of the ecliptic */
      doe = doe + (double) 0.00256 * cos(DEGREES2RADIAN(doomega));

      /* calculate right ascension and declination */
      *pdoalpha = REDUCE360(RADIAN2DEGREES(atan2(cos(DEGREES2RADIAN((doe)))
                                           * sin(DEGREES2RADIAN(dolamda)),
                                           cos(DEGREES2RADIAN(dolamda)))));
      *pdodelta = RADIAN2DEGREES( asin(  sin(DEGREES2RADIAN(doe))
                                       * sin(DEGREES2RADIAN(dolamda)))
                                );
      }

   else if (shMethod == 2)
      {
      ;
      }

   return shReturnValue;
   }

