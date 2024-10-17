/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_nc_cloud
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_nc_cloud`;

USE `db_nc_cloud`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `m_id` int(10) NOT NULL auto_increment,
  `m_admin` varchar(50) default NULL,
  `m_pass` varchar(50) default NULL,
  `m_admin_name` varchar(50) default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`m_id`,`m_admin`,`m_pass`,`m_admin_name`) values (1,'admin','admin','DHS');

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_code` int(20) NOT NULL auto_increment,
  `c_url` varchar(50) default NULL,
  `c_uname` varchar(50) default NULL,
  `c_pwd` varchar(50) default NULL,
  `c_flag` varchar(10) default NULL,
  PRIMARY KEY  (`c_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`,`c_flag`) values (1,'ftp.drivehq.com','blrstore4','*blrstore123','active');
insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`,`c_flag`) values (2,'ftp.drivehq.com','blrstore1','*blrstore123','deactive');
insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`,`c_flag`) values (3,'ftp.drivehq.com','blrstore2','*blrstore123','active');
insert into `m_cloud` (`c_code`,`c_url`,`c_uname`,`c_pwd`,`c_flag`) values (4,'ftp.drivehq.com','blrstore3','*blrstore123','active');

/*Table structure for table `m_file` */

DROP TABLE IF EXISTS `m_file`;

