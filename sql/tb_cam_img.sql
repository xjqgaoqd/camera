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

 Date: 25/08/2023 10:32:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cam_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_cam_img`;
CREATE TABLE `tb_cam_img`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cam_id` int(11) NOT NULL,
  `file_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `used` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cam_img
-- ----------------------------
INSERT INTO `tb_cam_img` VALUES (4, 1, '/97e63a807b090bb2.jpg', '1');

SET FOREIGN_KEY_CHECKS = 1;
