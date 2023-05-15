package Model;

import Model.Monom;
import Model.Polinom;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolinomeConverter {

    private View view;

    public Polinom convert(String polinom) {

        String[] monomStrings = polinom.split("\\+");
        Polinom p = new Polinom();
        int constant, exp;
        for (String monomString : monomStrings) {
            if (monomString.length() > 0) {
                String[] expConst = monomString.split("X\\^");
                if (expConst[0].equals("")) {
                    constant = 1;
                } else {
                    constant = Integer.parseInt(expConst[0]);
                }
                if (expConst.length == 1) {
                    exp = 0;
                } else {
                    exp = Integer.parseInt(expConst[1]);
                }
                p.addMonom(new Monom(constant, exp));
            }
        }
        return p;
    }


}
