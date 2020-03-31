package com.example.vue_admin.server.impl;

import com.alibaba.fastjson.JSON;
import com.example.vue_admin.mapper.UserMapper;
import com.example.vue_admin.model.entity.User;
import com.example.vue_admin.server.UserService;
import com.example.vue_admin.utils.MD5;
import com.example.vue_admin.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: vue_admin
 * @Package com.example.vue_admin.server.impl
 * @Description:
 * @date 2020/3/30 星期一 22:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> userLoginByUsernameAndPassword(User user, String type) {
        Map<String,Object>resultMap=new HashMap<String, Object>();
        Map<String,Object>map=new HashMap<String, Object>();
        resultMap.put("msg","failed");
        resultMap.put("code",20004);
        User u=userMapper.userLoginByUsernameAndPassword(user);
        if(u!=null){
            System.out.println("登录成功");
            resultMap.put("code",20000);
            resultMap.put("msg","success");
            String token = this.createToken(u, type);
            map.put("token",token);
            resultMap.put("data",map);
            this.saveToken(u,token);
        }
        return resultMap;
    }


    //存放token
    private void saveToken(User user1, String token) {
        Map<String,Object>map=new HashMap<String, Object>();
        String tokenKey="User"+user1.getUid();
        String tokenValue=null;
        if((tokenValue=redisUtil.get(tokenKey))!=null){ //单点登录
            redisUtil.delete(tokenKey);
            redisUtil.delete(tokenValue);
        }
        List<String> role=userMapper.getUserRoleByUid(user1.getUid());
        user1.setRoles(role);
        redisUtil.setEx(tokenKey,token,7, TimeUnit.DAYS);//token 设置7天
        redisUtil.setEx(token, JSON.toJSONString(user1),7,TimeUnit.DAYS);
    }
    //创建token
    private String createToken(User user, String type) {
        StringBuilder sb=new StringBuilder();
        sb.append("token-");
        sb.append(type);
        sb.append(MD5.getMD5(user.getUid().toString(),32));
        sb.append(LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        sb.append(UUID.randomUUID().toString().substring(0,6));
        return sb.toString();
    }


}
