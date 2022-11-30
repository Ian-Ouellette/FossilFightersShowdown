import java.util.List;

public class Vivosaur {

    private String name;
    private int maxlp;
    private int currentlp;
    private int attack;
    private int defense;
    private int accuracy;
    private int evasion;
    private List<Ability> abilities;
    private Type type;
    

    public Vivosaur(String name, Type type, int lp, int attack, int defense, int accuracy, int evasion) {
        this.name = name;
        this.type = type;
        this.maxlp = lp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.currentlp = maxlp;
    }
    
}
