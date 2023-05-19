-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 19, 2021 lúc 05:19 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlycuahangaokhoac`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MAHD` varchar(50) NOT NULL,
  `MASP` varchar(50) NOT NULL,
  `DONGIA` varchar(50) NOT NULL,
  `SOLUONG` double NOT NULL,
  `GIAMGIA` double NOT NULL,
  `THANHTIEN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MAHD`, `MASP`, `DONGIA`, `SOLUONG`, `GIAMGIA`, `THANHTIEN`) VALUES
('hd023', 'sp05', '350000', 2, 175000, 350000),
('hd023', 'sp02', '800000', 5, 0, 4000000),
('hd12', 'sp04', '900000', 10, 0, 9000000),
('hd12', 'sp05', '350000', 10, 178500, 1715000),
('hd01', 'sp06', '450000', 1, 0, 450000),
('hd022', 'sp07', '400000', 1, 0, 400000),
('hd021', 'sp08', '300000', 1, 0, 300000),
('hd09', 'sp08', '300000', 1, 0, 300000),
('hd10', 'sp08', '300000', 3, 0, 900000),
('hd07', 'sp08', '300000', 1, 0, 300000),
('hd099', 'sp03', '150000', 1, 0, 150000),
('hd099', 'sp05', '350000', 1, 178500, 171500),
('hd11', 'sp05', '350000', 1, 178500, 171500);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhaphang`
--

CREATE TABLE `chitietphieunhaphang` (
  `MAPNH` varchar(50) NOT NULL,
  `MASP` varchar(50) NOT NULL,
  `DONGIA` varchar(50) NOT NULL,
  `SOLUONG` varchar(50) NOT NULL,
  `THANHTIEN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhaphang`
--

INSERT INTO `chitietphieunhaphang` (`MAPNH`, `MASP`, `DONGIA`, `SOLUONG`, `THANHTIEN`) VALUES
('pn01', 'sp08', '1000', '10', '10000.0'),
('pn01', 'sp01', '1000', '10000', '1.0E7'),
('pn02', 'sp02', '10000', '20', '200000.0'),
('pn02', 'sp01', '10', '100', '1000.0'),
('pn03', 'sp02', '10000', '200', '2000000.0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giamgia`
--

CREATE TABLE `giamgia` (
  `MASP` varchar(50) NOT NULL,
  `MAGG` varchar(50) NOT NULL,
  `PHANTRAM` varchar(50) NOT NULL,
  `NGBD` varchar(50) NOT NULL,
  `NGKT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `giamgia`
--

INSERT INTO `giamgia` (`MASP`, `MAGG`, `PHANTRAM`, `NGBD`, `NGKT`) VALUES
('sp05', 'aa', '30', '2018-11-02', '2019-10-11'),
('sp02', 'aa', '30', '2018-11-02', '2019-10-11'),
('sp08', 'ab', '25', '2000-12-03', '2000-12-13'),
('sp09', 'aa', '30', '2018-11-02', '2019-10-11'),
('sp01', 'a', '30', '2018-11-02', '2018-11-02');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` varchar(50) NOT NULL,
  `MAKH` varchar(50) NOT NULL,
  `MANV` varchar(50) NOT NULL,
  `NGAYGD` date NOT NULL,
  `TONGTIEN` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MAHD`, `MAKH`, `MANV`, `NGAYGD`, `TONGTIEN`) VALUES
('hd01', 'kh01', 'nv03', '2018-01-03', 450000),
('hd022', 'kh01', 'nv03', '2018-01-03', 400000),
('hd021', 'kh01', 'nv04', '2018-01-03', 300000),
('hd09', 'kh01', 'nv03', '2017-02-03', 300000),
('hd10', 'kh01', 'nv04', '2016-02-03', 900000),
('hd07', 'kh01', 'nv04', '2018-10-02', 300000),
('hd099', 'kh01', 'nv04', '2018-10-03', 321500),
('hd11', 'kh04', 'nv04', '2016-02-03', 171500);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` varchar(50) NOT NULL,
  `TENKH` varchar(50) NOT NULL,
  `DIACHI` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `TENKH`, `DIACHI`, `SDT`) VALUES
