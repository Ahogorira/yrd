package com.zking.service;

import com.zking.model.Jkfq;
import com.zking.model.Loan;

import java.util.List;
import java.util.Map;

public interface LoanService {
    /**
     * 获取所有审核通过的借款申请
     * @return
     */
    public List<Loan> getLoanBysh();

    /**
     * 获取所有审核通过的借款申请和其利率
     * @return
     */
    public List<Map<String,Object>> getLoanAndfq();

    /**
     * 根据用户id获取其相应的借款记录
     * @param uid
     * @return
     */
    public List<Loan> getLoanByUid(Integer uid);
}
