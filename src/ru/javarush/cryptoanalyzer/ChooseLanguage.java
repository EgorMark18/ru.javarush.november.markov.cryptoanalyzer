package ru.javarush.cryptoanalyzer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ChooseLanguage {
    static int choose;
    static TreeMap<Integer, Character> alphabet = new TreeMap<Integer, Character>();
    static int a = 0;

    static int number_of_letter;
    static String language;

    public static void language(){
        try {
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Пожалуйста, выберете один из предложенных Вам языков");
        }

        if(choose == 1){
            System.out.println("Вы выбрали русский язык" + "\n" + "_________________________");
            number_of_letter = 32;
            language = "russian";
        }
        else if(choose == 2){
            System.out.println("Вы выбрали английский язык" + "\n" + "_________________________");
            number_of_letter = 25;
            language = "english";
        }
        else {
            if (a == 0) {
                System.out.println("Выбере один из двух языков");
                a++;
                language();
            }
            if (a == 1){
                System.out.println("Найчиво просим Вас выбрать один из двух предложенных языков!");
                a++;
                language();
            }
            else if (a == 2){
                System.out.println("Крайне найчиво просим Вас выбрать один из двух предложенных языков!");
                a++;
                language();
            }
            else if (a == 3){
                System.out.println("Видимо, Вы просто балуетесь, до свидания!");
                a++;
            }

        }
    }


    public static class Alphabet {
        static List<Character> ru_alphabet = Arrays.asList('А','Б','В','Г','Д','Е','Ë','Ж','З','И','Й','К','Л','М','Н','О',
                'П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я','а','б','в','г','д','e','ё','ж','з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я','.',',','"',':','-','!','?',' ','(',')');
        static List<Character> en_alphabet = Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                'P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                'p','q','r','s','t','u','v','w','x','y','z','.',',','"',':','-','!','?',' ','(',')');
    }
}
