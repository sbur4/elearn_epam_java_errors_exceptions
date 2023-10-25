package com.epam.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Subject {
    CORE, BASIC, ADVANCED, TESTING, ENGLISH, UNKNOWN;

    public static List<Subject> getSubjects() {
        return new ArrayList<>(EnumSet.allOf(Subject.class));
    }

    public static List<String> getSubjectsNames() {
        return EnumSet.allOf(Subject.class).stream().map(Subject::name).collect(Collectors.toList());
    }

    public static Map<Subject, Integer> getSubject(Map<String, Integer> stringIntegerMap) {
        Map<Subject, Integer> map = new HashMap<>();
        stringIntegerMap.forEach((key, value) -> Subject.getSubjects().stream()
                .filter(subject -> key.toUpperCase().equals(subject.name()))
                .forEachOrdered(subject -> map.put(subject, value)));
        return map;
    }
}