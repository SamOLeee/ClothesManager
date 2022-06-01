package cn.service.impl;

import cn.domain.User;
import cn.entity.PageResult;
import cn.service.UserService;
import cn.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
    public void addUser(User user){
        userMapper.addUser(user);
    }
    public PageResult searchUser(User user,Integer pageNUm,Integer pageSize){
        PageHelper.startPage(pageNUm,pageSize);
        Page<User> page=userMapper.searchUser(user);
        return new PageResult(page.getTotal(),page.getResult());
    }
    public User findByUserId(Integer id){
        return userMapper.findByUserId(id);
    }
}
