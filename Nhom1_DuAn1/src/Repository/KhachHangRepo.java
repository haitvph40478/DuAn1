/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.KhachHang;
import Model.NhanVien;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI 15
 */
public class KhachHangRepo {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public boolean inertKH(KhachHang kh) {
        sql = "insert into KhachHang(MaKH , TenKH , Email,DiaChi,SDT,GioiTinh) values(?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.getEmail());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getSDT());
            ps.setObject(6, kh.getGioiTinh());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

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




    public int updateKH(KhachHang kh, String MaKH) {
        sql = "update KhachHang set   TenKH=? , Email =?, DiaChi=?,SDT=? , GioiTinh=? where MaKH=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getEmail());
            ps.setObject(3, kh.getDiaChi());
            ps.setObject(4, kh.getSDT());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, MaKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//
//
//

    public int deleteKH(String MaKH) {
        sql = "delete from KhachHang where MaKH=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<KhachHang> getAll() {

        ArrayList<KhachHang> list = new ArrayList<>();
        sql = "select MaKH , TenKH , Email,DiaChi,SDT,GioiTinh from KhachHang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String MaKH = rs.getString("MaKH");
                String TenKH = rs.getString("TenKH");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                int GioiTinh = Integer.valueOf(rs.getString("GioiTinh"));
                KhachHang kh = new KhachHang();
                kh.setMaKH(MaKH);
                kh.setTenKH(TenKH);
                kh.setEmail(Email);
                kh.setDiaChi(DiaChi);
                kh.setSDT(SDT);
                kh.setGioiTinh(GioiTinh);
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public ArrayList<HoaDon> getAllHD() {
//        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
//        sql = "SELECT HoaDon.MaHoaDon, KhachHang.tenKH,HoaDon.DiaChiNguoiNhan,HoaDon.TongTien, HoaDon.NgayTao, "
//                + "  HoaDon.Trangthai,HoaDon.trangthaicbb ,"
//                + " KhachHang.ID AS idKH, KhachHang.tenKH AS tenKH FROM HoaDon\n"
//                + "LEFT JOIN KhachHang ON HoaDon.IDKhangHang = KhachHang.ID";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
////                int id = Integer.valueOf((rs.getString(1)));
//                
////                UUID idhd = UUID.fromString(rs.getString("id"));
//                 String MaHoaDon = rs.getString("MaHoaDon");
//                Date NgayTao = rs.getDate("NgayTao");
//                BigDecimal TongTien = rs.getBigDecimal("TongTien");
//                String DiaChiNguoiNhan = rs.getString("DiaChiNguoiNhan");
//                String Trangthai = rs.getString("Trangthai");
//                int trangthaicbb = Integer.valueOf(rs.getString("trangthaicbb"));
//                int idkh = Integer.valueOf(rs.getString("idKH"));
//                String tenKH = rs.getString("tenKH");
//
//                KhachHang kh = new KhachHang();
//                kh.setID(idkh);
//                kh.setTenKH(tenKH);
//
//                HoaDon hoaDon = new HoaDon();
//                hoaDon.setMaHoaDon(MaHoaDon);
//                hoaDon.setNgayTao(NgayTao);
//                hoaDon.setDiaChiNguoiNhan(DiaChiNguoiNhan);
//                hoaDon.setTongTien(TongTien);
//                hoaDon.setTrangThai(Trangthai);
//                hoaDon.setIdKhachHang(kh);
//                hoaDon.setTrangthaicbb(trangthaicbb);
//                hoaDonList.add(hoaDon);
//            }
//            return hoaDonList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<HoaDon> selectAllHoaDon() {
//       
//        ArrayList<HoaDon> list = new ArrayList();
//        sql = "select  HoaDon.ma,HoaDon.ngaythanhtoan,HoaDon.tongtiencuahoadon,"
//                + "HoaDon.tinhtrang,HoaDon.tennguoinhan ,HoaDon.diachi from HoaDon  inner join KhachHang on KhachHang.id=HoaDon.id_khachhang";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                //  KhachHang kh = new KhachHang(rs.getString(5));
//                HoaDon hd = new HoaDon(rs.getString(1), rs.getDate(2),
//                        rs.getBigDecimal(3), rs.getInt(4),
//                        rs.getString(5), rs.getString(6));
//                list.add(hd);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public KhachHang selectById(String maKH) {
//        ArrayList<KhachHang> list = new ArrayList<>();
//        sql = "select TenKH , Email,DiaChi,SDT,GioiTinh from KhachHang where MaKH =?";
//
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                String MaKH = rs.getString("MaKH");
//                String TenKH = rs.getString("TenKH");
//                String Email = rs.getString("Email");
//                String DiaChi = rs.getString("DiaChi");
//                String SDT = rs.getString("SDT");
//                int GioiTinh = Integer.valueOf(rs.getString("GioiTinh"));
//                KhachHang kh = new KhachHang();
//                kh.setMaKH(MaKH);
//                kh.setTenKH(TenKH);
//                kh.setEmail(Email);
//                kh.setDiaChi(DiaChi);
//                kh.setSDT(SDT);
//                kh.setGioiTinh(GioiTinh);
//                list.add(kh);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
    public List<KhachHang> timTen(String TenKH) {
        sql = "select  MaKH,TenKH , Email,DiaChi,SDT,GioiTinh from KhachHang where TenKH like ?";
        
        List<KhachHang> listKH = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + TenKH + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                 String MaKH = rs.getString("MaKH");
                 String tenKH = rs.getString("TenKH");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                int GioiTinh = Integer.valueOf(rs.getString("GioiTinh"));
                KhachHang kh = new KhachHang();
                kh.setMaKH(MaKH);
                kh.setTenKH(tenKH);
                kh.setEmail(Email);
                kh.setDiaChi(DiaChi);
                kh.setSDT(SDT);
                kh.setGioiTinh(GioiTinh);
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public List<KhachHang> timMa(String MaKH) {
        sql = "select  MaKH,TenKH , Email,DiaChi,SDT,GioiTinh from KhachHang where MaKH like ?";
        
        List<KhachHang> listKH = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,  MaKH);
            rs = ps.executeQuery();
            while (rs.next()) {
                 String maKH = rs.getString("MaKH");
                 String tenKH = rs.getString("TenKH");
                String Email = rs.getString("Email");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                int GioiTinh = Integer.valueOf(rs.getString("GioiTinh"));
                KhachHang kh = new KhachHang();
                kh.setMaKH(MaKH);
                kh.setTenKH(tenKH);
                kh.setEmail(Email);
                kh.setDiaChi(DiaChi);
                kh.setSDT(SDT);
                kh.setGioiTinh(GioiTinh);
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//
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
