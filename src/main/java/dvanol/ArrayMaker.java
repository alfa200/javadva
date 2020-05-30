package dvanol;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayMaker {
    //Метод для ввода массива слов
    public static String[] getInpu2(int size) {
        System.out.println("Введите слова, которыми необходимо наполнить массив");
        Scanner in = new Scanner(System.in);
        String[] mass = new String[size];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = in.next();
        }
        return mass;
    }

    //Найти самое длиное слово(а)
    public static ArrayList<String> findLongestWord(String[] mass) {
        int length = 0;
        //Поиск длины самого длинного слова
        for (String s : mass) {
            if (s.length() > length) {
                length = s.length();
            }
        }
        //Заполнение массива самыми длинными словами
        ArrayList<String> longestWords = new ArrayList<String>();
        for (String s : mass) {
            if (s.length() == length){
                longestWords.add(s);
            }
        }
        return longestWords;
    }

}
