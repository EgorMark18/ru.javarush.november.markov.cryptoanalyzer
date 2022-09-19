package ru.javarush.cryptoanalyzer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;



public class Main {
    static final String CHOOSE_LANGUAGE = "Выберете язык текста:" + "\n" + "1. Русский" + "\n" + "2. English";
    static final String CHOOSE_MODE = "Выберете режим работы приложения:" + "\n" + "\n" + "1. Шифрование данных" + "\n" + "2. Дешифровка данных" + "\n" + "3. Brut force";

    public static void main(String[] args) {
//        Application.launch(args);
        System.out.println(CHOOSE_MODE);

        int number_of_mode = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            number_of_mode = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Пожалуйста, выберете один из предложенных Вам режимов");

        }

        if (number_of_mode == 1){
            System.out.println("Вы выбрали режим шифрования" + "\n" + "_________________________" + "\n");
            System.out.println(CHOOSE_LANGUAGE);
            ChooseLanguage.language();
                if (ChooseLanguage.language.equals("russian")){
                    Encryption.encryption_ru();
                }
                else {
                    Encryption.encryption_en();
                }
        }
        else if (number_of_mode == 2){
            System.out.println("Вы выбрали режим дешифровки" + "\n" + "_________________________" + "\n");
            System.out.println(CHOOSE_LANGUAGE);
            ChooseLanguage.language();
            if (ChooseLanguage.language.equals("english")){
                Decryption.decryption_en();
            }
            else {
                Decryption.decryption_ru();
            }

        }
        else if (number_of_mode == 3){
            System.out.println("Вы выбрали режим Brut Force" + "\n" + "_________________________" + "\n");
            System.out.println(CHOOSE_LANGUAGE);
            ChooseLanguage.language();
            if (ChooseLanguage.language.equals("english")){
                BrutForce.brut_force_en();
            }
            else {
                BrutForce.brut_force_ru();
            }
        }
        else {
            System.out.println("Выберете один из предложенных вариантов работы приложения");
        }
    }
}
