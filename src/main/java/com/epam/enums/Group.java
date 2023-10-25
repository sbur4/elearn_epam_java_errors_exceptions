package com.epam.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Group {
    JAVA, PYTHON, C, JAVASCRIPT, DATABASE, SCRUMMASTER, DEVOPS, UNKNOWN;

    public static List<Group> getGroups() {
        return new ArrayList<>(EnumSet.allOf(Group.class));
    }

    public static List<String> getGroupsNames() {
        return EnumSet.allOf(Group.class).stream().map(Group::name).collect(Collectors.toList());
    }

    public static Group getGroup(String groupName) {
        return Group.getGroups().stream()
                .filter(group -> groupName.toUpperCase().equals(group.name()))
                .findFirst()
                .orElse(Group.UNKNOWN);
    }
}