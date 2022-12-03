# JavaFXCalculator
Калькулятор обрабатывающий `бинарные` и `унарные` операции над числами, использующий `JavaFX`. <br/>
<p align="center">
  <img src="https://user-images.githubusercontent.com/79517707/205450925-ad16963b-389e-4b7f-91c0-fa325f99f313.png"/>
</p>

# Структура
+ CalculatorApplicatoin (main). Содержит `start` метод с загрузкой fxml файла и создания stage. 
+ CalculatorFunction. Содержит бинарные и унарные функции выполнения процесса. 
+ CalculatorController. Содержит методы событий при нажатии определенных кнопок в интерфейсе.

# Принцип работы контроллера
```java
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
```
Данный метод срабатывает при каждом нажатии кнопки с цифрой. Кнопкам присвоенная каждая цифра, она и считывается в переменную `val`. Булевская переменная `isOperation` имеет значение false, если кнопка является числом, и true, если операцией. `tempResult` - label, который находиться вверху интерфейса и выводит выражения (Например, 1+1). `result` - главный Label, где показывается значение кнопки на которую нажали, а также результат выполнения выражения. 

<br/>

```java
@FXML
    public void ClearFunction() {
        operation = "";
        isOperation = false;
        tempResult.setText("");
        result.setText("");
        num1 = 0;
        temp = 0;
    }
``` 
Кнопка `C` в калькуляторе. Данный метод сбрасывает все поля класса. 
<br/>

```java
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
``` 
Метод бинарных операций сработает при нажатии на одну из кнопок бинарных операций. Переменной `val` присваивается текст кнопки (операция). Если главный label не пустой то переменной `temp` присвается значение цифры, которая есть на данном label. Далее идет проверка на наличие значения в поле `operation`, если оно пустое, то постоянной переменной цифры присвается значение с поля `temp`, а если нет, то вызывается метод бинарных операций из класса `CalculatorFunction`. Выполнен с помощью контрукции `switch-case`. 
<br/>
Проверка на пустоту поля `operation` сделанно для того, чтобы пользователь мог вводить сложные выражения. При первой итерации данного метода это поле будет пустое. 
<br/>
Если пользователь нажмет на кнопку `=`, то на главный label выведется результат вычислений, и дополнительный label примет такое же значения, чтобы проводить дальнейшие операции над данным числом.
<br/>

```java
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
``` 
Метод унарных операций работает очень просто. В поле `operation` записывается операция. В поле `num1` записывается число, которое находится на главном label. Далее вызывается метод унарных операций из класса `CalculatorFunction`, и результат выполнения выводится на главный label.
