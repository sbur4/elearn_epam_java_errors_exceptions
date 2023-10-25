package com.epam.strategy.impl;

import com.epam.exception.AbsentFacultiesInUniversityException;
import com.epam.strategy.Validator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreValidatorImpl implements Validator<Map<String, Integer>> {

    @Override
    public void validate(Map<String, Integer> stringIntegerMap) {
        List<String> errorsMessages = stringIntegerMap.entrySet().stream()
                .filter(entry -> isInvalidScore(entry.getValue()))
                .map(entry -> String.format("Subject {%s} has invalid score '%d'.", entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        if (!errorsMessages.isEmpty()) {
            throw new AbsentFacultiesInUniversityException(String.join("\n", errorsMessages));
        }
    }

    private boolean isInvalidScore(Integer score) {
        return score == null || score < 0 || score > 10;
    }
}