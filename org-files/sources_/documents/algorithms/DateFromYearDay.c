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
@brief       calculates a date from the day in the year
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double  YearDay
@param short   year
@param double *month
@param double *day

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?DateFromYearDay.c
@endif

*/

/* see page 66 */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShDateFromYearDay(double doYD, short shYear, double *pdoM, double *pdoD)
   {
   short shReturnValue = (short) 0;
   short shIsLeap      = (short) 0;

   if (pdoM != NULL)
      {
      *pdoM = (double) -1;
      }

   if (pdoD != NULL)
      {
      *pdoD = (double) -1;
      }

   if (ShIsLeapYear(&shIsLeap, shYear,
                         (short) (shYear < 1582 ? JULIAN : GREGORIAN)) != 0)
      {
      shReturnValue = (short) 2;
      }

   else if (   (doYD < 0)
            || (doYD > (shIsLeap == 0 ? 365 : 366))
           )
      {
      shReturnValue = (short) 1;
      }

   else if (pdoM == NULL)
      {
      shReturnValue = (short) 3;
      }

   else if (pdoD == NULL)
      {
      shReturnValue = (short) 4;
      }

   else
      {
      if (doYD < 32)
         {
         *pdoM = (double) 1;
         }
      else
         {
         *pdoM = floor(  (   (  (double) 9
                              * (  (double) (shIsLeap == 1 ? 1 : 2)
                                 + doYD
                                )
                             )
                           / (double) 275
                         )
                       + (double) (0.98)
                       );

         }

      *pdoD = (   (  doYD
                   - floor( (  ((double) 275 * (*pdoM))
                             / (double) 9
                            )
                          )
                   )

                +  (  (double) (shIsLeap == 1 ? 1 : 2)
                    * floor(  (*pdoM + (double) 9)
                            / (double) 12
                           )
                   )
                + (double) 30
              );

      }

   return shReturnValue;
   }

