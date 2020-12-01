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
@Table(name="Inspectortype")
public class RegisterInspectortype {
    @Id
    @Column
    private String inspectortype;
    @Builder
    public RegisterInspectortype(String inspectortype){this.inspectortype = inspectortype;}
}
