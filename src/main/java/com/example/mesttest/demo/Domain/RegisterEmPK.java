package com.example.mesttest.demo.Domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterEmPK implements Serializable {
    private Long orgid;
    private Long companyid;
    private String employeenumber;
}
