package com.eclipse.restserver;

import com.eclipse.restserver.entities.CompoundBeanEntity;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.text.NumberFormat;
import java.util.logging.Level;

import java.util.logging.Logger;

/**
 * This class contains the web service methods. You can have multiple request
 * methods of the same type each in its own class or different types of requests
 * in this file.
 *
 * @author Ken Fogel
 */
// This is the path to the service method. It follows the Application path in 
// the URL as in http://localhost:8080/Mod_08_JPA_Server_participant/services/compound
@Path("compound")
public class CompoundInterestService {

    // Whether you use it or not, consider always declaring a logger.
    private static final Logger LOG = Logger.getLogger(
            CompoundInterestService.class.
                    getName());

    // Keep the 'result' to 2 decimal places
    private final NumberFormat numberFormat;

    // This will inject an EntityManager object 
    @PersistenceContext(unitName = "workshopPU")
    private EntityManager entityManager;

    // This will inject a UserTransaction object
    @Resource
    private UserTransaction utx;

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
     * This method is a POST service. It expects to receive an object of type
     * CompoundBean and then returns that bean after the calculation and the
     * result is added to the bean. As this method is annotated with a REST
     * annotation, @POST, the conversion from JSON to Object and then Object to
     * JSON is performed automatically. To use curl use:
     * curl -i -X POST --header "Content-Type: application/json" --data "{ \"principal\": 100.00, \"annualInterestRate\": 0.05, \"compoundPerTimeUnit\": 12.0, \"time\": 5.0, \"result\": \"0.0\" }" http://localhost:8080/Mod_08_JPA_Server_participant/services/compound
     *
     * @param compoundBeanEntity a CompoundBean object received as JSON and
     * converted to an object
     * @return the JSON serialization of the CompoundBean object
     */
    // Request method type
    @POST
    public CompoundBeanEntity postCompoundInterest(CompoundBeanEntity compoundBeanEntity) {

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
     * Here is the server side JPA code to store a record in the database. 
     * 
     * @param compoundBeanEntity 
     */
    private void storeResult(CompoundBeanEntity compoundBeanEntity) {

        //ToDo
        
    }
}
