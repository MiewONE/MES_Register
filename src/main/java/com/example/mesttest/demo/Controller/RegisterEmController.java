package com.example.mesttest.demo.Controller;


import com.example.mesttest.demo.Dto.RegisterDto;
import com.example.mesttest.demo.Dto.RegisterResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RegisterEmController {
    private final RegisterService service;
    @PostMapping("/api/register")
    public String save(@RequestBody RegisterDto dto) {

        String tmp = null;
        String tt =dto.getEmployeenumber();
        RegisterResDto ts =service.findByEmployeenumber(tt);
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
    public String update(@PathVariable String employee_number,@RequestBody RegisterDto reqDto)
    {
        return service.update(employee_number,reqDto);
    }
    @DeleteMapping("/api/delete")
    public String delete(@RequestBody List<Map<String,Object>> employees)
    {

        List<String> employee_del = new ArrayList<String>();
        for(Map<String,Object> em : employees)
        {
          for(String key:em.keySet())
          {
                employee_del.add(em.get(key).toString());
          }
        }
        for(String ems : employee_del)
        {
            try{
                service.delete(ems);
            }catch (Exception e)
            {
                return "오류가 발생하여 취소되었습니다.";
            }

        }
        return "";
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
