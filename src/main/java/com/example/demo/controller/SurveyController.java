package com.example.demo.controller;

import com.example.demo.model.request.SurveyRequest;
import com.example.demo.model.response.SurveyResponse;
import com.example.demo.service.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveys")
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/create")
    public ResponseEntity<SurveyResponse> createSurvey(@RequestBody SurveyRequest request) {
        return ResponseEntity.ok(surveyService.createSurvey(request));
    }

    @GetMapping("/get")
    public ResponseEntity<List<SurveyResponse>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }
}
