package com.example.mesttest.demo.Dto;

import com.example.mesttest.demo.Domain.RegisterEm;

import lombok.Getter;

import java.util.Date;

@Getter
public class RegisterResDto {
    private Long orgid; // 사업장
    private Long companyid; // 공장
    private String employeenumber; // 사원번호
    private String inspectortype; // 사원구분
    private String krname;
    private String departmentcode;
    private String positioncode;
    private String upperemployeenumber;
    private String leaderyn;
    private Date effectivestartdate;
    private Date effectiveenddate;
    private String email;
    private String phonenumber;
    private String useyn;
    private String remarks;
    private String createdby;
    private Date creationdate;
    private String lastupdatedby;
    private Date lastupdatedate;

    public RegisterResDto(RegisterEm entity)
    {
        this.orgid = entity.getOrgid();
        this.companyid = entity.getCompanyid();
        this.employeenumber =entity.getEmployeenumber();
        this.inspectortype = entity.getInspectortype();
        this.krname = entity.getKrname();
        this.departmentcode = entity.getDepartmentcode();
        this.positioncode = entity.getPositioncode();
        this.upperemployeenumber = entity.getUpperemployeenumber();
        this.leaderyn = entity.getLeaderyn();
        this.effectivestartdate = entity.getEffectivestartdate();
        this.effectiveenddate = entity.getEffectiveenddate();
        this.email = entity.getEmail();
        this.phonenumber = entity.getPhonenumber();
        this.useyn = entity.getUseyn();
        this.remarks = entity.getRemarks();
        this.createdby = entity.getCreatedby();
        this.creationdate = entity.getCreationdate();
        this.lastupdatedate = entity.getLastupdatedate();
        this.lastupdatedby = entity.getLastupdatedby();
    }

//    public RegisterResDto(RegisterFactory entity)
//    {
//        this.ResFactory = entity.getFactory();
//    }
//    public RegisterResDto(RegisterPosition entity)
//    {
//        this.ResPosition= entity.getPosition();
//    }
//    public RegisterResDto(RegisterInspectortype entity)
//    {
//        this.ResInspectortype = entity.getInspectortype();
//    }
//    public RegisterResDto(RegisterDepartmentcode entity)
//    {
//        this.ResDepartmentcode = entity.getDepartmentcode();
//    }

}
