package com.example.mesttest.demo.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class TitleMenu {

    @Id
    private String titleMenuName;
    @Column
    private String titleMenuUrl;
    @Column(unique = true)
    private int priority;

    @Builder
    public TitleMenu(String titleMenuName,String titleMenuUrl,int priority)
    {
        this.titleMenuName = titleMenuName;
        this.titleMenuUrl = titleMenuUrl;
        this.priority = priority;
    }
}
