package dao;

import cn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDao {
    @Select("Select * from User where email={email} AND password={password}")
    public User login(User user);
}
