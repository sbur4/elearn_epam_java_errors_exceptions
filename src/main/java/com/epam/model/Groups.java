package com.epam.model;

import com.epam.enums.Course;
import com.epam.enums.Group;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Groups {
    private Group group;
    private Course course;
    private Set<Student> students;

    public Groups() {
    }

    public Groups(Group group, Course course, Set<Student> students) {
        this.group = group;
        this.course = course;
        this.students = students;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addtStudent(Student student) {
        students.add(student);
    }

    public void addtStudents(Set<Student> studentList) {
        students.addAll(studentList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Groups)) {
            return false;
        }
        Groups groups = (Groups) o;
        return group == groups.group && course == groups.course && Objects.equals(students, groups.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, course, students);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Groups.class.getSimpleName() + "[", "]")
                .add("group=" + group)
                .add("course=" + course)
                .add("students=" + students)
                .toString();
    }
}