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
@brief       calculates if a year is leap or not
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param short *result
@param short  year,
@param short  calendar : 0 for julian, 1 for gregorian

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 3 : error in parameter 3

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?IsLeapYear.c
@endif
*/

/* see page 62 */

#ifdef ASTROALGO
   #include <assert.h>
   #include <stdio.h>
   #include "AstroAlgo.h"
   __declspec(dllexport) short __stdcall
#else
   short
#endif

ShIsLeapYear(short *pshResult, short shYear, short shCalendar)
                  /* shCalendar JULIAN for julian, GREGORIAN for gregorian */
   {
   short shReturnValue = (short) 0;

   if (pshResult != NULL)
      {
      *pshResult = (short) -1;
      }

   if (pshResult == NULL)
      {
      shReturnValue = (short) 1;
      }

   else if (   (shCalendar != (short) JULIAN)
            && (shCalendar != (short) GREGORIAN)
          )
      {
      shReturnValue = (short) 3;
      }

   else if (shCalendar == (short) JULIAN)
         {
         if ((shYear % (short) 4) == 0)
            {
            *pshResult = (short) 1;
            }
         else
            {
            *pshResult = (short) 0;
            }
         }

   else
         {
         assert(shCalendar == (short) GREGORIAN);
         if (   ((shYear % (short) 4) == 0)
             && (   ((shYear % (short) 100) != 0)
                 || ((shYear % (short) 400) == 0)
                )
            )
            {
            *pshResult = (short) 1;
            }
         else
            {
            *pshResult = (short) 0;
            }
         }

   return shReturnValue;
   }

