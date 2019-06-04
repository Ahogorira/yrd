package com.zking.controller;

import com.google.gson.Gson;
import com.zking.model.Bank;
import com.zking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankController {
    @Autowired
    private  BankService bankService;

    @ResponseBody
    @RequestMapping(value = "bankByUid",produces ="application/text;charset=utf-8")
    public String getBankByUid(){
        //获取当期用户id
        //调用查询银行卡方法
        Gson gson = new Gson();
        String str = "无卡";
        System.out.println(bankService.getbanks(1).size());
        if(bankService.getbanks(1).size()>0){
            str = gson.toJson(bankService.getbanks(1));
        };
        return str;
    }


}

