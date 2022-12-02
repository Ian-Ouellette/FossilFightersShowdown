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
    private Zone zone;
    private Range range;
    private double criticalChance;

    public Vivosaur(String name, Type type, int lp, int attack, int defense, int accuracy, int evasion, double criticalChance) {
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
        zone = null;
        range = null;
        this.criticalChance = criticalChance;
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

    public int getAttackStatus() {
        return statusEffects.get(0);
    }

    public int getDefenseStatus() {
        return statusEffects.get(1);
    }

    public int getAccuracyStatus() {
        return statusEffects.get(2);
    }

    public int getEvasionStatus() {
        return statusEffects.get(3);
    }

    public void takeDamage(int amount) {

    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    @Override
    public String toString() {
        return name + "\nType: " + type + "\nLife Points: " + currentlp + 
                        "/" + maxlp + "\nAttack: " + attack + "\nDefense: "
                        + defense + "\nAccuracy: " + accuracy + "\nEvasion: "
                        + evasion;
    }
}
