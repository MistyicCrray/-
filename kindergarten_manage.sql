/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50545
 Source Host           : localhost:3306
 Source Schema         : kindergarten_manage

 Target Server Type    : MySQL
 Target Server Version : 50545
 File Encoding         : 65001

 Date: 08/12/2019 19:13:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `detail` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('6P9jI4l6kvl2eb5H', '123', '123');

-- ----------------------------
-- Table structure for t_activity_student
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_student`;
CREATE TABLE `t_activity_student`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动id',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卫生管理员id',
  `student_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生id',
  `ac_date` datetime NULL DEFAULT NULL COMMENT '活动时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_activity_student
-- ----------------------------
INSERT INTO `t_activity_student` VALUES ('P1SxmN01310VkVbS', '6P9jI4l6kvl2eb5H', 'dtafP5pUCMvWtj4r', '1', NULL);

-- ----------------------------
-- Table structure for t_cleaning
-- ----------------------------
DROP TABLE IF EXISTS `t_cleaning`;
CREATE TABLE `t_cleaning`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `site` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫地点（包括教师、寝室、厨房）',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫内容',
  `period` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫周期',
  `standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫标准',
  `time` date NULL DEFAULT NULL COMMENT '清扫时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_cleaning
-- ----------------------------
INSERT INTO `t_cleaning` VALUES ('BsV46e1O3uq9aj85', '1', '123', '123123123', '123123', '2019-10-08');

-- ----------------------------
-- Table structure for t_cleaning_info
-- ----------------------------
DROP TABLE IF EXISTS `t_cleaning_info`;
CREATE TABLE `t_cleaning_info`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cleaning_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫表的ID',
  `clean_start_time` datetime NULL DEFAULT NULL COMMENT '清扫开始时间',
  `clean_end_time` datetime NULL DEFAULT NULL COMMENT '清扫结束时间',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清扫人',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_cleaning_info
-- ----------------------------
INSERT INTO `t_cleaning_info` VALUES ('2J9gf26IiFPMxn96', 'BsV46e1O3uq9aj85', '2019-10-03 00:00:00', '2019-10-03 00:00:00', '1111', 'Dk1aqN6gZ75iw06K.png');
INSERT INTO `t_cleaning_info` VALUES ('IYg4597vkMO393jc', 'BsV46e1O3uq9aj85', '2019-10-30 00:00:00', '2019-10-31 00:00:00', '1', '3nWTn41bM2t3AT84.jpg');
INSERT INTO `t_cleaning_info` VALUES ('iziWy7vmVp9Hm2Me', 'BsV46e1O3uq9aj85', '2019-10-17 00:00:00', '2019-10-11 00:00:00', '123123', '4VK16vLhPAyV4FC2.png');
INSERT INTO `t_cleaning_info` VALUES ('sR4f3X1AmxvAD9Es', 'BsV46e1O3uq9aj85', '2019-10-03 00:00:00', '2019-10-03 01:10:47', NULL, '565r82uHA1Maiqri.png');
INSERT INTO `t_cleaning_info` VALUES ('T9s37jj6c694g33x', 'BsV46e1O3uq9aj85', '2019-10-11 00:00:00', '2019-10-11 00:00:00', '123123123123123', 'ruIQ2Ykl013lkCFY.png');

-- ----------------------------
-- Table structure for t_communication
-- ----------------------------
DROP TABLE IF EXISTS `t_communication`;
CREATE TABLE `t_communication`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(6000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户发送id',
  `to_user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户接收id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_communication
