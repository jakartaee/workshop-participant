package com.eclipse.compoundinterest.bean;

/**
 * Here is the Java Bean for the Compound Interest. The 'result' field is a
 * String so that if any of the input values are out of range, as determined in
 * the CompoundInterest class, then the string 'xxxxx' can be returned.
 *
 * @author Ken Fogel
 */
public class CompoundBean {

    private double principal;
    private double annualInterestRate;
    private double compoundPerTimeUnit;
    private double time;
    private String result;

    public CompoundBean(double principal, double annualInterestRate,
            double compoundPerTimeUnit, double time) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.compoundPerTimeUnit = compoundPerTimeUnit;
        this.time = time;
        this.result = "xxxxx";
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getCompoundPerTimeUnit() {
        return compoundPerTimeUnit;
    }

    public void setCompoundPerTimeUnit(double compoundPerTimeUnit) {
        this.compoundPerTimeUnit = compoundPerTimeUnit;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompoundBean{");
        sb.append("principal=").append(principal);
        sb.append(", annualInterestRate=").append(annualInterestRate);
        sb.append(", compoundPerTimeUnit=").append(compoundPerTimeUnit);
        sb.append(", time=").append(time);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
