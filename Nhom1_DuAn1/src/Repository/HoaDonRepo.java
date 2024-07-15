/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.KhachHang;
import Model.NhanVien;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepo {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public ArrayList<HoaDon> getAll() {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        sql = "SELECT HoaDon.MaHoaDon, NhanVien.MaNV, KhachHang.tenKH, KhachHang.SDT,HoaDon.DiaChiNguoiNhan,HoaDon.TongTien, HoaDon.NgayTao, "
                + "  HoaDon.Trangthai ,"
                + "NhanVien.ID AS idNV, NhanVien.MaNV,NhanVien.TenNV, KhachHang.ID AS idKH, KhachHang.tenKH AS tenKH,KhachHang.SDT AS SDT FROM HoaDon\n"
                + "LEFT JOIN NhanVien ON HoaDon.IDNhanVien = NhanVien.ID\n"
                + "LEFT JOIN KhachHang ON HoaDon.IDKhangHang = KhachHang.ID";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                int id = Integer.valueOf((rs.getString(1)));
                
//                UUID idhd = UUID.fromString(rs.getString("id"));
                 String MaHoaDon = rs.getString("MaHoaDon");
                Date NgayTao = rs.getDate("NgayTao");
                BigDecimal TongTien = rs.getBigDecimal("TongTien");
                String DiaChiNguoiNhan = rs.getString("DiaChiNguoiNhan");
                String Trangthai = rs.getString("Trangthai");
//                int trangthaicbb = Integer.valueOf(rs.getString("trangthaicbb"));
                int idnv = Integer.valueOf(rs.getString("idNV"));
                String MaNV = rs.getString("MaNV");
                String TenNV = rs.getString("TenNV");
//                int idkh = Integer.valueOf(rs.getString("idKH"));
                String tenKH = rs.getString("tenKH");
                 String SDT = rs.getString("SDT");

                NhanVien nv = new NhanVien();
                nv.setID(idnv);
                nv.setMaNV(MaNV);
                nv.setTenNV(TenNV);
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("idKH"));
                kh.setTenKH(tenKH);
                kh.setSDT(SDT);

                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(MaHoaDon);
                hoaDon.setNgayTao(NgayTao);
                hoaDon.setDiaChiNguoiNhan(DiaChiNguoiNhan);
                hoaDon.setTongTien(TongTien);
                hoaDon.setTrangThai(Trangthai);
                hoaDon.setIdNhanVien(nv);
                hoaDon.setIdKhachHang(kh);
//                hoaDon.setTrangthaicbb(trangthaicbb);
                hoaDonList.add(hoaDon);
            }
            return hoaDonList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /////////////////////
//     public ArrayList<HoaDon> getAllcbb(int trangthaicbb) {
//        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
//        sql = "SELECT HoaDon.MaHoaDon, NhanVien.MaNV, KhachHang.tenKH, KhachHang.SDT, HoaDon.NgayTao, "
//                + " HoaDon.TongTien, HoaDon.Trangthai,HoaDon.trangthaicbb"
//                + "NhanVien.ID AS idNV, NhanVien.MaNV, KhachHang.ID AS idKH, KhachHang.tenKH AS tenKH,KhachHang.SDT AS SDT FROM HoaDon\n"
//                + "LEFT JOIN NhanVien ON HoaDon.IDNhanVien = NhanVien.ID\n"
//                + "LEFT JOIN KhachHang ON HoaDon.IDKhangHang = KhachHang.ID"
//                + "WHERE trangthaicbb =?";
//        try {
//            conn = DBConnect.getConnection();
//            ps = conn.prepareStatement(sql);
////            ps.setInt(1,ID );
//             ps.setInt(1, trangthaicbb);
//            rs = ps.executeQuery();
//            while (rs.next()) {
////                int id = Integer.valueOf((rs.getString(1)));
//                
////                UUID idhd = UUID.fromString(rs.getString("id"));
//                 String MaHoaDon = rs.getString("MaHoaDon");
//                Date NgayTao = rs.getDate("NgayTao");
//                BigDecimal TongTien = rs.getBigDecimal("TongTien");
//                String Trangthai = rs.getString("Trangthai");
//                int idnv = Integer.valueOf(rs.getString("idNV"));
//                String MaNV = rs.getString("MaNV");
//                int idkh = Integer.valueOf(rs.getString("idKH"));
//                String tenKH = rs.getString("tenKH");
//                 String SDT = rs.getString("SDT");
//
//                NhanVien nv = new NhanVien();
//                nv.setID(idnv);
//                nv.setMaNV(MaNV);
//                KhachHang kh = new KhachHang();
//                kh.setID(idkh);
//                kh.setTenKH(tenKH);
//                kh.setSDT(SDT);
//
//                HoaDon hoaDon = new HoaDon();
//                hoaDon.setMaHoaDon(MaHoaDon);
//                hoaDon.setNgayTao(NgayTao);
//                hoaDon.setTongTien(TongTien);
//                hoaDon.setTrangThai(Trangthai);
//                hoaDon.setIdNhanVien(nv);
//                hoaDon.setIdKhachHang(kh);
//                hoaDonList.add(hoaDon);
//            }
//            return hoaDonList;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
     ///////////////////
    
    public ArrayList<HoaDon> timKiem(String MaHoaDon){
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try(Connection conn = DBConnect.getConnection();
           PreparedStatement ps = conn.prepareStatement("SELECT * FROM HoaDOn WHERE MaHoaDon =?")) {
            ps.setObject(1, MaHoaDon);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setID(Integer.valueOf(rs.getString(1)));
                hd.setIDKhangHang(Integer.valueOf(rs.getString(2)));
                hd.setIDNhanVien(Integer.valueOf(rs.getString(3)));
                hd.setIDVoucher(Integer.valueOf(rs.getString(4)));
                hd.setTenNguoiNhan(rs.getString(5));
                hd.setSdtNguoiNhan(rs.getString(6));
                hd.setDiaChiNguoiNhan(rs.getString(7));

                

                listHD.add(hd);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return listHD;
    }

    
}
