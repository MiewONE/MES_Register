package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);
}
