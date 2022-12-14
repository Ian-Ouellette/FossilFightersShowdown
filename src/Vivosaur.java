package src;
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
    private List<Skill> skills;
    private Type type;
    private Double[] supportEffects;
    private Double[] allyEffects;
    private Double[] enemyEffects;
    private Zone zone;
    private Range range;
    private double criticalChance;
    private int attackStatus;
    private int defenseStatus;

    public Vivosaur(String name, Type type, int lp, int attack, int defense, int accuracy, int evasion, Range range, double criticalChance) {
        this.name = name;
        this.type = type;
        this.maxlp = lp;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
        this.evasion = evasion;
        this.range = range;
        skills = new ArrayList<>();
        this.currentlp = maxlp;
        supportEffects = new Double[4];
        allyEffects = new Double[4];
        enemyEffects = new Double[4];
        zone = null;
        range = null;
        this.criticalChance = criticalChance;
        attackStatus = 0;
        defenseStatus = 0;
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

    public int getAttackStatus() {
        return attackStatus;
    }

    public int getDefenseStatus() {
        return defenseStatus;
    }

    public double getAttackSupport() {
        return supportEffects[0];
    }

    public double getDefenseSupport() {
        return supportEffects[1];
    }

    public double getAccuracySupport() {
        return supportEffects[2];
    }

    public double getEvasionSupport() {
        return supportEffects[3];
    }

    public Double[] getAllyEffects() {
        return allyEffects;
    }

    public Double[] getEnemyEffects() {
        return enemyEffects;
    }

    public void setAllyEffects(Double[] allyEffects) {
        this.allyEffects = allyEffects;
    }

    public void setEnemyEffects(Double[] enemyEffects) {
        this.enemyEffects = enemyEffects;
    }

    public void takeDamage(int amount) {

    }

    public void addSkill(Skill skill) {
        skills.add(skill);
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
