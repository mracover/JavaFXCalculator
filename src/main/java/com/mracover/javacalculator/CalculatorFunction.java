package com.mracover.javacalculator;

public class CalculatorFunction {

    public float calculateUnaryNumber(float num, String operator) {
        switch (operator) {
            case "√":
                return (float) Math.sqrt(num);
            case "Sin":
                return (float)Math.sin(num);
            case "Cos":
                return (long)Math.cos(num);
            case "Tan":
                return (float)Math.tan(num);
            case "e^x":
                return (float) Math.exp(num);
            case "x^2":
                return num*num;
            case "x^3":
                return num*num*num;
            case "Log":
                return (float) Math.log(num);
            case "ln":
                return (float) Math.log10(num);
            case "x!":
                int f = 1;
                for (int i = 1; i <= num; i++) {
                    f = f * i;
                }
                return f;
        }
        return 0;
    }

    public  float calculateBinaryNumber(float num1, float num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if(num2==0)
                    return 0;
                return num1 / num2;
            case "Mod":
                return num1 % num2;
            case "x^y":
                return (float) Math.pow(num1, num2);
            default:
                break;
        }
        return 0;
    }
}
