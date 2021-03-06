package com.zking.service;

import com.zking.model.Hk;

import java.util.List;

public interface HkSerivce {
    /**
     * 添加还款信息
     * @param hk
     * @return
     */
    public int addHk(Hk hk);

    /**
     * 根据用户id查找相应还款信息
     * @param uid
     * @return
     */
    public List<Hk> getHkByUid(Integer uid);
}
