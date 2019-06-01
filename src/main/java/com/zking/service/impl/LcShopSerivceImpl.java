package com.zking.service.impl;

import com.zking.dao.LcShopDao;
import com.zking.model.LcShop;
import com.zking.service.LcShopSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("lcShopSerivce")
public class LcShopSerivceImpl implements LcShopSerivce {
    @Autowired
    private LcShopDao lcShopDao;

    @Override
    public int addLcShopDao(LcShop lcShop) {
        return lcShopDao.addLcShopDao(lcShop);
    }

    @Override
    public List<LcShop> getLcShopByUid(Integer uid) {
        return lcShopDao.getLcShopByUid(uid);
    }

    @Override
    public List<LcShop> getLcShopByLcid(Integer lcid) {
        return lcShopDao.getLcShopByLcid(lcid);
    }
}
