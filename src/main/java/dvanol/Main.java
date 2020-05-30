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
            //Ввести выражения для расчета и сохранить в массиве exp
            String[] exp = Calculator.getInput();
            DecimalFormat df = new DecimalFormat("#.####");
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
            } else {
                System.out.println("Неизвестная операция!");
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
            System.out.println("Заполните массив из 20 целых чисел значениями от -10 до 10 включительно");
            ArrayList<Integer> mass = FillArrayAndSwitch.arrayFiller();
            System.out.println(FillArrayAndSwitch.findTwoNumbers(mass));

        } else if (check == 4) {
            //Формируется новогодний подарок. Он может включать в себя разные сладости
            // (Candy, Jellybean, etc.) У каждой сладости есть название, вес, цена и свой
            // уникальный параметр. Необходимо собрать подарок из сладостей.
            // Найти общий вес подарка, общую стоимость подарка и вывести на
            // консоль информацию о всех сладостях в подарке.
            System.out.println("Введите сколько сладостей в подарке");
            int size = in.nextInt();
            ArrayList<BagOfSweets> bag = new ArrayList<BagOfSweets>();
            for (int i = 0; i < size; i++) {
                System.out.println("Введите информацию в формате 'название,масса,стоимость,особенность'");
                String[] description = in.next().split(",");
                BagOfSweets bos = new BagOfSweets(description[0],
                        Double.valueOf(description[1]), Double.valueOf(description[2]), description[3]);
                bag.add(bos);
            }
            double masss = 0;
            double price = 0;
            //Посчитать массу и стоимость всего подарка
            for (BagOfSweets bs : bag) {
                masss += bs.getMassa();
                price += bs.getPrice();
            }
            System.out.println("Информация о подарке:");
            System.out.println("Масса подарка " + masss +" г");
            System.out.println("Стоимость подарка " + price +" руб.");
            for (BagOfSweets bs : bag) {
                System.out.println(bs.getName() +" (" + bs.getSpecialPart() + ")");
            }
        } else if (check == 5) {
            //Прочитать слова из файла.
            //Отсортировать в алфавитном порядке.
            //Посчитать сколько раз каждое слово встречается в файле. Вывести статистику на консоль
            //Найти слово с максимальным количеством повторений. Вывести на консоль
            //это слово и сколько раз оно встречается в файле
            ArrayList<String> array = ReadFromFile.readFromFile();
            Collections.sort(array);
            Map<String, Integer> map = ReadFromFile.countWords(array);
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
