package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.Repository.RegisterPositionRepository;
import com.example.mesttest.demo.Domain.Repository.RegisterRepository;
import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import com.example.mesttest.demo.Dto.EmployeeUpdateReqDto;
import com.example.mesttest.demo.Dto.RegisterDto;
import com.example.mesttest.demo.Dto.RegisterPositionDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisterEmTest {

    Date date = new Date();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private RegisterRepository rep;
    @Autowired
    private RegisterPositionRepository Positionrep;
    @After
    public void deldb() throws Exception
    {
//        rep.deleteAll();
    }

    @Test
    public void RegisterEmregister() throws Exception
    {

        for(int i=8;i<100;i++) {
            RegisterDto reqDto = RegisterDto.builder()
                    .orgid(6L)
                    .companyid(6L)
                    .employeenumber(i + "")
                    .inspectortype("1")
                    .krname("park")
                    .departmentcode("123")
                    .positioncode("123")
                    .upperemployeenumber("123")
                    .leaderyn("1")
                    .effectivestartdate(date)
                    .effectiveenddate(date)
                    .email("email")
                    .phonenumber("1")
                    .useyn("1")
                    .remarks("123")
                    .createdby("123")
                    .creationdate(date)
                    .lastupdatedby("213")
                    .lastupdatedate(date)
                    .build();

            String url = "http://localhost:" + port + "/api/register";

            ResponseEntity<String> resEntity = restTemplate.postForEntity(url, reqDto, String.class);


//            assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//            List<RegisterEm> all = rep.findAll();
//            assertThat(all.get(0).getEmployeenumber()).isEqualTo("1");
        }

    }

    @Test
    public void Employeeupdate() throws Exception
    {
        RegisterEm req = rep.save(RegisterEm.builder()
                .orgid(10L)
                .companyid(10L)
                .employeenumber("10")
                .inspectortype("1")
                .krname("park")
                .departmentcode("123")
                .positioncode("123")
                .upperemployeenumber("123")
                .leaderyn("1")
                .effectivestartdate(date)
                .effectiveenddate(date)
                .email("park")
                .phonenumber("123")
                .useyn("1")
                .remarks("123")
                .createdby("123")
                .creationdate(date)
                .lastupdatedby("213")
                .lastupdatedate(date)
                .build());

        String updateNumber = req.getEmployeenumber();

        String name = "wongyun";
        String email = "pp";

        EmployeeUpdateReqDto reqDto = EmployeeUpdateReqDto.builder()
                .krname(name)
                .email(email)
                .build();

        //@PutMapping("/api/update/{employeenumber}")
//        String url = "http://localhost:"+port+"/api/update/"+updateNumber;
        String url = "Http://localhost:"+port+"/api/delete/"+updateNumber;
        HttpEntity<EmployeeUpdateReqDto> reqEntity = new HttpEntity<>(reqDto);
        ResponseEntity<String> resEntity = restTemplate.exchange(url, HttpMethod.DELETE,reqEntity,String.class);

        assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<RegisterEm> all = rep.findAll();
        for(RegisterEm el : all)
        {
//           assertThat(el.getEmployeenumber());
            System.out.println(el.getEmployeenumber());
        }
//        assertThat(all.getKrname()).isEqualTo(name);


    }

    @Test
    public void Employeesearch() throws Exception
    {
        String phone = "4723";

        List<RegisterEm> test = rep.findByPhonenumberContains(phone);


        System.out.println("findphonenumber"+test);
//        assertThat(test.get(0)).isEqualTo()
    }
    @Test
    public void InsertPosition()
    {
        String text = "회장";

        //RegisterDto reqDto
        RegisterPositionDto entity = RegisterPositionDto.builder().position(text).build();

        ///api/register/insertPosition
        //String url = "http://localhost:" + port + "/api/register";
        String url = "http://localhost:" + port + "/api/register/insertposition";

        ResponseEntity<String> resEntity = restTemplate.postForEntity(url, entity, String.class);

        assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<RegisterPosition> all = Positionrep.findAll();
        assertThat(all.get(0).getPosition()).isEqualTo(text);
//        List<String> tests = Positionrep.save(entity);
    }
}
