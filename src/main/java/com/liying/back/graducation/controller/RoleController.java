package com.liying.back.graducation.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liying.back.graducation.common.QueryPageParam;
import com.liying.back.graducation.common.Result;
import com.liying.back.graducation.entity.Role;
import com.liying.back.graducation.entity.User;
import com.liying.back.graducation.service.IRoleService;
import com.liying.back.graducation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liying
 * @since 2024-02-20
 */
@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    //    增删改查实现
    @Autowired
    private IRoleService roleService;

    //   增加
    @PostMapping()
    public Result save(@RequestBody  Role role){
        return roleService.save(role)?Result.suc():Result.fail();
    }

    //    查询
    @GetMapping
    public Result selectList(){
        if( Result.suc(roleService.list())!=null){
            return  Result.suc(roleService.list());
        }else {
            return Result.fail();
        }
    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        IPage page=new Page(query.getPageCurrent(),query.getPageSize());
        HashMap param = query.getParam();
        String name= (String) param.get("username");

        LambdaQueryWrapper<Role> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(Role :: getName,name);
        }

        IPage iPage = roleService.page(page,lambdaQueryWrapper);

        return Result.suc(iPage.getRecords(),iPage.getTotal());
    }

}
