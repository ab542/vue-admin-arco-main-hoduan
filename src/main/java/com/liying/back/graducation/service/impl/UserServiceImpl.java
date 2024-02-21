package com.liying.back.graducation.service.impl;

import com.liying.back.graducation.entity.User;
import com.liying.back.graducation.mapper.UserMapper;
import com.liying.back.graducation.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liying
 * @since 2024-02-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
