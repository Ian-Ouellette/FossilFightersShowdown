package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public String[] splitter(String line) {
        Character delimiter = ',';
        int last = 0;
        int endOfLine = line.length();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < endOfLine; i++) {
            if (line.charAt(i) == delimiter || i == endOfLine - 1) {
                info.add(line.substring(last + 1, i));
                last = i;
            } else if (line.charAt(i) == '\"') {
                int end = line.indexOf("\"", i + 1);
                if (end != -1)
                    i = end;
            }
        }
        String[] strInfo = new String[info.size()];
        return info.toArray(strInfo);
    }

    public List<String[]> readFile(String file) {
        List<String[]> items = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); //Skip first line
            while ((line = br.readLine()) != null) {
                items.add(splitter(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: Couldnt read input file || " + file);
        }
        return items;
}
    
}
