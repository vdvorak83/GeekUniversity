package com.geekbrains;

import com.geekbrains.Collections_lesson.PhoneBook;
import com.geekbrains.Collections_lesson.WordsArray;
import com.geekbrains.DataBase_Lesson.ItemHandler;
import com.geekbrains.Exception_lesson.ArrayChecker;
import com.geekbrains.GUI.MainChatWindow;
import com.geekbrains.GenericsPackage.*;
import com.geekbrains.oop_lesson.obstacleCourse.*;
import com.geekbrains.oop_lesson.team.Team;
import com.geekbrains.oop_lesson.team.TeamMember;
import com.geekbrains.MultiThreading.*;

import java.applet.Applet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ItemHandler itemHandler = new ItemHandler();
        try {
            itemHandler.connect();
            //itemHandler.deleteTable();
            //itemHandler.createTable();
            //itemHandler.fillTable();
            //itemHandler.deleteAllItems();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            itemHandler.disconnect();
        }
    }

    private static void doLesson_Fruits() {
        BoxFruit<Apple> appleBox = new BoxFruit<Apple>(1);
        BoxFruit<Orange> orangeBox = new BoxFruit<Orange>(1.5);
        BoxFruit<Apple> appleBox2 = new BoxFruit<Apple>(1);

        for (int i = 0; i < 3; i++) {
            orangeBox.addFruit(new Orange());
            appleBox.addFruit(new Apple());
            appleBox2.addFruit(new Apple());
        }

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        appleBox2.addFruit(new Apple());


        System.out.println("Weight appleBox: " + appleBox.getBoxWeight());
        System.out.println("Weight orangeBox: " + orangeBox.getBoxWeight());
        System.out.println("Weights equals - " + appleBox.compare(orangeBox));
        System.out.println("---------------------------------------------");

        appleBox.addFruits(appleBox2);

    }

    private static void doGenericLesson(){
        //String[] strings = createArrayWords();
        //Generics<String> stringGenerics = new Generics<>(strings);

        Integer[] ints = new Integer[5];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        Generics<Integer> stringGenerics = new Generics<>(ints);

        System.out.println("Before replace");
        stringGenerics.printArray(ints);
        stringGenerics.replaceTwoElements(1, 4);
        System.out.println("------------------------------------");
        System.out.println("After replace");
        stringGenerics.printArray(ints);

        ArrayList<Integer> intsArrayAsList = stringGenerics.convertArrayToArrayList(ints);
        if (intsArrayAsList instanceof ArrayList) System.out.println("Convert completed");
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

    private static void doLesson_6() {
        // run two methods in class ClientLauncher and ServerLauncher
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
}

