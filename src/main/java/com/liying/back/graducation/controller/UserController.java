package com.liying.back.graducation.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.liying.back.graducation.common.QueryPageParam;
import com.liying.back.graducation.common.Result;
import com.liying.back.graducation.entity.User;
import com.liying.back.graducation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liying
 * @since 2024-02-20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //    增删改查实现
    @Autowired
    private UserService userService;


    //    查询
    @GetMapping
    public Result selectList(){
        if(Result.suc(userService.list())!=null){
            return  Result.suc(userService.list());
        }else {
            return Result.fail();
        }
    }
    @GetMapping("/{id}")
    public Result selectByid(@PathVariable Integer id){
        if(userService.getById(id)!=null){
            return Result.suc(userService.getById(id));
        }else {
            return Result.fail();
        }

    }
    //   增加
    @PostMapping()
    public Result save(@RequestBody User user){
        return userService.save(user)?Result.suc():Result.fail();
    }
    //    修改
    @PutMapping
    public Result update(@RequestBody User user){
        if(userService.updateById(user)){
            return Result.suc(userService.updateById(user));
        }else {
            return Result.fail();
        }
    }
    //    删除
    @DeleteMapping("/{id}")
    public Result deleted(@PathVariable Integer id){
        if(userService.removeById(id)){
            return Result.suc(userService.removeById(id));
        }else {
            return Result.fail();
        }
    }
    //    新增或修改
    @PostMapping("/saveOrupdate")
    public Result saveOrupdate(@RequestBody User user){
        if(userService.saveOrUpdate(user)){
            return Result.suc(userService.saveOrUpdate(user));
        }else {
            return Result.fail();
        }
    }
    //    模糊查询like
    @PostMapping("/listP")
    public Result listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(lambdaQueryWrapper.like(User::getUsername,user.getUsername())!=null)
        {   return Result.suc(userService.list(lambdaQueryWrapper));
        }else {
            return Result.fail();
        }

    }

    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query){
        IPage page=new Page(query.getPageCurrent(),query.getPageSize());
        HashMap param = query.getParam();
        String name= (String) param.get("username");


        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(User::getUsername,name);
        }


        IPage iPage = userService.page(page,lambdaQueryWrapper);

        return Result.suc(iPage.getRecords(),iPage.getTotal());
    }


}
