package com.zking.dao;

import com.zking.model.Lccp;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LccpDao {
    /**
     * 添加理财产品
     * @param lccp
     * @return
     */
    public int addLccp(Lccp lccp);

    /**
     * 删除理财产品
     * @param lcid
     * @return
     */
    public int delLccp(Integer lcid);


    /**
     * 修改理财产品
     * @param lccp
     * @return
     */
    public int updateLccp(Lccp lccp);

    /**
     * 查询所有理财产品
     * @return
     */
    public List<Lccp> getAllLccp();

    /**
     * 根据id查询相应理财产品
     * @param lcid
     * @return
     */
    public Lccp getLccpByid(Integer lcid);


}
