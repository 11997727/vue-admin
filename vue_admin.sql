/*
Navicat MySQL Data Transfer

Source Server         : 阿里云docker
Source Server Version : 50729
Source Host           : 123.57.128.164:3307
Source Database       : vue_admin

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-04-01 00:59:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rname` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'SuperAdmin');
INSERT INTO `role` VALUES ('2', 'Admin');

-- ----------------------------
-- Table structure for uar
-- ----------------------------
DROP TABLE IF EXISTS `uar`;
CREATE TABLE `uar` (
  `uar_id` int(11) NOT NULL AUTO_INCREMENT,
  `uar_uid` int(11) NOT NULL,
  `uar_rid` int(11) NOT NULL,
  PRIMARY KEY (`uar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of uar
-- ----------------------------
INSERT INTO `uar` VALUES ('1', '1', '1');
INSERT INTO `uar` VALUES ('2', '1', '2');
INSERT INTO `uar` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `introduction` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '介绍',
  `avatar` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '头像',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'I am a super administrator', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'superadmin', 'wuchengzhuo', '123456');
INSERT INTO `user` VALUES ('2', 'I am an admin', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 'admin', 'cuihao', '123456');
