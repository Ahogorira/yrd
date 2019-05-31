package com.zking.model;

import java.io.Serializable;

public class LcShop implements Serializable {
    private Integer lsid;//理财购买记录id
    private Double lsMoney;//购买金额
    private Double lssy;//理财收益
    private User user;//用户id
    private Lccp lccp;//理财产品id

}
