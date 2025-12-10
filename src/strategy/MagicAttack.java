package strategy;

import model.Character;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 20;
        int selfDamage = 5;
        enemy.takeDamage(damage);
        attacker.takeDamage(selfDamage);
        String msg = "[" + attacker.getName() + "] применил магию на " + damage + " урона (но потерял " + selfDamage + " HP).";
        System.out.println(msg);
        attacker.notifyObservers("[LOG] " + msg);
    }
}
