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

 Date: 25/08/2023 10:32:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_cam_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_cam_info`;
CREATE TABLE `tb_cam_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `issue_time` date NULL DEFAULT NULL,
  `issue_price` double(10, 1) NULL DEFAULT NULL,
  `now_price` double(10, 1) NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `edit_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_cam_info
-- ----------------------------
INSERT INTO `tb_cam_info` VALUES (1, 'Canon', 'EOS R10', '2022-07-15', 6469.0, 7088.0, '01', NULL, '2023-08-24 20:00:47', '2023-08-25 09:29:07');
INSERT INTO `tb_cam_info` VALUES (2, 'Nikon', 'Z30', '2020-08-09', 4799.0, 5099.0, '01', NULL, '2023-08-16 14:30:20', '2023-08-25 09:29:08');

-- ----------------------------
-- Triggers structure for table tb_cam_info
-- ----------------------------
DROP TRIGGER IF EXISTS `update_modified_time`;
delimiter ;;
CREATE TRIGGER `update_modified_time` BEFORE UPDATE ON `tb_cam_info` FOR EACH ROW BEGIN
    SET NEW.edit_time = NOW();
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
