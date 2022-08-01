package com.example.demo.security;

import com.example.demo.security.services.UserdetailsServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserdetailsServicesimpl userdetailsServicesimpl;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        // không cần xác minh
        http.authorizeRequests().antMatchers("/login","/","/css/*","/js/*" ,"/img/*","/api/v1/student/get").permitAll();
        // còn lại tất cả đều xác minh

        //phân quyền
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        //
        http.authorizeRequests().antMatchers("/user").access("hasAnyRole('USER')");
        http.authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')");


        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/index")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userdetailsServicesimpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}//$2a$10$Ew.QvN0nTPvS0Csn5kOunOz0zNzvIR1vHGI8dXZXkkCnImewlbfNa (123456)
