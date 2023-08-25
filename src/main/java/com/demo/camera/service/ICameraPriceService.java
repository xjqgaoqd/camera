package com.demo.camera.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraPrice;

import java.util.List;

public interface ICameraPriceService extends IService<CameraPrice> {
    ApiResponse<List<CameraPrice>> queryByCondition(ParameterCondition param);

    void queryNewPrice(List<Integer> camIds);
}
