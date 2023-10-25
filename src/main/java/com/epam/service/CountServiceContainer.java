package com.epam.service;

import com.epam.service.impl.AverageScoreInAllSubjectsCountServiceImpl;
import com.epam.service.impl.AverageScoreInAllUniversityCountServiceImpl;
import com.epam.service.impl.AverageScoreBySubjectGroupFacultyCountServiceImpl;

public class CountServiceContainer {
    private final AverageScoreInAllSubjectsCountServiceImpl averageScoreInAllSubjectsCountService;
    private final AverageScoreBySubjectGroupFacultyCountServiceImpl averageScoreBySubjectGroupFacultyCountService;
    private final AverageScoreInAllUniversityCountServiceImpl averageScoreInAllUniversityCountService;

    public CountServiceContainer(AverageScoreInAllSubjectsCountServiceImpl averageScoreInAllSubjectsCountService,
                                 AverageScoreBySubjectGroupFacultyCountServiceImpl averageScoreBySubjectGroupFacultyCountService,
                                 AverageScoreInAllUniversityCountServiceImpl averageScoreInAllUniversityCountService) {
        this.averageScoreInAllSubjectsCountService = averageScoreInAllSubjectsCountService;
        this.averageScoreBySubjectGroupFacultyCountService = averageScoreBySubjectGroupFacultyCountService;
        this.averageScoreInAllUniversityCountService = averageScoreInAllUniversityCountService;
    }

    public AverageScoreInAllSubjectsCountServiceImpl getCountAverageScoreInAllSubjectsService() {
        return averageScoreInAllSubjectsCountService;
    }

    public AverageScoreBySubjectGroupFacultyCountServiceImpl getCountAverageScoreBySubjectGroupFacultyService() {
        return averageScoreBySubjectGroupFacultyCountService;
    }

    public AverageScoreInAllUniversityCountServiceImpl getCountAverageScoreInAllUniversityService() {
        return averageScoreInAllUniversityCountService;
    }
}