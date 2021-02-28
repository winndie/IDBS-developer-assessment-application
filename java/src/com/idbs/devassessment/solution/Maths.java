package com.idbs.devassessment.solution;

public class Maths {
    public static long getPower(long baseValue, int power) {

        long answer = 0;

        if (power == 0) {

            answer = 1;

        } else if (power == 1) {

            answer = baseValue;

        } else if (power > 1) {

            answer = baseValue;

            for (int i = 1; i < power; i++) {

                long powerVal = 0;

                for (int j = 1; j <= baseValue; j++) {
                    if (j == 2) {
                        powerVal = answer;
                    }
                    answer = answer + powerVal;
                }
            }
        }

        return answer;
    }

    public static long getMultiple(long baseValue, int multiplier) {

        long answer = 0;

        for (int i = 1; i <= multiplier; i++) {
            answer = answer + baseValue;
        }

        return answer;
    }

    public static long getAddSub(boolean isAdd, long a, long b) {

        long answer;

        if (isAdd) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }
}
