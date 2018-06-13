/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : pw_zyj

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2018-06-13 16:49:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `resource_name` varchar(20) DEFAULT NULL,
  `resource_url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', null, '我是谁', '/whoim');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root', null, null, null, null);
INSERT INTO `user` VALUES ('2', 'sang', 'sang', null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '1', '2');
