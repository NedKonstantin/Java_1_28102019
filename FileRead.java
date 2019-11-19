package ru.nedovesov.konstantin.java_1.lesson_6;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileRead {
    public static void main(String[] args) {
//        String msg1 = "Hello World!";
//        String msg2 = "Hello Java!";
//        String msg3 = "Hello Konstantin!";
//        String msg4 = "The world is beautiful!";
//        String msg5 = "Java is a popular programming language!";
//        String msg6 = "I'm interested in learning Java!";
//        String nameDir = "E://GeekBrains//Java_Basic//Java_1_28102019";
//        fillFiles(msg1, msg2, msg3, msg4, msg5, msg6);
//        readFromTwoFileAndWriteToOneFile("File1.txt", "File2.txt");
//        Scanner scanner = new Scanner(System.in);
//        String searchWord = scanner.nextLine();
//        System.out.println((wordSearch("File1.txt", searchWord)) ? "Слово есть" : "Слова нет");
//        System.out.println((searchInDir(nameDir, searchWord)) ? "Слово есть" : "Слова нет");

    }

    private static boolean searchInDir(String nameDir, String searchWord) {
        File dir = new File(nameDir);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                try {
                    if (wordSearch(files[i], searchWord)) return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }

    private static boolean wordSearch(File file, String searchWord) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            int i = 0;
            while ((i = fis.read()) != -1) {
                for (int j = 0; j < searchWord.getBytes().length; j++) {
                    if (i != searchWord.getBytes()[j]) {
                        break;
                    } else {
                        i = fis.read();
                    }
                    if (j == searchWord.getBytes().length - 1) {
                        return true;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
            return false;
    }

    private static boolean wordSearch(String fileName, String searchWord) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int i = 0;
            while ((i = fis.read()) != -1){
                for (int j = 0; j < searchWord.getBytes().length; j++) {
                    if (i != searchWord.getBytes()[j]){
                        break;
                    } else {
                        i = fis.read();
                    }
                    if (j == searchWord.getBytes().length - 1){
                        return true;
                    }
                }
            }
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    private static void readFromTwoFileAndWriteToOneFile(String nameFile1, String nameFile2) {
        StringBuilder tempMsg = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(nameFile2);
            FileOutputStream fos = new FileOutputStream(nameFile1, true);
            int i = 0;
            while ((i = fis.read()) != -1){
                fos.write(i);
            }
            fis.close();
            fos.close();
        } catch (IOException e){
            e.getMessage();
        }
    }

    private static void fillFiles(String msg1, String msg2, String msg3, String msg4, String msg5, String msg6) {
        try {
           FileOutputStream fos1 = new FileOutputStream("File1.txt");
           FileOutputStream fos2 = new FileOutputStream("File2.txt");
           for (int i = 0; i < 20; i++) {
               fos1.write(msg1.getBytes());
               fos2.write(msg4.getBytes());
               fos1.write(' ');
               fos2.write(' ');
               fos1.write(msg2.getBytes());
               fos2.write(msg5.getBytes());
               fos1.write(' ');
               fos2.write(' ');
               fos1.write(msg3.getBytes());
               fos2.write(msg6.getBytes());
               fos1.write('\n');
               fos2.write('\n');
           }
           fos1.close();
           fos2.close();
       }  catch (IOException e) {
           e.printStackTrace();
       }
    }
}
