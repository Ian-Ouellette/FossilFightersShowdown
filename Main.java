public class Main {
    public static void main(String[] args) {
        String name = "Spinax";
        Type type = Type.Air;
        int lp = 480;
        int attack = 72;
        int defense = 36;
        int accuracy = 48;
        int evasion = 20;
        double crit = 0.15;

        Vivosaur spinax = new Vivosaur(name, type, lp, attack, defense, accuracy, evasion, crit);

        System.out.println(spinax);
    }
}
