package com.klb.auth.service;

import common.pojo.ResultObject;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 18:16
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class DemoService {


    @RequestMapping("/getuser")
//    @PreAuthorize("hasAnyAuthority('p1')")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultObject<Object> getUser(Authentication authentication,@RequestHeader("Authorization")String authorization){
        String[] token = authorization.split(" ");
        return ResultObject.success(Jwts.parser().setSigningKey("yun".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token[1]));
    }
}
