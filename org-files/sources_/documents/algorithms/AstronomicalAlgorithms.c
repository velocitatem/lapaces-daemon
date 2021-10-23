/**************************************************************************
  AstronomicalAlgorithms.c

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
This main source file implements the book examples.  The \#ifdef PAGE_nnn_TEST
directives in AstronomicalAlgorithms.h are used to include/exclude the related
code.

@file
@brief       AstronomicalAlgorithms main source file
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug
@todo        implement the remaining algorithms of the book...
@note
The screen output of this program is quite long.
It is easier to re-direct it to a file and then read this file with an editor
- AstronomicalAlgorithms > aa.txt
- edit aa.txt

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?AstronomicalAlgorithms.c
@endif
*/

#include <stdio.h>
#include <assert.h>
#include <limits.h>
#include <math.h>
#include <time.h>

/****************************************************************************/

#include "AstronomicalAlgorithms.h"

#include "InterpolationDifferences.c"
#include "IsLeapYear.c"
#include "JulianDay.c"
#include "DateFromJulianDay.c"
#include "DayOfWeek.c"
#include "DayOfYear.c"
#include "DateFromYearDay.c"
#include "EasterSunday.c"
#include "RhoSinPhiTwo.c"
#include "RhoCosPhiTwo.c"
#include "MoonPhasesJDE.c"
#include "SolarCoordinates.c"

/****************************************************************************/


