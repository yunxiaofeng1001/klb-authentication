package com.klb.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 16:07
 */
//@EnableResourceServer
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class ResourceConfig {

//    @Autowired
//    @Qualifier("jwtTokenStore")
//    private TokenStore jwtTokenStore;
//    @Autowired
//    private ResourceServerTokenServices tokenServices;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()//授权的请求
//                .anyRequest()//任何请求
//                .authenticated()//需要身份认证
//                .and().csrf().disable();
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//
//        resources.resourceId("exam-resource").tokenServices(tokenServices).tokenStore(jwtTokenStore).stateless(true);
////        super.configure(resources);
//    }
}
