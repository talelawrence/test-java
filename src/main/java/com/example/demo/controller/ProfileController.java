package com.example.demo.controller;


import com.example.demo.model.entity.ProfileEntity;
import com.example.demo.model.response.ProfileResponse;
import com.example.demo.model.response.Status;
import com.example.demo.service.ProfileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profile")
@Log4j2
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/risk-calculate")
    public ResponseEntity<Map<String, Object>> createAndCalculateRisk(@RequestBody List<ProfileEntity> profiles) {

        List<Map<String, Object>> dataList = new ArrayList<>();
        String message = "API called successfully..";
        String descriptionEn = "Customer Profile created successfully.";
        String descriptionTh = "ข้อมูลลูกค้าได้ทำการบันทึกเรียบร้อยแล้ว";
        String statusCode = "0000";

        try {
            for (ProfileEntity profile : profiles) {
                // Save Profile to DB
                ProfileEntity savedProfile = profileService.createProfile(profile);

                // Calculate Risk
                String risk = profileService.calculateRisk(profile.getOccupationCode());

                // Create response data
                Map<String, Object> customerInfo = new HashMap<>();
                customerInfo.put("full_name_en", savedProfile.getCustomerTitleEn() + " " + savedProfile.getCustomerFirstNameEn() + " " + savedProfile.getCustomerLastNameEn());
                customerInfo.put("full_name_th", savedProfile.getCustomerTitleTh() + " " + savedProfile.getCustomerFirstNameTh() + " " + savedProfile.getCustomerLastNameTh());
                customerInfo.put("sex", savedProfile.getSex().equals("M") ? "Male" : "Female");
                customerInfo.put("Occupation_desc", getOccupationDescription(savedProfile.getOccupationCode()));

                Map<String, Object> data = new HashMap<>();
                data.put("Customer_info", customerInfo);
                data.put("Customer_risk", risk);

                dataList.add(data);

                log.info("Customer Create Profile and Calculate Risk success");
            }
        } catch (Exception e) {
            statusCode = "9999";
            message = "Unable to call API";
            descriptionEn = "Unable to create profile and calculate Risk failed";
            descriptionTh = "ไม่สามารถสร้างโปรไฟล์และคำนวณความเสี่ยงล้มเหลว";

            log.error("Unable to create profile and calculate Risk failed", e);
        }

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> status = new HashMap<>();
        status.put("code", statusCode);
        status.put("message", message);
        Map<String, String> description = new HashMap<>();
        description.put("en", descriptionEn);
        description.put("th", descriptionTh);
        status.put("description", description);
        response.put("status", status);
        response.put("Data", dataList);

        return ResponseEntity.ok(response);
    }

    private String getOccupationDescription(String occupationCode) {
        switch (occupationCode) {
            case "01":
                return "Police";
            case "02":
                return "Criminal";
            case "03":
                return "Officer";
            default:
                return "Other";
        }
    }
}
