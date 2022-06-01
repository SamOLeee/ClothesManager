package cn.mapper;

import com.github.pagehelper.Page;
import cn.domain.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select("select * from user where user_email=#{email} AND user_password=#{password}")
    @Results(id ="userMap" ,value={
            @Result(id = true,column = "user_id",property = "id"),
            @Result(column = "user_name",property = "name"),
            @Result(column = "user_password",property = "password"),
            @Result(column = "user_email",property = "email"),
            @Result(column = "user_role",property = "role"),/*
            @Result(column = "delete",property = "del"),*/
    })
    User login(User user);
    void addUser(User user);
    @Select({"<script>" +
            "SELECT * FROM user " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  user_id  like  CONCAT('%',#{id},'%')</if>" +
            "<if test=\"name != null\"> AND user_name like  CONCAT('%', #{name},'%') </if>" +
            "order by user_status" +
            "</script>"
    })
    @ResultMap("userMap")
        //搜索用户
    Page<User> searchUser(User user );

    @Select(" select * from user where user_id=#{id}")
    @ResultMap("userMap")
        //根据用户id查询用户信息
    User findByUserId(Integer id);

    @Select("select count(user_name) from user where user_name=#{name}")
        //检查用户名是否已经存在
    Integer checkName(String name);

    @Select("select count(user_email) from user where user_email=#{email}")
        //检查用户邮箱是否已经存在
    Integer checkEmail(String email);
}
