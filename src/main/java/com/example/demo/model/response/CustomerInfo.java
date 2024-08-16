package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerInfo {
    private String fullNameEn;
    private String fullNameTh;
    private String sex;
    private String occupationDesc;
}
