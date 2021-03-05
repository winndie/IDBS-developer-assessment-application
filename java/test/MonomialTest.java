import com.idbs.devassessment.solution.Monomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MonomialTest {
    @Test
    void getPower() {
        Assertions.assertEquals(Math.pow(3, 5), Monomial.getPower(3, 5));
    }

    @Test
    void getMultiple() {
        Assertions.assertEquals(3 * 5, Monomial.getMultiple(3, 5));
    }
}