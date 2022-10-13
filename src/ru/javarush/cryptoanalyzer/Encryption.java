package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Encryption {

    public static void encryptionRu() {
        char letter;
        int key = 0;
        int reedLetter = 0;

        System.out.println("" + "\n" + "Укажите полный путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String fileName = null;
        BufferedReader bufferedReader = null;
        try {
            fileName = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            encryptionRu();
        }
        StringBuilder newString = new StringBuilder();

        System.out.println("\n" + "Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            encryptionRu();

        }

        while (true) {
            try {
                if (!((reedLetter = bufferedReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) reedLetter;
            if (ChooseLanguage.Alphabet.ruAlphabet.contains(letter)) {
                int origPosition = ChooseLanguage.Alphabet.ruAlphabet.indexOf(letter);
                int newPosition = (origPosition + key) % ChooseLanguage.Alphabet.ruAlphabet.size();
                char newLetter = ChooseLanguage.Alphabet.ruAlphabet.get(newPosition);
                newString.append(newLetter);
            } else newString.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_cipher"
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
        System.out.println("Шифрование выполнено успешно " + "\u2705");
        System.out.println("Файл с зашифрованным успешно создан " + "\u2705");
    }

    public static void encryptionEn() {
        char letter;
        int key = 0;
        int reedLetter = 0;

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
            encryptionEn();
        }
        StringBuilder newString = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            encryptionEn();

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
                int newPosition = (origPosition + key) % ChooseLanguage.Alphabet.enAlphabet.size();
                char newLetter = ChooseLanguage.Alphabet.enAlphabet.get(newPosition);
                newString.append(newLetter);
            } else newString.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_cipher"
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
        System.out.println("Шифрование выполнено успешно " + "\u2705");
        System.out.println("Файл с зашифрованным успешно создан " + "\u2705");
    }
}

