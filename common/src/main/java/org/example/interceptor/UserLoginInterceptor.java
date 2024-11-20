package org.example.interceptor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.example.utils.ThreadLocalUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor implements HandlerInterceptor {


    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("user-info");
        if(StrUtil.isNotBlank(header)) {
            ThreadLocalUtil.set(header);
            return true;
        }
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
        return true;
    }
    /***
     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        ThreadLocalUtil.remove();
        System.out.println("执行了拦截器的afterCompletion方法");
    }
}




