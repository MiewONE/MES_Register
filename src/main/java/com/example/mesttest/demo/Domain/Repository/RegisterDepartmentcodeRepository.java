package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterDepartmentcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDepartmentcodeRepository extends JpaRepository<RegisterDepartmentcode,String> {
    //RegisterPosition findByPositionEquals(String position);
    RegisterDepartmentcode findByDepartmentcodeEquals(String departmentcode);
}
