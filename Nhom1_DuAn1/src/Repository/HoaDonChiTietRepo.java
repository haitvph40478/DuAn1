/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDonChiTiet;
import Model.HoaDon;
import Model.SanPham;
import Model.MauSac;
import Model.Hang;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTietRepo {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public ArrayList<HoaDonChiTiet> getAll() {
        ArrayList<HoaDonChiTiet> hoaDonCTList = new ArrayList<>();
        sql = "SELECT HoaDonChiTiet.MaHoaDonChiTiet,HoaDon.MaHoaDon,SanPham.TenSP,MauSac.TenMau,Hang.TenHang,\n"
                + "    HoaDonChiTiet.SoLuong,HoaDonChiTiet.GiaTien,HoaDonChiTiet.ThanhTien,\n"
                + "	HoaDon.ID AS IDHoaDon, HoaDon.MaHoaDon, SanPham.ID AS IDSP, SanPham.TenSP AS TenSP ,\n"
                + "	MauSac.iD AS IDMauSac,MauSac.TenMau AS TenMau,Hang.iD AS IDHang, Hang.TenHang AS TenHang\n"
                + "FROM HoaDonChiTiet\n"
                + "INNER JOIN SanPhamChiTiet ON HoaDonChiTiet.IDSanPhamChiTiet = SanPhamChiTiet.ID\n"
                + "INNER JOIN SanPham ON SanPhamChiTiet.IDSanPham = SanPham.ID\n"
                + "INNER JOIN MauSac ON SanPhamChiTiet.IDMauSac = MauSac.ID\n"
                + "INNER JOIN Hang ON SanPhamChiTiet.IDHang = Hang.ID\n"
                + "INNER JOIN HoaDon ON HoaDonChiTiet.IDHoaDon = HoaDon.ID;";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                int id = Integer.valueOf((rs.getString(1)));
                String MaHoaDonChiTiet = rs.getString("MaHoaDonChiTiet");
                int SoLuong = Integer.valueOf((rs.getString(("SoLuong"))));
                BigDecimal GiaTien = rs.getBigDecimal("GiaTien");
                BigDecimal ThanhTien = rs.getBigDecimal("ThanhTien");

                int IDHoaDon = Integer.valueOf(rs.getString("IDHoaDon"));
                String MaHoaDon = rs.getString("MaHoaDon");
                int IDSP = Integer.valueOf(rs.getString("IDSP"));
                String TenSP = rs.getString("TenSP");
                int IDMauSac = Integer.valueOf(rs.getString("IDMauSac"));
                String TenMau = rs.getString("TenMau");
                int IDHang = Integer.valueOf(rs.getString("IDHang"));
                String TenHang = rs.getString("TenHang");

                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(MaHoaDon);
                SanPham sp = new SanPham();
                sp.setTenSP(TenSP);
                MauSac ms = new MauSac();
                ms.setTenMau(TenMau);
                Hang h = new Hang();
                h.setTenHang(TenHang);
                
      
                
                HoaDonChiTiet hdct = new HoaDonChiTiet();     
                hdct.setSoLuong(SoLuong);
                hdct.setThanhTien(ThanhTien);
                hdct.setIdHoaDon(hd);
                hdct.setIdSanPham(sp);
                hdct.setIdMauSac(ms);
                hdct.setIdHang(h);
                hdct.setGiaTien(GiaTien);
                
                hoaDonCTList.add(hdct);
            }
            return hoaDonCTList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
