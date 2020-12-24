package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Dto.menu.MenuDto;
import com.example.mesttest.demo.Dto.menu.TitleMenuDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterMenuContorller {
    private final RegisterService service;

    @PostMapping("/api/register/titleMenu")
    public String save_titleMenu(@RequestBody TitleMenuDto dto)
    {
        try{
            service.titleMenuSave(dto);
            return "저장에 성공하였습니다.";
        }
        catch(Exception e)
        {
            return "Error!";
        }

    }
    @PostMapping("/api/register/menu")
    public String save_subMenu(@RequestBody MenuDto dto)
    {
        try{
            service.menuSave(dto);
            return "저장성공";
        }
        catch(Exception e)
        {
            return "Error";
        }

    }

    @DeleteMapping("/api/delete/titleMenu")
    public String del_titleMenu(@RequestBody TitleMenuDto dto)
    {
        try{
            service.titleMenuDel(dto.getTitleMenuName());
            return "삭제가 완료되었습니다.";
        }catch(Exception e)
        {
            return "Error!";
        }
    }
    @DeleteMapping("/api/delete/menu")
    public String del_menu(@RequestBody MenuDto dto)
    {
        try{
            service.menuDel(dto.getId());
            return "삭제가 완료되었습니다.";
        }catch(Exception e)
        {
            return "error!";
        }
    }
}
