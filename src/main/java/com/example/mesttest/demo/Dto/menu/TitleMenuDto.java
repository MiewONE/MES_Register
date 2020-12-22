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

    @Builder
    public TitleMenuDto(String titleMenuUrl,String titleMenuName)
    {
        this.titleMenuName = titleMenuName;
        this.titleMenuUrl = titleMenuUrl;
    }

    public TitleMenu toEntity()
    {
        return TitleMenu.builder()
                .titleMenuName(titleMenuName)
                .titleMenuUrl(titleMenuUrl)
                .build();
    }
}
