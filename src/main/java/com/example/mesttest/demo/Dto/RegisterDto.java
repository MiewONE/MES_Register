package com.example.mesttest.demo.Dto;

import com.example.mesttest.demo.Domain.RegisterEm;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
public class RegisterDto {
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

    private String RegFactory;
    private String RegPosition;
    private String RegDepartmentcode;
    private String RegInspectortype;
    @Builder
    public RegisterDto(Long orgid, Long companyid, String employeenumber, String inspectortype, String krname, String departmentcode, String positioncode, String upperemployeenumber, String leaderyn, Date effectivestartdate, Date effectiveenddate, String email, String phonenumber, String useyn, String remarks, String createdby, Date creationdate, String lastupdatedby, Date lastupdatedate)
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
    @Builder
    public RegisterDto(String Regkeyword)
    {
        switch (Regkeyword)
        {
            case "Factory":
                this.RegFactory=Regkeyword;
                break;
            case "Position":
                this.RegPosition=Regkeyword;
                break;
            case "Departmentcode":
                this.RegDepartmentcode=Regkeyword;
                break;
            case "Inspectortype":
                this.RegInspectortype=Regkeyword;
                break;
        }
    }

//    public RegisterPosition toPositionEntity()
//    {
//        return RegisterPosition.builder().position(RegPosition).build();
//    }
//    public RegisterInspectortype toInspectortypeEntity()
//    {
//        return RegisterInspectortype.builder().inspectortype(RegInspectortype).build();
//    }
//    public RegisterDepartmentcode toDepartmentcodeEntity()
//    {
//        return RegisterDepartmentcode.builder().departmentcode(RegDepartmentcode).build();
//    }
//    public RegisterFactory toFactoryEntity()
//    {
//        return RegisterFactory.builder().factory(RegFactory).build();
//    }
    public RegisterEm toEntity()
    {
        return RegisterEm.builder()
                .orgid(orgid)
                .companyid(companyid)
                .employeenumber(employeenumber)
                .inspectortype(inspectortype)
                .krname(krname)
                .departmentcode(departmentcode)
                .positioncode(positioncode)
                .upperemployeenumber(upperemployeenumber)
                .leaderyn(leaderyn)
                .effectivestartdate(effectivestartdate)
                .effectiveenddate(effectiveenddate)
                .email(email)
                .phonenumber(phonenumber)
                .useyn(useyn)
                .remarks(remarks)
                .createdby(createdby)
                .creationdate(creationdate)
                .lastupdatedby(lastupdatedby)
                .lastupdatedate(lastupdatedate)
                .build();
    }
}
