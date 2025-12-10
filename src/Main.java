import factory.*;
import model.Character;
import model.Enemy;
import observer.BattleLog;
import strategy.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Мини-RPG!");
        System.out.println("Выберите героя: 1 — Воин, 2 — Маг, 3 — Лучник");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя героя: ");
        String heroName = scanner.nextLine();

        CharacterFactory factory;
        switch (choice) {
            case 1 -> factory = new WarriorFactory();
            case 2 -> factory = new MageFactory();
            case 3 -> factory = new ArcherFactory();
            default -> factory = new WarriorFactory();
        }

        Character hero = factory.createCharacter(heroName);
        Character enemy = new Enemy("Злобный Маг", 80);
        enemy.setAttackStrategy(new MagicAttack());

        BattleLog logger = new BattleLog();
        hero.addObserver(logger);
        enemy.addObserver(logger);

        System.out.println("\nБой начинается!");
        System.out.println(hero + " VS " + enemy + "\n");

        int turn = 0;
        while (hero.isAlive() && enemy.isAlive()) {
            if (turn % 2 == 0) {
                hero.performAttack(enemy);
            } else {
                enemy.performAttack(hero);
            }

            System.out.println(hero + " | " + enemy + "\n");

            Thread.sleep(600);
            turn++;
        }

        String winner = hero.isAlive() ? hero.getName() : enemy.getName();
        System.out.println("[LOG] Победитель: " + winner);

        scanner.close();
    }
}