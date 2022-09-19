package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BrutForce {
    static int new_position = 0;
    static char letter;
    static int a = 0;

    public static void brut_force_en() throws FileNotFoundException, IOException {

        System.out.println("Укажите полной путь к файлу");

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
        StringBuilder new_string = new StringBuilder();
        ArrayList<Character> repeat = new ArrayList<Character>();

        while ((a = bufferedReader.read()) != -1) {
            letter = (char) a;
            repeat.add(letter);
        }

        for (int i = 0; i < 33; i++) {
            for (Character letter_i: repeat){
                if (ChooseLanguage.Alphabet.en_alphabet.contains(letter_i)){
                    int orig_position = ChooseLanguage.Alphabet.en_alphabet.indexOf(letter_i);
                    if (orig_position < i){
                        new_position = orig_position - i + ChooseLanguage.Alphabet.en_alphabet.size();
                    }
                    else {new_position = (orig_position - i);}
                    char new_letter = ChooseLanguage.Alphabet.en_alphabet.get(new_position);
                    new_string.append(new_letter);
                }
                else new_string.append(letter_i);
            }
            if (new_string.toString().contains(" (") || new_string.toString().contains(") ") || (new_string.toString().contains(". ") && new_string.toString().contains(", "))){
                System.out.println(new_string);
                break;
            }
            new_string.delete(0, new_string.length());
        }
    }

    public static void brut_force_ru() throws FileNotFoundException, IOException {

        System.out.println("Укажите полной путь к файлу");

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
        StringBuilder new_string = new StringBuilder();
        ArrayList<Character> repeat = new ArrayList<Character>();

        while ((a = bufferedReader.read()) != -1) {
            letter = (char) a;
            repeat.add(letter);
        }

        for (int i = 0; i < 33; i++) {
            for (Character letter_i: repeat){
                if (ChooseLanguage.Alphabet.ru_alphabet.contains(letter_i)){
                    int orig_position = ChooseLanguage.Alphabet.ru_alphabet.indexOf(letter_i);
                    if (orig_position < i){
                        new_position = orig_position - i + ChooseLanguage.Alphabet.ru_alphabet.size();
                    }
                    else {new_position = (orig_position - i);}
                    char new_letter = ChooseLanguage.Alphabet.ru_alphabet.get(new_position);
                    new_string.append(new_letter);
                }
                else new_string.append(letter_i);
            }
            if (new_string.toString().contains(". ") || new_string.toString().contains(" (") || new_string.toString().contains(") ") || new_string.toString().contains(", ")){
                System.out.println(new_string);
                break;
            }
            new_string.delete(0, new_string.length());
        }
    }

}
