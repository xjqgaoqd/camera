package com.demo.camera.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraImg;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.mapper.CameraImgMapper;
import com.demo.camera.mapper.CameraInfoMapper;
import com.demo.camera.service.ICameraInfoService;
import com.demo.camera.utils.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraInfoServiceImpl extends ServiceImpl<CameraInfoMapper, CameraInfo> implements ICameraInfoService{
    @Autowired
    private CameraInfoMapper cameraInfoMapper;

    @Autowired
    private CameraImgMapper cameraImgMapper;

    @Value("${upload.path}") // 读取配置中的文件上传路径
    private String uploadPath;

    @Override
    public ApiResponse<List<CameraInfo>> queryByCondition(ParameterCondition param) {
        CameraInfo cameraInfo = JsonUtil.getEntityClazz(param.getFilter(),CameraInfo.class);
        PageHelper.startPage(param.getPageIndex(),param.getPageSize());
        List<CameraInfo> pages = cameraInfoMapper.selectCameraInfoByCondition(cameraInfo);
        for (CameraInfo info : pages){
            CameraImg one = new LambdaQueryChainWrapper<CameraImg>(cameraImgMapper)
                    .eq(CameraImg::getCamId, info.getId())
                    .eq(CameraImg::getUsed, "1")
                    .orderByAsc(CameraImg::getId)
                    .one();
            if (null != one){
                one.setFilePath(uploadPath + one.getFilePath());
                info.setMainImg(one);
            }
        }
//        stdCodeUtils.changeValue(pages);
        PageInfo<CameraInfo> pageInfo = new PageInfo<>(pages);
        return ApiResponse.success(pageInfo.getList(),pageInfo.getTotal());
    }
}
