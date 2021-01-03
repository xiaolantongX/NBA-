package com.lwj.pms.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
            req.setCharacterEncoding("Utf-8");
            resp.setCharacterEncoding("Utf-8");
            resp.setContentType("text/html;charset=Utf-8");
            filterChain.doFilter(req,resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("CharacterEncodingFilter初始化成功！！");
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁成功！！");
    }
}
