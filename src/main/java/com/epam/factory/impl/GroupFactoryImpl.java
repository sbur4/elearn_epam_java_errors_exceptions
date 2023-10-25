package com.epam.factory.impl;

import com.epam.dto.GroupDto;
import com.epam.factory.UniversityFactory;
import com.epam.mapper.MapperContainer;
import com.epam.mapper.impl.GroupMapperImpl;
import com.epam.model.Groups;
import com.epam.strategy.ValidatorContainer;
import com.epam.strategy.impl.IsEmptyGroupValidatorImpl;

public class GroupFactoryImpl implements UniversityFactory<Groups, GroupDto> {
    private final IsEmptyGroupValidatorImpl groupValidator;
    private final GroupMapperImpl groupMapper;

    public GroupFactoryImpl(ValidatorContainer validatorContainer, MapperContainer mapperContainer) {
        this.groupValidator = validatorContainer.getGroupValidator();
        this.groupMapper = mapperContainer.getGroupMapper();
    }

    @Override
    public Groups create(GroupDto dto) {
        groupValidator.validate(dto.getStudents());

        return groupMapper.mapTo(dto);
    }
}