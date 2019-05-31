package com.zking.controller;

import com.zking.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserControllerTest {

    @RequestMapping(value = "/login")
    public String login(User user, HttpServletRequest request){
        //使用shiro认证框架
        //1，获得subject对象
        Subject subject = SecurityUtils.getSubject();
        //2,封装用户信息（用户名和密码）
        AuthenticationToken token = new UsernamePasswordToken(user.getUname(), user.getUpwd());
        //3,开始认证
        try {
            //将用户名和密码传入认证方法
            subject.login(token);

            //获取principal,取得用户名
            String username = subject.getPrincipal().toString();
            //4，登陆成功
            //将用户名存入session
            request.getSession().setAttribute("uname",username);
            return "success.jsp";
        }catch (UnknownAccountException e){
            //账户不存在，把该信息传回到login.jsp
            System.out.println("账户不存在");
            return "login.jsp";
        }catch (AuthenticationException e){
            //账户或密码错误
            System.out.println("账户或密码错误");
            return "login.jsp";
        }

    }
}
