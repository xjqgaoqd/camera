package com.demo.camera.common;

import com.demo.camera.service.ICameraInfoService;
import com.demo.camera.service.ICameraPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceUpdateScheduler {

    @Autowired
    ICameraPriceService cameraPriceService;

    @Autowired
    ICameraInfoService cameraInfoService;

    @Scheduled(cron = "0 0 0 */2 * ?") // 每隔两天执行一次，参考Cron表达式
    public void updateProductPriceAndSave() {
        List<Integer> integerList = cameraInfoService.list().stream().map(c -> c.getId()).collect(Collectors.toList());
        cameraPriceService.queryNewPrice(integerList);
        System.out.println("商品价格已更新并保存");
    }
}

