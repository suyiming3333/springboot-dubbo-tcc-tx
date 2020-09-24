package com.corn.alipay;


import java.math.BigDecimal;

public interface CombinePayServiceAPI {
    /**
     * 组合支付
     * 红包支付+余额支付
     * @param orderId
     * @param redPacketPayAmount
     * @param capitalPayAmount
     * @return
     */
    void combinePay(String orderId, long userId, BigDecimal redPacketPayAmount, BigDecimal capitalPayAmount);

}
