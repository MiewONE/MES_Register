package com.example.mesttest.demo.Domain.defaultStructure;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="Factory")
public class RegisterFactory {
    @Id @Column(name="factory") private String factory;
    public RegisterFactory(String factory){this.factory=factory;}
    @Builder public void factoryUpdate(String factory){this.factory=factory;}
}
