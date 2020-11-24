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
    @Id @Column(name="org_id") private Long orgid; // 사업장
    @Id @Column(name="company_id") private Long companyid; // 공장
    @Id @Column(name="employee_number") private String employeenumber; // 사원번호
    @Column(name="inspector_type",nullable = false,length = 20) private String inspectortype; // 사원구분
    @Column(name="kr_name",length = 200) private String krname;//사원명
    @Column(name="department_code",nullable = false,length=20) private String departmentcode;//부서코드
    @Column(name="position_code",length=20) private String positioncode;//직위
    @Column(name="upper_employee_number",length=20) private String upperemployeenumber;//상위자
    @Column(name="leader_yn",nullable = false,length=1) private String leaderyn;//부서장여부
    @Column(name="effective_start_date",nullable = false) @Temporal(TemporalType.DATE) private Date effectivestartdate;//입사일자
    @Column(name="effective_end_date",nullable=false) @Temporal(TemporalType.DATE) private Date effectiveenddate;//퇴사일자
    @Column(name="email",length=200) private String email;//이메일 
    @Column(name="phone_number",length = 20) private String phonenumber;//전화번호
    @Column(name="use_yn",nullable = false,length = 1) private String useyn;//사용유무
    @Column(name="remarks",length = 200) private String remarks;//비고
    @Column(name="created_by",nullable = false,length=30) private String createdby;//등록자
    @Column(name="creation_date",nullable = false) @Temporal(TemporalType.DATE) private Date creationdate;//등록일자
    @Column(name="last_updated_by",nullable = false,length = 30) private String lastupdatedby;//수정자
    @Column(name="last_update_date",nullable = false) @Temporal(TemporalType.DATE) private Date lastupdatedate;//수정일자

    @Builder
    public RegisterEm(Long orgid, Long companyid, String employeenumber, String inspectortype, String krname, String departmentcode, String positioncode, String upperemployeenumber, String leaderyn, Date effectivestartdate, Date effectiveenddate, String email, String phonenumber, String useyn, String remarks, String createdby, Date creationdate, String lastupdatedby, Date lastupdatedate)
    {
        this.orgid = orgid;
        this.companyid = companyid;
        this.employeenumber = employeenumber;
        this.inspectortype = inspectortype;
        this.krname = krname;
        this.departmentcode = departmentcode;
        this.positioncode = positioncode;
        this.upperemployeenumber = upperemployeenumber;
        this.leaderyn = leaderyn;
        this.effectivestartdate = effectivestartdate;
        this.effectiveenddate = effectiveenddate;
        this.email = email;
        this.phonenumber = phonenumber;
        this.useyn = useyn;
        this.remarks = remarks;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdatedby=lastupdatedby;
        this.lastupdatedate = lastupdatedate;
    }

    public void update(Long orgid, Long companyid, String employeenumber, String inspectortype, String krname, String departmentcode, String positioncode, String upperemployeenumber, String leaderyn, Date effectivestartdate, Date effectiveenddate, String email, String phonenumber, String useyn, String remarks, String createdby, Date creationdate, String lastupdatedby, Date lastupdatedate)
    {
        this.orgid = orgid;
        this.companyid = companyid;
        this.employeenumber = employeenumber;
        this.inspectortype = inspectortype;
        this.krname = krname;
        this.departmentcode = departmentcode;
        this.positioncode = positioncode;
        this.upperemployeenumber = upperemployeenumber;
        this.leaderyn = leaderyn;
        this.effectivestartdate = effectivestartdate;
        this.effectiveenddate = effectiveenddate;
        this.email = email;
        this.phonenumber = phonenumber;
        this.useyn = useyn;
        this.remarks = remarks;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdatedby=lastupdatedby;
        this.lastupdatedate = lastupdatedate;
    }

}

/*
* */
