public class Main {
    public static void main(String[] args) {
        Vivosaur spinax = new Vivosaur("Spinax", Type.Air, 480, 72, 36, 48, 20, Range.closeRange, 0.15);
        spinax.setZone(Zone.az);
        Skill spinaxFang = new Skill("Spinax Fang", 84, 50, "No Effect", true);
        spinax.addSkill(spinaxFang);

        Vivosaur tRex = new Vivosaur("T-Rex", Type.Fire, 600, 99, 50, 43, 43, Range.closeRange, 0.15);
        tRex.setZone(Zone.az);
        Skill tyrantsRoar = new Skill("Tyrant's Roar", 100, 100, "Special: Attack both AZ and SZ", false);
        tRex.addSkill(tyrantsRoar);

        DamageCalculator calculator = new DamageCalculator();

        int damage = calculator.calculateDamage(spinax, tRex, tyrantsRoar);
        System.out.println(damage);

        damage = calculator.calculateDamage(tRex, spinax, spinaxFang);
        System.out.println(damage);
    }
}
