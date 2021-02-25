/*
 * Copyright (C) 1993-2020 ID Business Solutions Limited
 * All rights reserved
 */
package com.idbs.devassessment.solution;

import com.idbs.devassessment.core.DifficultyLevel;
import com.idbs.devassessment.core.IDBSSolutionException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

/**
 * Example solution for the example question
 */

public class CandidateSolution extends CandidateSolutionBase {
    @Override
    public DifficultyLevel getDifficultyLevel() {
        return DifficultyLevel.LEVEL_2;
    }

    private long getPower(int power, long baseValue) {

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
                    if (j == 1) {
                        powerVal = 0;
                    } else if (j == 2) {
                        powerVal = answer;
                    }
                    answer = answer + powerVal;
                }
            }
        }

        return answer;
    }

    private long getMultiple(int multiplier, long baseValue) {

        long answer = 0;

        for (int i = 1; i <= multiplier; i++) {
            answer = answer + baseValue;
        }

        return answer;
    }

    private long getAddSub(boolean isAdd, long a, long b) {

        long answer;

        if (isAdd) {
            answer = a + b;
        } else {
            answer = a - b;
        }

        return answer;
    }

    private long getAnswerFromJson(String json) {

        long answer = 0;

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        JsonArray terms = jsonObject.getJsonArray("terms");
        int xValue = jsonObject.getInt("xValue");

        for (int i = 0; i < terms.size(); i++) {

            int power = terms
                    .getJsonObject(i).getInt("power");
            int multiplier = terms
                    .getJsonObject(i).getInt("multiplier");
            boolean isAdd = terms
                    .getJsonObject(i).getString("action").equals("add");

            answer = getAddSub(isAdd, answer
                    , getMultiple(multiplier
                            , getPower(power, xValue)));
        }

        return answer;
    }

    private long getAnswerFromNumeric(String data) {

        long answer = 0;

        String[] terms = data.substring(data.indexOf("y") + 4).split("(?=[+-])");
        int xValue = Integer.parseInt(data.substring(4, data.indexOf(";")));

        for (String term : terms) {

            int power = Integer.parseInt(term.substring(term.indexOf("^") + 1));
            int multiplier = Integer.parseInt(term.substring(1, term.indexOf(".")));
            boolean isAdd = term.charAt(0) == '+';

            answer = getAddSub(isAdd, answer
                    , getMultiple(multiplier
                            , getPower(power, xValue)));
        }

        return answer;
    }

    @Override
    public String getAnswer() throws IDBSSolutionException {

        long answer;
        String jsonPrefix = "json:";
        String numericPrefix = "numeric:";
        String data = getDataForQuestion();

        if (data.startsWith(jsonPrefix)) {
            answer = getAnswerFromJson(data.substring(jsonPrefix.length()));
        } else if (data.startsWith(numericPrefix)) {
            answer = getAnswerFromNumeric(data.substring(numericPrefix.length()));
        } else {
            answer = getAnswerFromJson(data);
        }

        return Long.toString(answer);
    }

}
