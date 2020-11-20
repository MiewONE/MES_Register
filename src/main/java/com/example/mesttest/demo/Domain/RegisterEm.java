package com.example.mesttest.demo.Domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@IdClass(RegisterEmPK.class)
@Entity
@Table(name = "cb_humanresource_manager")
public class RegisterEm {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_id; // 사업장
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="COMPANY_ID")
    private Long company_id; // 공장
    @Id
    private String employee_number; // 사원번호
    @Column(nullable = false,length = 20)
    private String inspector_type; // 사원구분
    @Column(length = 200)
    private String kr_name;//사원명
    @Column(nullable = false,length=20)
    private String department_code;//부서코드
    @Column(length=20)
    private String position_code;//직위
    @Column(length=20)
    private String upper_employee_number;//상위자
    @Column(nullable = false,length=1)
    private String leader_yn;//부서장여부
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effective_start_date;//입사일자
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date effective_end_date;//퇴사일자
    @Column(length=200)
    private String email;//이메일
    @Column(length = 20)
    private String phone_number;//전화번호
    @Column(nullable = false,length = 1)
    private String use_yn;//사용유무
    @Column(length = 200)
    private String remarks;//비고
    @Column(nullable = false,length=30)
    private String created_by;//등록자
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creation_date;//등록일자
    @Column(nullable = false,length = 30)
    private String last_updated_by;//수정자
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date last_update_date;//수정일자

    @Builder
    public RegisterEm(Long org_id, Long company_id, String employee_number, String inspector_type, String kr_name, String department_code, String position_code, String upper_employee_number, String leader_yn, Date effective_start_date, Date effective_end_date, String email, String phone_number, String use_yn, String remarks, String created_by, Date creation_date, String last_updated_by, Date last_update_date)
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

    public void update(Long org_id, Long company_id, String employee_number, String inspector_type, String kr_name, String department_code, String position_code, String upper_employee_number, String leader_yn, Date effective_start_date, Date effective_end_date, String email, String phone_number, String use_yn, String remarks, String created_by, Date creation_date, String last_updated_by, Date last_update_date)
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

/*
* */
