package gui;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleUnaryOperator;
import java.util.List;
import java.util.ArrayList;

import operation.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton[] digitButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton log10Button;
    private double num1, num2;
    private char operation;
    private boolean isOperationPerformed;
    private List<String> operations = new ArrayList<>();

    // Create instances of your operation classes
    private AdditionOperation additionOperation = new AdditionOperation();
    private SubtractionOperation subtractionOperation = new SubtractionOperation();
    private MultiplicationOperation multiplicationOperation = new MultiplicationOperation();
    private DivisionOperation divisionOperation = new DivisionOperation();
    private ExponentiationOperation exponentiationOperation = new ExponentiationOperation();
    private SquareRootOperation squareRootOperation = new SquareRootOperation();
    private ModuloOperation moduloOperation = new ModuloOperation();
    private SinusOperation sinusOperation = new SinusOperation();
    private CosinusOperation cosinusOperation = new CosinusOperation();
    private TangensOperation tangensOperation = new TangensOperation();
    private LogarithmOperation logarithmOperation = new LogarithmOperation();
    private FactorialOperation factorialOperation = new FactorialOperation();
    private CubeRootOperation cubeRootOperation = new CubeRootOperation();
    private NaturalLogarithmOperation naturalLogarithmOperation = new NaturalLogarithmOperation();
    private AbsoluteValueOperation absoluteValueOperation = new AbsoluteValueOperation();
    private RoundingOperation roundingOperation = new RoundingOperation();
    private AverageOperation averageOperation = new AverageOperation();


    public CalculatorGUI() {
        setTitle("Calculator App");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setEditable(false);
        inputField.setPreferredSize(new Dimension(inputField.getPreferredSize().width, 100));
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 6));

        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
            buttonPanel.add(digitButtons[i]);
        }

        operationButtons = new JButton[13];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        operationButtons[4] = new JButton("^");
        operationButtons[5] = new JButton("√");
        operationButtons[6] = new JButton("%");
        operationButtons[7] = new JButton("sin");
        operationButtons[8] = new JButton("cos");
        operationButtons[9] = new JButton("tan");
        operationButtons[10] = new JButton("log");
        operationButtons[11] = new JButton("!");
        operationButtons[12] = new JButton("∛");
        for (int i = 0; i < 13; i++) {
            operationButtons[i].addActionListener(this);
            buttonPanel.add(operationButtons[i]);
        }


        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);



        log10Button = new JButton("log10");
        log10Button.addActionListener(this);
        buttonPanel.add(log10Button);

        add(buttonPanel, BorderLayout.CENTER);


        JButton lnButton = new JButton("ln");
        lnButton.addActionListener(this);
        buttonPanel.add(lnButton);

        JButton absButton = new JButton("abs");
        absButton.addActionListener(this);
        buttonPanel.add(absButton);

        JButton commaButton = new JButton(".");
        commaButton.addActionListener(this);
        buttonPanel.add(commaButton);

        JButton roundButton = new JButton("round");
        roundButton.addActionListener(this);
        buttonPanel.add(roundButton);

        JButton log2Button = new JButton("log2");
        log2Button.addActionListener(this);
        buttonPanel.add(log2Button);

        JButton averageButton = new JButton("avg");
        averageButton.addActionListener(this);
        buttonPanel.add(averageButton);




        ThemeManager.applyDefaultTheme(this);

        for(JButton button : digitButtons){
            ThemeManager.setButtonTheme(button, ThemeManager.DEFAULT_DIGIT_COLOR);
            button.setFont(new Font("Arial", Font.BOLD, 24));
        }

        for (JButton button : operationButtons) {
            ThemeManager.setButtonTheme(button, ThemeManager.DEFAULT_BUTTON_COLOR);
        }

        for (JButton button : operationButtons) {
            ThemeManager.setButtonTheme(button, ThemeManager.DEFAULT_OPERATION_BUTTON_COLOR);
        }

        ThemeManager.setButtonTheme(equalsButton, ThemeManager.DEFAULT_EQUALS_BUTTON_COLOR);
        ThemeManager.setButtonTheme(clearButton, ThemeManager.DEFAULT_CLEAR_BUTTON_COLOR);
        ThemeManager.setButtonTheme(log10Button, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(lnButton, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(absButton, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(commaButton, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(roundButton, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(log2Button, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);
        ThemeManager.setButtonTheme(averageButton, ThemeManager.DEFAULT_SPECIAL_BUTTON_COLOR);

        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            inputField.setText(inputField.getText() + command);
        } else if (command.equals("C")) {
            clearInput();
        } else if (command.equals("=")) {
            if (isOperationPerformed) {
                performOperation();
            } else if (inputField.getText().contains("+") || inputField.getText().contains("-") || inputField.getText().contains("*")) {
                performOperation();
            }
        } else if (command.equals("avg")) {
            if (inputField.getText().contains("+")) {
                String[] numbersString = inputField.getText().split("\\+");
                List<Double> numbers = new ArrayList<>();
                for (String numberString : numbersString) {
                    try {
                        double number = Double.parseDouble(numberString);
                        numbers.add(number);
                    } catch (NumberFormatException ex) {
                        inputField.setText("Invalid input: " + numberString);
                        return;
                    }
                }
                double result = AverageOperation.averageOf(numbers);
                inputField.setText(String.valueOf(result));
            }
        } else {
            if (command.equals("sin")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = sinusOperation.sinusOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("cos")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = cosinusOperation.cosinusOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("tan")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = tangensOperation.tangensOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("log")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = logarithmOperation.logarithmOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("!")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = factorialOperation.factorialOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("∛")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = cubeRootOperation.cubeRootOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("ln")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = naturalLogarithmOperation.naturalLogarithmOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("abs")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = AbsoluteValueOperation.absoluteValueOf(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals(".")) {
                if (!inputField.getText().contains(".")) {
                    inputField.setText(inputField.getText() + ".");
                }
            }else if (command.equals("round")) {
                num1 = Double.parseDouble(inputField.getText());
                double result = RoundingOperation.roundNumber(num1);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else if (command.equals("log10")) {
                num1 = Double.parseDouble(inputField.getText());
                try {
                    double result = Log10Operation.log10Of(num1);
                    inputField.setText(String.valueOf(result));
                } catch (IllegalArgumentException ex) {
                    inputField.setText(ex.getMessage());
                }
                clearOperation();
            }else if (command.equals("log2")) {
                num1 = Double.parseDouble(inputField.getText());
                try {
                    double result = Log2Operation.log2Of(num1);
                    inputField.setText(String.valueOf(result));
                } catch (IllegalArgumentException ex) {
                    inputField.setText(ex.getMessage());
                }
                clearOperation();
            }else if (command.equals("avg")) {
                String input = inputField.getText();
                String[] numbersString = input.split("+");
                List<Double> numbers = new ArrayList<>();
                for (String numberString : numbersString) {
                    try {
                        double number = Double.parseDouble(numberString);
                        numbers.add(number);
                    } catch (NumberFormatException ex) {
                        inputField.setText("Invalid input: " + numberString);
                        return;
                    }
                }
                double result = AverageOperation.averageOf(numbers);
                inputField.setText(String.valueOf(result));
                clearOperation();
            } else {
                setOperation(command.charAt(0));
            }
        }
    }

    private void setOperation(char operation) {
        if (isOperationPerformed) {
            num1 = Double.parseDouble(inputField.getText().split("\\+")[0]);
        } else {
            num1 = Double.parseDouble(inputField.getText());
        }
        this.operation = operation;
        inputField.setText(inputField.getText() + operation);
        isOperationPerformed = true;
    }

    private void performOperation() {
        String[] numbersString;
        double result = 0;
        if (inputField.getText().contains("+")) {
            numbersString = inputField.getText().split("\\+");
            for (String numberString : numbersString) {
                try {
                    double number = Double.parseDouble(numberString);
                    result += number;
                } catch (NumberFormatException ex) {
                    inputField.setText("Invalid input: " + numberString);
                    return;
                }
            }
        } else if (inputField.getText().contains("-")) {
            numbersString = inputField.getText().split("-");
            try {
                result = Double.parseDouble(numbersString[0]);
            } catch (NumberFormatException ex) {
                inputField.setText("Invalid input: " + numbersString[0]);
                return;
            }
            for (int i = 1; i < numbersString.length; i++) {
                try {
                    double number = Double.parseDouble(numbersString[i]);
                    result -= number;
                } catch (NumberFormatException ex) {
                    inputField.setText("Invalid input: " + numbersString[i]);
                    return;
                }
            }
        } else if (inputField.getText().contains("*")) {
            numbersString = inputField.getText().split("\\*");
            try {
                result = Double.parseDouble(numbersString[0]);
            } catch (NumberFormatException ex) {
                inputField.setText("Invalid input: " + numbersString[0]);
                return;
            }
            for (int i = 1; i < numbersString.length; i++) {
                try {
                    double number = Double.parseDouble(numbersString[i]);
                    result *= number;
                } catch (NumberFormatException ex) {
                    inputField.setText("Invalid input: " + numbersString[i]);
                    return;
                }
            }
        } else {
            num2 = Double.parseDouble(inputField.getText());
            switch (operation) {
                case '/':
                    if (num2 != 0) {
                        result = divisionOperation.divideNumbers(num1, num2);
                    } else {
                        inputField.setText("Division by zero is not allowed.");
                        return;
                    }
                    break;
                case '^':
                    result = exponentiationOperation.exponentiateNumbers(num1, num2);
                    break;
                case '√':
                    result = squareRootOperation.squareRootOf(num1);
                    break;
                case '%':
                    result = moduloOperation.moduloNumbers(num1, num2);
                    break;
                case 's':
                    result = sinusOperation.sinusOf(num1);
                    break;
            }
        }
        if (result == (long) result) {
            // Round the result to the nearest integer
            result = Math.round(result);
        }
        inputField.setText(String.valueOf(result));
        clearOperation();
    }

    private void clearInput() {
        inputField.setText("");
        clearOperation();
    }

    private void clearOperation() {
        num1 = 0;
        num2 = 0;
        operation = ' ';
        isOperationPerformed = false;
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }


}