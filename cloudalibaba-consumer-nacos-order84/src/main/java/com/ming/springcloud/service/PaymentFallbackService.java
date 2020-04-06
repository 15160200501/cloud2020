package com.ming.springcloud.service;

import com.ming.springcloud.CommonResult;
import com.ming.springcloud.Payment;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444444,"服务降级返回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
