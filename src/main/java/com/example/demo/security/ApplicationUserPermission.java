package com.example.demo.security;

public enum ApplicationUserPermission {
    GOAL_READ("goal:read"),
    GOAL_WRITE("goal:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
