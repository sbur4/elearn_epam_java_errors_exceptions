package com.epam.mapper.impl;

import com.epam.dto.UniversityDto;
import com.epam.mapper.Mapper;
import com.epam.model.University;

import java.util.HashSet;

public class UniversityMapperImpl implements Mapper<University, UniversityDto> {
    @Override
    public University mapTo(UniversityDto dto) {
        return new University(dto.getName(), new HashSet<>(dto.getFaculties()));
    }
}