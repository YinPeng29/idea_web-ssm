package com.ssm.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssm.demo.common.pojo.AjaxResult;
import com.ssm.demo.common.pojo.PageAjax;
import com.ssm.demo.model.IMemberOrders;
import com.ssm.demo.service.OrderService;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/queryById")
    public AjaxResult queryById(int id){
        IMemberOrders order = (IMemberOrders) orderService.selectById(id);
        return new AjaxResult(order);
    }

    @ResponseBody
    @RequestMapping("/queryOne")
    public AjaxResult queryOne(IMemberOrders order){
        IMemberOrders $order = (IMemberOrders) orderService.selectOne(order);
        return new AjaxResult($order);
    }

    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResult queryList(IMemberOrders order){
        List<?> list = orderService.selectList(order);
        return new AjaxResult(list);
    }

    @ResponseBody
    @RequestMapping("/queryPage")
    public PageAjax<IMemberOrders> queryPage(IMemberOrders order, PageAjax<IMemberOrders> page){
        return orderService.selectPage(order, page);
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(IMemberOrders order){
        order.setOrdercode(System.currentTimeMillis() + "");
        order.setNickname("我是天王");
        order.setShopname("好东西");
        order.setBuycount(5);
        order.setPaycount(100.0);
        order.setBuytime("2017-06-08 19:00:00");
        orderService.save(order);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/update")
    public AjaxResult update(IMemberOrders order){
        order.setOrdercode(System.currentTimeMillis() + "");
        order.setNickname("我是天王aaa");
        order.setShopname("好东西");
        order.setBuycount(5);
        order.setPaycount(100.0);
        orderService.update(order);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/batchSave")
    public AjaxResult batchSave(){
        List<IMemberOrders> list = new ArrayList<IMemberOrders>();
        IMemberOrders order = null;
        for(int i = 0; i < 10; i++){
            order = new IMemberOrders();
            order.setOrdercode(System.currentTimeMillis() + i + "");
            order.setNickname("我是天王");
            order.setShopname("好东西");
            order.setBuycount(5);
            order.setPaycount(100.0);
            order.setBuytime("2017-06-08 19:00:00");
            list.add(order);
        }
        orderService.batchSave(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/batchUpdate")
    public AjaxResult batchUpdate(){
        Long[] ids = new Long[]{3767097l, 3767096l, 3767095l, 3767094l, 3767093l};

        List<IMemberOrders> list = new ArrayList<IMemberOrders>();
        IMemberOrders order = new IMemberOrders();
        for(Long id: ids){
            order = new IMemberOrders();
            order.setOid(id);
            order.setNickname("我是天王" + id);
            order.setShopname("好东西" + id);
            order.setBuycount(15);
            order.setPaycount(200.0);
            list.add(order);
        }
        orderService.batchUpdate(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/delList")
    public AjaxResult delList(Integer[] ids){
        List<Integer> list = Arrays.asList(ids);
        orderService.delList(list);
        return new AjaxResult();
    }

    @ResponseBody
    @RequestMapping("/delArray")
    public AjaxResult delArray(int[] ids){
        orderService.delArray(ids);
        return new AjaxResult();
    }

}

