package com.example.mesttest.demo.Domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterEmPK implements Serializable {
    private Long org_id;
    private Long company_id;
    private String employee_number;
}
