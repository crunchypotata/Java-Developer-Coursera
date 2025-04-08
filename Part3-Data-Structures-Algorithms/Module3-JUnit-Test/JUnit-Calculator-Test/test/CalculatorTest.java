import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void multiplyNumbers() {
        Calculator calculator = new Calculator();
        double sum = calculator.multiply(2, 3);

        assertEquals(6, sum);

    }
}
