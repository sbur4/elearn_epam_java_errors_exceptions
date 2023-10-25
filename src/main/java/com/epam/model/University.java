package com.epam.model;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class University {
    private String name;
    private Set<Faculties> faculties;

    public University() {
    }

    public University(String name, Set<Faculties> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculties> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculties> faculties) {
        this.faculties = faculties;
    }

    public void addtFaculty(Faculties faculty) {
        faculties.add(faculty);
    }

    public void addtFaculties(Set<Faculties> facultyList) {
        faculties.addAll(facultyList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof University)) {
            return false;
        }
        University that = (University) o;
        return Objects.equals(name, that.name) && Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculties);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", University.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("faculties=" + faculties)
                .toString();
    }
}