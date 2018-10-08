package cn.lix.filter;


import com.lix.entity.Xt_yh;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器，过滤掉用户直接访问jsp的请求
 */
public class LoginFilter implements Filter {

    private String[] excludeUris;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String excludeUri = filterConfig.getInitParameter("excludeUri");
        excludeUris = excludeUri.split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        boolean flag = false;
       String path = request.getRequestURI();
        for (int i = 0; i < excludeUris.length; i++){
            if (path.contains(excludeUris[i])){
                flag = true;
                break;
            }
        }
        if (!flag){
            Xt_yh sysUser = (Xt_yh) request.getSession().getAttribute("xtYh");
            if (sysUser == null){
                request.getRequestDispatcher("/random").forward(request,response);
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
