package com.zking.quartz;


import com.zking.model.Hk;
import com.zking.model.Loan;
import com.zking.model.User;
import com.zking.model.Yq;
import com.zking.service.HkSerivce;
import com.zking.service.LoanService;
import com.zking.service.UserService;
import com.zking.service.YqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
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
    @Autowired
    private UserService userService;//用户service
    @Autowired
    private YqService yqService;//逾期service

    /**
     * 发送扣款提醒短信方法
     */
    @Scheduled(cron = "* * 8 8 * ?")//每月8日早上8点发送扣款提醒短信
    public void node(){
        //从借款申请表中获得所有已通过审核的对象
        List<Loan> loanBysh = loanService.getLoanBysh();
        //定义应发送短信的用户id数组
        List<Integer> uids = new ArrayList<>();
        for (Loan bysh : loanBysh){
            //通过该用户的id获取其还款记录
            Boolean f = false;//定义还款是否已完成的标记
            List<Hk> hkByUid = hkSerivce.getHkByUid(bysh.getUid());
            for (Hk hk : hkByUid) {
                //判断其还款是否已完成
                if(hk.getHkfq()==bysh.getIfq().getFqkx()){
                    f = true;
                }
            }
            if(f==false){//如果未完成，则将其id添加至提醒手机号的集合中
                uids.add(bysh.getUid());
            }

        }
        //调用方法根据uid查找相应用户，给其发送扣款提醒短信
        List<User> userById = userService.getUserById(uids);
        //定义一个手机号集合
        List<String> phones = new ArrayList<>();
        for (User user : userById) {
            phones.add(user.getPhone());
        }

        //调用发送短信方法,将手机号集合传进去,顺便把短信模板编号传进去
        try {
            codeNode(phones,"T170317004265");
        } catch (Exception e) {
            System.out.println("发送短信错误");
            e.printStackTrace();
        }
    }

    //扣款前发送短信方法
    public void codeNode(List<String> phones,String tNum) throws Exception{
        for (String phone : phones) {
            URL u = new URL("http://route.showapi.com/28-1?showapi_appid=90784&mobile="+phone+"&content={%22name%22:%22卧槽%22,%22code%22:%2249791%22}&tNum="+tNum+"&big_msg=1&showapi_sign=36bb53e6712946d5b8bfd554e602cd17");
            InputStream in = u.openStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                byte buf[] = new byte[1024];
                int read = 0;
                while ((read = in .read(buf)) > 0) {
                    out.write(buf, 0, read);
                }
            } finally {
                if ( in != null) {
                    in .close();
                }
            }
            byte b[] = out.toByteArray();
            System.out.println(new String(b, "utf-8"));
        }
    }


    @Scheduled(cron = "* * 8 10 * ?")//每月的10日早上8点进行扣款
    public void AutoMoney_(){//扣款方法
        //从借款申请表中获得所有已通过审核的对象
        List<Loan> loanBysh = loanService.getLoanBysh();
        //遍历该集合
        for (Loan loan : loanBysh) {
            //通过该用户的id获取其还款记录
            Boolean f = false;//定义还款是否已完成的标记
            //根据用户id查询其还款记录
            List<Hk> hkByUid = hkSerivce.getHkByUid(loan.getUid());
            //判断其还款是否已完成
            if(hkByUid.size()!=loan.getIfq().getFqkx()){//未完成还款的进行扣款
                //先获取每期应还本金
                Double money = loan.getMoney()/loan.getIfq().getFqkx();
                //获取每期应还利息
                Double lx =loan.getMoney()*loan.getIfq().getFqlv()/loan.getIfq().getFqkx();
                //得出每期应还总额
                Double zmoney = money+lx;
                //使用用户id查询该用户账户余额是否够当期应还金额
                User user = userService.getByUid(loan.getUid());

                if(user.getMoneyed()>zmoney){//如果用户账户余额小于应扣金额
                    //扣款失败的将其加入到逾期表中去
                    Yq yq = new Yq();//定义一个逾期对象,为其赋值
                    //获得当前时间
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    yq.setUid(user.getUid());
                    yq.setYqtime(simpleDateFormat.format(new Date()));
                    yq.setYqmoney(zmoney);
                    yq.setYqlx(lx);
                    yq.setYqfq(hkByUid.size()+1);
                    yq.setYqzt(1);
                    if(yqService.addYq(yq)<=0){//添加到逾期表
                        System.out.println("添加逾期表记录失败");
                    }
                }else{ //用户账户余额够扣当期金额
                   //调用对应方法进行扣款，并添加还款记录
                    if(userService.delUserMoney(user.getUid(),user.getMoneyed()-zmoney)<=0){
                        System.out.println("扣款错误");
                    }
                    else{//扣款成功，添加还款记录
                        //定义还款对象为其赋值
                        Hk hk = new Hk();
                        hk.setUid(user.getUid());
                        hk.setJkfq(loan.getIfq().getFqkx());
                        hk.setMoney(loan.getMoney());
                        hk.setHkfq(hkByUid.size()+1);
                        hk.setHkMoney(zmoney);
                        //获得当前时间
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        hk.setHktime(simpleDateFormat.format(new Date()));
                        if(hkSerivce.addHk(hk)<=0){
                            System.out.println("添加还款记录错误");
                        }
                    }

                }


            }
        }
    }

    //逾期方法
    @Scheduled(cron = "* * 8 * * ?")//每天早上8点提醒一次还款，并尝试再次扣款
    public void yuqi(){
        //查询逾期表中的未还款记录
        List<Yq> yqAllw = yqService.getYqAllw();
        for (Yq yq : yqAllw) {
            User user = userService.getByUid(yq.getUid());
            if(user.getMoneyed()>=yq.getYqmoney()){
                //调用扣款方法
                if(userService.delUserMoney(user.getUid(),user.getMoneyed()-yq.getYqmoney())<=0){
                    System.out.println("扣款错误");
                }else{
                    //定义还款对象为其赋值
                    Hk hk = new Hk();
                    hk.setUid(user.getUid());
                    //根据用户id获取借款记录获取期数
                    Integer qs = loanService.getLoanByUid(user.getUid()).get(0).getIfq().getFqkx();
                    hk.setJkfq(qs);
                    hk.setMoney(yq.getYqmoney());
                    hk.setHkfq(yq.getYqfq());
                    hk.setHkMoney(yq.getYqmoney());
                    //获得当前时间
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    hk.setHktime(simpleDateFormat.format(new Date()));
                    if(hkSerivce.addHk(hk)<=0){
                        System.out.println("添加还款记录错误");
                    }else{
                        //再修改逾期表中的还款状态与逾期截止时间
                    }
                }
            }else{
                //再次扣款失败调用发送短信方法提醒
                yqH();
                //并提升还款金额（+罚息）
            }
        }
    }

    //逾期后发送短信方法
    public void yqH(){

    }



    //逾期即将一整期，将要拉黑发送短信提醒方法
    @Scheduled(cron = "* * * 11 * ?")//每月的11日筛选逾期即将一整期未还的用户
    public void brakNames(){
        //获取所有逾期未还记录
        List<Yq> yqAllw = yqService.getYqAllw();
        for (Yq yq : yqAllw) {
            //获取逾期时间
            String yqtime = yq.getYqtime();
            //获取逾期月份
            Integer yqmonth = Integer.parseInt(yqtime.substring(yqtime.indexOf("-")+1,yqtime.indexOf("-")+3));
            //获取当前月份
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = simpleDateFormat.format(new Date());
            Integer month = Integer.parseInt(date.substring(date.indexOf("-")+1),date.indexOf("-")+3);
            //判断是否为即将逾期一整期
            if(yqmonth<month){
                //发送即将拉黑的提醒短信
                brakNode();
            }
        }

    }

    //发送提醒拉黑短信提醒
    public void brakNode(){

    }


    //逾期一整期拉黑方法
    @Scheduled(cron = "* * * 13 * ?")//每月的12日筛选逾期即将一整期未还的用户
    public void brakNameK(){
        //获取所有逾期未还记录
        List<Yq> yqAllw = yqService.getYqAllw();
        for (Yq yq : yqAllw) {
            //获取逾期时间
            String yqtime = yq.getYqtime();
            //获取逾期月份
            Integer yqmonth = Integer.parseInt(yqtime.substring(yqtime.indexOf("-")+1,yqtime.indexOf("-")+3));
            //获取当前月份
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = simpleDateFormat.format(new Date());
            Integer month = Integer.parseInt(date.substring(date.indexOf("-")+1),date.indexOf("-")+3);
            //判断是否为逾期一整期
            if(yqmonth<month){
                //将当前用户状态修改为黑名单
                //获取用户id后调用拉黑方法
                yq.getUid();
            }
        }
    }


    /*public static void main(String[] args) {
        //获得当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = simpleDateFormat.format(new Date());

        String sub = date.substring(0,date.indexOf("-")+3);

        String date2 = "2019-12-02 07:59:57";

        String sub2 = date2.substring(0,date2.indexOf("-")+3);


        System.out.println(sub2);
        System.out.println(date);

    }*/
}
