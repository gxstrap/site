package com.rpc.auth.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpc.auth.mapper.UserMapper;
import com.rpc.auth.model.User;
import com.rpc.auth.service.UserService;
import com.rpc.auth.util.UserEncodes;
import com.rpc.common.constants.Constants;
import com.rpc.common.exception.BusinessException;
import com.rpc.util.DateUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new BusinessException("user.registr.error", "注册信息错误");
        }

        if (StringUtils.isBlank(user.getLoginName()) || StringUtils.isBlank(user.getPassword())) {
            throw new BusinessException("user.registr.error", "注册信息错误");
        }

        UserEncodes.entryptPassword(user);
        user.setIsDel(Constants.IS_DEL_N);
        user.setCreateTime(DateUtil.getSystemDateTime());
        userMapper.insert(user);
    }

}
