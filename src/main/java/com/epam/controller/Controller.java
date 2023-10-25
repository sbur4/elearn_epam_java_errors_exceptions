package com.epam.controller;

import com.epam.dto.FacultyDto;
import com.epam.dto.GroupDto;
import com.epam.dto.StudentDto;
import com.epam.dto.UniversityDto;
import com.epam.enums.Course;
import com.epam.enums.Faculty;
import com.epam.enums.Group;
import com.epam.enums.Subject;
import com.epam.factory.FactoryContainer;
import com.epam.factory.impl.FacultyFactoryImpl;
import com.epam.factory.impl.GroupFactoryImpl;
import com.epam.factory.impl.StudentFactoryImpl;
import com.epam.factory.impl.UniversityFactoryImpl;
import com.epam.model.Faculties;
import com.epam.model.Groups;
import com.epam.model.Student;
import com.epam.model.University;
import com.epam.service.CountServiceContainer;
import com.epam.service.impl.AverageScoreBySubjectGroupFacultyCountServiceImpl;
import com.epam.service.impl.AverageScoreInAllSubjectsCountServiceImpl;
import com.epam.service.impl.AverageScoreInAllUniversityCountServiceImpl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    public void processRun(FactoryContainer factoryContainer, CountServiceContainer countServiceContainer) {
        University university = generateUniversity(factoryContainer);
        System.out.println(university);

        // task 1
        AverageScoreInAllSubjectsCountServiceImpl countService1 =
                countServiceContainer.getCountAverageScoreInAllSubjectsService();
        Student student = new Student("Bush", "George", "Walker",
                LocalDateTime.of(1946, Month.JULY, 6, 0, 0), "New haven, USA",
                "380667778899", 2L, Faculty.DEV, Group.JAVA, Course.APPLICANT, Collections.emptyMap());
        double averageScore1 = countService1.count(university, student);
        System.out.println(averageScore1);

        // task 2
        AverageScoreBySubjectGroupFacultyCountServiceImpl countService2 =
                countServiceContainer.getCountAverageScoreBySubjectGroupFacultyService();
        double averageScore2 = countService2.count(university, Subject.CORE, Group.JAVA, Faculty.DEV);
        System.out.println(averageScore2);

        // task 3
        AverageScoreInAllUniversityCountServiceImpl countService3 =
                countServiceContainer.getCountAverageScoreInAllUniversityService();
        double averageScore3 = countService3.count(university);
        System.out.println(averageScore3);
    }

    private static University generateUniversity(FactoryContainer factoryContainer) {
        FacultyFactoryImpl facultyFactory = factoryContainer.getFacultyFactory();

        FacultyDto facultyDevDto = new FacultyDto("dev", Stream.of(generateJavaDevApplicantsGroup(factoryContainer),
                        generatePyDevStudentsGroup(factoryContainer), generateDbTraineeGroup(factoryContainer))
                .collect(Collectors.toList()));
        Faculties facultyDev = facultyFactory.create(facultyDevDto);

        FacultyDto qaFacultyDto = new FacultyDto("qa", Stream.of(generateCjuniorGroup(factoryContainer),
                generateJsMiddleGroup(factoryContainer)).collect(Collectors.toList()));
        Faculties qaFaculty = facultyFactory.create(qaFacultyDto);


        UniversityFactoryImpl universityFactory = factoryContainer.getUniversityFactory();
        UniversityDto universityDto = new UniversityDto("EPAM University", Stream.of(facultyDev, qaFaculty)
                .collect(Collectors.toList()));

        return universityFactory.create(universityDto);
    }

    private static Groups generateJsMiddleGroup(FactoryContainer factoryContainer) {
        String faculty = "qa";
        String group = "javascript";
        String course = "middle";

        Map<String, Integer> subjects9 = new LinkedHashMap<>();
        subjects9.put("advanced", 6);
        subjects9.put("english", 8);
        StudentDto studentDto9 = new StudentDto("Duda", "Andrzej", "Sebastian",
                LocalDateTime.of(1972, Month.MAY, 16, 0, 0), "Krakow, Poland",
                "+381111111111", 9L, faculty, group, course, subjects9);

        Map<String, Integer> subjects10 = new LinkedHashMap<>();
        subjects10.put("advanced", 8);
        subjects10.put("english", 9);
        StudentDto studentDto10 = new StudentDto("Kallas", "Kaja", null,
                LocalDateTime.of(1977, Month.JUNE, 18, 0, 0), "Tallinn, Estonian",
                "+382222222222", 10L, faculty, group, course, subjects10);

        StudentFactoryImpl studentFactory = factoryContainer.getStudentFactory();
        Student student9 = studentFactory.create(studentDto9);
        Student student10 = studentFactory.create(studentDto10);

        GroupDto groupDto = new GroupDto(group, course,
                Stream.of(student9, student10).collect(Collectors.toList()));
        GroupFactoryImpl groupFactory = factoryContainer.getGroupFactory();

        return groupFactory.create(groupDto);
    }

    private static Groups generateCjuniorGroup(FactoryContainer factoryContainer) {
        String faculty = "qa";
        String group = "c";
        String course = "junior";

        Map<String, Integer> subjects7 = new LinkedHashMap<>();
        subjects7.put("core", 2);
        subjects7.put("english", 3);
        StudentDto studentDto7 = new StudentDto("Sunak", "Rishi", null,
                LocalDateTime.of(1980, Month.MAY, 12, 0, 0), "Southampton, UK",
                "+380939394444", 7L, faculty, group, course, subjects7);

        Map<String, Integer> subjects8 = new LinkedHashMap<>();
        subjects8.put("core", 4);
        subjects8.put("english", 5);
        StudentDto studentDto8 = new StudentDto("Johnson", "Boris", "Alexander",
                LocalDateTime.of(1964, Month.JUNE, 19, 0, 0), "New York City, USA",
                "+380403332211", 8L, faculty, group, course, subjects8);

        StudentFactoryImpl studentFactory = factoryContainer.getStudentFactory();
        Student student7 = studentFactory.create(studentDto7);
        Student student8 = studentFactory.create(studentDto8);

        GroupDto groupDto = new GroupDto(group, course,
                Stream.of(student7, student8).collect(Collectors.toList()));
        GroupFactoryImpl groupFactory = factoryContainer.getGroupFactory();

        return groupFactory.create(groupDto);
    }

    private static Groups generateDbTraineeGroup(FactoryContainer factoryContainer) {
        String faculty = "dev";
        String group = "database";
        String course = "trainee";

        Map<String, Integer> subjects5 = new LinkedHashMap<>();
        subjects5.put("advanced", 9);
        subjects5.put("english", 10);
        StudentDto studentDto5 = new StudentDto("Scholz", "Olaf", null,
                LocalDateTime.of(1958, Month.JUNE, 14, 0, 0), "Osnabruck, Germany",
                "+380010203045", 5L, faculty, group, course, subjects5);

        Map<String, Integer> subjects6 = new LinkedHashMap<>();
        subjects6.put("advanced", 0);
        subjects6.put("english", 1);
        StudentDto studentDto6 = new StudentDto("Macron", "Emmanuel", "Jean-Michel",
                LocalDateTime.of(1977, Month.DECEMBER, 21, 0, 0), "Amiens, France",
                "+382221133444", 6L, faculty, group, course, subjects6);

        StudentFactoryImpl studentFactory = factoryContainer.getStudentFactory();
        Student student5 = studentFactory.create(studentDto5);
        Student student6 = studentFactory.create(studentDto6);

        GroupDto groupDto = new GroupDto(group, course,
                Stream.of(student5, student6).collect(Collectors.toList()));
        GroupFactoryImpl groupFactory = factoryContainer.getGroupFactory();

        return groupFactory.create(groupDto);
    }

    private static Groups generatePyDevStudentsGroup(FactoryContainer factoryContainer) {
        String faculty = "dev";
        String group = "python";
        String course = "student";

        Map<String, Integer> subjects3 = new LinkedHashMap<>();
        subjects3.put("basic", 5);
        subjects3.put("testing", 6);
        StudentDto studentDto3 = new StudentDto("Trudeau", "Justin", "Pierre",
                LocalDateTime.of(1971, Month.DECEMBER, 25, 0, 0), "Ottawa, Canada",
                "+380331117878", 3L, faculty, group, course, subjects3);

        Map<String, Integer> subjectsList4 = new LinkedHashMap<>();
        subjectsList4.put("basic", 7);
        subjectsList4.put("testing", 8);
        StudentDto studentDto4 = new StudentDto("George", "Charles", "Philip Arthur",
                LocalDateTime.of(1948, Month.NOVEMBER, 14, 0, 0), "London, UK",
                "380224005060", 4L, faculty, group, course, subjectsList4);

        StudentFactoryImpl studentFactory = factoryContainer.getStudentFactory();
        Student student3 = studentFactory.create(studentDto3);
        Student student4 = studentFactory.create(studentDto4);

        GroupDto groupDto = new GroupDto(group, course,
                Stream.of(student3, student4).collect(Collectors.toList()));
        GroupFactoryImpl groupFactory = factoryContainer.getGroupFactory();

        return groupFactory.create(groupDto);
    }

    private static Groups generateJavaDevApplicantsGroup(FactoryContainer factoryContainer) {
        String faculty = "dev";
        String group = "java";
        String course = "applicant";

        Map<String, Integer> subjects1 = new LinkedHashMap<>();
        subjects1.put("core", 1);
        subjects1.put("english", 2);
        StudentDto studentDto1 = new StudentDto("Baiden", "Joseph", "Robinette",
                LocalDateTime.of(1942, Month.NOVEMBER, 20, 0, 0), "Scranton, USA",
                "+380554443322", 1L, faculty, group, course, subjects1);

        Map<String, Integer> subjects2 = new LinkedHashMap<>();
        subjects2.put("core", 3);
        subjects2.put("english", 4);
        StudentDto studentDto2 = new StudentDto("Bush", "George", "Walker",
                LocalDateTime.of(1946, Month.JULY, 6, 0, 0), "New haven, USA",
                "380667778899", 2L, faculty, group, course, subjects2);

        StudentFactoryImpl studentFactory = factoryContainer.getStudentFactory();
        Student student1 = studentFactory.create(studentDto1);
        Student student2 = studentFactory.create(studentDto2);

        GroupDto groupDto = new GroupDto(group, course,
                Stream.of(student1, student2).collect(Collectors.toList()));
        GroupFactoryImpl groupFactory = factoryContainer.getGroupFactory();

        return groupFactory.create(groupDto);
    }
}