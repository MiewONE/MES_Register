package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.RegisterEmRepository;
import com.example.mesttest.demo.Dto.EmployeeUpdateReqDto;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import com.example.mesttest.demo.Dto.RegisterEmResDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
    private RegisterEmRepository rep;

    @After
    public void del_db() throws Exception
    {
//        rep.deleteAll();
    }

    @Test
    public void RegisterEm_register() throws Exception
    {
        for(int i=8;i<100;i++)
        {
            RegisterEmDto reqDto =RegisterEmDto.builder()
                    .org_id(6L)
                    .company_id(6L)
                    .employee_number(i+"")
                    .inspector_type("1")
                    .kr_name("park")
                    .department_code("123")
                    .position_code("123")
                    .upper_employee_number("123")
                    .leader_yn("1")
                    .effective_start_date(date)
                    .effective_end_date(date)
                    .email("email")
                    .phone_number("123")
                    .use_yn("1")
                    .remarks("123")
                    .created_by("123")
                    .creation_date(date)
                    .last_updated_by("213")
                    .last_update_date(date)
                    .build();

            String url ="http://localhost:"+port+"/api/register";

            ResponseEntity<String> resEntity = restTemplate.postForEntity(url,reqDto,String.class);


            assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

            List<RegisterEm> all =rep.findAll();
            assertThat(all.get(0).getEmployee_number()).isEqualTo("1");
        }

    }

    @Test
    public void Employee_update() throws Exception
    {
        RegisterEm req = rep.save(RegisterEm.builder()
                .org_id(10L)
                .company_id(10L)
                .employee_number("10")
                .inspector_type("1")
                .kr_name("park")
                .department_code("123")
                .position_code("123")
                .upper_employee_number("123")
                .leader_yn("1")
                .effective_start_date(date)
                .effective_end_date(date)
                .email("park")
                .phone_number("123")
                .use_yn("1")
                .remarks("123")
                .created_by("123")
                .creation_date(date)
                .last_updated_by("213")
                .last_update_date(date)
                .build());

        String updateNumber = req.getEmployee_number();

        String name = "wongyun";
        String email = "pp";

        EmployeeUpdateReqDto reqDto = EmployeeUpdateReqDto.builder()
                .kr_name(name)
                .email(email)
                .build();

        //@PutMapping("/api/update/{employee_number}")
//        String url = "http://localhost:"+port+"/api/update/"+updateNumber;
        String url = "Http://localhost:"+port+"/api/delete/"+updateNumber;
        HttpEntity<EmployeeUpdateReqDto> reqEntity = new HttpEntity<>(reqDto);
        ResponseEntity<String> resEntity = restTemplate.exchange(url, HttpMethod.DELETE,reqEntity,String.class);

        assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<RegisterEm> all = rep.findAll();
        for(RegisterEm el : all)
        {
//           assertThat(el.getEmployee_number());
            System.out.println(el.getEmployee_number());
        }
//        assertThat(all.getKr_name()).isEqualTo(name);


    }

}
