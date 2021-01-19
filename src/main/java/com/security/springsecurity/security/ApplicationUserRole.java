package com.security.springsecurity.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.security.springsecurity.security.ApplicationUserPermission.*;

/**
 * @author Alauddin Tuhin
 * @created_on 1/18/21 at 5:16 PM
 * @project - springsecurity
 **/
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permission;


    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission() {
        return permission;
    }
}
