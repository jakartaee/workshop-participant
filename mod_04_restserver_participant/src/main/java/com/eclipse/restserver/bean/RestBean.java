package com.eclipse.restserver.bean;

import jakarta.enterprise.context.RequestScoped;
import java.time.LocalDateTime;

/**
 * Simple Java Bean for a web service. The annotation @RequestScoped implies
 * that this bean will be created by CDI and that its lifetime is a single request.
 */
@RequestScoped
public class RestBean {

    private String name;
    private LocalDateTime theTime;
    private String serviceSource;

    public RestBean() {
        this.name = "";
        theTime = LocalDateTime.now();
        serviceSource = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTheTime() {
        return theTime;
    }

    public void setTheTime(LocalDateTime theTime) {
        this.theTime = theTime;
    }

    public String getServiceSource() {
        return serviceSource;
    }

    public void setServiceSource(String serviceSource) {
        this.serviceSource = serviceSource;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RestBean{");
        sb.append("name=").append(name);
        sb.append(", theTime=").append(theTime);
        sb.append(", serviceSource=").append(serviceSource);
        sb.append('}');
        return sb.toString();
    }    
}
