package com.epam.dto;

import com.epam.model.Student;

import java.util.List;

public class GroupDto {
    private final String group;
    private final String course;
    private final List<Student> students;

    public GroupDto(String group, String course, List<Student> students) {
        this.group = group;
        this.course = course;
        this.students = students;
    }

    public String getGroup() {
        return group;
    }

    public String getCourse() {
        return course;
    }

    public List<Student> getStudents() {
        return students;
    }
}