-- ----------------------------
INSERT INTO `t_communication` VALUES ('0931UL0R3iIg71s9', '123123123', '<p>\n	123123123qwerqweqweq\n</p>\n<p>\n	weqweqwekjhqd<img src=\"http://localhost/kindeditor/plugins/emoticons/images/22.gif\" border=\"0\" alt=\"\" />\n</p>\n<p>\n	<u>qwdqkjhfqreqerqwrwq</u>\n</p>\n<p>\n	<u>qwqwqwwq</u><span style=\"line-height:2.5;\"><u></u><u></u></span>\n</p>', '2019-10-05 11:45:54', 'r4BeynHP2sr3N4sS', 'r4BeynHP2sr3N4sS');
INSERT INTO `t_communication` VALUES ('7pP106aBnP02gxsP', '121', '23123123', '2019-10-05 11:28:05', '61rwXY4KqpXQSy06', 'r4BeynHP2sr3N4sS');
INSERT INTO `t_communication` VALUES ('kmgIM37JfpruxB66', '1', '111', '2019-12-07 20:22:23', 'mEnapjLvK6fEUu03', 'saUd2l3xK1X62K72');

-- ----------------------------
-- Table structure for t_dishes
-- ----------------------------
DROP TABLE IF EXISTS `t_dishes`;
CREATE TABLE `t_dishes`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜品名称',
  `ingredients` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食材',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_dishes
-- ----------------------------
INSERT INTO `t_dishes` VALUES ('0e2KHWYB3T7sNmHC', '小炒肉', '主料：五花肉。\r\n辅料：青红椒、葱、姜、蒜。\r\n调料：盐、白糖、醋、生抽、高汤精、花椒、麻椒、干辣椒。');
INSERT INTO `t_dishes` VALUES ('8QDvuR44SIahbK00', '宫保鸡丁', '主料：鸡\r\n制作材料\r\n制作材料(14张)\r\n 脯肉（225克）、花生米（50克）。\r\n辅料：葱（45克）、姜（10克）。\r\n调料：干辣椒（8克）、花椒（1.5克）、色拉油（60克）、食盐（2克）、料酒（2克）、味精（1克）、酱油（6.5克）、白糖（10克）、醋（7克）、水淀粉（22克）');

-- ----------------------------
-- Table structure for t_dishes_daily
-- ----------------------------
DROP TABLE IF EXISTS `t_dishes_daily`;
CREATE TABLE `t_dishes_daily`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `breakfast_food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐菜式(可有多种，逗号隔开)由dishes提供',
  `breakfast_money` int(10) NULL DEFAULT 0 COMMENT '早餐价格（单位/分）',
  `lunch_food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐菜式(可有多种，逗号隔开)由dishes提供',
  `lunch_money` int(10) NULL DEFAULT NULL COMMENT '午餐价格（单位/分）',
  `dinner_food` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐菜式(可有多种，逗号隔开)由dishes提供',
  `dinner_money` int(10) NULL DEFAULT 0 COMMENT '晚餐价格（单位/分）',
  `dishes_date` date NULL DEFAULT NULL COMMENT '菜单日期',
  `create_date` date NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `breakfast_food_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '早餐菜式id',
  `lunch_food_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '午餐菜式id',
  `dinner_food_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '晚餐菜式id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_dishes_daily
-- ----------------------------
INSERT INTO `t_dishes_daily` VALUES ('095a708n617LeAgj', '小炒肉,宫保鸡丁', 123123, '小炒肉,宫保鸡丁', 123123, '小炒肉', 123123, '2019-10-16', '2019-10-12', NULL, '8QDvuR44SIahbK00', '8QDvuR44SIahbK00', '8QDvuR44SIahbK00');
INSERT INTO `t_dishes_daily` VALUES ('B5uGsi5P9Y96MA81', '小炒肉', 1111, '小炒肉', 1111, '小炒肉', 1111, '2019-10-17', '2019-10-11', NULL, '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00');
INSERT INTO `t_dishes_daily` VALUES ('jENoKSzN7TNCYywB', '宫保鸡丁', 2, '宫保鸡丁', 100, '宫保鸡丁', 100, '2019-10-17', '2019-10-12', NULL, '8QDvuR44SIahbK00', '8QDvuR44SIahbK00', '8QDvuR44SIahbK00');
INSERT INTO `t_dishes_daily` VALUES ('jq0IiIx8ePkO83oA', '123123,宫保鸡丁', 12, '123123,宫保鸡丁', 1255, '123123,宫保鸡丁', 1299, '2019-10-31', '2019-10-06', NULL, '0e2KHWYB3T7sNmHC', '8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00');
INSERT INTO `t_dishes_daily` VALUES ('Lz1BLySyTpgk3j3d', '123123', 1, '123123', 1, '123123', 1, '2019-10-06', '2019-10-06', NULL, '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '8QDvuR44SIahbK00');
INSERT INTO `t_dishes_daily` VALUES ('Yh4f75MF7hrm1CjC', '小炒肉,宫保鸡丁', 1200, '小炒肉,宫保鸡丁', 11100, '小炒肉,宫保鸡丁', 1200, '2019-10-16', '2019-10-25', NULL, '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00', '0e2KHWYB3T7sNmHC,8QDvuR44SIahbK00');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int(1) NULL DEFAULT 0 COMMENT '缴费支付状态(0未支付  1已支付)',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费家长id',
  `create_date` datetime NULL DEFAULT NULL COMMENT '缴费时间',
  `pay_money` int(10) NULL DEFAULT 0 COMMENT '缴费总金额（单位/分）',
  `pay_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式（现在主要为支付宝）',
  `pay_standard_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缴费标准id',
  `student_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('12312312312', 1, '1', '2019-10-02 12:30:02', 4, 'aplipay', 'y6I2D6QUCoNP5Eg0', '8UsT7sl3W56fn3PQ');
