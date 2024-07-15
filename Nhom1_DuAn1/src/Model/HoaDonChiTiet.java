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
public class HoaDonChiTiet {

    private int ID;
    private String MaHoaDonChiTiet;
    private int IDHoaDon;
    private int IDSanPhamChiTiet;
    private HoaDon hoaDon;
    private SanPhamChiTiet sanPhamChiTiet;
    private int SoLuong;
    private BigDecimal GiaTien;
    private BigDecimal ThanhTien;
    private String TrangThai;
    private Date NgayTao;
    private Date NgaySua;
    private int NguoiTao;
    private int NguoiSua;
    private int xoa;
    private HoaDon idHoaDon;
    private SanPham idSanPham;
    private MauSac idMauSac;
    private Hang idHang;

    public HoaDonChiTiet() {
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPhamChiTiet getSanPhamChiTiet() {
        return sanPhamChiTiet;
    }

    public void setSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        this.sanPhamChiTiet = sanPhamChiTiet;
    }

    public HoaDonChiTiet(int ID, String MaHoaDonChiTiet, int IDHoaDon, int IDSanPhamChiTiet, int SoLuong, BigDecimal GiaTien, BigDecimal ThanhTien, String TrangThai, Date NgayTao, Date NgaySua, int NguoiTao, int NguoiSua, int xoa, HoaDon idHoaDon, SanPham idSanPham, MauSac idMauSac, Hang idHang) {
        this.ID = ID;
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.IDHoaDon = IDHoaDon;
        this.IDSanPhamChiTiet = IDSanPhamChiTiet;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.ThanhTien = ThanhTien;
        this.TrangThai = TrangThai;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.NguoiTao = NguoiTao;
        this.NguoiSua = NguoiSua;
        this.xoa = xoa;
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.idMauSac = idMauSac;
        this.idHang = idHang;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    public int getIDSanPhamChiTiet() {
        return IDSanPhamChiTiet;
    }

    public void setIDSanPhamChiTiet(int IDSanPhamChiTiet) {
        this.IDSanPhamChiTiet = IDSanPhamChiTiet;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public BigDecimal getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(BigDecimal GiaTien) {
        this.GiaTien = GiaTien;
    }

    public BigDecimal getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(BigDecimal ThanhTien) {
        this.ThanhTien = ThanhTien;
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

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

    public MauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Hang getIdHang() {
        return idHang;
    }

    public void setIdHang(Hang idHang) {
        this.idHang = idHang;
    }

    public void setIDHoaDon(HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
