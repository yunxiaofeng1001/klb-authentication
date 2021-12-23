package com.klb.exam.demo;

import common.pojo.ResultObject;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @program: klb-authentication
 * @description: demo user
 * @author: Yunxf
 * @create: 2021-12-22 15:12
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/getuser")
//    @PreAuthorize("hasAnyAuthority('p1')")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultObject<Object> getUser(Authentication authentication,@RequestHeader("Authorization")String authorization){
        String[] token = authorization.split(" ");
        return ResultObject.success(Jwts.parser().setSigningKey("yun".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token[1]));
    }

    @RequestMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResultObject<List<DemoUser>> getUser(){
        DemoUser user1 = new DemoUser("1","zhang");
        DemoUser user2 = new DemoUser("2","li");
        List<DemoUser> users  = Arrays.asList(user1,user2);
        return ResultObject.success(users);
    }
}
