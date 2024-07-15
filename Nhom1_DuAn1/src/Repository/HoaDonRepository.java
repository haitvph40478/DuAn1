/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.HoaDon;
import Model.MauSac;
import java.math.BigDecimal;
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
public class HoaDonRepository {

    KhachHangRepository khRepo;
    NhanVienRepository nvRepo;

    public HoaDonRepository() {
        this.khRepo = new KhachHangRepository();
        this.nvRepo = new NhanVienRepository();
    }

    public List<HoaDon> getAll() {
        List<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT ID, MaHoaDon, IDKhangHang, IDNhanVien, IDVoucher, TenNguoiNhan, SdtNguoiNhan, DiaChiNguoiNhan,"
                + " PhiShip,TongTien, TienMat, TienChuyenKhoan, MaChuyenKhoan, HinhThuc, TrangThai, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa FROM dbo.HoaDon ORDER BY ID DESC";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon obj = new HoaDon();
                obj.setID(rs.getInt("ID"));
                obj.setMaHoaDon(rs.getString("MaHoaDon"));
                obj.setNhanVien(nvRepo.getObj(rs.getString("IDNhanVien")));
                obj.setKhachHang(khRepo.getObj(rs.getString("IDKhangHang")));
                obj.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                obj.setSdtNguoiNhan(rs.getString("SdtNguoiNhan"));
                obj.setDiaChiNguoiNhan(rs.getString("DiaChiNguoiNhan"));
                obj.setPhiShip(rs.getString("PhiShip") != null ? new BigDecimal(rs.getString("PhiShip")) : BigDecimal.ZERO);
                obj.setTongTien(rs.getString("TongTien") != null ? new BigDecimal(rs.getString("TongTien")) : BigDecimal.ZERO);
                obj.setTienMat(rs.getString("TienMat") != null ? new BigDecimal(rs.getString("TienMat")) : BigDecimal.ZERO);
                obj.setTienChuyenKhoan(rs.getString("TienChuyenKhoan") != null ? new BigDecimal(rs.getString("TienChuyenKhoan")) : BigDecimal.ZERO);
                obj.setMaChuyenKhoan(rs.getString("MaChuyenKhoan"));
                obj.setHinhThuc(rs.getString("HinhThuc"));
                obj.setTrangThai(rs.getString("TrangThai"));
                obj.setNgayTao(rs.getDate("NgayTao"));
                obj.setNgaySua(rs.getDate("NgaySua"));
                obj.setNguoiTao(rs.getInt("NguoiTao"));
                obj.setNguoiSua(rs.getInt("NguoiSua"));
                obj.setXoa(rs.getInt("xoa"));
//                obj.setTrangthaicbb(rs.getInt("trangthaicbb"));
                lst.add(obj);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<HoaDon> getAllByTrangThai(String trangThai) {
        List<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT ID, MaHoaDon, IDKhangHang, IDNhanVien, IDVoucher, TenNguoiNhan, SdtNguoiNhan, DiaChiNguoiNhan,\n"
                + "PhiShip,TongTien, TienMat, TienChuyenKhoan, MaChuyenKhoan, HinhThuc, TrangThai, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa FROM dbo.HoaDon WHERE TrangThai LIKE ?  ORDER BY ID DESC";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + trangThai + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon obj = new HoaDon();
                obj.setID(rs.getInt("ID"));
                obj.setMaHoaDon(rs.getString("MaHoaDon"));
                obj.setNhanVien(nvRepo.getObj(rs.getString("IDNhanVien")));
                obj.setKhachHang(khRepo.getObj(rs.getString("IDKhangHang")));
                obj.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                obj.setSdtNguoiNhan(rs.getString("SdtNguoiNhan"));
                obj.setDiaChiNguoiNhan(rs.getString("DiaChiNguoiNhan"));
                obj.setPhiShip(rs.getString("PhiShip") != null ? new BigDecimal(rs.getString("PhiShip")) : BigDecimal.ZERO);
                obj.setTongTien(rs.getString("TongTien") != null ? new BigDecimal(rs.getString("TongTien")) : BigDecimal.ZERO);
                obj.setTienMat(rs.getString("TienMat") != null ? new BigDecimal(rs.getString("TienMat")) : BigDecimal.ZERO);
                obj.setTienChuyenKhoan(rs.getString("TienChuyenKhoan") != null ? new BigDecimal(rs.getString("TienChuyenKhoan")) : BigDecimal.ZERO);
                obj.setMaChuyenKhoan(rs.getString("MaChuyenKhoan"));
                obj.setHinhThuc(rs.getString("HinhThuc"));
                obj.setTrangThai(rs.getString("TrangThai"));
                obj.setNgayTao(rs.getDate("NgayTao"));
                obj.setNgaySua(rs.getDate("NgaySua"));
                obj.setNguoiTao(rs.getInt("NguoiTao"));
                obj.setNguoiSua(rs.getInt("NguoiSua"));
                obj.setXoa(rs.getInt("xoa"));
//                obj.setTrangthaicbb(rs.getInt("trangthaicbb"));
                lst.add(obj);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public HoaDon getObj(String id) {
        HoaDon obj = new HoaDon();
        String sql = "SELECT ID, MaHoaDon, IDKhangHang, IDNhanVien, IDVoucher, TenNguoiNhan, SdtNguoiNhan, DiaChiNguoiNhan,"
                + " PhiShip,TongTien, TienMat, TienChuyenKhoan, MaChuyenKhoan, HinhThuc, TrangThai, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa FROM dbo.HoaDon WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                obj.setID(rs.getInt("ID"));
                obj.setMaHoaDon(rs.getString("MaHoaDon"));
                obj.setNhanVien(nvRepo.getObj(rs.getString("IDNhanVien")));
                obj.setKhachHang(khRepo.getObj(rs.getString("IDKhangHang")));
                obj.setIDVoucher(rs.getInt("IDVoucher"));
                obj.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                obj.setSdtNguoiNhan(rs.getString("SdtNguoiNhan"));
                obj.setDiaChiNguoiNhan(rs.getString("DiaChiNguoiNhan"));
                obj.setPhiShip(rs.getString("PhiShip") != null ? new BigDecimal(rs.getString("PhiShip")) : BigDecimal.ZERO);
                obj.setTongTien(rs.getString("TongTien") != null ? new BigDecimal(rs.getString("TongTien")) : BigDecimal.ZERO);
                obj.setTienMat(rs.getString("TienMat") != null ? new BigDecimal(rs.getString("TienMat")) : BigDecimal.ZERO);
                obj.setTienChuyenKhoan(rs.getString("TienChuyenKhoan") != null ? new BigDecimal(rs.getString("TienChuyenKhoan")) : BigDecimal.ZERO);
                obj.setMaChuyenKhoan(rs.getString("MaChuyenKhoan"));
                obj.setHinhThuc(rs.getString("HinhThuc"));
                obj.setTrangThai(rs.getString("TrangThai"));
                obj.setNgayTao(rs.getDate("NgayTao"));
                obj.setNgaySua(rs.getDate("NgaySua"));
                obj.setNguoiTao(rs.getInt("NguoiTao"));
                obj.setNguoiSua(rs.getInt("NguoiSua"));
                obj.setXoa(rs.getInt("xoa"));
//                obj.setTrangthaicbb(rs.getInt("trangthaicbb"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public HoaDon getObjByMa(String maHoaDon) {
        HoaDon obj = new HoaDon();
        String sql = "SELECT ID, MaHoaDon, IDKhangHang, IDNhanVien, IDVoucher, TenNguoiNhan, SdtNguoiNhan, DiaChiNguoiNhan,"
                + " PhiShip,TongTien, TienMat, TienChuyenKhoan, MaChuyenKhoan, HinhThuc, TrangThai, NgayTao, NgaySua, NguoiTao, NguoiSua, xoa FROM dbo.HoaDon WHERE MaHoaDon = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                obj.setID(rs.getInt("ID"));
                obj.setMaHoaDon(rs.getString("MaHoaDon"));
                obj.setNhanVien(nvRepo.getObj(rs.getString("IDNhanVien")));
                obj.setKhachHang(khRepo.getObj(rs.getString("IDKhangHang")));
                obj.setIDVoucher(rs.getInt("IDVoucher"));
                obj.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                obj.setSdtNguoiNhan(rs.getString("SdtNguoiNhan"));
                obj.setDiaChiNguoiNhan(rs.getString("DiaChiNguoiNhan"));
                obj.setPhiShip(rs.getString("PhiShip") != null ? new BigDecimal(rs.getString("PhiShip")) : BigDecimal.ZERO);
                obj.setTongTien(rs.getString("TongTien") != null ? new BigDecimal(rs.getString("TongTien")) : BigDecimal.ZERO);
                obj.setTienMat(rs.getString("TienMat") != null ? new BigDecimal(rs.getString("TienMat")) : BigDecimal.ZERO);
                obj.setTienChuyenKhoan(rs.getString("TienChuyenKhoan") != null ? new BigDecimal(rs.getString("TienChuyenKhoan")) : BigDecimal.ZERO);
                obj.setMaChuyenKhoan(rs.getString("MaChuyenKhoan"));
                obj.setHinhThuc(rs.getString("HinhThuc"));
                obj.setTrangThai(rs.getString("TrangThai"));
                obj.setNgayTao(rs.getDate("NgayTao"));
                obj.setNgaySua(rs.getDate("NgaySua"));
                obj.setNguoiTao(rs.getInt("NguoiTao"));
                obj.setNguoiSua(rs.getInt("NguoiSua"));
                obj.setXoa(rs.getInt("xoa"));
//                obj.setTrangthaicbb(rs.getInt("trangthaicbb"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public boolean add(HoaDon hd) {
        String sql = "INSERT INTO dbo.HoaDon(MaHoaDon,IDKhangHang,IDNhanVien,IDVoucher,TenNguoiNhan,SdtNguoiNhan,DiaChiNguoiNhan,"
                + "PhiShip,TongTien,TrangThai,NgayTao,NgaySua,NguoiTao,NguoiSua,xoa)"
                + "VALUES(?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?)";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHoaDon());
            if (hd.getKhachHang() != null) {
                ps.setInt(2, hd.getKhachHang().getID());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            if (hd.getNhanVien() != null) {
                ps.setInt(3, hd.getNhanVien().getID());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            ps.setNull(4, java.sql.Types.INTEGER);

            ps.setString(5, hd.getTenNguoiNhan());
            ps.setString(6, hd.getSdtNguoiNhan());
            ps.setString(7, hd.getDiaChiNguoiNhan());
            ps.setBigDecimal(8, hd.getPhiShip());
            ps.setBigDecimal(9, hd.getTongTien());
            ps.setString(10, hd.getTrangThai());
            ps.setDate(11, new java.sql.Date(hd.getNgayTao().getTime()));
            ps.setDate(12, new java.sql.Date(hd.getNgaySua().getTime()));
            ps.setInt(13, hd.getNguoiTao());
            ps.setInt(14, hd.getNguoiSua());
            ps.setInt(15, hd.getXoa());
//            ps.setInt(16, hd.getTrangthaicbb());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String id, HoaDon hd) {
        String sql = "UPDATE dbo.HoaDon\n"
                + "SET MaHoaDon= ?,IDKhangHang= ?,IDNhanVien= ?,IDVoucher= ?,TenNguoiNhan= ?,SdtNguoiNhan= ?,DiaChiNguoiNhan= ?\n"
                + ",PhiShip= ?,TongTien= ?, TienMat = ?, TienChuyenKhoan = ?, MaChuyenKhoan = ?, HinhThuc = ?,  TrangThai= ?,NgayTao= ?,NgaySua= ?,NguoiTao= ?,NguoiSua= ?,xoa= ?, NgayThanhToan = ?  WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHoaDon());
            if (hd.getKhachHang() != null) {
                ps.setInt(2, hd.getKhachHang().getID());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            if (hd.getNhanVien()!= null) {
                ps.setInt(3, hd.getNhanVien().getID());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            ps.setNull(4, java.sql.Types.INTEGER);
            ps.setString(5, hd.getTenNguoiNhan());
            ps.setString(6, hd.getSdtNguoiNhan());
            ps.setString(7, hd.getDiaChiNguoiNhan());
            ps.setBigDecimal(8, hd.getPhiShip());
            ps.setBigDecimal(9, hd.getTongTien());
            ps.setBigDecimal(10, hd.getTienMat());
            ps.setBigDecimal(11, hd.getTienChuyenKhoan());
            ps.setString(12, hd.getMaChuyenKhoan());
            ps.setString(13, hd.getHinhThuc());
            ps.setString(14, hd.getTrangThai());
            ps.setDate(15, new java.sql.Date(hd.getNgayTao().getTime()));
            ps.setDate(16, new java.sql.Date(hd.getNgaySua().getTime()));
            ps.setInt(17, hd.getNguoiTao());
            ps.setInt(18, hd.getNguoiSua());
            ps.setInt(19, hd.getXoa());
//            ps.setInt(16, hd.getTrangthaicbb());
            ps.setDate(20, new java.sql.Date(new Date().getTime()));
            ps.setString(21, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
