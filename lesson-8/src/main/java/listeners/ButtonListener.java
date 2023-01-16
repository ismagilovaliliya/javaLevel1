package listeners;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener implements ActionListener {

    private JTextField inputField;
    private String current,  operator;
    private double previous;

    public ButtonListener(JTextField inputField) {

        this.inputField = inputField;
        previous = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource(); // получили текущее значение

        current = btn.getText(); //текущее значение

        if(current.equals("+") || current.equals("-") || current.equals("/") ||current.equals("x")){
            operator = current;
        }else if(current.equals("=")) {
            inputField.setText(String.valueOf(previous));
            return;
        }else {
            //если число
            selectOperator(current);
        }

        System.out.println("previous " + previous);
        System.out.println("current " + current);
        System.out.println("zad"+new int[][]{{1,2,7},{3,4,5}}[1][2]);
        inputField.setText(inputField.getText()+ " " + btn.getText());
    }

    public void selectOperator(String number){

        if(previous == 0){
            previous = Double.valueOf(number);
            return;
        } else if (previous !=0 && !operator.isEmpty()){
            calcutale();
        }

    }

    private void calcutale() {
        double result = 0;
        double num1 = previous;
        double num2 = Double.parseDouble(current);

        System.out.println("num1 "+ num1 + ", num2 "+ num2);
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                break;
        }
        current = String.valueOf(result);
        previous = result;
    }

}
