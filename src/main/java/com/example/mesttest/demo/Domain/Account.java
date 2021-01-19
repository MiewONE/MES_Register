package com.example.mesttest.demo.Domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;
    @Column
    private String role;

    public void encodePassword(PasswordEncoder passwordEncoder)
    {
        this.password = passwordEncoder.encode(this.password);
    }

}
