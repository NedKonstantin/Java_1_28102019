package ru.nedovesov.konstantin.java_1.lesson_5;

import java.util.Scanner;

public class MainZoo {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Animal zoo[] = {new Cat("cat", "Barsik", 200, 2, 0),
                        new Cat("cat", "Murzik", 200, 2, 0),
                        new Dog("dog", "Sharik", 500, 0.5f, 10),
                        new Horse("horse", "Gnedoi", 1500, 3f, 100),
                        new Bird("bird", "Kesha", 5, 0.2f, 0),
                        new WaterBird("duck", "Donald", 25, 0.5f, 500)};

        System.out.println("Введите дистанцию для бега");
        float distanceRun = scanner.nextFloat();
        System.out.println("Введите высоту для прыжка");
        float distanceJump = scanner.nextFloat();
        System.out.println("Введите дистанцию для заплыва");
        float distanceSwim = scanner.nextFloat();
        for (int i = 0; i < zoo.length; i++) {
            if(zoo[i].running(distanceRun)) {
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                                    + " преодолел всю дистанцию в " + distanceRun + " м");
            } else {
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                                    + " смог преодолеть только " + zoo[i].getRun() + " м");
            }
            if(zoo[i].jumping(distanceJump)){
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                        + " прыгнул на " + distanceJump + " м");
            } else {
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                        + " смог прыгнуть только на " + zoo[i].getJump() + " м");
            }
            if(zoo[i].swimming(distanceSwim)){
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                        + " проплыл " + distanceSwim + " м");
            } else if (zoo[i] instanceof Cat || zoo[i] instanceof Bird && !(zoo[i] instanceof WaterBird)) {
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                        + " не умеет плавать");
            } else {
                System.out.println(zoo[i].getType() + " " + zoo[i].getName()
                        + " смог проплыть только " + zoo[i].getSwim() + " м");
            }

        }
    }
}
