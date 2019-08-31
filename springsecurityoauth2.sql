/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-07-04 08:12:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clientdetails
-- ----------------------------
DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `appId` varchar(255) NOT NULL,
  `resourceIds` varchar(255) DEFAULT NULL,
  `appSecret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `grantTypes` varchar(255) DEFAULT NULL,
  `redirectUrl` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additionalInformation` varchar(4096) DEFAULT NULL,
  `autoApproveScopes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clientdetails
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(255) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` text,
  `autoapprove` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('net5ijy', null, '12345678', 'all,read,write', 'authorization_code,refresh_token,password', null, 'ROLE_TRUSTED_CLIENT', '43200', '43200', null, null);
INSERT INTO `oauth_client_details` VALUES ('tencent', null, '12345678', 'all,read,write', 'authorization_code,password', null, 'ROLE_TRUSTED_CLIENT', '1800', '1800', null, null);

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for springcloud_role
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_role`;
CREATE TABLE `springcloud_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_role
-- ----------------------------
INSERT INTO `springcloud_role` VALUES ('1', 'ADMIN');
INSERT INTO `springcloud_role` VALUES ('2', 'USER');
INSERT INTO `springcloud_role` VALUES ('3', 'DBA');

-- ----------------------------
-- Table structure for springcloud_user
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_user`;
CREATE TABLE `springcloud_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bdjh7hkhwt42imfy9b9vp0odh` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=426 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_user
-- ----------------------------
INSERT INTO `springcloud_user` VALUES ('1', '2019-03-26 08:47:48', '18902120812@189.cn', '$2a$10$808uxYoOsZ/5pI5vme0MKOLkJ/VdGYeXSDHkfBAnR3bbqFvP64nwa', '18902120812', 'admin1');
INSERT INTO `springcloud_user` VALUES ('218', '2019-05-31 10:08:39', '18902120002@189.cn', '$2a$10$DjCIGAvRTt3GTBMypYhFR.bYRXyfZkgcM1tbyJfBiBKY18PKxG3Wm', '18902120002', 'admin002');
INSERT INTO `springcloud_user` VALUES ('317', '2019-06-03 15:22:15', '18902120001@189.cn', '$2a$10$WcV5VFRRFeCCRdtXE3eUI.LKgV02SWkoxin9Jo5KtLo7lHFcx6hbe', '18902120001', 'admin0001');
INSERT INTO `springcloud_user` VALUES ('318', '2019-06-03 15:22:15', '18902120002@189.cn', '$2a$10$4F8B.AL1jHiSlJFKfDSP9.Uw.U/k6C2qZ.WLdmWIFdRxgg0nkO.eO', '18902120002', 'admin0002');
INSERT INTO `springcloud_user` VALUES ('319', '2019-06-03 15:22:15', '18902120003@189.cn', '$2a$10$m5ZpevvrunALuIlDgFO.AOo5m//mArBWRDZiXxr8hQIWu.eKhgWvK', '18902120003', 'admin0003');
INSERT INTO `springcloud_user` VALUES ('320', '2019-06-03 15:22:15', '18902120004@189.cn', '$2a$10$mLcmKlsvalZSLQs.KxLuSOy4kBhAVTjeuqsdoee.o8bWebC72SFCq', '18902120004', 'admin0004');
INSERT INTO `springcloud_user` VALUES ('321', '2019-06-03 15:22:15', '18902120005@189.cn', '$2a$10$.RBfNjZ2fKxqOAwmB.thBeuBHrWCaA.EV.OFp7luai0rOAaR0yaVu', '18902120005', 'admin0005');
INSERT INTO `springcloud_user` VALUES ('322', '2019-06-03 15:22:15', '18902120006@189.cn', '$2a$10$NbqsmZCep7u7BcOYrNxcaelcyJl9Od35mjmCcOQKeb7tInz9G5BSG', '18902120006', 'admin0006');
INSERT INTO `springcloud_user` VALUES ('323', '2019-06-03 15:22:15', '18902120007@189.cn', '$2a$10$Iv9MV1B1dFMTWwFay9uhsuVqrvtkH5MWSdY.dm22CUOZpKCjO9Uqi', '18902120007', 'admin0007');
INSERT INTO `springcloud_user` VALUES ('324', '2019-06-03 15:22:15', '18902120008@189.cn', '$2a$10$wc4SsJpxabcoreinoRHKou2F.LxYwJY9N8uQaGkjo4DWs9GyCP4WO', '18902120008', 'admin0008');
INSERT INTO `springcloud_user` VALUES ('325', '2019-06-03 15:22:16', '18902120009@189.cn', '$2a$10$pIvDaB2D1HbxmHTA9B57W.X4DXZCE9sE5.xStSCnxxPFLlu4vUzk6', '18902120009', 'admin0009');
INSERT INTO `springcloud_user` VALUES ('326', '2019-06-03 15:22:16', '18902120010@189.cn', '$2a$10$9.URFErwQQhj4up2XwD84.m5vsTqcEXrvH8dD/3ZeF.GGq5YxNbsu', '18902120010', 'admin0010');
INSERT INTO `springcloud_user` VALUES ('327', '2019-06-03 15:22:16', '18902120011@189.cn', '$2a$10$bNLbmXHSSUbWPFB3U6a32.HhZOlE2YCAk1L.JwrzcHFjlSFgmD.C6', '18902120011', 'admin0011');
INSERT INTO `springcloud_user` VALUES ('328', '2019-06-03 15:22:16', '18902120012@189.cn', '$2a$10$kXwey5xq/Eg.NzULGCubmeKYbPaNwL1Cut8UxpARP.wsxUX9z6Y6i', '18902120012', 'admin0012');
INSERT INTO `springcloud_user` VALUES ('329', '2019-06-03 15:22:16', '18902120013@189.cn', '$2a$10$OrU2Sp5Icn85W3mRflXI2ufHypmtOvoGTv/UzAaG8OOJOxBQMm9lK', '18902120013', 'admin0013');
INSERT INTO `springcloud_user` VALUES ('330', '2019-06-03 15:22:16', '18902120014@189.cn', '$2a$10$46ee6/blgANpypjtXyOMI.1fWAaL5S9U847mGUotkeEjq82xan29S', '18902120014', 'admin0014');
INSERT INTO `springcloud_user` VALUES ('331', '2019-06-03 15:22:16', '18902120015@189.cn', '$2a$10$HZzmmpFBfIW8YJSWUgOcq.spXH1zIRxDy/E4eAJrcZawoBUnnWdzO', '18902120015', 'admin0015');
INSERT INTO `springcloud_user` VALUES ('332', '2019-06-03 15:22:16', '18902120016@189.cn', '$2a$10$Pdx5kV09q37yGSG7wLrjPOuU7gHGj9spLIhAq3Z6qDw5MNC/jJZXu', '18902120016', 'admin0016');
INSERT INTO `springcloud_user` VALUES ('333', '2019-06-03 15:22:16', '18902120017@189.cn', '$2a$10$gAyqGdht4h1DfVMJDwRTVehf3xE9S9xoDpJsXOL/WNrwnpfjm3X3.', '18902120017', 'admin0017');
INSERT INTO `springcloud_user` VALUES ('334', '2019-06-03 15:22:16', '18902120018@189.cn', '$2a$10$2i7YewO3CF9ySrF66/TIhuc7Zw/WlZ4hRTWGehiAz20kZPFNIdiaW', '18902120018', 'admin0018');
INSERT INTO `springcloud_user` VALUES ('335', '2019-06-03 15:22:16', '18902120019@189.cn', '$2a$10$QyA9P.WPs1mMcA5m5uovOe7ZpU6sfdXX8K60pg45It0YZSwTq9bBS', '18902120019', 'admin0019');
INSERT INTO `springcloud_user` VALUES ('336', '2019-06-03 15:22:16', '18902120020@189.cn', '$2a$10$mqdYjI0SJqfcLalrazunzeuzBVqnbaUNDjB0QYA.MBf1Z8ewZH.ky', '18902120020', 'admin0020');
INSERT INTO `springcloud_user` VALUES ('337', '2019-06-03 15:22:16', '18902120021@189.cn', '$2a$10$McN6GB2jRsEOpDIrh11xPOx55xa2jS6hOtpec/tRsb31sEeciTUpm', '18902120021', 'admin0021');
INSERT INTO `springcloud_user` VALUES ('338', '2019-06-03 15:22:16', '18902120022@189.cn', '$2a$10$unJpjA9ysMZXIxpjGQmmNu9qB5L6X.84euOwfJAMZyaYQyFnWV0p.', '18902120022', 'admin0022');
INSERT INTO `springcloud_user` VALUES ('339', '2019-06-03 15:22:16', '18902120023@189.cn', '$2a$10$d/grGljQ.rnnj52C/BaQ7.K1AnjcCXC1A8JhF7/QNLWHo7vwzVbGO', '18902120023', 'admin0023');
INSERT INTO `springcloud_user` VALUES ('340', '2019-06-03 15:22:16', '18902120024@189.cn', '$2a$10$yc27IyuTAMaoP3CSP2xBLeJ6MV1b15HHfvvud3w1zHV/0RdNY9G2a', '18902120024', 'admin0024');
INSERT INTO `springcloud_user` VALUES ('341', '2019-06-03 15:22:17', '18902120025@189.cn', '$2a$10$r4t4U6e8itQihsuhXGGokOv25SLhCmE4Uc.7zMN2kEhXfWD6l8qhK', '18902120025', 'admin0025');
INSERT INTO `springcloud_user` VALUES ('342', '2019-06-03 15:22:17', '18902120026@189.cn', '$2a$10$AxG8b33f9dbm.9rzrIhh0.GPjRne6Ko.8Ux3ZIfqp3j6XOpLmRxHu', '18902120026', 'admin0026');
INSERT INTO `springcloud_user` VALUES ('343', '2019-06-03 15:22:17', '18902120027@189.cn', '$2a$10$plPRlK7GPexzt9MtPHx12uRNlpgodfcALzEKjWn0ubXzsykjxXACi', '18902120027', 'admin0027');
INSERT INTO `springcloud_user` VALUES ('344', '2019-06-03 15:22:17', '18902120028@189.cn', '$2a$10$v1j1h0ntOwKD1WRWGkPPBOfmyIIZ3YcrgsFuvkJscx0EO0Sp6J6UG', '18902120028', 'admin0028');
INSERT INTO `springcloud_user` VALUES ('345', '2019-06-03 15:22:17', '18902120029@189.cn', '$2a$10$19gLHsPaQUST0v0lM1Dy5.f.ZtNMOVB7tG0mgT.akNjLQW.iLoIAK', '18902120029', 'admin0029');
INSERT INTO `springcloud_user` VALUES ('346', '2019-06-03 15:22:17', '18902120030@189.cn', '$2a$10$47q5dzRnaxQRBE5RHf38yO1cPYGFAVUYvTyQaLT4xug8SUjCkOt3m', '18902120030', 'admin0030');
INSERT INTO `springcloud_user` VALUES ('347', '2019-06-03 15:22:17', '18902120031@189.cn', '$2a$10$Q4gV4oTwg64cMp/vl0gBmuT1hArQJObXKQXOPE6bfGTd6qoZ27I5q', '18902120031', 'admin0031');
INSERT INTO `springcloud_user` VALUES ('348', '2019-06-03 15:22:17', '18902120032@189.cn', '$2a$10$egsoquPq575qvRE527JRSuNXBFFJ6f.pjS9Xl.85o6IBGOpEb.Gcy', '18902120032', 'admin0032');
INSERT INTO `springcloud_user` VALUES ('349', '2019-06-03 15:22:17', '18902120033@189.cn', '$2a$10$urSSvkuLol1PqYW59G5ItOLdfrvAUnwXNDwNTA0MJwUFzGsXNx11m', '18902120033', 'admin0033');
INSERT INTO `springcloud_user` VALUES ('350', '2019-06-03 15:22:17', '18902120034@189.cn', '$2a$10$O0Rqce4LSMQs0bv0fIOZUOipvE0WugRzcKIehA6nWM3W1qOPFc17e', '18902120034', 'admin0034');
INSERT INTO `springcloud_user` VALUES ('351', '2019-06-03 15:22:17', '18902120035@189.cn', '$2a$10$Vb1dEVbe3ZkWtq9A0fpZJOLxuWsVpozDJ65KC.MvgddT3Knyg7Wom', '18902120035', 'admin0035');
INSERT INTO `springcloud_user` VALUES ('352', '2019-06-03 15:22:17', '18902120036@189.cn', '$2a$10$nLUWCo6M24szYHuK0W9LQeFuTtTpmQOHZj76Kcr6HJ80CE4xU9bQi', '18902120036', 'admin0036');
INSERT INTO `springcloud_user` VALUES ('353', '2019-06-03 15:22:17', '18902120037@189.cn', '$2a$10$a6kXa5A/mFJ4VoNL3XMtS.Ue1NaVPVPDKEht9tVHZmKoOm9k/S67q', '18902120037', 'admin0037');
INSERT INTO `springcloud_user` VALUES ('354', '2019-06-03 15:22:17', '18902120038@189.cn', '$2a$10$E0NW4JmwcHOlmhbG6CdF0urk4LRQ2MNgO4E6eqhb4oCPx7vUc0Wyy', '18902120038', 'admin0038');
INSERT INTO `springcloud_user` VALUES ('355', '2019-06-03 15:22:17', '18902120039@189.cn', '$2a$10$1po6kwK9XOIE2LBdrSHf5..vyfyIxXODxaSAKw3dM1Nmw3JHPDZy6', '18902120039', 'admin0039');
INSERT INTO `springcloud_user` VALUES ('356', '2019-06-03 15:22:17', '18902120040@189.cn', '$2a$10$rIX40EUQ8Lm12866DpNLcOrwACNBGSXZaVe3iMdzKZfKzL3mdQCue', '18902120040', 'admin0040');
INSERT INTO `springcloud_user` VALUES ('357', '2019-06-03 15:22:18', '18902120041@189.cn', '$2a$10$r7PB1oVbb2J/qekfGessOeUCcfW.5w61GQmSxA6lPXvTV0KoQueBa', '18902120041', 'admin0041');
INSERT INTO `springcloud_user` VALUES ('358', '2019-06-03 15:22:18', '18902120042@189.cn', '$2a$10$wZ1c/3nQEN7659Z0vzF.YecKbHhakaf1hkUtaXwiuMdv.mqbj7PMa', '18902120042', 'admin0042');
INSERT INTO `springcloud_user` VALUES ('359', '2019-06-03 15:22:18', '18902120043@189.cn', '$2a$10$FY1ov/3yq5C6VTFsPK0Jue4sS2CCIKCQ5yE8YA8XqOyyZFg733N3S', '18902120043', 'admin0043');
INSERT INTO `springcloud_user` VALUES ('360', '2019-06-03 15:22:18', '18902120044@189.cn', '$2a$10$MLnVSpNRyxn6xD73YySrD.0eFVrehQxli/YEvoy0fZeK2O8CVlBvO', '18902120044', 'admin0044');
INSERT INTO `springcloud_user` VALUES ('361', '2019-06-03 15:22:18', '18902120045@189.cn', '$2a$10$a8ThixYjvPHIFDXMOCepH.DATcrHFp3e0R0ShBTkEc9EuuLMuC/NW', '18902120045', 'admin0045');
INSERT INTO `springcloud_user` VALUES ('362', '2019-06-03 15:22:18', '18902120046@189.cn', '$2a$10$OKnpZuZ2li1VCa3YgjQucOABgMS5zcrLlVP.neSmw7KNrpYQlPz5u', '18902120046', 'admin0046');
INSERT INTO `springcloud_user` VALUES ('363', '2019-06-03 15:22:18', '18902120047@189.cn', '$2a$10$OhdLIfIVnQ1fDijou4vm/.qujDUZR6aRIV6o1FwUmG7dA3RM0LJEG', '18902120047', 'admin0047');
INSERT INTO `springcloud_user` VALUES ('364', '2019-06-03 15:22:18', '18902120048@189.cn', '$2a$10$SdIPVQZ8wgiKfOk2MwOCO.w/fHNPrMUkLoN8F67EpS9LRXaiPRW4u', '18902120048', 'admin0048');
INSERT INTO `springcloud_user` VALUES ('365', '2019-06-03 15:22:18', '18902120049@189.cn', '$2a$10$fGqL9ZXppoYSa8h8HPLNnujtJrs.YKDrCJ9rNvoOHYyg3U6.HaFw.', '18902120049', 'admin0049');
INSERT INTO `springcloud_user` VALUES ('366', '2019-06-03 15:22:18', '18902120050@189.cn', '$2a$10$K70SuqzKnFQs3EWIvDrKg.bTf.8o41f7e5oH.q7qy7/XbArsmVRmm', '18902120050', 'admin0050');
INSERT INTO `springcloud_user` VALUES ('367', '2019-06-03 15:22:18', '18902120051@189.cn', '$2a$10$ivjF0NeK3ezKkP3XCXtGIe.tvSUQaMCE9jQ1w5ohcE7fVJ82F2JvS', '18902120051', 'admin0051');
INSERT INTO `springcloud_user` VALUES ('368', '2019-06-03 15:22:18', '18902120052@189.cn', '$2a$10$z8/BWcaLCOoeQaGT6GsjOOSD8l0TZ8o821zTdAK47yxjoXRrhcj1y', '18902120052', 'admin0052');
INSERT INTO `springcloud_user` VALUES ('369', '2019-06-03 15:22:18', '18902120053@189.cn', '$2a$10$CPf/MyCDlyj6JrmglGXOAeBvWq.VoyADWArc8yf8zVI172E8mDgBe', '18902120053', 'admin0053');
INSERT INTO `springcloud_user` VALUES ('370', '2019-06-03 15:22:18', '18902120054@189.cn', '$2a$10$7BVBAl7eGIXjYBJwHCC/2OLHbj2vAuwZ1msbFXaDesXybFOC2FihK', '18902120054', 'admin0054');
INSERT INTO `springcloud_user` VALUES ('371', '2019-06-03 15:22:18', '18902120055@189.cn', '$2a$10$oMcDV36.kC3Gsx07PDH4COvumehRw9Dj5mglWxBNqbq0EoFjvTa2m', '18902120055', 'admin0055');
INSERT INTO `springcloud_user` VALUES ('372', '2019-06-03 15:22:19', '18902120056@189.cn', '$2a$10$7oDE.qC5RTm76YBngTEzXO3ABr/Iwr9td2hLxLDNjT.HJijyGxWsu', '18902120056', 'admin0056');
INSERT INTO `springcloud_user` VALUES ('373', '2019-06-03 15:22:19', '18902120057@189.cn', '$2a$10$/kobMEr4g6ZfN6qzR7531eDPr96xZN2rwCEHsOysPrv9XpgAo2pli', '18902120057', 'admin0057');
INSERT INTO `springcloud_user` VALUES ('374', '2019-06-03 15:22:19', '18902120058@189.cn', '$2a$10$DyIUEBuyEHPiLYNTikZNsu7Ztk4qVhvAjqXnwa9wq26xYmUC.dd5W', '18902120058', 'admin0058');
INSERT INTO `springcloud_user` VALUES ('375', '2019-06-03 15:22:19', '18902120059@189.cn', '$2a$10$j9IStt5Uqg0Jgiwjb/gA5O6sFNCabBfpKcWOSLg7v8q14nnUMy/2y', '18902120059', 'admin0059');
INSERT INTO `springcloud_user` VALUES ('376', '2019-06-03 15:22:19', '18902120060@189.cn', '$2a$10$1rS8lS7R8Igk/ILj2Wl3vO/G9Nh2LbyAFoC.5gtxEkmR7rpKzXDY.', '18902120060', 'admin0060');
INSERT INTO `springcloud_user` VALUES ('377', '2019-06-03 15:22:19', '18902120061@189.cn', '$2a$10$sSlkE2mcmL66aUYEJXAC1O/pQLvM19wJAiSlW7PDceQL1bg7Fwzgi', '18902120061', 'admin0061');
INSERT INTO `springcloud_user` VALUES ('378', '2019-06-03 15:22:19', '18902120062@189.cn', '$2a$10$2ajejvwsDAShQGqoULWA7eIQKIf3jrkMyai8153r1F/Uncx8b3qKC', '18902120062', 'admin0062');
INSERT INTO `springcloud_user` VALUES ('379', '2019-06-03 15:22:19', '18902120063@189.cn', '$2a$10$WQamM.sppSc9AeSqF3Gum.ceEGw2.n4/FoYQMW4buy/k8FSZjyVN.', '18902120063', 'admin0063');
INSERT INTO `springcloud_user` VALUES ('380', '2019-06-03 15:22:19', '18902120064@189.cn', '$2a$10$r2ZxalwxKQpgXSTqUz5Lwemlx2OAnpMffEUte0cYISN6Sbctwdvx.', '18902120064', 'admin0064');
INSERT INTO `springcloud_user` VALUES ('381', '2019-06-03 15:22:19', '18902120065@189.cn', '$2a$10$rMZ2EhledLYTQM8BuFlHveTbgxFSe26wljdtX3zJcB7eHDSyFjZPO', '18902120065', 'admin0065');
INSERT INTO `springcloud_user` VALUES ('382', '2019-06-03 15:22:19', '18902120066@189.cn', '$2a$10$bQw7C4ab6VONmc58r1Bq3eQnTwgL.1eNfeuQoUJvzPJ6gsiL5XSzG', '18902120066', 'admin0066');
INSERT INTO `springcloud_user` VALUES ('383', '2019-06-03 15:22:19', '18902120067@189.cn', '$2a$10$WOmXhXBzW8PpxCdkcHOJ9e3qQupvpvUiEB65NoV7OkfH14YSoZ47K', '18902120067', 'admin0067');
INSERT INTO `springcloud_user` VALUES ('384', '2019-06-03 15:22:19', '18902120068@189.cn', '$2a$10$AdEfUqNwNTVv0FkHgu72KOzgeZh7g1BC8LcqD6IKTGCaFQAqgrJtO', '18902120068', 'admin0068');
INSERT INTO `springcloud_user` VALUES ('385', '2019-06-03 15:22:19', '18902120069@189.cn', '$2a$10$2MElRWr9Fjfcu2ntmL7q0ej.wGXtJ0A3VPsXwUgAVssICv8ZITinG', '18902120069', 'admin0069');
INSERT INTO `springcloud_user` VALUES ('386', '2019-06-03 15:22:19', '18902120070@189.cn', '$2a$10$E.iaISxar0hd/W4qHL3AiuMdeWCQgIxoRjZPrMttstRD/sIdtQBxK', '18902120070', 'admin0070');
INSERT INTO `springcloud_user` VALUES ('387', '2019-06-03 15:22:19', '18902120071@189.cn', '$2a$10$x/G8sG2Sx8/r9RQqQiATTOyk9MWi/l922Jq0kQbjBKRbxNzs1dq.C', '18902120071', 'admin0071');
INSERT INTO `springcloud_user` VALUES ('388', '2019-06-03 15:22:20', '18902120072@189.cn', '$2a$10$NRyI11bdrXBSIY6tzlL01ugEeYcaDiRXTVgCfThk7LsQYCtl6zxFO', '18902120072', 'admin0072');
INSERT INTO `springcloud_user` VALUES ('389', '2019-06-03 15:22:20', '18902120073@189.cn', '$2a$10$g8ecsTe6z7BBDa1a.a4U5u9CzM0vkLRyjmsSPGVkhhDNSf7N/rqCu', '18902120073', 'admin0073');
INSERT INTO `springcloud_user` VALUES ('390', '2019-06-03 15:22:20', '18902120074@189.cn', '$2a$10$/x.OAD985U3qE2Bbg3I8dOynrBnRV.TUTgBewEPvc1Lq1sY0VQcG2', '18902120074', 'admin0074');
INSERT INTO `springcloud_user` VALUES ('391', '2019-06-03 15:22:20', '18902120075@189.cn', '$2a$10$zQwR49liGvW76ZVjeUy59.3RpSKPkbcIhCR.eMF6p4YxmDvKpxPly', '18902120075', 'admin0075');
INSERT INTO `springcloud_user` VALUES ('392', '2019-06-03 15:22:20', '18902120076@189.cn', '$2a$10$.Y1SEWfLjWFN2MXCmLS6eOXUee/aAj/h1ZV.F5O8We0HhxbpIQrt.', '18902120076', 'admin0076');
INSERT INTO `springcloud_user` VALUES ('393', '2019-06-03 15:22:20', '18902120077@189.cn', '$2a$10$HHs69TEWtycbCRV1SBPece082rXe4s77g4zEGYrKuxVZBoU23WOrW', '18902120077', 'admin0077');
INSERT INTO `springcloud_user` VALUES ('394', '2019-06-03 15:22:20', '18902120078@189.cn', '$2a$10$/PIi.ru5V00uuWblhdJgzeSqotqCJMvCErM3Y7ec3QBSY.szo90VC', '18902120078', 'admin0078');
INSERT INTO `springcloud_user` VALUES ('395', '2019-06-03 15:22:20', '18902120079@189.cn', '$2a$10$prqy5Dp.KHsczmpO8DlmsuTWxFSahB.rLzixBXIP0rXLoiCxV3MEu', '18902120079', 'admin0079');
INSERT INTO `springcloud_user` VALUES ('396', '2019-06-03 15:22:20', '18902120080@189.cn', '$2a$10$bRQPfNmn8758wjSgcEHONu5x9kSTXJ3x3SORANrnmavg95UGHLOXG', '18902120080', 'admin0080');
INSERT INTO `springcloud_user` VALUES ('397', '2019-06-03 15:22:20', '18902120081@189.cn', '$2a$10$AioV5R19tKixr98f7cOjBOlNg.l121YiLh1auQEFy6fLQkzJf3EYS', '18902120081', 'admin0081');
INSERT INTO `springcloud_user` VALUES ('398', '2019-06-03 15:22:20', '18902120082@189.cn', '$2a$10$3ig1kA6OxY6m0OBNJw8iReyMpfFae/nBVPdYMe0OPYBaCW4o0mhjG', '18902120082', 'admin0082');
INSERT INTO `springcloud_user` VALUES ('399', '2019-06-03 15:22:20', '18902120083@189.cn', '$2a$10$4raJuQOk1rwCXWDRSEBP4.6SejSzCVuu01vCJE4WjWdlct/cml1ta', '18902120083', 'admin0083');
INSERT INTO `springcloud_user` VALUES ('400', '2019-06-03 15:22:20', '18902120084@189.cn', '$2a$10$737NJ4nC/SwtO9wyMNL8YOwtykIbi9U0DneMobfWxcFLOSTlPwksW', '18902120084', 'admin0084');
INSERT INTO `springcloud_user` VALUES ('401', '2019-06-03 15:22:20', '18902120085@189.cn', '$2a$10$WOuUCrHK6uie.ryOEboTIeqKHh8T91dPRTaKDvRrEs.yxEYPEXNn6', '18902120085', 'admin0085');
INSERT INTO `springcloud_user` VALUES ('402', '2019-06-03 15:22:20', '18902120086@189.cn', '$2a$10$I5qFUN/HccPqPc7i1l4Tn.4TbYfclG8bKOV3evZg.adKzV7w.K7cq', '18902120086', 'admin0086');
INSERT INTO `springcloud_user` VALUES ('403', '2019-06-03 15:22:20', '18902120087@189.cn', '$2a$10$0yhM0HQZ4pd9DPj7EH3/.O.WUEaTyZS6snTX9xvntcML7E57jgE9.', '18902120087', 'admin0087');
INSERT INTO `springcloud_user` VALUES ('404', '2019-06-03 15:22:20', '18902120088@189.cn', '$2a$10$XKmsOs2favwswQoLfEPBr.gj.UvmdZ2TBhWBtdoBSfXnhzNm9JrGu', '18902120088', 'admin0088');
INSERT INTO `springcloud_user` VALUES ('405', '2019-06-03 15:22:21', '18902120089@189.cn', '$2a$10$luQMMsRAuBgubuAZRqCCuOMd4C1zSLsjgWSGv2kt/5c5yPiCwunUq', '18902120089', 'admin0089');
INSERT INTO `springcloud_user` VALUES ('406', '2019-06-03 15:22:21', '18902120090@189.cn', '$2a$10$ju5RLtUykY5en4DI80aEAuW5LjhH40v19HnAIwxL1DZGyvilGpZnG', '18902120090', 'admin0090');
INSERT INTO `springcloud_user` VALUES ('407', '2019-06-03 15:22:21', '18902120091@189.cn', '$2a$10$4D6Rf5lTUplqdN24telLTeaiwyewqHQ61VIUE1Jhh2u89VtukZDEC', '18902120091', 'admin0091');
INSERT INTO `springcloud_user` VALUES ('408', '2019-06-03 15:22:21', '18902120092@189.cn', '$2a$10$JGKKQUlXwqyWD9exO9r43OO2g/eyGEEqA7ye.2h5h9vP2zmpIbhwy', '18902120092', 'admin0092');
INSERT INTO `springcloud_user` VALUES ('409', '2019-06-03 15:22:21', '18902120093@189.cn', '$2a$10$GRk.1XssBFTwd//dY5amzurQ/eqvQrc6VJuA00F.jlhHOYNsgrUBa', '18902120093', 'admin0093');
INSERT INTO `springcloud_user` VALUES ('410', '2019-06-03 15:22:21', '18902120094@189.cn', '$2a$10$juQGT5s1MJ8IU66fGesTXOx4G.LtIdtfR67vrx7Nj8QYcgNPg0TW2', '18902120094', 'admin0094');
INSERT INTO `springcloud_user` VALUES ('411', '2019-06-03 15:22:21', '18902120095@189.cn', '$2a$10$lmk/Hj5wnGfP4cgZ0W5PnerWORUK8T0rUSSgS.TKI4/8ZMBiFAemi', '18902120095', 'admin0095');
INSERT INTO `springcloud_user` VALUES ('412', '2019-06-03 15:22:21', '18902120096@189.cn', '$2a$10$j/nUa9HVqTOJzw3nRiNW.elvYsDhZgh5YuFinq27ngOjZ4vop61wa', '18902120096', 'admin0096');
INSERT INTO `springcloud_user` VALUES ('413', '2019-06-03 15:22:21', '18902120097@189.cn', '$2a$10$EuvtDb01c59ZEiy/b6z5ReCoEJFiKh3eL3ZFkI2G0pqL/JSNAHlNS', '18902120097', 'admin0097');
INSERT INTO `springcloud_user` VALUES ('414', '2019-06-03 15:22:21', '18902120098@189.cn', '$2a$10$eQKNsoSudF45dB1h3Lx8ZOAvpDHkjoLqr/vwh0/EEVKrocX6k37eG', '18902120098', 'admin0098');
INSERT INTO `springcloud_user` VALUES ('415', '2019-06-03 15:22:21', '18902120099@189.cn', '$2a$10$o7o/JEQimso.PzW6p0wh3O83BM80r9LoIXqWBtRoLEhxO9B4oPi7K', '18902120099', 'admin0099');
INSERT INTO `springcloud_user` VALUES ('416', '2019-06-03 15:22:21', '18902120100@189.cn', '$2a$10$6oz/tX2Ob0iX9rxtTRV1OetcQtHcGsRDHPxKrRNE3TrClik3oLbYq', '18902120100', 'admin0100');
INSERT INTO `springcloud_user` VALUES ('424', '2019-06-03 16:26:32', '18902120812@189.cn', '$2a$10$JWaVlU83Di5x5wHMXP1ycOf1VWieadrTiqHmcDMTHkWSDPiA8roPe', '18902120812', 'admin001x');
INSERT INTO `springcloud_user` VALUES ('425', '2019-06-03 16:27:32', '18902120812@189.cn', '$2a$10$GZMPgPYGIERJJyJmR3CS2uHn5vXDdMMJrddJLvCR8zKk5x8vekn/K', '18902120812', 'admin002x');

-- ----------------------------
-- Table structure for springcloud_user_role
-- ----------------------------
DROP TABLE IF EXISTS `springcloud_user_role`;
CREATE TABLE `springcloud_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `user_role_role_id` (`role_id`),
  KEY `user_role_user_id` (`user_id`),
  CONSTRAINT `user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `springcloud_role` (`id`),
  CONSTRAINT `user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `springcloud_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of springcloud_user_role
-- ----------------------------
INSERT INTO `springcloud_user_role` VALUES ('1', '1');
INSERT INTO `springcloud_user_role` VALUES ('1', '218');