int main(int iArgumentsCount, char *aszArguments[], char *aszEnvironment[])
   {
   char       sz1[LO_DEFAULT_WORKSTRING_LENGTH] = {(char) 0};
   int        iReturnValue                      = 0;
   struct tm *ptmTimeNow                        = NULL;
   time_t     ttSecondsNow                      = (time_t) 0;

   if (iArgumentsCount < 1)
      {
      iReturnValue = 1;
      }
   else if (aszArguments == NULL)
      {
      iReturnValue = 2;
      }
   else if (aszEnvironment == NULL)
      {
      iReturnValue = 3;
      }
   else
      {
      (void) fprintf(stdout,
                     "\n%s%s%s\n%s\n%s\n",
                     __FILE__,
                     ", by Christophe DAVID, compiled ",
                     __DATE__,
                     "christophe.david@christophedavid.org",
                     "http://www.christophedavid.org/"
                    );

      ttSecondsNow = time(NULL);
      ptmTimeNow   = localtime(&ttSecondsNow);

      if (strftime(sz1, (size_t) (sizeof(sz1) - (size_t) 1),
                   "\nCurrent local time : %A %B %d, %Y - %H:%M:%S\n\n",
                   ptmTimeNow) == (size_t) 0)
         {
         *sz1 = (char) 0;
         }
      (void) fprintf(stdout, "%s", sz1);

      /**********************************************************************/

      #ifdef PAGE_007_TEST
      (void) fprintf(stdout, "\npage 007 : sine(36000030) = %f\n",
                     sin(DEGREES2RADIAN(36000030)));
      (void) fprintf(stdout, "page 007 : 23d26m49s      = %f degrees\n",
                     DEGMINSEC2DECIMAL(+, 23, 26, 49));
      #endif

      /**********************************************************************/

      #ifdef PAGE_008_TEST
      (void) fprintf(stdout,
                 "\npage 008 : 9h14m55.8s     = %f degrees, tan(alpha) = %f\n",
                     RIGHTASC2DECIMAL(9,14,55.8),
                     tan(DEGREES2RADIAN(RIGHTASC2DECIMAL(9,14,55.8)))
                    );
      #endif

      /**********************************************************************/

      #ifdef PAGE_009_TEST
      (void) fprintf(stdout, "\npage 009 : -13d47m22s     = %f degrees\n",
                     DEGMINSEC2DECIMAL(-, 13,47,22));
      #endif

      /**********************************************************************/

      #ifdef PAGE_013_TEST

      /* swap trick given in the book */
      if (1)                                             /*lint !e506 !e774 */
         {
         double doX = do_pi;
         double doY = do_e;
         (void) fprintf(stdout,
                        "\npage 013 : before swap : X = %.20f, Y = %.20f\n",
                         doX, doY);

         doX = doX + doY;
         doY = doX - doY;
         doX = doX - doY;
         (void) fprintf(stdout,
                        "page 013 : after  swap : Y = %.20f, X = %.20f\n",
                        doY, doX);
         }

      /* this is pure intellectual curiosity here, but could be useful to swap
         large arrays (strings, matrices, etc.) */

      if (1)                                             /*lint !e506 !e774 */
         {
         size_t         st1   = (size_t) 0;
         unsigned char *puchX = NULL;
         unsigned char *puchY = NULL;

         double doX = do_pi;
         double doY = do_e;

         (void) fprintf(stdout,
                        "\npage 013 : before swap : X = %.20f, Y = %.20f\n",
                        doX, doY);

         puchX = (unsigned char *) &doX;
         puchY = (unsigned char *) &doY;

         for (st1 = (size_t) 0 ; st1 < sizeof(doX) ; st1++)
            {
            *puchX = *puchX ^ *puchY;
            *puchY = *puchY ^ *puchX;
            *puchX = *puchX ^ *puchY;
            puchX++;
            puchY++;
            }
         (void) fprintf(stdout,
                        "page 013 : after  swap : Y = %.20f, X = %.20f\n",
                        doY, doX);
         }

      if (1)                                           /*lint !e506 !e774 */
         {
         size_t         st1   = (size_t) 0;
         unsigned char *puchX = NULL;
         unsigned char *puchY = NULL;

         char szX[] = "0123456789abcd";
         char szY[] = "ABCDEFGHIJKLMN";

         (void) fprintf(stdout,
                        "\npage 013 : before swap : X = %s, Y = %s\n",
                        szX, szY);

         puchX = (unsigned char *) szX;
         puchY = (unsigned char *) szY;

         for (st1 = (size_t) 0 ; st1 < sizeof(szX) ; st1++)
            {
            *puchX = *puchX ^ *puchY;
            *puchY = *puchY ^ *puchX;
            *puchX = *puchX ^ *puchY;
            puchX++;
            puchY++;
            }
         (void) fprintf(stdout,
                        "page 013 : after  swap : Y = %s, X = %s\n", szY, szX);
         }

      #endif

      /**********************************************************************/

      #ifdef PAGE_017_TEST

      if (1)                                             /*lint !e506 !e774 */
         {
         float flX = (float) 1;
         long  loJ = (long) 0;

         (void) fprintf(stdout, "%s", "\n");

         while (1)                                      /*lint !e506 !e716 */
            {
            flX = flX * (float) 2;

            if (flX + (float) 1 == flX)                       /*lint !e777 */
               {
               break;
               }
            loJ += (long) 1;
            }

         (void) fprintf(stdout,
                        "page 017 : float  : J = %ld, J * 0.30103 = %f\n",
                        loJ, (double) ((float)((float) loJ * (float) 0.30103)));
         }

      if (1)                                             /*lint !e506 !e774 */
         {
         double doX = (double) 1;
         long  loJ = (long) 0;

         while (1)                                       /*lint !e506 !e716 */
            {
            doX = doX * (double) 2;

            if (doX + (double) 1 == doX)                       /*lint !e777 */
               {
               break;
               }
            loJ += (long) 1;
            }

         (void) fprintf(stdout,
                        "page 017 : double : J = %ld, J * 0.30103 = %f\n",
                        loJ, (double)((double) loJ * (double) 0.30103));
         }
      #endif

      /**********************************************************************/

      #ifdef PAGE_018_TEST

      (void) fprintf(stdout,
                     "\npage 018 : 4 * atan(1) = %21.20f\n"
                     "           PI          = 3.14159265358979323846\n\n"
                     ,
                     (double) ((double) 4 * atan((double) 1)));


      if (1)                                            /*lint !e506 !e774 */
         {
         double doX = (double) ((double) 1 / (double) 3);
         long   loJ = (long) 0;

         for (loJ = (long) 1 ; loJ <= 30 ; loJ++)
            {
            doX = ((((double) 9 * doX) + (double) 1) * doX) - (double) 1;
            (void) fprintf(stdout,
                           "page 018 : %2ld %21.20f\n",
                           loJ, doX);

            }
         }

      if (1)                                            /*lint !e506 !e774 */
         {
         double doX = (double) 1.0000001;
         long   loJ = (long) 0;


         for (loJ = (long) 1 ; loJ <= 27 ; loJ++)
            {
            doX *= doX;
            }

         (void) fprintf(stdout,
               "\npage 018 : 27 iterations of 1.0000001 ^ 2 give %.4f\n",
                        doX);
         }

      #endif

      /**********************************************************************/

      #ifdef PAGE_019_TEST

      (void) fprintf(stdout,
                     "\npage 019 : floor(100 * (4.34 - floor(4.34))) = %.3f\n",
                     floor(100 * ((double) 4.34 - floor((double) 4.34)))
                    );

      (void) fprintf(stdout,
                     "\npage 019 : 2 + 0.2 + 0.2 + 0.2 + 0.2 + 0.2 - 3 = %e\n",
                     ((double) 2 + (double) 0.2 + (double) 0.2 + (double) 0.2
                      + (double) 0.2 + (double) 0.2 - (double) 3)
                    );

      (void) fprintf(stdout,
                     "\npage 019 : 0.2 + 0.2 + 0.2 + 0.2 + 0.2 + 2 - 3 = %e\n",
                     ((double) 0.2 + (double) 0.2 + (double) 0.2 + (double) 0.2
                      + (double) 0.2 + (double) 2 - (double) 3)
                    );

      (void) fprintf(stdout,
                     "\npage 019 : 2 + (5 * 0.2) - 3  = %e\n",
                     (double) 2 + ((double) 5 * (double) 0.2) - (double) 3
                    );


      if (1)                                            /*lint !e506 !e774 */
         {
         double doA = (double) 0;
         double doB = (double) 0;
         double doC = (double) 0;

         doA =    (double) 0.2
                + (double) 0.2 + (double) 0.2 + (double) 0.2 + (double) 0.2;
         doB = (double) 2 + doA;
         doC = doB - (double) 3;
         (void) fprintf(stdout, "\npage 019 : C = %e\n", doC);
         }

      if (1)                                            /*lint !e506 !e774 */
         {
         double doI = (double) 0;
         double doU = (double) 0;

         for (doI = (double) 0 ; doI < 100 ; doI += (double) 0.1)
            {
            doU = doI;
            }
         (void) fprintf(stdout, "\npage 019 : U = %.20f\n", doU);

         }
      #endif

      /**********************************************************************/

      #ifdef PAGE_020_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         double doI = (double) 0;
         double doJ = (double) 0;
         double doU = (double) 0;

         for (doJ = (double) 0 ; doI < 1000 ; doJ ++)
            {
            doI = doJ / (double) 10;
            doU = doI;
            }
         (void) fprintf(stdout, "\npage 020 : U = %.20f\n", doU);
         }

      (void) fprintf(stdout,
                     "\npage 020 : 3 * (1/3) = %f\n",
                     (double) 3 * ((double) 1 / (double) 3)
                    );


      if (1)                                            /*lint !e506 !e774 */
         {
         double doA = (double) 0.1;

         (void) fprintf(stdout, "\npage 020 : floor(1000 * 0.1) = %.20f\n",
                        (floor((double) 1000 * doA)));
         }



      (void) fprintf(stdout, "\npage 020 : LONG_MAX = %ld\n", LONG_MAX);


      (void) fprintf(stdout,
                     "\npage 020 : sqrt(25) - 5 = %f\n",
                     sqrt((double) 25) - floor(sqrt((double) 25))
                    );

      #endif

      /**********************************************************************/

      #ifdef PAGE_021_TEST

      (void) fprintf(stdout, "\npage 021 : ROUND(pi) = %f\n", ROUND(do_pi));
      (void) fprintf(stdout, "\npage 021 : ROUND(e)  = %f\n", ROUND(do_e));

      #endif

      /**********************************************************************/

      #ifdef PAGE_024_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         double adoTableValues[5]  = {(double) 0.898013,
                                      (double) 0.891109,
                                      (double) 0.884226,
                                      (double) 0.877366,
                                      (double) 0.870531
                                     };

         double adoDifferences[5]  = {(double) 0};  /*lint !e785 */
         short shTemp1             = (short) 0;
         short shTemp2             = (short) 0;

         for (shTemp1 = (short) 1 ; shTemp1 <= 3 ; shTemp1++)
            {
            shTemp2 = ShInterpolationDifferences(adoTableValues,
                                                 (short) 5,
                                                 adoDifferences,
                                                 sizeof(adoDifferences),
                                                 shTemp1
                                                );
            if (shTemp2 != 0)
               {
               (void) fprintf(stdout, "\npage 024 : shTemp2 = %hd\n", shTemp2);
               }
            else
               {
               (void) fprintf(stdout,
                     "\npage 024 : differences %hd: %10f %10f %10f %10f %10f",
                              shTemp1,
                              adoDifferences[0],
                              adoDifferences[1],
                              adoDifferences[2],
                              adoDifferences[3],
                              adoDifferences[4]
                             );
               }
            }
         (void) fprintf(stdout, "%s", "\n");
         }
      #endif


      /**********************************************************************/

      #ifdef PAGE_061_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         double doJD = (double) 0;
         short  sh1  = (short)  0;

         sh1 = ShJulianDay(&doJD,
                          (double) 1957, (double) 10, (double) 4.81, (short) 1);
         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 059 : JD 7.a = %.2f\n", doJD);
            }
         else
            {
            (void) fprintf(stdout, "\npage 059 : ShJulianDay returns %hd\n",
                           sh1);
            }

         sh1 = ShJulianDay(&doJD,
                          (double) 333, (double) 1, (double) 27.5, (short) 0);

         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 061 : JD 7.b = %.2f\n", doJD);
            }
         else
            {
            (void) fprintf(stdout, "\npage 061 : ShJulianDay returns %hd\n",
                           sh1);
            }
         }

      #endif

      /**********************************************************************/

      #ifdef PAGE_062_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         short  sh1  = (short)  0;
         short  sh2  = (short)  0;
         short  sh3  = (short)  0;

         double ado1[16][5] = { { 2000,  1,  1.5,   0, 2451545.0},
                                { 1999,  1,  1  ,   0, 2451179.5},
                                { 1987,  1, 27  ,   0, 2446822.5},
                                { 1987,  6, 19.5,   0, 2446966.0},
                                { 1988,  1, 27  ,   0, 2447187.5},
                                { 1988,  6, 19.5,   0, 2447332.0},
                                { 1900,  1,  1  ,   0, 2415020.5},
                                { 1600,  1,  1  ,   0, 2305447.5},
                                { 1600, 12, 31  ,   0, 2305812.5},
                                {  837,  4, 10.3,   0, 2026871.8},
                                { -123, 12, 31  ,   0, 1676496.5},
                                { -122,  1,  1  ,   0, 1676497.5},
                                {-1000,  7, 12.5,   0, 1356001.0},
                                {-1000,  2, 29  ,   0, 1355866.5},
                                {-1001,  8, 17.9,   0, 1355671.4},
                                {-4712,  1,  1.5,   0,       0.0}
                             };

         for (sh1 = (short) 0 ; sh1 < 16 ; sh1++)
            {
            sh2 = ShJulianDay(&(ado1[sh1][3]),
                                ado1[sh1][0],
                                ado1[sh1][1],
                                ado1[sh1][2],
                                (short) (ado1[sh1][0] < 1582 ?
                                         JULIAN : GREGORIAN)
                             );
            if (sh2 == 0)
               {
               (void) fprintf(stdout,
                              "\npage 062 : %10.2f %10.2f %10.2f %12.2f %5.2f",
                              ado1[sh1][0],
                              ado1[sh1][1],
                              ado1[sh1][2],
                              ado1[sh1][3],
                              ado1[sh1][4] - ado1[sh1][3]
                             );
               }
            else
               {
               (void) fprintf(stdout, "\npage 062 : ShJulianDay returns %hd\n",
                              sh2);
               }
            }
         (void) fprintf(stdout, "%s", "\n");

         /*********************/

         sh1 = (short) 2000;
         sh2 = ShIsLeapYear(&sh3, sh1, (short) GREGORIAN);
         (void) fprintf(stdout,
                        "\npage 062 : ShIsLeapYear(%hd) returns"
                        " %hd and result is %hd\n"
                        ,
                        sh1, sh2, sh3);
         }
      #endif

      /**********************************************************************/

      #ifdef PAGE_063_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         double adoJD[3] = {(double) 2436116.31,
                            (double) 1842713.0,
                            (double) 1507900.13
                           };

         short  sh1  = (short )          0;
         short  sh2  = (short )          0;

         for (sh1 = (short) 0 ; sh1 < 3 ; sh1++)
            {
            double doY  = (double) 0;
            double doM  = (double) 0;
            double doD  = (double) 0;
            double doH  = (double) 0;
            double dom  = (double) 0;
            double doS  = (double) 0;

            sh2 = ShDateFromJulianDay(adoJD[sh1], &doY, &doM, &doD,
                                                  &doH, &dom, &doS);
            if (sh2 == 0)
               {
               (void) fprintf(stdout, "\npage 064 : D=%5.2f, M=%2.0f, Y=%2.0f",
                              doD, doM, doY);
               }
            else
               {
               (void) fprintf(stdout,
                              "\npage 064 : ShDateFromJulianDay returns %hd",
                              sh2);
               }
            }
         (void) fprintf(stdout, "%s", "\n");
         }

      #endif

      /**********************************************************************/

      #ifdef PAGE_064_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         double doJD1 = (double) 0;
         double doJD2 = (double) 0;

         if (  (ShJulianDay(&doJD1,
                           (double) 1910, (double) 4, (double) 20,
                           (short) GREGORIAN) == 0
               )

             && (ShJulianDay(&doJD2,
                           (double) 1986, (double) 2, (double) 9,
                           (short) GREGORIAN) == 0
                )
            )

            {
            (void) fprintf(stdout,
                           "\npage 064 : ex. 7.d = %.0f",
                           doJD1 - doJD2);
            }


         if (ShJulianDay(&doJD1,
                           (double) 1991, (double) 7, (double) 11,
                           (short) GREGORIAN) == 0)
             {
             double doY  = (double) 0;
             double doM  = (double) 0;
             double doD  = (double) 0;
             double doH  = (double) 0;
             double dom  = (double) 0;
             double doS  = (double) 0;

             if (ShDateFromJulianDay(doJD1 + (double) 10000,
                                     &doY, &doM, &doD,
                                     &doH, &dom, &doS) == 0)
                {
                (void) fprintf(stdout,
                               "\npage 064 : D=%5.2f, M=%2.0f, Y=%2.0f\n",
                               doD, doM, doY);
                }
             }
         }
      #endif

      /**********************************************************************/

      #ifdef PAGE_065_TEST

      if (1)                                            /*lint !e506 !e774 */
         {
         short sh1   = (short) 0;
         short shDOW = (short) 0;

         sh1 = ShDayOfWeek(&shDOW, (double) 1954, (double) 6, (double) 30);

         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 065 : shDOW = %hd", shDOW);
            }
         else
            {
            (void) fprintf(stdout,
                           "\npage 065 : ShDayOfWeek returns %hd",
                           sh1);
            }
         }

      if (1)                                            /*lint !e506 !e774 */
         {
         short sh1   = (short) 0;
         short shDOY = (short) 0;

         sh1 = ShDayOfYear(&shDOY, (double) 1988, (double) 4, (double) 22);

         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 065 : ex. 7.g = %hd", shDOY);
            }
         else
            {
            (void) fprintf(stdout,
                           "\npage 065 : ShDayOfyear returns %hd",
                           sh1);
            }
         (void) fprintf(stdout, "%s", "\n");
         }
      #endif

      /**********************************************************************/
      #ifdef PAGE_066_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         short  sh1  = (short)  0;
         double doM  = (double) 0;
         double doD  = (double) 0;

         sh1 = ShDateFromYearDay((double) 113, (short) 1988, &doM, &doD);
         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 066 : D = %2.0f, M = %2.0f",
                           doD, doM);
            }
         else
            {
            (void) fprintf(stdout,
                           "\npage 066 : ShDateFromYearDay returns %hd",
                           sh1);
            }
         (void) fprintf(stdout, "%s", "\n");
         }
      #endif
      /**********************************************************************/

      #ifdef PAGE_067_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         short sh1    = (short)  0;
         short shYear = (short)  0;
         short shM    = (short) 0;
         short shD    = (short) 0;

         (void) fprintf(stdout, "%s", "\npage 067 : \n");
         for (shYear = (short) 1583 ; shYear <= 2303 ; shYear++)
            {
            sh1 = ShEasterSunday(shYear, &shM, &shD, GREGORIAN, CHRISTIAN);
            if (sh1 == 0)
               {
               (void) fprintf(stdout, "%04hd/%02hd/%02hd ", shYear, shM, shD);
               }
            else
               {
               (void) fprintf(stdout,
                              "\npage 067 : ShDateFromYearDay returns %hd",
                              sh1);
               }
            if (shYear % 7 == 0)
               {
               (void) fprintf(stdout, "%s", "\n");
               }
            }
         (void) fprintf(stdout, "%s", "\n");
         }
      #endif
      /**********************************************************************/

      #ifdef PAGE_082_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         double doTemp01 = DEGMINSEC2DECIMAL(+, 33, 21, 22);

         double b = (double)(  DO_EARTH_EQUATORIAL_RADIUS
                             * ((double) 1 - DO_EARTH_FLATTENING));
         (void) fprintf(stdout, "\npage 082 : b   = %8.3f", b);
         (void) fprintf(stdout, "\npage 082 : b/a = %10.8f",
                                (double)( b / DO_EARTH_EQUATORIAL_RADIUS));
         (void) fprintf(stdout, "\npage 082 : 1-f = %10.8f",
                                (double) (1 - DO_EARTH_FLATTENING));
         (void) fprintf(stdout, "\npage 082 : e   = %10.8f",
                                (double)

                                sqrt(   ((double) 2 * DO_EARTH_FLATTENING)
                                     -  (  DO_EARTH_FLATTENING
                                         * DO_EARTH_FLATTENING)));

         (void) fprintf(stdout, "\npage 082 : ex. 11.a phi          = %8.6f",
                                doTemp01);
         (void) fprintf(stdout, "\npage 082 :          RhoSinPhiTwo = %9.6f",
                                   DoRhoSinPhiTwo(doTemp01, (double) 1706));
         (void) fprintf(stdout, "\npage 082 :          RhoCosPhiTwo = %9.6f",
                                   DoRhoCosPhiTwo(doTemp01, (double) 1706));

         }
      #endif
      /**********************************************************************/
      #ifdef PAGE_165_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         short sh1 = (short) 0;

         double doJD     = (double) 2448908.5;
         double doalpha  = (double)       0;
         double dodelta  = (double)       0;
         short  shMethod = (short)        1;

         sh1 = ShSolarCoordinates(doJD, &doalpha, &dodelta, shMethod);
         if (sh1 != 0)
            {
            (void) fprintf(stdout,
                       "\npage 165 : ShSolarCoordinates() returns %hd",
                           sh1);
            }
         else
            {
            (void) fprintf(stdout,
                           "\npage 165 : doalpha = %f, dodelta = %f",
                           doalpha, dodelta);
            }
         }
      #endif
      /**********************************************************************/
      #ifdef PAGE_169_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         }
      #endif
      /**********************************************************************/
      #ifdef PAGE_353_TEST
      if (1)                                            /*lint !e506 !e774 */
         {
         short  sh1   = (short)  0;
         double doJDE = (double) 0;

         sh1 = ShMoonPhaseJDE(&doJDE, (double) 1977.13, (short) 0);
         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 353 : ex. 49.a JDE = %13.5f", doJDE);
            }
         else
            {
            (void) fprintf(stdout,
                   "\npage 353 : ex. 49.a ShMoonPhaseJDE returns %hd", sh1);
            }

         sh1 = ShMoonPhaseJDE(&doJDE, (double) 2044, (short) 3);
         if (sh1 == 0)
            {
            (void) fprintf(stdout, "\npage 353 : ex. 49.b JDE = %13.5f", doJDE);
            }
         else
            {
            (void) fprintf(stdout,
                   "\npage 353 : ex. 49.b ShMoonPhaseJDE returns %hd", sh1);
            }
         }

      if (1)                                            /*lint !e506 !e774 */
         {
         short  sh1                = (short)   0;
         short  sh2                = (short)   0;
         double doJDE              = (double)  0;
         double doY                = (double)  0;
         double doYear             = (double)  0;
         double doMonth            = (double)  0;
         double doDay              = (double)  0;
         double doHour             = (double)  0;
         double doMin              = (double)  0;
         double doSec              = (double)  0;
         double doPreviousNew[2]   = {(double) 0, (double) 0};
         unsigned long uloLunation = (unsigned long) 0;

         (void) fprintf(stdout, "\n\n%s\n",
                  "Lunation              New Moon                            First Quarter                          Full Moon                            Last Quarter              Lunation Duration");
         (void) fprintf(stdout, "%s\n",
                  "-------- ------------------------------------  ------------------------------------  ------------------------------------  ------------------------------------  -----------------");

         doY = (double) 1920;             /* min -2000 */
         while (doY < (double) 2020)      /* max +6000 */
            {
            if (uloLunation > 0)
               {
               (void) fprintf(stdout, "%05ld : " , uloLunation);
               uloLunation++;
               }
            else
               {
               (void) fprintf(stdout, "%8s", "");
               }
            for (sh1 = (short) 0 ; sh1 < 4 ; sh1++)
               {
               sh2 = ShMoonPhaseJDE(&doJDE, doY, sh1);
               if (sh2 != 0)
                  {
                  break;
                  }
               else
                  {
                  if (sh1 == 0)
                     {
                     doPreviousNew[0] = doPreviousNew[1];
                     doPreviousNew[1] = doJDE;
                     if (floor(doJDE) == 2423407)
                        {
                        uloLunation = (unsigned long) 1;
                        }
                     }
                  sh2 = ShDateFromJulianDay(doJDE, &doYear, &doMonth, &doDay,
                                                   &doHour, &doMin,   &doSec);
                  if (sh2 != 0)
                     {
                     break;
                     }
                  else
                     {
                     (void) fprintf(stdout,
                                   "%04.0f/%02.0f/%02.0f"
                                   " %02.0f:%02.0f:%02.0f (%14f)  "
                                   ,
                                   doYear, doMonth, doDay, doHour,
                                   doMin, doSec, doJDE);
                     }
                  }
               }
            (void) fprintf(stdout, "%9f\n",
                           (double) (doPreviousNew[0] > 0 ?
                                     (doPreviousNew[1] - doPreviousNew[0])
                                     : 0));

            doY += ((double) 29.530589 / (double) 365.25);
            }
         (void) fprintf(stdout, "%s", "\n");
         }
      }
   #endif

   return iReturnValue;
   }

/****************************************************************************/


/* eod of file */
