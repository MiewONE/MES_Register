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
@AllArgsConstructor
@Entity
@Table(name="Departmentcode")
public class RegisterDepartmentcode {
    @Id
    @Column
    private String departmentcode;
    @Builder
    public void departmentcodeUpdate(String departmentcode)
    {
        this.departmentcode = departmentcode;
    }
}
