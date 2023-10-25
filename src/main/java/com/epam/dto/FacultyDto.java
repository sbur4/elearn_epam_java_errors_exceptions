package com.epam.dto;

import com.epam.model.Groups;

import java.util.List;

public class FacultyDto {
    private final String faculty;
    private final List<Groups> groups;

    public FacultyDto(String faculty, List<Groups> groups) {
        this.faculty = faculty;
        this.groups = groups;
    }

    public String getFaculty() {
        return faculty;
    }

    public List<Groups> getGroups() {
        return groups;
    }
}