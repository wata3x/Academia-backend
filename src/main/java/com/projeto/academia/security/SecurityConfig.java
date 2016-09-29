package com.projeto.academia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by wata on 21/09/2016.
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                    .and()
                    .authorizeRequests()
                        .antMatchers("/usuarios/**").permitAll()
                        .antMatchers("/categorias/**").hasRole("ADMIN")
                        .anyRequest().authenticated()

                    .and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();


    }
}
