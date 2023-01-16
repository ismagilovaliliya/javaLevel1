import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButtonListener implements ActionListener {

    private JTextField inputField;

   /* public TestButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
