package com.example.quickcode01;

/**
 * Created by 조대웅 on 2016-11-15.
 */

public class MyAverage extends MyValue {
    public float getValue(int[] A){
        float Avg = 0;
        for (int i = 0; i < A.length; i++){
            Avg += A[i];
        }
        Avg = Avg / A.length;

        return Avg; //have
    }
}
