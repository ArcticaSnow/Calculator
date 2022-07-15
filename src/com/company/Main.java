package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine(); // считываем строку
        System.out.println(calc(text)); // вызываем метод, передав в него строку, и выводим на консаль результат
    }

    public static String calc(String input) throws Exception{ // создаем метод
        String[] mas = input.split(" "); // заносим значения в массив, разделитель - пробел

        int a = 0; // переменная для первого операнда
        int b = 0; // переменная для второго операнда
        String operator = null; // переменная для оператора

        int countRoman = 0; // счетчик для количества римских чисел
        int countOperation = 0; // счетчик для количества знаков математического оператора
        int countOperand = 0; // счетчик для количества операндов

        int result = 0; // переменная для результата

        for (String el: mas) { // пробегаем циклом по массиву
            if (el.equals("+") || el.equals("-") || el.equals("*") || el.equals("/")) { // если el равна оператору, соответствующему заданию
                countOperation++; // увеличиваем счетчик операторов
                operator = el; // присваиваем оператору значение el
            } else countOperand++; // увеличиваем счетчик операндов
        }

        if (countOperation == 0 || countOperation > 1 || countOperand > 2) { // если количество операндов и операторов не удовлетворяет заданию
            throw new Exception();
        }

        switch (mas[0]) { // отслеживаем сколько введено римских чисел и переводим их в арабские, затем заносим значение в переменную a
            case ("I") : a = 1; countRoman++; break;
            case ("II") : a = 2; countRoman++; break;
            case ("III") : a = 3; countRoman++; break;
            case ("IV") : a = 4; countRoman++; break;
            case ("V") : a = 5; countRoman++; break;
            case ("VI") : a = 6; countRoman++; break;
            case ("VII") : a = 7; countRoman++; break;
            case ("VIII") : a = 8; countRoman++; break;
            case ("IX") : a = 9; countRoman++; break;
            case ("X") : a = 10; countRoman++; break;
            default: if(mas[0].contains("X") || mas[0].contains("L")
                    || mas[0].contains("C") || mas[0].contains("D")
                    || mas[0].contains("M")) { // если число римское, но оно не входит в заданный диапазон, то выбрасываем исключение
                throw new Exception();
            }
        }

        switch (mas[2]) { // отслеживаем сколько введено римских чисел и переводим их в арабские, затем заносим значение в переменную b
            case ("I") : b = 1; countRoman++; break;
            case ("II") : b = 2; countRoman++; break;
            case ("III") : b = 3; countRoman++; break;
            case ("IV") : b = 4; countRoman++; break;
            case ("V") : b = 5; countRoman++; break;
            case ("VI") : b = 6; countRoman++; break;
            case ("VII") : b = 7; countRoman++; break;
            case ("VIII") : b = 8; countRoman++; break;
            case ("IX") : b = 9; countRoman++; break;
            case ("X") : b = 10; countRoman++; break;
            default: if(mas[2].contains("X") || mas[2].contains("C")
                    || mas[2].contains("L") || mas[2].contains("D")
                    || mas[2].contains("M")) { // если число римское, но оно не входит в диапазон, то выбрасываем исключение
                throw new Exception();
            }
        }

        if(countRoman == 1) { // если только одно число римское, выбрасываем исключение
            throw new Exception();
        }

        if (countRoman == 0) { // если нет римских цифр, переводим значения в int и заносим в переменные
            a = Integer.parseInt(mas[0]);
            b = Integer.parseInt(mas[2]);
        }

        if (a < 0 ||a > 10 || b < 0 || b > 10) { // если числа не попадают в заданный диапазон, выбрасываем исключение
            throw new Exception();
        }

        switch (operator) { // проверяем знак, если все ок, то считаем результат, иначе выбрасываем исключение
            case("+") : result = a + b; break;
            case("-") : result = a - b; break;
            case("*") : result =  a * b; break;
            case("/") : result =  a / b; break;
            default: throw new Exception();
        }

        if (countRoman == 2) { // если изначально два числа были римские

            String numberOne = null; // переменная для записи значения из разряда единиц
            String numberTen = null; // переменная для записи значения из разряда десятков

            if (result < 1) { // если результат меньше единицы, выбрасываем исключение
                throw new Exception();
            }

            if (result % 10 == 1) numberOne = "I"; // с помощью остатка от деления на 10 находим значения в разряде единиц и записываем его в соответствующую переменную
            else if (result % 10 == 2) numberOne = "II";
            else if (result % 10 == 3) numberOne = "III";
            else if (result % 10 == 4) numberOne = "IV";
            else if (result % 10 == 5) numberOne = "V";
            else if (result % 10 == 6) numberOne = "VI";
            else if (result % 10 == 7) numberOne = "VII";
            else if (result % 10 == 8) numberOne = "VIII";
            else if (result % 10 == 9) numberOne = "IX";
            else if (result % 10 == 10) numberOne = "X";

            if (result == 20) numberOne = "XX"; // если результат равен числу, кратному 10, то переводим его в римское и записываем в переменную
            else if (result == 30) numberOne = "XXX";
            else if (result == 40) numberOne = "XL";
            else if (result == 50) numberOne = "L";
            else if (result == 60) numberOne = "LX";
            else if (result == 70) numberOne = "LXX";
            else if (result == 80) numberOne = "LXXX";
            else if (result == 90) numberOne = "XC";
            else if (result == 100) numberOne = "C";

            if (result > 10 && result < 20) numberTen = "X"; // определяем, в каком диапазоне находится результат и записываем в переменную значения их разряда десяток
            else if (result > 20 && result < 30) numberTen = "XX";
            else if (result > 30 && result < 40) numberTen = "XXX";
            else if (result > 40 && result < 50) numberTen = "XL";
            else if (result > 50 && result < 60) numberTen = "L";
            else if (result > 60 && result < 70) numberTen = "LX";
            else if (result > 70 && result < 80) numberTen = "LXX";
            else if (result > 80 && result < 90) numberTen = "LXXX";
            else if (result > 90 && result < 100) numberTen = "XC";

            return (numberTen == null ? numberOne : numberTen + numberOne); // возвращаем результат в римских цифрах
        }

        return Integer.toString(result); // возвращаем результат в арабских цифрах, предварительно переведя его в строку
    }
}