package com.geekbrains;

import com.geekbrains.obstacleCourse.*;
import com.geekbrains.team.Team;
import com.geekbrains.team.TeamMember;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacle = {new Cross(6), new Swimming(3), new Fight(9),new Jumping(1)};
        Course c = new Course(obstacle); // Создаем полосу препятствий

        TeamMember[] teamMembers = {new TeamMember("Alex",10),new TeamMember("Mike",7),new TeamMember("Duke",4),new TeamMember("Mark",2)};
        Team team = new Team(teamMembers,"DreamTeam"); // Создаем первую команду

        c.doIt(team); // Просим первую команду пройти полосу
        team.showResults(); // Показываем результаты первой команды
    }
}
