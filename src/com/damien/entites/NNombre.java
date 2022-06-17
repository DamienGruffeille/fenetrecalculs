package com.damien.entites;

/**
 * The type N nombre.
 */
public class NNombre {

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
        NNombre.res = res;
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
        res = 0;
        int nombre = chiffre;

        for(int i = 1; i <= nombre; i++){
            res = Math.addExact(res,i);
            //res += i;
        }

        return res;
    }


}
