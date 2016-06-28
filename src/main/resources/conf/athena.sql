DROP TABLE IF EXISTS `athena_user`;
CREATE TABLE `athena_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` int(11) NOT NULL,
  `isSuperUser` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_unique` (`userName`),
  UNIQUE KEY `email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `athena_product`;
CREATE TABLE `athena_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) NOT NULL,
  `productDesc` varchar(1024),
  `productType` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `athena_product_role`;
CREATE TABLE `athena_product_role` (
  `productId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `role` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `athena_project`;
CREATE TABLE `athena_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(100) NOT NULL,
  `projectDesc` varchar(1024),
  `projectType` int(11) NOT NULL,
  `projectStage` int(11) NOT NULL,
  `productId` bigint(20) NOT NULL,
  `projectStartDate` datetime DEFAULT NULL,
  `projectEndDate` datetime DEFAULT NULL,
  `projectActualEndDate` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `athena_project_role`;
CREATE TABLE `athena_project_role` (
  `projectId` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `role` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;