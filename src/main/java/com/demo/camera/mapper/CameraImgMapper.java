package com.demo.camera.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.camera.entity.CameraImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CameraImgMapper extends BaseMapper<CameraImg> {
    List<CameraImg> selectCameraImgByCondition(CameraImg cameraImg);
}
