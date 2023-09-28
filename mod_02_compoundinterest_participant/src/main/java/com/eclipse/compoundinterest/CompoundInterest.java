package com.eclipse.compoundinterest;

import com.eclipse.compoundinterest.bean.CompoundBean;
import java.text.NumberFormat;
import java.util.logging.Logger;

/**
 * The calculation for compound interest. The input can come from a Java Bean
 * with a field set aside for the result or as a Record but with the result as
 * the returned value. There is no absolute answer, you only need to pass all
 * tests. Feel free to replace this with your solution.
 *
 * @author Ken Fogel
 */
public class CompoundInterest {

    // Keep the 'result' to 2 decimal places
    private final NumberFormat numberFormat;

    /**
     * Initialize and configure the numberFormat object
     */
    public CompoundInterest() {
        numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    /**
     * Here is the method that calculates the result. If any of the fields in
     * the CompoundBean are out of range then the 'result' field is set to
     * 'Invalid'.
     *
     * @param compoundBean The data to be used in the calculation
     */
    public void calculateCompoundInterest(CompoundBean compoundBean) {

        // ToDo
    }

    /**
     * Here we validate the four fields in the CompoundBean. If any fail
     * validation then the result field of the CompoundBean will be set to
     * 'invalid'
     *
     * @param compoundBean The data to be validated
     * @return Were all the fields in the CompoundBean valid? true or false
     */
    private boolean validateBean(CompoundBean compoundBean) {

        // ToDo
        return true; // replace with your return value
    }
}
