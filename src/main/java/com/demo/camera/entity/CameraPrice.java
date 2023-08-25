package com.demo.camera.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("tb_cam_price")
public class CameraPrice {
    @TableId
    private int id;
    @TableField("cam_id")
    private int camId;
    @TableField("add_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date addTime;
    @TableField("price")
    private Double price;
    @TableField("supplier")
    private String supplier;
}
