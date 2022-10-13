package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Decryption {
    public static void decryptionRu() {
        char letter;
        int key = 0;
        int reedLetter = 0;
        int newPosition = 0;

        System.out.println("Укажите полный путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String fileName = null;
        BufferedReader bufferedReader = null;
        try {
            fileName = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            decryptionRu();
        }
        StringBuilder newString = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            decryptionRu();

        }

        while (true) {
            try {
                if ((reedLetter = bufferedReader.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) reedLetter;
            if (ChooseLanguage.Alphabet.ruAlphabet.contains(letter)) {
                int origPosition = ChooseLanguage.Alphabet.ruAlphabet.indexOf(letter);
                if (origPosition < key) {
                    newPosition = origPosition - key + ChooseLanguage.Alphabet.ruAlphabet.size();
                } else {
                    newPosition = (origPosition - key);
                }
                char newLetter = ChooseLanguage.Alphabet.ruAlphabet.get(newPosition);
                newString.append(newLetter);
            } else newString.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_decryption"
                    + fileName.substring((fileName.lastIndexOf('.'))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write(newString.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("____________________________");
        System.out.println("Расшифровка выполнена успешно " + "\u2705");
        System.out.println("Файл с расшифрованным текстом успешно создан " + "\u2705");
    }

    public static void decryptionEn() {
        char letter;
        int key = 0;
        int reedLetter = 0;
        int newPosition = 0;

        System.out.println("Укажите полной путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String fileName = null;
        BufferedReader bufferedReader = null;
        try {
            fileName = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            decryptionEn();
        }
        StringBuilder newString = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            decryptionEn();

        }

        while (true) {
            try {
                if (!((reedLetter = bufferedReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) reedLetter;
            if (ChooseLanguage.Alphabet.enAlphabet.contains(letter)) {
                int origPosition = ChooseLanguage.Alphabet.enAlphabet.indexOf(letter);
                if (origPosition < key) {
                    newPosition = origPosition - key + ChooseLanguage.Alphabet.enAlphabet.size();
                } else {
                    newPosition = (origPosition - key);
                }
                char newLetter = ChooseLanguage.Alphabet.enAlphabet.get(newPosition);
                newString.append(newLetter);
            } else newString.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            String copyFileName = fileName;
            fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_decryption"
                    + fileName.substring((fileName.lastIndexOf('.'))));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write(newString.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("____________________________");
        System.out.println("Расшифровка выполнена успешно " + "\u2705");
        System.out.println("Файл с расшифрованным текстом успешно создан " + "\u2705");
    }
}
