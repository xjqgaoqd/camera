package com.demo.camera.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.camera.entity.CameraInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CameraInfoMapper extends BaseMapper<CameraInfo> {
    List<CameraInfo> selectCameraInfoByCondition(CameraInfo cameraInfo);
}
