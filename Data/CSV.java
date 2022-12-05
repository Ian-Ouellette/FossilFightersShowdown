package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import src.*;

public class CSV {

    public String[] splitter(String line) {
        Character delimiter = ',';
        int last = 0;
        int endOfLine = line.length();
        List<String> info = new ArrayList<>();
        boolean isFirst = true;
        for (int i = 0; i < endOfLine; i++) {
            if (line.charAt(i) == delimiter || i == endOfLine - 1) {
                if (isFirst) {
                    info.add(line.substring(last, i));
                    last = i;
                    isFirst = false;
                    continue;
                }
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

    public List<Vivosaur> getVivosaurs(List<String[]> vivosaurList) {
        List<Vivosaur> vivosaurs = new ArrayList<>();
        String name = "";
        Type type = null;
        int lp = 0;
        int attack = 0;
        int defense = 0;
        int accuracy = 0;
        int evasion = 0;
        Range range = null;
        double crit = 0.0;
        Double[] allyEffects = new Double[4];
        Double[] enemyEffects = new Double[4];
        for (String[] strings : vivosaurList) {
            name = strings[0];
            type = stringToType(strings[1]);
            lp = Integer.parseInt(strings[3]);
            attack = Integer.parseInt(strings[4]);
            defense = Integer.parseInt(strings[5]);
            accuracy = Integer.parseInt(strings[6]);
            evasion = Integer.parseInt(strings[7]);
            range = stringToRange(strings[8]);
            crit = Double.parseDouble(strings[9]);
            Vivosaur vivosaur = new Vivosaur(name, type, lp, attack, defense, accuracy, evasion, range, crit);
            for (int i = 0; i < 4; i++) {
                allyEffects[i] = Double.parseDouble(strings[i+10]);
            } for (int i = 0; i < 4; i++) {
                enemyEffects[i] = Double.parseDouble(strings[i+13]);
            }
            vivosaur.setAllyEffects(allyEffects);
            vivosaur.setEnemyEffects(enemyEffects);
            vivosaurs.add(vivosaur);
        }
        return vivosaurs;
    }

    private Type stringToType(String string) {
        Type type = null;
        if (string.equals("Air")) {
            type = Type.Air;
        } else if (string.equals("Earth")) {
            type = Type.Earth;
        } else if (string.equals("Fire")) {
            type = Type.Fire;
        } else if (string.equals("Water")) {
            type = Type.Water;
        } else if (string.equals("Neutral")) {
            type = Type.Neutral;
        } else if (string.equals("Legendary")) {
            type = Type.Legendary;
        }
        return type;
    }

    private Range stringToRange(String string) {
        Range range = null;
        if (string.equals("Close")) {
            range = Range.Close;
        } else if (string.equals("Long")) {
            range = Range.Long;
        } else if (string.equals("Longer")) {
            range = Range.Longer;
        } else if (string.equals("Longerer")) {
            range = Range.Longerer;
        } else if (string.equals("Longest")) {
            range = Range.Longest;
        }
        return range;
    }
    
}
