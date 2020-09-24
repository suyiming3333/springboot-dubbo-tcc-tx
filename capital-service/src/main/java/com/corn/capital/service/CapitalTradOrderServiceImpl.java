package com.corn.capital.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.corn.capital.CapitalTradeOrderService;

import com.corn.capital.vo.CapitalTradeOrderDto;
import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.dubbo.context.DubboTransactionContextEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service(interfaceClass = CapitalTradeOrderService.class)
public class CapitalTradOrderServiceImpl implements CapitalTradeOrderService {


    @Override
    @Compensable(confirmMethod = "confirmRecord", cancelMethod = "cancelRecord", transactionContextEditor = DubboTransactionContextEditor.class)
    public void payRecord(CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("try pay record");
//        throw new RuntimeException("capital service");
    }

    public void confirmRecord(CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("concirm pay record");
    }

    public void cancelRecord(CapitalTradeOrderDto tradeOrderDto) {
        System.out.println("cancel pay record");
    }
}
