package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.TitleMenu;
import lombok.Getter;

@Getter
public class TitleMenuResDto {
    private String titleMenuName;
    private String titleMenuUrl;

    public TitleMenuResDto(TitleMenu entity)
    {
        this.titleMenuName = entity.getTitleMenuName();
        this.titleMenuUrl = entity.getTitleMenuUrl();
    }
}
