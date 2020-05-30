package dvanol;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFromFile {
    //Предполагается, что файл наполнен словами по одном слову нас строку
    public static ArrayList<String> readFromFile() throws IOException {
        FileReader fr= new FileReader("myfile1.txt");
        Scanner scan = new Scanner(fr);
        String[] line = scan.nextLine().split(" ");
        ArrayList<String> array = new ArrayList<String>(Arrays.asList(line));
        fr.close();
    return array;
    }

    //Предполагается, что файл наполнен словами по одном слову нас строку
    public static Map<String,Integer> countWords(ArrayList<String> array){
        Map<String,Integer> map = new HashMap<String, Integer>();
        int count = 0;
        for (String str : array) {
            if (!map.containsKey(str)) {
                for (String str2 : array) {
                    if (str2.equals(str)){
                        count++;
                    }
                }
                map.put(str, count);
            }
            count = 0;
        }
        return map;
    }
}