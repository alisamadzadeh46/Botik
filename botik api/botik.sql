-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 18, 2021 at 01:16 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alisama1_botik`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `token` text NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `codeposti` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `phone` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `phonesabet` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `token`, `address`, `codeposti`, `phone`, `phonesabet`) VALUES
(2, 'e4a0ecde9947a6b6de8b03c738fb1861', 'aaaa', '90909', '09214539576', '9090123'),
(3, 'afdf6123d6634cba1c378e8a1179a0c3', 'اردبیل', '949449494', '09214539576', '09214539576'),
(4, 'dab179b1a53c07c773e42fbed8011969', '', '', '', ''),
(5, 'dab179b1a53c07c773e42fbed8011969', 'vgfvb ', '785680', '888554', '855445'),
(6, 'dab179b1a53c07c773e42fbed8011969', 'vbjjcdf', '65656263', '454543660', '451213'),
(7, 'c23c486a9494b6628ffea868afe1062a', 'شهرک آزادی', '35353', '242535863', '');

-- --------------------------------------------------------

--
-- Table structure for table `Cart`
--

CREATE TABLE `Cart` (
  `id` int(11) NOT NULL,
  `token` varchar(280) NOT NULL,
  `idproduct` varchar(280) NOT NULL,
  `count` varchar(280) NOT NULL,
  `price` varchar(280) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart`
--

INSERT INTO `Cart` (`id`, `token`, `idproduct`, `count`, `price`) VALUES
(35, 'e4a0ecde9947a6b6de8b03c738fb1861', '1', '1', '500'),
(36, 'dab179b1a53c07c773e42fbed8011969', '1', '1', '500');

-- --------------------------------------------------------

--
-- Table structure for table `Pay`
--

