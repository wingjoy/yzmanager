/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.5.32 : Database - yzmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yzmanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yzmanager`;

/*Table structure for table `archives` */

DROP TABLE IF EXISTS `archives`;

CREATE TABLE `archives` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `arDate` datetime DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `fileNumber` varchar(255) DEFAULT NULL,
  `filePages` varchar(255) DEFAULT NULL,
  `giveArName` varchar(255) DEFAULT NULL,
  `saveArDepartment` varchar(255) DEFAULT NULL,
  `saveArName` varchar(255) DEFAULT NULL,
  `saveArDate` datetime DEFAULT NULL,
  `fileCoverNumber` varchar(255) DEFAULT NULL,
  `saveYears` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `saveArRemarks` varchar(255) DEFAULT NULL,
  `averify` int(11) DEFAULT NULL,
  `fileFileName` varchar(255) DEFAULT NULL,
  `fileDir` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `archives` */

/*Table structure for table `custom` */

DROP TABLE IF EXISTS `custom`;

CREATE TABLE `custom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `areaName` varchar(255) DEFAULT NULL,
  `customType` varchar(255) DEFAULT NULL,
  `customState` int(11) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `workPhone` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `rectify` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `custom` */

/*Table structure for table `customarea` */

DROP TABLE IF EXISTS `customarea`;

CREATE TABLE `customarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `areaName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customarea` */

/*Table structure for table `customstate` */

DROP TABLE IF EXISTS `customstate`;

CREATE TABLE `customstate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stateName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customstate` */

/*Table structure for table `customtype` */

DROP TABLE IF EXISTS `customtype`;

CREATE TABLE `customtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customtype` */

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `haveHouse` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`department`,`haveHouse`) values (1,'航空服务部',1),(2,'办公室',1),(3,'新一代产品部',0),(7,'机场服务部',0);

/*Table structure for table `expense` */

DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `supplierAddress` varchar(255) DEFAULT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `contactPhone` varchar(255) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `TotalPrice` double DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `payMode` varchar(255) DEFAULT NULL,
  `everify` int(11) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `everifyName` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `expense` */

/*Table structure for table `firstclass` */

DROP TABLE IF EXISTS `firstclass`;

CREATE TABLE `firstclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `systemName` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `houseId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

/*Data for the table `firstclass` */

insert  into `firstclass`(`id`,`department`,`systemName`,`firstCName`,`houseId`) values (190,'2','0','签字笔','2'),(191,'2','0','胶水','2'),(192,'2','0','笔记本','2'),(193,'2','0','文件夹','2'),(194,'2','0','档案盒','2'),(195,'2','0','剪刀','2'),(196,'2','0','直尺','2'),(197,'2','0','其他','2'),(198,'2','0','订书机','2'),(199,'2','0','计算器','2'),(200,'2','0','回形针及燕尾夹','2'),(201,'2','0','电池','2'),(202,'2','0','纸杯','2'),(203,'2','0','','2');

/*Table structure for table `gcompany` */

DROP TABLE IF EXISTS `gcompany`;

CREATE TABLE `gcompany` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gcompany` */

/*Table structure for table `housemanager` */

DROP TABLE IF EXISTS `housemanager`;

CREATE TABLE `housemanager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `houseId` varchar(255) DEFAULT NULL,
  `managerName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `housemanager` */

insert  into `housemanager`(`id`,`houseId`,`managerName`,`department`) values (2,'2','wjtao','2'),(4,'1','guanliyuan','1');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `systemManager` bit(1) DEFAULT NULL,
  `departmentManager` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `outstorehouse` */

DROP TABLE IF EXISTS `outstorehouse`;

CREATE TABLE `outstorehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `houseId` varchar(255) DEFAULT NULL,
  `outDate` datetime DEFAULT NULL,
  `applyDate` datetime DEFAULT NULL,
  `applyDepartment` varchar(255) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `houseVerifyName` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `outRemarks` varchar(255) DEFAULT NULL,
  `outVerify` int(11) DEFAULT NULL,
  `inVerifyName` varchar(255) DEFAULT NULL,
  `houseManager` varchar(255) DEFAULT NULL,
  `applyCount` int(11) DEFAULT NULL,
  `inVerifyRemarks` varchar(255) DEFAULT NULL,
  `houseVerifyRemarks` varchar(255) DEFAULT NULL,
  `houseManagerRemarks` varchar(255) DEFAULT NULL,
  `nextVerifyName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `outstorehouse` */

insert  into `outstorehouse`(`id`,`version`,`userName`,`department`,`firstCName`,`secondCName`,`houseId`,`outDate`,`applyDate`,`applyDepartment`,`purpose`,`houseVerifyName`,`unit`,`outRemarks`,`outVerify`,`inVerifyName`,`houseManager`,`applyCount`,`inVerifyRemarks`,`houseVerifyRemarks`,`houseManagerRemarks`,`nextVerifyName`) values (25,0,'a','2','197','546','2','2013-11-07 08:21:58','2013-11-07 07:52:31','1','1111','zhuren','对','2222 ',4,'guanliyuan','wjtao',4,'vvvvv','sadasd','','wjtao');

/*Table structure for table `paymode` */

DROP TABLE IF EXISTS `paymode`;

