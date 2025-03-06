package com.example.demo.model.request;

import com.example.demo.model.response.SurveyChoice;
import com.example.demo.model.response.SurveySetting;
import lombok.Data;

import java.util.List;

@Data
public class SurveyRequest {
    private String type;
    private String title;
    private List<SurveySetting> settings;
    private List<SurveyChoice> choices;
}
