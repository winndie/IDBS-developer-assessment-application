import com.idbs.devassessment.solution.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void getAnswerAsString() {
        String data;

        data = "{\"xValue\" : 38,\"terms\" : [{ \"power\" : 0,  \"multiplier\" : 9, \"action\" :  \"subtract\"  },{ \"power\" : 2,  \"multiplier\" : 7, \"action\" :  \"subtract\"  },{ \"power\" : 1,  \"multiplier\" : 5, \"action\" :  \"subtract\"  },{ \"power\" : 3,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 5,  \"multiplier\" : 6, \"action\" :  \"subtract\"  },{ \"power\" : 6,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 7,  \"multiplier\" : 3, \"action\" :  \"add\"  },{ \"power\" : 4,  \"multiplier\" : 3, \"action\" :  \"subtract\"  }]}";
        Assertions.assertEquals("312655158493", new Polynomial(data).getAsString());

        data = "json:{\"xValue\" : 38,\"terms\" : [{ \"power\" : 0,  \"multiplier\" : 9, \"action\" :  \"subtract\"  },{ \"power\" : 2,  \"multiplier\" : 7, \"action\" :  \"subtract\"  },{ \"power\" : 1,  \"multiplier\" : 5, \"action\" :  \"subtract\"  },{ \"power\" : 3,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 5,  \"multiplier\" : 6, \"action\" :  \"subtract\"  },{ \"power\" : 6,  \"multiplier\" : 10, \"action\" :  \"subtract\"  },{ \"power\" : 7,  \"multiplier\" : 3, \"action\" :  \"add\"  },{ \"power\" : 4,  \"multiplier\" : 3, \"action\" :  \"subtract\"  }]}";
        Assertions.assertEquals("312655158493", new Polynomial(data).getAsString());

        data = "numeric:x = 47; y = +2.x^2+5.x^1-9.x^4-4.x^0+7.x^3";
        Assertions.assertEquals("-43185719", new Polynomial(data).getAsString());
    }
}