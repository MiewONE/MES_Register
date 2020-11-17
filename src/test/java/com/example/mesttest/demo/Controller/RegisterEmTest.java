package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Domain.RegisterEm;
import com.example.mesttest.demo.Domain.RegisterEmRepository;
import com.example.mesttest.demo.Dto.RegisterEmDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
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
        RegisterEmDto reqDto =RegisterEmDto.builder()
                .org_id(6L)
                .company_id(6L)
                .employee_number("6")
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
