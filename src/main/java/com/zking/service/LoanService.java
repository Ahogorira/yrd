package com.zking.service;

import com.zking.model.Loan;

import java.util.List;

public interface LoanService {
    /**
     * 获取所有审核通过的借款申请
     * @return
     */
    public List<Loan> getLoanBysh();
}
