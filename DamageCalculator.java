import java.util.Random;

public class DamageCalculator {

    public DamageCalculator() {}

    public int calculateDamage(Vivosaur target, Vivosaur source, Skill skill) {
        Random random = new Random();
        int attack = source.getAttack();
        int power = skill.getDamage();
        int attackSupport = source.getAttackSupport();
        int defense = target.getDefense();
        int defenseSupport = target.getDefenseSupport();
        double randomMultiplier = random.nextDouble(0.95, 1.05);
        double elementalMultiplier = elementAdvantage(target.getType(), source.getType());
        
        return 0;
    }

    private double elementAdvantage(Type target, Type source) {
        double multiplier = 1;
        
        if (target.equals(Type.Air)) {
            if (source.equals(Type.Earth)) {
                multiplier = 1.5;
            } else if (source.equals(Type.Water)) {
                multiplier = 0.75;
            }
        } 
        else if (target.equals(Type.Water)) {
            if (source.equals(Type.Air)) {
                multiplier = 1.5;
            } else if (source.equals(Type.Fire)) {
                multiplier = 0.75;
            }
        } 
        else if (target.equals(Type.Fire)) {
            if (source.equals(Type.Water)) {
                multiplier = 1.5;
            } else if (source.equals(Type.Earth)) {
                multiplier = 0.75;
            }
        } 
        else if (target.equals(Type.Earth)) {
            if (source.equals(Type.Fire)) {
                multiplier = 1.5;
            } else if (source.equals(Type.Air)) {
                multiplier = 0.75;
            }
        } else {
            multiplier = 1;
        }
        
        return multiplier;
    }
    
}
