package com.example.mesttest.demo.Domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface RegisterEmRepository extends JpaRepository<RegisterEm,String> {
    @Query("SELECT R FROM RegisterEm R ORDER BY R.employee_number DESC")
    List<RegisterEm> findAllDesc();

    @Query("select R from RegisterEm R where R.employee_number = ?1")
    RegisterEm findByEmployee_number(String employeer_code);

//    Optional<RegisterEm> findByEmployee_number(String employee_number);
//    RegisterEm findByEmployee_number(String employee_number);
//    @Query("select R.employee_number from RegisterEm R where R.employee_number=?1")
//    List<RegisterEm> findAllByEmployee_number(String employee_number);

//    @Query("select R from RegisterEm R where R.employee_number=?1")
//    RegisterEm findByEmployee_number(String Employee_number);

//    String findByEmployee_number(String code);
}
