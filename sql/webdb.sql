/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-04-10 14:12:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(32) NOT NULL,
  `AdminPwd` varchar(64) NOT NULL,
  `AdminType` smallint(6) NOT NULL COMMENT '管理员类型',
  `LastLoginTime` varchar(50) DEFAULT '' COMMENT '注册时间',
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'HSP', 'hsp', '1', '2018-10-14');
INSERT INTO `admin` VALUES ('2', 'HWJ', 'hwj', '1', '2018-10-14');
INSERT INTO `admin` VALUES ('3', 'HWY', 'hwy', '1', '2018-10-14');
INSERT INTO `admin` VALUES ('4', 'CJP', 'cjp', '1', '2018-10-14');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `NewsID` int(11) NOT NULL AUTO_INCREMENT,
  `NewsTitle` varchar(60) NOT NULL COMMENT '新闻标题',
  `NewsContent` longtext NOT NULL COMMENT '新闻内容',
  `NewsTime` varchar(50) NOT NULL DEFAULT '' COMMENT '新闻日期',
  `AdminName` varchar(32) NOT NULL COMMENT '编辑人',
  PRIMARY KEY (`NewsID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '两会召开', '测试', 'Mon Mar 18 08:49:31 CST 2019', '贺文杰');
INSERT INTO `news` VALUES ('3', '第三条新闻', '2018年10月14日，盛源水暖工程有限公司开通官方网站。', '2018-10-14 19:19', 'HSP');
INSERT INTO `news` VALUES ('4', '第四条新闻', '华为发布新手机', '2019-2-8', 'HWJ');
INSERT INTO `news` VALUES ('5', '第四条新闻', '华为发布新手机', '2015-6-8', 'zhangsan');
INSERT INTO `news` VALUES ('6', '第六条新闻', '华为发布新手机', '2012-2-8', 'HWJ');
INSERT INTO `news` VALUES ('7', '第七条新闻', '华为发布新手机', '2019-2-8', 'HWJ');
INSERT INTO `news` VALUES ('10', '测试', '测试', '2019-3-18', '贺文杰');
INSERT INTO `news` VALUES ('11', '测试', '123156', '2019-3-18', '贺文杰');
