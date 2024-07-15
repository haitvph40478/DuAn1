/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienRepository {

    ChucVuRepository cvRepo;

    public NhanVienRepository() {
        cvRepo = new ChucVuRepository();
    }

    public List<NhanVien> getAll() {
        List<NhanVien> lst = new ArrayList<>();
        String sql = "SELECT ID, MaNV, TenNV, IDChucVu, SDT, Email, CCCD, GioiTinh, MatKhau, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa, TrangThai FROM dbo.NhanVien";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt("ID"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setChucVu(cvRepo.getObj(rs.getString("IDChucVu")));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setNgaySua(rs.getDate("NgaySua"));
                nv.setNguoiTao(rs.getInt("NguoiTao"));
                nv.setNguoiSua(rs.getInt("NguoiSua"));
                nv.setXoa(rs.getInt("xoa"));
                nv.setTrangThai(rs.getInt("TrangThai"));
                lst.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    public NhanVien getObj(String id) {
        NhanVien nv = null;
        String sql = "SELECT ID, MaNV, TenNV, IDChucVu, SDT, Email, CCCD, GioiTinh, MatKhau, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa, TrangThai FROM dbo.NhanVien WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nv = new NhanVien();
                nv.setID(rs.getInt("ID"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setChucVu(cvRepo.getObj(rs.getString("IDChucVu")));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setNgaySua(rs.getDate("NgaySua"));
                nv.setNguoiTao(rs.getInt("NguoiTao"));
                nv.setNguoiSua(rs.getInt("NguoiSua"));
                nv.setXoa(rs.getInt("xoa"));
                nv.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
    public NhanVien getAccountNhanVien(String sdt){
     NhanVien nv = null;
        String sql = "SELECT ID, MaNV, TenNV, IDChucVu, SDT, Email, CCCD, GioiTinh, MatKhau, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa, TrangThai FROM dbo.NhanVien WHERE SDT = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nv = new NhanVien();
                nv.setID(rs.getInt("ID"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setChucVu(cvRepo.getObj(rs.getString("IDChucVu")));
                nv.setSDT(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setNgayTao(rs.getDate("NgayTao"));
                nv.setNgaySua(rs.getDate("NgaySua"));
                nv.setNguoiTao(rs.getInt("NguoiTao"));
                nv.setNguoiSua(rs.getInt("NguoiSua"));
                nv.setXoa(rs.getInt("xoa"));
                nv.setTrangThai(rs.getInt("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nv;
    }
}
