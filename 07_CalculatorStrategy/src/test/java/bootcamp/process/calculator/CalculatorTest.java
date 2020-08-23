package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.process.element.ProcessingElement;
import bootcamp.process.element.impl.ElementFactoryImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void shouldCalculateTheResult() {
        Params params = new Params(new BigDecimal(8000), new BigDecimal(8000), "+");
        ElementFactoryImpl factory = new ElementFactoryImpl();
        Optional<ProcessingElement> adder = factory.create("+");
        Optional<BigDecimal> value = Optional.ofNullable(adder.get().process(params.getX(), params.getY()));
        Calculator calculator = new Calculator(factory);
        Result result = new Result(Status.SUCCESS, "Here is your result:", value);
//        assertEquals(new BigDecimal(16000), result.getValue().get());
        assertEquals(calculator.calculate(params), result);
    }

}

























