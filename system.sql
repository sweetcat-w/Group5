/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : localhost:3306
 Source Schema         : system

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 30/05/2022 22:59:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for g_stock
-- ----------------------------
DROP TABLE IF EXISTS `g_stock`;
CREATE TABLE `g_stock`  (
  `g_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `g_barCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品条形码',
  `g_shelfLife` int(5) NOT NULL COMMENT '保质期',
  `g_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类型',
  `s_num` int(5) NOT NULL COMMENT '库存数量',
  `g_nuit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `g_Isexpired` int(255) NOT NULL COMMENT '是否过期',
  PRIMARY KEY (`g_barCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of g_stock
-- ----------------------------
INSERT INTO `g_stock` VALUES ('怡宝矿泉水', '12111', 5, '饮用水', 20, '箱', 0);
INSERT INTO `g_stock` VALUES ('统一茉莉蜜茶', '1322', 12, '饮料', 112, '箱', 0);
INSERT INTO `g_stock` VALUES ('百事可乐', '21550530', 3, '碳酸饮料', 22, '箱', 0);
INSERT INTO `g_stock` VALUES ('AD钙', '2311', 12, '饮料', 32, '箱', 0);
INSERT INTO `g_stock` VALUES ('统一绿茶', '5689897', 2, '饮用水', 20, '箱', 0);

-- ----------------------------
-- Table structure for p_details
-- ----------------------------
DROP TABLE IF EXISTS `p_details`;
CREATE TABLE `p_details`  (
  `transactionNo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易单号',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供货商',
  `transactionDate` date NOT NULL COMMENT '交易日期',
  `g_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `g_barCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品条形码',
  `g_manufactureDate` date NOT NULL COMMENT '生产日期',
  `g_num` int(5) NOT NULL COMMENT '数量',
  `g_specifications` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格',
  `g_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `g_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类型',
  `g_shelfLife` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保质期',
  PRIMARY KEY (`g_barCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of p_details
-- ----------------------------
INSERT INTO `p_details` VALUES ('2022052901', '娃哈哈有限公司', '2022-05-29', '娃哈哈矿泉水', '052901', '2022-05-14', 1, '12瓶', '箱', '饮用水', '3年');
INSERT INTO `p_details` VALUES ('2022052902', '统一有限公司', '2022-05-30', '老坛酸菜面', '0529222', '2022-05-08', 5, '6桶', '箱', '速食品', '3年');
INSERT INTO `p_details` VALUES ('202205312144', '百事有限公司', '2022-05-30', '百事可乐', '21450530', '2022-01-01', 2, '12瓶', '箱', '碳酸饮料', '2年');
INSERT INTO `p_details` VALUES ('2022052511', '娃哈哈', '2022-04-30', '娃哈哈AD钙', '232123', '2022-05-20', 21, '121', '箱', '饮料', '1年6个月');
INSERT INTO `p_details` VALUES ('2022052901', '统一有限公司', '2022-01-30', '鲜虾鱼板面（桶装）', '4798789', '2022-01-12', 2, '6桶', '箱', '速食品', '1年');
INSERT INTO `p_details` VALUES ('2022', '统一有限公司', '2022-01-19', '老坛酸菜面', '7897998', '2022-01-30', 1, '6桶', '箱', '速食品', '1年');
INSERT INTO `p_details` VALUES ('5989897', '统一有限公司', '2022-01-22', '统一冰红茶', '888999', '2022-01-14', 2, '12瓶', '箱', '饮料', '2年');

-- ----------------------------
-- Table structure for p_registration
-- ----------------------------
DROP TABLE IF EXISTS `p_registration`;
CREATE TABLE `p_registration`  (
  `transactionNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易单号',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名',
  `p_category` int(255) NOT NULL COMMENT '商品种类数目',
  `transactionDate` date NOT NULL COMMENT '交易日期',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`transactionNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of p_registration
-- ----------------------------
INSERT INTO `p_registration` VALUES ('2022052511', '娃哈哈', 2, '2022-01-30', '无');
INSERT INTO `p_registration` VALUES ('2022052901', '娃哈哈有限公司', 5, '2022-05-29', '无');
INSERT INTO `p_registration` VALUES ('2022052902', '统一有限公司', 2, '2022-01-31', '无');
INSERT INTO `p_registration` VALUES ('20220530', '康师傅有限公司', 5, '2022-01-07', '无');
INSERT INTO `p_registration` VALUES ('202245', '康师傅有限公司', 3, '2022-01-18', '无');
INSERT INTO `p_registration` VALUES ('789789456', '康师傅有限公司', 4, '2022-01-07', '无');
INSERT INTO `p_registration` VALUES ('897858', '康师傅有限公司', 5, '2022-01-02', '无');

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`  (
  `g_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `g_barCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品条形码',
  `g_specifications` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格',
  `transactionNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易单号',
  `g_manufactureDate` date NOT NULL COMMENT '生产日期',
  `r_num` int(255) NOT NULL COMMENT '退货数量',
  `g_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `r_date` date NOT NULL COMMENT '退货日期',
  PRIMARY KEY (`g_barCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of refund
-- ----------------------------
INSERT INTO `refund` VALUES ('娃哈哈', '052901', '12瓶', '20220529222', '2022-01-01', 1, '箱', '2022-01-29');
INSERT INTO `refund` VALUES ('统一冰红茶', '05302152', '12瓶', '2598', '2022-01-05', 3, '箱', '2022-01-29');
INSERT INTO `refund` VALUES ('红烧牛肉面', '202205305', '6桶', '22053324', '2022-01-30', 2, '箱', '2022-01-31');
INSERT INTO `refund` VALUES ('娃哈哈AD钙奶', '212022', '23支', '2123193831', '2022-05-21', 22, '箱', '2022-05-29');
INSERT INTO `refund` VALUES ('老坛酸菜面', '789789', '6桶', '789755', '2022-01-30', 2, '箱', '2022-01-21');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `creditCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '统一社会信用代码',
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `s_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商状态',
  `s_liaisoner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `liaisonPhone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`creditCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('2022053078', '可口可乐有限公司', '在营', '小田', '18259892222');
INSERT INTO `supplier` VALUES ('21273212', '娃哈哈集团', '有限公司', '王先生', '15977123200');
INSERT INTO `supplier` VALUES ('350264787', '统一有限公司', '在营', '阿甜', '18259890002');
INSERT INTO `supplier` VALUES ('35052678', '娃哈哈有限公司', '在营', '田老板', '18259890002');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `phoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `isAdmain` int(1) NOT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2121', '田薇', '18259893311', '123456', 0);
INSERT INTO `user` VALUES ('6732', '阿甜', '18259893387', '123456', 0);
INSERT INTO `user` VALUES ('admin', '管理员', '18259890001', '123456', 0);
INSERT INTO `user` VALUES ('dev', '田薇', '18259890012', 'abc789', 0);
INSERT INTO `user` VALUES ('test', '小田', '18259890015', 'ancdefg', 0);

SET FOREIGN_KEY_CHECKS = 1;
