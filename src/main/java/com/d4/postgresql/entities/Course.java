package com.d4.postgresql.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    public Course() {}

    public Course(Course copy) {
        this.id = copy.getId();
        this.name = copy.getName();
        this.schoolId = copy.getSchoolId();
        this.schoolCourseId = copy.getSchoolCourseId();
    }

    @Id
    private String id;

    @Column(name="school_id")
    private String schoolId;

    @Column(name="school_course_id")
    private String schoolCourseId;

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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCourseId() {
        return schoolCourseId;
    }

    public void setSchoolCourseId(String schoolCourseId) {
        this.schoolCourseId = schoolCourseId;
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