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
                    FileInputStream fis = new FileInputStream(files[i].getAbsolutePath());
                    StringBuilder temp = new StringBuilder();
                    int n = 0;
                    while ((n = fis.read()) != -1) {
                        temp.append((char) n);
                    }
                    fis.close();
                    String tempString = temp.toString();
                    for (int j = 0; j < tempString.getBytes().length; j++) {
                        if (tempString.getBytes()[j] == searchWord.getBytes()[0]) {
                            for (int k = 1; k < searchWord.getBytes().length || j < tempString.getBytes().length; k++) {
                                if (searchWord.getBytes()[k] != tempString.getBytes()[j + k]) {
                                    break;
                                }
                                if (k == searchWord.getBytes().length - 1) {
                                    return true;
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return false;
    }

    private static boolean wordSearch(String fileName, String searchWord) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            StringBuilder temp = new StringBuilder();
            int i = 0;
            while ((i = fis.read()) != -1){
                temp.append((char)i);
            }
            fis.close();
            String tempString = temp.toString();
            for (int j = 0; j < tempString.getBytes().length; j++) {
                if (tempString.getBytes()[j] == searchWord.getBytes()[0]){
                    for (int k = 1; k < searchWord.getBytes().length || j < tempString.getBytes().length; k++) {
                        if(searchWord.getBytes()[k] != tempString.getBytes()[j + k]){
                            break;
                        }
                        if(k == searchWord.getBytes().length - 1){
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    private static void readFromTwoFileAndWriteToOneFile(String nameFile1, String nameFile2) {
        StringBuilder tempMsg = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(nameFile2);
            int i = 0;
            while ((i = fis.read()) != -1){
                tempMsg.append((char)i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream(nameFile1, true);
            fos.write(tempMsg.toString().getBytes());
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
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
