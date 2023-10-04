package com.eclipse.unittest;

import com.eclipse.compoundinterest.CompoundInterest;
import com.eclipse.compoundinterest.bean.CompoundBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This is a JUnit5 parameterized test class. In this workshop you are required
 * to write the necessary methods in the CompoundInterest.java file such that
 * all tests pass. As it is presented, only values out of range result in being
 * Invalid. Consider how you might deal with invalid numbers such as 'bob'.
 *
 * There is no absolute answer, only answers that can pass the unit tests.
 *
 * @author Ken Fogel
 */
public class ParameterizedTests {

    private CompoundInterest calc;
    private CompoundBean data;

    /**
     * Before each run of a test this method is called to create a new instance
     * of the CompoundInterest object
     */
    @BeforeEach
    public void init() {
        calc = new CompoundInterest();
    }

    /**
     * The list of values to use in testing organized in CSV format and the
     * method to use for each test.
     * 
     * Select the CsvSource based on what the decimal point is in your locale
     *
     */
    @ParameterizedTest
    // Decimal point is a period
    @CsvSource(delimiter = '|', textBlock = """
        100.0 | 0.05 | 12.0 | 5.0 | 128.34
        234.0 | 0.08 | 12.0 | 3.0 | 297.24
        1233.0 | 0.03 | 12.0 | 10.0 | 1663.75
        34.0 | 0.13 | 12.0 | 6.0 | 73.86
        -1.0 | 0.05 | 12.0 | 5.0 | xxxxx
        100.0 | -1.0 | 12.0 | 5.0| xxxxx
        100.0 | 0.05 | -1.0 | 5.0 | xxxxx
        100.0 | 0.05 | 12.0 | -1.0 | xxxxx
    """)
    // Decimal point is a comma
//    @CsvSource(delimiter = '|', textBlock = """
//        100,0 | 0,05 | 12,0 | 5,0 | 128,34
//        234,0 | 0,08 | 12,0 | 3,0 | 297,24
//        1233,0 | 0,03 | 12,0 | 10,0 | 1663,75
//        34,0 | 0,13 | 12,0 | 6,0 | 73,86
//        -1,0 | 0,05 | 12,0 | 5,0 | xxxxx
//        100,0 | -1,0 | 12,0 | 5,0| xxxxx
//        100,0 | 0,05 | -1,0 | 5,0 | xxxxx
//        100,0 | 0,05 | 12,0 | -1,0 | xxxxx
//    """)

    /**
     * This method is called for each line in the CsvSource. It creates a Java
     * Bean from the data and passes it to the calculateCompoundInterest method.
     * It then asserts that the result calculated matches the expected result.
     */
    public void knownValueLoanCalculationTest_param(ArgumentsAccessor args) {
        data = buildBean(args);
        calc.calculateCompoundInterest(data);
        assertEquals(args.getDouble(4), data.getResult());
    }

    /**
     * While each line in CsvSource has 5 values, only the first four are
     * assigned to the bean as the fifth value is the expected result and will
     * be filled in by calculateCompoundInterest.
     *
     * @param args a row of data from CsvSource
     * @return a CompoundBean object with the test data
     */
    private CompoundBean buildBean(ArgumentsAccessor args) {
        return new CompoundBean(args.getDouble(0),
                args.getDouble(1),
                args.getDouble(2),
                args.getDouble(3)
        );
    }
}
