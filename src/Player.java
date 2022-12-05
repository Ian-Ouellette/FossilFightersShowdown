package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    
    private List<Vivosaur> vivosaurs;
    private int fpRegen;
    private int fp;

    public Player (int fpRegen) {
        this.fpRegen = fpRegen;
        fp = 0;
        vivosaurs = new ArrayList<>();
    }

    public int getFp() {
        return fp;
    }

    public void addVivosaur(Vivosaur vivosaur) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean cont = false;
        if (vivosaurs.size() < 5) {
            vivosaurs.add(vivosaur);
        } else {
            int i = 1;
            for (Vivosaur v : vivosaurs) {
                System.out.println(i + ")\n" + v);
                i++;
            }
            while (!cont) {
                System.out.println("Enter the number of the vivosaur you would like to replace: ");
                userInput = input.nextInt();
                if (userInput <= vivosaurs.size()) {
                    vivosaurs.remove(i-1);
                    cont = true;
                } else {
                    System.out.println("Please enter a valid number");
                }
            }
            vivosaurs.add(vivosaur);
        }
        input.close();
    }

    public void removeVivosaur(int index) {
        if (vivosaurs.size() > 0 && index < vivosaurs.size()) {
            vivosaurs.remove(index);
        }
    }

    public void regenFp() {
        fp += fpRegen;
    }

}
