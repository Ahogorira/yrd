package com.zking.dao;

import com.zking.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanDao {
    /**
     * 获取所有审核通过的借款申请
     * @return
     */
    public List<Loan> getLoanBysh();
}