INSERT INTO `t_order` VALUES ('5quRrrF8D5mu3F0q', 0, '1', '2019-10-11 22:34:05', 400000, 'aplipay', '29Njy4W8NqgM4N00', '6Z9D06l7TjX35e0L');
INSERT INTO `t_order` VALUES ('5xDEbn0BwR0VQR9P', 0, '1', '2019-10-02 12:35:49', 4, 'aplipay', 'y6I2D6QUCoNP5Eg0', '6Z9D06l7TjX35e0L');
INSERT INTO `t_order` VALUES ('bq3MLsEb3p3oWKd0', 0, '1', '2019-10-11 22:31:56', 400000, 'aplipay', '29Njy4W8NqgM4N00', '6Z9D06l7TjX35e0L');
INSERT INTO `t_order` VALUES ('dfsgert', 0, '1', '2019-10-01 23:59:55', 0, 'aplipay', 'y6I2D6QUCoNP5Eg0', '1');
INSERT INTO `t_order` VALUES ('EEDXMwPOS8k23bSr', 0, '1', '2019-10-11 22:35:54', 400000, 'aplipay', '29Njy4W8NqgM4N00', '6Z9D06l7TjX35e0L');
INSERT INTO `t_order` VALUES ('G0mf68ghMenMlB8s', 0, '1', '2019-10-07 22:10:50', 2578800, 'aplipay', '4g00kOMZ64nssNVr', '1');
INSERT INTO `t_order` VALUES ('O5g8kwBTtH30OXk0', 0, '1', '2019-10-07 22:11:03', 2578800, 'aplipay', '4g00kOMZ64nssNVr', '6Z9D06l7TjX35e0L');
INSERT INTO `t_order` VALUES ('pd5drd41B6M2C17b', 1, '1', '2019-10-07 21:44:10', 2578800, 'aplipay', '4g00kOMZ64nssNVr', '1');
INSERT INTO `t_order` VALUES ('TGiLJE85d9RHD68S', 0, '1', '2019-10-07 21:45:34', 2578800, 'aplipay', '4g00kOMZ64nssNVr', '1');
INSERT INTO `t_order` VALUES ('wWTopf48K66xYQU1', 0, '1', '2019-10-07 22:11:39', 2578800, 'aplipay', '4g00kOMZ64nssNVr', '8UsT7sl3W56fn3PQ');

