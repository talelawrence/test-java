package com.example.demo.model.entity;

import com.example.demo.model.response.SurveyChoice;
import com.example.demo.model.response.SurveySetting;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String title;

    @ElementCollection
    private List<SurveySetting> settings;

    @ElementCollection
    private List<SurveyChoice> choices;
}
