package com.example.demo.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SurveyChoice {
    private String title;

    @Column(name = "\"value\"")
    private String value;
}
