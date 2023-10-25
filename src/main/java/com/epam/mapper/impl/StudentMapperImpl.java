package com.epam.mapper.impl;

import com.epam.dto.StudentDto;
import com.epam.enums.Course;
import com.epam.enums.Faculty;
import com.epam.enums.Group;
import com.epam.enums.Subject;
import com.epam.mapper.Mapper;
import com.epam.model.Student;

import java.util.Map;

public class StudentMapperImpl implements Mapper<Student, StudentDto> {
    @Override
    public Student mapTo(StudentDto dto) {
        Faculty faculty = Faculty.getFaculty(dto.getFaculty());
        Group group = Group.getGroup(dto.getGroup());
        Course course = Course.getCourse(dto.getCourse());
        Map<Subject, Integer> subjectsAndScores = Subject.getSubject(dto.getSubjectsList());

        return new Student(dto.getSurname(), dto.getName(), dto.getPatronymic(), dto.getBirthDate(),
                dto.getAddress(), dto.getPhone(), dto.getId(), faculty, group, course, subjectsAndScores);
    }
}