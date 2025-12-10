package strategy;

import model.Character;
import java.util.Random;

public class BowAttack implements AttackStrategy {
    private final Random rand = new Random();

    @Override
    public void attack(Character attacker, Character enemy) {
        int baseDamage = 10;
        boolean crit = rand.nextDouble() < 0.3;
        int damage = crit ? baseDamage * 2 : baseDamage;
        enemy.takeDamage(damage);
        String msg = "[" + attacker.getName() + "] выстрелил из лука на " + damage + " урона" + (crit ? " (КРИТ!)" : "") + ".";
        System.out.println(msg);
        attacker.notifyObservers("[LOG] " + msg);
    }
}
