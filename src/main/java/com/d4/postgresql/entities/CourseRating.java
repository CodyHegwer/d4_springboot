package com.d4.postgresql.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "course_ratings")
public class CourseRating implements Serializable {

    public CourseRating() {}

    public CourseRating(CourseRating copy) {
        this.id = copy.getId();
        this.courseId = copy.getCourseId();
        this.difficulty = copy.getDifficulty();
        this.grade = copy.getGrade();
        this.worth = copy.getWorth();
    }

    @Id
    private String id;

    @Column(name="course_id")
    private String courseId;

    @Column(name="difficulty")
    private Integer difficulty;

    @Column(name="grade")
    private Integer grade;

    @Column(name="worth")
    private Integer worth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name="ip")
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}