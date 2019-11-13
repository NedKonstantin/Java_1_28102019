package ru.nedovesov.konstantin.java_1.lesson_5;

public class MainZoo {
    public static void main(String[] args) {
        Animal zoo[] = {new Cat("cat", "Barsik", 200, 2, 0),
                        new Cat("cat", "Murzik", 200, 2, 0),
                        new Dog("dog", "Sharik", 500, 0.5f, 10),
                        new Horse("horse", "Gnedoi", 1500, 3f, 100),
                        new Bird("bird", "Kesha", 5, 0.2f, 0)};

        for (int i = 0; i < zoo.length; i++) {
            System.out.println(zoo[i].running(zoo[i].getRun()));
            System.out.println(zoo[i].jumping(zoo[i].getJump()));
            System.out.println(zoo[i].swimming(zoo[i].getSwim()));
        }
    }
}
