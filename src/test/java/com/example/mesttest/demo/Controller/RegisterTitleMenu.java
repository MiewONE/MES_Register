package com.example.mesttest.demo.Controller;

import com.example.mesttest.demo.Domain.Repository.TitleMenuRepository;
import com.example.mesttest.demo.Domain.TitleMenu;
import com.example.mesttest.demo.Dto.menu.TitleMenuDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisterTitleMenu {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TitleMenuRepository rep;

    @After
    public void deldb() throws Exception{
        rep.deleteAll();
    }
    @Test
    public void RegisterTitleMenu() throws Exception
    {
        TitleMenuDto dto = TitleMenuDto.builder()
                .titleMenuName("영업물류")
                .titleMenuUrl("url")
                .build();

        String url = "http://localhost:"+port+"/api/register/menu";

        ResponseEntity<String> resEntity = restTemplate.postForEntity(url,dto,String.class);

        assertThat(resEntity.getStatusCode()).isEqualTo((HttpStatus.OK));
        List<TitleMenu> all = rep.findAll();

        assertThat(all.get(0));
    }
}
