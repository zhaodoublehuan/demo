/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50556
 Source Host           : localhost:3306
 Source Schema         : zhh_demo

 Target Server Type    : MySQL
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 17/06/2018 23:57:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict_data
-- ----------------------------
DROP TABLE IF EXISTS `dict_data`;
CREATE TABLE `dict_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称描述',
  `type_id` int(11) NULL DEFAULT NULL COMMENT 'typeid',
  `seq` int(255) NULL DEFAULT NULL COMMENT '排序',
  `insert_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_data
-- ----------------------------
INSERT INTO `dict_data` VALUES (1, '办公用品', NULL, 1, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (2, '交通用品', NULL, 1, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (3, '吨', NULL, 2, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (4, '件', NULL, 2, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (5, '供货商', NULL, 3, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (6, '出货商', NULL, 3, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (7, '进货', NULL, 4, NULL, NULL, NULL);
INSERT INTO `dict_data` VALUES (8, '出货', NULL, 4, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典分类名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典分类描述',
  `seq` int(99) NULL DEFAULT NULL COMMENT '排序',
  `insert_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (1, '产品分类', '用来对产品进行分类', NULL, NULL, NULL);
INSERT INTO `dict_type` VALUES (2, '产品单位', '不同的产品可能单位不一致', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '产品类型',
  `unit_id` int(11) NULL DEFAULT NULL COMMENT '单位',
  `insert_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '钢筋', '测试钢筋', 12.00, 1, 3, NULL, NULL);
INSERT INTO `product` VALUES (2, '三角铁', '测试三角铁', 11.00, 2, 4, NULL, NULL);

-- ----------------------------
-- Table structure for product_inout_record
-- ----------------------------
DROP TABLE IF EXISTS `product_inout_record`;
CREATE TABLE `product_inout_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `product_count` decimal(10, 0) NULL DEFAULT NULL COMMENT '产品数量',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `product_shop_id` int(11) NULL DEFAULT NULL COMMENT '合作商id',
  `product_inout_type` int(11) NULL DEFAULT NULL COMMENT '进出货标识',
  `inout_date` datetime NULL DEFAULT NULL COMMENT '进出货时间',
  `insert_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_inout_record
-- ----------------------------
INSERT INTO `product_inout_record` VALUES (2, 2, 1, 100.00, 1, 8, '2018-06-11 00:00:00', NULL, NULL);
INSERT INTO `product_inout_record` VALUES (3, 1, 1, 100.00, 1, 7, '2018-06-17 00:00:00', NULL, NULL);
INSERT INTO `product_inout_record` VALUES (4, 1, 5, 1000.00, 1, 7, '2018-06-17 00:00:00', NULL, NULL);
INSERT INTO `product_inout_record` VALUES (5, 1, 2, 500.00, 1, 8, '2018-06-17 00:00:00', NULL, NULL);
INSERT INTO `product_inout_record` VALUES (6, 2, 3, 500.00, 1, 7, '2018-06-06 00:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for product_shop
-- ----------------------------
DROP TABLE IF EXISTS `product_shop`;
CREATE TABLE `product_shop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作商名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作商描述',
  `shop_type` int(11) NULL DEFAULT NULL COMMENT '合作商类型',
  `insert_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_shop
-- ----------------------------
INSERT INTO `product_shop` VALUES (1, '测试供应商', '杀杀杀', 5, NULL, NULL);
INSERT INTO `product_shop` VALUES (2, '测试111', 'aaaa', 6, NULL, NULL);
INSERT INTO `product_shop` VALUES (3, '大连厂', '大连厂的描述', 5, NULL, NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menu_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `menu_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `icon_class` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式',
  `level` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单等级',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '折叠状态',
  `sort` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单排序',
  `active` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单状态',
  `leaf` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否子叶节点',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0eab13f9cecc4ad591ffc9576a0ddc0f', '/chart/index', '首页', 'fa fa-fw fa-home', NULL, NULL, '1', 'Y', NULL, '报表页面', NULL, '2018-06-07 16:12:39', '2018-06-07 16:12:39');
INSERT INTO `sys_menu` VALUES ('468b07312445446f8cf909cc671dcef9', '/pshop/index', '合作商管理', 'fa fa-fw fa-group', NULL, NULL, '4', 'Y', NULL, '添加菜单描述', NULL, '2017-07-18 09:17:15', '2017-07-18 09:17:15');
INSERT INTO `sys_menu` VALUES ('59dfa0efc3b24a6eaa2bcacea123f0a4', '/precord/index', '进出货管理', 'fa fa-fw fa-truck', NULL, NULL, '3', 'Y', NULL, NULL, NULL, '2017-05-09 11:16:46', '2017-05-09 11:16:46');
INSERT INTO `sys_menu` VALUES ('7a5404bfd9cc48328bce04a2971f574f', '', '系统信息维护', 'fa fa-fw fa-cog', NULL, NULL, '5', 'Y', NULL, '添加菜单描述', NULL, '2017-05-08 14:22:21', '2017-05-08 14:22:21');
INSERT INTO `sys_menu` VALUES ('7a5404bfd9cc48328bce04a2971f57qw', '/product/index', '商品管理', 'fa fa-fw fa-cubes', NULL, NULL, '2', 'Y', NULL, NULL, '', '2018-06-10 16:21:51', '2018-06-10 16:21:53');
INSERT INTO `sys_menu` VALUES ('7a54qweree04a2971f574faaaaaaa', '/dictData/index', '类别详情管理', 'fa fa-fw fa-align-justify', NULL, NULL, '2', 'Y', NULL, NULL, '7a5404bfd9cc48328bce04a2971f574f', '2018-06-11 14:01:29', '2018-06-11 14:01:33');
INSERT INTO `sys_menu` VALUES ('7a54qweree04a2971f574faddsddef', '/dictType/index', '类别管理', 'fa fa-fw fa-th-large', NULL, NULL, '1', 'Y', NULL, NULL, '7a5404bfd9cc48328bce04a2971f574f', '2018-06-11 14:00:20', '2018-06-11 14:00:23');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('5142509655d848b3a7ebce7ef6f6f8d1', 'query', '???????????', '2018-06-06 19:45:57', '2018-06-06 19:45:57');
INSERT INTO `sys_permission` VALUES ('538f961ee672407b84189584bee9d758', 'query', '测试权限描述', '2017-04-20 18:05:58', '2017-04-20 18:05:58');
INSERT INTO `sys_permission` VALUES ('5525329b04404f7d9653af3c78ec7596', 'query', '???????????', '2017-04-21 10:18:53', '2017-04-21 10:18:53');
INSERT INTO `sys_permission` VALUES ('5d0f0e84a5514e04ac6789624d4c1da9', 'query', '???????????', '2017-07-18 09:17:15', '2017-07-18 09:17:15');
INSERT INTO `sys_permission` VALUES ('64ffb5fb3e1f40b287dd75fe32d8db3a', 'query', '???????????', '2018-06-07 16:12:39', '2018-06-07 16:12:39');
INSERT INTO `sys_permission` VALUES ('e7de12bddab8402db9c50a4bd37192aa', 'query', '测试权限描述', '2017-04-20 20:03:39', '2017-04-20 20:03:39');
INSERT INTO `sys_permission` VALUES ('ed0ff7b68e8345deacad09aa01db4ddb', 'query', '???????????', '2017-04-21 13:36:51', '2017-04-21 13:36:51');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `active` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色状态',
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('20206c39f81a4f39a3e76270366364dd', '测试角色', '用来测试的角色', 'Y', '2017-07-18 09:17:17', '2017-07-18 09:17:17');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `menu_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `active` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '0eab13f9cecc4ad591ffc9576a0ddc0f', '20206c39f81a4f39a3e76270366364dd', 'Y', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('2', '468b07312445446f8cf909cc671dcef9', '20206c39f81a4f39a3e76270366364dd', 'Y', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('3', '59dfa0efc3b24a6eaa2bcacea123f0a4', '20206c39f81a4f39a3e76270366364dd', 'Y', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('4', '7a5404bfd9cc48328bce04a2971f574f', '20206c39f81a4f39a3e76270366364dd', 'Y', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES ('5', '7a5404bfd9cc48328bce04a2971f57qw', '20206c39f81a4f39a3e76270366364dd', 'Y', '2018-06-10 16:22:22', '2018-06-10 16:22:25');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `permission_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账户',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密用的盐',
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `active` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('45c126f2d11a4761a4eed37a89556235', 'admin', '赵欢欢', '4c3f11476f7b8e2a3c9d75c1d16d8c87', '7d4b03bf48574a1aad4166bb9164d55d', NULL, NULL, 'Y', '2018-06-08 18:24:18', '2018-06-08 18:24:18');
INSERT INTO `sys_user` VALUES ('5dd673bede36467da1e620d499a7d782', '111', '111', '1248c38b0d99e1dc19aa03f6c65df94d', 'e8a0f50e9908490185e69e16af2e13ad', NULL, NULL, 'Y', '2017-05-12 10:55:25', '2017-05-12 10:55:25');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `login_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `insert_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  `active` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('admin', '20206c39f81a4f39a3e76270366364dd', '2018-06-09 14:41:46', '2018-06-09 14:41:49', 'Y');

-- ----------------------------
-- View structure for chart_data
-- ----------------------------
DROP VIEW IF EXISTS `chart_data`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `chart_data` AS select sum(`product_inout_record`.`product_price`) AS `price`,sum(`product_inout_record`.`product_count`) AS `number`,`product_inout_record`.`product_inout_type` AS `product_inout_type`,`product_inout_record`.`product_id` AS `product_id` from `product_inout_record` group by `product_inout_record`.`product_id`,`product_inout_record`.`product_inout_type`;

SET FOREIGN_KEY_CHECKS = 1;
