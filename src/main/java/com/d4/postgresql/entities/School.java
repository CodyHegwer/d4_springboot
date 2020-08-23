package com.d4.postgresql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}