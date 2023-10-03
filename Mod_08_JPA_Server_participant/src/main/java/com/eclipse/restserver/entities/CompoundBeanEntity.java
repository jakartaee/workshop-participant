package com.eclipse.restserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * In this project we are using the Java Persistence API. This requires that our
 * JavaBean is designated as an Entity. It shows the table this bean will be
 * written to and designates the id field as the primary key that will be
 * generated automatically.
 *
 * @author Ken Fogel
 */
@Entity
@Table(name = "calculations")
public class CompoundBeanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double principal;
    private double annualInterestRate;
    private double compoundPerTimeUnit;
    private double time;
    private String result;

    /**
     * Required default constructor
     */
    public CompoundBeanEntity() {
    }

    public CompoundBeanEntity(double principal, double annualInterestRate,
            double compoundPerTimeUnit, double time) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.compoundPerTimeUnit = compoundPerTimeUnit;
        this.time = time;
        this.result = "invalid";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        sb.append("CompoundBeanEntity{");
        sb.append("principal=").append(principal);
        sb.append(", annualInterestRate=").append(annualInterestRate);
        sb.append(", compoundPerTimeUnit=").append(compoundPerTimeUnit);
        sb.append(", time=").append(time);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
