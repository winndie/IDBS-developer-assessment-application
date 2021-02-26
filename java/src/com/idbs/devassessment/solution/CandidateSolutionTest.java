package com.idbs.devassessment.solution;

import org.junit.jupiter.api.Assertions;

class CandidateSolutionTest {

    CandidateSolution can;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        can = new CandidateSolution();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        can = null;
    }

    @org.junit.jupiter.api.Test
    void getPower() {
        Assertions.assertEquals(Math.pow(3, 5), can.getPower(3, 5));
    }

    @org.junit.jupiter.api.Test
    void getMultiple() {
        Assertions.assertEquals(3 * 5, can.getMultiple(3, 5));
    }

    @org.junit.jupiter.api.Test
    void getAddSub() {
        Assertions.assertEquals(3 + 5, can.getAddSub(true, 3, 5));
    }

    @org.junit.jupiter.api.Test
    void getAnswerFromJson() {
        String json = "{\"xValue\" : 38,\"terms\" : [{ \"power\" : 0,  \"multiplier\" : 9, \"action\" :  \"subtract\"  },{ \"power\" : 2,  \"multiplier\" : 7, \"action\" :  \"subtract\"  },{ \"power\" : 1,  \"multiplier\" : 5, \"action\" :  \"subtract\"  },{ \"power\" : 3,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 5,  \"multiplier\" : 6, \"action\" :  \"subtract\"  },{ \"power\" : 6,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 7,  \"multiplier\" : 3, \"action\" :  \"add\"  },{ \"power\" : 4,  \"multiplier\" : 3, \"action\" :  \"subtract\"  }]}";
        Assertions.assertEquals(Long.valueOf("312655158493"), can.getAnswerFromJson(json));
    }

    @org.junit.jupiter.api.Test
    void getAnswerFromNumeric() {
        String data = "x = 47; y = +2.x^2+5.x^1-9.x^4-4.x^0+7.x^3";
        Assertions.assertEquals(Long.valueOf("-43185719"), can.getAnswerFromNumeric(data));
    }
}