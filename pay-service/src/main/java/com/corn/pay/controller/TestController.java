package com.corn.pay.controller;


import com.corn.pay.transaction.TransactionConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/")
public class TestController {

    @Autowired
    private TransactionConsumer transactionConsumer;

    @RequestMapping(value = "test",method = RequestMethod.POST)
    public void testCombinePay(){
        transactionConsumer.sendMessage("6666");
//        log.info("支付结果：{}",result);
    }
}
