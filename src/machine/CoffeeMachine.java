package machine;

import java.util.Scanner;

class Coffee {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public Coffee(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }

    public void giveMoney() {
        this.money = 0;
    }

    public void buyCoffee(int water, int milk, int beans, int cups, int money) {
        this.water -= water;
        this.milk -= milk;
        this.beans -= beans;
        this.cups -= cups;
        this.money += money;
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }
}

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);

    static Coffee coffee = new Coffee(400, 540, 120, 9, 550);
    static Coffee espresso = new Coffee(250, 0, 16, 1, 4);
    static Coffee latte = new Coffee(350, 75, 20, 1, 7);
    static Coffee cappuccino = new Coffee(200, 100, 12, 1, 6);

    public static void remaining() {
        System.out.printf("The coffee machine has:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans%n" +
                "%d disposable cups%n" +
                "$%d of money%n", coffee.getWater(), coffee.getMilk(), coffee.getBeans(), coffee.getCups(), coffee.getMoney());
    }

    public static void take() {
        System.out.printf("I gave you $%d%n", coffee.getMoney());
        coffee.giveMoney();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String command = scanner.next();

        switch (command) {
            case "1" :
                if (coffee.getWater() >= espresso.getWater() && coffee.getBeans() >= espresso.getBeans() && coffee.getCups() >= espresso.getCups()) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffee.buyCoffee(espresso.getWater(), espresso.getMilk(), espresso.getBeans(), espresso.getCups(), espresso.getMoney());
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (coffee.getWater() >= latte.getWater() && coffee.getBeans() >= latte.getBeans() && coffee.getCups() >= latte.getCups() &&
                        coffee.getMilk() >= latte.getMilk()) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffee.buyCoffee(latte.getWater(), latte.getMilk(), latte.getBeans(), latte.getCups(), latte.getMoney());
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "3":
                if (coffee.getWater() >= cappuccino.getWater() && coffee.getBeans() >= cappuccino.getBeans() &&
                        coffee.getCups() >= cappuccino.getCups() && coffee.getMilk() >= cappuccino.getMilk()) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffee.buyCoffee(cappuccino.getWater(), cappuccino.getMilk(), cappuccino.getBeans(), cappuccino.getCups(), cappuccino.getMoney());
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Command not found!");
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cups = scanner.nextInt();

        coffee.fill(water, milk, beans, cups);
    }


    public static void coffeeMachine() {


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Command not found!");
                    break;
            }
        }
    }
}