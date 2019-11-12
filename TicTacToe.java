package ru.nedovesov.konstantin.java_1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static final int SIZE_X = 3;
    static final int SIZE_Y = 3;
    static final int WIN_SERIAS = 3;
    static char[][] field = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'x';
    static final char AI_DOT = 'o';
    static final char EMPTY_DOT = '.';

    static Scanner scanner = new Scanner(System.in);
    static final Random rand = new Random();

    public static void initField(){
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printField(){
        System.out.print("   ");
        for (int i = 1; i < SIZE_X + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void setSym (int y, int x, char sym){
        field[y][x] = sym;
    }

    public static boolean checkWin(char sym){
        if (checkWinHorizontal(sym)){
            return true;
        }
        if (checkWinVertical(sym)){
            return true;
        }
        if (checkWinDiagonal(sym)){
            return true;
        }
//        if (checkWinTopDiagonal(sym)){
//            return true;
//        }
//        if (checkBottomDiagonal(sym)){
//            return true;
//        }
        return false;
    }

    public static boolean checkWinHorizontal(char sym){
        for (int i = 0; i < SIZE_Y; i++) {
            int count = 0;
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym) {
                    count++;
                }
                if (field[i][j] != sym) {
                    count = 0;
                }
                if (count == WIN_SERIAS) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinVertical(char sym){
        for (int j = 0; j < SIZE_X; j++) {
            int count = 0;
            for (int i = 0; i < SIZE_Y; i++) {
                if(field[i][j]==sym){
                    count++;
                }
                if (field[i][j] != sym) {
                    count = 0;
                }
                if(count==WIN_SERIAS){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWinDiagonal(char s) {
        int diagonalShift = SIZE_X - WIN_SERIAS;
        int count = 0;
        while (diagonalShift >= 0) {
            for(int i = 0; i < WIN_SERIAS; i++){
                if (field[i+diagonalShift][i] == s)
                    count++;
                if (count == WIN_SERIAS)
                    return true;
            }
            count = 0;
            for (int i = 0; i < WIN_SERIAS; i++){
                if (field[i][i+diagonalShift] == s)
                    count++;
                if (count == WIN_SERIAS)
                    return true;
            }
            count = 0;
            for(int i = 0, j = 1; i < WIN_SERIAS; i++, j++){
                if (field[field.length - diagonalShift - j][i] == s)
                    count++;
                if (count == WIN_SERIAS)
                    return true;
            }
            count = 0;
            for(int i = field.length - 1, j = 1; j < field.length; j++, i --){
                if (field[i][j] == s)
                    count++;
                if (count == WIN_SERIAS)
                    return true;
            }
            count = 0;
            diagonalShift--;

        }
        for(int i = 0, j = 1; i < WIN_SERIAS; i++, j++){
            if (field[field.length - j][i] == s)
                count++;
            if (count == WIN_SERIAS)
                return true;
        }

        return false;
    }
//    public static boolean checkWinTopDiagonal(char sym){
//        int count = 0;
//        for (int i = 0, j = 0; i < SIZE_Y; i++, j++) {
//            if(field[i][j] == sym){
//                count++;
//            }
//            if (field[i][j] != sym) {
//                count = 0;
//            }
//            if (count == WIN_SERIAS){
//                return true;
//            }
//        }
//        count = 0;
//        int diagonalShift = SIZE_Y - WIN_SERIAS;
//        while (diagonalShift > 0) {
//            for (int i = 0 + diagonalShift, j = 0; i < SIZE_Y; i++, j++) {
//                if (field[i][j] == sym) {
//                    count++;
//                }
//                if (field[i][j] != sym) {
//                    count = 0;
//                }
//                if (count == WIN_SERIAS) {
//                    return true;
//                }
//            }
//            diagonalShift--;
//        }
//        count = 0;
//        diagonalShift = SIZE_Y - WIN_SERIAS;
//        while (diagonalShift > 0) {
//            for (int i = 0, j = 0 + diagonalShift; j < SIZE_X; i++, j++) {
//                if (field[i][j] == sym) {
//                    count++;
//                }
//                if (field[i][j] != sym) {
//                    count = 0;
//                }
//                if (count == WIN_SERIAS) {
//                    return true;
//                }
//            }
//            diagonalShift--;
//        }
//        return false;
//    }
//
//    public static boolean checkBottomDiagonal(char sym) {
//        int count = 0;
//        for (int i = SIZE_Y - 1, j = 0; j < SIZE_X; i--, j++) {
//            if(field[i][j] == sym){
//                count++;
//            }
//            if (field[i][j] != sym) {
//                count = 0;
//            }
//            if(count == WIN_SERIAS){
//                return true;
//            }
//        }
//        count = 0;
//        int diagonalShift = SIZE_Y - WIN_SERIAS;
//        while (diagonalShift > 0){
//            for (int i = SIZE_Y - 1 - diagonalShift, j = 0; i >= 0; i--, j++) {
//                if(field[i][j] == sym){
//                    count++;
//                }
//                if (field[i][j] != sym) {
//                    count = 0;
//                }
//                if(count == WIN_SERIAS){
//                    return true;
//                }
//            }
//            diagonalShift--;
//        }
//        count = 0;
//        diagonalShift = SIZE_Y - WIN_SERIAS;
//        while (diagonalShift > 0) {
//            for (int i = SIZE_Y - 1, j = 0 + diagonalShift; j < SIZE_X; i--, j++) {
//                if (field[i][j] == sym) {
//                    count++;
//                }
//                if (field[i][j] != sym) {
//                    count = 0;
//                }
//                if (count == WIN_SERIAS) {
//                    return true;
//                }
//            }
//            diagonalShift--;
//        }
//        return false;
//    }

    private static boolean checkDraw() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }

    public static void plaerStep(){
        int x, y;
        do{
            System.out.println("¬ведите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }while (!isCellValid(y, x));
        setSym(y, x, PLAYER_DOT);
    }

    public static void aiStep(){
        int x, y;
        do{
            x = rand.nextInt(SIZE_X);
            y = rand.nextInt(SIZE_Y);
        }while (!isCellValid(y, x));
        setSym(y, x, AI_DOT);
    }

    public static boolean isCellValid(int y, int x){
        if(x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1){
            return false;
        }
        return (field[y][x] == EMPTY_DOT);
    }


    public static void main(String[] args) {
        initField();
        printField();

        while (true){
            plaerStep();
            printField();
            if(checkWin(PLAYER_DOT)){
                System.out.println("Player WIN!");
                break;
            }
            if(checkDraw()){
                System.out.println("DRAW!");
                break;
            }

            aiStep();
            printField();
            if(checkWin(AI_DOT)){
                System.out.println("SkyNet WIN!");
                break;
            }
            if(checkDraw()){
                System.out.println("DRAW!");
                break;
            }
        }
    }
}
