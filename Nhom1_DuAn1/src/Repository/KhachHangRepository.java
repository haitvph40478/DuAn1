/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> lst = new ArrayList<>();
        String sql = "SELECT ID, MaKH, TenKH, Email, DiaChi, SDT, GioiTinh, NgayTao, NgaySua,  NguoiTao, NguoiSua, xoa FROM dbo.KhachHang";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setID(rs.getInt("ID"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setNgayTao(rs.getDate("NgayTao"));
                kh.setNgaySua(rs.getDate("NgaySua"));
                kh.setNguoiTao(rs.getInt("NguoiTao"));
                kh.setNguoiSua(rs.getInt("NguoiSua"));
                kh.setXoa(rs.getInt("xoa"));
                lst.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }
    
    public KhachHang getObj(String id) {
        KhachHang kh =  null;
        String sql = "SELECT ID, MaKH, TenKH, Email, DiaChi, SDT, GioiTinh, NgayTao, NgaySua,  NguoiTao, NguoiSua, xoa FROM dbo.KhachHang WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                kh = new KhachHang();
                kh.setID(rs.getInt("ID"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setNgayTao(rs.getDate("NgayTao"));
                kh.setNgaySua(rs.getDate("NgaySua"));
                kh.setNguoiTao(rs.getInt("NguoiTao"));
                kh.setNguoiSua(rs.getInt("NguoiSua"));
                kh.setXoa(rs.getInt("xoa"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kh;
    }
}
