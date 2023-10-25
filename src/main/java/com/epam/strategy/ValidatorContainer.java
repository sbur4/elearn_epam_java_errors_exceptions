package com.epam.strategy;

import com.epam.strategy.impl.HasStudentSubjectsValidatorImpl;
import com.epam.strategy.impl.IsEmptyFacultyValidatorImpl;
import com.epam.strategy.impl.IsEmptyGroupValidatorImpl;
import com.epam.strategy.impl.IsEmptyUniversityValidatorImpl;
import com.epam.strategy.impl.NameValidatorImpl;
import com.epam.strategy.impl.ScoreValidatorImpl;
import com.epam.strategy.impl.StudentValidatorImpl;

public class ValidatorContainer {
    private final StudentValidatorImpl studentValidator;
    private final HasStudentSubjectsValidatorImpl studentSubjectsValidator;
    private final ScoreValidatorImpl scoreValidator;
    private final IsEmptyGroupValidatorImpl groupValidator;
    private final IsEmptyFacultyValidatorImpl facultyValidator;
    private final NameValidatorImpl nameValidator;
    private final IsEmptyUniversityValidatorImpl universityValidator;

    public ValidatorContainer(StudentValidatorImpl studentValidator, HasStudentSubjectsValidatorImpl studentSubjectsValidator,
                              ScoreValidatorImpl scoreValidator, IsEmptyGroupValidatorImpl groupValidator,
                              IsEmptyFacultyValidatorImpl facultyValidator, NameValidatorImpl nameValidator,
                              IsEmptyUniversityValidatorImpl universityValidator) {
        this.studentValidator = studentValidator;
        this.studentSubjectsValidator = studentSubjectsValidator;
        this.scoreValidator = scoreValidator;
        this.groupValidator = groupValidator;
        this.facultyValidator = facultyValidator;
        this.nameValidator = nameValidator;
        this.universityValidator = universityValidator;
    }

    public StudentValidatorImpl getStudentValidator() {
        return studentValidator;
    }

    public HasStudentSubjectsValidatorImpl getStudentSubjectsValidator() {
        return studentSubjectsValidator;
    }

    public ScoreValidatorImpl getScoreValidator() {
        return scoreValidator;
    }

    public IsEmptyGroupValidatorImpl getGroupValidator() {
        return groupValidator;
    }

    public IsEmptyFacultyValidatorImpl getFacultyValidator() {
        return facultyValidator;
    }

    public NameValidatorImpl getNameValidator() {
        return nameValidator;
    }

    public IsEmptyUniversityValidatorImpl getUniversityValidator() {
        return universityValidator;
    }
}