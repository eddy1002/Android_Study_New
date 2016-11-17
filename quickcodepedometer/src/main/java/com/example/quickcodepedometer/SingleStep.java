package com.example.quickcodepedometer;

/**
 * Created by Cho on 2016-11-17.
 */

public class SingleStep {
    private int step = 0;

    private static SingleStep instance;

    public SingleStep(){
        step = 0;
    }

    public static SingleStep getInstance(){
        if (instance == null)
            instance = new SingleStep();

        return instance;
    }

    public int getStep(){
        return step;
    }

    public void addStep() { step++; }

    public void resetStep() { step = 0; }
}
