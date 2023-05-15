package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel Main;
    private JButton integrateButton;
    private JButton multiplicationButton;
    private JButton addButton;
    private JButton substractButton;
    private JButton divideButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField quotient;
    private JButton derivateButton;
    private JTextField remainder;

    public View() {
        this.setContentPane(this.Main);
        this.setVisible(true);
        this.pack();
    }

    public void updateResult(String string) {
        quotient.setText(string);
    }

    public void updateRemainder(String string){
        remainder.setText(string);
    }

    public String getPolinome1() {
        return textField1.getText();
    }

    public String getPolinome2(){
        return textField2.getText();
    }

    public void addController(ActionListener listener){
        addButton.addActionListener(listener);
        substractButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        multiplicationButton.addActionListener(listener);
        derivateButton.addActionListener(listener);
        integrateButton.addActionListener(listener);
    }
}
