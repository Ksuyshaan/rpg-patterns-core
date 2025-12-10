package factory;

import model.Character;
import strategy.MagicAttack;

public class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        Character mage = new Character(name, 80) {};
        mage.setAttackStrategy(new MagicAttack());
        return mage;
    }
}