('kh03', 'Duy ', 'SG', '0381124242'),
('kh10', 'Cao Nam', 'SG', '0385579327'),
('kh04', 'Trần Duy ', 'SG', '0371779324'),
('kh01', 'Sonhhhhquujjjuuuj', 'HN', '0389939111');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MALOAI` varchar(50) NOT NULL,
  `TENLOAI` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MALOAI`, `TENLOAI`) VALUES
('sp01', 'aaa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ncc`
--

CREATE TABLE `ncc` (
  `MANCC` varchar(50) NOT NULL,
  `TENNCC` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `ncc`
--

INSERT INTO `ncc` (`MANCC`, `TENNCC`) VALUES
('ncc01', 'Dung Quất'),
('ncc03', 'TMA'),
('ncc02', 'Dung Quất 2'),
('ncc04', 'AROMA');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` varchar(50) NOT NULL,
  `TENNV` varchar(50) NOT NULL,
  `GIOITINH` varchar(50) NOT NULL,
  `CHUCVU` varchar(50) NOT NULL,
  `LUONG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `GIOITINH`, `CHUCVU`, `LUONG`) VALUES
('nv03', 'Trần Hạo Hải', 'nam', 'Quản lí', '10000000'),
('nv04', 'Trần Hạo Nam', 'nam', 'Quản lí', '10000000'),
('nv01', 'Nguyễn Bá', 'nam', 'Nhân Viên', '5000000'),
('nv02', 'Nguyễn Công', 'nam', 'Nhân Viên', '5000000'),
('nv07', 'Trần Hạo Hải', 'nam', 'Giám đôc', '20000000'),
('nv05', 'Nguyến Thị Hoa', 'nữ', 'Quản lí', '10000000');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MAPNH` varchar(50) NOT NULL,
  `MANCC` varchar(50) NOT NULL,
  `MANV` varchar(50) NOT NULL,
  `NGAYNHAP` date NOT NULL,
  `TONGTIEN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`MAPNH`, `MANCC`, `MANV`, `NGAYNHAP`, `TONGTIEN`) VALUES
('pn02', 'ncc01', 'nv03', '2000-02-16', '201000.0'),
('pn03', 'ncc02', 'nv01', '2000-02-16', '2000000.0'),
('pn01', 'ncc01', 'nv03', '2018-12-13', '1.001E7');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` varchar(50) NOT NULL,
  `TENSP` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `NGAYSX` date NOT NULL,
  `SOLUONG` varchar(50) NOT NULL,
  `DONGIA` varchar(50) NOT NULL,
  `MALOAI` varchar(50) NOT NULL,
  `HINHANH` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `NGAYSX`, `SOLUONG`, `DONGIA`, `MALOAI`, `HINHANH`) VALUES
('sp01', 'Áo khoác jean ZZz', '2000-03-03', '100', '200000', 'jean1', 'null'),
('sp02', 'Áo khoác jean cao bồi hồ đông', '2000-03-03', '297', '80000', 'jean1', 'null'),
('sp03', 'Áo khoác kaki olala', '2000-03-03', '51', '150000', 'kaki1', 'null'),
('sp05', 'Áo khoác da đen', '2000-03-03', '30', '350000', 'da1', 'null'),
('sp06', 'Áo khoác da bạc bb', '2000-03-03', '29', '450000', 'da1', 'null'),
('sp07', 'Áo khoác jean BBQ', '2017-07-03', '99', '400000', 'jean1', 'null'),
('sp08', 'Áo khoác jean KORA', '2017-07-03', '27', '300000', 'jean2', 'null'),
('sp09', 'Áo khoác jean BaBa', '2019-07-03', '26', '300000', 'jean1', 'jean1'),
('sp11', 'Áo khoác OBZ', '2019-07-03', '26', '300000', 'jean1', 'jean1'),
('sp16', 'Áo khoác da bạc nữ', '2000-03-03', '29', '450000', 'da2', 'null'),
('sp20', 'Áo khoác jean Hàn 1', '2001-03-03', '100', '200000', 'jean1', 'null');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MALOAI`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
