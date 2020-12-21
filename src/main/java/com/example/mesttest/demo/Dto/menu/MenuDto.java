package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.Menu;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto {
    private Long id;
    private String test1;
    private String test2;
    private String test3;
    private String test4;
    private String test5;
    private String test6;
    @Builder
    public MenuDto(Long id,String test1,String test2,String test3,String test4,String test5,String test6)
    {
        this.id = id;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
        this.test5 = test5;
        this.test6 = test6;
    }
    public Menu toEntity()
    {
        return Menu.builder()
                .id(id)
                .test1(test1)
                .test2(test2)
                .test3(test3)
                .test4(test4)
                .test5(test5)
                .test6(test6)
                .build();
    }
}
