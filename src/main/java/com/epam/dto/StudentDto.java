package com.epam.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class StudentDto {
    private final String surname;
    private final String name;
    private final String patronymic;
    private final LocalDateTime birthDate;
    private final String address;
    private final String phone;
    private final Long id;
    private final String faculty;
    private final String group;
    private final String course;
    private final Map<String, Integer> subjectsList;

    public StudentDto(String surname, String name, String patronymic, LocalDateTime birthDate, String address,
                      String phone, Long id, String faculty, String group, String course, Map<String, Integer> subjectsList) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.id = id;
        this.faculty = faculty;
        this.group = group;
        this.course = course;
        this.subjectsList = subjectsList;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public String getCourse() {
        return course;
    }

    public Map<String, Integer> getSubjectsList() {
        return subjectsList;
    }
}