-- ----------------------------
-- Table structure for t_parents
-- ----------------------------
DROP TABLE IF EXISTS `t_parents`;
CREATE TABLE `t_parents`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家长姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_parents
-- ----------------------------
INSERT INTO `t_parents` VALUES ('1', '黎明');
INSERT INTO `t_parents` VALUES ('62tHqe1YoPJ56WV2', '23423423');
INSERT INTO `t_parents` VALUES ('6Mv3KW2cD5x7KKWN', '1233');
INSERT INTO `t_parents` VALUES ('e4tlIrVcz5mg03s4', '12312');
INSERT INTO `t_parents` VALUES ('EPUx3885xV90tyHU', '小红');
INSERT INTO `t_parents` VALUES ('KlCUm689k6PzitcY', '2234');
INSERT INTO `t_parents` VALUES ('M442RH5R5zY596zj', '空空');
INSERT INTO `t_parents` VALUES ('Sg6UgMIKWiHe1pHw', '小明');
INSERT INTO `t_parents` VALUES ('SGH6B5v8Ojfb4TM8', '黄小雨');

-- ----------------------------
-- Table structure for t_pay_standard
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_standard`;
CREATE TABLE `t_pay_standard`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `schooling` int(10) NULL DEFAULT 0 COMMENT '学费（单位/分）',
  `book_money` int(11) NULL DEFAULT 0 COMMENT '书费（单位/分）',
  `board_ages` int(10) NULL DEFAULT 0 COMMENT '伙食费（单位/分）',
  `quarterage` int(10) NULL DEFAULT 0 COMMENT '住宿费（单位/分）',
  `payment_deadline` date NULL DEFAULT NULL COMMENT '缴费期限',
  `year` date NULL DEFAULT NULL COMMENT '学年',
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pay_standard
-- ----------------------------
INSERT INTO `t_pay_standard` VALUES ('29Njy4W8NqgM4N00', 100000, 100000, 100000, 100000, '2019-10-12', '2019-10-11', '5BKr50wzLCam6WSD.docx');
INSERT INTO `t_pay_standard` VALUES ('4g00kOMZ64nssNVr', 1110000, 222330000, 33330000, 1110000, '2019-10-11', '2019-10-07', 'jkqbGB8vx8v86Y2r.docx');
INSERT INTO `t_pay_standard` VALUES ('sW66G9lnuohzL36i', 1200, 1200, 1200, 1200, '2019-10-10', '2019-10-10', 'ypC93WalN901M2Q1.docx');
INSERT INTO `t_pay_standard` VALUES ('y6I2D6QUCoNP5Eg0', 100, 100, 100, 100, '2019-10-01', '2019-10-04', NULL);

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project
-- ----------------------------
INSERT INTO `t_project` VALUES ('uY7xwbxeyM91ocVG', '书法班');

-- ----------------------------
-- Table structure for t_project_student
-- ----------------------------
DROP TABLE IF EXISTS `t_project_student`;
CREATE TABLE `t_project_student`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `project_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程ID',
  `student_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生id',
  `teacher_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_student
