package model;

import observer.GameObserver;
import strategy.AttackStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int hp;
    protected AttackStrategy attackStrategy;
    private final List<GameObserver> observers = new ArrayList<>();

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public void performAttack(Character enemy) {
        if (attackStrategy != null && isAlive() && enemy.isAlive()) {
            attackStrategy.attack(this, enemy);
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String event) {
        for (GameObserver obs : observers) {
            obs.onEvent(event);
        }
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + "[HP=" + hp + "]";
    }
}
