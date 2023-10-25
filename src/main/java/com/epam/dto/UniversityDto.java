package com.epam.dto;

import com.epam.model.Faculties;

import java.util.List;

public class UniversityDto {
    private final String name;
    private final List<Faculties> faculties;

    public UniversityDto(String name, List<Faculties> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public List<Faculties> getFaculties() {
        return faculties;
    }
}