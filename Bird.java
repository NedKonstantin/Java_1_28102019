package ru.nedovesov.konstantin.java_1.lesson_5;

public class Bird extends Animal {
    public Bird (String type, String name, float run, float jump, float swim){
        super(type, name, run, jump, swim);
    }

    @Override
    protected boolean swimming (float swim){
        return false;
    }
}
