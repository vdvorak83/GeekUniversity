package com.geekbrains.oop_lesson.obstacleCourse;

import com.geekbrains.oop_lesson.team.TeamMember;

public abstract class Obstacle {

    private int difficulty;

    public Obstacle(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void goChallenge (TeamMember member){}


}
