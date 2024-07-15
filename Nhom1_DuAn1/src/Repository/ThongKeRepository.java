/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import Model.SanPhamView;
import Model.ThongKeView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeRepository {

    public List<ThongKeView> getDoanhThu(String month, String year) {
        List<ThongKeView> lst = new ArrayList<>();

        String sql = "SELECT MONTH(dbo.HoaDon.NgayThanhToan) AS N'Tháng', SUM(dbo.HoaDonChiTiet.SoLuong)AS N'Số Lượng', SUM(dbo.HoaDonChiTiet.SoLuong * dbo.HoaDonChiTiet.GiaTien) AS N'Doanh Thu' FROM dbo.HoaDon JOIN dbo.HoaDonChiTiet ON HoaDonChiTiet.IDHoaDon = HoaDon.ID JOIN dbo.SanPhamChiTiet ON SanPhamChiTiet.ID = HoaDonChiTiet.IDSanPhamChiTiet WHERE dbo.HoaDon.TrangThai = 1 AND YEAR(dbo.HoaDon.NgayThanhToan) LIKE ? AND MONTH(dbo.HoaDon.NgayThanhToan) LIKE ? GROUP BY YEAR(dbo.HoaDon.NgayThanhToan) , MONTH(dbo.HoaDon.NgayThanhToan)";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + year + "%");
            ps.setString(2, "%" + month + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setThang(rs.getString(1));
                tk.setSoLuong(rs.getString(2));
                tk.setDoanThu(rs.getString(3));
                lst.add(tk);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    public List<SanPhamView> getDoanhThuSanPham(String ten) {
        List<SanPhamView> lst = new ArrayList<>();

        String sql = "SELECT MaSPCT AS 'Ma', dbo.SanPham.TenSP AS 'Ten',Gia  AS 'Gia', HoaDonChiTiet.SoLuong AS 'so Luon', SUM(HoaDonChiTiet.SoLuong * Gia) AS 'doanh Thu'  FROM dbo.SanPhamChiTiet JOIN dbo.HoaDonChiTiet ON HoaDonChiTiet.IDSanPhamChiTiet = SanPhamChiTiet.ID JOIN dbo.SanPham ON SanPham.ID = SanPhamChiTiet.IDSanPham WHERE TenSP LIKE ? OR MaSPCT LIKE ? GROUP BY MaSPCT, TenSP, Gia, HoaDonChiTiet.SoLuong";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamView sp = new SanPhamView();
                sp.setMa(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setGia(rs.getString(3));
                sp.setSoLuong(rs.getString(4));
                sp.setDoanhThu(rs.getString(5));
                lst.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    public String getDoanhThuValue(String value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String doanhThu = "";

        String sql = "";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = null;
            if (value.equalsIgnoreCase("day")) {
                sql = "SELECT SUM(TongTien) AS 'Tong tien' FROM HoaDon WHERE TrangThai = 1 AND DAY(NgayThanhToan)  = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, day);
            } else if (value.equalsIgnoreCase("month")) {
                sql = "SELECT SUM(TongTien) AS 'Tong tien' FROM HoaDon WHERE TrangThai = 1 AND YEAR(NgayThanhToan) = ? AND MONTH(NgayThanhToan) = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, year);
                ps.setInt(2, month);

            } else if (value.equalsIgnoreCase("year")) {
                sql = "SELECT SUM(TongTien) AS 'Tong tien' FROM HoaDon WHERE TrangThai = 1 AND YEAR(NgayThanhToan) = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, year);

            } else {
                sql = "SELECT SUM(TongTien) AS 'Tong tien' FROM HoaDon";
                ps = conn.prepareStatement(sql);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doanhThu = rs.getString(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThu;
    }
    
    
    public List<String> getThang(String year) {
        List<String> lst = new ArrayList<>();

        String sql = "SELECT MONTH(NgayThanhToan) AS 'thang' FROM dbo.HoaDon WHERE TrangThai = 1 AND YEAR(NgayThanhToan) LIKE ? GROUP BY MONTH(NgayThanhToan) ORDER BY MONTH(NgayThanhToan) DESC";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + year + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(rs.getString(1));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }
    
    
     public List<String> getNam() {
        List<String> lst = new ArrayList<>();

        String sql = "SELECT YEAR(NgayThanhToan) AS 'YEAR' FROM dbo.HoaDon WHERE TrangThai = 1 GROUP BY YEAR(NgayThanhToan) ORDER BY YEAR(NgayThanhToan) DESC";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(rs.getString(1));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }
}
