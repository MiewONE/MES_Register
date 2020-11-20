package com.example.mesttest.demo.Service;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.RegisterEmRepository;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegisterService {
    private final RegisterEmRepository rep;

    @Transactional
    public String save(RegisterEmDto dto)
    {
        return rep.save(dto.toEntity()).getEmployee_number();
    }

    public RegisterEmResDto findByEmployee_number(String employeer_code)
    {
        RegisterEm entity = rep.findByEmployee_number(employeer_code);//.orElseThrow(()->new IllegalArgumentException("해당 사원은 존재하지 않습니다"+employeer_code));
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

    public void delete(String employee_number)
    {
        RegisterEm entity = rep.findByEmployee_number(employee_number);
        rep.delete(entity);
    }
    @Transactional
    public String update(String employee_number,RegisterEmDto reqDto)
    {
        RegisterEm em = rep.findByEmployee_number(employee_number);
        em.update(
                reqDto.getOrg_id(),
                reqDto.getCompany_id(),
                reqDto.getEmployee_number(),
                reqDto.getInspector_type(),
                reqDto.getKr_name(),
                reqDto.getDepartment_code(),
                reqDto.getPosition_code(),
                reqDto.getUpper_employee_number(),
                reqDto.getLeader_yn(),
                reqDto.getEffective_start_date(),
                reqDto.getEffective_end_date(),
                reqDto.getEmail(),
                reqDto.getPhone_number(),
                reqDto.getUse_yn(),
                reqDto.getRemarks(),
                reqDto.getCreated_by(),
                reqDto.getCreation_date(),
                reqDto.getLast_updated_by(),
                reqDto.getLast_update_date()
        );
        return employee_number;
    }
}
