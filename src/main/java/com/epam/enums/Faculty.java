package com.epam.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Faculty {
    DEV, QA, BA, AGILE, SUPPORT, UNKNOWN;

    public static List<Faculty> getFaculties() {
        return new ArrayList<>(EnumSet.allOf(Faculty.class));
    }

    public static List<String> getFacultiesNames() {
        return EnumSet.allOf(Faculty.class).stream().map(Faculty::name).collect(Collectors.toList());
    }

    public static Faculty getFaculty(String facultyName) {
        return Faculty.getFaculties().stream()
                .filter(faculty -> facultyName.toUpperCase().equals(faculty.name()))
                .findFirst()
                .orElse(Faculty.UNKNOWN);
    }
}