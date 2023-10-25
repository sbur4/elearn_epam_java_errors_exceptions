package com.epam.factory;

import com.epam.factory.impl.FacultyFactoryImpl;
import com.epam.factory.impl.GroupFactoryImpl;
import com.epam.factory.impl.StudentFactoryImpl;
import com.epam.factory.impl.UniversityFactoryImpl;

public class FactoryContainer {
    private final StudentFactoryImpl studentFactory;
    private final GroupFactoryImpl groupFactory;
    private final FacultyFactoryImpl facultyFactory;
    private final UniversityFactoryImpl universityFactory;

    public FactoryContainer(StudentFactoryImpl studentFactory, GroupFactoryImpl groupFactory,
                            FacultyFactoryImpl facultyFactory, UniversityFactoryImpl universityFactory) {
        this.studentFactory = studentFactory;
        this.groupFactory = groupFactory;
        this.facultyFactory = facultyFactory;
        this.universityFactory = universityFactory;
    }

    public StudentFactoryImpl getStudentFactory() {
        return studentFactory;
    }

    public GroupFactoryImpl getGroupFactory() {
        return groupFactory;
    }

    public FacultyFactoryImpl getFacultyFactory() {
        return facultyFactory;
    }

    public UniversityFactoryImpl getUniversityFactory() {
        return universityFactory;
    }
}