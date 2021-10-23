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
@brief       conversion
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double Phi
@param double Height

@return
converted value

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?RhoCosPhiTwo.c
@endif
*/

/* see page 82 */

double DoRhoCosPhiTwo(double doPhi, double doHeight)
   {
   double doReturnValue = (double) 0;

   double doU =  atan((((double) 1 - DO_EARTH_FLATTENING)
                       * tan(DEGREES2RADIAN(doPhi))));

   #if 0
   (void) fprintf(stdout, "\n%s line %ld doU = %8.6f", __FILE__, __LINE__,
                  RADIAN2DEGREES(doU));
   #endif

   doReturnValue = (   cos(doU)
                    +  (  (  doHeight
                           / (double) DO_EARTH_EQUATORIAL_RADIUS
                          )
                        * cos(doU)
                       )
                    );

   return doReturnValue;
   }