-- ----------------------------
INSERT INTO `t_project_student` VALUES ('GIrloj6H55ox3p37', 'uY7xwbxeyM91ocVG', '8UsT7sl3W56fn3PQ', 'L2DJz7xeVHvB7a9Z');
INSERT INTO `t_project_student` VALUES ('LRrzz3FVy6M1T96P', 'uY7xwbxeyM91ocVG', '1', 'jgASLH594843asbd');

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `communication_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交流表id',
  `to_user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收者id',
  `send_user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者id',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `content` varchar(6000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_reply
-- ----------------------------
INSERT INTO `t_reply` VALUES ('00pL8837K6Yg08A6', 'kmgIM37JfpruxB66', NULL, 'mEnapjLvK6fEUu03', '2019-12-07 20:28:56', '554545');
INSERT INTO `t_reply` VALUES ('5PJG6RatCT7PH8B5', '7pP106aBnP02gxsP', NULL, '61rwXY4KqpXQSy06', '2019-10-05 12:43:18', '234234234');
INSERT INTO `t_reply` VALUES ('6288S2y1kGN32tsN', '7pP106aBnP02gxsP', NULL, '61rwXY4KqpXQSy06', '2019-10-07 18:58:36', '哈哈哈哈哈哈哈哈哈<img src=\"http://localhost/kindeditor/plugins/emoticons/images/0.gif\" border=\"0\" alt=\"\" />');
INSERT INTO `t_reply` VALUES ('8gmidJLlGmU3lXpk', 'kmgIM37JfpruxB66', NULL, 'mEnapjLvK6fEUu03', '2019-12-07 20:28:46', '5545');
INSERT INTO `t_reply` VALUES ('93ru0d88q2W48Jar', '0931UL0R3iIg71s9', NULL, 'r4BeynHP2sr3N4sS', '2019-10-05 12:24:27', '<p>\n	123123qweqwe\n</p>\n<p>\n	qwe\n</p>\n<p>\n	qw\n</p>\n<p>\n	qwe\n</p>\n<p>\n	qwe\n</p>');
INSERT INTO `t_reply` VALUES ('GzVsB8sAf2jr8v4T', 'kmgIM37JfpruxB66', NULL, 'mEnapjLvK6fEUu03', '2019-12-07 20:28:54', '554545');
INSERT INTO `t_reply` VALUES ('k9TGMSiTtuiw3txw', 'kmgIM37JfpruxB66', NULL, 'mEnapjLvK6fEUu03', '2019-12-07 20:28:55', '554545');
INSERT INTO `t_reply` VALUES ('MK42stkd5u7jEjx6', '7pP106aBnP02gxsP', NULL, '61rwXY4KqpXQSy06', '2019-10-05 12:38:36', '<p>\n	qwe1231\n</p>\n<p>\n	<br />\n</p>\n<p>\n	3245251235\n</p>');
INSERT INTO `t_reply` VALUES ('Mm9sq45d8w0M7P78', 'kmgIM37JfpruxB66', NULL, 'mEnapjLvK6fEUu03', '2019-12-07 20:28:53', '554545');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `work_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `id_card` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('dtafP5pUCMvWtj4r', '123125', NULL);
INSERT INTO `t_staff` VALUES ('j2EhuKZF6uFfhieM', '1eqwe', NULL);
INSERT INTO `t_staff` VALUES ('jgASLH594843asbd', '201910756', NULL);
INSERT INTO `t_staff` VALUES ('L2DJz7xeVHvB7a9Z', '201910987', NULL);
INSERT INTO `t_staff` VALUES ('pcdlkI4Pa7euioi3', '201910079', NULL);
INSERT INTO `t_staff` VALUES ('UHeG30jU2bB9Kx1b', '201910571', NULL);
INSERT INTO `t_staff` VALUES ('Uq4jYV89M412c9ti', '201910881', NULL);
INSERT INTO `t_staff` VALUES ('V7l6xNV3M8y08JkC', '201910845', NULL);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `contract` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `in_date` date NULL DEFAULT NULL COMMENT '入园时间',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家长id（可以有多个，逗号隔开）',
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `father_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲电话',
  `mather_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲电话',
  `father_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲姓名',
  `mather_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲姓名',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `gender` int(10) NULL DEFAULT 0 COMMENT '性别0男  1女',
  `class_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '112331', '123433', '1234234', '2019-09-07', '1', '1', '1234234234', '1', '1', '1', '2019-09-26', 0, NULL);
INSERT INTO `t_student` VALUES ('43lIs87563fr7B83', '明明', '198723132', '无', '2019-10-17', 'EPUx3885xV90tyHU', '1197', '18899665432', '18899665432', '小红', '小明', '2019-10-17', 0, '三年二班');
INSERT INTO `t_student` VALUES ('6Z9D06l7TjX35e0L', '李晓明', '1', '1', '2019-09-29', '1', NULL, '1', '1', '1', '1', '2019-09-29', 0, '一年一班');
INSERT INTO `t_student` VALUES ('8c7FG314d099t73y', '小小', '12311223', '哈哈哈', '2019-09-12', 'M442RH5R5zY596zj', NULL, '12221112', '12221112', '空空', '空空', '2019-09-01', 1, '小班');
INSERT INTO `t_student` VALUES ('8UsT7sl3W56fn3PQ', 'xiaoxiaop', '123876123', 'sdfsdfwe', '2019-09-26', '1', NULL, '123qwe', '123q123', '12312', '123123', '2019-09-28', 0, '大班');
INSERT INTO `t_student` VALUES ('DCh7J4gb4N40UbPC', '笑笑', '2', '1211', '2019-09-06', 'Sg6UgMIKWiHe1pHw', NULL, '1231211', '1231211', '111', '111', '2016-05-18', NULL, NULL);
INSERT INTO `t_student` VALUES ('F69DqQj7iAaw6043', '1', '1', '1', '2019-09-19', NULL, NULL, '1', '1', '1', '1', '2019-09-21', NULL, NULL);
INSERT INTO `t_student` VALUES ('i081p4amIJs9L7XV', 'Hisss', '1009987871', '1112212', '2019-10-16', 'KlCUm689k6PzitcY', '20198', '1111212312', '123123', '123123', '123123', '2019-10-17', 0, '二年一班');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户表id',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的姓名',
  `login_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `contract` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式（qq，微信，手机号等）',
  `birthday` date NULL DEFAULT '0000-00-00' COMMENT '生日',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `gender` int(1) NULL DEFAULT 0 COMMENT '0男  1女',
  `user_type` int(1) NULL DEFAULT 0 COMMENT '0管理员  1家长 2幼儿园教师  3园长  4厨师  5卫生管理员',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `state` int(1) NULL DEFAULT 0 COMMENT '用户状态 0正常  1冻结',
  `admin_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'admin表id（如果用户类型是管理员才不为空）',
  `staff_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'staff表id（如果用户类型是教职工才不为空）',
  `parents_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'parents表id（如果用户类型是家长才不为空）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0PL4UbHub2odxuaQ', '23423423', '234234', '187672161', NULL, '北京天安门', 'ca0ac53949a35994a756c957db0f713eca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, '62tHqe1YoPJ56WV2');
INSERT INTO `t_user` VALUES ('141h67C49JJJ8979', '小红', '12341233', '123412444', NULL, '1231', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 'EPUx3885xV90tyHU');
INSERT INTO `t_user` VALUES ('5uMGN610S3AEdY2X', '空空', '12221112', '12221112', NULL, '哈哈哈', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 'M442RH5R5zY596zj');
INSERT INTO `t_user` VALUES ('61rwXY4KqpXQSy06', '123123', '222', '18767216751', NULL, '北京天安门', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, '2019-09-28 15:02:39', 0, NULL, NULL, '1');
INSERT INTO `t_user` VALUES ('83OOZsXvcI933A32', '2234', '223442', '2234421111', NULL, '2234', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 'KlCUm689k6PzitcY');
INSERT INTO `t_user` VALUES ('8R9m043V8eIr4svL', '12312', '1212', '121211', NULL, '1212', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 'e4tlIrVcz5mg03s4');
INSERT INTO `t_user` VALUES ('be5Z9TUbWHExX66o', '李娜', '无', '无', NULL, '无', 'ca0ac53949a35994a756c957db0f713e', NULL, 1, 3, NULL, NULL, 0, NULL, '3451V9W3wnVqsLVy', NULL);
INSERT INTO `t_user` VALUES ('CQT2BmAe79d8fcZj', '1222', '驱蚊器无23', '驱蚊器无23', NULL, '千万1 1212', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 4, NULL, NULL, 0, NULL, 'FyCXNx7m5B85zD27', NULL);
INSERT INTO `t_user` VALUES ('ewl4i1eENPE1fsLH', '12121212', '121212', '121212', NULL, '1212', 'ca0ac53949a35994a756c957db0f713e', NULL, 1, 3, NULL, NULL, 0, NULL, 'UHeG30jU2bB9Kx1b', NULL);
INSERT INTO `t_user` VALUES ('f8S9AA0T8zAR3FBf', '123123123122', '1231', '1231', NULL, '1221', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 3, NULL, NULL, 0, NULL, 'D9CQ6ci6t4rb1wFy', NULL);
INSERT INTO `t_user` VALUES ('GqM8Y5QR8KubamLv', '1233', '223', '223', NULL, '23234', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, '6Mv3KW2cD5x7KKWN');
INSERT INTO `t_user` VALUES ('icEKMP34110aieHU', '无名', '123331222', '123331222', NULL, '13123123', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 2, NULL, NULL, 0, NULL, 'jgASLH594843asbd', NULL);
INSERT INTO `t_user` VALUES ('iZ0BG23kW4l3KXv5', NULL, '12', '12', NULL, NULL, 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 0, NULL, '2019-09-28 09:50:20', 1, NULL, '', NULL);
INSERT INTO `t_user` VALUES ('j2EhuKZF6uFfhieM', 'qwe', 'qinjie', '123456', NULL, NULL, 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 5, NULL, '2019-10-11 20:25:34', 0, NULL, 'j2EhuKZF6uFfhieM', NULL);
INSERT INTO `t_user` VALUES ('mEnapjLvK6fEUu03', '1231', '312', '312', NULL, '12312', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 2, NULL, NULL, 0, NULL, '0W97261D20i6dSpd', NULL);
INSERT INTO `t_user` VALUES ('MIGwY83vlMj731gu', '12', '123', '123', NULL, '12', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 4, NULL, NULL, 0, NULL, 'Uq4jYV89M412c9ti', NULL);
INSERT INTO `t_user` VALUES ('ofqKpv1g4BrQA758', '小明', '111222', '111222', NULL, '111', 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 1, NULL, NULL, 0, NULL, NULL, 'Sg6UgMIKWiHe1pHw');
INSERT INTO `t_user` VALUES ('PclL2G8pqCx5xz4Z', NULL, '111', '22', NULL, NULL, 'ca0ac53949a35994a756c957db0f713e', NULL, NULL, 0, NULL, '2019-09-28 09:43:13', 0, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES ('r4BeynHP2sr3N4sS', '李青', '14231234', '14231234', NULL, '战争学院', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 2, NULL, NULL, 0, NULL, 'pcdlkI4Pa7euioi3', NULL);
INSERT INTO `t_user` VALUES ('saUd2l3xK1X62K72', '李白', '112341', '112341', NULL, '1', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 2, NULL, NULL, 0, NULL, 'L2DJz7xeVHvB7a9Z', NULL);
INSERT INTO `t_user` VALUES ('V7l6xNV3M8y08JkC', '回来', '189898', '189898', NULL, '22', 'ca0ac53949a35994a756c957db0f713e', NULL, 0, 5, NULL, NULL, 0, NULL, 'dtafP5pUCMvWtj4r', NULL);
INSERT INTO `t_user` VALUES ('v9gLN8vqjQJJm45F', 'admin', 'admin', '188774859651', '1998-06-08', '地址', '21232f297a578e9043724a0e4a691fac', NULL, 1, 0, NULL, '2019-09-26 21:04:23', 0, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
