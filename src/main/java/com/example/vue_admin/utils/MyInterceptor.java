package com.example.vue_admin.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: newdraft
 * @Package com.example.newdraft.util
 * @Description: 拦截器
 * @date 2020/2/2 星期日 10:18
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
            Map<String,Object>map=new HashMap<>();
            String token = request.getHeader("X-Token");
            System.out.println("拦截器显示token>>>"+token);
        if(token==null||token.equals("")||token.equals("null")){
                map.put("code",50008);//非法令牌
                returnJson(response, JSON.toJSONString(map));
                System.out.println("不放行,没有token,非法令牌");
                return false;
        }
        if(!redisUtil.hasKey(token)){
            map.put("code",50014);//令牌过期
            returnJson(response, JSON.toJSONString(map));
            System.out.println("有token,令牌过期");
            return false;
        }
        request.setAttribute("token",token);
        System.out.println("放行,有token");
            return true;
    }

    public void returnJson(HttpServletResponse response, String json){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
