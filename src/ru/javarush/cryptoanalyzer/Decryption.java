package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Decryption {
    public static void decryption_ru() {
        char letter;
        int key = 0;
        int a = 0;
        int new_position = 0;

        System.out.println("Укажите полный путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String file_name = null;
        BufferedReader bufferedReader = null;
        try {
            file_name = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует");
            decryption_ru();
        }
        StringBuilder new_string = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            decryption_ru();

        }

        while (true) {
            try {
                if ((a = bufferedReader.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) a;
            if (ChooseLanguage.Alphabet.ru_alphabet.contains(letter)){
                int orig_position = ChooseLanguage.Alphabet.ru_alphabet.indexOf(letter);
                if (orig_position < key){
                    new_position = orig_position - key + ChooseLanguage.Alphabet.ru_alphabet.size();
                }
                else {new_position = (orig_position - key);}
                char new_letter = ChooseLanguage.Alphabet.ru_alphabet.get(new_position);
                new_string.append(new_letter);
            }
            else new_string.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_name + "_decryption");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write(new_string.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decryption_en() {
        char letter;
        int key = 0;
        int a = 0;
        int new_position = 0;

        System.out.println("Укажите полной путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String file_name = null;
        BufferedReader bufferedReader = null;
        try {
            file_name = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(file_name));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            decryption_en();
        }
        StringBuilder new_string = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            decryption_en();

        }

        while (true) {
            try {
                if (!((a = bufferedReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) a;
            if (ChooseLanguage.Alphabet.en_alphabet.contains(letter)){
                int orig_position = ChooseLanguage.Alphabet.en_alphabet.indexOf(letter);
                if (orig_position < key){
                    new_position = orig_position - key + ChooseLanguage.Alphabet.en_alphabet.size();
                }
                else {new_position = (orig_position - key);}
                char new_letter = ChooseLanguage.Alphabet.en_alphabet.get(new_position);
                new_string.append(new_letter);
            }
            else new_string.append(letter);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file_name + "_decryption");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write(new_string.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
