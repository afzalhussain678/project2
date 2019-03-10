package com.hussain.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDetailsResponse {
    private String name;
    private int age;
    private double height;
    private String country;
}
