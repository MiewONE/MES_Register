package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Dto.RegisterResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final RegisterService service;
    @GetMapping("/")
    public String Index(Model model)
    {
        model.addAttribute("title","홈페이지");
        model.addAttribute("menu",service.findAlltitleMenu());
        model.addAttribute("nav",service.findAllMenu());
        //기본페이지에서 보여줄 서브타이틀들을 불러와야함
        //디비에 넣어놨다가 가지고오는걸로 확장성가지게 하자.
//        model.addAttribute("nav",service.getMenu());
        return "main";
    }
    @GetMapping("/system")
    public String system(Model model)
    {
        model.addAttribute("title","시스템관리");
        return "system";
    }
    @GetMapping("/employee/{employee_number}")
    public String employeeUpdate(@PathVariable String employee_number,Model model)
    {
        RegisterResDto dto = service.findByEmployeenumber(employee_number);
        model.addAttribute("employee",dto);
        model.addAttribute("context","수정");
        return "updateData";

    }
    @GetMapping("/error")
    public String error()
    {
        return "error";
    }
//    @GetMapping("/employee/search/{search_title}&{search_keyword}")
//        public String employeerSearch(@PathVariable String search_title,@PathVariable String search_keyword,Model model)
//    {
//        RegisterEmResDto dto = service.fin
//    }
    @GetMapping("/employee/search")//이름,직위,전화번호
    public String employeeSearch(@RequestParam String title , @RequestParam String keyword,Model model)
    {
        switch (title)
        {
            case "employeenumber":
                RegisterResDto ser = service.findByEmployeenumber(keyword);
                model.addAttribute("employeers",ser);
                break;
            default:
                List<RegisterResDto> sers = service.Search(title,keyword);
                model.addAttribute("employeers",sers);
                break;
        }


        return "main";
    }
    @GetMapping("/employee/register")
    public String employeeRegister(Model model  )
    {
        model.addAttribute("context","등록");
        return "inputData";
    }

}
