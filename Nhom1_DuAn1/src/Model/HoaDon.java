/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDon {

    private int ID;
    private String MaHoaDon;
    private Integer IDKhangHang;
    private Integer IDNhanVien;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private int IDVoucher;
    private String TenNguoiNhan;
    private String SdtNguoiNhan;
    private String DiaChiNguoiNhan;
    private BigDecimal PhiShip;
    private BigDecimal TongTien;
    private BigDecimal tienMat;
    private BigDecimal tienChuyenKhoan;
    private String maChuyenKhoan;
    private String hinhThuc;
    private String TrangThai;
    private Date NgayTao;
    private Date NgaySua;
    private int NguoiTao;
    private int NguoiSua;
    private int xoa;
    private int trangthaicbb;
    private KhachHang idKhachHang;
    private NhanVien idNhanVien;

    public HoaDon() {
    }

    public HoaDon(int ID, String MaHoaDon, Integer IDKhangHang, Integer IDNhanVien, KhachHang khachHang, NhanVien nhanVien, int IDVoucher, String TenNguoiNhan, String SdtNguoiNhan, String DiaChiNguoiNhan, BigDecimal PhiShip, BigDecimal TongTien, String TrangThai, Date NgayTao, Date NgaySua, int NguoiTao, int NguoiSua, int xoa, int trangthaicbb, KhachHang idKhachHang, NhanVien idNhanVien) {
        this.ID = ID;
        this.MaHoaDon = MaHoaDon;
        this.IDKhangHang = IDKhangHang;
        this.IDNhanVien = IDNhanVien;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.IDVoucher = IDVoucher;
        this.TenNguoiNhan = TenNguoiNhan;
        this.SdtNguoiNhan = SdtNguoiNhan;
        this.DiaChiNguoiNhan = DiaChiNguoiNhan;
        this.PhiShip = PhiShip;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.NguoiTao = NguoiTao;
        this.NguoiSua = NguoiSua;
        this.xoa = xoa;
        this.trangthaicbb = trangthaicbb;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
    }

    public BigDecimal getTienMat() {
        return tienMat;
    }

    public void setTienMat(BigDecimal tienMat) {
        this.tienMat = tienMat;
    }

    public BigDecimal getTienChuyenKhoan() {
        return tienChuyenKhoan;
    }

    public void setTienChuyenKhoan(BigDecimal tienChuyenKhoan) {
        this.tienChuyenKhoan = tienChuyenKhoan;
    }

    public String getMaChuyenKhoan() {
        return maChuyenKhoan;
    }

    public void setMaChuyenKhoan(String maChuyenKhoan) {
        this.maChuyenKhoan = maChuyenKhoan;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Integer getIDKhangHang() {
        return IDKhangHang;
    }

    public void setIDKhangHang(Integer IDKhangHang) {
        this.IDKhangHang = IDKhangHang;
    }

    public Integer getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(Integer IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVoucher = IDVoucher;
    }

    public String getTenNguoiNhan() {
        return TenNguoiNhan;
    }

    public void setTenNguoiNhan(String TenNguoiNhan) {
        this.TenNguoiNhan = TenNguoiNhan;
    }

    public String getSdtNguoiNhan() {
        return SdtNguoiNhan;
    }

    public void setSdtNguoiNhan(String SdtNguoiNhan) {
        this.SdtNguoiNhan = SdtNguoiNhan;
    }

    public String getDiaChiNguoiNhan() {
        return DiaChiNguoiNhan;
    }

    public void setDiaChiNguoiNhan(String DiaChiNguoiNhan) {
        this.DiaChiNguoiNhan = DiaChiNguoiNhan;
    }

    public BigDecimal getPhiShip() {
        return PhiShip;
    }

    public void setPhiShip(BigDecimal PhiShip) {
        this.PhiShip = PhiShip;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(Date NgaySua) {
        this.NgaySua = NgaySua;
    }

    public int getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(int NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public int getNguoiSua() {
        return NguoiSua;
    }

    public void setNguoiSua(int NguoiSua) {
        this.NguoiSua = NguoiSua;
    }

    public int getXoa() {
        return xoa;
    }

    public void setXoa(int xoa) {
        this.xoa = xoa;
    }

    public int getTrangthaicbb() {
        return trangthaicbb;
    }

    public void setTrangthaicbb(int trangthaicbb) {
        this.trangthaicbb = trangthaicbb;
    }

    public KhachHang getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(KhachHang idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public NhanVien getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(NhanVien idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    

    
}
