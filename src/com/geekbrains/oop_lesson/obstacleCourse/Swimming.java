package com.geekbrains.oop_lesson.obstacleCourse;

import com.geekbrains.oop_lesson.team.TeamMember;

public class Swimming extends Obstacle {
    public Swimming(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.swimm(super.getDifficulty());
    }
}
