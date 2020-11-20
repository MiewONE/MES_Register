package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final RegisterService service;

    @GetMapping("/")
    public String Index(Model model)
    {
        model.addAttribute("employeers",service.findAllDesc());
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
        RegisterEmResDto dto = service.findByEmployee_number(employee_number);
        model.addAttribute("employee",dto);
        model.addAttribute("employeers",service.findAllDesc());
        return "update";

    }
}
