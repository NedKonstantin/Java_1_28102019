package ru.nedovesov.konstantin.java_1.lesson_5;

import java.util.Random;

public abstract class Animal {
    private String type;
    private String name;
    private final float run;
    private final float jump;
    private final float swim;
    private final Random random = new Random();
    protected Animal(String type, String name, float run, float jump, float swim){
        this.type = type;
        this.name = name;
        this.run = run + random.nextFloat() * run - run / 2;
        this.jump = jump + random.nextFloat() * jump - jump / 2;
        this.swim = swim + random.nextFloat() * swim - swim / 2;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getRun() {
        return run;
    }

    public float getJump() {
        return jump;
    }

    public float getSwim() {
        return swim;
    }

    protected String running(float run){
        String formatRun = String.format("%.1f", run);
        return type + " " + name + " running on " + formatRun + " m";
    }

    protected String jumping(float jump){
        String formatJump = String.format("%.1f", jump);
        return type + " " + name + " jumping on " + formatJump + " m";
    }

    protected String swimming(float swim){
        String formatSwim = String.format("%.1f", swim);
        return type + " " + name + " swimming on " + formatSwim + " m";
    }
}
