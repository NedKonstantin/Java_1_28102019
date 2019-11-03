package ru.nedovesov.konstantin.java_1;

/*
* 1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
*    где a, b, c, d – целочисленные входные параметры этого метода;
* 2. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
*    в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
* 3. Написать метод, которому в качестве параметра передается целое число,
*    метод должен напечатать в консоль положительное ли число передали, или отрицательное;
*    Замечание: ноль считаем положительным числом.
* 4. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
*    метод должен вывести в консоль сообщение «Привет, указанное_имя!»; Вывести приветствие
*    в консоль
* 5. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
*    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/
public class HomeWorkOne {
    public static void main(String[] args){
        System.out.println(arithmeticMethod(82, 33, 54, 65));
        System.out.println(checkAmount(1, 9));
        negativeOrPositive(5);
        System.out.println(helloMethod("Константин"));
        checkYear(2016);
    }

    public static float arithmeticMethod(int a, int b, int c, int d){
        return a * (b + (c * 1f / d));
    }

    public static boolean checkAmount(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    public static void negativeOrPositive(int a){
        if(a < 0){
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static String helloMethod(String name){
        return "Привет, " + name + "!";
    }

    public static void checkYear(int year){
        if(year % 400 == 0) {
            System.out.println("Год високосный");
        } else if (year % 100 == 0 || year != 0) {
            System.out.println("Год не високосный");
        } else if (year % 4 == 0) {
            System.out.println("Год високосный");
        }
    }
}

