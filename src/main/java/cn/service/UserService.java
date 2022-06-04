package cn.service;

import cn.domain.User;
import cn.entity.PageResult;


public interface UserService {
    User login(User user);//用户登录
    void addUser(User user);//新增用户
    PageResult searchUser(User user,Integer pageNum,Integer pageSize);
    void updateUser(User user);
    User findUserById(Integer id);

/*    void delUser(Integer id);*/
}
