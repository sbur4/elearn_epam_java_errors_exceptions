package com.epam.strategy.impl;

import com.epam.dto.StudentDto;
import com.epam.exception.StudentFieldsException;
import com.epam.strategy.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentValidatorImpl implements Validator<StudentDto> {

    @Override
    public void validate(StudentDto studentDto) {
        if (Objects.isNull(studentDto)) {
            throw new StudentFieldsException("Student can't be empty.");
        }

        List<String> errorsMessages = new ArrayList<>();
        if (Objects.isNull(studentDto.getSurname()) || studentDto.getSurname().isEmpty()) {
            errorsMessages.add("Student surname can't be empty.");
        }
        if (Objects.isNull(studentDto.getName()) || studentDto.getName().isEmpty()) {
            errorsMessages.add("Student name can't be empty!");
        }
//        if (Objects.isNull(studentDto.getPatronymic()) || studentDto.getPatronymic().isEmpty()) {
//            errorsMessages.add("Student patronymic can't be empty.");
//        }
//        if (Objects.isNull(studentDto.getBirthDate())) {
//            errorsMessages.add("Student birth date can't be empty.");
//        }
        if (Objects.isNull(studentDto.getAddress()) || studentDto.getAddress().isEmpty()) {
            errorsMessages.add("Student address can't be empty.");
        }
        if (Objects.isNull(studentDto.getPhone()) || studentDto.getPhone().isEmpty()) {
            errorsMessages.add("Student phone can't be empty.");
        }
        if (Objects.isNull(studentDto.getFaculty()) || studentDto.getFaculty().isEmpty()) {
            errorsMessages.add("Student faculty can't be empty.");
        }
        if (Objects.isNull(studentDto.getGroup()) || studentDto.getGroup().isEmpty()) {
            errorsMessages.add("Student group can't be empty.");
        }
        if (Objects.isNull(studentDto.getCourse()) || studentDto.getCourse().isEmpty()) {
            errorsMessages.add("Student course can't be empty.");
        }

        if (!errorsMessages.isEmpty()) {
            throw new StudentFieldsException(String.join("\n", errorsMessages));
        }
    }
}