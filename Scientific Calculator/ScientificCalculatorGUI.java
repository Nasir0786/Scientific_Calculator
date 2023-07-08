import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculatorGUI extends JFrame implements ActionListener {

    private JTextField textField;
    private double number1, number2, result;
    private String operator;
    private double memory;

    public ScientificCalculatorGUI() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sqrt", "sin", "cos", "tan",
                "M+", "M-", "MR", "MC",
                "C"
        };

        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.addActionListener(this);
            buttonPanel.add(btn);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
            case ".":
                textField.setText(textField.getText() + command);
                break;
            case "/": case "*": case "-": case "+":
                number1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
                break;
            case "sqrt":
                number1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(number1);
                textField.setText(String.valueOf(result));
                break;
            case "sin":
                number1 = Double.parseDouble(textField.getText());
                result = Math.sin(Math.toRadians(number1));
                textField.setText(String.valueOf(result));
                break;
            case "cos":
                number1 = Double.parseDouble(textField.getText());
                result = Math.cos(Math.toRadians(number1));
                textField.setText(String.valueOf(result));
                break;
            case "tan":
                number1 = Double.parseDouble(textField.getText());
                result = Math.tan(Math.toRadians(number1));
                textField.setText(String.valueOf(result));
                break;
            case "=":
                number2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "/":
                        result = number1 / number2;
                        textField.setText(String.valueOf(result));
                        break;
                    case "*":
                        result = number1 * number2;
                        textField.setText(String.valueOf(result));
                        break;
                    case "-":
                        result = number1 - number2;
                        textField.setText(String.valueOf(result));
                        break;
                    case "+":
                        result = number1 + number2;
                        textField.setText(String.valueOf(result));
                        break;
                }
                break;
            case "M+":
                memory += Double.parseDouble(textField.getText());
                break;
            case "M-":
                memory -= Double.parseDouble(textField.getText());
                break;
            case "MR":
                textField.setText(String.valueOf(memory));
                break;
            case "MC":
                memory = 0;
                break;
            case "C":
                textField.setText("");
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ScientificCalculatorGUI().setVisible(true);
            }
        });
    }
}
