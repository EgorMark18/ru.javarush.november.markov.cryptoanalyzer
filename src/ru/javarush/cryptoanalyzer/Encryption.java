package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Encryption {

    public static void encryption_ru() throws FileNotFoundException, IOException {
        char letter;
        int key = 0;
        int a = 0;

        System.out.println("\n" + "Укажите полный путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String file_name = null;
        BufferedReader bufferedReader = null;
        try {
            file_name = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(file_name));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            encryption_ru();
        }
        StringBuilder new_string = new StringBuilder();

        System.out.println("\n" + "Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            encryption_ru();

        }

        while ((a = bufferedReader.read()) != -1) {
            letter = (char) a;
            if (ChooseLanguage.Alphabet.ru_alphabet.contains(letter)){
                int orig_position = ChooseLanguage.Alphabet.ru_alphabet.indexOf(letter);
                int new_position = (orig_position + key) % ChooseLanguage.Alphabet.ru_alphabet.size();
                char new_letter = ChooseLanguage.Alphabet.ru_alphabet.get(new_position);
                new_string.append(new_letter);
            }
                else new_string.append(letter);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file_name + "_cipher");
        fileOutputStream.write(new_string.toString().getBytes(StandardCharsets.UTF_8));
    }
    public static void encryption_en() throws IOException {
        char letter;
        int key = 0;
        int a = 0;

        System.out.println("Укажите полный путь к файлу");

        Scanner scanner = new Scanner(System.in);
        String file_name = null;
        BufferedReader bufferedReader = null;
        try {
            file_name = scanner.nextLine();
            bufferedReader = new BufferedReader(new FileReader(file_name));
        } catch (FileNotFoundException e) {
            System.out.println(" ");
            System.out.println("Такого пути не существует" + "\n" + "\n" + "____________________" + "\n");
            encryption_en();
        }
        StringBuilder new_string = new StringBuilder();

        System.out.println("Укажите ключ шифрования");
        try {
            key = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Ключ должен быть числом, давайте начнем заново");
            encryption_en();

        }

        while ((a = bufferedReader.read()) != -1) {
            letter = (char) a;
            if (ChooseLanguage.Alphabet.en_alphabet.contains(letter)){
                int orig_position = ChooseLanguage.Alphabet.en_alphabet.indexOf(letter);
                int new_position = (orig_position + key) % ChooseLanguage.Alphabet.en_alphabet.size();
                char new_letter = ChooseLanguage.Alphabet.en_alphabet.get(new_position);
                new_string.append(new_letter);
            }
            else new_string.append(letter);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file_name + "_cipher");
        fileOutputStream.write(new_string.toString().getBytes(StandardCharsets.UTF_8));
    }
}

