package cn.mapper;

import cn.domain.Goods;
import com.github.pagehelper.Page;
import cn.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_email=#{email} AND user_password=#{password} and user_delete = 0")
    //id字段默认为false，表示不是主键
    //column表示数据库表字段，property表示实体类属性名。
    @Results(id ="userMap" ,value={
            @Result(id = true,column = "user_id",property = "id"),
            @Result(column = "user_name",property = "name"),
            @Result(column = "user_password",property = "password"),
            @Result(column = "user_email",property = "email"),
            @Result(column = "user_role",property = "role"),
            @Result(column = "user_delete",property = "delete"),
            @Result(column = "user_no",property = "no")
    })
    User login(User user);

    void addUser(User user);

    void editUser(User user);

    @Select({"<script>" +
            "SELECT * FROM user " +
            "where 1=1 " +
            "<if test=\"no != null\"> AND  user_no  like  CONCAT('%',#{no},'%')</if>" +
            "<if test=\"name != null\"> AND user_name like  CONCAT('%', #{name},'%') </if>" +
            "</script>"
    })
    @ResultMap("userMap")
    Page<User> searchUser(User user ); //搜索用户

    @Select(" select * from user where user_id=#{id}")
    @ResultMap("userMap")
    User findUserById(Integer id);//根据用户id查询用户信息

    @Select("select * from user where user_name=#{name}")
    @ResultMap("userMap")
    User checkName(String name);//检查用户名是否已经存在

    @Select("select * from user where user_email=#{email}")
    @ResultMap("userMap")
    User checkEmail(String email);//检查用户邮箱是否已经存在
}
