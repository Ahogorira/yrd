package com.zking.quartz;


import com.zking.model.Hk;
import com.zking.model.Loan;
import com.zking.service.HkSerivce;
import com.zking.service.LoanService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定时扣款类
 */
@Component
public class AutoMoney{
    @Autowired
    private LoanService loanService;//借款service
    @Autowired
    private HkSerivce hkSerivce;//还款service



    /**
     * 发送提醒短信方法
     */
    @Scheduled(cron = "* * 8 8 * ?")//每月8日早上8点发送扣款提醒短信
    public void node(){
        //从借款申请表中获得所有已通过审核的对象
        List<Loan> loanBysh = loanService.getLoanBysh();
        //定义应发送短信的用户id数组
        List<Integer> uids = new ArrayList<>();
        for (Loan bysh : loanBysh){
            uids.add(bysh.getUid());
        }
        //调用方法根据uid查找相应用户，给其发送扣款提醒短信

    }



    @Scheduled(cron = "* * 8 10 * ?")//每月的10日早上8点进行扣款
    public void AutoMoney_(){//扣款方法
        //从借款申请表中获得所有已通过审核的对象
        List<Loan> loanBysh = loanService.getLoanBysh();
        //遍历该集合
        for (Loan bysh : loanBysh) {
            //通过该用户的id获取其还款记录
            Boolean f = false;//定义还款是否已完成的标记
            List<Hk> hkByUid = hkSerivce.getHkByUid(bysh.getUid());
            for (Hk hk : hkByUid) {
                //判断其还款是否已完成
                if(hk.getHkfq()==bysh.getIfq()){
                    f = true;
                }
            }
            if(f==false){//未完成还款的进行扣款
                //扣款失败的将其加入到逾期表中去
            }
        }
    }


    //逾期方法
    @Scheduled(cron = "* * 8 * * ?")//每天早上8点提醒一次还款
    public void yuqi(Integer uid){

    }

    //逾期即将一整期，将要拉黑发送短信提醒方法
    @Scheduled(cron = "* * * 9 * ?")//每月的9日筛选逾期即将一整期未还的用户
    public void brakNames(){

    }
}
