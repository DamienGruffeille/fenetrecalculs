package com.damien.entites;

/**
 * The type Carre.
 */
public class Carre {
    /**
     * Gets res.
     *
     * @return the res
     */
    public static double getRes() {
        return res;
    }

    /**
     * Sets res.
     *
     * @param res the res
     */
    public static void setRes(double res) {
        Carre.res = res;
    }

    /**
     * The Res.
     */
    static double res;

    /**
     * Calculer double.
     *
     * @param chiffre the chiffre
     * @return the double
     */
    protected static double calculer(int chiffre) {
        res = 0;
        res = Math.pow(chiffre,2);

        return res;
    }
}
