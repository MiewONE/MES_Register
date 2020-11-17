package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
