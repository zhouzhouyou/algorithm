package sort;

import java.io.*;
import java.util.ArrayList;

public class DataReader {
    public static Integer[] getDataSet() {
        String filename = "sort.txt";
        File file = new File(filename);
        ArrayList<Integer> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String string;
            while ((string = reader.readLine()) != null && !string.equals("")) {
                while (string.contains(" ")) {
                    string = string.substring(1);
                }
                list.add(Integer.valueOf(string));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer[] out = new Integer[list.size()];
        return list.toArray(out);
    }
}
