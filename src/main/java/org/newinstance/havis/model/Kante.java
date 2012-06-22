package org.newinstance.havis.model;

/**
 * User: u207365
 * Date: 19.06.12
 * Time: 14:52
 */
public class Kante {

    private BP von;
    private BP nach;

    private int count = 1;

    public Kante(BP von, BP nach) {
        this.von = von;
        this.nach = nach;
    }

    public void incrementCount() {
        count++;
    }

    public String toString() {
        return von.getUic() + "-" + nach.getUic() + ": " + count;
    }

    public BP getVon() {
        return von;
    }

    public void setVon(BP von) {
        this.von = von;
    }

    public BP getNach() {
        return nach;
    }

    public void setNach(BP nach) {
        this.nach = nach;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
