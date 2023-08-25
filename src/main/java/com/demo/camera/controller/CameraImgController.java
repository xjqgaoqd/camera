package com.demo.camera.controller;

import com.demo.camera.common.ApiResponse;
import com.demo.camera.common.ParameterCondition;
import com.demo.camera.entity.CameraImg;
import com.demo.camera.entity.CameraInfo;
import com.demo.camera.service.ICameraImgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

import java.util.List;

@Slf4j
//@Api(tags = "相机信息管理")
@RestController
@RequestMapping("/cameraImg")
public class CameraImgController {

    @Value("${upload.path}") // 读取配置中的文件上传路径
    private String uploadPath;
    @Autowired
    private ICameraImgService cameraImgService;

    @PostMapping("/queryCameraInfoByCondition")
    public ApiResponse<List<CameraImg>> queryEquipDetailByCondition(@RequestBody ParameterCondition<CameraImg> parameterCondition){
        try {
            return cameraImgService.queryByCondition(parameterCondition);
        }catch (Exception e){
            log.error("查询设备信息列表异常：",e);
            return ApiResponse.error(500,"错误");
        }
    }


    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam(value = "id") int id) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            String filename = file.getOriginalFilename();
            String path = "/" + filename;
            File dest = new File(uploadPath + path);
            file.transferTo(dest);
            CameraImg cameraImg = new CameraImg();
            cameraImg.setCamId(id);
            cameraImg.setUsed("1");
            cameraImg.setFilePath(path);
            cameraImgService.save(cameraImg);
            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed";
        }
    }
}
