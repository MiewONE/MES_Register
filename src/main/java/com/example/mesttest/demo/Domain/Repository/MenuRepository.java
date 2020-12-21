package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
