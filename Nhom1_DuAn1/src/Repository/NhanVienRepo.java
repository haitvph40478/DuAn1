/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI 15
 */
public class NhanVienRepo {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean inertKH(NhanVien nv) {
        sql = "insert into NhanVien(MaNV , TenNV ,IDChucVu,SDT, Email,CCCD,GioiTinh,DiaChi,MatKhau,TrangThai) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getIDChucVu());
            ps.setObject(4, nv.getSDT());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getCCCD());
            ps.setObject(7, nv.getGioiTinh());
            ps.setObject(8, nv.getDiaChi());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getTrangThai());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
//
//    public KhachHang checkMa(String ma) {
//        sql = "select ma , ten , gioitinh,ngaysinh,sdt,email,diachi from KhachHang where ma=? ";
//        KhachHang kh = null;
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ma);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
//            }
//            return kh;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//

    public int updateKH(NhanVien nv, String MaNV) {
        sql = "update NhanVien set   TenNV=? , IDChucVu =?, SDT=?,Email=? , CCCD=?,GioiTinh=? , DiaChi=?,MatKhau=? , TrangThai=? where MaNV=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getTenNV());
            ps.setObject(2, nv.getIDChucVu());
            ps.setObject(3, nv.getSDT());
            ps.setObject(4, nv.getEmail());
            ps.setObject(5, nv.getCCCD());
            ps.setObject(6, nv.getGioiTinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getMatKhau());
            ps.setObject(9, nv.getTrangThai());
            ps.setObject(10, nv.getMaNV());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }



    public int deleteKH(String MaNV) {
        sql = "delete from NhanVien where MaNV=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaNV);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<NhanVien> getAll() {

        ArrayList<NhanVien> list = new ArrayList<>();
        sql = "select MaNV , TenNV ,IDChucVu,SDT, Email,CCCD,GioiTinh,DiaChi,MatKhau,TrangThai from NhanVien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String TenNV = rs.getString("TenNV");
                int IDChucVu = rs.getInt("IDChucVu");
                String SDT = rs.getString("SDT");
                String Email = rs.getString("Email");
                String CCCD = rs.getString("CCCD");
                int GioiTinh = rs.getInt("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String MatKhau = rs.getString("MatKhau");
                int TrangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien();
                nv.setMaNV(MaNV);
                nv.setTenNV(TenNV);
                nv.setIDChucVu(IDChucVu);
                nv.setSDT(SDT);
                nv.setEmail(Email);
                nv.setCCCD(CCCD);
                nv.setGioiTinh(GioiTinh);
                nv.setDiaChi(DiaChi);
                nv.setMatKhau(MatKhau);
                nv.setTrangThai(TrangThai);

                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  public List<NhanVien> timTen(String TenNV) {
        sql = "select  MaNV , TenNV ,IDChucVu,SDT, Email,CCCD,GioiTinh,DiaChi,MatKhau,TrangThai from NhanVien where TenNV like ?";
        
        List<NhanVien> listKH = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + TenNV + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String MaNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                int IDChucVu = rs.getInt("IDChucVu");
                String SDT = rs.getString("SDT");
                String Email = rs.getString("Email");
                String CCCD = rs.getString("CCCD");
                int GioiTinh = rs.getInt("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String MatKhau = rs.getString("MatKhau");
                int TrangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien();
                nv.setMaNV(MaNV);
                nv.setTenNV(tenNV);
                nv.setIDChucVu(IDChucVu);
                nv.setSDT(SDT);
                nv.setEmail(Email);
                nv.setCCCD(CCCD);
                nv.setGioiTinh(GioiTinh);
                nv.setDiaChi(DiaChi);
                nv.setMatKhau(MatKhau);
                nv.setTrangThai(TrangThai);
                listKH.add(nv);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public List<NhanVien> timMa(String MaNV) {
        sql = "select  MaNV , TenNV ,IDChucVu,SDT, Email,CCCD,GioiTinh,DiaChi,MatKhau,TrangThai  from NhanVien where MaNV like ?";
        
        List<NhanVien> listKH = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,  MaNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                 String maNV = rs.getString("MaNV");
                String TenNV = rs.getString("TenNV");
                int IDChucVu = rs.getInt("IDChucVu");
                String SDT = rs.getString("SDT");
                String Email = rs.getString("Email");
                String CCCD = rs.getString("CCCD");
                int GioiTinh = rs.getInt("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String MatKhau = rs.getString("MatKhau");
                int TrangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien();
                nv.setMaNV(MaNV);
                nv.setTenNV(TenNV);
                nv.setIDChucVu(IDChucVu);
                nv.setSDT(SDT);
                nv.setEmail(Email);
                nv.setCCCD(CCCD);
                nv.setGioiTinh(GioiTinh);
                nv.setDiaChi(DiaChi);
                nv.setMatKhau(MatKhau);
                nv.setTrangThai(TrangThai);
                listKH.add(nv);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }//
//    public List<KhachHang> getAllCBO() {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        ArrayList<KhachHang> list = new ArrayList<>();
//        sql = "select ma , ten , gioitinh,ngaysinh,sdt,email,diachi from KhachHang  ";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
//                list.add(kh);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<KhachHang> timTheoGioiTinh(Boolean gioiTinh) {
//        sql = "select ma , ten , gioitinh,ngaysinh,sdt,email,diachi from KhachHang where gioitinh = ?";
//        KhachHang kh = null;
//        List<KhachHang> listNH = new ArrayList<>();
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, gioiTinh);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
//
//                listNH.add(kh);
//            }
//            return listNH;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
