package com.epam.enums;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    APPLICANT, STUDENT, TRAINEE, JUNIOR, MIDDLE, SENIOR, TEAMLEAD, PM, ARCHITECTOR, UNKNOWN;

    public static List<Course> getCourses() {
        return EnumSet.allOf(Course.class).stream().collect(Collectors.toList());
    }

    public static List<String> getCoursesNames() {
        return EnumSet.allOf(Course.class).stream().map(Course::name).collect(Collectors.toList());
    }

    public static Course getCourse(String courseName) {
        return Course.getCourses().stream()
                .filter(course -> courseName.toUpperCase().equals(course.name()))
                .findFirst()
                .orElse(Course.UNKNOWN);
    }
}