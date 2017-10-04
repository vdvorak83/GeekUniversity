package com.geekbrains.obstacleCourse;

import com.geekbrains.Status;
import com.geekbrains.team.Team;
import com.geekbrains.team.TeamMember;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
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
