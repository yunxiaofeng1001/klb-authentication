package com.klb.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 14:16
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(bCryptPasswordEncoder().encode("123123"))
//                .roles("ADMIN","USER")
//                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("p1,p2"));
//    }

    /**
     * 如果使用密码模式需要配置AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                .and()
                .requestMatchers()//系统中所有请求
                .antMatchers("/**")//SpringSecurity接管的请求/**系统所有请求
                .and()
                .authorizeRequests()//得到SpringSecurity接管的请求
                .antMatchers("/user/*")//给接管的请求(/**)中的/test/*
                .hasRole("ADMIN")//配置需要p1权限
                .antMatchers("/permission/*")//给接管的请求(/**)中的/mbb/*
                .permitAll()//放行，无需权限
                .anyRequest()//其他请求
                .authenticated()//都需要认证
                .and()
                .csrf().disable()//关闭csrf
        ;

//
//        //系统中所有请求
//        http
//                .formLogin()
//                .and()
//                .requestMatchers()
//                //SpringSecurity接管的请求/**系统所有请求
//                .antMatchers("/**")
//                .and()
//                //得到SpringSecurity接管的请求
//                .authorizeRequests()
////                .antMatchers("/oauth/**","/login/**","/logout/**").permitAll()
//                //给接管的请求(/**)中的/user/*
//                .antMatchers("/user/*")
////                .permitAll()
//                //配置admin角色
//                .hasRole("ADMIN")
////                .hasAnyAuthority("p1","p2")
//                //给接管的请求(/**)中的/permission/*
//                .antMatchers("/permission/*")
//                .permitAll()//放行，无需权限
//                .anyRequest()//其他请求
//                .authenticated()//都需要认证
//                .and()
//                .csrf().disable();//关闭csrf
    }
}
