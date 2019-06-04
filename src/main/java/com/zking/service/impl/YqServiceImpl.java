package com.zking.service.impl;

import com.zking.dao.YqDao;
import com.zking.model.Yq;
import com.zking.service.YqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("yqService")
public class YqServiceImpl implements YqService {

    @Autowired
    private YqDao yqDao;

    @Override
    public int addYq(Yq yq) {
        return yqDao.addYq(yq);
    }

    @Override
    public List<Yq> getYqAllw() {
        return yqDao.getYqAllw();
    }

    @Override
    public List<Yq> getYqAll() {
        return yqDao.getYqAll();
    }

    @Override
    public int updateYq(Integer yqid) {
        return yqDao.updateYq(yqid);
    }

}
