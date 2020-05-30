-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2020 at 07:36 AM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pandu`
--

-- --------------------------------------------------------

--
-- Table structure for table `_cicilan`
--

CREATE TABLE `_cicilan` (
  `id_cicilan` int(11) NOT NULL,
  `cicilan_tgl` date NOT NULL,
  `cicilan_nominal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_cicilan`
--

INSERT INTO `_cicilan` (`id_cicilan`, `cicilan_tgl`, `cicilan_nominal`) VALUES
(1, '2020-05-29', '9000000');

-- --------------------------------------------------------

--
-- Table structure for table `_jenisbangun`
--

CREATE TABLE `_jenisbangun` (
  `id_jenisbangun` int(11) NOT NULL,
  `jenisbangun_nama` varchar(150) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_jenisbangun`
--

INSERT INTO `_jenisbangun` (`id_jenisbangun`, `jenisbangun_nama`) VALUES
(1, '5IjvpK4SqcrHd+mIE8jttpiJ7NCClQVWxRrQgEs7Mo7KZL5qBbLL7m0hS15NLALAyRE2aBv6WVwg+a1ecxwsuQ==');

-- --------------------------------------------------------

--
-- Table structure for table `_lokasi`
--

CREATE TABLE `_lokasi` (
  `id_lokasi` int(11) NOT NULL,
  `lokasi_namalokasi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_lokasi`
--

INSERT INTO `_lokasi` (`id_lokasi`, `lokasi_namalokasi`) VALUES
(1, 'O5GGH9750QMMRYVN8fiFxaO8tHwV4omkf3nwrAuRLNLRzDMSfzhkR2ElUKdSV2LjCCM3CBGn1qZSfNzACktEhacYBPI6XFNQmKZEhwmWYbg=');

-- --------------------------------------------------------

--
-- Table structure for table `_pelanggan`
--

CREATE TABLE `_pelanggan` (
  `id_pelanggan` int(100) NOT NULL,
  `pelanggan_nama` varchar(255) NOT NULL,
  `pelanggan_alamat` varchar(255) NOT NULL,
  `pelanggan_nohp` varchar(255) NOT NULL,
  `pelanggan_email` varchar(200) NOT NULL,
  `pelanggan_pekerjaan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_pelanggan`
--

INSERT INTO `_pelanggan` (`id_pelanggan`, `pelanggan_nama`, `pelanggan_alamat`, `pelanggan_nohp`, `pelanggan_email`, `pelanggan_pekerjaan`) VALUES
(3, 'nhn2zsNKKPnFqL+q8HRxu43SHmT7kk2+XAJ2qznfc5Q=', 'bpBO+0Zfc4EPlK1ZXVAnrI8HAMN77OmUhPJhNgge5NmhTfn4FJtLXhBfSTgJYIBM/YUgQlWk7fvtXiMhKox5KP2cOO99LzawXVXTeKV7A/4Mc+Y/aVbRDuTGc2sP3qKpIAs0Dm76ylv9GhSVkz9Uog==', '7KXkNRm05ep2yjHrS8sgvQ==', 'SEhG7Aqwyas70xdn5IzIczsvJWBxJfGQKXPhikmxXhY=', 'SY4PdVWZlDXJWtBwfqc7sA==');

-- --------------------------------------------------------

--
-- Table structure for table `_tender`
--

CREATE TABLE `_tender` (
  `id_tender` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `id_jenisbangun` int(11) NOT NULL,
  `id_cicilan` int(11) NOT NULL,
  `tender_tanggaltender` date NOT NULL,
  `tender_namatender` varchar(50) NOT NULL,
  `tender_nilaikontrak` varchar(50) NOT NULL,
  `tender_nilaidp` varchar(50) NOT NULL,
  `tender_alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_tender`
--

INSERT INTO `_tender` (`id_tender`, `id_pelanggan`, `id_jenisbangun`, `id_cicilan`, `tender_tanggaltender`, `tender_namatender`, `tender_nilaikontrak`, `tender_nilaidp`, `tender_alamat`) VALUES
(1, 3, 1, 1, '2020-05-29', 'fddfjfdj', '789000', '656565', 'gjfgjfjfgjgfj');

-- --------------------------------------------------------

--
-- Table structure for table `_user`
--

CREATE TABLE `_user` (
  `id_user` int(11) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_status` varchar(50) NOT NULL,
  `user_tglbuat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_user`
--

INSERT INTO `_user` (`id_user`, `user_username`, `user_password`, `user_status`, `user_tglbuat`) VALUES
(1, 'bogi', '123', 'Aktif', '2020-05-18 14:30:20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `_cicilan`
--
ALTER TABLE `_cicilan`
  ADD PRIMARY KEY (`id_cicilan`);

--
-- Indexes for table `_jenisbangun`
--
ALTER TABLE `_jenisbangun`
  ADD PRIMARY KEY (`id_jenisbangun`);

--
-- Indexes for table `_lokasi`
--
ALTER TABLE `_lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indexes for table `_pelanggan`
--
ALTER TABLE `_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `_tender`
--
ALTER TABLE `_tender`
  ADD PRIMARY KEY (`id_tender`,`id_pelanggan`,`id_jenisbangun`,`id_cicilan`),
  ADD KEY `fk__tender__pelanggan_idx` (`id_pelanggan`),
  ADD KEY `fk__tender__jenisbangun1_idx` (`id_jenisbangun`),
  ADD KEY `fk__tender__cicilan1_idx` (`id_cicilan`);

--
-- Indexes for table `_user`
--
ALTER TABLE `_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `_cicilan`
--
ALTER TABLE `_cicilan`
  MODIFY `id_cicilan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `_jenisbangun`
--
ALTER TABLE `_jenisbangun`
  MODIFY `id_jenisbangun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `_lokasi`
--
ALTER TABLE `_lokasi`
  MODIFY `id_lokasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `_pelanggan`
--
ALTER TABLE `_pelanggan`
  MODIFY `id_pelanggan` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `_tender`
--
ALTER TABLE `_tender`
  MODIFY `id_tender` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `_user`
--
ALTER TABLE `_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `_tender`
--
ALTER TABLE `_tender`
  ADD CONSTRAINT `fk__tender__cicilan` FOREIGN KEY (`id_cicilan`) REFERENCES `_cicilan` (`id_cicilan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__tender__jenisbangun` FOREIGN KEY (`id_jenisbangun`) REFERENCES `_jenisbangun` (`id_jenisbangun`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__tender__pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `_pelanggan` (`id_pelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
