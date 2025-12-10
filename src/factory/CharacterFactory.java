package factory;

import model.Character;

public abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}
