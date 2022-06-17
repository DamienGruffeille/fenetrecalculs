package com.damien.entites;

/**
 * The type Factorielle.
 */
public class Factorielle {
    /**
     * Gets res.
     *
     * @return the res
     */
    public static int getRes() {
        return res;
    }

    /**
     * Sets res.
     *
     * @param res the res
     */
    public static void setRes(int res) {
        Factorielle.res = res;
    }

    /**
     * The Res.
     */
    static int res;

    /**
     * Calculer int.
     *
     * @param chiffre the chiffre
     * @return the int
     */
    protected static int calculer(int chiffre) {
        res = 1;
        while (chiffre > 0) {
            res = Math.multiplyExact(res,chiffre);
            chiffre -= 1;
        }

        return res;
    }
}
