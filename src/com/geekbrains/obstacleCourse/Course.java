package com.geekbrains.obstacleCourse;

import com.geekbrains.Status;
import com.geekbrains.team.Team;
import com.geekbrains.team.TeamMember;

public class Course implements Obstacle{
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    @Override
    public void doIt(Team team) {
        for (TeamMember member: team.getMembers()) {
            member.setStatus(Status.PassedDistance);
        }
    }

}
