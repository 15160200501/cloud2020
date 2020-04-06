package com.ming.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;


public interface StorageService {

    // 扣减库存
    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
