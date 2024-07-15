/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDonChiTiet;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository {

    HoaDonRepository hdRepo;
    SanPhamChiTietRepository spctRepo;

    public HoaDonChiTietRepository() {
        hdRepo = new HoaDonRepository();
        spctRepo = new SanPhamChiTietRepository();
    }

    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> lst = new ArrayList<>();
        String sql = "SELECT ID, IDHoaDon,IDSanPhamChiTiet, SoLuong, GiaTien, ThanhTien FROM dbo.HoaDonChiTiet";

        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setID(rs.getInt("ID"));
                hdct.setHoaDon(hdRepo.getObj(rs.getString("IDHoaDon")));
                hdct.setSanPhamChiTiet(spctRepo.getObj(rs.getString("IDSanPhamChiTiet")));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setGiaTien(rs.getString("GiaTien") != null ? new BigDecimal(rs.getString("GiaTien")) : BigDecimal.ZERO);
                hdct.setThanhTien(rs.getString("ThanhTien") != null ? new BigDecimal(rs.getString("ThanhTien")) : BigDecimal.ZERO);
                lst.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public List<HoaDonChiTiet> getAllByHoaDon(String idHd) {
        List<HoaDonChiTiet> lst = new ArrayList<>();
        String sql = "SELECT ID, IDHoaDon,IDSanPhamChiTiet, SoLuong, GiaTien, ThanhTien FROM dbo.HoaDonChiTiet WHERE IDHoaDon = ?";

        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setID(rs.getInt("ID"));
                hdct.setHoaDon(hdRepo.getObj(rs.getString("IDHoaDon")));
                hdct.setSanPhamChiTiet(spctRepo.getObj(rs.getString("IDSanPhamChiTiet")));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setGiaTien(rs.getString("GiaTien") != null ? new BigDecimal(rs.getString("GiaTien")) : BigDecimal.ZERO);
                hdct.setThanhTien(rs.getString("ThanhTien") != null ? new BigDecimal(rs.getString("ThanhTien")) : BigDecimal.ZERO);

                lst.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public Boolean add(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO dbo.HoaDonChiTiet(IDHoaDon,IDSanPhamChiTiet,SoLuong,GiaTien,ThanhTien)VALUES(?,?,?,?,?)";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getHoaDon().getID());
            ps.setInt(2, hdct.getSanPhamChiTiet().getId());
            ps.setInt(3, hdct.getSoLuong());
            ps.setBigDecimal(4, hdct.getGiaTien());
            ps.setBigDecimal(5, hdct.getThanhTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean update(String idHdct, HoaDonChiTiet hdct) {
        String sql = "UPDATE dbo.HoaDonChiTiet SET SoLuong =?, ThanhTien = ? WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getSoLuong());
            ps.setBigDecimal(2, hdct.getThanhTien());
            ps.setString(3, idHdct);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public Boolean delete(String idHdct) {
        String sql = "DELETE dbo.HoaDonChiTiet WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHdct);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
}
