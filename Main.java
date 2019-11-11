package ru.nedovesov.konstantin.java_1.lesson_4;

/*
* 1.    Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
* 2.    Конструктор класса должен заполнять эти поля при создании объекта;
* 3.    Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
* 5.    Вывести при помощи методов из пункта 3 ФИО и должность.
* 6.    Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* 7.    * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
* 8.    *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
        присваивался личный уникальный идентификационный порядковый номер
 */

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
        Employee[] employeesArray = new Employee[sizeArray()];
        fillArray(employeesArray);
        for (int j = 0; j < employeesArray.length; j++) {
            System.out.println(employeesArray[j].getId() + "s " + employeesArray[j].getName() + "ss "
                                + employeesArray[j].getPosition() + "sss " + employeesArray[j].getPhoneNumber() + "SSSS"
                                + employeesArray[j].getSalary() + "sssss " + employeesArray[j].getAge());
        }
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 45)
                employeesArray[i].setIncreaseSalary(5000);
        }
        for (int i = 0; i < employeesArray.length; i++) {
            if (employeesArray[i].getAge() > 40)
                employeesArray[i].infoEmployee();
        }
    }
    private static int sizeArray (){
        System.out.println("Установите количество сотрудников в массиве: ");
        int size = scanner.nextInt();
        return size;
    }

    private static void fillArray(Employee[] array) {
//        String name;
//        String position;
//        String phoneNumber;
//        int salary;
//        int birthYear;
        for (int j = 0; j < array.length; j++) {
            System.out.print("Введите ФИО ");
            String name = scanner.nextLine(); // В консоли почему-то не запрашивается ввод этой строки... 
            System.out.println("Введите должность ");
            String position = scanner.nextLine();
            System.out.println("Введите номер телефона ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Введите сумму заработной платы ");
            int salary = scanner.nextInt();
            System.out.println("Введите год рождения ");
            int birthYear = scanner.nextInt();
            array[j] = new Employee(name, position, phoneNumber, salary, birthYear);
        }
//        scanner.close();
    }
}
