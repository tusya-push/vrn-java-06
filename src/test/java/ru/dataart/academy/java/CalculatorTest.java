package ru.dataart.academy.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

public class CalculatorTest {

    @Test
    public void testGetNumberOfChar() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = Objects.requireNonNull(classLoader.getResource("test.zip")).getPath();
        assert (Calculator.getNumberOfChar(path, '1').equals(3));
        assert (Calculator.getNumberOfChar(path, '-').equals(2));
        assert (Calculator.getNumberOfChar(path, 'a').equals(0));
    }

    @Test
    public void testGetMaxWordLength() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        assert (Calculator.getMaxWordLength(Objects.requireNonNull(classLoader.getResource("test.zip")).getPath()).equals(2));
        assert (Calculator.getMaxWordLength(Objects.requireNonNull(classLoader.getResource("test1.zip")).getPath()).equals(12));
    }

}
