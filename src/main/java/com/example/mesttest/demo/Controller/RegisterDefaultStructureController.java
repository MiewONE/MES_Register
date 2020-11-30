package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RegisterDefaultStructureController {
    private final RegisterService service;

//    @PostMapping("/api/register/")
}
