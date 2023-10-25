package com.epam;

import com.epam.controller.Controller;
import com.epam.factory.FactoryContainer;
import com.epam.factory.impl.FacultyFactoryImpl;
import com.epam.factory.impl.GroupFactoryImpl;
import com.epam.factory.impl.StudentFactoryImpl;
import com.epam.factory.impl.UniversityFactoryImpl;
import com.epam.mapper.MapperContainer;
import com.epam.mapper.impl.FacultyMapperImpl;
import com.epam.mapper.impl.GroupMapperImpl;
import com.epam.mapper.impl.StudentMapperImpl;
import com.epam.mapper.impl.UniversityMapperImpl;
import com.epam.service.CountServiceContainer;
import com.epam.service.impl.AverageScoreInAllSubjectsCountServiceImpl;
import com.epam.service.impl.AverageScoreInAllUniversityCountServiceImpl;
import com.epam.service.impl.AverageScoreBySubjectGroupFacultyCountServiceImpl;
import com.epam.strategy.ValidatorContainer;
import com.epam.strategy.impl.HasStudentSubjectsValidatorImpl;
import com.epam.strategy.impl.IsEmptyFacultyValidatorImpl;
import com.epam.strategy.impl.IsEmptyGroupValidatorImpl;
import com.epam.strategy.impl.IsEmptyUniversityValidatorImpl;
import com.epam.strategy.impl.NameValidatorImpl;
import com.epam.strategy.impl.ScoreValidatorImpl;
import com.epam.strategy.impl.StudentValidatorImpl;

public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.processRun(initFactoryContainer(initValidatorContainer(), initMapperContainer()),
                initCountServiceContainer());
    }

    private static ValidatorContainer initValidatorContainer() {
        return new ValidatorContainer(new StudentValidatorImpl(), new HasStudentSubjectsValidatorImpl(),
                new ScoreValidatorImpl(), new IsEmptyGroupValidatorImpl(), new IsEmptyFacultyValidatorImpl(),
                new NameValidatorImpl(), new IsEmptyUniversityValidatorImpl());
    }

    private static MapperContainer initMapperContainer() {
        return new MapperContainer(new StudentMapperImpl(), new GroupMapperImpl(), new FacultyMapperImpl(),
                new UniversityMapperImpl());
    }

    private static FactoryContainer initFactoryContainer(ValidatorContainer validatorContainer,
                                                         MapperContainer mapperContainer) {
        return new FactoryContainer(new StudentFactoryImpl(validatorContainer, mapperContainer),
                new GroupFactoryImpl(validatorContainer, mapperContainer),
                new FacultyFactoryImpl(validatorContainer, mapperContainer),
                new UniversityFactoryImpl(validatorContainer, mapperContainer));
    }

    private static CountServiceContainer initCountServiceContainer() {
        return new CountServiceContainer(new AverageScoreInAllSubjectsCountServiceImpl(),
                new AverageScoreBySubjectGroupFacultyCountServiceImpl(),
                new AverageScoreInAllUniversityCountServiceImpl());
    }
}