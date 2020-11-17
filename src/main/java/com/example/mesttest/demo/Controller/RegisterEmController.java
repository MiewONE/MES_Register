package com.example.mesttest.demo.Controller;


import com.example.mesttest.demo.Domain.RegisterEmRepository;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RegisterEmController {
    private final RegisterService service;
    @PostMapping("/api/register")
    public String save(@RequestBody RegisterEmDto dto) {
//        System.out.println(dto.getEmployee_number());
//        System.out.println("있네"+service.finById_pk(dto.getEmployee_number()));
        String tmp = null;
        String tt =dto.getEmployee_number();
        RegisterEmResDto ts =service.findByEmployee_number(tt);
        if(ts!=null) tmp = ts.getEmployee_number();
        if(tt.equals(tmp) )
        {
            return "이미 존재하는 사원번호입니다.";
        }else
        {
            return "사원번호 : "+service.save(dto)+",사원 이름 :"+dto.getKr_name()+"인 사원 등록이 완료되었습니다";//'사원 등록이 완료되었습니다'+
        }
//        return service.save(dto);

    }
//    @GetMapping("/api/employeer/{employeer_number}")
//    public RegisterEmResDto findById(@PathVariable String employeer_number)
//    {
//        return service.findByEmployee_number(employeer_number);
//    }
}
