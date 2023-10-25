package com.epam.service.impl;

import com.epam.model.Student;
import com.epam.model.University;
import com.epam.service.CountService;

import java.util.Map;
import java.util.Objects;

public class AverageScoreInAllSubjectsCountServiceImpl implements CountService<Object> {
    @Override
    public double count(Object... objects) {
        University university = (University) objects[0];
        Student std = (Student) objects[1];

        return university.getFaculties().stream()
                .flatMap(faculties -> faculties.getGroups().stream())
                .flatMap(groups -> groups.getStudents().stream())
                .filter(student -> Objects.equals(student, std))
                .flatMap(student -> student.getSubjectsList().entrySet().stream())
                .mapToInt(Map.Entry::getValue)
                .average()
                .orElse(0.0);
    }
}