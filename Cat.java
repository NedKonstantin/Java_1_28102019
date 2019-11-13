package ru.nedovesov.konstantin.java_1.lesson_5;

public class Cat extends Animal {
    public Cat(String type, String name, float run, float jump, float swim){
        super(type, name, run, jump, swim);
    }

    @Override
    protected String swimming (float swim){
        return this.getType() + " " + this.getName() + " can't swim";
    }
}
