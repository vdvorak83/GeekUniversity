package com.geekbrains.RacePackage;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private static AtomicInteger ai;
    static {
        ai = new AtomicInteger(0);
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier barrier;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.barrier = barrier;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            if (ai.incrementAndGet() == 1){
                System.out.println("Winner - " + this.name);
            }
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
