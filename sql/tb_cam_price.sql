/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50612
 Source Host           : localhost:3306
 Source Schema         : db_my_note

 Target Server Type    : MySQL
 Target Server Version : 50612
 File Encoding         : 65001

 Date: 25/08/2023 10:32:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cam_price
-- ----------------------------
DROP TABLE IF EXISTS `tb_cam_price`;
CREATE TABLE `tb_cam_price`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cam_id` int(11) NOT NULL,
  `price` double(10, 1) NULL DEFAULT NULL,
  `supplier` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `add_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cam_price
-- ----------------------------
INSERT INTO `tb_cam_price` VALUES (4, 1, 7088.0, '佳能影像专卖店 佳能（Canon）皇泽专卖店 爱摄数码专营店 佳能（Canon）相机旗舰店 a axon_us海外官方旗舰店', '2023-08-25');
INSERT INTO `tb_cam_price` VALUES (5, 2, 5099.0, '', '2023-08-25');

SET FOREIGN_KEY_CHECKS = 1;
