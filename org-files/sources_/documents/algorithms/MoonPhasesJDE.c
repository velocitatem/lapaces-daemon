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
@brief       calculates the moon phase for a given julian date
@author      Christophe DAVID \n
             christophe.david@christophedavid.org \n
             http://www.christophedavid.org
@since       01/07/1999
@version     1.0
@date        05/04/2001
@bug         no known bug

@param double *JulianDay
@param double  year : range [-2000, +6000]
@param int     phase :
- 0 for new moon
- 1 for first quarter
- 2 for full moon
- 3 for last quarter

@return
- 0 : completed successfully
- 1 : error in parameter 1
- 2 : error in parameter 2
- 3 : error in parameter 3

@if logger
@image html http://www.mot.be/cgi-bin/logger.cgi?MoonPhasesJDE.c
@endif
*/

/* see page 349 */

#ifdef ASTROALGO
   #include <math.h>
   #include <stdio.h>
   #include "AstroAlgo.h"

   __declspec(dllexport) short __stdcall
#else
   short
#endif

#define D (double)

ShMoonPhaseJDE(double *pdoResult, double doYear, short shPhase)
   {
   double ado1[25][7] = {  /* page 351 */
               /*  new moon    full moon  E     F     M     M_    O  */
               {D -0.40720, D -0.40614, D 0, D  0, D  0, D  1, D  0},
               {D  0.17241, D  0.17302, D 1, D  0, D  1, D  0, D  0},
               {D  0.01608, D  0.01614, D 0, D  0, D  0, D  2, D  0},
               {D  0.01039, D  0.01043, D 0, D  2, D  0, D  0, D  0},
               {D  0.00739, D  0.00734, D 1, D  0, D -1, D  1, D  0},
               {D -0.00514, D -0.00515, D 1, D  0, D  1, D  1, D  0},
               {D  0.00208, D  0.00209, D 2, D  0, D  2, D  0, D  0},
               {D -0.00111, D -0.00111, D 0, D -2, D  0, D  1, D  0},
               {D -0.00057, D -0.00057, D 0, D  2, D  0, D  1, D  0},
               {D  0.00056, D  0.00056, D 1, D  0, D  1, D  2, D  0},
               {D -0.00042, D -0.00042, D 0, D  0, D  0, D  3, D  0},
               {D  0.00042, D  0.00042, D 1, D  2, D  1, D  0, D  0},
               {D  0.00038, D  0.00038, D 1, D -2, D  1, D  0, D  0},
               {D -0.00024, D -0.00024, D 1, D  0, D -1, D  2, D  0},
               {D -0.00017, D -0.00017, D 0, D  0, D  0, D  0, D  1},
               {D -0.00007, D -0.00007, D 0, D  0, D  2, D  1, D  0},
               {D  0.00004, D  0.00004, D 0, D -2, D  0, D  2, D  0},
               {D  0.00004, D  0.00004, D 0, D  0, D  3, D  0, D  0},
               {D  0.00003, D  0.00003, D 0, D -2, D  1, D  1, D  0},
               {D  0.00003, D  0.00003, D 0, D  2, D  0, D  2, D  0},
               {D -0.00003, D -0.00003, D 0, D  2, D  1, D  1, D  0},
               {D  0.00003, D  0.00003, D 0, D  2, D -1, D  1, D  0},
               {D -0.00002, D -0.00002, D 0, D -2, D -1, D  1, D  0},
               {D -0.00002, D -0.00002, D 0, D  0, D  1, D  3, D  0},
               {D  0.00002, D  0.00002, D 0, D  0, D  0, D  4, D  0}
               }
              ;

   double ado2[25][6] = {  /* page 352 */
               /*             E     F     M     M_    O  */
               {D -0.62801, D 0, D  0, D  0, D  1, D  0},
               {D  0.17172, D 1, D  0, D  1, D  0, D  0},
               {D -0.01183, D 1, D  0, D  1, D  1, D  0},
               {D  0.00862, D 0, D  0, D  0, D  2, D  0},
               {D  0.00804, D 0, D  2, D  0, D  0, D  0},
               {D  0.00454, D 1, D  0, D -1, D  1, D  0},
               {D  0.00204, D 2, D  0, D  2, D  0, D  0},
               {D -0.00180, D 0, D -2, D  0, D  1, D  0},
               {D -0.00070, D 0, D  2, D  0, D  1, D  0},
               {D -0.00040, D 0, D  0, D  0, D  3, D  0},
               {D -0.00034, D 1, D  0, D -1, D  2, D  0},
               {D  0.00032, D 1, D  2, D  1, D  0, D  0},
               {D  0.00032, D 1, D -2, D  1, D  0, D  0},
               {D -0.00028, D 2, D  0, D  2, D  1, D  0},
               {D  0.00027, D 1, D  0, D  1, D  2, D  0},
               {D -0.00017, D 0, D  0, D  0, D  0, D  1},
               {D -0.00005, D 0, D -2, D -1, D  1, D  0},
               {D  0.00004, D 0, D  2, D  0, D  2, D  0},
               {D -0.00004, D 0, D  2, D  1, D  1, D  0},
               {D  0.00004, D 0, D  0, D -2, D  1, D  0},
               {D  0.00003, D 0, D -2, D  1, D  1, D  0},
               {D  0.00003, D 0, D  0, D  3, D  0, D  0},
               {D  0.00002, D 0, D -2, D  0, D  2, D  0},
               {D  0.00002, D 0, D  2, D -1, D  1, D  0},
               {D -0.00002, D 0, D  0, D  1, D  3, D  0}
               }
              ;

   double ado3[14][3] = {    /* page 351 */
                         {D 299.77, D  0.107408, D 0.000325},
                         {D 251.88, D  0.016321, D 0.000165},
                         {D 251.83, D 26.651886, D 0.000164},
                         {D 349.42, D 36.412478, D 0.000126},
                         {D  84.66, D 18.206239, D 0.000110},
                         {D 141.74, D 53.303771, D 0.000062},
                         {D 207.14, D  2.453732, D 0.000060},
                         {D 154.84, D  7.306860, D 0.000056},
                         {D  34.52, D 27.261239, D 0.000047},
                         {D 207.19, D  0.121824, D 0.000042},
                         {D 291.34, D  1.844379, D 0.000040},
                         {D 161.72, D 24.198154, D 0.000037},
                         {D 239.56, D 25.513099, D 0.000035},
                         {D 331.55, D  3.592518, D 0.000024}
                        };

   short  shReturnValue = (short) 0;
   double adoA[14] = {D 0, D 0, D 0, D 0, D 0, D 0, D 0, D 0, D 0, D 0,
                      D 0, D 0, D 0, D 0};
   double doE     = D 0;
   double doF     = D 0;
   double doK     = D 0;
   double doM     = D 0;
   double doM_    = D 0;
   double doO     = D 0;
   double doT     = D 0;
   double doCorr1 = D 0;
   double doCorr2 = D 0;
   double doCorr3 = D 0;

   short  sh1     = (short)  0;
   short  sh2     = (short)  0;
   double do1     = D 0;
   double do2     = D 0;

   if (pdoResult == NULL)
      {
      shReturnValue = (short) 1;
      }
   else if ((doYear < -2000) || (doYear > 6000))
      {
      shReturnValue = (short) 2;
      }
   else if ((shPhase < 0) || (shPhase > 3))
      {
      shReturnValue = (short) 3;
      }
   else
      {
      doK = (doYear - D 2000) * D 12.3685;
      doK = floor(doK) + D (D 0.25 * D shPhase);
      doT = doK / D 1236.85;

      *pdoResult =    D 2451550.09766
                   + (D 29.530588861  * doK)
                   + (D 0.0015437     * doT * doT)
                   + (D 0.000000150   * doT * doT * doT)
                   + (D 0.00000000073 * doT * doT * doT * doT);

      doE  =    D   1
             - (D   0.002516     * doT)
             - (D   0.0000074    * doT * doT);

      doM  =    D   2.5534
             + (D  29.10535670  * doK)
             - (D   0.0000014   * doT * doT)
             - (D   0.00000011  * doT * doT * doT);

      doM_ =    D 201.5643
             + (D 385.81693528  * doK)
             + (D   0.0107582   * doT * doT)
             + (D   0.0000138   * doT * doT * doT)
             - (D   0.000000058 * doT * doT * doT * doT);

      doF  =    D 160.7108
             + (D 390.67050284  * doK)
             - (D   0.0016118   * doT * doT)
             - (D   0.00000227  * doT * doT * doT)
             + (D   0.000000011 * doT * doT * doT * doT);

      doO  =    D 124.7746
             - (D   1.56375588  * doK)
             + (D   0.0020672   * doT * doT)
             + (D   0.00000215  * doT * doT * doT);


      doCorr1 = D 0;
      if ((shPhase == 0) || (shPhase == 2))
         {
         for (sh1 = (short) 0 ; sh1 < 25 ; sh1++)
            {
            do1 = ado1[sh1][shPhase == 0 ? 0 : 1];
            for (sh2 = (short) 0 ; sh2 < ado1[sh1][2] ; sh2++)
               {
               do1 *= doE;
               }
            do2 =  (ado1[sh1][3] * doF);
            do2 += (ado1[sh1][4] * doM);
            do2 += (ado1[sh1][5] * doM_);
            do2 += (ado1[sh1][6] * doO);
            do2 = sin(DEGREES2RADIAN(REDUCE360(do2)));
            doCorr1 += do1 * do2;
            }
         }
      else
         {
         for (sh1 = (short) 0 ; sh1 < 25 ; sh1++)
            {
            do1 = ado2[sh1][0];
            for (sh2 = (short) 0 ; sh2 < ado2[sh1][1] ; sh2++)
               {
               do1 *= doE;
               }
            do2 =  (ado2[sh1][2] * doF);
            do2 += (ado2[sh1][3] * doM);
            do2 += (ado2[sh1][4] * doM_);
            do2 += (ado2[sh1][5] * doO);
            do2 = sin(DEGREES2RADIAN(REDUCE360(do2)));
            doCorr1 += do1 * do2;
            }
         doCorr3 =
                 D 0.00306
              - (D 0.00038 * doE * cos(DEGREES2RADIAN(REDUCE360(doM))))
              + (D 0.00026       * cos(DEGREES2RADIAN(REDUCE360(doM_))))
              - (D 0.00002       * cos(DEGREES2RADIAN(REDUCE360((doM_ - doM)))))
              + (D 0.00002       * cos(DEGREES2RADIAN(REDUCE360((doM_ + doM)))))
              + (D 0.00002       * cos(DEGREES2RADIAN(REDUCE360((D 2 * doF)))));

         if (shPhase == 3)
            {
            doCorr3 *= D -1;
            }
         }

      doCorr2 = D 0;
      for (sh1 = (short) 0 ; sh1 < 14 ; sh1++)
         {
         adoA[sh1] += ado3[sh1][0];
         adoA[sh1] += (ado3[sh1][1] * doK);
         if (sh1 == 0)
            {
            adoA[sh1] -= (D 0.009173 * doT * doT);
            }
         doCorr2 += sin(DEGREES2RADIAN(REDUCE360(adoA[sh1]))) * ado3[sh1][2];
         }

      #if 0
      (void) fprintf(stdout, "\n           doK  = %16f"
                             "\n           doT  = %16f"
                             "\n           doE  = %16f"
                             "\n           doM  = %16f (%10f)"
                             "\n           doM_ = %16f (%10f)"
                             "\n           doF  = %16f (%10f)"
                             "\n           doO  = %16f (%10f)"
                             "\n        doCorr1 = %16f"
                             "\n        doCorr2 = %16f"
                             "\n        doCorr3 = %16f"
                             "\n      pdoResult = %16f"
                             ,
                             doK, doT, doE, doM, REDUCE360(doM),
                             doM_, REDUCE360(doM_), doF, REDUCE360(doF),
                             doO, REDUCE360(doO), doCorr1, doCorr2,
                             doCorr3, *pdoResult);
      #endif

      *pdoResult += doCorr1;
      *pdoResult += doCorr2;
      *pdoResult += doCorr3;
      }
   return shReturnValue;
   }

#undef D


/*
From: Jean Meeus
To:  Christophe David
Subject: phases de la lune
Date: lundi 18 octobre 1999 11:57

Cher Monsieur,

En effet, on numérote parfois les lunaisons, et on utilise alors la
numerotation proposee en 1933 par E. W. Brown ; la lunaison numero 1 est
celle qui a commence le 17,janvier 1923.

L'algorithme que je donne au Chapitre 49 de la 2e edition de mes
"Algorithms" est valable pour quelques dizaines de siecles, disons entre
les annees -2000 et +6000. Mais ne perdez pas de vue que les resultats
obtenus sont en erreur de 4 secondes en moyenne (ce qui tout de meme est
magnifique, vu le nombre relativement restreint de termes periodiques
utilises), et qu'au maximum l'erreur peut atteindre environ 15 secondes,
ainsi qu'il est mentionne a la page 354.

Si l'on veut une precision meilleure, il y a lieu de faire des calculs plus
elabores. Je puis vous donner les instants des phases lunaires a la seconde
pres, en Temps Dynamique, pour quelques annees, par exemple dans les annees
-2000, -1000, 0, 1000, 2000, 3000 et 4000. Est-ce que cela vous interesse?

Bien sincerement.

Jean Meeus
*/

