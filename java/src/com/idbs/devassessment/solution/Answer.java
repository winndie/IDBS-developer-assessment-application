package com.idbs.devassessment.solution;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class Answer {

    private final String jsonStart = "{";
    private final String jsonEnd = "}";
    private final String jsonPrefix = "json:";
    private final String numericPrefix = "numeric:";

    private String json, data, answerString;

    public Answer(String questionData) {

        if (questionData.startsWith(jsonPrefix)) {

            this.json = questionData.substring(jsonPrefix.length());

        } else if (questionData.startsWith(jsonStart) &&
                questionData.endsWith(jsonEnd)) {

            this.json = questionData;

        } else if (questionData.startsWith(numericPrefix)) {

            this.data = questionData.substring(numericPrefix.length());

        }

    }

    public String getAnswerAsString() {
        long answer = 0;

        if (json != null) {

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

                answer = Maths.getAddSub(isAdd, answer,
                        Maths.getMultiple(
                                Maths.getPower(xValue, power), multiplier));
            }
        } else if (data != null) {

            String[] terms = data.substring(data.indexOf("y") + 4).split("(?=[+-])");
            int xValue = Integer.parseInt(data.substring(4, data.indexOf(";")));

            for (String term : terms) {

                int power = Integer.parseInt(term.substring(term.indexOf("^") + 1));
                int multiplier = Integer.parseInt(term.substring(1, term.indexOf(".")));
                boolean isAdd = term.charAt(0) == '+';

                answer = Maths.getAddSub(isAdd, answer,
                        Maths.getMultiple(
                                Maths.getPower(xValue, power), multiplier));
            }
        }

        answerString = Long.toString(answer);

        return answerString;
    }

}