package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterInspectortype;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterinspectortypeRepository extends JpaRepository<RegisterInspectortype,String>{
    RegisterInspectortype findByInspectortypeEquals(String inspectortype);
}
