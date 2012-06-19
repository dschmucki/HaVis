package org.newinstance.havis.model;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author dschmucki
 */
public class HaVisModel {

    HashMap<String, BP> bpMap;
    HashMap<String, Kante> kanteMap;

    public HaVisModel() {
        bpMap = new HashMap<String, BP>();
        kanteMap = new HashMap<String, Kante>();
    }

    public void addBp(String uic, String name) {
        bpMap.put(uic, new BP(uic, name));
    }

    public void addKoordinaten(String uic, double x, double y, int z) {

        BP bp = bpMap.get(uic);

        if (bp != null) {
            bp.setX(x);
            bp.setY(y);
            bp.setZ(z);
        }
    }

    public void addKante(String von, String nach) {

        String key = von + nach;

        if (kanteMap.containsKey(key)) {
            kanteMap.get(key).incrementCount();
        } else {
            BP v = bpMap.get(von);
            BP n = bpMap.get(nach);
            if (v != null && n != null) {
                kanteMap.put(key, new Kante(v, n));
            }
        }
    }

    public Collection<BP> getAllBp() {
        return this.bpMap.values();
    }

    public Collection<Kante> getAllKante() {
        return this.kanteMap.values();
    }
}
