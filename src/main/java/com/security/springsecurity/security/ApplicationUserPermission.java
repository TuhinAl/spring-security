package com.security.springsecurity.security;

/**
 * @author Alauddin Tuhin
 * @created_on 1/18/21 at 5:17 PM
 * @project - springsecurity
 **/
public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
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
