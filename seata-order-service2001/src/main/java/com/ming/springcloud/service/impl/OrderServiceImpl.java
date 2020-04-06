package com.ming.springcloud.service.impl;

import com.ming.springcloud.dao.OrderDao;
import com.ming.springcloud.domain.Order;
import com.ming.springcloud.service.AccountService;
import com.ming.springcloud.service.OrderService;
import com.ming.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---------->开始新建订单");
        //1.新建订单
        orderDao.create(order);

        log.info("---------->订单微服务开始调用库存，做扣减count");
        //2.扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---------->订单微服务调用库存，做扣减end");

        log.info("---------->订单微服务开始调用账户，做扣减money");
        //3.扣减账户
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---------->订单微服务调用账户，做扣减end");

        //4.修改订单的状态，从零到1，1代表已经完成
        log.info("---------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("---------->修改订单状态结束");

        log.info("------------>下订单结束了，哈哈");
    }
}
