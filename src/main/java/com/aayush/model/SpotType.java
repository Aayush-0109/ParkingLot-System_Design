package com.aayush.model;

public enum SpotType {
    SMALL(1),
    MEDIUM(2),
    LARGE(3);

    private final int priority;

    SpotType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
