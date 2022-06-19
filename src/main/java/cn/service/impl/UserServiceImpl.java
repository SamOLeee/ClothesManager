package cn.service.impl;

import cn.domain.Goods;
import cn.domain.User;
import cn.entity.PageResult;
import cn.entity.Result;
import cn.service.UserService;
import cn.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User checkName(String name) {
        return userMapper.checkName(name);
    }


    @Override
    public User checkEmail(String email) {
        return userMapper.checkEmail(email);
    }


    public PageResult searchUser(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page = userMapper.searchUser(user);
        return new PageResult(page.getTotal(), page.getResult());
    }

    public void updateUser(User user) {
        /*        System.out.println("impl"+user);*/
        userMapper.editUser(user);
    }

    public void delUser(Integer id) {
        User user = this.findUserById(id);
        user.setDelete(1);
        userMapper.editUser(user);
    }

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public Result updateUserPwd(User user) {
        User u = this.findUserById(user.getId());
        u.setPassword(user.getPassword());
        userMapper.editUser(user);
        return new Result(true, "密码修改成功！");
    }

    public String createUserNo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        String t = dateFormat.format(new Date());
        String randomString = RandomStringUtils.randomNumeric(6);
        String userNo = "UR" + t + randomString;
        return userNo;
    }
}
