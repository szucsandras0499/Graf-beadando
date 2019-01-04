package hu.petrik.graffeladat;

/**
 * A gráf egy éle, és a hozzá tartozó adatok.
 */
class El {
    /**
     * Az egyik csúcs indexe
     */
    private int elsocsucs;
    /**
     * A másik csúcs indexe
     */
    private int masodikcsucs;
    private int suly;

    /**
     * Létrehoz egy úgy élt.
     * 
     * @param elsocsucs Az egyik csúcs indexe
     * @param masodikcsucs A másik csúcs indexe
     */
    public El(int elsocsucs, int masodikcsucs, int suly) {
        this.elsocsucs = elsocsucs;
        this.masodikcsucs = masodikcsucs;
        this. suly = suly;
    }

    /**
     * @return Az egyik csúcs indexe
     */
    public int getElsocsucs() {
        return elsocsucs;
    }

    /**
     * @return A másik csúcs indexe
     */
    public int getMasodikcsucs() {
        return masodikcsucs;
    }

    public int getSuly() {
        return suly;
    }
    
    @Override
    public String toString() {
        return String.format("(%d - %d - %d)", elsocsucs, masodikcsucs, suly);
    }
}
