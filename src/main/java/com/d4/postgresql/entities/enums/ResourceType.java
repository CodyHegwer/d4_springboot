package com.d4.postgresql.entities.enums;

public enum ResourceType {
    SCHOOL("school"),
    COURSE("course"),
    COURSE_RATING("rating"),
    COURSE_COMMENT("comment");

    public final String value;

    private ResourceType(String value) {
        this.value = value;
    }
}
