package com.epam.factory.impl;

import com.epam.dto.UniversityDto;
import com.epam.factory.UniversityFactory;
import com.epam.mapper.MapperContainer;
import com.epam.mapper.impl.UniversityMapperImpl;
import com.epam.model.University;
import com.epam.strategy.ValidatorContainer;
import com.epam.strategy.impl.IsEmptyUniversityValidatorImpl;
import com.epam.strategy.impl.NameValidatorImpl;

public class UniversityFactoryImpl implements UniversityFactory<University, UniversityDto> {
    private final NameValidatorImpl nameValidator;
    private final IsEmptyUniversityValidatorImpl universityValidator;
    private final UniversityMapperImpl universityMapper;

    public UniversityFactoryImpl(ValidatorContainer validatorContainer, MapperContainer mapperContainer) {
        this.nameValidator = validatorContainer.getNameValidator();
        this.universityValidator = validatorContainer.getUniversityValidator();
        this.universityMapper = mapperContainer.getUniversityMapper();
    }

    @Override
    public University create(UniversityDto dto) {
        nameValidator.validate(dto.getName());
        universityValidator.validate(dto);

        return universityMapper.mapTo(dto);
    }
}