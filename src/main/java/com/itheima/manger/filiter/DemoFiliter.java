package com.itheima.manger.filiter;

import com.itheima.manger.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebFilter("/*")
public class DemoFiliter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = request.getHeader("token");

        if (token == null){
            response.setStatus(401);
            log.error("空令牌");
            return;
        }
        try {
            Claims claims = JwtUtils.parseJWT(token);
            log.info("claims: {}", claims);
        }catch (Exception e){
            response.setStatus(401);
            log.error("令牌解析失败:{}",e.getMessage());
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
