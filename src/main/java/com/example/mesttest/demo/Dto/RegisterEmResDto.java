package com.example.mesttest.demo.Dto;

import com.example.mesttest.demo.Domain.RegisterEm;
import lombok.Getter;

import java.util.Date;

@Getter
public class RegisterEmResDto {
    private Long org_id; // 사업장
    private Long company_id; // 공장
    private String employee_number; // 사원번호
    private String inspector_type; // 사원구분
    private String kr_name;
    private String department_code;
    private String position_code;
    private String upper_employee_number;
    private String leader_yn;
    private Date effective_start_date;
    private Date effective_end_date;
    private String email;
    private String phone_number;
    private String use_yn;
    private String remarks;
    private String created_by;
    private Date creation_date;
    private String last_updated_by;
    private Date last_update_date;

    public RegisterEmResDto(RegisterEm entity)
    {
        this.org_id = entity.getOrg_id();
        this.company_id = entity.getCompany_id();
        this.employee_number =entity.getEmployee_number();
        this.inspector_type = entity.getInspector_type();
        this.kr_name = entity.getKr_name();
        this.department_code = entity.getDepartment_code();
        this.position_code = entity.getPosition_code();
        this.upper_employee_number = entity.getUpper_employee_number();
        this.leader_yn = entity.getLeader_yn();
        this.effective_start_date = entity.getEffective_start_date();
        this.effective_end_date = entity.getEffective_end_date();
        this.email = entity.getEmail();
        this.phone_number = entity.getPhone_number();
        this.use_yn = entity.getUse_yn();
        this.remarks = entity.getRemarks();
        this.created_by = entity.getCreated_by();
        this.last_update_date = entity.getLast_update_date();
        this.last_updated_by = entity.getLast_updated_by();
    }
}
