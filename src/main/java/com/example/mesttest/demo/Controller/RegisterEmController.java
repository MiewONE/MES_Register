package com.example.mesttest.demo.Controller;


import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Dto.JqgridVo;
import com.example.mesttest.demo.Dto.RegisterDto;
import com.example.mesttest.demo.Dto.RegisterResDto;
import com.example.mesttest.demo.Service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
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
    @PutMapping("/api/update/{employeenumber}")
    public String update(@PathVariable String employeenumber,@RequestBody RegisterDto reqDto)
    {
        return service.update(employeenumber,reqDto);
    }
//    @PostMapping("/api/update")
//    public String update(@RequestParam String employeenumber,@RequestBody RegisterDto reqDto)
//    {
//        return service.update(employeenumber,reqDto);
//    }
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
        return "삭제 되었습니다.";
    }
    @GetMapping("/api/emolpyeeList")
    public List<RegisterResDto> jqgridStart(@RequestParam String _search,@RequestParam String nd,@RequestParam String page,@RequestParam String sidx,@RequestParam String sord,@RequestParam String rows)
    {
//        List<RegisterResDto> list = new ArrayList<>();
//        if(searchField!=null||searchField.length()>1)
//        {
//            switch (searchField)
//            {
//                case "employeenumber":
//                    RegisterResDto ser = service.findByEmployeenumber(searchString);
//                    list.add(ser);
//                    return list;
//                default:
//                    return service.Search(searchField,searchString);
//            }
//        }else
//        {
            List<RegisterResDto> returnValue = service.findAllDesc();
            return returnValue;
//        }

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
