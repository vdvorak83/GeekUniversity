package com.geekbrains.team;

import com.geekbrains.Status;

public class TeamMember {
    private Status status = Status.NoPassedDistance;
    private String nameTeamMember;

    public TeamMember(String nameTeamMember) {
        this.nameTeamMember = nameTeamMember;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNameTeamMember() {
        return nameTeamMember;
    }

    public void setNameTeamMember(String nameTeamMember) {
        this.nameTeamMember = nameTeamMember;
    }
}
