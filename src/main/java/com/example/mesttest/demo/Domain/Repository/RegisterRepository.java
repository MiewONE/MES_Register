package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterEm,String> {
    @Query("SELECT R FROM RegisterEm R ORDER BY R.employeenumber DESC")
    List<RegisterEm> findAllDesc();

//    @Query("select R from RegisterEm R where R.employee_number = ?1")
//    RegisterEm findByEmployee_number(String employeer_code);
    @Query("select distinct R.positioncode From RegisterEm  R ")
    List<String> findByPositioncode();
//    List<RegisterEm> findAllByDepartmentcode();
//    List<RegisterEm> findAllByInspectortype();
//    List<RegisterEm> findAllByCompanyid();
    RegisterEm findByEmployeenumberEquals(String employeenumber);
    List<RegisterEm> findByKrnameContains(String krname);
    List<RegisterEm> findByPhonenumberContains(String phonenumber);
    List<RegisterEm> findByPositioncodeEquals(String position);
//    List<RegisterEm> findRegisterEmByPhone_numberContains(String phone_number);

}
