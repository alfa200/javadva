package dvanol;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    //Метод для ввода выражения для расчета
    public static String getInput(){
        System.out.println("Введите выражения для расчета в формате 'a + b'");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static boolean checkString(String str){
        return Pattern.matches("^[0-9]*[.]?[0-9]+[ ][+\\-*/][ ][0-9]*[.]?[0-9]+", str);

    }
    //Метод для складывания чисел
    public static double sum(double a, double b) {
            double result = a + b;
            //Осуществить проверку на выход за пределы double.
            //В случае выхода выкинуть Exception и вернуть 0.
            if (Double.isInfinite(result) || isBoundaryValue(result)) {
                throw (new InfiniteException("Результат не входит сторого в пределы double"));
            } else {
                return result;
            }
    }

    //Метод для вычетания чисел
    public static double subtract(double a, double b) {
            double result = a - b;
            //Осуществить проверку на выход за пределы double.
            //В случае выхода выкинуть Exception и вернуть 0.
            if (Double.isInfinite(result) || isBoundaryValue(result)) {
                throw (new InfiniteException("Результат не входит сторого в пределы double"));
            } else {
                return result;
            }
    }

    //Метод для умножения двух чисел
    public static double multiply(double a, double b) {

            double result = a * b;
            //Осуществить проверку на выход за пределы double.
            //В случае выхода выкинуть Exception и вернуть 0.
            if (Double.isInfinite(result) || isBoundaryValue(result)) {
                throw (new InfiniteException("Результат не входит сторого в пределы double"));
            } else {
                return result;
            }
    }

    //Метод для деления двух чисел
    public static double divide(double a, double b) {
            double result = a / b;
            //Осуществить проверку на выход за пределы double.
            //В случае выхода выкинуть Exception и вернуть 0.
            if (Double.isInfinite(result) || isBoundaryValue(result)) {
                throw (new InfiniteException("Результат не входит сторого в пределы double"));
            } else {
                return result;
            }
    }

    private static boolean isBoundaryValue(Double number) {
        if (number.equals(Double.MAX_VALUE) || number.equals(Double.MIN_VALUE)) {
            return true;
        } else {
            return false;
        }
    }
}


