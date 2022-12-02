import java.util.Random;

public class DamageCalculator {

    public DamageCalculator() {}

    public int calculateDamage(Vivosaur target, Vivosaur source, Skill skill) {
        Random random = new Random();
        double attack = source.getAttack();
        double power = skill.getDamage();
        double attackSupport = source.getAttackSupport();
        double attackStatus = source.getAttackStatus();
        double defense = target.getDefense();
        double defenseSupport = target.getDefenseSupport();
        double defenseStatus = target.getDefenseStatus();
        double randomMultiplier = random.nextDouble(0.95, 1.05);
        double elementalMultiplier = elementAdvantage(target.getType(), source.getType());
        double rangeMultiplier = rangeAdvantage(target.getZone(), source.getZone(), source.getRange());
        double critical = critMultiplier(source.getCriticalChance());

        double attackDamage = attack + power + attackStatus;
        attackDamage = attackDamage * attackSupport;
        double block = defenseSupport + defenseStatus;
        block = block * defense;
        double finalDamage = attackDamage - block;
        finalDamage = finalDamage * randomMultiplier * elementalMultiplier * rangeMultiplier * critical;
        
        return (int)finalDamage;
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

    private double rangeAdvantage(Zone target, Zone source, Range sourceRange) {
        double multiplier = 1;

        if (sourceRange.equals(Range.closeRange)) {
            if (source.equals(Zone.az)) {
                if (target.equals(Zone.bottomsz) || target.equals(Zone.topsz)) {
                    multiplier = 0.5;
                }
            } else if (source.equals(Zone.bottomsz) || source.equals(Zone.bottomsz)) {
                multiplier = 0.5;
            }
        } else if (sourceRange.equals(Range.longerRange)) {
            multiplier = 1.2;
        } else if (sourceRange.equals(Range.longererRange)) {
            multiplier = 1.4;
        } else if (sourceRange.equals(Range.longestRange)) {
            multiplier = 1.8;
        }

        return multiplier;
    }

    private double critMultiplier(double critChance) {
        double multiplier = 1;
        Random rand = new Random();
        double isCrit = rand.nextDouble(1);
        if (isCrit <= critChance) {
            multiplier = 1.5;
        }
        return multiplier;
    }
    
}
