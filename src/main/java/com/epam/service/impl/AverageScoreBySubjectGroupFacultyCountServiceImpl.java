package com.epam.service.impl;

import com.epam.enums.Faculty;
import com.epam.enums.Group;
import com.epam.enums.Subject;
import com.epam.model.University;
import com.epam.service.CountService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AverageScoreBySubjectGroupFacultyCountServiceImpl implements CountService<Object> {
    @Override
    public double count(Object... objects) {
        University university = (University) objects[0];
        Subject subject = (Subject) objects[1];
        Group group = (Group) objects[2];
        Faculty faculty = (Faculty) objects[3];

        List<Integer> scores = university.getFaculties().stream()
                .filter(faculties -> faculties.getFaculty() == faculty)
                .flatMap(faculties -> faculties.getGroups().stream())
                .filter(groups -> groups.getGroup() == group)
                .flatMap(groups -> groups.getStudents().stream())
                .flatMap(student -> student.getSubjectsList().entrySet().stream())
                .filter(entry -> entry.getKey() == subject)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        int count = scores.size();
        int sum = scores.stream().mapToInt(Integer::intValue).sum();

        return count > 0 ? (double) sum / count : 0.0;
    }
}