package com.klb.exam.demo;

import common.pojo.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: klb-authentication
 * @description:
 * @author: Yunxf
 * @create: 2021-12-22 15:46
 */
@Slf4j
@RestController
@RequestMapping("permission")
public class PermissionController {


    @RequestMapping("/getpermission")
    @PreAuthorize("hasRole('USER')")
    public ResultObject<String> getPermission(Authentication authentication){
        return ResultObject.success(authentication.getPrincipal().toString());
    }

    @RequestMapping("/getpermissionnoauth")
    @PreAuthorize("hasRole('USER')")
    public ResultObject<String> getPermission(){
        return ResultObject.success("yes");
    }
}
