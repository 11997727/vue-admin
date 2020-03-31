package com.example.vue_admin.controller;

import com.alibaba.fastjson.JSON;
import com.example.vue_admin.server.UserService;
import com.example.vue_admin.utils.RedisUtil;
import com.example.vue_admin.utils.UserAgentUtil;
import cz.mallat.uasparser.UserAgentInfo;
import com.example.vue_admin.model.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: vue_admin
 * @Package com.example.vue_admin.controller
 * @Description:
 * @date 2020/3/30 星期一 21:58
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserAgentUtil userAgentUtil;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user, HttpServletRequest request) throws IOException {
        String header = request.getHeader("User-Agent");
        UserAgentInfo parse = userAgentUtil.uaSparser.parse(header);
        String type = parse.getDeviceType();
        return JSON.toJSONString(userService.userLoginByUsernameAndPassword(user,type));
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(HttpServletRequest request) throws IOException {
        Map<String,Object>map=new HashMap<>();
        String token = request.getAttribute("token").toString();
            String s = redisUtil.get(token);
            User user = JSON.parseObject(s, User.class);
            map.put("code",20000);
            map.put("data",user);
            return JSON.toJSONString(map);
    }
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request) throws IOException {
        Map<String,Object>map=new HashMap<>();
        String token = request.getAttribute("token").toString();
        redisUtil.delete(token);
        map.put("code",20000);
        return JSON.toJSONString(map);
    }
}
