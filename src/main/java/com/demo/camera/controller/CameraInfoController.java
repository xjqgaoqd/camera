package com.demo.camera.controller;

import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.service.ICameraInfoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
//@Api(tags = "相机信息管理")
@RestController
@RequestMapping("/cameraInfo")
public class CameraInfoController {

    @Autowired
    private ICameraInfoService cameraInfoService;

//    @ApiOperation(value = "查询相机信息接口")
    @PostMapping("/queryCameraInfoByCondition")
    public ApiResponse<List<CameraInfo>> queryEquipDetailByCondition(@RequestBody ParameterCondition<CameraInfo> parameterCondition){
        try {
            return cameraInfoService.queryByCondition(parameterCondition);
        }catch (Exception e){
            log.error("查询设备信息列表异常：",e);
            return ApiResponse.error(500,"错误");
        }
    }

}
