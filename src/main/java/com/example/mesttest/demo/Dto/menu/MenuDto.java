package com.example.mesttest.demo.Dto.menu;

import com.example.mesttest.demo.Domain.Menu;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto {
    private Long id;

    private String menuUrl;
    private String menuClass;
    private String useYN;
    private String sortNo;
    private String collapseYN;
    private int depth;
    private int parentId;
    
    @Builder
    public MenuDto(Long id,String menuUrl,String menuClass,String useYN,String sortNo,String collapseYN,int depth,int parentId)
    {
        this.id = id;
        this.menuUrl = menuUrl;
        this.menuClass = menuClass;
        this.useYN = useYN;
        this.sortNo = sortNo;
        this.collapseYN = collapseYN;
        this.depth = depth;
        this.parentId = parentId;
    }
    public Menu toEntity()
    {
        return Menu.builder()
                .id(id)
                .menuUrl(menuUrl)
                .menuClass(menuClass)
                .useYN(useYN)
                .sortNo(sortNo)
                .collapseYN(collapseYN)
                .depth(depth)
                .parentId(parentId)
                .build();
    }
}
