package com.geekbrains.oop_lesson.obstacleCourse;

import com.geekbrains.oop_lesson.Status;
import com.geekbrains.oop_lesson.team.Team;
import com.geekbrains.oop_lesson.team.TeamMember;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (TeamMember member: team.getMembers()) {
            for (Obstacle obs :obstacles) {
                obs.goChallenge(member);
                if (member.getStatus()==Status.NoPassedDistance){
                    break;
                }
            }
        }
    }

}
