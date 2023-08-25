package com.demo.camera.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tb_cam_img")
public class CameraImg {
    @TableId
    private int id;
    @TableField("cam_id")
    private int camId;
    @TableField("file_path")
    private String filePath;
    @TableField("used")
    private String used;
}
