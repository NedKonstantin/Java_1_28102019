package ru.nedovesov.konstantin.java_1.lesson_4;

public class Employee {
    private static int idCount = 0;
    private int id;
    private String name;
    private String position;
    private String phoneNumber;
    private int salary;
    private int birthYear;

    private Employee() {
        idCount ++;
    }

    public Employee(String name, String position, String phoneNumber, int salary, int birthYear) {
        this();
        this.id = idCount;
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return 2019 - birthYear;
    }

    public void setIncreaseSalary(int sum) {
        this.salary += sum;
    }
    public void infoEmployee (){
        System.out.printf("%d %s %s %s %d %d", this.id, this.name, this.position, this.phoneNumber, this.salary, this.getAge());
    }
}
