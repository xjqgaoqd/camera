package com.demo.camera.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName("tb_cam_url")
public class CameraUrl {
    @TableId
    private int id;
    @TableField("cam_id")
    private int camId;
    @TableField("url")
    private String url;
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @TableField("use_url")
    private String useUrl;

    @TableField(exist = false)
    private List<Integer> camIds;
}
