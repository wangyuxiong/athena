DROP TABLE IF EXISTS `athena_user`;
CREATE TABLE `athena_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `passwd` varchar(100) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;