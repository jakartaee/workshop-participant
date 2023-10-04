package com.eclipse.restsebootstrap;

import com.eclipse.restsebootstrap.entities.CompoundBeanEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.text.NumberFormat;
import java.util.logging.Level;

import java.util.logging.Logger;

/**
 * This class contains the web service method for GET.
 *
 * @author Ken Fogel
 */
// This is the path to the service method. It follows the Application path in 
// the URL as in http://localhost:8080/services/compound
@Path("compound")
public class CompoundInterestService {

    // Whether you use it or not, consider always declaring a logger.
    private static final Logger LOG = Logger.getLogger(
            CompoundInterestService.class.
                    getName());

    // Keep the 'result' to 2 decimal places
    private final NumberFormat numberFormat;

    /**
     * Initialize and configure the numberFormat object
     */
    public CompoundInterestService() {
        numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    /**
     * This method can receive the value from a query string.The annotation
     * {@literal @}QueryParam("principle") indicates that the query string is
     * expected to have a "?principle=" as in
     * http://localhost:8080/services/compound?principal=100.00&annualInterestRate=0.05&compoundPerTimeUnit=12.0&time=5.0
     * You can use the line above minus the asterisk in a web browser. If you
     * are using curl the text beginning with http until the URL must be in
     * quotation marks. This is necessary due to the decimal points. curl
     * "http://localhost:8080/services/compound?principal=100.00&annualInterestRate=0.05&compoundPerTimeUnit=12.0&time=5.0"
     *
     * @param principal
     * @param annualInterestRate
     * @param compoundPerTimeUnit
     * @param time
     * @return A string that displays the result
     */
    // Request method type
    @GET
    public String sayCompoundInterest(@QueryParam("principal") double principal,
            @QueryParam("annualInterestRate") double annualInterestRate,
            @QueryParam("compoundPerTimeUnit") double compoundPerTimeUnit,
            @QueryParam("time") double time) {

        // ToDo

    }

    /**
     * Here is the method that calculates the result. If any of the fields in
     * the CompoundBeanEntity are out of range then the 'result' field is set to
     * "xxxxx".
     *
     * @param compoundBeanEntity The data to be used in the calculation
     */
    public void calculateCompoundInterest(CompoundBeanEntity compoundBeanEntity) {
        if (validateBean(compoundBeanEntity)) {
            double ans = compoundBeanEntity.getPrincipal()
                    * Math.pow(1 + compoundBeanEntity.getAnnualInterestRate()
                            / compoundBeanEntity.getCompoundPerTimeUnit(),
                            compoundBeanEntity.
                                    getTime() * compoundBeanEntity.
                                    getCompoundPerTimeUnit());
            compoundBeanEntity.setResult(numberFormat.format(ans));
        } else {
            compoundBeanEntity.setResult("xxxxx");
        }
    }

    /**
     * Here we validate the four fields in the CompoundBeanEntity.
     *
     * @param compoundBeanEntity The data to be validated
     * @return Were all the fields in the CompoundBean valid? true or false
     */
    private boolean validateBean(CompoundBeanEntity compoundBeanEntity) {
        boolean valid = true;
        if (compoundBeanEntity.getPrincipal() <= 0 || compoundBeanEntity.
                getAnnualInterestRate() <= 0 || compoundBeanEntity.
                        getAnnualInterestRate() >= 1 || compoundBeanEntity.
                        getTime() <= 0 || compoundBeanEntity.
                        getCompoundPerTimeUnit() <= 0) {
            valid = false;
        }
        return valid;
    }

    /**
     * This method creates an EntityManager based on the persistence.xml
     * configuration. Once created it can now store the entity into the
     * database.
     *
     * @param compoundBeanEntity
     */
    private void storeResult(CompoundBeanEntity compoundBeanEntity) {
        
        // ToDo
    }
}
