package com.geekbrains.oop_lesson.team;

import com.geekbrains.oop_lesson.Status;

public class Team {
    private TeamMember[] members;
    private final String nameTeam;

    public Team(String nameTeam, TeamMember... members) {
        this.members = members;
        this.nameTeam = nameTeam;
    }

    public void showResults(){
        divider();
        System.out.println("Полосу препятствий преодолевала команда: " + nameTeam);
        for (TeamMember member:members) {
            if (member.getStatus()== Status.NoPassedDistance){
                showResultMemberNoPassed(member);
            }
            else {showResultMemberPassed(member);}
        }
        divider();
    }

    private void showResultMemberNoPassed(TeamMember member) {
        divider();
        System.out.println(member.getNameTeamMember() + " Не прошел полосу препятствий");
    }

    private void showResultMemberPassed(TeamMember member){
        divider();
        System.out.println(member.getNameTeamMember() + " Успешно прошел полосу препятствий");
    }

    public TeamMember[] getMembers() {
        return members;
    }

    private void divider(){
        System.out.println("-----------------------------------------------------------");
    }
}
