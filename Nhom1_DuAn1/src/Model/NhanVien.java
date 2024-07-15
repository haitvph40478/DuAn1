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
public class NhanVien {
    private Integer ID;
    private String MaNV;
    private String TenNV;
    private ChucVu chucVu;
    private Integer IDChucVu;
    private String SDT ;
    private String Email;
    private String CCCD;
    private int GioiTinh;
    private String DiaChi;
    private String MatKhau;
    private Date NgayTao;
    private Date NgaySua;
    private int NguoiTao;
    private int NguoiSua;
    private int xoa;
    private int TrangThai;

    public NhanVien() {
    }

    public NhanVien(int ID, String MaNV, String TenNV, ChucVu chucVu, Integer IDChucVu, String SDT, String Email, String CCCD, int GioiTinh, String DiaChi, String MatKhau, Date NgayTao, Date NgaySua, int NguoiTao, int NguoiSua, int xoa, int TrangThai) {
        this.ID = ID;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.chucVu = chucVu;
        this.IDChucVu = IDChucVu;
        this.SDT = SDT;
        this.Email = Email;
        this.CCCD = CCCD;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.MatKhau = MatKhau;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.NguoiTao = NguoiTao;
        this.NguoiSua = NguoiSua;
        this.xoa = xoa;
        this.TrangThai = TrangThai;
    }


    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public Integer getIDChucVu() {
        return IDChucVu;
    }

    public void setIDChucVu(Integer IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

  

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

 

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
       public String hienThiTrangThai() {
        if (TrangThai == 1) {
            return "Đang làm";
        } else {
            return "Nghỉ làm";
        }
    }
           public String hienThiGioiTinh() {
        if (GioiTinh == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
   public String hienThiChucVu() {
        if (IDChucVu == 2) {
            return "Quản Lý";
        } else {
            return "Nhân Viên";
        }
    }    



    
    

    
 
    
    
    
}
