package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.TitleMenu;
import lombok.Getter;

@Getter
public class TitleMenuResDto {
    private String titleMenuName;
    private String titleMenuUrl;
    private int priority;

    public TitleMenuResDto(TitleMenu entity)
    {
        this.titleMenuName = entity.getTitleMenuName();
        this.titleMenuUrl = entity.getTitleMenuUrl();
        this.priority = entity.getPriority();
    }
}
