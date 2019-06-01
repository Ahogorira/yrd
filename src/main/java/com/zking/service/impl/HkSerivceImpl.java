package com.zking.service.impl;

import com.zking.dao.HkDao;
import com.zking.model.Hk;
import com.zking.service.HkSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("hkSerivce")
public class HkSerivceImpl implements HkSerivce {
    @Autowired
    private HkDao hkDao;
    @Override
    public int addHk(Hk hk) {
        return hkDao.addHk(hk);
    }

    @Override
    public List<Hk> getHkByUid(Integer uid) {
        return hkDao.getHkByUid(uid);
    }
}
