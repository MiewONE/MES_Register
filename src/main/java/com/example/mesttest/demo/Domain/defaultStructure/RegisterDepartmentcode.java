package com.example.mesttest.demo.Domain.defaultStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="Departmentcode")
public class RegisterDepartmentcode {
    @Id
    @Column
    private String departmentcode;
    @Builder
    public RegisterDepartmentcode(String departmentcode)
    {
        this.departmentcode = departmentcode;
    }
}
