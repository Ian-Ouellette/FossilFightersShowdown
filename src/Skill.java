package src;
public class Skill {
    
    private String name;
    private int damage;
    private int cost;
    private String effect;
    private boolean isCounterable;

    public Skill (String name, int damage, int cost, String effect, boolean isCounterable) {
        this.name = name;
        this.damage = damage;
        this.cost = cost; 
        this.effect = effect;
        this.isCounterable = isCounterable;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getCost() {
        return cost;
    }

    public String getEffect() {
        return effect;
    }

    public boolean getIsCounterable() {
        return isCounterable;
    }

}
