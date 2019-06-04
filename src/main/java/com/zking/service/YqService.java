package com.zking.service;

import com.zking.model.Yq;

import java.util.List;

public interface YqService {
    /**
     * 添加逾期记录
     * @param yq
     * @return
     */
    public int addYq(Yq yq);

    /**
     * 查询逾期表中的未还记录
     * @return
     */
    public List<Yq> getYqAllw();
    /**
     * 查询逾期表中的所有记录
     * @return
     */
    public List<Yq> getYqAll();

    /**
     * 修改逾期状态（未还改已还）
     * @param yqid
     * @return
     */
    public int updateYq(Integer yqid);
}
