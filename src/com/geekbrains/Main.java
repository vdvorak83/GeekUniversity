package com.geekbrains;

import com.geekbrains.obstacleCourse.*;
import com.geekbrains.team.Team;
import com.geekbrains.team.TeamMember;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacle = {new Cross(), new Swimming(), new Fight(),new Jumping()};
        Course c = new Course(obstacle); // Создаем полосу препятствий

        TeamMember[] teamMembers = {new TeamMember("Alex"),new TeamMember("Mike"),new TeamMember("Duke"),new TeamMember("Mark")};
        Team team = new Team(teamMembers,"DreamTeam"); // Создаем первую команду

        c.doIt(team); // Просим первую команду пройти полосу
        team.showResults(); // Показываем результаты первой команды
    }
}
