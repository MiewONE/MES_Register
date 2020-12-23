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

    @Builder
    public TitleMenu(String titleMenuName,String titleMenuUrl)
    {
        this.titleMenuName = titleMenuName;
        this.titleMenuUrl = titleMenuUrl;
    }
}
