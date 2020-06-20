package dvanol;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Ввести '1' для доступа к калькулятору, '2' поиск максимального слова в массиве, '3' " +
                "для задания 'Массив размерностью 20, заполняется случайными целыми числами от -10 до 10. " +
                "Найти максимальный отрицательный и минимальный положительный элементы массива. Поменять их местами.', " +
                "'4', чтобы наполнить новогодний подарок.");
        int check = in.nextInt();
        //Калькулятор
        if (check == 1) {
            //Ввести выражения для расчета и сохранить в строку str
            String str = Calculator.getInput();
            //Проверить на удовлетворение шаблону
            if (Calculator.checkString(str)) {
                //Представить введеное выражение в виде массива
                String[] exp = str.split(" ");
                DecimalFormat df = new DecimalFormat("#.####");
                try {
                    if (exp[1].equals("+")) {
                        double result = Calculator.sum(Double.valueOf(exp[0]), Double.valueOf(exp[2]));
                        System.out.println(df.format(result));
                    } else if (exp[1].equals("-")) {
                        double result = Calculator.subtract(Double.valueOf(exp[0]), Double.valueOf(exp[2]));
                        System.out.println(df.format(result));
                    } else if (exp[1].equals("*")) {
                        double result = Calculator.multiply(Double.valueOf(exp[0]), Double.valueOf(exp[2]));
                        System.out.println(df.format(result));
                    } else if (exp[1].equals("/")) {
                        double result = Calculator.divide(Double.valueOf(exp[0]), Double.valueOf(exp[2]));
                        System.out.println(df.format(result));
                    }
                } catch (InfiniteException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Введеное выражение не соответсвует формату!");
            }
            //Поиск максимального элемента в массиве. Для начала задать массив слов.
            //Размерность массива произвольна, задается в консоли.
            //После чего в консоли вводятся слова в количестве равном заданной длине массива.
            //В полученном массиве необходимо найти самое длинное слово. Результат вывести на консоль
        } else if (check == 2) {
            System.out.println("Ввеидете длину массива");
            int size = in.nextInt();
            String[] mass = ArrayMaker.getInpu2(size);
            System.out.println("Самое длинное слово(а):");
            for (String s : ArrayMaker.findLongestWord(mass)) {
                System.out.println(s);
            }

        } else if (check == 3) {
            System.out.println("Массив заполнен 20 случайными значениями от -10 до 10 включительно");
            ArrayList<Integer> mass = FillArrayAndSwitch.randomArrayFiller();
            System.out.println(mass);
            System.out.println("Массив после замены местами");
            System.out.println(FillArrayAndSwitch.findTwoNumbers(mass));

        } else if (check == 4) {
            //Формируется новогодний подарок. Он может включать в себя разные сладости
            // (Candy, Jellybean, etc.) У каждой сладости есть название, вес, цена и свой
            // уникальный параметр. Необходимо собрать подарок из сладостей.
            // Найти общий вес подарка, общую стоимость подарка и вывести на
            // консоль информацию о всех сладостях в подарке.
            ArrayList<Sweets> bag = new ArrayList<Sweets>();
            bag.add(new Jellybean("Jellybean1", 101, 1001, "цвет", "red"));
            bag.add(new Jellybean("Jellybean2", 102, 1002, "цвет", "green"));
            bag.add(new Jellybean("Jellybean3", 103, 1003, "цвет", "blue"));
            bag.add(new Cookies("Cookies1", 201, 2001, "страна", "Russia"));
            bag.add(new Cookies("Cookies2", 202, 2002, "страна", "USA"));
            bag.add(new Candy("Candy1", 301, 3001, "вкус", "flavor of childhood"));
            for (Sweets bs : bag) {
                System.out.println(bs.toString());
            }


        } else if (check == 5) {
            //Прочитать слова из файла.
            //Отсортировать в алфавитном порядке.
            //Посчитать сколько раз каждое слово встречается в файле. Вывести статистику на консоль
            //Найти слово с максимальным количеством повторений. Вывести на консоль
            //это слово и сколько раз оно встречается в файле
            ArrayList<String> array = ReadFromFile.readFromFile();
            Collections.sort(array);
            System.out.println("Отсортированные в алфавитном порядке слова:");
            System.out.println(array);
            Map<String, Integer> map = ReadFromFile.countWords(array);
            System.out.println("Частота упоминания слов в файле в формате 'слово - количество упоминаний'");
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                System.out.println(pair.getKey() + " - " + pair.getValue());
            }

            int max = 1;
            //Поиск максимального повтора
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (pair.getValue() > max) {
                    max = pair.getValue();
                }
            }
            //Вывод на экран слов с максимальным повтором
            System.out.println("Чаще всего (" + max + " раз(а)) встречаются слова:");
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (pair.getValue() == max) {
                    System.out.println(pair.getKey());
                }
            }
        } else {


            System.out.println("Неизвестная команда");
        }
    }

}
