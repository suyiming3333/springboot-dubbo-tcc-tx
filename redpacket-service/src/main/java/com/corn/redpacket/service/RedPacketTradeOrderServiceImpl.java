package com.corn.redpacket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.corn.redpacket.RedPacketTradeOrderService;
import com.corn.redpacket.vo.RedPacketTradeOrderDto;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass = RedPacketTradeOrderService.class,group = "default")
public class RedPacketTradeOrderServiceImpl implements RedPacketTradeOrderService {


    @Override
    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = DubboTransactionContextEditor.class)
    public void payRecord(RedPacketTradeOrderDto redPacketTradeOrderDto) {
        System.out.println("try redpackage record");
//        throw new RuntimeException("red packet");
    }

    public void confirmRecord(RedPacketTradeOrderDto redPacketTradeOrderDto) {
        System.out.println(" try redpackage confirmRecord");
    }

    public void cancelRecord(RedPacketTradeOrderDto redPacketTradeOrderDto) {
        System.out.println(" try redpackage cancelRecord");
    }
}
