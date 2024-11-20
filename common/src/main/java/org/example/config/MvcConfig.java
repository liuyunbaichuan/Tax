package org.example.config;

import org.example.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
        //所有路径都被拦截
        //registration.addPathPatterns("/**");
        //添加不拦截路径
//        registration.excludePathPatterns(
//                "/user/login",
//                "/user/register",
//                "/**/*.html",
//                "/**/*.js",
//                "/**/*.css"
//        );
    }
}

