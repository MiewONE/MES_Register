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
    }
    @PutMapping("/api/update/{employee_number}")
    public String update(@PathVariable String employee_number,@RequestBody RegisterEmDto reqDto)
    {
        return service.update(employee_number,reqDto);
    }
    @DeleteMapping("/api/delete/{employee_number}")
    public String delete(@PathVariable String employee_number)
    {
        service.delete(employee_number);
        return employee_number;
    }

}
