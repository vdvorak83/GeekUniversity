package com.geekbrains.oop_lesson.team;

import com.geekbrains.oop_lesson.Status;

public class TeamMember {
    private Status status = Status.NoPassedDistance;
    private String nameTeamMember;
    private int power;

    public TeamMember(String nameTeamMember, int power) {
        this.nameTeamMember = nameTeamMember;
        this.power = power;
    }

    public Status getStatus() {
        return status;
    }

    public String getNameTeamMember() {
        return nameTeamMember;
    }

    public void fight(int courseDifficulty){
        if (checkPower(courseDifficulty)){
            changeStatus(Status.PassedDistance," победил в бою");
        }
        else{
            changeStatus(Status.NoPassedDistance," проиграл в бою");
        }
    }

    public void jump(int courseDifficulty){
        if (checkPower(courseDifficulty)){
            changeStatus(Status.PassedDistance," преодолел барьер");
        }
        else{
            changeStatus(Status.NoPassedDistance," не преодолел барьер");
        }
    }

    public void run(int courseDifficulty){
        if (checkPower(courseDifficulty)){
            changeStatus(Status.PassedDistance," пробежал кросс");
        }
        else{
            changeStatus(Status.NoPassedDistance,"  не пробежал кросс");
        }
    }

    public void swimm(int courseDifficulty){
        if (checkPower(courseDifficulty)){
            changeStatus(Status.PassedDistance," проплыл дистаницию");
        }
        else{
            changeStatus(Status.NoPassedDistance," не проплыл дистаницию");
        }
    }

    private boolean checkPower(int courseDifficulty){
        return power > courseDifficulty || power == courseDifficulty;
    }

    private void changeStatus(Status newStatus,String message){
        status = newStatus;
        System.out.println(nameTeamMember + message);
    }

}
