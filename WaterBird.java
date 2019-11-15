package ru.nedovesov.konstantin.java_1.lesson_5;

public class WaterBird extends Bird {
    public WaterBird (String type, String name, float run, float jump, float swim){
        super(type, name, run, jump, swim);
    }

    @Override
    protected boolean swimming(float swim){
        return swim <= this.getSwim();
    }
}
