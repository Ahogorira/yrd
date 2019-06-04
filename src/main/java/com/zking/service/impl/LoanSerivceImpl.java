package com.zking.service.impl;

import com.zking.dao.LoanDao;
import com.zking.model.Jkfq;
import com.zking.model.Loan;
import com.zking.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("loanService")
public class LoanSerivceImpl implements LoanService {
    @Autowired
    private LoanDao loanDao;

    @Override
    public List<Loan> getLoanBysh() {
        return loanDao.getLoanBysh();
    }

    @Override
    public List<Map<String, Object>> getLoanAndfq() {
        return loanDao.getLoanAndfq();
    }

    @Override
    public List<Loan> getLoanByUid(Integer uid) {
        return loanDao.getLoanByUid(uid);
    }


}
