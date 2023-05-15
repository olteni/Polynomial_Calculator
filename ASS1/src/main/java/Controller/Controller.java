package Controller;

import Model.Polinom;
import Model.PolinomeConverter;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Controller implements ActionListener {

    private final View view;

   public Controller(View view){
       this.view = view;
   }

    @Override
    public void actionPerformed(ActionEvent e) {
       PolinomeConverter pc = new PolinomeConverter();

        switch(e.getActionCommand()){
            case "Add" -> {
                Polinom polinom1 = pc.convert(view.getPolinome1());
                Polinom polinom2=  pc.convert(view.getPolinome2());
                view.updateResult(polinom1.add(polinom2).toString());
            }
            case "Substract" -> {
                Polinom polinom1 = pc.convert(view.getPolinome1());
                Polinom polinom2=  pc.convert(view.getPolinome2());
                view.updateResult(polinom1.subb(polinom2).toString());
            }

            case "Divide" -> {
                Polinom polinom1 = pc.convert(view.getPolinome1());
                Polinom polinom2=  pc.convert(view.getPolinome2());
                Map.Entry<Polinom,Polinom> pair = Polinom.divide(polinom1,polinom2);
                view.updateResult(pair.getValue().toString());
                view.updateRemainder(pair.getKey().toString());
            }

            case "Multiplication" ->{
                Polinom polinom1 = pc.convert(view.getPolinome1());
                Polinom polinom2=  pc.convert(view.getPolinome2());
                view.updateResult(polinom1.multiplication(polinom2).toString());
            }

            case "Derivate" -> {
                Polinom polinom1 = pc.convert(view.getPolinome1());
                view.updateResult(polinom1.derivation().toString());
            }
            case "Integrate" -> {
                Polinom polinom1 = pc.convert(view.getPolinome1());
                view.updateResult(polinom1.integration().toString());
            }

        }
    }
}
