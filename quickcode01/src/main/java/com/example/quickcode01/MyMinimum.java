package com.example.quickcode01;

/**
 * Created by 조대웅 on 2016-11-15.
 */

public class MyMinimum extends MyValue {
    public float getValue(int[] A){
        float Min = A[0];
        for (int i = 0; i < A.length; i++){
            if (Min >= A[i])
                Min = A[i];
        }

        return Min;
    }
}
