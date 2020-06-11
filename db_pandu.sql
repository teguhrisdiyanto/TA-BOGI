-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2020 pada 19.30
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Struktur dari tabel `_cicilan`
--

CREATE TABLE `_cicilan` (
  `id_cicilan` int(11) NOT NULL,
  `cicilan_tgl` varchar(50) NOT NULL DEFAULT 'current_timestamp()',
  `cicilan_nominal` varchar(50) NOT NULL,
  `_tender_id_tender` int(11) NOT NULL,
  `_tender_id_pelanggan` int(11) NOT NULL,
  `_tender_id_jenisbangun` int(11) NOT NULL,
  `_tender__lokasi_id_lokasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_cicilan`
--

INSERT INTO `_cicilan` (`id_cicilan`, `cicilan_tgl`, `cicilan_nominal`, `_tender_id_tender`, `_tender_id_pelanggan`, `_tender_id_jenisbangun`, `_tender__lokasi_id_lokasi`) VALUES
(2, 'AOPmnb+IyWF4WwSodMUigw==', '64s0SdnMzysFsq8z/W9x8A==', 2, 2, 1, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `_jenisbangun`
--

CREATE TABLE `_jenisbangun` (
  `id_jenisbangun` int(11) NOT NULL,
  `jenisbangun_nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_jenisbangun`
--

INSERT INTO `_jenisbangun` (`id_jenisbangun`, `jenisbangun_nama`) VALUES
(1, 'F+vdKjAGMYEGML1F6iH7Jg=='),
(2, '514/J2cWNqmnwP2++N3suw==');

-- --------------------------------------------------------

--
-- Struktur dari tabel `_lokasi`
--

CREATE TABLE `_lokasi` (
  `id_lokasi` int(11) NOT NULL,
  `lokasi_namalokasi` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_lokasi`
--

INSERT INTO `_lokasi` (`id_lokasi`, `lokasi_namalokasi`) VALUES
(1, 'HG2QnlrgHL8NNMd2OnTjNQ=='),
(2, 'w0bk9ogCNTDlf6cdv8Wq9Q=='),
(3, 'y2oPgSf2si92NIZuMmJvnFcPTFPpKkAMZxIUqZdkxj0=');

-- --------------------------------------------------------

--
-- Struktur dari tabel `_pelanggan`
--

CREATE TABLE `_pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `pelanggan_nama` varchar(50) NOT NULL,
  `pelanggan_alamat` varchar(50) NOT NULL,
  `pelanggan_nohp` varchar(50) NOT NULL,
  `pelanggan_email` varchar(50) NOT NULL,
  `pelanggan_pekerjaan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_pelanggan`
--

INSERT INTO `_pelanggan` (`id_pelanggan`, `pelanggan_nama`, `pelanggan_alamat`, `pelanggan_nohp`, `pelanggan_email`, `pelanggan_pekerjaan`) VALUES
(2, '88xkb5cfbwjaFpEVW/b3Pw==', '9U3gQahguCITMpPhBl8cTA==', '+GD2TJkIhKubcAAWnzqMXA==', 'SEhG7Aqwyas70xdn5IzIczsvJWBxJfGQKXPhikmxXhY=', 'ico3uKZ+Nibq4ethTZ402A=='),
(3, 'RaMtlExosNGBHdzCVu0mAA==', 'v/WKS7oev/YZ323cVY2aEg==', 'YIBvtGcXYjHJRt6e/UT21A==', 'IUhN/kdgD0LHxm5OIu4dUw==', 'rkJbe7T4G53O6IWbQmP91Q==');

-- --------------------------------------------------------

--
-- Struktur dari tabel `_tender`
--

CREATE TABLE `_tender` (
  `id_tender` int(11) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `id_jenisbangun` int(11) NOT NULL,
  `_lokasi_id_lokasi` int(11) NOT NULL,
  `tender_tanggaltender` varchar(50) NOT NULL DEFAULT 'current_timestamp()',
  `tender_namatender` varchar(50) NOT NULL,
  `tender_nilaikontrak` varchar(50) NOT NULL,
  `tender_nilaidp` varchar(50) NOT NULL,
  `sisabayar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_tender`
--

INSERT INTO `_tender` (`id_tender`, `id_pelanggan`, `id_jenisbangun`, `_lokasi_id_lokasi`, `tender_tanggaltender`, `tender_namatender`, `tender_nilaikontrak`, `tender_nilaidp`, `sisabayar`) VALUES
(1, 3, 2, 3, 'jbsHaK0+VoaA8AnSYL3+Dw==', '65IxCrJUKiFpxP9841mksw==', '0yGmybzxYryJXDkzJ2V7Ng==', 'KGqcX6zA6DkmpbTHQeZEZw==', 'YBC/2qSQFobBOoSNvjr+pw=='),
(2, 2, 1, 1, 'CTXBEG3qVnFf1IxUau5JtA==', 'iTaLAwxzd+0sXUDGk2C3Tqrree2fUZ4AxorBaCXWeDg=', 'L+/PhHJCl5kViB8pjWL17g==', 'uGcl5wKwVrm9uYkQbtiitw==', 'C+sJnYDTaDgYYvbK5vYHmg==');

-- --------------------------------------------------------

--
-- Struktur dari tabel `_user`
--

CREATE TABLE `_user` (
  `id_user` int(11) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_status` varchar(50) NOT NULL,
  `user_tglbuat` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `_user`
--

INSERT INTO `_user` (`id_user`, `user_username`, `user_password`, `user_status`, `user_tglbuat`) VALUES
(1, 'bogi', '123', 'aktif', '2020-06-02 12:33:18');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `_cicilan`
--
ALTER TABLE `_cicilan`
  ADD PRIMARY KEY (`id_cicilan`,`_tender_id_tender`,`_tender_id_pelanggan`,`_tender_id_jenisbangun`,`_tender__lokasi_id_lokasi`),
  ADD KEY `fk__cicilan__tender1_idx` (`_tender_id_tender`,`_tender_id_pelanggan`,`_tender_id_jenisbangun`,`_tender__lokasi_id_lokasi`);

--
-- Indeks untuk tabel `_jenisbangun`
--
ALTER TABLE `_jenisbangun`
  ADD PRIMARY KEY (`id_jenisbangun`);

--
-- Indeks untuk tabel `_lokasi`
--
ALTER TABLE `_lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indeks untuk tabel `_pelanggan`
--
ALTER TABLE `_pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `_tender`
--
ALTER TABLE `_tender`
  ADD PRIMARY KEY (`id_tender`,`id_pelanggan`,`id_jenisbangun`,`_lokasi_id_lokasi`),
  ADD KEY `fk__tender__pelanggan_idx` (`id_pelanggan`),
  ADD KEY `fk__tender__jenisbangun1_idx` (`id_jenisbangun`),
  ADD KEY `fk__tender__lokasi1_idx` (`_lokasi_id_lokasi`);

--
-- Indeks untuk tabel `_user`
--
ALTER TABLE `_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `_cicilan`
--
ALTER TABLE `_cicilan`
  MODIFY `id_cicilan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `_jenisbangun`
--
ALTER TABLE `_jenisbangun`
  MODIFY `id_jenisbangun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `_lokasi`
--
ALTER TABLE `_lokasi`
  MODIFY `id_lokasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `_pelanggan`
--
ALTER TABLE `_pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT untuk tabel `_tender`
--
ALTER TABLE `_tender`
  MODIFY `id_tender` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `_user`
--
ALTER TABLE `_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `_cicilan`
--
ALTER TABLE `_cicilan`
  ADD CONSTRAINT `fk__cicilan__tender1` FOREIGN KEY (`_tender_id_tender`,`_tender_id_pelanggan`,`_tender_id_jenisbangun`,`_tender__lokasi_id_lokasi`) REFERENCES `_tender` (`id_tender`, `id_pelanggan`, `id_jenisbangun`, `_lokasi_id_lokasi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ketidakleluasaan untuk tabel `_tender`
--
ALTER TABLE `_tender`
  ADD CONSTRAINT `fk__tender__jenisbangun` FOREIGN KEY (`id_jenisbangun`) REFERENCES `_jenisbangun` (`id_jenisbangun`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__tender__lokasi1` FOREIGN KEY (`_lokasi_id_lokasi`) REFERENCES `_lokasi` (`id_lokasi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk__tender__pelanggan` FOREIGN KEY (`id_pelanggan`) REFERENCES `_pelanggan` (`id_pelanggan`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
