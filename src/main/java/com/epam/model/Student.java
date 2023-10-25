package com.epam.model;

import com.epam.enums.Course;
import com.epam.enums.Faculty;
import com.epam.enums.Group;
import com.epam.enums.Subject;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Student extends Human {
    private Long id;
    private Faculty faculty;
    private Group group;
    private Course course;
    private Map<Subject, Integer> subjectsList;

    public Student() {

    }

    public Student(Long id, Faculty faculty, Group group, Course course, Map<Subject, Integer> subjectsList) {
        this.id = id;
        this.faculty = faculty;
        this.group = group;
        this.course = course;
        this.subjectsList = subjectsList;
    }

    public Student(String surname, String name, String patronymic, LocalDateTime birthDate, String address,
                   String phone, Long id, Faculty faculty, Group group, Course course, Map<Subject, Integer> subjectsList) {
        super(surname, name, patronymic, birthDate, address, phone);
        this.id = id;
        this.faculty = faculty;
        this.group = group;
        this.course = course;
        this.subjectsList = subjectsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Map<Subject, Integer> getSubjectsList() {
        return subjectsList;
    }

    public void setSubjectsList(Map<Subject, Integer> subjectsList) {
        this.subjectsList = subjectsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(faculty, student.faculty)
                && Objects.equals(group, student.group) && course == student.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, faculty, group, course);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("id=" + id)
                .add("faculty='" + faculty + "'")
                .add("group='" + group + "'")
                .add("course=" + course)
                .add("subjectsList=" + subjectsList)
                .toString();
    }
}