package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.TitleMenu;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TitleMenuDto {
    private String titleMenuName;
    private String titleMenuUrl;
    private int priority;

    @Builder
    public TitleMenuDto(String titleMenuUrl,String titleMenuName,int priority)
    {
        this.titleMenuName = titleMenuName;
        this.titleMenuUrl = titleMenuUrl;
        this.priority = priority;
    }

    public TitleMenu toEntity()
    {
        return TitleMenu.builder()
                .titleMenuName(titleMenuName)
                .titleMenuUrl(titleMenuUrl)
                .priority(priority)
                .build();
    }
}
