package com.epam.factory.impl;

import com.epam.dto.StudentDto;
import com.epam.factory.UniversityFactory;
import com.epam.mapper.MapperContainer;
import com.epam.mapper.impl.StudentMapperImpl;
import com.epam.model.Student;
import com.epam.strategy.ValidatorContainer;
import com.epam.strategy.impl.HasStudentSubjectsValidatorImpl;
import com.epam.strategy.impl.ScoreValidatorImpl;
import com.epam.strategy.impl.StudentValidatorImpl;

public class StudentFactoryImpl implements UniversityFactory<Student, StudentDto> {
    private final StudentValidatorImpl studentValidator;
    private final HasStudentSubjectsValidatorImpl studentSubjectsValidator;
    private final ScoreValidatorImpl scoreValidator;
    private final StudentMapperImpl studentMapper;

    public StudentFactoryImpl(ValidatorContainer validatorContainer, MapperContainer mapperContainer) {
        this.studentValidator = validatorContainer.getStudentValidator();
        this.studentSubjectsValidator = validatorContainer.getStudentSubjectsValidator();
        this.scoreValidator = validatorContainer.getScoreValidator();
        this.studentMapper = mapperContainer.getStudentMapper();
    }


    @Override
    public Student create(StudentDto dto) {
        studentValidator.validate(dto);
        studentSubjectsValidator.validate(dto.getSubjectsList());
        scoreValidator.validate(dto.getSubjectsList());

        return studentMapper.mapTo(dto);
    }
}