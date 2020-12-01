package com.example.mesttest.demo.Service;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.RegisterPositionRepository;
import com.example.mesttest.demo.Domain.RegisterRepository;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterFactory;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import com.example.mesttest.demo.Dto.RegisterDto;
import com.example.mesttest.demo.Dto.RegisterResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegisterService {
    private final RegisterRepository rep;

    private final RegisterPositionRepository positionRepository;
    @Transactional
    public String save(RegisterDto dto)
    {
        return rep.save(dto.toEntity()).getEmployeenumber();
    }

    public RegisterResDto findByEmployeenumber(String employeercode)
    {
        RegisterEm entity = rep.findByEmployeenumberEquals(employeercode);//.orElseThrow(()->new IllegalArgumentException("해당 사원은 존재하지 않습니다"+employeercode));
        if(entity==null) return null;
        return new RegisterResDto(entity);
    }
    @Transactional//(readOnly = true) //readOnly =true를 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회속도가 개선됨. 등록,삭제,수전 기능이 없는 서비스메소드에 사용하는게 좋음
    public List<RegisterResDto> findAllDesc()
    {
        return rep.findAllDesc().stream()
                .map(RegisterResDto::new) // == .map(posts -> new PostsListResponseDto(posts)
                .collect(Collectors.toList());  // postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드.
    }

    public void delete(String employeenumber)
    {
        RegisterEm entity = rep.findByEmployeenumberEquals(employeenumber);
        rep.delete(entity);
    }
    @Transactional
    public String update(String employeenumber, RegisterDto reqDto)
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
    public List<RegisterResDto> Search(String title, String keyword) {
        switch (title) {
            case "name":
                return rep.findByKrnameContains(keyword).stream()
                        .map(RegisterResDto::new).collect(Collectors.toList());
            case "position":
                return rep.findByPositioncodeEquals(keyword).stream()
                        .map(RegisterResDto::new).collect(Collectors.toList());
            case "phonenumber":
                return rep.findByPhonenumberContains(keyword).stream()
                        .map(RegisterResDto::new).collect(Collectors.toList());
            default:
                return rep.findAll().stream().map(RegisterResDto::new).collect(Collectors.toList());

        }
    }
    public List<RegisterPosition> View()
    {
        return positionRepository.findAll();
    }
    public void Insert(RegisterPosition entity)
    {
        positionRepository.save(entity);
    }


}
