package com.geekbrains;

import com.geekbrains.Collections_lesson.PhoneBook;
import com.geekbrains.Collections_lesson.WordsArray;
import com.geekbrains.Exception_lesson.ArrayChecker;
import com.geekbrains.GUI.MainChatWindow;
import com.geekbrains.NetProgramming.Client.ClientLauncher;
import com.geekbrains.NetProgramming.Server.ServerLauncher;
import com.geekbrains.oop_lesson.obstacleCourse.*;
import com.geekbrains.oop_lesson.team.Team;
import com.geekbrains.oop_lesson.team.TeamMember;
import com.geekbrains.MultiThreading.*;


public class Main {

    public static void main(String[] args) {
        doLesson_6();
    }

    private static void doLesson_6() {
        // run two methods in class ClientLauncher and ServerLauncher
    }

    private static String[] createArrayWords() {
        String [] strings = new String[10];
        strings[0] = "Mama";
        strings[1] = "Papa";
        strings[2] = "Puma";
        strings[3] = "Irbis";
        strings[4] = "Mama";
        strings[5] = "Papa";
        strings[6] = "Kot";
        strings[7] = "Sobaka";
        strings[8] = "Dochka";
        strings[9] = "Sobaka";
        return strings;
    }

    private static void doPhoneBook(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addElementPhoneBook("Shum","89670049109");
        phoneBook.addElementPhoneBook("Shum","89670049110");
        phoneBook.addElementPhoneBook("Shum","89670049111");

        phoneBook.addElementPhoneBook("Art","888888");
        phoneBook.addElementPhoneBook("Art","888888");
        phoneBook.addElementPhoneBook("Art","888888   ");
        phoneBook.addElementPhoneBook("Art","888  88 8 ");
        phoneBook.addElementPhoneBook("Art","8  8  8 888     ");

        System.out.println("Shum: " + phoneBook.getPhonesByName("Shum"));
        System.out.println("Art: " + phoneBook.getPhonesByName("Art"));
        System.out.println("Alex: " + phoneBook.getPhonesByName("Alex"));
        System.out.println("Nikto:" + phoneBook.getPhonesByName(""));
    }

    private static String[][] createArray() {
        String[][] array = new String[4][4];
        for (int i = 0; i < array.length; i++,System.out.println()) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf((int)(Math.random() * 10));
                System.out.print(array[i][j] + " ");
            }
        }
        return array;
    }

    private static void doLesson_1 (){
        Obstacle[] obstacle = {new Cross(6), new Swimming(3), new Fight(9),new Jumping(1)};
        Course c = new Course(obstacle); // Создаем полосу препятствий

        Team team =
                new Team("DreamTeam",
                        new TeamMember("Alex",10),
                        new TeamMember("Mike",7),
                        new TeamMember("Duke",4),
                        new TeamMember("Mark",2)); // Создаем первую команду, количество участников не фиксированно.

        c.doIt(team); // Просим первую команду пройти полосу
        team.showResults(); // Показываем результаты первой команды
    }

    private static void doLesson_2(){

        String[][] strings = createArray();
        //strings[2][3]="K";
        ArrayChecker arrayChecker = new ArrayChecker();
        arrayChecker.setStrings(strings);

        arrayChecker.summ();
    }

    private static void doLesson_3() {
        doPhoneBook();
        WordsArray wordsArray = new WordsArray(createArrayWords());
        wordsArray.doArrayWords();
    }

    private static void doLesson_4(){
        MainChatWindow chatWindow = new MainChatWindow();
    }

    private static void doLesson_5() {
        MultiThreadingCalculate multiThreadingCalculate = new MultiThreadingCalculate();
        multiThreadingCalculate.oneThreadCalculate();
        multiThreadingCalculate.twoThreadsCalculate();
    }
}

