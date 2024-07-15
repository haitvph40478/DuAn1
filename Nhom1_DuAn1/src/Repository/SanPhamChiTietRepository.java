/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPhamChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietRepository {

    private SanPhamRepository spRepo;
    private MauSacRepository msRepo;
    private ChatLieuRepository clRepo;
    private SoNganRepository snRepo;
    private SizeRepository sizeRepo;
    private QuaiDeoRepository qdRepo;
    private HangRepository hangRepo;

    public SanPhamChiTietRepository() {
        this.spRepo = new SanPhamRepository();
        this.msRepo = new MauSacRepository();
        this.clRepo = new ChatLieuRepository();
        this.snRepo = new SoNganRepository();
        this.sizeRepo = new SizeRepository();
        this.qdRepo = new QuaiDeoRepository();
        this.hangRepo = new HangRepository();
    }

    public List<SanPhamChiTiet> getAll() {
        List<SanPhamChiTiet> lst = new ArrayList<>();
        String sql = "SELECT ID, MaSPCT,IDSanPham, IDMauSac, IDChatLieu, IDSoNgan, IDSize,IDQuaiDeo, IDNSX, Gia, SoLuong, TinhTrang  FROM dbo.SanPhamChiTiet";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamChiTiet ctsp = new SanPhamChiTiet();
                ctsp.setId(Integer.valueOf(rs.getString("ID")));
                ctsp.setMaSPCT(rs.getString("MaSPCT"));
                ctsp.setSanpham(spRepo.getObj(rs.getString("IDSanPham")));
                ctsp.setMausac(msRepo.getObj(rs.getString("IDMauSac")));
                ctsp.setChatlieu(clRepo.getObj(rs.getString("IDChatLieu")));
                ctsp.setSongan(snRepo.getObj(rs.getString("IDSoNgan")));
                ctsp.setSize(sizeRepo.getObj(rs.getString("IDSize")));
                ctsp.setQuaideo(qdRepo.getObj(rs.getString("IDQuaiDeo")));
                ctsp.setHang(hangRepo.getObj(rs.getString("IDNSX")));
                ctsp.setGia(Double.parseDouble(rs.getString("Gia")));
                ctsp.setSoluong(Integer.parseInt(rs.getString("SoLuong")));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                lst.add(ctsp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<SanPhamChiTiet> getAllByTinhTrang(String tinhTrang) {
        List<SanPhamChiTiet> lst = new ArrayList<>();
        String sql = "SELECT ID, MaSPCT,IDSanPham, IDMauSac, IDChatLieu, IDSoNgan, IDSize,IDQuaiDeo, IDNSX, Gia, SoLuong, TinhTrang  FROM dbo.SanPhamChiTiet WHERE TinhTrang = ? ";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tinhTrang);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamChiTiet ctsp = new SanPhamChiTiet();
                ctsp.setId(Integer.valueOf(rs.getString("ID")));
                ctsp.setMaSPCT(rs.getString("MaSPCT"));
                ctsp.setSanpham(spRepo.getObj(rs.getString("IDSanPham")));
                ctsp.setMausac(msRepo.getObj(rs.getString("IDMauSac")));
                ctsp.setChatlieu(clRepo.getObj(rs.getString("IDChatLieu")));
                ctsp.setSongan(snRepo.getObj(rs.getString("IDSoNgan")));
                ctsp.setSize(sizeRepo.getObj(rs.getString("IDSize")));
                ctsp.setQuaideo(qdRepo.getObj(rs.getString("IDQuaiDeo")));
                ctsp.setHang(hangRepo.getObj(rs.getString("IDNSX")));
                ctsp.setGia(Double.parseDouble(rs.getString("Gia")));
                ctsp.setSoluong(Integer.parseInt(rs.getString("SoLuong")));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                lst.add(ctsp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<SanPhamChiTiet> getAllByTenAndTinhTrang(String ten, String tinhTrang) {
        List<SanPhamChiTiet> lst = new ArrayList<>();
        String sql = "SELECT SanPhamChiTiet.ID , MaSPCT,IDSanPham, IDMauSac, IDChatLieu, IDSoNgan, IDSize,IDQuaiDeo, IDHang, Gia, SoLuong, TinhTrang   FROM dbo.SanPhamChiTiet JOIN dbo.SanPham ON SanPham.ID = SanPhamChiTiet.IDSanPham WHERE dbo.SanPham.TenSP LIKE ? AND TinhTrang = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, tinhTrang);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamChiTiet ctsp = new SanPhamChiTiet();
                ctsp.setId(Integer.valueOf(rs.getString("ID")));
                ctsp.setMaSPCT(rs.getString("MaSPCT"));
                ctsp.setSanpham(spRepo.getObj(rs.getString("IDSanPham")));
                ctsp.setMausac(msRepo.getObj(rs.getString("IDMauSac")));
                ctsp.setChatlieu(clRepo.getObj(rs.getString("IDChatLieu")));
                ctsp.setSongan(snRepo.getObj(rs.getString("IDSoNgan")));
                ctsp.setSize(sizeRepo.getObj(rs.getString("IDSize")));
                ctsp.setQuaideo(qdRepo.getObj(rs.getString("IDQuaiDeo")));
                ctsp.setHang(hangRepo.getObj(rs.getString("IDHang")));
                ctsp.setGia(Double.parseDouble(rs.getString("Gia")));
                ctsp.setSoluong(Integer.parseInt(rs.getString("SoLuong")));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                lst.add(ctsp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<SanPhamChiTiet> getAllByTenAndTinhTrangAndCombobox(String ten, String size, String mauSac, String hang, String tinhTrang) {
        List<SanPhamChiTiet> lst = new ArrayList<>();
        String sql = "SELECT SanPhamChiTiet.ID , MaSPCT,IDSanPham, IDMauSac, dbo.MauSac.TenMau, IDChatLieu, IDSoNgan, IDSize,IDQuaiDeo, IDHang, Gia, SoLuong, TinhTrang   FROM dbo.SanPhamChiTiet \n"
                + "JOIN dbo.SanPham ON SanPham.ID = SanPhamChiTiet.IDSanPham\n"
                + "JOIN dbo.Size ON Size.ID = SanPhamChiTiet.IDSize\n"
                + "JOIN dbo.MauSac ON MauSac.ID = SanPhamChiTiet.IDMauSac\n"
                + "JOIN dbo.Hang ON Hang.ID = SanPhamChiTiet.IDHang\n"
                + "WHERE (dbo.SanPham.TenSP LIKE ? AND dbo.Size.TenSize LIKE ? AND dbo.MauSac.TenMau LIKE ? AND dbo.Hang.TenHang LIKE ?)\n"
                + "AND TinhTrang = ? AND SoLuong > 0 AND SanPhamChiTiet.xoa = 0 ORDER BY ID DESC";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + size + "%");
            ps.setString(3, "%" + mauSac + "%");
            ps.setString(4, "%" + hang + "%");
            ps.setString(5, tinhTrang);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamChiTiet ctsp = new SanPhamChiTiet();
                ctsp.setId(Integer.valueOf(rs.getString("ID")));
                ctsp.setMaSPCT(rs.getString("MaSPCT"));
                ctsp.setSanpham(spRepo.getObj(rs.getString("IDSanPham")));
                ctsp.setMausac(msRepo.getObj(rs.getString("IDMauSac")));
                ctsp.setChatlieu(clRepo.getObj(rs.getString("IDChatLieu")));
                ctsp.setSongan(snRepo.getObj(rs.getString("IDSoNgan")));
                ctsp.setSize(sizeRepo.getObj(rs.getString("IDSize")));
                ctsp.setQuaideo(qdRepo.getObj(rs.getString("IDQuaiDeo")));
                ctsp.setHang(hangRepo.getObj(rs.getString("IDHang")));
                ctsp.setGia(Double.parseDouble(rs.getString("Gia")));
                ctsp.setSoluong(Integer.parseInt(rs.getString("SoLuong")));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));
                lst.add(ctsp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public SanPhamChiTiet getObj(String id) {
        SanPhamChiTiet ctsp = new SanPhamChiTiet();
        String sql = "SELECT ID, MaSPCT,IDSanPham, IDMauSac, IDChatLieu, IDSoNgan, IDSize,IDQuaiDeo, IDNSX, Gia, SoLuong, TinhTrang  FROM dbo.SanPhamChiTiet WHERE ID = ? ";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ctsp.setId(Integer.valueOf(rs.getString("ID")));
                ctsp.setMaSPCT(rs.getString("MaSPCT"));
                ctsp.setSanpham(spRepo.getObj(rs.getString("IDSanPham")));
                ctsp.setMausac(msRepo.getObj(rs.getString("IDMauSac")));
                ctsp.setChatlieu(clRepo.getObj(rs.getString("IDChatLieu")));
                ctsp.setSongan(snRepo.getObj(rs.getString("IDSoNgan")));
                ctsp.setSize(sizeRepo.getObj(rs.getString("IDSize")));
                ctsp.setQuaideo(qdRepo.getObj(rs.getString("IDQuaiDeo")));
                ctsp.setHang(hangRepo.getObj(rs.getString("IDNSX")));
                ctsp.setGia(Double.parseDouble(rs.getString("Gia")));
                ctsp.setSoluong(Integer.parseInt(rs.getString("SoLuong")));
                ctsp.setTinhTrang(rs.getString("TinhTrang"));

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsp;
    }

    public Boolean update(String id, SanPhamChiTiet spct) {
        String sql = "UPDATE dbo.SanPhamChiTiet\n"
                + "SET SoLuong = ?\n"
                + "WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, spct.getSoluong());
            ps.setString(2, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
