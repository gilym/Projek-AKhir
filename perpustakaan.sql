-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jun 2022 pada 09.29
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `NIM` varchar(20) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Jenis_Kelamin` varchar(20) NOT NULL,
  `Jurusan` varchar(50) NOT NULL,
  `Umur` int(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `No_HP` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`NIM`, `Nama`, `Jenis_Kelamin`, `Jurusan`, `Umur`, `Email`, `No_HP`) VALUES
('123200002', 'Viery chan', 'Laki-Laki', 'Sistem Informasi', 20, 'vierychan@gmail.com', '081245796344'),
('123200004', 'Jerome Polin', 'Laki-Laki', 'Teknik Kimia', 21, 'JeromePolin@email.com', '082147896532'),
('123200006', 'Ukhti Nurul', 'Perempuan', 'D3 Teknik Kimia', 21, 'UkhtiNurull@emiail.com', '081266774458'),
('1232000100', 'Viery', 'Perempuan', 'Informatika', 19, 'viery@gmail.com', '081245796322'),
('1232000123', 'baba', 'Laki-Laki', 'Sistem Informasi', 25, 'baba@email.com', '081240559988'),
('123200039', 'Susi Susanti', 'Perempuan', 'D3 Teknik Kimia', 17, 'SusiSusanti@email.com', '082346791855'),
('123200045', 'Hartanta Dwi Putra Sembiring', 'Laki-Laki', 'Informatika', 19, 'hartanta@email.com', '081255647895'),
('123200056', 'Gilang Yoenal Marinta', 'Laki-Laki', 'Informatika', 19, 'gilang@gmail.com', '081240402365'),
('123200077', 'Azka Hartami', 'Laki-Laki', 'Teknik Kimia', 20, 'Azka@email.com', '081236678965'),
('123200099', 'Abdul artami', 'Laki-Laki', 'Informatika', 12, 'abdul@emiail.com', '0812667744584');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `Id_Buku` varchar(50) NOT NULL,
  `Judul` varchar(50) NOT NULL,
  `Pengarang` varchar(50) NOT NULL,
  `Tahun` int(11) NOT NULL,
  `Jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`Id_Buku`, `Judul`, `Pengarang`, `Tahun`, `Jumlah`) VALUES
('A1', 'Kamu dan ', 'Hartanta Sembiring', 2012, 44),
('A10', 'Fakta dan Opini', 'Sugeng', 2004, 56),
('A11', 'Gajah dan Sepatu', 'Tulus', 2012, 70),
('A12', 'Hari Minggu Greja', 'Agung', 2014, 23),
('A13', 'Indahnya Gunung Simeru', 'Jono', 1999, 14),
('A14', 'Janda Yang Manis', 'Raja Chan', 2018, 45),
('A15', 'Kukang dan Naga', 'Raditya', 2017, 104),
('A16', 'Laskar Pelangi', 'Judika', 2006, 11),
('A17', 'Mewarnai Kepala', 'Acong', 2005, 29),
('A18', 'Naga dan Hayalan', 'Azaka ', 2007, 99),
('A19', 'Opini Membangkitkan Jiwa Juang', 'Nalwa', 2001, 20),
('A2', 'JavaNET', 'Alfath Hudal', 2022, 8),
('A20', 'Penulis Yang Handal', 'Dedi Korbuzer', 2011, 50),
('A21', 'Tutorial Main Mobel legen', 'Rifki Kun', 2020, 54),
('A22', 'Variabel XYZ ', 'Matkun', 2019, 66),
('A3', 'Nihonggo Mantappu', 'Jerome Polin', 2021, 19),
('A30', 'Pemrograman Basis Data', 'Rinaldi Munir', 2022, 6),
('A4', 'C++', 'WIbowo', 2002, 30),
('A6', 'Menghitung Bambu', 'Alfath Hudal', 2020, 26),
('A7', 'ABCD', 'WIsnu Hasyim', 2000, 213),
('B1', 'Laskar cinta', 'Gilang marinta', 2022, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `No_Pinjam` int(11) NOT NULL,
  `NIM` varchar(50) NOT NULL,
  `Id_Buku` varchar(50) NOT NULL,
  `Tanggal_Pinjam` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`No_Pinjam`, `NIM`, `Id_Buku`, `Tanggal_Pinjam`) VALUES
(1, '123200045', 'A3', '2022-05-02'),
(2, '123200045', 'A1', '2022-05-05'),
(9, '123200077', 'A20', '2022-03-08'),
(10, '123200039', 'A30', '2022-05-24'),
(23, '123200056', 'A1', '2022-06-01'),
(24, '123200045', 'A3', '2022-05-02');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`Id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'user', 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`NIM`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`Id_Buku`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`No_Pinjam`),
  ADD KEY `Id_Buku` (`Id_Buku`),
  ADD KEY `Id_Anggota` (`NIM`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `No_Pinjam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `Id_Anggota` FOREIGN KEY (`NIM`) REFERENCES `anggota` (`NIM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Id_Buku` FOREIGN KEY (`Id_Buku`) REFERENCES `buku` (`Id_Buku`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
