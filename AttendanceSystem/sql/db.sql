-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.19-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 attendancesystem 的数据库结构
DROP DATABASE IF EXISTS `attendancesystem`;
CREATE DATABASE IF NOT EXISTS `attendancesystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `attendancesystem`;

-- 导出  表 attendancesystem.record 结构
DROP TABLE IF EXISTS `record`;
CREATE TABLE IF NOT EXISTS `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL DEFAULT '0' COMMENT '学生id',
  `date` varchar(50) NOT NULL COMMENT '考勤日期',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0正常1迟到2早退3旷课',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='考勤记录';

-- 正在导出表  attendancesystem.record 的数据：~0 rows (大约)
DELETE FROM `record`;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` (`id`, `studentId`, `date`, `status`) VALUES
	(1, 1, '2018-12-20', 1),
	(2, 3, '2018-12-20', 3),
	(3, 4, '2018-12-20', 0),
	(4, 9, '2018-12-20', 2);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;

-- 导出  表 attendancesystem.student 结构
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（用于登录）',
  `number` varchar(50) NOT NULL DEFAULT '0' COMMENT '学号（用于登录）',
  `teacherId` int(11) NOT NULL DEFAULT '0' COMMENT '班主任id',
  `gender` varchar(20) NOT NULL DEFAULT '0' COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  attendancesystem.student 的数据：~10 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `password`, `number`, `teacherId`, `gender`) VALUES
	(1, '肖同学', '123456', '001', 1, '男'),
	(2, '赵同学', '123456', '002', 1, '男'),
	(3, '李同学', '123456', '003', 1, '男'),
	(4, '孙同学', '123456', '004', 1, '男'),
	(5, '马同学', '123456', '005', 1, '男'),
	(6, '陈同学', '123456', '006', 1, '男'),
	(7, '黄同学', '123456', '007', 1, '男'),
	(8, '王同学', '123456', '008', 1, '男'),
	(9, '林同学', '123456', '009', 1, '男'),
	(10, '周同学', '123456', '010', 1, '男');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 attendancesystem.teacher 结构
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0' COMMENT '姓名',
  `password` varchar(50) NOT NULL DEFAULT '0' COMMENT '密码（用于登录）',
  `number` varchar(50) NOT NULL DEFAULT '0' COMMENT '工号（用于登录）',
  `gender` varchar(20) NOT NULL DEFAULT '0' COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  attendancesystem.teacher 的数据：~1 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `name`, `password`, `number`, `gender`) VALUES
	(1, '肖老师', '123456', '007007', '男');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
