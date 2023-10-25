package com.epam.model;

import com.epam.enums.Faculty;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Faculties {
    private Faculty faculty;
    private Set<Groups> groups;

    public Faculties() {
    }

    public Faculties(Faculty faculty, Set<Groups> groups) {
        this.faculty = faculty;
        this.groups = groups;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }

    public void addtGroup(Groups group) {
        groups.add(group);
    }

    public void addtGroups(Set<Groups> groupsList) {
        groups.addAll(groupsList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Faculties)) {
            return false;
        }
        Faculties faculties = (Faculties) o;
        return faculty == faculties.faculty && Objects.equals(groups, faculties.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, groups);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Faculties.class.getSimpleName() + "[", "]")
                .add("faculty='" + faculty + "'")
                .add("groups=" + groups)
                .toString();
    }
}