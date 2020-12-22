package com.example.mesttest.demo.Domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String menuUrl;
    @Column private String menuClass;
    @Column private String useYN;
    @Column private String sortNo;
    @Column private String collapseYN;
    @Column private int depth;
    @Column private int parentId;
    
    @Builder
    public Menu(Long id,String menuUrl,String menuClass,String useYN,String sortNo,String collapseYN,int depth,int parentId)
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
}
