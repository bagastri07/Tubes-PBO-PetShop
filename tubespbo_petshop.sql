-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jan 2022 pada 13.15
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo_petshop`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `hewan_peliharaan`
--

CREATE TABLE `hewan_peliharaan` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jenis_kelamin` enum('Jantan','Betina') NOT NULL,
  `usia` int(11) NOT NULL,
  `jenis_hewan` enum('Anjing','Kucing') NOT NULL,
  `id_pelanggan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `hewan_peliharaan`
--

INSERT INTO `hewan_peliharaan` (`id`, `nama`, `jenis_kelamin`, `usia`, `jenis_hewan`, `id_pelanggan`) VALUES
(2, 'Bruno', 'Jantan', 13, 'Kucing', 4),
(4, 'Lufi', 'Betina', 23, 'Kucing', 23),
(6, 'Akaya', 'Betina', 12, 'Kucing', 4),
(8, 'Kuku', 'Betina', 12, 'Anjing', 20),
(10, 'Miko', 'Betina', 3, 'Kucing', 23),
(11, 'Lucy', 'Jantan', 3, 'Kucing', 6),
(12, 'Lusa', 'Betina', 4, 'Anjing', 6),
(13, 'Emon', 'Betina', 6, 'Kucing', 5),
(14, 'Alana Khoir', 'Betina', 12, 'Kucing', 6),
(15, 'Romeo', 'Betina', 7, 'Anjing', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `invoice`
--

CREATE TABLE `invoice` (
  `no_invoice` varchar(100) NOT NULL,
  `id_pelanggan` int(11) NOT NULL,
  `id_hewan` int(11) NOT NULL,
  `jenis_layanan` varchar(255) NOT NULL,
  `metode_pembayaran` enum('Gopay','Tunai') NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `biaya_layanan` float NOT NULL,
  `diskon` float NOT NULL,
  `total_biaya` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `invoice`
--

INSERT INTO `invoice` (`no_invoice`, `id_pelanggan`, `id_hewan`, `jenis_layanan`, `metode_pembayaran`, `tanggal_transaksi`, `biaya_layanan`, `diskon`, `total_biaya`) VALUES
('INV-GR01-04.01.2022-003100', 5, 13, 'Grooming-Memandikan Hewan', 'Gopay', '2022-01-04', 50000, 5000, 45000),
('INV-GR01-04.01.2022-125118', 6, 12, 'Grooming-Memandikan Hewan', 'Gopay', '2022-01-04', 65000, 6500, 58500),
('INV-GR02-04.01.2022-002731', 4, 2, 'Grooming-Membersihkan Kutu', 'Gopay', '2022-01-04', 70000, 7000, 63000),
('INV-GR02-04.01.2022-003130', 5, 13, 'Grooming-Membersihkan Kutu', 'Tunai', '2022-01-04', 70000, 0, 70000),
('INV-GR02-04.01.2022-124323', 6, 14, 'Grooming-Membersihkan Kutu', 'Gopay', '2022-01-04', 70000, 7000, 63000),
('INV-GR02-04.01.2022-221808', 4, 15, 'Grooming-Membersihkan Kutu', 'Tunai', '2022-01-04', 85000, 0, 85000),
('INV-GR03-04.01.2022-002855', 20, 8, 'Grooming-Memotong Kuku', 'Gopay', '2022-01-04', 45000, 4500, 40500),
('INV-GR03-04.01.2022-004916', 4, 2, 'Grooming-Memotong Kuku', 'Gopay', '2022-01-04', 30000, 3000, 27000),
('INV-GR03-04.01.2022-131651', 4, 15, 'Grooming-Memotong Kuku', 'Gopay', '2022-01-04', 45000, 4500, 40500),
('INV-PH-06.01.2022-191310', 4, 6, 'Penitipan-4 Hari', 'Gopay', '2022-01-06', 100000, 10000, 90000),
('INV-PH-06.01.2022-191335', 20, 8, 'Penitipan-3 Hari', 'Tunai', '2022-01-06', 90000, 0, 90000),
('INV-PH-06.01.2022-191353', 23, 4, 'Penitipan-4 Hari', 'Gopay', '2022-01-06', 100000, 10000, 90000),
('INV-PH-06.01.2022-191417', 23, 10, 'Penitipan-5 Hari', 'Gopay', '2022-01-06', 125000, 12500, 112500);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nomorTelepon` varchar(14) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `nama`, `nomorTelepon`, `alamat`) VALUES
(4, 'Perwira Hanif Zakaria', '0852526672', 'Jl. Kemerdekaan Kita Semua'),
(5, 'Bagas Tri Wibowo', '0853466777', 'Jl. Lupa'),
(6, 'Maulana Farrel', '08222222', 'Jl. Kebahagian Bersama, Kabupaten Kotawaringin Selatan, Jakarta Utara, Norwegia'),
(20, 'Maulana Fizkri', '0923134', 'Jl. 4 0'),
(23, 'Layli Rahmah Su', '08214545445', 'Jl. Yogya'),
(25, 'Serly', '09323785437', 'Jl. Surabaya'),
(26, 'Dafa', '90982452345', 'Jl. Bandung');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `hewan_peliharaan`
--
ALTER TABLE `hewan_peliharaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Indeks untuk tabel `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`no_invoice`),
  ADD KEY `invoice_ibfk_3` (`id_pelanggan`),
  ADD KEY `FK_id_hewan` (`id_hewan`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `hewan_peliharaan`
--
ALTER TABLE `hewan_peliharaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `hewan_peliharaan`
--
ALTER TABLE `hewan_peliharaan`
  ADD CONSTRAINT `hewan_peliharaan_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `FK_id_hewan` FOREIGN KEY (`id_hewan`) REFERENCES `hewan_peliharaan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
