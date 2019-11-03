package ru.nedovesov.konstantin.java_1;
/*
* 1 ������ ������������� ������, ��������� �� ��������� 0 � 1. ��������: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
*   �������� �����, ���������� � �������� ������� 0 �� 1, 1 �� 0;
* 2 ������ ������ ������������� ������ �������� 8. �������� �����, ������� ������� �����
*   �������� ��� ���������� 1 4 7 10 13 16 19 22;
* 3 ������ ������ [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], �������� �����, ����������� �� ���� ������
*   � ���������� ����� ������ 6 �� 2;
* 4 ������ ���������� ������. �������� ������ ������ � �� ������������ � ������������� ��������;
* 5 * ������� ���������� ������������� ������ (���������� ����� � �������� ����������),
*   ��������� ��� ������������ �������� ���������, ��������� ����(�);
* 6 ** �������� �����, � ������� ���������� �� ������ ���������� ������������� ������,
*   ����� ������ ������� true ���� � ������� ���� �����, � ������� ����� ����� � ������ ����� ������� �����.
*   �������: checkBalance([1, 1, 1, || 2, 1]) > true, checkBalance ([2, 1, 1, 2, 1]) > false,
*   checkBalance ([10, || 1, 2, 3, 4]) > true. ����������� ������� �������� ��������� ||, ��� ������� � ������ �� ������.
* 7 *** �������� �����, �������� �� ���� ������� ���������� ������ � ����� n
*   (����� ���� �������������, ��� �������������), ��� ���� ����� ������ ���������� ��������
*   ��� �������� ������� �� n �������.
* 8 **** �� ������������ ��������������� �������� ��� ������� ������ 7.
*/

import java.util.Arrays;

public class HomeWorkTwo {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeElementsArrays(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[8];
        fillArray(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multipleElementsArrays(arr3);
        System.out.println(Arrays.toString(arr3));
        int[] arr4 = {12, 5, 45, 21, 18, 32, 52, 26, 41, 50};
        System.out.println("������������ �������� �������: " + maximumElement(arr4));
        System.out.println("����������� �������� �������: " + minimumElement(arr4));
        int[][] arr5 = new int[15][15];
        fillDiagonal(arr5);
        printArrayToConsole(arr5);
        int[] arr6 = {1, 1, 2, 4, 3, 2, 3};
        int[] arr7 = {2, 3, 2, 5, 6, 2, 1};
        System.out.println("������ ����� ������: " + checkBalance(arr6));
        System.out.println("������ ����� ������: " + checkBalance(arr7));
        System.out.println("������ ����� ������: " + checkBalanceVariantTwo(arr6));
        System.out.println("������ ����� ������: " + checkBalanceVariantTwo(arr7));
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr8));
        changeArray(arr8, 3);
        System.out.println(Arrays.toString(arr8));
        changeArray(arr8, - 3);
        System.out.println(Arrays.toString(arr8));
    }
// ������� 1
    private static void changeElementsArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

// ������� 2
    private static void fillArray(int[] array) {
        array[0] = 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i-1] + 3;
        }
    }

// ������� 3
    private static void multipleElementsArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
    }

// ������� 4
    private static int maximumElement(int[] array){
        int maximum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > maximum) maximum = array[i];
        }
        return maximum;
    }
    private static int minimumElement(int[] array){
        int minimum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < minimum) minimum = array[i];
        }
        return minimum;
    }

// ������� 5
    private static void fillDiagonal(int[][] array) {
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            array[i][j] = 1;
        }
        for (int i = 0, j = array.length - 1; j >= 0; i++, j--) {
            array[i][j] = 1;
        }
    }
// �������, ����� ������ ��������� �� ��������...
    private static void printArrayToConsole(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

// ������� 6
// ������ �������� ������� �������
    private static boolean checkBalance(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum % 2 == 0) ? true : false;
    }
// ����� ����������, ����� ������ ��� ������ ��������� ������
    private static boolean checkBalanceVariantTwo (int[] arr) {
        int sumRight = 0;
        int sumLeft = 0;
        for (int i = 0; i < arr.length-1; i++) {
            sumLeft += arr[i];
            sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return  false;
    }

// ������� 7 � 8
    private static void changeArray(int[] arr, int n) {
        int tempVar;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                tempVar = arr[arr.length - 1];
//            System.out.println(tempVar);
                for (int j = arr.length - 1, a = 2; j > 0; j--, a++) {
                    arr[j] = arr[arr.length - a];
                }
                arr[0] = tempVar;
            }
        } else {
            for (int i = 0; i < n * (-1); i++) {
                tempVar = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 1] = tempVar;
            }
        }
    }
}
