package com.security.springsecurity.student;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alauddin Tuhin
 * @created_on 1/18/21 at 1:25 PM
 * @project - springsecurity
 **/
@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String studentName;

}
