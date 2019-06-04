package com.zking.service.impl;

import com.zking.dao.BankDao;
import com.zking.model.Bank;
import com.zking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankService")
public class BankServiceImpl implements BankService {
    @Autowired
    private BankDao bankDao;
    @Override
    public List<Bank> getbanks(Integer uid) {
        return bankDao.getbanks(uid);
    }
}
