
package com.example.vvce.jarfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void additionTest() {
        assertEquals(30.0, 20.0 + 10.0);
    }

    @Test
    public void subtractionTest() {
        assertEquals(10.0, 20.0 - 10.0);
    }

    @Test
    public void multiplicationTest() {
        assertEquals(200.0, 20.0 * 10.0);
    }

    @Test
    public void divisionTest() {
        assertEquals(2.0, 20.0 / 10.0);
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> {
            int a = 10;
            int b = 0;
            int result = a / b;
        });
    }
}
