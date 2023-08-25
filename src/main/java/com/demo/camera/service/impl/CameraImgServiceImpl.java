package com.demo.camera.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraImg;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.mapper.CameraImgMapper;
import com.demo.camera.service.ICameraImgService;
import com.demo.camera.utils.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraImgServiceImpl extends ServiceImpl<CameraImgMapper, CameraImg> implements ICameraImgService{
    @Autowired
    private CameraImgMapper cameraImgMapper;

    @Override
    public ApiResponse<List<CameraImg>> queryByCondition(ParameterCondition param) {
        CameraImg cameraImg = JsonUtil.getEntityClazz(param.getFilter(),CameraImg.class);
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        List<CameraImg> pages = cameraImgMapper.selectCameraImgByCondition(cameraImg);
//        stdCodeUtils.changeValue(pages);
        PageInfo<CameraImg> pageInfo = new PageInfo<>(pages);
        return ApiResponse.success(pageInfo.getList(),pageInfo.getTotal());
    }
}
