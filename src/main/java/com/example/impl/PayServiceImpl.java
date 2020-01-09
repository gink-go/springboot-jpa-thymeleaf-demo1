package com.example.impl;

import com.example.pay.PayService;

public class PayServiceImpl implements PayService {
    @Override
    public void add(Double money) {
        System.out.print("支付增加");
    }

    @Override
    public void update(Double money) {
        System.out.print("支付更新");
    }

    @Override
    public void delete(Long id) {
        System.out.print("支付删除");
    }
}
