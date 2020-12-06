package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterFactory;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterFactoryRepository extends JpaRepository<RegisterFactory,String> {
//    RegisterPosition findByPositionEquals(String position);
    RegisterFactory findByFactoryEquals(String factory);
}
