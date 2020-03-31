package com.example.vue_admin.mapper;

import com.example.vue_admin.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project: vue_admin
 * @Package com.example.vue_admin.mapper
 * @Description: ${todo}
 * @author 吴成卓
 * @date 2020/3/30 星期一 22:17
 * @version V1.0 
 *
 */
@Mapper
public interface UserMapper {


    User userLoginByUsernameAndPassword(User user);

    List<String> getUserRoleByUid(@Param("uid") Integer uid);
}