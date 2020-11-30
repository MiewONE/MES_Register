package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final RegisterService service;

    @GetMapping("/")
    public String Index(Model model)
    {
        List<RegisterEmResDto> ser =service.findAllDesc();
        int cnt = ser.size();
        model.addAttribute("employeers",ser);
        model.addAttribute("cnt",cnt);
        return "main";
    }
    @GetMapping("/employee")
    public String employee(Model model)
    {
        return "employee_detail";
    }
    @GetMapping("/employee/{employee_number}")
    public String employeeUpdate(@PathVariable String employee_number,Model model)
    {
        RegisterEmResDto dto = service.findByEmployeenumber(employee_number);
        model.addAttribute("employee",dto);
        model.addAttribute("context","사원 수정");
        return "main";

    }
//    @GetMapping("/employee/search/{search_title}&{search_keyword}")
//        public String employeerSearch(@PathVariable String search_title,@PathVariable String search_keyword,Model model)
//    {
//        RegisterEmResDto dto = service.fin
//    }
    @GetMapping("/employee/search")//이름,직위,전화번호
    public String employeeSearch(@RequestParam String title , @RequestParam String keyword,Model model)
    {
        List<RegisterEmResDto> ser = service.Search(title,keyword);
        int cnt = ser.size();
//        RegisterEmResDto dto = service.Search_phonenumber(keyword);
        model.addAttribute("employeers",ser);
        model.addAttribute("cnt",cnt);
        return "main";
    }
    @GetMapping("/employee/register")
    public String employeeRegister(Model model  )
    {
        model.addAttribute("context","사원등록");
        return "inputData";
    }
}
