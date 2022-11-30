import java.util.ArrayList;
import java.util.List;

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
        vivosaurs.add(vivosaur);
    }

    public void regenFp() {
        fp += fpRegen;
    }

}
