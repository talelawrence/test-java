package com.example.demo.service;

import com.example.demo.model.entity.Survey;
import com.example.demo.model.request.SurveyRequest;
import com.example.demo.model.response.SurveyResponse;
import com.example.demo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    public SurveyResponse createSurvey(SurveyRequest request) {
        Survey survey = new Survey();
        survey.setType(request.getType());
        survey.setTitle(request.getTitle());
        survey.setSettings(request.getSettings());
        survey.setChoices(request.getChoices());

        survey = surveyRepository.save(survey);

        return convertToResponse(survey);
    }

    public List<SurveyResponse> getAllSurveys() {
        return surveyRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private SurveyResponse convertToResponse(Survey survey) {
        SurveyResponse response = new SurveyResponse();
        response.setId(survey.getId());
        response.setType(survey.getType());
        response.setTitle(survey.getTitle());
        response.setSettings(survey.getSettings());
        response.setChoices(survey.getChoices());
        return response;
    }
}
