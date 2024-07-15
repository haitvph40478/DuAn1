/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KhachHang {

    private Integer ID;
    private String MaKH;
    private String TenKH;
    private String Email;
    private String DiaChi;
    private String SDT;
    private int GioiTinh;
    private Date NgayTao;
    private Date NgaySua;
    private int NguoiTao;
    private int NguoiSua;
    private int xoa;

    public KhachHang() {
    }

    public KhachHang(int ID, String MaKH, String TenKH, String Email, String DiaChi, String SDT, int GioiTinh, Date NgayTao, Date NgaySua, int NguoiTao, int NguoiSua, int xoa) {
        this.ID = ID;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.NguoiTao = NguoiTao;
        this.NguoiSua = NguoiSua;
        this.xoa = xoa;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
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

}
