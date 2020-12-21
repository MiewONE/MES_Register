package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.Menu;
import lombok.Getter;

@Getter
public class MenuResDto {
    private Long id;
    private String test1;
    private String test2;
    private String test3;
    private String test4;
    private String test5;
    private String test6;

    public MenuResDto(Menu entity)
    {
        this.id = entity.getId();
        this.test1 = entity.getTest1();
        this.test2 = entity.getTest2();
        this.test3 = entity.getTest3();
        this.test4 = entity.getTest4();
        this.test5 = entity.getTest5();
        this.test6 = entity.getTest6();
    }

}
