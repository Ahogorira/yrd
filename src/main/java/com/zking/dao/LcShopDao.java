package com.zking.dao;

import com.zking.model.LcShop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LcShopDao {
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
