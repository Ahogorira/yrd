package com.zking.dao;

import com.zking.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Component
public interface UserDaoTest {
    /**
     * 查询所有用户
     * @return
     */
    List<User> queryUserAll();

    /**
     * 根据用户名查找用户对象
     * @param uname
     * @return
     */
    public User checkByName(String uname);

    /**
     * 根据用户id查找持有权限
     * @param uid
     * @return
     */
    public List<Map<String,Object>> getRoleById(Integer uid);
}
