package com.demo.camera.controller;

import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.entity.CameraPrice;
import com.demo.camera.service.ICameraInfoService;
import com.demo.camera.service.ICameraPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
//@Api(tags = "相机信息管理")
@RestController
@RequestMapping("/cameraPrice")
public class CameraPriceController {

    @Autowired
    private ICameraPriceService cameraPriceService;

//    @ApiOperation(value = "查询相机信息接口")
    @PostMapping("/queryCameraPriceByCondition")
    public ApiResponse<List<CameraPrice>> queryCameraPriceByCondition(@RequestBody ParameterCondition<CameraPrice> parameterCondition){
        try {
            return cameraPriceService.queryByCondition(parameterCondition);
        }catch (Exception e){
            log.error("查询列表异常：",e);
            return ApiResponse.error(500,"错误");
        }
    }

    @PostMapping("/queryNewPrice")
    public ApiResponse<String> queryNewPrice(@RequestBody Map<String,Object> param){
        try {
            cameraPriceService.queryNewPrice((List<Integer>) param.get("camIds"));
            return ApiResponse.success("OK",0);
        }catch (Exception e){
            log.error("查询列表异常：",e);
            return ApiResponse.error(500,"错误");
        }
    }

}
