package com.geekbrains;

import com.geekbrains.Collections_lesson.PhoneBook;
import com.geekbrains.Exception_lesson.ArrayChecker;
import com.geekbrains.oop_lesson.obstacleCourse.*;
import com.geekbrains.oop_lesson.team.Team;
import com.geekbrains.oop_lesson.team.TeamMember;

public class Main {

    public static void main(String[] args) {
        doLesson_3();
    }

    private static void doLesson_3() {
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

