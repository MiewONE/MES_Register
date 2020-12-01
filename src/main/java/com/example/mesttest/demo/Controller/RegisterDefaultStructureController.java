package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterFactory;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import com.example.mesttest.demo.Dto.RegisterResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RegisterDefaultStructureController {
    private final RegisterService service;

    @GetMapping("/api/register/factory")
    public List<RegisterPosition> viewFactory()
    {
        return service.View();
    }
    @GetMapping("/api/register/position")
    public List<RegisterPosition> viewPosition()
    {
        return service.View();
    }
    @PostMapping("/api/register/insertPosition")
    public String insertPosition(@RequestBody RegisterPosition dto)
    {
        service.Insert(dto);
        return "success";
    }
//    @GetMapping("/api/register/departmentcode")
//    public List<RegisterResDto> viewPosition(Model model)
//    {
//
//    }
//    @GetMapping("/api/register/inspectortype")
//    public List<RegisterResDto> viewInspectortype(Model model)
//    {
//
//    }
//    @GetMapping("/api/register/position")
//    public List<RegisterResDto> viewDepartmentcode(Model model)
//    {
//
//    }
}
