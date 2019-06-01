package com.zking.service;

import com.zking.model.LcShop;

import java.util.List;

public interface LcShopSerivce {

    /**
     * 增加理财产品购买记录
     * @param lcShop
     * @return
     */
    public int addLcShopDao(LcShop lcShop);

    /**
     * 根据用户id查询理财产品购买记录
     * @param uid
     * @return
     */
    public List<LcShop> getLcShopByUid(Integer uid);

    /**
     * 根据理财产品id获取理财产品购买记录
     * @param lcid
     * @return
     */
    public List<LcShop> getLcShopByLcid(Integer lcid);
}
