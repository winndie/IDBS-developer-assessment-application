package com.idbs.devassessment.solution;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class Polynomial {

    private final String jsonStart = "{";
    private final String jsonEnd = "}";
    private final String jsonPrefix = "json:";
    private final String numericPrefix = "numeric:";

    private String json, data;

    public Polynomial(String questionData) {

        if (questionData.startsWith(jsonPrefix)) {

            this.json = questionData.substring(jsonPrefix.length());

        } else if (questionData.startsWith(jsonStart) &&
                questionData.endsWith(jsonEnd)) {

            this.json = questionData;

        } else if (questionData.startsWith(numericPrefix)) {

            this.data = questionData.substring(numericPrefix.length());

        }

    }

    public String getAsString() {
        long answer = 0;

        if (json != null) {

            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = reader.readObject();
            reader.close();

            JsonArray terms = jsonObject.getJsonArray("terms");
            int xValue = jsonObject.getInt("xValue");

            for (int i = 0; i < terms.size(); i++) {
                answer += new Monomial(terms.getJsonObject(i)).getAsLong(xValue);
            }
        } else if (data != null) {

            String[] terms = data.substring(data.indexOf("y") + 4).split("(?=[+-])");
            int xValue = Integer.parseInt(data.substring(4, data.indexOf(";")));

            for (String term : terms) {
                answer += new Monomial(term).getAsLong(xValue);
            }
        }

        return Long.toString(answer);
    }

}