CREATE TABLE `paymode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `paymode` */

/*Table structure for table `personal` */

DROP TABLE IF EXISTS `personal`;

CREATE TABLE `personal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `registerDate` datetime DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `contactName` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `workPhone` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `personal` */

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `systemManager` tinyint(1) DEFAULT NULL,
  `departmentManager` tinyint(1) DEFAULT NULL,
  `ams` tinyint(1) DEFAULT NULL,
  `amsselect` tinyint(1) DEFAULT NULL,
  `amsadd` tinyint(1) DEFAULT NULL,
  `amsmodify` tinyint(1) DEFAULT NULL,
  `amsdelete` tinyint(1) DEFAULT NULL,
  `amsSelectOther` tinyint(1) DEFAULT NULL,
  `averify` tinyint(1) DEFAULT NULL,
  `pms` tinyint(1) DEFAULT NULL,
  `pmsselect` tinyint(1) DEFAULT NULL,
  `pmsadd` tinyint(1) DEFAULT NULL,
  `pmsmodify` tinyint(1) DEFAULT NULL,
  `pmsdelete` tinyint(1) DEFAULT NULL,
  `pmsSelectOther` tinyint(1) DEFAULT NULL,
  `ems` tinyint(1) DEFAULT NULL,
  `emsselect` tinyint(1) DEFAULT NULL,
  `emsadd` tinyint(1) DEFAULT NULL,
  `emsmodify` tinyint(1) DEFAULT NULL,
  `emsdelete` tinyint(1) DEFAULT NULL,
  `emsSelectOther` tinyint(1) DEFAULT NULL,
  `everify` tinyint(1) DEFAULT NULL,
  `emsMonth` tinyint(1) DEFAULT NULL,
  `emsClass` tinyint(1) DEFAULT NULL,
  `ims` tinyint(1) DEFAULT NULL,
  `imsInRegister` tinyint(1) DEFAULT NULL,
  `imsOutRegister` tinyint(1) DEFAULT NULL,
  `iverify` tinyint(1) DEFAULT NULL,
  `cms` tinyint(1) DEFAULT NULL,
  `cmsselect` tinyint(1) DEFAULT NULL,
  `cmsadd` tinyint(1) DEFAULT NULL,
  `cmsmodify` tinyint(1) DEFAULT NULL,
  `cmsdelete` tinyint(1) DEFAULT NULL,
  `cmsSelectOther` tinyint(1) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `FK65E8905AF260D17` (`user_id`),
  CONSTRAINT `FK65E8905AF260D17` FOREIGN KEY (`user_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `power` */

insert  into `power`(`id`,`userName`,`name`,`department`,`systemManager`,`departmentManager`,`ams`,`amsselect`,`amsadd`,`amsmodify`,`amsdelete`,`amsSelectOther`,`averify`,`pms`,`pmsselect`,`pmsadd`,`pmsmodify`,`pmsdelete`,`pmsSelectOther`,`ems`,`emsselect`,`emsadd`,`emsmodify`,`emsdelete`,`emsSelectOther`,`everify`,`emsMonth`,`emsClass`,`ims`,`imsInRegister`,`imsOutRegister`,`iverify`,`cms`,`cmsselect`,`cmsadd`,`cmsmodify`,`cmsdelete`,`cmsSelectOther`,`user_id`) values (3,'a','sa','1',1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2),(4,'wjtao','陶维佳','2',0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,3),(6,'bli','李冰','2',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,5),(7,'zhangsan','张三','2',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,6),(8,'wangwu','王五','2',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,7),(9,'部门管理员','部门管理员','2',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8),(10,'综合办主任','综合办主任','1',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9),(11,'guanliyuan','部门管理员','1',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,10),(12,'zhuren','主任','1',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,11),(13,'jingli','经理','1',0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,12);

/*Table structure for table `secondclass` */

DROP TABLE IF EXISTS `secondclass`;

CREATE TABLE `secondclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `systemName` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `inCount` int(11) DEFAULT NULL,
  `outCount` int(11) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `currentCount` int(11) DEFAULT NULL,
  `houseId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=620 DEFAULT CHARSET=utf8;

/*Data for the table `secondclass` */

insert  into `secondclass`(`id`,`department`,`systemName`,`firstCName`,`secondCName`,`inCount`,`outCount`,`unitPrice`,`unit`,`currentCount`,`houseId`) values (466,'2','0','190','真彩中性笔量贩（黑）',0,0,0.78,'支',0,'2'),(467,'2','0','190','真彩中性笔量贩（红）',33,0,2.2,'支',33,'2'),(468,'2','0','190','真彩中性笔量贩（蓝）',13,0,1.6,'支',13,'2'),(469,'2','0','190','真彩替芯量贩（黑）',320,0,0.47,'支',320,'2'),(470,'2','0','190','真彩替芯量贩（红）',100,6,0.67,'支',94,'2'),(471,'2','0','190','真彩替芯量贩（蓝）',8,0,0.67,'支',8,'2'),(472,'2','0','190','水笔芯-派克',3,0,5,'支',3,'2'),(473,'2','0','190','固定笔（黑）',6,0,2.5,'支',6,'2'),(474,'2','0','190','白板笔（黑）',24,0,6.4,'支',24,'2'),(475,'2','0','190','白板笔（红）',41,0,6.4,'支',41,'2'),(476,'2','0','190','白板笔（蓝）',53,0,6.4,'支',53,'2'),(477,'2','0','190','荧光笔',5,0,1.5,'支',5,'2'),(478,'2','0','190','记号笔-黑',13,0,1.4,'支',13,'2'),(479,'2','0','190','记号笔-红',13,0,1.4,'支',13,'2'),(480,'2','0','190','记号笔-蓝',7,0,1.4,'支',7,'2'),(481,'2','0','190','记号笔-细黑',0,0,1,'支',0,'2'),(482,'2','0','190','记号笔-细红',10,0,1,'支',10,'2'),(483,'2','0','190','记号笔-细蓝',2,0,1,'支',2,'2'),(484,'2','0','190','记号笔-细黄',30,0,1,'支',30,'2'),(485,'2','0','190','圆珠笔(蓝色)',0,0,0.8,'支',0,'2'),(486,'2','0','190','圆珠笔（黑色）',1,0,1.9,'支',1,'2'),(487,'2','0','190','圆珠笔芯（蓝色）',1298,0,0.67,'支',1298,'2'),(488,'2','0','190','铅笔（2B）',0,0,0.68,'支',0,'2'),(489,'2','0','190','铅笔（HB）',50,0,0.5,'支',50,'2'),(490,'2','0','190','铅笔（红蓝）',6,0,0.6,'支',6,'2'),(491,'2','0','190','橡皮',24,0,0.45,'块',24,'2'),(492,'2','0','190','修正液',15,0,2.2,'瓶',15,'2'),(493,'2','0','190','修正带',0,0,4.5,'个',0,'2'),(494,'2','0','191','固体胶',0,0,1.1,'个',0,'2'),(495,'2','0','191','液体胶',32,0,1.4,'个',32,'2'),(496,'2','0','190','黑墨水-派克',8,0,12,'瓶',8,'2'),(497,'2','0','190','黑墨水-英雄',0,0,5,'瓶',0,'2'),(498,'2','0','190','蓝黑墨水-奥林丹',1,0,3.1,'瓶',1,'2'),(499,'2','0','190','蓝黑墨水-英雄',0,0,5,'瓶',0,'2'),(500,'2','0','190','蓝黑墨水-博士',4,0,5,'瓶',4,'2'),(501,'2','0','190','蓝墨水',0,0,5,'瓶',0,'2'),(502,'2','0','192','A4笔记本',17,0,11.3,'本',17,'2'),(503,'2','0','192','彩面抄',13,0,6.2,'本',13,'2'),(504,'2','0','192','黑面抄',126,0,5,'本',126,'2'),(505,'2','0','192','软面抄',23,0,5,'本',23,'2'),(506,'2','0','192','工作手册',7,0,2,'本',7,'2'),(507,'2','0','192','会议记录本',3,0,13.8,'本',3,'2'),(508,'2','0','193','文件夹',19,0,5.6,'个',19,'2'),(509,'2','0','193','文件夹-2孔D型夹',36,0,8,'个',36,'2'),(510,'2','0','193','名片册-300页',5,0,15,'本',5,'2'),(511,'2','0','193','拉杆夹',40,0,1.62,'个',40,'2'),(512,'2','0','193','书写板夹',9,0,6,'个',9,'2'),(513,'2','0','193','文件盒',13,0,12.2,'个',13,'2'),(514,'2','0','193','牛皮档案袋',50,0,0.4,'个',50,'2'),(515,'2','0','193','透明档案袋',21,0,1.9,'个',21,'2'),(516,'2','0','193','拉边袋-网格A5',1,0,3,'个',1,'2'),(517,'2','0','193','拉边袋-网格B5',12,0,3,'个',12,'2'),(518,'2','0','193','拉边袋-网格A4',0,0,4,'个',0,'2'),(519,'2','0','193','拉边袋-塑料A4',0,0,1.7,'个',0,'2'),(520,'2','0','193','拉边袋-塑料A5',20,0,1.7,'个',20,'2'),(521,'2','0','193','纽扣袋',4,0,1.9,'个',4,'2'),(522,'2','0','194','资料册-20页',7,0,9.2,'本',7,'2'),(523,'2','0','194','资料册-40页',21,0,14.5,'本',21,'2'),(524,'2','0','194','资料册-60页',72,0,16.5,'本',72,'2'),(525,'2','0','194','资料册-80页',9,0,18.5,'本',9,'2'),(526,'2','0','194','资料册-100页',15,0,20.5,'本',15,'2'),(527,'2','0','194','杂志架（3档）',0,0,36.1,'组',0,'2'),(528,'2','0','194','杂志架（4档）',8,0,20.8,'组',8,'2'),(529,'2','0','192','100页银行日记账',2,0,6,'本',2,'2'),(530,'2','0','192','200页银行日记账',8,0,10.8,'本',8,'2'),(531,'2','0','192','领物单',22,13,2,'本',9,'2'),(532,'2','0','192','收款收据',16,0,2.3,'本',16,'2'),(533,'2','0','192','收文簿',15,0,1.5,'本',15,'2'),(534,'2','0','192','发文簿',13,0,1.5,'本',13,'2'),(535,'2','0','192','复写纸',4,0,3.5,'盒',4,'2'),(536,'2','0','192','A4复写纸',0,0,7.4,'盒',0,'2'),(537,'2','0','195','剪刀',17,0,2.8,'把',17,'2'),(538,'2','0','195','起订器',18,0,2.1,'个',18,'2'),(539,'2','0','195','美工刀',12,20,2.5,'把',-8,'2'),(540,'2','0','196','直尺',7,0,1.5,'把',7,'2'),(541,'2','0','190','笔筒',4,3,8.3,'把',1,'2'),(542,'2','0','190','卷笔刀',2,0,3,'把',2,'2'),(543,'2','0','197','吸水棉',14,0,0.8,'个',14,'2'),(544,'2','0','192','商务贴',10,0,2.8,'本',10,'2'),(545,'2','0','192','报事贴',13,0,4,'本',13,'2'),(546,'2','0','197','磁条',13,8,6.5,'对',5,'2'),(547,'2','0','197','磁粒',80,0,2.5,'对',80,'2'),(548,'2','0','197','装订夹-五金',30,0,18.9,'盒',30,'2'),(549,'2','0','197','装订夹-塑料',2,0,18.9,'盒',2,'2'),(550,'2','0','198','订书机-0221#（配10#针）',0,0,8,'个',0,'2'),(551,'2','0','198','订书机-0414#（配12#针）',17,0,12,'个',17,'2'),(552,'2','0','198','订书机-0394#（配13#针）',0,0,105,'个',0,'2'),(553,'2','0','198','订书机-迷你型（配10#针）',0,0,5,'个',0,'2'),(554,'2','0','198','订书针13#',31,0,1,'盒',31,'2'),(555,'2','0','198','订书针12#',0,0,1,'盒',0,'2'),(556,'2','0','198','订书针10#',0,0,0.65,'盒',0,'2'),(557,'2','0','198','回形针',11,0,1.5,'盒',11,'2'),(558,'2','0','198','回形针-彩色',0,0,3.6,'盒',0,'2'),(559,'2','0','198','大回形针',2,0,3.6,'盒',2,'2'),(560,'2','0','198','大头针',9,0,1.5,'盒',9,'2'),(561,'2','0','197','蜡线',36,0,9.5,'卷',36,'2'),(562,'2','0','197','宝塔线',18,0,10,'卷',18,'2'),(563,'2','0','197','包角纸',7,0,2.5,'束',7,'2'),(564,'2','0','199','计算器',12,0,45,'个',12,'2'),(565,'2','0','199','计算器-12位',0,0,60,'个',0,'2'),(566,'2','0','200','51MM长尾夹',12,0,12.5,'盒',12,'2'),(567,'2','0','200','41MM长尾夹',13,0,11.5,'盒',13,'2'),(568,'2','0','200','32MM长尾夹',10,0,7.5,'盒',10,'2'),(569,'2','0','200','25MM长尾夹',6,0,10.5,'盒',6,'2'),(570,'2','0','200','19MM长尾夹',14,0,5.5,'盒',14,'2'),(571,'2','0','200','19MM长尾夹（彩色）',1,0,5.5,'盒',1,'2'),(572,'2','0','199','透明胶',221,0,0.5,'卷',221,'2'),(573,'2','0','199','黄色封箱带',58,0,6,'卷',58,'2'),(574,'2','0','199','透明封箱带',25,0,5.7,'卷',25,'2'),(575,'2','0','199','透明封箱带-南航',451,0,5.7,'卷',451,'2'),(576,'2','0','199','打包带',452,0,12,'卷',452,'2'),(577,'2','0','199','打包扣',11,0,20,'盒',11,'2'),(578,'2','0','199','垃圾桶-塑料',12,0,7.8,'个',12,'2'),(579,'2','0','199','垃圾桶-金属',7,0,18,'个',7,'2'),(580,'2','0','199','别针（10个/组）',42,0,0.64,'组',42,'2'),(581,'2','0','199','橡皮筋',11,0,6,'包',11,'2'),(582,'2','0','198','7MM二孔打孔机',3,0,7,'个',3,'2'),(583,'2','0','198','7MM四孔打孔机',0,0,38,'个',0,'2'),(584,'2','0','198','5MM三孔打孔机',10,0,32,'个',10,'2'),(585,'2','0','199','原子印油',3,0,2.2,'盒',3,'2'),(586,'2','0','199','光敏印油（红）',2,0,12,'盒',2,'2'),(587,'2','0','199','光敏印油（蓝）',6,0,12,'盒',6,'2'),(588,'2','0','199','双面胶',0,0,0.8,'卷',0,'2'),(589,'2','0','199','双面胶-厚',25,0,1.2,'卷',25,'2'),(590,'2','0','196','印台-双色',5,0,11.2,'个',5,'2'),(591,'2','0','196','印台-蓝色',4,0,5.3,'个',4,'2'),(592,'2','0','196','印泥（大）',5,0,5.3,'个',5,'2'),(593,'2','0','196','印泥（中）',9,0,5.3,'个',9,'2'),(594,'2','0','196','印泥（小）',0,0,5.3,'个',0,'2'),(595,'2','0','201','电池1#',14,6,3,'节',8,'2'),(596,'2','0','201','电池2#',14,0,3,'节',14,'2'),(597,'2','0','201','电池5#',115,0,1.5,'节',115,'2'),(598,'2','0','201','电池7#',40,0,1.5,'节',40,'2'),(599,'2','0','201','电池9V',3,0,6,'节',3,'2'),(600,'2','0','192','大信封',1010,0,0.55,'个',1010,'2'),(601,'2','0','192','中信封',87,0,0.27,'个',87,'2'),(602,'2','0','192','小信封',435,0,0.16,'个',435,'2'),(603,'2','0','192','红头纸',96,0,8,'本',96,'2'),(604,'2','0','192','绿头纸',187,0,8,'本',187,'2'),(605,'2','0','202','一次性杯子',15,0,11.4,'卷',15,'2'),(606,'2','0','202','面巾纸',150,0,3.8,'盒',150,'2'),(607,'2','0','202','盒装面纸',51,0,6.16,'盒',51,'2'),(608,'2','0','197','卷尺（3M）',2,0,15,'个',2,'2'),(609,'2','0','197','卷尺(5M)',0,0,16,'个',0,'2'),(610,'2','0','190','白板擦',25,0,6,'个',25,'2'),(611,'2','0','196','印油-朱砂',0,0,5.3,'个',0,'2'),(612,'2','0','196','快干印泥油',1,0,8,'个',1,'2'),(613,'2','0','203','大垃圾袋',2,0,0,'袋',2,'2'),(614,'2','0','203','小垃圾袋',3,0,0,'箱',3,'2'),(615,'2','0','203','擦手纸',6,0,0,'箱',6,'2'),(616,'2','0','203','卷纸',0,0,0,'箱',0,'2'),(617,'2','0','203','塑料水杯',2300,0,0,'个',2300,'2'),(618,'2','0','203','小瓶矿泉水',28,0,0,'箱',28,'2'),(619,'2','0','203','苏打水',8,0,0,'箱',8,'2');

/*Table structure for table `shouse` */

DROP TABLE IF EXISTS `shouse`;

CREATE TABLE `shouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `houseName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `shouse` */

insert  into `shouse`(`id`,`houseName`,`department`) values (1,'航空办公用品库','1'),(2,'办公室库房','2');

/*Table structure for table `somefile` */

DROP TABLE IF EXISTS `somefile`;

CREATE TABLE `somefile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `somefile` */

insert  into `somefile`(`id`,`userName`,`fileName`,`filePath`,`comment`) values (1,NULL,NULL,'E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103003648null',NULL),(2,NULL,NULL,'E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103003758null',NULL),(3,NULL,NULL,'E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103004233null',NULL),(4,NULL,NULL,'E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103004240null',NULL),(5,NULL,NULL,'E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103004545null',NULL),(6,NULL,'QQPCDetector.exe','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103124646QQPCDetector.exe',NULL),(7,NULL,'QQPCDetector.exe','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103124735QQPCDetector.exe',NULL),(8,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103165123办公用品物品清单 xls1 (35) - 副本.xls',NULL),(9,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103165236办公用品物品清单 xls1 (35) - 副本.xls',NULL),(10,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103165458办公用品物品清单 xls1 (35) - 副本.xls',NULL),(11,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103192547办公用品物品清单 xls1 (35) - 副本.xls',NULL),(12,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103193148办公用品物品清单 xls1 (35) - 副本.xls',NULL),(13,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103193739办公用品物品清单 xls1 (35) - 副本.xls',NULL),(14,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131103194414办公用品物品清单 xls1 (35) - 副本.xls',NULL),(15,NULL,'办公用品物品清单 xls1 (35) - 副本.xls','E:\\server\\apache-tomcat-6.0.37\\wtpwebapps\\yzmanager\\upload\\131104002022办公用品物品清单 xls1 (35) - 副本.xls',NULL);

/*Table structure for table `storehouse` */

DROP TABLE IF EXISTS `storehouse`;

CREATE TABLE `storehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `inDepartment` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `firstCName` varchar(255) DEFAULT NULL,
  `secondCName` varchar(255) DEFAULT NULL,
  `houseId` varchar(255) DEFAULT NULL,
  `inDate` datetime DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `inContent` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `inCount` int(11) DEFAULT NULL,
  `inVerify` int(11) DEFAULT NULL,
  `inVerifyName` varchar(255) DEFAULT NULL,
  `inRemarks` varchar(255) DEFAULT NULL,
  `VerifyRemarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=786 DEFAULT CHARSET=utf8;

/*Data for the table `storehouse` */

insert  into `storehouse`(`id`,`version`,`userName`,`inDepartment`,`department`,`firstCName`,`secondCName`,`houseId`,`inDate`,`unitPrice`,`totalPrice`,`inContent`,`unit`,`inCount`,`inVerify`,`inVerifyName`,`inRemarks`,`VerifyRemarks`) values (629,0,'a','1','2','190','466','2','2013-11-04 00:20:22',0.78,0,'12支/盒 0.5mm9','支',0,1,'a',NULL,'同意'),(630,0,'a','1','2','190','467','2','2013-11-04 00:20:22',2.2,0,'12支/盒 0.5mm9','支',33,1,'a',NULL,'同意'),(631,0,'a','1','2','190','468','2','2013-11-04 00:20:22',1.6,0,'12支/盒 0.5mm9','支',13,1,'a',NULL,'同意'),(632,0,'a','1','2','190','469','2','2013-11-04 00:20:23',0.47,0,'20支/盒 0.5mm 130mm2017','支',320,1,'a',NULL,'同意'),(633,0,'a','1','2','190','470','2','2013-11-04 00:20:23',0.67,0,'20支/盒 0.5mm 130mm2017','支',100,1,'a',NULL,'同意'),(634,0,'a','1','2','190','471','2','2013-11-04 00:20:23',0.67,0,'20支/盒 0.5mm 130mm2017','支',8,1,'a',NULL,'同意'),(635,0,'a','1','2','190','472','2','2013-11-04 00:20:23',5,0,'','支',3,1,'a',NULL,'同意'),(636,0,'a','1','2','190','473','2','2013-11-04 00:20:23',2.5,0,'真彩服务性专用台笔（黑） 0.5mm5621','支',6,1,'a',NULL,'同意'),(637,0,'a','1','2','190','474','2','2013-11-04 00:20:23',6.4,0,'斑马中嘴白板笔（黑） 10支/盒','支',24,1,'a',NULL,'同意'),(638,0,'a','1','2','190','475','2','2013-11-04 00:20:23',6.4,0,'斑马中嘴白板笔（红） 10支/盒','支',41,1,'a',NULL,'同意'),(639,0,'a','1','2','190','476','2','2013-11-04 00:20:23',6.4,0,'斑马中嘴白板笔（蓝） 10支/盒','支',53,1,'a',NULL,'同意'),(640,0,'a','1','2','190','477','2','2013-11-04 00:20:23',1.5,0,'东洋荧光笔  10支/盒','支',5,1,'a',NULL,'同意'),(641,0,'a','1','2','190','478','2','2013-11-04 00:20:23',1.4,0,'永生88记号笔（黑） 10支/盒','支',13,1,'a',NULL,'同意'),(642,0,'a','1','2','190','479','2','2013-11-04 00:20:23',1.4,0,'永生88记号笔（红） 10支/盒','支',13,1,'a',NULL,'同意'),(643,0,'a','1','2','190','480','2','2013-11-04 00:20:23',1.4,0,'永生88记号笔（蓝） 10支/盒','支',7,1,'a',NULL,'同意'),(644,0,'a','1','2','190','481','2','2013-11-04 00:20:23',1,0,'','支',0,1,'a',NULL,'同意'),(645,0,'a','1','2','190','482','2','2013-11-04 00:20:23',1,0,'','支',10,1,'a',NULL,'同意'),(646,0,'a','1','2','190','483','2','2013-11-04 00:20:23',1,0,'','支',2,1,'a',NULL,'同意'),(647,0,'a','1','2','190','484','2','2013-11-04 00:20:23',1,0,'','支',30,1,'a',NULL,'同意'),(648,0,'a','1','2','190','485','2','2013-11-04 00:20:23',0.8,0,'12支/盒','支',0,1,'a',NULL,'同意'),(649,0,'a','1','2','190','486','2','2013-11-04 00:20:23',1.9,0,'12支/盒 0.7mm','支',1,1,'a',NULL,'同意'),(650,0,'a','1','2','190','487','2','2013-11-04 00:20:23',0.67,0,'100支/盒','支',1298,1,'a',NULL,'同意'),(651,0,'a','1','2','190','488','2','2013-11-04 00:20:24',0.68,0,'10/盒','支',0,1,'a',NULL,'同意'),(652,0,'a','1','2','190','489','2','2013-11-04 00:20:24',0.5,0,'中华铅笔量贩（黑）10支/盒 101-HB','支',50,1,'a',NULL,'同意'),(653,0,'a','1','2','190','490','2','2013-11-04 00:20:24',0.6,0,'','支',6,1,'a',NULL,'同意'),(654,0,'a','1','2','190','491','2','2013-11-04 00:20:24',0.45,0,'长城小金边橡皮（白）','块',24,1,'a',NULL,'同意'),(655,0,'a','1','2','190','492','2','2013-11-04 00:20:24',2.2,0,'白雪修正液 12瓶/盒','瓶',15,1,'a',NULL,'同意'),(656,0,'a','1','2','190','493','2','2013-11-04 00:20:24',4.5,0,'','个',0,1,'a',NULL,'同意'),(657,0,'a','1','2','191','494','2','2013-11-04 00:20:24',1.1,0,'得力固体胶 12个/盒','个',0,1,'a',NULL,'同意'),(658,0,'a','1','2','191','495','2','2013-11-04 00:20:24',1.4,0,'得力液体胶水 50ml','个',32,1,'a',NULL,'同意'),(659,0,'a','1','2','190','496','2','2013-11-04 00:20:24',12,0,'','瓶',8,1,'a',NULL,'同意'),(660,0,'a','1','2','190','497','2','2013-11-04 00:20:24',5,0,'','瓶',0,1,'a',NULL,'同意'),(661,0,'a','1','2','190','498','2','2013-11-04 00:20:24',3.1,0,'50ML','瓶',1,1,'a',NULL,'同意'),(662,0,'a','1','2','190','499','2','2013-11-04 00:20:24',5,0,'','瓶',0,1,'a',NULL,'同意'),(663,0,'a','1','2','190','500','2','2013-11-04 00:20:24',5,0,'英雄博士蓝黑墨水','瓶',4,1,'a',NULL,'同意'),(664,0,'a','1','2','190','501','2','2013-11-04 00:20:24',5,0,'','瓶',0,1,'a',NULL,'同意'),(665,0,'a','1','2','192','502','2','2013-11-04 00:20:24',11.3,0,'APP精装本A4 96页  5本/包','本',17,1,'a',NULL,'同意'),(666,0,'a','1','2','192','503','2','2013-11-04 00:20:24',6.2,0,'广博精品硬面抄  5本/包','本',13,1,'a',NULL,'同意'),(667,0,'a','1','2','192','504','2','2013-11-04 00:20:24',5,0,'5本/包','本',126,1,'a',NULL,'同意'),(668,0,'a','1','2','192','505','2','2013-11-04 00:20:24',5,0,'10本/包','本',23,1,'a',NULL,'同意'),(669,0,'a','1','2','192','506','2','2013-11-04 00:20:24',2,0,'10本/包','本',7,1,'a',NULL,'同意'),(670,0,'a','1','2','192','507','2','2013-11-04 00:20:24',13.8,0,'','本',3,1,'a',NULL,'同意'),(671,0,'a','1','2','193','508','2','2013-11-04 00:20:24',5.6,0,'齐心A4文件夹  12个/盒','个',19,1,'a',NULL,'同意'),(672,0,'a','1','2','193','509','2','2013-11-04 00:20:24',8,0,'','个',36,1,'a',NULL,'同意'),(673,0,'a','1','2','193','510','2','2013-11-04 00:20:24',15,0,'','本',5,1,'a',NULL,'同意'),(674,0,'a','1','2','193','511','2','2013-11-04 00:20:24',1.62,0,'齐心A4抽杆夹  10个/套','个',40,1,'a',NULL,'同意'),(675,0,'a','1','2','193','512','2','2013-11-04 00:20:25',6,0,'塑料书写板夹','个',9,1,'a',NULL,'同意'),(676,0,'a','1','2','193','513','2','2013-11-04 00:20:25',12.2,0,'得力粘扣档案盒3寸A4蓝5603  12个/盒','个',13,1,'a',NULL,'同意'),(677,0,'a','1','2','193','514','2','2013-11-04 00:20:25',0.4,0,'北京牛皮纸档案袋量贩（土黄色）A4 2寸  25个/包','个',50,1,'a',NULL,'同意'),(678,0,'a','1','2','193','515','2','2013-11-04 00:20:25',1.9,0,'齐心文件袋（透明）A4  20个/包','个',21,1,'a',NULL,'同意'),(679,0,'a','1','2','193','516','2','2013-11-04 00:20:25',3,0,'','个',1,1,'a',NULL,'同意'),(680,0,'a','1','2','193','517','2','2013-11-04 00:20:25',3,0,'','个',12,1,'a',NULL,'同意'),(681,0,'a','1','2','193','518','2','2013-11-04 00:20:25',4,0,'','个',0,1,'a',NULL,'同意'),(682,0,'a','1','2','193','519','2','2013-11-04 00:20:25',1.7,0,'','个',0,1,'a',NULL,'同意'),(683,0,'a','1','2','193','520','2','2013-11-04 00:20:25',1.7,0,'','个',20,1,'a',NULL,'同意'),(684,0,'a','1','2','193','521','2','2013-11-04 00:20:25',1.9,0,'齐心按钮式文件袋（透明）A4 12个/包','个',4,1,'a',NULL,'同意'),(685,0,'a','1','2','194','522','2','2013-11-04 00:20:25',9.2,0,'齐心标准型资料册 NF20  12个/盒','本',7,1,'a',NULL,'同意'),(686,0,'a','1','2','194','523','2','2013-11-04 00:20:25',14.5,0,'齐心标准型资料册 NF40  12个/盒','本',21,1,'a',NULL,'同意'),(687,0,'a','1','2','194','524','2','2013-11-04 00:20:25',16.5,0,'齐心标准型资料册 NF60  12个/盒','本',72,1,'a',NULL,'同意'),(688,0,'a','1','2','194','525','2','2013-11-04 00:20:25',18.5,0,'6个/盒','本',9,1,'a',NULL,'同意'),(689,0,'a','1','2','194','526','2','2013-11-04 00:20:25',20.5,0,'6个/盒','本',15,1,'a',NULL,'同意'),(690,0,'a','1','2','194','527','2','2013-11-04 00:20:25',36.1,0,'树德银系资料架（银色）A4 三格','组',0,1,'a',NULL,'同意'),(691,0,'a','1','2','194','528','2','2013-11-04 00:20:25',20.8,0,'钊盛四档资料架（黑） A4 四格','组',8,1,'a',NULL,'同意'),(692,0,'a','1','2','192','529','2','2013-11-04 00:20:25',6,0,'','本',2,1,'a',NULL,'同意'),(693,0,'a','1','2','192','530','2','2013-11-04 00:20:25',10.8,0,'','本',8,1,'a',NULL,'同意'),(694,0,'a','1','2','192','531','2','2013-11-04 00:20:25',2,0,'立信三联领料单','本',22,1,'a',NULL,'同意'),(695,0,'a','1','2','192','532','2','2013-11-04 00:20:25',2.3,0,'立信三联收款收据60K','本',16,1,'a',NULL,'同意'),(696,0,'a','1','2','192','533','2','2013-11-04 00:20:25',1.5,0,'','本',15,1,'a',NULL,'同意'),(697,0,'a','1','2','192','534','2','2013-11-04 00:20:25',1.5,0,'','本',13,1,'a',NULL,'同意'),(698,0,'a','1','2','192','535','2','2013-11-04 00:20:25',3.5,0,'上海牌复写纸','盒',4,1,'a',NULL,'同意'),(699,0,'a','1','2','192','536','2','2013-11-04 00:20:25',7.4,0,'上海牌复写纸','盒',0,1,'a',NULL,'同意'),(700,0,'a','1','2','195','537','2','2013-11-04 00:20:26',2.8,0,'益而高剪刀','把',17,1,'a',NULL,'同意'),(701,0,'a','1','2','195','538','2','2013-11-04 00:20:26',2.1,0,'得力起钉器','个',18,1,'a',NULL,'同意'),(702,0,'a','1','2','195','539','2','2013-11-04 00:20:26',2.5,0,'得力金属小美工刀','把',12,1,'a',NULL,'同意'),(703,0,'a','1','2','196','540','2','2013-11-04 00:20:26',1.5,0,'得力直尺（透明）30cm','把',7,1,'a',NULL,'同意'),(704,0,'a','1','2','190','541','2','2013-11-04 00:20:26',8.3,0,'得力笔筒','把',4,1,'a',NULL,'同意'),(705,0,'a','1','2','190','542','2','2013-11-04 00:20:26',3,0,'得力削笔器','把',2,1,'a',NULL,'同意'),(706,0,'a','1','2','197','543','2','2013-11-04 00:20:26',0.8,0,'得力财务用海绵缸','个',14,1,'a',NULL,'同意'),(707,0,'a','1','2','192','544','2','2013-11-04 00:20:26',2.8,0,'OA商务贴 4条/包','本',10,1,'a',NULL,'同意'),(708,0,'a','1','2','192','545','2','2013-11-04 00:20:26',4,0,'3M报事贴好（黄）3x3 8本/包','本',13,1,'a',NULL,'同意'),(709,0,'a','1','2','197','546','2','2013-11-04 00:20:26',6.5,0,'钊盛白板磁条（混色）','对',13,1,'a',NULL,'同意'),(710,0,'a','1','2','197','547','2','2013-11-04 00:20:26',2.5,0,'得力小号磁粒','对',80,1,'a',NULL,'同意'),(711,0,'a','1','2','197','548','2','2013-11-04 00:20:26',18.9,0,'易达文件装订夹','盒',30,1,'a',NULL,'同意'),(712,0,'a','1','2','197','549','2','2013-11-04 00:20:26',18.9,0,'易达文件装订夹','盒',2,1,'a',NULL,'同意'),(713,0,'a','1','2','198','550','2','2013-11-04 00:20:26',8,0,'','个',0,1,'a',NULL,'同意'),(714,0,'a','1','2','198','551','2','2013-11-04 00:20:26',12,0,'','个',17,1,'a',NULL,'同意'),(715,0,'a','1','2','198','552','2','2013-11-04 00:20:26',105,0,'','个',0,1,'a',NULL,'同意'),(716,0,'a','1','2','198','553','2','2013-11-04 00:20:26',5,0,'','个',0,1,'a',NULL,'同意'),(717,0,'a','1','2','198','554','2','2013-11-04 00:20:26',1,0,'','盒',31,1,'a',NULL,'同意'),(718,0,'a','1','2','198','555','2','2013-11-04 00:20:27',1,0,'得力订书针 12#  10盒/包','盒',0,1,'a',NULL,'同意'),(719,0,'a','1','2','198','556','2','2013-11-04 00:20:27',0.65,0,'得力订书针 10#  10盒/包','盒',0,1,'a',NULL,'同意'),(720,0,'a','1','2','198','557','2','2013-11-04 00:20:27',1.5,0,'得力回形针29mm 100枚  10盒/包','盒',11,1,'a',NULL,'同意'),(721,0,'a','1','2','198','558','2','2013-11-04 00:20:27',3.6,0,'','盒',0,1,'a',NULL,'同意'),(722,0,'a','1','2','198','559','2','2013-11-04 00:20:27',3.6,0,'','盒',2,1,'a',NULL,'同意'),(723,0,'a','1','2','198','560','2','2013-11-04 00:20:27',1.5,0,'益而高大头针','盒',9,1,'a',NULL,'同意'),(724,0,'a','1','2','197','561','2','2013-11-04 00:20:27',9.5,0,'立信装订用线','卷',36,1,'a',NULL,'同意'),(725,0,'a','1','2','197','562','2','2013-11-04 00:20:27',10,0,'','卷',18,1,'a',NULL,'同意'),(726,0,'a','1','2','197','563','2','2013-11-04 00:20:27',2.5,0,'立信包角纸  25套','束',7,1,'a',NULL,'同意'),(727,0,'a','1','2','199','564','2','2013-11-04 00:20:27',45,0,'卡西欧计算器 MX-120S','个',12,1,'a',NULL,'同意'),(728,0,'a','1','2','199','565','2','2013-11-04 00:20:27',60,0,'','个',0,1,'a',NULL,'同意'),(729,0,'a','1','2','200','566','2','2013-11-04 00:20:27',12.5,0,'易优百黑色长尾夹（黑色） 51MM','盒',12,1,'a',NULL,'同意'),(730,0,'a','1','2','200','567','2','2013-11-04 00:20:27',11.5,0,'易优百黑色长尾夹（黑色） 41MM','盒',13,1,'a',NULL,'同意'),(731,0,'a','1','2','200','568','2','2013-11-04 00:20:27',7.5,0,'易优百黑色长尾夹（黑色） 32MM','盒',10,1,'a',NULL,'同意'),(732,0,'a','1','2','200','569','2','2013-11-04 00:20:27',10.5,0,'易优百黑色长尾夹（黑色） 25MM','盒',6,1,'a',NULL,'同意'),(733,0,'a','1','2','200','570','2','2013-11-04 00:20:27',5.5,0,'易优百黑色长尾夹（黑色） 19MM','盒',14,1,'a',NULL,'同意'),(734,0,'a','1','2','200','571','2','2013-11-04 00:20:27',5.5,0,'易优百长尾夹（彩色）19MM','盒',1,1,'a',NULL,'同意'),(735,0,'a','1','2','199','572','2','2013-11-04 00:20:27',0.5,0,'永大透明胶  1.2CM','卷',221,1,'a',NULL,'同意'),(736,0,'a','1','2','199','573','2','2013-11-04 00:20:27',6,0,'易贴黄色封箱胶带  5卷/筒','卷',58,1,'a',NULL,'同意'),(737,0,'a','1','2','199','574','2','2013-11-04 00:20:27',5.7,0,'得力普通封箱胶带量贩  5卷/筒','卷',25,1,'a',NULL,'同意'),(738,0,'a','1','2','199','575','2','2013-11-04 00:20:27',5.7,0,'南航LOGO封箱胶带  6卷/筒','卷',451,1,'a',NULL,'同意'),(739,0,'a','1','2','199','576','2','2013-11-04 00:20:28',12,0,'PP打包带','卷',452,1,'a',NULL,'同意'),(740,0,'a','1','2','199','577','2','2013-11-04 00:20:28',20,0,'宝冠金属打包扣  500个/盒','盒',11,1,'a',NULL,'同意'),(741,0,'a','1','2','199','578','2','2013-11-04 00:20:28',7.8,0,'得力圆形纸篓（蓝色）','个',12,1,'a',NULL,'同意'),(742,0,'a','1','2','199','579','2','2013-11-04 00:20:28',18,0,'铁质垃圾桶','个',7,1,'a',NULL,'同意'),(743,0,'a','1','2','199','580','2','2013-11-04 00:20:28',0.64,0,'上海3号别针','组',42,1,'a',NULL,'同意'),(744,0,'a','1','2','199','581','2','2013-11-04 00:20:28',6,0,'好文客橡皮筋（80G）','包',11,1,'a',NULL,'同意'),(745,0,'a','1','2','198','582','2','2013-11-04 00:20:28',7,0,'齐心精致型打孔机','个',3,1,'a',NULL,'同意'),(746,0,'a','1','2','198','583','2','2013-11-04 00:20:28',38,0,'得力四孔打孔机','个',0,1,'a',NULL,'同意'),(747,0,'a','1','2','198','584','2','2013-11-04 00:20:28',32,0,'可得优三孔可调式打孔机','个',10,1,'a',NULL,'同意'),(748,0,'a','1','2','199','585','2','2013-11-04 00:20:28',2.2,0,'杰丽斯原子印油（红）','盒',3,1,'a',NULL,'同意'),(749,0,'a','1','2','199','586','2','2013-11-04 00:20:28',12,0,'光敏印印油(红） 10ml','盒',2,1,'a',NULL,'同意'),(750,0,'a','1','2','199','587','2','2013-11-04 00:20:28',12,0,'光敏印印油(蓝） 10ml','盒',6,1,'a',NULL,'同意'),(751,0,'a','1','2','199','588','2','2013-11-04 00:20:28',0.8,0,'晶华双面胶','卷',0,1,'a',NULL,'同意'),(752,0,'a','1','2','199','589','2','2013-11-04 00:20:28',1.2,0,'晶华海绵胶','卷',25,1,'a',NULL,'同意'),(753,0,'a','1','2','196','590','2','2013-11-04 00:20:28',11.2,0,'立信双色快干印台（红/蓝）','个',5,1,'a',NULL,'同意'),(754,0,'a','1','2','196','591','2','2013-11-04 00:20:28',5.3,0,'得力透明圆形快干印台（蓝）','个',4,1,'a',NULL,'同意'),(755,0,'a','1','2','196','592','2','2013-11-04 00:20:28',5.3,0,'泥质印泥','个',5,1,'a',NULL,'同意'),(756,0,'a','1','2','196','593','2','2013-11-04 00:20:28',5.3,0,'泥质印泥','个',9,1,'a',NULL,'同意'),(757,0,'a','1','2','196','594','2','2013-11-04 00:20:28',5.3,0,'泥质印泥','个',0,1,'a',NULL,'同意'),(758,0,'a','1','2','201','595','2','2013-11-04 00:20:28',3,0,'','节',14,1,'a',NULL,'同意'),(759,0,'a','1','2','201','596','2','2013-11-04 00:20:28',3,0,'','节',14,1,'a',NULL,'同意'),(760,0,'a','1','2','201','597','2','2013-11-04 00:20:28',1.5,0,'白象碱性电池5# （5节/板）','节',115,1,'a',NULL,'同意'),(761,0,'a','1','2','201','598','2','2013-11-04 00:20:28',1.5,0,'白象碱性电池7# （5节/板）','节',40,1,'a',NULL,'同意'),(762,0,'a','1','2','201','599','2','2013-11-04 00:20:28',6,0,'','节',3,1,'a',NULL,'同意'),(763,0,'a','1','2','192','600','2','2013-11-04 00:20:28',0.55,0,'南航LOGO大信封（白色） 100个/封','个',1010,1,'a',NULL,'同意'),(764,0,'a','1','2','192','601','2','2013-11-04 00:20:28',0.27,0,'南航LOGO中信封（土黄色）100个/封','个',87,1,'a',NULL,'同意'),(765,0,'a','1','2','192','602','2','2013-11-04 00:20:29',0.16,0,'南航LOGO小信封（白色）100个/封','个',435,1,'a',NULL,'同意'),(766,0,'a','1','2','192','603','2','2013-11-04 00:20:29',8,0,'南航抬头红头纸','本',96,1,'a',NULL,'同意'),(767,0,'a','1','2','192','604','2','2013-11-04 00:20:29',8,0,'南航抬头绿头纸','本',187,1,'a',NULL,'同意'),(768,0,'a','1','2','202','605','2','2013-11-04 00:20:29',11.4,0,'汇丰纸杯 230ml增厚装  50个/包','卷',15,1,'a',NULL,'同意'),(769,0,'a','1','2','202','606','2','2013-11-04 00:20:29',3.8,0,'心相印袋装面巾纸  3包/组','盒',150,1,'a',NULL,'同意'),(770,0,'a','1','2','202','607','2','2013-11-04 00:20:29',6.16,0,'妮飘盒装面纸150抽5盒装','盒',51,1,'a',NULL,'同意'),(771,0,'a','1','2','197','608','2','2013-11-04 00:20:29',15,0,'3米卷尺','个',2,1,'a',NULL,'同意'),(772,0,'a','1','2','197','609','2','2013-11-04 00:20:29',16,0,'5米卷尺','个',0,1,'a',NULL,'同意'),(773,0,'a','1','2','190','610','2','2013-11-04 00:20:29',6,0,'','个',25,1,'a',NULL,'同意'),(774,0,'a','1','2','196','611','2','2013-11-04 00:20:29',5.3,0,'','个',0,1,'a',NULL,'同意'),(775,0,'a','1','2','196','612','2','2013-11-04 00:20:29',8,0,'','个',1,1,'a',NULL,'同意'),(776,0,'a','1','2','203','613','2','2013-11-04 00:20:29',0,0,'90*110','袋',2,1,'a',NULL,'同意'),(777,0,'a','1','2','203','614','2','2013-11-04 00:20:29',0,0,'50*60','箱',3,1,'a',NULL,'同意'),(778,0,'a','1','2','203','615','2','2013-11-04 00:20:29',0,0,'','箱',6,1,'a',NULL,'同意'),(779,0,'a','1','2','203','616','2','2013-11-04 00:20:29',0,0,'','箱',0,1,'a',NULL,'同意'),(780,0,'a','1','2','203','617','2','2013-11-04 00:20:29',0,0,'50个/包','个',2300,1,'a',NULL,'同意'),(781,0,'a','1','2','203','618','2','2013-11-04 00:20:29',0,0,'24瓶/箱','箱',28,1,'a',NULL,'同意'),(782,0,'a','1','2','203','619','2','2013-11-04 00:20:29',0,0,'','箱',8,1,'a',NULL,'同意'),(784,0,'a','1','2','191','494','2','2013-11-05 23:05:26',3.1,0,'dsad','瓶',9,0,'a',' ',NULL),(785,0,'a','1','2','195','537','2','2013-11-05 23:05:26',5,0,'把','把',50,0,'a',' ',NULL);

/*Table structure for table `system` */

DROP TABLE IF EXISTS `system`;

CREATE TABLE `system` (
  `systemID` int(11) NOT NULL AUTO_INCREMENT,
  `systemName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`systemID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system` */

insert  into `system`(`systemID`,`systemName`) values (1,'办公用品管理系统');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`userPassword`,`name`,`sex`,`department`,`post`,`remarks`,`status`) values (2,'a','0b4e7a0e5fe84ad35fb5f95b9ceeac79','陈飞','男','1',NULL,NULL,1),(3,'wjtao','0b4e7a0e5fe84ad35fb5f95b9ceeac79','陶维佳','男','2','用品发放人员','优秀',1),(5,'bli','96e79218965eb72c92a549dd5a330112','李冰','男','2','普通员工','',1),(6,'zhangsan','0b4e7a0e5fe84ad35fb5f95b9ceeac79','张三','男','2','审核','',1),(7,'wangwu','96e79218965eb72c92a549dd5a330112','王五','男','2','办公室主任','',1),(8,'部门管理员11','e10adc3949ba59abbe56e057f20f883e','部门管理员111','男','1','部门管理员111','部门管理员111',1),(9,'综合办主任','e10adc3949ba59abbe56e057f20f883e','综合办主任','男','1','综合办主任','综合办主任',1),(10,'guanliyuan','e10adc3949ba59abbe56e057f20f883e','部门管理员','男','1','部门管理员','部门管理员',1),(11,'zhuren','e10adc3949ba59abbe56e057f20f883e','主任','男','1','主任','主任',1),(12,'jingli','e10adc3949ba59abbe56e057f20f883e','经理','男','1','经理','经理',1);

/*Table structure for table `userarea` */

DROP TABLE IF EXISTS `userarea`;

CREATE TABLE `userarea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `areaName` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userarea` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
