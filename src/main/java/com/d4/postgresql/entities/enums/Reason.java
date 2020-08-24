package com.d4.postgresql.entities.enums;

public enum Reason {
    OFFENSIVE("offensive"),
    NEEDS_UPDATING("update"),
    DUPLICATE("duplicate"),
    OTHER("other");

    public final String value;

    private Reason(String value) {
        this.value = value;
    }
}
