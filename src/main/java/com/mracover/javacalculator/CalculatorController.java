package com.mracover.javacalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Label result;
//    Промежуточный результат
    @FXML
    private Label tempResult;
    private float num1 = 0;
    private float temp = 0;
    private String operation = "";
//    Проверка операции
    private boolean isOperation = false;
    private final CalculatorFunction calculatorFunction = new CalculatorFunction();

//    Ввод цифр; Вывод цифры на экран
    @FXML
    public void processNumber(ActionEvent evt) {
        String val = ((Button)evt.getSource()).getText();
        if (isOperation) {
            tempResult.setText(tempResult.getText() + val);
            result.setText(val);
        } else {
            result.setText(result.getText() + val);
            tempResult.setText(tempResult.getText() + val);
        }
        isOperation = false;

    }

    @FXML
    public void ClearFunction() {
        operation = "";
        isOperation = false;
        tempResult.setText("");
        result.setText("");
        num1 = 0;
        temp = 0;
    }

    @FXML
    public void processBinaryOperator(ActionEvent evt) {
        String val = ((Button)evt.getSource()).getText();
        isOperation = true;
        if (!result.getText().isEmpty()) {
            temp = Float.parseFloat(result.getText());
            if (operation.isEmpty()) {
                num1 = temp;
            } else {
                num1 = calculatorFunction.calculateBinaryNumber(num1, temp, operation);
            }
        }
        if (val.equals("=")) {
            operation = "";
            result.setText(String.valueOf(num1));
            tempResult.setText(String.valueOf(num1));
        } else {
            operation = val;
            result.setText("");
            tempResult.setText(tempResult.getText() + operation);
        }
    }

    @FXML
    public void processUnaryOperator(ActionEvent evt) {
        operation = ((Button)evt.getSource()).getText();
        num1 = Float.parseFloat(result.getText());
        result.setText("");

        float output = calculatorFunction.calculateUnaryNumber(num1, operation);
        result.setText(String.valueOf(output));
        tempResult.setText(String.valueOf(output));
        operation = "";
        num1 = 0;
    }
}
