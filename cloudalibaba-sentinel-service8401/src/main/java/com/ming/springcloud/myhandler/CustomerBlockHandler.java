package com.ming.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ming.springcloud.CommonResult;
import com.ming.springcloud.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(4444,"按客户自定义,global Handler----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义,global Handler----2");
    }
}
