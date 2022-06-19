package cn.service;

import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;
import cn.entity.Result;


public interface UserService {
    User login(User user);//用户登录
    void addUser(User user);//新增用户
    PageResult searchUser(User user,Integer pageNum,Integer pageSize);
    void updateUser(User user);
    User findUserById(Integer id);
    User checkName(String name);
    User checkEmail(String email);
    void delUser(Integer id);
    Result updateUserPwd(User user);
    String createUserNo();
}
