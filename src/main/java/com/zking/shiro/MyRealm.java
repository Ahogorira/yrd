package com.zking.shiro;


import com.zking.dao.UserDaoTest;
import com.zking.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDaoTest userDaoTest;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       //1,授权主体
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        System.out.println("授权");
        //2，获取当前用户的对象，再获得uid,并调用方法获取持有权限
        User user = userDaoTest.checkByName(principalCollection.getPrimaryPrincipal().toString());
        List<Map<String, Object>> roles = userDaoTest.getRoleById(user.getUid());
        //3,如果权限不为空
        if(roles!=null&&roles.size()!=0){
            //遍历授权
            for (Map<String, Object> role : roles) {
                if(role!=null&&role.size()!=0){
                    //给当前用户添加授权码
                    info.addStringPermission(role.get("codes").toString());
                }
            }
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //1，获取用户输入的账户信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userDaoTest.checkByName(token.getUsername());
        //判断用户是否存在，不存在返回null
        if(user==null){
            return null;
        }
        //返回密码
        return new SimpleAuthenticationInfo(user.getUname(),user.getUpwd(),getName());

    }
}
