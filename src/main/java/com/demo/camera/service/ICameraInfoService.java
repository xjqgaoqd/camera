package com.demo.camera.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraInfo;

import java.util.List;

public interface ICameraInfoService extends IService<CameraInfo> {
    ApiResponse<List<CameraInfo>> queryByCondition(ParameterCondition param);
}
