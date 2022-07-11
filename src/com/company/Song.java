package com.company;

import java.util.Random;

public class Song {
    private String title;
    private double duration;


    public Song(String title) {
        this.title = title;
        this.duration = duration();
    }


    public String getTitle() {
        return title;
    }


    public double getDuration() {
        return duration;
    }


    private double duration() {
        Random random = new Random();
        double randomValue = 2 + (5 - 2) * random.nextDouble();

        if (validTime(randomValue)) {
            int time = (int) randomValue;
            randomValue = randomValue - time;
            randomValue *= 100;

            if (randomValue > 60) {
                time += 1;
                randomValue -= 60;

                double result = time + (randomValue/100);
                double round = Math.round(result*100.0)/100.0;
                return round;
            }else {
                double result = time + (randomValue/100);
                double round = Math.round(result*100.0)/100.0;
                return round;
            }
        }
        return -1;
    }


    private boolean validTime(double duration){
        if (duration > 10){
            return false;
        }else if (duration < 1){
            return false;
        }
        return true;
    }


}
