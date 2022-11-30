import java.util.ArrayList;
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
    private int attackSupport;
    private int defenseSupport;
    private List<Integer> statusEffects;

    public Vivosaur(String name, Type type, int lp, int attack, int defense, int accuracy, int evasion) {
        this.name = name;
        this.type = type;
        this.maxlp = lp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.currentlp = maxlp;
        attackSupport = 0;
        defenseSupport = 0;
        statusEffects = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            statusEffects.add(0);
        }
    }

    public Type getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getEvasion() {
        return evasion;
    }

    public int getAttackSupport() {
        return attackSupport;
    }

    public int getDefenseSupport() {
        return defenseSupport;
    }

    public void takeDamage(int amount) {

    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    @Override
    public String toString() {
        return name + "\nType: " + type + "\nLife Points: " + currentlp + 
                        "/" + maxlp + "\nAttack: " + attack + "\nDefense: "
                        + defense + "\nAccuracy: " + accuracy + "\nEvasion: "
                        + evasion;
    }
}
