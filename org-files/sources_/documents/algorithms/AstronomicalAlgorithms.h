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
@mainpage ASTRONOMICAL ALGORITHMS
- <b>see http://www.christophedavid.org for details</b>
- email : christophe.david@christophedavid.org
*/


/*!
@file
@brief       AstronomicalAlgorithms header file
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug
@remarks
The screen output of this program is quite long.
It is easier to re-direct it to a file and then read this file with an editor
- AstronomicalAlgorithms > aa.txt
- edit aa.txt

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?AstronomicalAlgorithms.h
@endif
*/


#ifndef ASTRONOMICAL_ALGORITHMS_H
   #define ASTRONOMICAL_ALGORITHMS_H

/****************************************************************************/

#define PAGE_007_TEST
#define PAGE_008_TEST
#define PAGE_009_TEST
#define PAGE_013_TEST
#define PAGE_017_TEST
#define PAGE_018_TEST
#define PAGE_019_TEST
#define PAGE_020_TEST
#define PAGE_021_TEST
#define PAGE_024_TEST
#define PAGE_061_TEST
#define PAGE_062_TEST
#define PAGE_063_TEST
#define PAGE_064_TEST
#define PAGE_065_TEST
#define PAGE_066_TEST
#define PAGE_067_TEST
#define PAGE_082_TEST
#define PAGE_165_TEST
#define PAGE_169_TEST
#define PAGE_353_TEST

/****************************************************************************/

#define do_e              (double)  2.71828182845904523536          /* p. 407 */
#define do_pi             (double)  3.14159265358979323846          /* p. 407 */
#define DEGREES2RADIAN(x) ((double) x * (double) 0.017453292519943) /* p. 407 */
#define RADIAN2DEGREES(x) ((double) x * (double) 57.295779513082)   /* p. 407 */

/****************************************************************************/

/* degrees, minutes, seconds to decimal degrees */
/* p009 */
#define DEGMINSEC2DECIMAL(sign, d, m, s) \
(((double) sign d) + (((double) sign m) / (double) 60) \
+ (((double) sign s) / (double) 3600))

/* p008 */
#define RIGHTASC2DECIMAL(d, m, s) ((double) 15 * DEGMINSEC2DECIMAL(+, d, m, s))

/* p021 */
#define ROUND(x) \
((double) x - floor((double) x) < (double) 0.5 ? floor(x) : ceil(x))

/****************************************************************************/

#define REDUCE360(x)  \
	(x >= 0 ? fmod(x, (double) 360) : (double) 360 + fmod(x, (double) 360))

/****************************************************************************/

/* geocentric rectangular coordinates of an observer */

/* p082 */
#define DO_EARTH_EQUATORIAL_RADIUS (double) 6378140 /* meters */           /*a*/
#define DO_EARTH_FLATTENING        (double) ((double) 1 / (double) 298.257)/*f*/

/****************************************************************************/

#define DO_JULIAN_CENTURIES(x) \
        (((double) x - (double) 2451545 ) / (double) 36525)   /* p163 */

/****************************************************************************/

#define LO_DEFAULT_WORKSTRING_LENGTH 512

#define JULIAN    0
#define GREGORIAN 1

#define CHRISTIAN 1

/****************************************************************************/

#endif

/* eod of file */
