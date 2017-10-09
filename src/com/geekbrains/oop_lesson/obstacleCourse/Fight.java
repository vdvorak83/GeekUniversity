package com.geekbrains.oop_lesson.obstacleCourse;

import com.geekbrains.oop_lesson.team.TeamMember;

public class Fight extends Obstacle {
    public Fight(int difficulty) {
        super(difficulty);
    }

    @Override
    public void goChallenge(TeamMember member) {
        member.fight(super.getDifficulty());
    }
}
