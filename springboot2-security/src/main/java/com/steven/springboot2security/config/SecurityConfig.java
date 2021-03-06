package com.steven.springboot2security.config;

import com.steven.springboot2security.handler.CustomLoginFailureHandler;
import com.steven.springboot2security.handler.CustomLoginSuccessHandler;
import com.steven.springboot2security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author CXQ
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    private CustomLoginFailureHandler customLoginFailureHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html", "/ad.html").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();

        http.formLogin()
                .loginPage("/api/user/login-routing")
                .loginProcessingUrl("/login")
//                .successForwardUrl("/api/user/main-routing")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customLoginFailureHandler)
                .permitAll()
                .and().logout()
                .logoutUrl("/api/user/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
    }
}