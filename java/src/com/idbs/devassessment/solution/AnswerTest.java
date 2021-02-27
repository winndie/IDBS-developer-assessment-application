package com.idbs.devassessment.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void getAnswerAsString() {
        String data;

        data = "{\"xValue\" : 38,\"terms\" : [{ \"power\" : 0,  \"multiplier\" : 9, \"action\" :  \"subtract\"  },{ \"power\" : 2,  \"multiplier\" : 7, \"action\" :  \"subtract\"  },{ \"power\" : 1,  \"multiplier\" : 5, \"action\" :  \"subtract\"  },{ \"power\" : 3,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 5,  \"multiplier\" : 6, \"action\" :  \"subtract\"  },{ \"power\" : 6,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 7,  \"multiplier\" : 3, \"action\" :  \"add\"  },{ \"power\" : 4,  \"multiplier\" : 3, \"action\" :  \"subtract\"  }]}";
        Assertions.assertEquals("312655158493", new Answer(data).getAnswerAsString());

        data = "json:{\"xValue\" : 38,\"terms\" : [{ \"power\" : 0,  \"multiplier\" : 9, \"action\" :  \"subtract\"  },{ \"power\" : 2,  \"multiplier\" : 7, \"action\" :  \"subtract\"  },{ \"power\" : 1,  \"multiplier\" : 5, \"action\" :  \"subtract\"  },{ \"power\" : 3,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 5,  \"multiplier\" : 6, \"action\" :  \"subtract\"  },{ \"power\" : 6,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 7,  \"multiplier\" : 3, \"action\" :  \"add\"  },{ \"power\" : 4,  \"multiplier\" : 3, \"action\" :  \"subtract\"  }]}";
        Assertions.assertEquals("312655158493", new Answer(data).getAnswerAsString());

        data = "numeric:x = 47; y = +2.x^2+5.x^1-9.x^4-4.x^0+7.x^3";
        Assertions.assertEquals("-43185719", new Answer(data).getAnswerAsString());
    }

    @Test
    void getPower() {
        Assertions.assertEquals(Math.pow(3, 5), new Answer("").getPower(3, 5));
    }

    @Test
    void getMultiple() {
        Assertions.assertEquals(3 * 5, new Answer("").getMultiple(3, 5));
    }

    @Test
    void getAddSub() {
        Assertions.assertEquals(3 + 5, new Answer("").getAddSub(true, 3, 5));
        Assertions.assertEquals(3 - 5, new Answer("").getAddSub(false, 3, 5));
    }
}