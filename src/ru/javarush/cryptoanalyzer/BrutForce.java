package ru.javarush.cryptoanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class BrutForce {
    static int newPosition = 0;
    static char letter;


    public static void brutForceEn() {

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
            brutForceEn();
        }
        StringBuilder newString = new StringBuilder();
        ArrayList<Character> repeat = new ArrayList<Character>();

        while (true) {
            int a;
            try {
                if (!((a = bufferedReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) a;
            repeat.add(letter);
        }

        for (int i = 0; i < 33; i++) {
            for (Character oldLetter : repeat) {
                if (ChooseLanguage.Alphabet.enAlphabet.contains(oldLetter)) {
                    int origPosition = ChooseLanguage.Alphabet.enAlphabet.indexOf(oldLetter);
                    if (origPosition < i) {
                        newPosition = origPosition - i + ChooseLanguage.Alphabet.enAlphabet.size();
                    } else {
                        newPosition = (origPosition - i);
                    }
                    char newLetter = ChooseLanguage.Alphabet.enAlphabet.get(newPosition);
                    newString.append(newLetter);
                } else newString.append(oldLetter);
            }
            int limit = Math.min(300, newString.length());
            if ((newString.substring(0, limit).contains(" (") && (newString.substring(0, limit).contains(") ") || newString.substring(0, limit).contains("). "))) || (newString.substring(0, limit).contains(". ") && newString.substring(0, limit).contains(", "))) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_brutForce"
                            + fileName.substring((fileName.lastIndexOf('.'))));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    fileOutputStream.write(newString.toString().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            newString.delete(0, newString.length());
        }
        System.out.println("____________________________");
        System.out.println("Расшифровка методом Brut Force выполнена успешно " + "\u2705");
        System.out.println("Файл с расшифрованным текстом успешно создан " + "\u2705");
    }

    public static void brutForceRu() {

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
            brutForceEn();
        }
        StringBuilder newString = new StringBuilder();
        ArrayList<Character> repeat = new ArrayList<Character>();

        while (true) {
            int a;
            try {
                if (!((a = bufferedReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            letter = (char) a;
            repeat.add(letter);
        }

        for (int i = 0; i < 33; i++) {
            for (Character oldLetter : repeat) {
                if (ChooseLanguage.Alphabet.ruAlphabet.contains(oldLetter)) {
                    int origPosition = ChooseLanguage.Alphabet.ruAlphabet.indexOf(oldLetter);
                    if (origPosition < i) {
                        newPosition = origPosition - i + ChooseLanguage.Alphabet.ruAlphabet.size();
                    } else {
                        newPosition = (origPosition - i);
                    }
                    char newLetter = ChooseLanguage.Alphabet.ruAlphabet.get(newPosition);
                    newString.append(newLetter);
                } else newString.append(oldLetter);
            }
            int limit = Math.min(300, newString.length());
            if ((newString.substring(0, limit).contains(" (") && (newString.substring(0, limit).contains(") ") || newString.substring(0, limit).contains("). "))) || (newString.substring(0, limit).contains(". ") && newString.substring(0, limit).contains(", "))) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(fileName.substring(0, (fileName.lastIndexOf('.'))) + "_brutForce"
                            + fileName.substring((fileName.lastIndexOf('.'))));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    fileOutputStream.write(newString.toString().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            newString.delete(0, newString.length());
        }
        System.out.println("____________________________");
        System.out.println("Расшифровка методом Brut Force выполнена успешно " + "\u2705");
        System.out.println("Файл с расшифрованным текстом успешно создан " + "\u2705");
    }

}
