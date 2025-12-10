package strategy;

import model.Character;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(Character attacker, Character enemy) {
        int damage = 15;
        enemy.takeDamage(damage);
        String msg = "[" + attacker.getName() + "] нанёс удар мечом на " + damage + " урона.";
        System.out.println(msg);
        attacker.notifyObservers("[LOG] " + msg);
    }
}