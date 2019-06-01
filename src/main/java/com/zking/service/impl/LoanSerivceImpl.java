package com.zking.service.impl;

import com.zking.dao.LoanDao;
import com.zking.model.Loan;
import com.zking.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loanService")
public class LoanSerivceImpl implements LoanService {
    @Autowired
    private LoanDao loanDao;

    @Override
    public List<Loan> getLoanBysh() {
        return loanDao.getLoanBysh();
    }
}
