package com.example.demo.service;

import com.example.demo.model.entity.ProfileEntity;
import com.example.demo.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProfileService {

    @Autowired
    public ProfileRepository repository;
    public ProfileEntity createProfile(ProfileEntity profile) {
        return repository.save(profile);
    }

    public String calculateRisk(String occupationCode) {
        switch (occupationCode) {
            case "01":
                return "Risk";
            case "02":
                return "Higher Risk";
            case "03":
                return "No Risk";
            default:
                return "Unknown";
        }
    }
}
