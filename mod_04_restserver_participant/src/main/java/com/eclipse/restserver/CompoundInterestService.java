package com.eclipse.restserver;

import com.eclipse.restserver.bean.CompoundBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * This is the path to the service method. It follows the Application path in
 * the URL as in
 * http://localhost:8080/Mod_04_RestServer_presenter/services/compoundGet
 */
@Path("compound")
/**
 * This class contains the web service methods. You can have multiple request
 * methods of the same type each in its own class or different types of requests
 * in this file.
 *
 * @author Ken Fogel
 */
public class CompoundInterestService {

    @Inject
    private CompoundBean compoundBean;

    // Keep the 'result' to 2 decimal places
    private final NumberFormat numberFormat;

    /**
     * Initialize and configure the numberFormat object
     */
    public CompoundInterestService() {
        numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    /**
     * This method can receive the value from a query string.The annotation
     * {@literal @}QueryParam("principal") indicates that the query string is
     * expected to have a "principal=" as in
     * http://localhost:8080/Mod_04_RestServer_presenter/services/compoundGet?principal=100.00&annualInterestRate=0.05&compoundPerTimeUnit=12.0&time=5.0
     * You can use the line above minus the asterisk in a web browser. If you
     * are using curl the text beginning with http until the URL must be in
     * quotation marks. This is necessary due to the decimal points. curl
     * "http://localhost:8080/Mod_04_RestServer_presenter/services/compoundGet?principal=100.00&annualInterestRate=0.05&compoundPerTimeUnit=12.0&time=5.0"
     *
     * @param principal
     * @param annualInterestRate
     * @param compoundPerTimeUnit
     * @param time
     * @return The CompoundBean with the input and the result.
     */
    @GET // Request Type
    public CompoundBean sayCompoundInterest(
            @QueryParam("principal") double principal,
            @QueryParam("annualInterestRate") double annualInterestRate,
            @QueryParam("compoundPerTimeUnit") double compoundPerTimeUnit,
            @QueryParam("time") double time) {

        // ToDo
        return compoundBean;
    }

    /**
     * This method is a POST service. It expects to receive an object of type
     * CompoundBean and then returns that bean after the calculation and the
     * result is added to the bean. As this method is annotated with a REST
     * annotation, @POST, the conversion from JSON to Object and then Object to
     * JSON is performed automatically.
     *
     * You cannot test a POST method from a browser. You must use cURL.
     *
     * Using cURL: The following is a single line. Remove the asterisks and turn
     * into a single line that can be run at the command line.
     *
     * Windows: Note: Do not use curl that is included in Windows\PowerShell
     * curl -i -X POST --header "Content-Type: application/json" --data
     * "{ \"principal\": 100.00, \"annualInterestRate\": 0.05,
     * \"compoundPerTimeUnit\": 12.0, \"time\": 5.0, \"result\": \"0.0\" }"
     * http://localhost:8080/Mod_04_RestServer_presenter/services/compound
     *
     * Linux/MacOS: 
     * curl -i -X POST --header "Content-Type: application/json" --data 
     * '{ "principal": 100.00, "annualInterestRate": 0.05, 
     * "compoundPerTimeUnit": 12.0, "time": 5.0, "result": "0.0" }' 
     * http://localhost:8080/Mod_04_RestServer_presenter/services/compound
     *
     * @param compoundBean a CompoundBean object received as JSON and converted
     * to an object
     * @return the JSON serialization of the CompoundBean object
     */
    // Request method type
    @POST
    public CompoundBean postCompoundInterest(CompoundBean compoundBean) {
        calculateCompoundInterest(compoundBean);
        return compoundBean;
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
     * Here we validate the four fields in the CompoundBean. Returns false if
     * principal is less than or equal to 0, interest rate is less than or equal
     * to 0 or more than or equal to 1, time less than or equal to 0
     *
     * @param compoundBean The data to be validated
     * @return Were all the fields in the CompoundBean valid? true or false
     */
    private boolean validateBean(CompoundBean compoundBean) {
        
        // ToDo
        
        return false; // ToDo
    }
}
