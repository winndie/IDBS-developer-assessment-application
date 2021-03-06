package com.idbs.devassessment.solution;

import javax.json.JsonObject;
import java.util.Map;
import java.util.HashMap;

public class Monomial {

    private final Map signMap;

    private int power, multiplier;
    private char sign;

    public Monomial() {
        signMap = new HashMap();
        signMap.put("add", "+");
        signMap.put("subtract", "-");
    }

    public Monomial(JsonObject term) {

        this();
        this.power = term.getInt("power");
        this.multiplier = term.getInt("multiplier");
        this.sign = signMap.get(term.getString("action")).toString().charAt(0);
    }

    public Monomial(String term) {

        this();
        this.power = Integer.parseInt(term.substring(term.indexOf("^") + 1));
        this.multiplier = Integer.parseInt(term.substring(1, term.indexOf(".")));
        this.sign = term.charAt(0);
    }

    public static long getPower(long baseValue, int power) {

        long answer = 0;

        if (power == 0) {

            answer = 1;

        } else if (power == 1) {

            answer = baseValue;

        } else if (power > 1) {

            answer = baseValue;
            for (int i = 2; i <= power; i++) {
                answer = getMultiple(answer, (int) baseValue);
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

    public long getAsLong(long xValue) {
        return Long.parseLong(sign + String.valueOf(getMultiple(
                getPower(xValue, power), multiplier)));
    }
}