import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyDispatcher implements KeyEventDispatcher {

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {   // аргумент - событие клавы
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  // если нажат ентер - считаем результат
           // result();
            System.out.println("Нажали интер -нужно посчитать");
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // если нажат эскейп - очищаем поле ввода
            //imput.setText("");
            System.out.println("стереть бы все");
        }

        return false;
    }


}
