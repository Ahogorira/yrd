package com.zking.controller;

import com.zking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TxCzController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "cz",produces ="application/text;charset=utf-8")
    public String cz(String money){//充值方法
        if(userService.cz(1,Double.parseDouble(money))>0){
            return "充值成功";
        }
        return "充值失败";
    }

    @ResponseBody
    @RequestMapping(value = "tx",produces ="application/text;charset=utf-8")
    public String tx(String money){//提现方法
        if(userService.tx(1,Double.parseDouble(money))>0){
            return "提现成功，请注意查收";
        }
        return "提现失败";
    }
}
