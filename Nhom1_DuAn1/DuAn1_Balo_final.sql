Create Database DuAn1_Balo_final
USE [DuAn1_Balo_final]
GO
DROP DATABASE DuAn1_Balo_final;

/****** Object:  Table [dbo].[ChatLieu]    Script Date: 25-Nov-23 10:10:03 AM ******/
select * from Hang
select * from HoaDonChiTiet
select * from HoaDon
select * from KhachHang
select * from Voucher
select * from ChucVu
select * from ChatLieu
select * from SoNgan
select * from Hang
select * from SanPham
select * from MauSac
select * from NhanVien
select * from SanPhamChiTiet
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaChatLieu] [nvarchar](50) NULL,
	[TenChatLieu] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_ChatLieu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaCV] [nvarchar](50) NULL,
	[TenCV] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hang]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHang] [nvarchar](50) NULL,
	[TenHang] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_Hang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDHoaDon] [int] NULL,
	[IDThanhToan] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_HinhThucThanhToan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [nvarchar](50) NULL,
	[IDKhangHang] [int] NULL,
	[IDNhanVien] [int] NULL,
	[IDVoucher] [int] NULL,
	[TenNguoiNhan] [nvarchar](50) NULL,
	[SdtNguoiNhan] [nvarchar](50) NULL,
	[DiaChiNguoiNhan] [nvarchar](50) NULL,
	[PhiShip] [decimal](10, 0) NULL,
	[TongTien] [decimal](18, 0) NULL,
	[TienMat] [decimal](18, 0) NULL,
	[TienChuyenKhoan] [dDecimal](18, 0) NULL,
	[MaChuyenKhoan] [nvarchar](50) NULL,
	[HinhThuc] [nvarchar](50) NULL,
	[TrangThai] [int] NULL,
	[NgayThanhToan] [date] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
	[trangthaicbb] [int] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDonChiTiet] [nvarchar](50) NULL,
	[IDHoaDon] [int] NULL,
	[IDSanPhamChiTiet] [int] NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [decimal](18, 0) NULL,
	[ThanhTien] [decimal](18, 0) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKH] [nvarchar](50) NULL,
	[TenKH] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[GioiTinh] [int] NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhoaKeo]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhoaKeo](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaKhoaKeo] [nvarchar](50) NULL,
	[TenKhoaKeo] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_KhoaKeo] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuHoaDon]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuHoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDHoaDon] [int] NULL,
	[TrangThai] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_LichSuHoaDon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaMau] [nvarchar](50) NULL,
	[TenMau] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nvarchar](50) NULL,
	[TenNV] [nvarchar](50) NULL,
	[IDChucVu] [int] NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[CCCD] [nvarchar](50) NULL,
	[GioiTinh] [int] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NSX]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NSX](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaNSX] [nvarchar](50) NULL,
	[TenNSX] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_NSX] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuaiDeo]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuaiDeo](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaQuaiDeo] [nvarchar](50) NULL,
	[TenQuaiDeo] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_QuaiDeo] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSP] [nvarchar](50) NULL,
	[TenSP] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSPCT] [nvarchar](50) NULL,
	[IDSanPham] [int] NULL,
	[IDHang] [int] NULL,
	[IDMauSac] [int] NULL,
	[IDChatLieu] [int] NULL,
	[IDSize] [int] NULL,
	[IDNSX] [int] NULL,
	[IDKhoaKeo] [int] NULL,
	[IDQuaiDeo] [int] NULL,
	[IDSoNgan] [int] NULL,
	[SoLuong] [int] NULL,
	[MoTa] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
	[Gia] [decimal](10, 2) NULL,
	[TinhTrang] [nvarchar](255) NULL,
 CONSTRAINT [PK_SanPhamChiTiet] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSize] [nvarchar](50) NULL,
	[TenSize] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_Size] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SoNgan]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SoNgan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaSoNgan] [nvarchar](50) NULL,
	[TenSoNgan] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_SoNgan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaHTTT] [nvarchar](50) NULL,
	[TenHTTT] [nvarchar](50) NULL,
	[MoTa] [nvarchar](50) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_ThanhToan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Voucher]    Script Date: 25-Nov-23 10:10:03 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Voucher](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MaVoucher] [nvarchar](50) NULL,
	[TenVoucher] [nvarchar](50) NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[PhanTramGiam] [decimal](18, 0) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[NguoiTao] [int] NULL,
	[NguoiSua] [int] NULL,
	[xoa] [int] NULL,
 CONSTRAINT [PK_Voucher] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 

