package com.example.mesttest.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/etc/**").permitAll()
                .antMatchers("/member/**").hasRole("MEMBER")
                .antMatchers("/**").hasRole("ROOT");
        //antMatchers 특정한 경로를 지정하여 권한을 부여한다.

        http.formLogin();
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        log.info("build Auth global...");
        auth.inMemoryAuthentication()
                .withUser("manager")
                .password("{noop}1234")
                .roles("ROOT");
    }
}
