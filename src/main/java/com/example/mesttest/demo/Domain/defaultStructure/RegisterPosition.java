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
@Table(name = "position")
public class RegisterPosition {
    @Id @Column(name="position") private String position;
    @Builder
    public RegisterPosition(String position){this.position=position;}
}
