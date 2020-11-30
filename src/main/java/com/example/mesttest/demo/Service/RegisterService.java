package com.example.mesttest.demo.Service;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.RegisterRepository;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegisterService {
    private final RegisterRepository rep;

    @Transactional
    public String save(RegisterEmDto dto)
    {
        return rep.save(dto.toEntity()).getEmployeenumber();
    }

    public RegisterEmResDto findByEmployeenumber(String employeercode)
    {
        RegisterEm entity = rep.findByEmployeenumberEquals(employeercode);//.orElseThrow(()->new IllegalArgumentException("해당 사원은 존재하지 않습니다"+employeercode));
        if(entity==null) return null;
        return new RegisterEmResDto(entity);
    }
    @Transactional//(readOnly = true) //readOnly =true를 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회속도가 개선됨. 등록,삭제,수전 기능이 없는 서비스메소드에 사용하는게 좋음
    public List<RegisterEmResDto> findAllDesc()
    {
        return rep.findAllDesc().stream()
                .map(RegisterEmResDto::new) // == .map(posts -> new PostsListResponseDto(posts)
                .collect(Collectors.toList());  // postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드.
    }

    public void delete(String employeenumber)
    {
        RegisterEm entity = rep.findByEmployeenumberEquals(employeenumber);
        rep.delete(entity);
    }
    @Transactional
    public String update(String employeenumber,RegisterEmDto reqDto)
    {
        RegisterEm em = rep.findByEmployeenumberEquals(employeenumber);
        em.update(
                reqDto.getOrgid(),
                reqDto.getCompanyid(),
                reqDto.getEmployeenumber(),
                reqDto.getInspectortype(),
                reqDto.getKrname(),
                reqDto.getDepartmentcode(),
                reqDto.getPositioncode(),
                reqDto.getUpperemployeenumber(),
                reqDto.getLeaderyn(),
                reqDto.getEffectivestartdate(),
                reqDto.getEffectiveenddate(),
                reqDto.getEmail(),
                reqDto.getPhonenumber(),
                reqDto.getUseyn(),
                reqDto.getRemarks(),
                reqDto.getCreatedby(),
                reqDto.getCreationdate(),
                reqDto.getLastupdatedby(),
                reqDto.getLastupdatedate()
        );
        return employeenumber;
    }
    public List<RegisterEmResDto> Search(String title, String keyword)
    {
        switch(title)
        {
            case "name":
                return rep.findByKrnameContains(keyword).stream()
                        .map(RegisterEmResDto::new).collect(Collectors.toList());
            case "position":
                return rep.findByPositioncodeEquals(keyword).stream()
                        .map(RegisterEmResDto::new).collect(Collectors.toList());
            case "phonenumber":
                return rep.findByPhonenumberContains(keyword).stream()
                        .map(RegisterEmResDto::new).collect(Collectors.toList());
            default:
                return rep.findAll().stream().map(RegisterEmResDto::new).collect(Collectors.toList());

        }
//        return rep.findByPhonenumberContains(keyword).stream()
//                .map(RegisterEmResDto::new)
//                .collect(Collectors.toList());
    }

//    public List<RegisterEmResDto> Searchphonenumber(String keyword)
//    {
//        return rep.findRegisterEmByPhonenumberContains(keyword).stream()
//                .map(RegisterEmResDto::new)
//                .collect(Collectors.toList());
//    }
}
