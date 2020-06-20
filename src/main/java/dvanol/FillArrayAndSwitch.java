package dvanol;

import java.util.ArrayList;
import java.util.Scanner;

public class FillArrayAndSwitch {
    //Метод для наполнения массива 20 челыми числами [-10; 10]
    public static ArrayList<Integer> arrayFiller() {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while (mass.size() < 20) {
            int number = in.nextInt();
            if (number >= -10 && number <= 10) {
                mass.add(number);
            }
        }
        return mass;
    }

    public static ArrayList<Integer> randomArrayFiller() {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        while (mass.size() < 20) {
            mass.add(number());
        }
        return mass;
    }

    public static int number() {
        return (int) (Math.random() * 21) - 10;
    }

    //Поиск мест максимального отрицательного и минимального положительного
    //элементов массива
    public static ArrayList<Integer> findTwoNumbers(ArrayList<Integer> mass) {
        int minIndex = -1;
        int maxIndex = -1;
        //Перебор чисел от -1 до -10
        for (int i = -1; i >= -10; i--) {
            //Сравнение i с числами массива в поисках первого совпадения
            for (int number : mass) {
                if (number == i) {
                    minIndex = mass.indexOf(i);
                    break;
                }
            }
            //Если максимальное отрицательное число найдено, то выйти из цикла
            if (minIndex != -1) {
                break;
            }
        }
        //Перебор чисел от 1 до 10
        for (int i = 1; i <= 10; i++) {
            //Сравнение i с числами массива в поисках первого совпадения
            for (int number : mass) {
                if (number == i) {
                    maxIndex = mass.indexOf(i);
                    break;
                }
            }
            //Если минимальное положительное число найдено, то выйти из цикла
            if (maxIndex != -1) {
                break;
            }
        }
        if (maxIndex == -1 || minIndex == -1) {
            return mass;
        } else {
            return switchTwoNumbers(mass, minIndex, maxIndex);
        }
    }

    //Поменять местами два числа с известными индексами
    public static ArrayList<Integer> switchTwoNumbers(ArrayList<Integer> mass, int minIndex, int maxIndex) {
        //Сохранить в переменную число с индексом
        int A = mass.get(minIndex);
        //Сохранить в переменную число с индексом
        int B = mass.get(maxIndex);
        //Поменять местам два числа
        mass.set(minIndex, B);
        mass.set(maxIndex, A);
        return mass;
    }
}
