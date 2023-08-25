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

 Date: 25/08/2023 10:32:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cam_url
-- ----------------------------
DROP TABLE IF EXISTS `tb_cam_url`;
CREATE TABLE `tb_cam_url`  (
  `id` int(11) NOT NULL,
  `cam_id` int(11) NOT NULL,
  `url` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `use_url` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cam_url
-- ----------------------------
INSERT INTO `tb_cam_url` VALUES (1, 1, 'https://detail.zol.com.cn/1411/1410436/price.shtml', '2023-08-24 14:01:59', 'zgc1');
INSERT INTO `tb_cam_url` VALUES (2, 2, 'https://detail.zol.com.cn/digital_camera/index1418977.shtml', '2023-08-24 14:02:45', 'zgc1');
INSERT INTO `tb_cam_url` VALUES (3, 1, 'https://detail.zol.com.cn/series/15/10709652_1.html', NULL, 'zgc2');
INSERT INTO `tb_cam_url` VALUES (4, 2, 'https://detail.zol.com.cn/series/15/10713271_1.html', NULL, 'zgc2');

SET FOREIGN_KEY_CHECKS = 1;
