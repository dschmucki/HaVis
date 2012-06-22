package org.newinstance.havis.model;

import java.io.*;

/**
 * User: u207365
 * Date: 19.06.12
 * Time: 15:30
 */
public class HaVisParser {

    private HaVisModel model;


    public void parseBp(String fileName) {

        try {
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String s;

            while ((s = r.readLine()) != null) {
                if (!s.startsWith("%") && s.length() > 12) {
                    String uic = s.substring(0, 7);
                    String name = s.substring(12).trim();

                    if (uic.length() == 7 && name.length() > 2) {
                        model.addBp(uic, name);
                 }
              }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseKoordinaten(String fileName) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String s;

            while ((s = r.readLine()) != null) {
                if (!s.startsWith("%") && s.length() > 7) {
                    String uic = s.substring(0, 7);
                    double x = Double.parseDouble(s.substring(8, 18).trim());
                    double y = Double.parseDouble(s.substring(19, 29).trim());
                    int z = Integer.parseInt(s.substring(30, 36).trim());

                    model.addKoordinaten(uic, x, y, z);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void parseKanten(String fileName) {

        String von = null;
        String nach = null;

        try {
            BufferedReader r = new BufferedReader(new FileReader(fileName));

            String s;

            while ((s = r.readLine()) != null) {

                von = nach;

                if (s.startsWith("*") || s.startsWith("%") || s.length() < 7) {
                    nach = null;
                } else {
                    nach = s.substring(0, 7);
                }

                if (von != null && nach != null) {
                    model.addKante(von, nach);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setModel(HaVisModel model) {
        this.model = model;
    }

}
