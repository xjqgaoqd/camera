package com.demo.camera.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.camera.entity.CameraPrice;
import com.demo.camera.entity.CameraUrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CameraUrlMapper extends BaseMapper<CameraUrl> {
    List<CameraUrl> selectCameraUrlByCondition(CameraUrl cameraUrl);

}
