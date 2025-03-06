package com.example.demo.model.response;

import lombok.Data;

import java.util.List;

@Data
public class SurveyResponse {
    private Long id;
    private String type;
    private String title;
    private List<SurveySetting> settings;
    private List<SurveyChoice> choices;
}
