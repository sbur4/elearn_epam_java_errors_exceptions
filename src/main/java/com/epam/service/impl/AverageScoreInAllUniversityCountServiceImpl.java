package com.epam.service.impl;

import com.epam.model.University;
import com.epam.service.CountService;

import java.util.Map;

public class AverageScoreInAllUniversityCountServiceImpl implements CountService<Object> {
    @Override
    public double count(Object... objects) {
        University university = (University) objects[0];

        return university.getFaculties().stream()
                .flatMap(faculty -> faculty.getGroups().stream())
                .flatMap(group -> group.getStudents().stream())
                .flatMap(student -> student.getSubjectsList().entrySet().stream())
                .mapToInt(Map.Entry::getValue)
                .average()
                .orElse(0.0);
    }
}