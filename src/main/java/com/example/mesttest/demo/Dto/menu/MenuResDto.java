package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.Menu;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class MenuResDto {
    private Long id;

    private String menuUrl;
    private String menuClass;
    private String useYN;
    private int sortNo;
    private String collapseYN;
    private int depth;
    private int parentId;

    public MenuResDto(Menu entity)
    {
        this.id = entity.getId();
        this.menuUrl = entity.getMenuUrl();
        this.menuClass = entity.getMenuClass();
        this.useYN = entity.getUseYN();
        this.sortNo = entity.getSortNo();
        this.collapseYN = entity.getCollapseYN();
        this.depth = entity.getDepth();
        this.parentId = entity.getParentId();
    }

}