CREATE TABLE `Pay` (
  `id` int(11) NOT NULL,
  `title` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `image` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `link` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Pay`
--

INSERT INTO `Pay` (`id`, `title`, `image`, `link`) VALUES
(1, 'پرداخت از طریق درگاه زرین پال', 'http://your domain.ir/botik/zarinpal.jpg', 'http://your domain.ir/botik/zarinpal.php?code=');

-- --------------------------------------------------------

--
-- Table structure for table `Post`
--

CREATE TABLE `Post` (
  `idpost` int(11) NOT NULL,
  `image` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `made` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `price` varchar(280) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `tozih` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Post`
--

INSERT INTO `Post` (`idpost`, `image`, `made`, `price`, `tozih`, `name`) VALUES
(1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3MnITSAjzPLi8MnPfIu_i84v2HOQRUOq1UQ&usqp=CAU', 'ترکیه', '500', 'مانتو خوبیه', 'مانتو ترکیه'),
(2, 'https://www.amazing.ir/wp-content/uploads/2014/09/Model-fall-Amazing-ir-2015-11.jpg', 'ترکیه', '500', 'مانتو خوبیه', 'مانتو ترکیه');

-- --------------------------------------------------------

--
-- Table structure for table `Slider`
--

CREATE TABLE `Slider` (
  `id` int(11) NOT NULL,
  `idpost` int(11) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Slider`
--

INSERT INTO `Slider` (`id`, `idpost`, `image`) VALUES
(1, 1, 'https://lh3.googleusercontent.com/proxy/XvPm6iw1MfgUvN2KRhSLIGTVQ_NJtHv6emXkpYJbBEFopoTiNgV431D82r83xcXjzFFOMvNeMlE5R--fBt2_zjZUfTJ7YIDihaAnHi7DbkoeC5oK6ksUOKCqtRw'),
(2, 1, 'https://lh3.googleusercontent.com/proxy/l7smqXltSXXEIUhaSqLRpz8cs0ceXYFGEWvtWjHPU7wrgzVuhI7uTnKeHXxjqpcQA3BQA6U3hOzgDBh9o36OOh-XPK3SPw569eqDhri0w6VyoVDe1Rt6ZVBgurY9LlWNu8Sh'),
(3, 1, 'https://arga-mag.com/file/img/2016/05/Model-Manto-turk-5.jpg'),
(4, 1, 'https://parsnaz.com/upload/81/0.717346001393758777_parsnaz_ir.jpg'),
(5, 2, 'https://lh3.googleusercontent.com/proxy/ILjMHlypNw6sJ-wBzkK-tc0ph3ytXcsrInJYx4uhjoXotgNbIG1q-8_asqA6LU0j86k3t7kQxL_dMEXGWxXG4kx4HpBiqJZw_vTJcbJnD2rtZwRZDkQNLzveguUDjUChrNQ8OfQgQlCXl6eT-GYEPuzOTHCOQ6ldB_PmyDrHkoZUc41A0qL9swTdj679UULn2zUdfOwYUGSKIyCZFyt58MCd4ifId1DOA0AEK1Rf21Gl5jGwLu-eGZ_rl091Zb5P2IJvoraOZGxGhmW9GwSWIsNTpwp8Gnq-fkA1Ah-7gmIy3mWelw'),
(6, 2, 'https://www.tasvirezendegi.com/wp-content/uploads/2017/06/-%D8%AA%D8%B1%DA%A9-%D8%AA%D8%A7%D8%A8%D8%B3%D8%AA%D8%A7%D9%86%DB%8C-10-e1496996692771.jpg'),
(7, 2, 'https://lh3.googleusercontent.com/proxy/4X-Jde597NLXw5ZSth0RsQyHVzXVsukObNq0UJombEp6eTTZf8PJg9VpkTgVGe3sVIpnkki_rvrq-BuwJNGRrYMuzZoi6U_n8ny9PxzEG30-NRqLTd2_KCXnrbE8q6xjs9psT3FSa_jWbLNkFwR0tm6eAo-2eFv9ylM2uklyCzjQkrpKIOatjLN1CCg'),
(8, 2, 'https://harfetaze.com/wp-content/uploads/2019/03/manto-tork-majlesi-20.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id` int(11) NOT NULL,
  `token` varchar(280) NOT NULL,
  `idaddress` varchar(20) NOT NULL,
  `price` varchar(280) NOT NULL,
  `status` text CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `code_pardakht` varchar(280) NOT NULL,
  `Authority` varchar(280) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_order`
--

INSERT INTO `tbl_order` (`id`, `token`, `idaddress`, `price`, `status`, `code_pardakht`, `Authority`) VALUES
(45, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '1', '34189', 'A00000000000000000000000000210593610'),
(46, 'afdf6123d6634cba1c378e8a1179a0c3', '', '500', '0', '68774', NULL),
(47, 'dab179b1a53c07c773e42fbed8011969', '', '1500', '0', '56520', NULL),
(48, 'dab179b1a53c07c773e42fbed8011969', '', '1500', '0', '87884', NULL),
(49, 'dab179b1a53c07c773e42fbed8011969', '', '1500', '0', '50738', NULL),
(50, 'dab179b1a53c07c773e42fbed8011969', '', '2500', 'درحال پرداخت', '15653', 'A00000000000000000000000000210618033'),
(51, 'c23c486a9494b6628ffea868afe1062a', '', '500', 'درحال پرداخت', '11587', 'A00000000000000000000000000210622706'),
(52, 'dab179b1a53c07c773e42fbed8011969', '', '1000', '0', '92136', NULL),
(53, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '96444', NULL),
(54, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '74312', NULL),
(55, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '49855', NULL),
(56, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '24544', NULL),
(57, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '80708', NULL),
(58, 'e4a0ecde9947a6b6de8b03c738fb1861', '', '500', '0', '26391', NULL),
(59, 'e4a0ecde9947a6b6de8b03c738fb1861', '2', '500', '0', '67205', NULL),
(60, 'e4a0ecde9947a6b6de8b03c738fb1861', '2', '500', '0', '80833', NULL),
(61, 'e4a0ecde9947a6b6de8b03c738fb1861', '2', '500', '0', '71329', 'A00000000000000000000000000211132266'),
(62, 'e4a0ecde9947a6b6de8b03c738fb1861', '2', '500', '0', '54095', NULL),
(63, '', '', '0', '0', '12712', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `id` int(11) NOT NULL,
  `username` varchar(280) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `password` varchar(280) CHARACTER SET utf8 COLLATE utf8_persian_ci NOT NULL,
  `token` varchar(280) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `username`, `password`, `token`) VALUES
(1, 'ag', 'fawVX6eorNlkg', 'e4a0ecde9947a6b6de8b03c738fb1861'),
(2, 'alisamadzadeh', 'faw9cvr6Zud0c', 'afdf6123d6634cba1c378e8a1179a0c3'),
(3, 'pouyahidden', 'fasItF7h87lVg', 'dab179b1a53c07c773e42fbed8011969'),
(4, 'سعید محمدی ', 'fasHnnyDR0bC2', 'c23c486a9494b6628ffea868afe1062a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Cart`
--
ALTER TABLE `Cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Pay`
--
ALTER TABLE `Pay`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Post`
--
ALTER TABLE `Post`
  ADD PRIMARY KEY (`idpost`);

--
-- Indexes for table `Slider`
--
ALTER TABLE `Slider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Cart`
--
ALTER TABLE `Cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `Post`
--
ALTER TABLE `Post`
  MODIFY `idpost` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Slider`
--
ALTER TABLE `Slider`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
