package com.epam.mapper;

import com.epam.mapper.impl.FacultyMapperImpl;
import com.epam.mapper.impl.GroupMapperImpl;
import com.epam.mapper.impl.StudentMapperImpl;
import com.epam.mapper.impl.UniversityMapperImpl;

public class MapperContainer {
    private final StudentMapperImpl studentMapper;
    private final GroupMapperImpl groupMapper;
    private final FacultyMapperImpl facultyMapper;
    private final UniversityMapperImpl universityMapper;

    public MapperContainer(StudentMapperImpl studentMapper, GroupMapperImpl groupMapper,
                           FacultyMapperImpl facultyMapper, UniversityMapperImpl universityMapper) {
        this.studentMapper = studentMapper;
        this.groupMapper = groupMapper;
        this.facultyMapper = facultyMapper;
        this.universityMapper = universityMapper;
    }

    public StudentMapperImpl getStudentMapper() {
        return studentMapper;
    }

    public GroupMapperImpl getGroupMapper() {
        return groupMapper;
    }

    public FacultyMapperImpl getFacultyMapper() {
        return facultyMapper;
    }

    public UniversityMapperImpl getUniversityMapper() {
        return universityMapper;
    }
}