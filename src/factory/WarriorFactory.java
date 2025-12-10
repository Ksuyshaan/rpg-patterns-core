package factory;

import model.Character;
import strategy.MeleeAttack;

public class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Character warrior = new Character(name, 100) {};
        warrior.setAttackStrategy(new MeleeAttack());
        return warrior;
    }
}
