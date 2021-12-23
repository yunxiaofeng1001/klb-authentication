package com.klb.exam.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @program: klb-authentication
 * @description: 解析请求头权限filter
 * @author: Yunxf
 * @create: 2021-12-22 19:57
 */
@Component
public class ParseTokenAuthenticationFilter extends OncePerRequestFilter {

    public static String tokenHeader = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader(tokenHeader);
        String[] token = authorization.split(" ");
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey("yun".getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token[1]);
        Object user_name = claimsJws.getBody().get("user_name");
        httpServletRequest.setAttribute("USER_NAME",user_name);

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
