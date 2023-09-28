package com.eclipse.restclient.bean;

// Help stamp out java.util.Date!
import java.time.LocalDateTime;

/**
 * Simple Java Bean for a web service. No annotations are required because this
 * object will be created by jakarta.ws.rs when the JSON string is mapped to the
 * matching object by the ObjectMapper.
 */
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
        return "JSON{" + "name=" + name + ", theTime=" + theTime + ", serviceSource=" + serviceSource + '}';
    }
}
