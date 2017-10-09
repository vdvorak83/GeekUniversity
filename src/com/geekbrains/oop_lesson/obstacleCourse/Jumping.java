package com.geekbrains.oop_lesson.obstacleCourse;


import com.geekbrains.oop_lesson.team.TeamMember;

public class Jumping extends Obstacle {

    public Jumping(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.jump(super.getDifficulty());
    }
}
