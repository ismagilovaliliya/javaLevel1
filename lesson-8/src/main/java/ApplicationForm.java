
import components.NumberJButton;
import components.OperatorJButton;
import listeners.ButtonListener;
import listeners.ClearButtonActionListener;
import listeners.ExitButtonListener;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ApplicationForm extends JFrame{

    private JTextField inputField;

    private String currentValue, previousValue, operator;

    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //нажатие на выход останавливает приложение
        setAlwaysOnTop(true); //показывать поверх всех окон

        int width = 350;
        int height = 450;

        //получаем парамметры экрана
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        //установка коррдинат в середине экрана
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);

        setJMenuBar(createMenu()); // Создание шапки
        setLayout(new BorderLayout());//так и не поняла что это. просто поле задает? почитать побольше, что за штука

        add(createTopPanel(), BorderLayout.NORTH); //верхушку добавили
        add(createCenterPanel(), BorderLayout.CENTER); //цифры + операторы

        //обработка клавиатуры
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyDispatcher());

        setVisible(true);// показать форму на экране
    }


    //шапка
    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);

        exitItem.addActionListener(new ExitButtonListener());

        return menuBar;
    }

    //панель ввода данных
    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputField.setMargin(new Insets(20, 0, 20, 0));
        inputField.setBackground(new Color(255, 255, 255));

        //inputField.setText("(1 + 5) * 2 = 12");

        return top;
    }

    //операторы + цифры
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);


        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        calc.addActionListener(buttonListener);
        digitsPanel.add(calc);


        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));

        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(buttonListener);
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(buttonListener);
        panel.add(plus);

        JButton multiply = new OperatorJButton("x");
        multiply.addActionListener(buttonListener);
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(buttonListener);
        panel.add(divide);

        return panel;
    }


    private void testListener() {
        Button button = new Button("Кнопка");
        button.addActionListener(new TestButtonListener());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("СОБЫТИЕ!");
            }
        });
//                button.addActionListener(e -> System.out.println("СОБЫТИЕ ЧЕРЕЗ ЛЯМБДУ!"));
        super.add(button);
    }

}
