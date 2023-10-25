package com.epam.mapper.impl;

import com.epam.dto.GroupDto;
import com.epam.enums.Course;
import com.epam.enums.Group;
import com.epam.mapper.Mapper;
import com.epam.model.Groups;

import java.util.HashSet;

public class GroupMapperImpl implements Mapper<Groups, GroupDto> {
    @Override
    public Groups mapTo(GroupDto dto) {
        Group group = Group.getGroup(dto.getGroup());
        Course course = Course.getCourse(dto.getCourse());

        return new Groups(group, course, new HashSet<>(dto.getStudents()));
    }
}