package com.ssm.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.demo.common.pojo.AjaxResult;
import com.ssm.demo.common.pojo.PageAjax;
import com.ssm.demo.model.User;
import com.ssm.demo.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //ResponsBody 自动映射到字段上 前提是字段要相同
    @ResponseBody
    @RequestMapping("/queryById")
    public AjaxResult queryById(int id){
//		User user = userService.selectById(id);
        Object user = userService.selectById(id);
        return new AjaxResult(user);
    }

    @ResponseBody
    @RequestMapping("/queryOne")
    public AjaxResult queryOne(User user){
        Object obj = userService.selectOne(user);
        return new AjaxResult(obj);
    }

    ////ResponsBody 可以自动将参数封装到对象上，前提是参数名称和对象属性名称相同
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResult queryList(User user){
        List<?> list = userService.selectList(user);
        return new AjaxResult(list);
    }

    @ResponseBody
    @RequestMapping("/queryPage")
    public PageAjax<User> queryPage(User user, PageAjax<User> page){
        return userService.selectPage(user, page);
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(User user){
        //保存map测试
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", user.getUsername());
        map.put("email", user.getEmail());
        map.put("useable", user.getUseable());
        map.put("password", user.getPassword());
        userService.save(map);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/update")
    public AjaxResult update(User user){
        //更新map测试
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", user.getId());
//		map.put("email", user.getEmail());
//		map.put("useable", user.getUseable());
//		map.put("password", user.getPassword());
        userService.update(user);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/batchSave")
    public AjaxResult batchSave(){
//		List<User> list = new ArrayList<User>();
//		User user = null;
//		for(int i = 0; i < 10; i ++){
//			user = new User();
//			String username = "ourte" + i;
//			user.setUsername(username);
//			user.setPassword("123456");
//			user.setUseable(1);
//			user.setEmail(username + "@163.com");
//			list.add(user);
//		}

        //map批量保存
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for(int i = 0; i < 10; i ++){
            map = new HashMap<String, Object>();
            String username = "csefgg" + i;
            map.put("username", username);
            map.put("email", username + "@163.com");
            map.put("useable", 1);
            map.put("password", "658264");
            list.add(map);
        }
        userService.batchSave(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/batchUpdate")
    public AjaxResult batchUpdate(){
        Integer[] ids = new Integer[]{30, 31, 32};

//		List<User> list = new ArrayList<User>();
//		User user = null;
//		for(int id: ids){
//			user = new User();
//			user.setId(id);
//			user.setPassword("654321");
//			user.setUseable(0);
//			user.setEmail("csew@163.com");
//			list.add(user);
//		}

        //map批量更新
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for(int id: ids){
            map = new HashMap<String, Object>();
            map.put("id", id);
            map.put("email", "dfdwfg@163.com");
            map.put("useable", 1);
            map.put("password", "565656");
            list.add(map);
        }
        userService.batchUpdate(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/delList")
    public AjaxResult delList(Integer[] ids){
        List<Integer> list = Arrays.asList(ids);
        userService.delList(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/delArray")
    public AjaxResult delArray(int[] ids){
        userService.delArray(ids);
        return new AjaxResult();
    }

}

