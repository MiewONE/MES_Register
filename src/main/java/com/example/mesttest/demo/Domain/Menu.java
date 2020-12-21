package com.example.mesttest.demo.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test1")
    private String test1;

    @Column(name = "test2")
    private String test2;

    @Column(name = "test3")
    private String test3;

    @Column(name = "test4")
    private String test4;

    @Column(name = "test5")
    private String test5;

    @Column(name = "test6")
    private String test6;

    @Builder
    public Menu(Long id,String test1,String test2,String test3,String test4,String test5,String test6)
    {
        this.id = id;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
        this.test5 = test5;
        this.test6 = test6;
    }
}
