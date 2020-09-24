package com.corn.pay.transaction;

import com.alibaba.dubbo.config.annotation.Reference;
import com.corn.capital.CapitalTradeOrderService;
import com.corn.capital.vo.CapitalTradeOrderDto;
import com.corn.redpacket.RedPacketTradeOrderService;
import com.corn.redpacket.vo.RedPacketTradeOrderDto;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @Autowired
    private RedPacketTradeOrderService redPacketTradeOrderService;

    @Autowired
    private CapitalTradeOrderService capitalTradeOrderService;

    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", asyncConfirm = true)
    public void sendMessage(String message){
        System.out.println("开始执行主业务");
        System.out.println("this is consumer sendMessage message="+message);
//
//        System.out.println(serviceAPI.sendMessage(message));
        System.out.println("开始执行多个子业务");

        // 测试业务
        //调用红包服务
        redPacketTradeOrderService.payRecord(new RedPacketTradeOrderDto());

        //调用余额服务
        capitalTradeOrderService.payRecord(new CapitalTradeOrderDto());

        throw new RuntimeException("test");

    }

    public void confirmSendMessage(String message){
        System.out.println("this is consumer confirmSendMessage message="+message);
//        System.out.println(serviceAPI.sendMessage(message));
    }

    public void cancelSendMessage(String message){
        System.out.println("this is consumer cancelSendMessage message="+message);
//        System.out.println(serviceAPI.sendMessage(message));
    }
}
