package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisterPositionRepository extends JpaRepository<RegisterPosition,String> {

    RegisterPosition findByPositionEquals(String position);
}
