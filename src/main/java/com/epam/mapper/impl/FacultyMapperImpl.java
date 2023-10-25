package com.epam.mapper.impl;

import com.epam.dto.FacultyDto;
import com.epam.enums.Faculty;
import com.epam.mapper.Mapper;
import com.epam.model.Faculties;

import java.util.HashSet;

public class FacultyMapperImpl implements Mapper<Faculties, FacultyDto> {
    @Override
    public Faculties mapTo(FacultyDto dto) {
        Faculty faculty = Faculty.getFaculty(dto.getFaculty());

        return new Faculties(faculty, new HashSet<>(dto.getGroups()));
    }
}