package com.zking.service;

import com.zking.model.Bank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankService {
    /**
     * 按用户id查询该用户所持有的银行卡
     */
    public List<Bank> getbanks(@Param("uid") Integer uid);
}
