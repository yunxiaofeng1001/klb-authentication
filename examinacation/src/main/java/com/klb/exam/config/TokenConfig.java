package com.klb.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 16:33
 */
//@Configuration
public class TokenConfig {

//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;

//    @Bean
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey("yun");
//        return jwtAccessTokenConverter;
//    }
//
//    /**
//     * 默认生成授权码是使用的InMemory模式
//     */
////    @Bean
////    public AuthorizationCodeServices authorizationCodeServices(){
////        return new InMemoryAuthorizationCodeServices();
////    }
//
//    /**
//     * 这里是用来生成token的service
//     * @return
//     */
//    @Bean
//    public AuthorizationServerTokenServices tokenService(){
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(jwtTokenStore());
//        defaultTokenServices.setSupportRefreshToken(true);
//        defaultTokenServices.setAccessTokenValiditySeconds(120);
//        defaultTokenServices.setRefreshTokenValiditySeconds(3600);
//        return defaultTokenServices;
//    }
//
////    @Bean
////    public TokenEnhancer myTokenEnhancer() {
////        return new TokenEnhancer() {
////            @Override
////            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
////                Map<String, Object> additionalInformation = new HashMap<>();
////                additionalInformation.put("custom_enhancer","yunxf enhancer");
//////        additionalInformation.put("hehehe",authentication);
////                ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(additionalInformation);
////                return accessToken;
////            }
////        };
////    }
//
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices services = new RemoteTokenServices();
//        services.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
//        services.setClientId("exam");
//        services.setClientSecret("exam");
//        return services;
//    }
}
