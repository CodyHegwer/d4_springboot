package com.d4.postgresql.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "schools")
public class School implements Serializable {

    public School() {}

    public School(School copy) {
        this.id = copy.getId();
        this.name = copy.getName();
    }

    @Id
    private String id;

    @Column(name="name")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="ip")
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}