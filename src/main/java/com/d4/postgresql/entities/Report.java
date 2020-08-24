package com.d4.postgresql.entities;

import com.d4.postgresql.entities.enums.Reason;
import com.d4.postgresql.entities.enums.ResourceType;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "reports")
public class Report implements Serializable {

    public Report() {}

    public Report(Report copy) {
        this.id = copy.getId();
        this.resourceId = copy.getResourceId();
        this.reason = copy.getReason();
        this.resourceType = copy.getResourceType();
        this.description = copy.getDescription();
        this.submitDate = copy.getSubmitDate();
    }

    @Id
    private String id;

    @Column(name="resource_id")
    private String resourceId;

    @Enumerated(EnumType.STRING)
    @Column(name="reason")
    private Reason reason;

    @Enumerated(EnumType.STRING)
    @Column(name="resource_type")
    private ResourceType resourceType;

    @Column(name="description")
    private String description;

    @Column(name="submit_date")
    private Instant submitDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="ip")
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Instant submitDate) {
        this.submitDate = submitDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
