package com.epam.factory.impl;

import com.epam.dto.FacultyDto;
import com.epam.factory.UniversityFactory;
import com.epam.mapper.MapperContainer;
import com.epam.mapper.impl.FacultyMapperImpl;
import com.epam.model.Faculties;
import com.epam.strategy.ValidatorContainer;
import com.epam.strategy.impl.IsEmptyFacultyValidatorImpl;

public class FacultyFactoryImpl implements UniversityFactory<Faculties, FacultyDto> {
    private final IsEmptyFacultyValidatorImpl facultyValidator;
    private final FacultyMapperImpl facultyMapper;

    public FacultyFactoryImpl(ValidatorContainer validatorContainer, MapperContainer mapperContainer) {
        this.facultyValidator = validatorContainer.getFacultyValidator();
        this.facultyMapper = mapperContainer.getFacultyMapper();
    }

    @Override
    public Faculties create(FacultyDto dto) {
        facultyValidator.validate(dto.getGroups());

        return facultyMapper.mapTo(dto);
    }
}