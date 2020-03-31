package com.example.vue_admin.server;

import com.example.vue_admin.model.entity.User;

import java.util.Map;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: vue_admin
 * @Package com.example.vue_admin.server
 * @Description:
 * @date 2020/3/30 星期一 22:09
 */
public interface UserService {
    Map<String,Object> userLoginByUsernameAndPassword(User user, String type);
}
