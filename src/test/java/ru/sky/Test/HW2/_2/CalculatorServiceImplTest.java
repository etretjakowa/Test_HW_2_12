package ru.sky.Test.HW2._2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sky.Test.HW2._2.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.sky.Test.HW2._2.CalculatorServiceImplTestConstants.*;

@SpringBootTest
class CalculatorServiceImplTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturn3WhenPlus1And2() {
        assertEquals(THREE, out.plus(ONE, TWO));
    }

    @Test
    public void shouldReturn2WhenPlus0And2() {
        assertEquals(TWO, out.plus(ZERO, TWO));
    }

    @Test
    public void shouldReturn0WhenMinus2And2() {
        assertEquals(ZERO, out.minus(TWO, TWO));
    }

    @Test
    public void shouldReturn0WhenMinus2And1() {
        assertEquals(ONE, out.minus(TWO, ONE));
    }

    @Test
    public void shouldReturn0WhenMultiply1And1() {
        assertEquals(ONE, out.multiply(ONE, ONE));
    }

    @Test
    public void shouldReturn0WhenMultiply2And1() {
        assertEquals(TWO, out.multiply(TWO, ONE));
    }

    @Test
    public void shouldReturn0WhenDivide2And2() {
        assertEquals(ONE, out.divide(TWO, TWO));
    }

    @Test
    public void shouldReturn0WhenDivide2And1() {
        assertEquals(TWO, out.divide(TWO, ONE));
    }

    @Test
    public void shouldThrowZeroDivideExceptionWhenDivideAnyNumAnd0() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(TWO, ZERO));
    }
}