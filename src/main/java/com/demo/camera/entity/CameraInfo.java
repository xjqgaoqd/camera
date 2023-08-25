package com.demo.camera.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName("tb_cam_info")
public class CameraInfo {
    @TableId
    private int id;
    @TableField("brand")
    private String brand;
    @TableField("model")
    private String model;
    @TableField("issue_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issueTime;
    @TableField("issue_price")
    private double issuePrice;
    @TableField("now_price")
    private double nowPrice;
    @TableField("content")
    private String content;
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @TableField("edit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime editTime;
    @TableField("type")
    private String type;

    @TableField(exist = false)
    private String issueStartTime;
    @TableField(exist = false)
    private String issueEndTime;
    @TableField(exist = false)
    private double issueMinPrice;
    @TableField(exist = false)
    private double issueMaxPrice;
    @TableField(exist = false)
    private CameraImg mainImg;

}