CREATE TABLE `m_file` (
  `f_no` int(10) NOT NULL auto_increment,
  `f_name` varchar(20) default NULL,
  `f_date` varchar(10) default NULL,
  `f_time` varchar(20) default NULL,
  `block1_mac` varchar(50) default NULL,
  `block2_mac` varchar(50) default NULL,
  `block3_mac` varchar(50) default NULL,
  `block4_mac` varchar(50) default NULL,
  `block5_mac` varchar(50) default NULL,
  `block6_mac` varchar(50) default NULL,
  `block7_mac` varchar(50) default NULL,
  `block8_mac` varchar(50) default NULL,
  `extra_char` varchar(10) default NULL,
  PRIMARY KEY  (`f_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_file` */

insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (1,'test.txt','31-03-2015','10:50:01','2defc98f83b2304e8665e0c8a79431fb','a56186a4a3dfa252d837732c8b69eda2','c5167e43fd7cdbaecd5699c094ab9538','fac958368d9653ebddea5d638948174','ef310dc92325298ece07bbbaf814beb7','e76f7e0ba15646fab2c3d53ac5daf770','73fb0ee37865746b106c08d804a64640','a56186a4a3dfa252d837732c8b69eda2','0.0 7029');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (2,'out.txt','31-03-2015','11:01:41','38b151b7aab3543d55c68fa5f9e1991','c6982269dbf2af7b6191c3b73db081af','e30d3573dabfb7487c3bab4c82293d05','d7a05c164449a5267786a56159bd5b9','91f4244c29be34494c3904e2ada2609a','749ce06f87d190f04e13a0034611fe5c','e85e958bba1142a65498da8714c398ec','c6982269dbf2af7b6191c3b73db081af','0.0 1754');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (3,'Medical.txt','30-04-2015','13:29:43','502dd64d2b2dc494d98304ac9c42d338','13428b207ddfec83ff67c2e62e2bc42a','3abfda880c3bb75181f2efd5a3e3972e','657e59c3c75918a83e346e5b23d09630','2e93210dfadcbea84fb9eb9b789c2d8e','505134b20570653567166cb1e5c4224c','6c403360c9dddbca539bde167581b714','677a9289edbe205a0a9d53feb347e990','0.0 100');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (4,'amTestFile.txt','18-05-2015','10:00:23','f814893777bcc2295fff05f00e508da6','e168f9b549f5fc3af4d5d6a003630c3e','4669569c9a870431c4896de37675a784','529dc67dde9486a1af8353915ab94870','45493823f788c7cffc9e8a217b2a7ea','5054fe4482522c2b6aae60860d42e310','cb668002f9452dbcb4c524c8e98437e7','e168f9b549f5fc3af4d5d6a003630c3e','0.0 22');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (5,'SAMPLE.txt','18-05-2015','15:55:53','a6077d257c448f5394a027c615fe5e49','d6faf6d913bd324ebb81542d33341d6c','83fb4c3a848bbb6772676c5005bee49','b8c6a751ad80f9cd5a0203966e876210','46c79e37ef3793f9b4a6de0c5d3842e1','1538d539cc9c52a9316513aee1faa71','49514d667c771e84d206cdb7f10ca6e0','95fafab4d44531ed6eb0577c94dafcae','0.0 384');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (6,'SAMPLE.txt','19-05-2015','12:30:58','a6077d257c448f5394a027c615fe5e49','d6faf6d913bd324ebb81542d33341d6c','83fb4c3a848bbb6772676c5005bee49','b8c6a751ad80f9cd5a0203966e876210','46c79e37ef3793f9b4a6de0c5d3842e1','1538d539cc9c52a9316513aee1faa71','49514d667c771e84d206cdb7f10ca6e0','95fafab4d44531ed6eb0577c94dafcae','0.0 384');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (7,'README (1).txt','21-05-2015','13:42:25','6a882a70fa7a5c37402085939daf8b79','7cf3fac3c28ab8b61d4690e07e67a27b','aaddcf68d5e7aa5c8be41b98e3acc676','f6eed06b18b777ccafccec2331ad9d78','53492a81126cb4478adf113a26debd52','24b2f7892bcb54a94458b55ba559affa','44dbd259341dac1a19417592bd8c97ec','7cf3fac3c28ab8b61d4690e07e67a27b','0.0 118');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (8,'Personal.txt','21-05-2015','13:47:55','81088d1a6f1923b430d2d50f99e6748a','3898efd86964e06b0e9c8216384035f9','8589232d6cc480240e387c300710079b','55a339281a5838e76c262e1c500d2af2','3de308e0887c5e485db36bbbd7ba062b','bc1072196337ac0eb6ba3bb82ac7a8bb','9f28a6e6d179f762a7227a7005005ac3','c05a5080067413877da70c7d1a150cb5','0.0 116');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (9,'README (1).txt','25-05-2015','16:08:51','6a882a70fa7a5c37402085939daf8b79','7cf3fac3c28ab8b61d4690e07e67a27b','aaddcf68d5e7aa5c8be41b98e3acc676','f6eed06b18b777ccafccec2331ad9d78','53492a81126cb4478adf113a26debd52','24b2f7892bcb54a94458b55ba559affa','44dbd259341dac1a19417592bd8c97ec','7cf3fac3c28ab8b61d4690e07e67a27b','0.0 118');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (10,'Medical.txt','25-05-2015','18:29:04','6bd768994b167de7042ae201170e6ff1','de4933723c4c1649bf3889006b4f4c9','f3eed083c5e769e4490cabe11c99cbf1','407d311f2b70192ff299ab0a1d7fbb41','3a1bb94da0869bebc93db674c76aa55d','e9e6515bef9b1f085bf56eb6f783d680','444b897057747e04408afe1a0dc870b7','de4933723c4c1649bf3889006b4f4c9','0.0 105');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (11,'SAMPLE.txt','25-05-2015','18:34:23','a6077d257c448f5394a027c615fe5e49','d6faf6d913bd324ebb81542d33341d6c','83fb4c3a848bbb6772676c5005bee49','b8c6a751ad80f9cd5a0203966e876210','46c79e37ef3793f9b4a6de0c5d3842e1','1538d539cc9c52a9316513aee1faa71','49514d667c771e84d206cdb7f10ca6e0','95fafab4d44531ed6eb0577c94dafcae','0.0 384');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (12,'zoo.txt','27-05-2015','11:25:01','a6077d257c448f5394a027c615fe5e49','d6faf6d913bd324ebb81542d33341d6c','83fb4c3a848bbb6772676c5005bee49','b8c6a751ad80f9cd5a0203966e876210','46c79e37ef3793f9b4a6de0c5d3842e1','1538d539cc9c52a9316513aee1faa71','49514d667c771e84d206cdb7f10ca6e0','95fafab4d44531ed6eb0577c94dafcae','0.0 384');
insert into `m_file` (`f_no`,`f_name`,`f_date`,`f_time`,`block1_mac`,`block2_mac`,`block3_mac`,`block4_mac`,`block5_mac`,`block6_mac`,`block7_mac`,`block8_mac`,`extra_char`) values (13,'SecretKey.txt','27-05-2015','17:40:10','d293a119176b7097fc8ebe6d84e2e240','6b6a2a08af8dddb7713c7f6b5fe13a51','97013c990a2d5b94320ae40080825bd5','b5c730528536e8466d944d269802d872','b3ba2bc2a62217174984e7b152fdba35','4ca5c8ae12d49b5ee59ccfcdef0af701','e3e3ed21766773c3d859636356d70293','6b6a2a08af8dddb7713c7f6b5fe13a51','0.0 33');

/*Table structure for table `m_transaction` */

DROP TABLE IF EXISTS `m_transaction`;

CREATE TABLE `m_transaction` (
  `t_no` int(10) NOT NULL auto_increment,
  `t_date` varchar(100) NOT NULL,
  `t_time` varchar(100) NOT NULL,
  `m_loginid` varchar(50) NOT NULL,
  `f_name` varchar(50) default NULL,
  `f_status` varchar(50) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_transaction` */

insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (1,'31-03-2015','10:50:01','user','test.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (2,'31-03-2015','10:50:17','test','test.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (3,'31-03-2015','11:01:41','test','out.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (4,'31-03-2015','11:01:50','user','out.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (5,'01-04-2015','09:51:02','user','out.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (6,'30-04-2015','13:29:43','user','Medical.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (7,'30-04-2015','13:32:56','user','Medical.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (8,'30-04-2015','13:33:57','user','Medical.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (9,'18-05-2015','10:00:23','user','amTestFile.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (10,'18-05-2015','10:01:04','user','amTestFile.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (11,'18-05-2015','15:55:53','user','SAMPLE.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (12,'18-05-2015','15:58:36','test','SAMPLE.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (13,'19-05-2015','12:30:58','user','SAMPLE.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (14,'19-05-2015','12:31:09','test','SAMPLE.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (15,'21-05-2015','13:42:25','user','README (1).txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (16,'21-05-2015','13:42:47','user','README (1).txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (17,'21-05-2015','13:47:55','user','Personal.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (18,'25-05-2015','16:08:51','user','README (1).txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (19,'25-05-2015','18:29:04','user','Medical.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (20,'25-05-2015','18:30:26','user','Medical.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (21,'25-05-2015','18:31:59','user','Medical.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (22,'25-05-2015','18:34:23','test','SAMPLE.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (23,'27-05-2015','11:25:01','test','zoo.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (24,'27-05-2015','11:25:15','test','zoo.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (25,'27-05-2015','17:40:10','user','SecretKey.txt','Uploaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (26,'27-05-2015','17:40:27','user','SecretKey.txt','Downloaded');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`m_loginid`,`f_name`,`f_status`) values (27,'27-05-2015','17:41:17','user','SecretKey.txt','Downloaded');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_no` int(10) NOT NULL auto_increment,
  `u_id` varchar(50) default NULL,
  `u_pass` varchar(20) default NULL,
  `u_name` varchar(50) default NULL,
  `u_email` varchar(30) default NULL,
  `u_phone` varchar(10) default NULL,
  PRIMARY KEY  (`u_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (1,'user','user','User','user@gmail.com','9988776655');
insert into `m_user` (`u_no`,`u_id`,`u_pass`,`u_name`,`u_email`,`u_phone`) values (2,'test','test','test','test@gmail.com','9988776644');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
