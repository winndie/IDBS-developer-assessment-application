/*
 * Copyright (C) 1993-2020 ID Business Solutions Limited
 * All rights reserved
 */
package com.idbs.devassessment.solution;

import com.idbs.devassessment.core.DifficultyLevel;
import com.idbs.devassessment.core.IDBSSolutionException;

/**
 * Example solution for the example question
 */

public class CandidateSolution extends CandidateSolutionBase {
    @Override
    public DifficultyLevel getDifficultyLevel() {
        return DifficultyLevel.LEVEL_2;
    }

    @Override
    public String getAnswer() throws IDBSSolutionException {

        String data = getDataForQuestion();

        if(data == null || data.length()==0) {
            throw new IDBSSolutionException();
        }

        return new Answer(data).getAnswerAsString();
    }
}
