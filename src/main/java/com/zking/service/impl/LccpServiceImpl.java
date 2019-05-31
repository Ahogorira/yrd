package com.zking.service.impl;

import com.zking.dao.LccpDao;
import com.zking.model.Lccp;
import com.zking.service.LccpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lccpService")
public class LccpServiceImpl implements LccpService {
    @Autowired
    private LccpDao lccpDao;

    @Override
    public int addLccp(Lccp lccp) {
        return lccpDao.addLccp(lccp);
    }

    @Override
    public int delLccp(Integer lcid) {
        return lccpDao.delLccp(lcid);
    }

    @Override
    public int updateLccp(Lccp lccp) {
        return lccpDao.updateLccp(lccp);
    }

    @Override
    public List<Lccp> getAllLccp() {
        return lccpDao.getAllLccp();
    }

    @Override
    public Lccp getLccpByid(Integer lcid) {
        return lccpDao.getLccpByid(lcid);
    }
}
