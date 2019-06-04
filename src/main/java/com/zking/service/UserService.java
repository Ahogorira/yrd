package com.zking.service;

import com.zking.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 根据id集合查询相应的用户
     * @param uids
     * @return
     */
    public List<User> getUserById(List<Integer> uids);

    /**
     * 根据用户id还（扣款）相应金额方法
     * @param uid
     * @param money
     * @return
     */
    public int delUserMoney(@Param("uid")Integer uid, @Param("money")Double money);

    /**
     * 根据用户id查询单个用户
     * @param uid
     * @return
     */
    public User getByUid(Integer uid);


    /**
     * 充值方法
     * @param uid
     * @param money
     * @return
     */
    public int cz(@Param("uid")Integer uid, @Param("money")Double money);


    /**
     * 提现方法
     * @param uid
     * @param money
     * @return
     */
    public int tx(@Param("uid")Integer uid, @Param("money")Double money);
}
