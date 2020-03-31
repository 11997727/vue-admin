package com.example.vue_admin.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: newdraft
 * @Package com.example.newdraft.util
 * @Description: 配置拦截器
 * @date 2020/1/14 星期二 19:53
 */
@Configuration
public class MyConfiguration implements WebMvcConfigurer {
//    /**前端用的代理已经解决了跨域问题，这里可以注释
//     * 跨域相关设置
//     *
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")// 允许跨域访问的路径
//                .allowedOrigins("*")// 允许跨域访问的源
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
//                .maxAge(168000)// 预检间隔时间
//                .allowedHeaders("*")// 允许头部设置
//                .allowCredentials(true);// 是否发送cookie
//    }

    /**讲拦截器交给springIOC容器管理,否则拦截器无法初始化Bean
     * @return
     */
    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }

    /**
     * 拦截器设置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor())
                //不需要拦截的地址
                .excludePathPatterns("/user/login")
                //要拦截的地址  如果全部拦截就用 "/**"
                .addPathPatterns("/**");

    }
}
