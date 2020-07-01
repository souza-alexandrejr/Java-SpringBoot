/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.codeblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Alexandre Junior
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    /* Define-se as URLs que não precisam de autenticação.
       Note que a URL referente ao 'newpost' não está inclusa. */
    private static final String[] AUTH_LIST = {
        "/",
        "/posts",
        "/posts/{id}"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll() // exclui as URLs do AUTH_LIST de autenticação
                .anyRequest().authenticated()       // as demais URLs precisam de autenticação
                .and().formLogin().permitAll()      // permite o usuário fazer seu login e logout com o form padrão do Spring Security
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("alexandre").password("{noop}123").roles("ADMIN");
                // bug do Spring -> colocar {noop} + senha (neste caso, 123)
    }

    /* Este método só é necessário caso os estilos Boostrap utilizados
       não fossem do tipo CDN, permitindo o acesso às pastas dentro da 
       aplicação. */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bootstrap/**");
//        web.ignoring().antMatchers("/bootstrap/**", "/style/**");
    }
}
