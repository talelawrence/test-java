package com.example.demo.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SurveySetting {
    @Column(name = "\"key\"")
    private String key;
    @Column(name = "\"value\"")
    private String value;
}
