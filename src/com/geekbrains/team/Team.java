package com.geekbrains.team;

import com.geekbrains.Status;

public class Team {
    private TeamMember[] members;
    private final String nameTeam;

    public Team(TeamMember[] members, String nameTeam) {
        this.members = members;
        this.nameTeam = nameTeam;
    }

    public void showResults(){
        for (TeamMember member:members) {
            if (member.getStatus()== Status.NoPassedDistance){
                showResultMemberNoPassed(member);
            }
            else {showResultMemberPassed(member);}
        }
    }

    private void showResultMemberNoPassed(TeamMember member) {
        System.out.println(member.getNameTeamMember() + " Не прошел полосу препятствий");
    }

    private void showResultMemberPassed(TeamMember member){
        System.out.println(member.getNameTeamMember() + " Успешно прошел полосу препятствий");
    }

    public TeamMember[] getMembers() {
        return members;
    }

}
