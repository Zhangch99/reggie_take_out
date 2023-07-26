package com.itheima.reggie.filter;

import com.alibaba.fastjson2.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @author zhangch
 * @Description
 * @date 2023/7/24 22:12
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    // 路径匹配器，定义路径匹配工具类，用于后期路径的匹配对比
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Long empId= (Long)request.getSession().getAttribute("employee");
        BaseContext.setCurrentId(empId);

        // 获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("拦截的请求为{}", requestURI);
        // 定义不需要处理的URI请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
        };
        // 使用匹配器，判断本次请求是否需要进行登录
        boolean check = check(urls, requestURI);
        //如果路径在urls路径中，则直接访问，不需要处理
        if (check){
            log.info("本次的请求不需要处理： {}", requestURI);
            filterChain.doFilter(request, response);
            return;
        }
        // 判断登录状态，如果已经登录则直接放行，通过输出流的方式向客户端页面响应数据
        if (request.getSession().getAttribute("employee") != null){
            log.info("用户已经登录，用户id为{}", request.getSession().getAttribute("employee"));
            filterChain.doFilter(request, response);
            return;
        }
        log.info("用户未登录");
        // 如果用户未登录，通过输出流的方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    public boolean check(String[] urls, String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                return true;
            }
        }
        return false;

    }
}