INSERT [dbo].[ChatLieu] ([ID], [MaChatLieu], [TenChatLieu], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'CL01', N'Polyester', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[ChatLieu] ([ID], [MaChatLieu], [TenChatLieu], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'CL02', N'Cotton', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[ChatLieu] ([ID], [MaChatLieu], [TenChatLieu], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'CL03', N'Da', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([ID], [MaCV], [TenCV], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'CV01', N'Nhân Viên', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[ChucVu] ([ID], [MaCV], [TenCV], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'CV02', N'Quản Lý', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
SET IDENTITY_INSERT [dbo].[Hang] ON 

INSERT [dbo].[Hang] ([ID], [MaHang], [TenHang], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'HA01', N'ADIDAS', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[Hang] ([ID], [MaHang], [TenHang], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'HA02', N'PUMA', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[Hang] ([ID], [MaHang], [TenHang], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'HA03', N'NIKE', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[Hang] ([ID], [MaHang], [TenHang], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (5, N'HA04', N'MLB', CAST(N'2023-11-23' AS Date), CAST(N'2023-11-23' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Hang] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([ID], [MaHoaDon], [IDKhangHang], [IDNhanVien], [IDVoucher], [TenNguoiNhan], [SdtNguoiNhan], [DiaChiNguoiNhan], [PhiShip], [TongTien], [TrangThai], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [trangthaicbb]) VALUES (1, N'HD01', 1, 1, 1, N'Trang', N'021435', N'càu diễn', CAST(25000 AS Decimal(10, 0)), CAST(725000 AS Decimal(18, 0)), 1, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, 1)
INSERT [dbo].[HoaDon] ([ID], [MaHoaDon], [IDKhangHang], [IDNhanVien], [IDVoucher], [TenNguoiNhan], [SdtNguoiNhan], [DiaChiNguoiNhan], [PhiShip], [TongTien], [TrangThai], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [trangthaicbb]) VALUES (2, N'HD02', 2, 1, 1, N'Kiên', NULL, N'Kieu Mai', NULL, CAST(2900000 AS Decimal(18, 0)), 0, CAST(N'2023-11-18' AS Date), CAST(N'2023-11-18' AS Date), NULL, NULL, NULL, 2)
INSERT [dbo].[HoaDon] ([ID], [MaHoaDon], [IDKhangHang], [IDNhanVien], [IDVoucher], [TenNguoiNhan], [SdtNguoiNhan], [DiaChiNguoiNhan], [PhiShip], [TongTien], [TrangThai], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [trangthaicbb]) VALUES (3, N'HD03', 1, 1, 1, N'Hùng', NULL, N'Ho Tung Mau', NULL, CAST(1400000 AS Decimal(18, 0)), 0, CAST(N'2023-11-19' AS Date), CAST(N'2023-11-19' AS Date), NULL, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([ID], [MaHoaDonChiTiet], [IDHoaDon], [IDSanPhamChiTiet], [SoLuong], [GiaTien], [ThanhTien], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'HDCT01', 1, 33, 1, CAST(700000 AS Decimal(18, 0)), CAST(700000 AS Decimal(18, 0)), CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [MaHoaDonChiTiet], [IDHoaDon], [IDSanPhamChiTiet], [SoLuong], [GiaTien], [ThanhTien], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'HDCT02', 2, 32, 1, CAST(900000 AS Decimal(18, 0)), CAST(900000 AS Decimal(18, 0)), CAST(N'2023-11-19' AS Date), CAST(N'2023-11-19' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [MaHoaDonChiTiet], [IDHoaDon], [IDSanPhamChiTiet], [SoLuong], [GiaTien], [ThanhTien], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'HDCT03', 2, 30, 2, CAST(1000000 AS Decimal(18, 0)), CAST(2000000 AS Decimal(18, 0)), CAST(N'2023-11-19' AS Date), CAST(N'2023-11-19' AS Date), NULL, NULL, NULL)
INSERT [dbo].[HoaDonChiTiet] ([ID], [MaHoaDonChiTiet], [IDHoaDon], [IDSanPhamChiTiet], [SoLuong], [GiaTien], [ThanhTien], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (5, N'HDCT04', 3, 31, 2, CAST(700000 AS Decimal(18, 0)), CAST(1400000 AS Decimal(18, 0)), CAST(N'2023-11-19' AS Date), CAST(N'2023-11-19' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([ID], [MaKH], [TenKH], [Email], [DiaChi], [SDT], [GioiTinh], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'Kh01', N'Khách Hùng', N'hungkh@gmail.com', N'Hà Nội', N'0388432827', 1, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[KhachHang] ([ID], [MaKH], [TenKH], [Email], [DiaChi], [SDT], [GioiTinh], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'Kh02', N'Trung Kiên', N'kien@gmail', N'Phú Thọ', N'03812435', 1, CAST(N'2023-11-18' AS Date), CAST(N'2023-11-18' AS Date), NULL, NULL, NULL)
INSERT [dbo].[KhachHang] ([ID], [MaKH], [TenKH], [Email], [DiaChi], [SDT], [GioiTinh], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'Kh03', N'Trần Thị Giang', N'Giangtmu@gmail.com', N'Hà Giang', N'0312456789', 0, CAST(N'2023-11-22' AS Date), CAST(N'2023-11-22' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[KhoaKeo] ON 

INSERT [dbo].[KhoaKeo] ([ID], [MaKhoaKeo], [TenKhoaKeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'kk01', N'Khóa Nhựa', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[KhoaKeo] ([ID], [MaKhoaKeo], [TenKhoaKeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'kk02', N'Khóa Đồng', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[KhoaKeo] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([ID], [MaMau], [TenMau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'MS01', N'Màu Đen', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[MauSac] ([ID], [MaMau], [TenMau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'MS02', N'Màu Xanh', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[MauSac] ([ID], [MaMau], [TenMau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'MS03', N'Màu Trắng', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[MauSac] ([ID], [MaMau], [TenMau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (4, N'MS04', N'Màu Xám', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [IDChucVu], [SDT], [Email], [CCCD], [GioiTinh], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [TrangThai]) VALUES (1, N'NV01', N'Trần Xuân Hùng', 2, N'0388432827', N'hungtxph20411@gmail.com', N'012832573', 1, N'Bắc Giang', NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, 1)
INSERT [dbo].[NhanVien] ([ID], [MaNV], [TenNV], [IDChucVu], [SDT], [Email], [CCCD], [GioiTinh], [DiaChi], [MatKhau], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [TrangThai]) VALUES (3, N'NV02', N'Trần Văn Hải', 1, N'031234567', N'haitv2024@gmail.com', N'12345678', 1, N'Hà Nội', NULL, CAST(N'2023-11-23' AS Date), CAST(N'2023-11-23' AS Date), NULL, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[NSX] ON 

INSERT [dbo].[NSX] ([ID], [MaNSX], [TenNSX], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'NSX01', N'Nhà Máy Hùng', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[NSX] ([ID], [MaNSX], [TenNSX], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'NSX02', N'Công Ty Hùng may vá', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[NSX] ([ID], [MaNSX], [TenNSX], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'NSX03', N'Công Ty May', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[NSX] OFF
GO
SET IDENTITY_INSERT [dbo].[QuaiDeo] ON 

INSERT [dbo].[QuaiDeo] ([ID], [MaQuaiDeo], [TenQuaiDeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'QD01', N'Vai', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[QuaiDeo] ([ID], [MaQuaiDeo], [TenQuaiDeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'QD02', N'Chéo', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[QuaiDeo] ([ID], [MaQuaiDeo], [TenQuaiDeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'QD03', N'Ngực', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[QuaiDeo] ([ID], [MaQuaiDeo], [TenQuaiDeo], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (4, N'QD04', N'Trợ lực', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[QuaiDeo] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'SP1', N'Balo Nike', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'SP2', N'Balo Adidas', CAST(N'2023-11-10' AS Date), CAST(N'2023-11-10' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'SP01', N'Balo Thoi Trang', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SanPham] ([ID], [MaSP], [TenSP], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (4, N'SP02', N'Balo Di Hoc', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] ON 

INSERT [dbo].[SanPhamChiTiet] ([ID], [MaSPCT], [IDSanPham], [IDHang], [IDMauSac], [IDChatLieu], [IDSize], [IDNSX], [IDKhoaKeo], [IDQuaiDeo], [IDSoNgan], [SoLuong], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [Gia], [TinhTrang]) VALUES (29, N'CTSP01', 1, 2, 4, 2, 1, 1, 1, 2, 3, 10, NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, CAST(900000.00 AS Decimal(10, 2)), N'Đang bán')
INSERT [dbo].[SanPhamChiTiet] ([ID], [MaSPCT], [IDSanPham], [IDHang], [IDMauSac], [IDChatLieu], [IDSize], [IDNSX], [IDKhoaKeo], [IDQuaiDeo], [IDSoNgan], [SoLuong], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [Gia], [TinhTrang]) VALUES (30, N'CTSP02', 3, 3, 3, 1, 2, 2, 2, 1, 4, 17, NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, CAST(1000000.00 AS Decimal(10, 2)), N'Đang bán')
INSERT [dbo].[SanPhamChiTiet] ([ID], [MaSPCT], [IDSanPham], [IDHang], [IDMauSac], [IDChatLieu], [IDSize], [IDNSX], [IDKhoaKeo], [IDQuaiDeo], [IDSoNgan], [SoLuong], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [Gia], [TinhTrang]) VALUES (31, N'CTSP03', 4, 2, 1, 3, 3, 3, 1, 2, 3, 10, NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, CAST(700000.00 AS Decimal(10, 2)), N'Hết Hàng')
INSERT [dbo].[SanPhamChiTiet] ([ID], [MaSPCT], [IDSanPham], [IDHang], [IDMauSac], [IDChatLieu], [IDSize], [IDNSX], [IDKhoaKeo], [IDQuaiDeo], [IDSoNgan], [SoLuong], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [Gia], [TinhTrang]) VALUES (32, N'CTSP04', 2, 1, 1, 2, 2, 1, 2, 1, 2, 15, NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, CAST(900000.00 AS Decimal(10, 2)), N'Đang bán')
INSERT [dbo].[SanPhamChiTiet] ([ID], [MaSPCT], [IDSanPham], [IDHang], [IDMauSac], [IDChatLieu], [IDSize], [IDNSX], [IDKhoaKeo], [IDQuaiDeo], [IDSoNgan], [SoLuong], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa], [Gia], [TinhTrang]) VALUES (33, N'CTSP05', 1, 3, 3, 1, 2, 3, 1, 2, 2, 10, NULL, CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL, CAST(700000.00 AS Decimal(10, 2)), N'Đang bán')
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[Size] ON 

INSERT [dbo].[Size] ([ID], [MaSize], [TenSize], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'SZ01', N'17in', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[Size] ([ID], [MaSize], [TenSize], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'SZ02', N'20in', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[Size] ([ID], [MaSize], [TenSize], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'SZ03', N'24in', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Size] OFF
GO
SET IDENTITY_INSERT [dbo].[SoNgan] ON 

INSERT [dbo].[SoNgan] ([ID], [MaSoNgan], [TenSoNgan], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'SN01', N'3', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SoNgan] ([ID], [MaSoNgan], [TenSoNgan], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'SN02', N'4', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SoNgan] ([ID], [MaSoNgan], [TenSoNgan], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (3, N'SN03', N'2', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[SoNgan] ([ID], [MaSoNgan], [TenSoNgan], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (4, N'SN04', N'5', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[SoNgan] OFF
GO
SET IDENTITY_INSERT [dbo].[ThanhToan] ON 

INSERT [dbo].[ThanhToan] ([ID], [MaHTTT], [TenHTTT], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'HTTT01', N'Chuyển Khoản', N'Chuyển qua stk ', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
INSERT [dbo].[ThanhToan] ([ID], [MaHTTT], [TenHTTT], [MoTa], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (2, N'HTTT02', N'Tiền Mặt', N'trả tiền mặt', CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ThanhToan] OFF
GO
SET IDENTITY_INSERT [dbo].[Voucher] ON 

INSERT [dbo].[Voucher] ([ID], [MaVoucher], [TenVoucher], [NgayBatDau], [NgayKetThuc], [PhanTramGiam], [NgayTao], [NgaySua], [NguoiTao], [NguoiSua], [xoa]) VALUES (1, N'VC01', N'Siêu khuyến mại 11/11', CAST(N'2023-11-07' AS Date), CAST(N'2023-11-13' AS Date), CAST(20 AS Decimal(18, 0)), CAST(N'2023-11-17' AS Date), CAST(N'2023-11-17' AS Date), NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Voucher] OFF
GO
ALTER TABLE [dbo].[ChatLieu] ADD  CONSTRAINT [DF_ChatLieu_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  CONSTRAINT [DF_ChatLieu_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChucVu] ADD  CONSTRAINT [DF_ChucVu_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChucVu] ADD  CONSTRAINT [DF_ChucVu_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[Hang] ADD  CONSTRAINT [DF_Hang_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[Hang] ADD  CONSTRAINT [DF_Hang_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  CONSTRAINT [DF_HinhThucThanhToan_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  CONSTRAINT [DF_HoaDon_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  CONSTRAINT [DF_HoaDonChiTiet_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[KhachHang] ADD  CONSTRAINT [DF_KhachHang_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[KhoaKeo] ADD  CONSTRAINT [DF_KhoaKeo_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[KhoaKeo] ADD  CONSTRAINT [DF_KhoaKeo_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[LichSuHoaDon] ADD  CONSTRAINT [DF_LichSuHoaDon_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[LichSuHoaDon] ADD  CONSTRAINT [DF_LichSuHoaDon_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[MauSac] ADD  CONSTRAINT [DF_MauSac_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[MauSac] ADD  CONSTRAINT [DF_MauSac_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [DF_NhanVien_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[NSX] ADD  CONSTRAINT [DF_NSX_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NSX] ADD  CONSTRAINT [DF_NSX_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[QuaiDeo] ADD  CONSTRAINT [DF_QuaiDeo_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[QuaiDeo] ADD  CONSTRAINT [DF_QuaiDeo_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SanPham] ADD  CONSTRAINT [DF_SanPham_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SanPhamChiTiet] ADD  CONSTRAINT [DF_SanPhamChiTiet_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SanPhamChiTiet] ADD  CONSTRAINT [DF_SanPhamChiTiet_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[Size] ADD  CONSTRAINT [DF_Size_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[Size] ADD  CONSTRAINT [DF_Size_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SoNgan] ADD  CONSTRAINT [DF_SoNgan_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SoNgan] ADD  CONSTRAINT [DF_SoNgan_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ThanhToan] ADD  CONSTRAINT [DF_ThanhToan_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ThanhToan] ADD  CONSTRAINT [DF_ThanhToan_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[Voucher] ADD  CONSTRAINT [DF_Voucher_NgayTao]  DEFAULT (getdate()) FOR [NgayTao]
GO
ALTER TABLE [dbo].[Voucher] ADD  CONSTRAINT [DF_Voucher_NgaySua]  DEFAULT (getdate()) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HinhThucThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_HinhThucThanhToan_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HinhThucThanhToan] CHECK CONSTRAINT [FK_HinhThucThanhToan_HoaDon]
GO
ALTER TABLE [dbo].[HinhThucThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_HinhThucThanhToan_ThanhToan] FOREIGN KEY([IDThanhToan])
REFERENCES [dbo].[ThanhToan] ([ID])
GO
ALTER TABLE [dbo].[HinhThucThanhToan] CHECK CONSTRAINT [FK_HinhThucThanhToan_ThanhToan]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([IDKhangHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([IDNhanVien])
REFERENCES [dbo].[NhanVien] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Voucher] FOREIGN KEY([IDVoucher])
REFERENCES [dbo].[Voucher] ([ID])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Voucher]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet] FOREIGN KEY([IDSanPhamChiTiet])
REFERENCES [dbo].[SanPhamChiTiet] ([ID])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_SanPhamChiTiet]
GO
ALTER TABLE [dbo].[LichSuHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_LichSuHoaDon_HoaDon] FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[LichSuHoaDon] CHECK CONSTRAINT [FK_LichSuHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([IDChucVu])
REFERENCES [dbo].[ChucVu] ([ID])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_ChatLieu] FOREIGN KEY([IDChatLieu])
REFERENCES [dbo].[ChatLieu] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_ChatLieu]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_Hang] FOREIGN KEY([IDHang])
REFERENCES [dbo].[Hang] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_Hang]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_KhoaKeo] FOREIGN KEY([IDKhoaKeo])
REFERENCES [dbo].[KhoaKeo] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_KhoaKeo]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_MauSac] FOREIGN KEY([IDMauSac])
REFERENCES [dbo].[MauSac] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_MauSac]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_NSX] FOREIGN KEY([IDNSX])
REFERENCES [dbo].[NSX] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_NSX]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_QuaiDeo] FOREIGN KEY([IDQuaiDeo])
REFERENCES [dbo].[QuaiDeo] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_QuaiDeo]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_SanPham] FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_SanPham]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_Size] FOREIGN KEY([IDSize])
REFERENCES [dbo].[Size] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_Size]
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_SanPhamChiTiet_SoNgan] FOREIGN KEY([IDSoNgan])
REFERENCES [dbo].[SoNgan] ([ID])
GO
ALTER TABLE [dbo].[SanPhamChiTiet] CHECK CONSTRAINT [FK_SanPhamChiTiet_SoNgan]
GO
