package com.example.mesttest.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class JqgridVo {
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
}
