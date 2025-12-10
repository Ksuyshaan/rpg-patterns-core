package factory;

import model.Character;
import strategy.BowAttack;

public class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Character archer = new Character(name, 90) {};
        archer.setAttackStrategy(new BowAttack());
        return archer;
    }
}
