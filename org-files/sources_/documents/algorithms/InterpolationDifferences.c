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
@brief       calculates Interpolation Differences
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double *TableValues
@param short   NumberOfTableValues
@param double *Differences
@param size_t  SizeOfDifferences
@param short   DifferenceRank

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3
- 4 : error in parameter 4
- 5 : error in parameter 5

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?InterpolationDifferences.c
@endif
*/

/* see page 23 */

short ShInterpolationDifferences(double * padoTableValues,
                                 short shNumberOfTableValues,
                                 double * padoDifferences,
                                 size_t stSizeOfpadoDifferences,
                                 short shDifferenceRank)
   {
   short shReturnValue = (short) 0;
   short sh1           = (short) 0;
   short sh2           = (short) 0;

   if (padoTableValues == NULL)
      {
      shReturnValue = (short) 1;
      }

   else if (shNumberOfTableValues < 3)
      {
      shReturnValue = (short) 2;
      }

   else if (padoDifferences == NULL)
      {
      shReturnValue = (short) 3;
      }

   else if (stSizeOfpadoDifferences <
             (size_t) ((long) shNumberOfTableValues * (long) sizeof(double))
           )
      {
      shReturnValue = (short) 4;
      }

   else if ((shDifferenceRank < 1) || (shDifferenceRank > 3))
      {
      shReturnValue = (short) 5;
      }

   else
      {
      for (sh1 = (short) 0 ; sh1 < shNumberOfTableValues ; sh1++)
         {
         padoDifferences[sh1] = padoTableValues[sh1];
         }

      for (sh1 = (short) 1 ; sh1 <= shDifferenceRank ; sh1++)
         {
         for (sh2 = (short) 0 ; sh2 < shNumberOfTableValues ; sh2++)
            {
            if (sh2 >= shNumberOfTableValues - sh1)
               {
               padoDifferences[sh2] = (double) 0;
               }
            else
               {
               padoDifferences[sh2] =   padoDifferences[sh2 + 1]
                                      - padoDifferences[sh2];
               }
            }
         }
      }

   return shReturnValue;
   }

