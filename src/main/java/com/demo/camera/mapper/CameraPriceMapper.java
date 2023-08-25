package com.demo.camera.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.camera.entity.CameraPrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CameraPriceMapper extends BaseMapper<CameraPrice> {
    List<CameraPrice> selectCameraPriceByCondition(CameraPrice cameraInfo);

}
