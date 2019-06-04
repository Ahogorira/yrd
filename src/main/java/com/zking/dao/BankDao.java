package com.zking.dao;

import com.zking.model.Bank;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BankDao {
    /**
     * 按用户id查询该用户所持有的银行卡
     */
    public List<Bank> getbanks(Integer uid);
}
