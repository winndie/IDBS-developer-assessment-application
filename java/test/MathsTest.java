import com.idbs.devassessment.solution.Maths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathsTest {
    @Test
    void getPower() {
        Assertions.assertEquals(Math.pow(3, 5), Maths.getPower(3, 5));
    }

    @Test
    void getMultiple() {
        Assertions.assertEquals(3 * 5, Maths.getMultiple(3, 5));
    }

    @Test
    void getAddSub() {
        Assertions.assertEquals(3 + 5, Maths.getAddSub(true, 3, 5));
        Assertions.assertEquals(3 - 5, Maths.getAddSub(false, 3, 5));
    }
}