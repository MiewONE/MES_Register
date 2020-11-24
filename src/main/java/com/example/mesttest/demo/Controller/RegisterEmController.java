package com.example.mesttest.demo.Controller;


import com.example.mesttest.demo.Domain.RegisterEmRepository;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RegisterEmController {
    private final RegisterService service;
    @PostMapping("/api/register")
    public String save(@RequestBody RegisterEmDto dto) {

        String tmp = null;
        String tt =dto.getEmployeenumber();
        RegisterEmResDto ts =service.findByEmployeenumber(tt);
        if(ts!=null) tmp = ts.getEmployeenumber();
        if(tt.equals(tmp) )
        {
            return "이미 존재하는 사원번호입니다.";
        }else
        {
            return "사원번호 : "+service.save(dto)+",사원 이름 :"+dto.getKrname()+"인 사원 등록이 완료되었습니다";//'사원 등록이 완료되었습니다'+
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
//    @GetMapping("/api/search")//이름,직위,전화번호
//    public String employeeSearch(@RequestParam String title , @RequestParam String keyword, Model model)
//    {
////        RegisterEmResDto dto = service.Search_phonenumber(keyword);
//        switch (title)
//        {
//            case "phonenumber":
//                model.addAttribute("employeer",service.findByEmployee_number(keyword));
//                return "main";
//            default:
//                return "";
//        }
//    }

}
