package com.example.mesttest.demo.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class EmployeeUpdateReqDto {
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

    @Builder
    public EmployeeUpdateReqDto(Long org_id, Long company_id, String employee_number, String inspector_type, String kr_name, String department_code, String position_code, String upper_employee_number, String leader_yn, Date effective_start_date, Date effective_end_date, String email, String phone_number, String use_yn, String remarks, String created_by, Date creation_date, String last_updated_by, Date last_update_date)
    {
        this.org_id = org_id;
        this.company_id = company_id;
        this.employee_number = employee_number;
        this.inspector_type = inspector_type;
        this.kr_name = kr_name;
        this.department_code = department_code;
        this.position_code = position_code;
        this.upper_employee_number = upper_employee_number;
        this.leader_yn = leader_yn;
        this.effective_start_date = effective_start_date;
        this.effective_end_date = effective_end_date;
        this.email = email;
        this.phone_number = phone_number;
        this.use_yn = use_yn;
        this.remarks = remarks;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_updated_by=last_updated_by;
        this.last_update_date = last_update_date;
    }
}
