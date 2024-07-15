/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChatLieu;
import Model.Hang;
import Model.MauSac;
import Model.QuaiDeo;
import Model.SanPham;
import Model.SanPhamChiTiet;
import Model.Size;
import Model.SoNgan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIGABYTE
 */
public class SanPhamChiTiet_Service {

    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SanPhamChiTiet> getAll_SanPhamChiTiet() {
        sql = " select MaSPCT,Sanpham.ID as'idSanPham',TenSP, MauSac.ID as'idMauSac',TenMau,\n"
                + "		ChatLieu.ID as'idChatLieu',TenChatLieu,SoNgan.ID as'idSoNgan', TenSoNgan,\n"
                + "		Size.ID as'idSize',TenSize, QuaiDeo.ID as'idQuaiDeo',TenQuaiDeo,\n"
                + "		Hang.ID as'idHang', TenHang,Gia, SanPhamChiTiet.SoLuong as'SoLuong', SanPhamChiTiet.TinhTrang as'TinhTrang' from SanPhamChiTiet\n"
                + "join SanPham on SanPham.ID = SanPhamChiTiet.IDSanPham\n"
                + "join MauSac on SanPhamChiTiet.IDMauSac = MauSac.ID\n"
                + "join Hang on SanPhamChiTiet.IDHang = Hang.ID\n"
                + "join QuaiDeo on SanPhamChiTiet.IDQuaiDeo = QuaiDeo.ID\n"
                + "join Size on SanPhamChiTiet.IDSize = Size.ID\n"
                + "join ChatLieu on SanPhamChiTiet.IDChatLieu= ChatLieu.ID\n"
                + "join SoNgan on SanPhamChiTiet.IDSoNgan = SoNgan.ID WHERE SanPhamChiTiet.xoa = 0 ORDER BY SanPhamChiTiet.ID DESC";
        List<SanPhamChiTiet> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idSP = rs.getInt("idSanPham");
                int idMS = rs.getInt("idMauSac");
                int idCL = rs.getInt("idChatLieu");
                int idSN = rs.getInt("idSoNgan");
                int idSZ = rs.getInt("idSize");
                int idQD = rs.getInt("idQuaiDeo");
                int idHG = rs.getInt("idHang");

                String maspct = rs.getString("MaSPCT");
                String masan = rs.getString("TenSP");
                String mamau = rs.getString("TenMau");
                String machat = rs.getString("TenChatLieu");
                String maso = rs.getString("TenSoNgan");
                String masize = rs.getString("TenSize");
                String maquai = rs.getString("TenQuaiDeo");
                String mahang = rs.getString("TenHang");
                double gia = rs.getDouble("Gia");
                int sol = rs.getInt("SoLuong");
                String tt = rs.getString("TinhTrang");

                SanPham sp = new SanPham();
                sp.setId(idSP);
                sp.setTenSP(masan);

                MauSac ms = new MauSac();
                ms.setId(idMS);
                ms.setTenMau(mamau);

                ChatLieu cl = new ChatLieu();
                cl.setId(idCL);
                cl.setTenChatLieu(machat);

                SoNgan sn = new SoNgan();
                sn.setId(idSN);
                sn.setTenSoNgan(maso);

                Size sz = new Size();
                sz.setId(idSZ);
                sz.setTenSize(masize);

                QuaiDeo qd = new QuaiDeo();
                qd.setId(idQD);
                qd.setTenQuaiDeo(maquai);

                Hang h = new Hang();
                h.setId(idHG);
                h.setTenHang(mahang);

                SanPhamChiTiet cc = new SanPhamChiTiet(maspct, sp, ms, cl, sn, sz, qd, h, gia, sol, tt);
                list.add(cc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer Them_SanPhamChiTiet(SanPhamChiTiet maSPCT) {
        sql = " insert into SanPhamChiTiet(MaSPCT ,IDSanPham,IDMauSac,IDChatLieu,IDSoNgan,IDSize,IDQuaiDeo,IDHang,Gia,SoLuong,TinhTrang, xoa) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maSPCT.getMaSPCT());
            Integer idMaSP = null;
            if (maSPCT.getSanpham() != null) {
                idMaSP = maSPCT.getSanpham().getId();
            }
            ps.setInt(2, idMaSP);

            Integer idMauSac = null;
            if (maSPCT.getMausac() != null) {
                idMauSac = maSPCT.getMausac().getId();
            }
            ps.setInt(3, idMauSac);

            Integer idchatlieu = null;
            if (maSPCT.getChatlieu() != null) {
                idchatlieu = maSPCT.getChatlieu().getId();
            }
            ps.setInt(4, idchatlieu);

            Integer idsongan = null;
            if (maSPCT.getSongan() != null) {
                idsongan = maSPCT.getSongan().getId();
            }
            ps.setInt(5, idsongan);

            Integer idsize = null;
            if (maSPCT.getSize() != null) {
                idsize = maSPCT.getSize().getId();
            }
            ps.setInt(6, idsize);

            Integer idQuaiDeo = null;
            if (maSPCT.getQuaideo() != null) {
                idQuaiDeo = maSPCT.getQuaideo().getId();
            }
            ps.setInt(7, idQuaiDeo);

            Integer idhang = null;
            if (maSPCT.getHang() != null) {
                idhang = maSPCT.getHang().getId();
            }
            ps.setInt(8, idhang);

            ps.setDouble(9, maSPCT.getGia());
            ps.setInt(10, maSPCT.getSoluong());
            ps.setString(11, "Đang Bán");
            ps.setInt(12, 0);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer Sua_SanPhamChiTiet(SanPhamChiTiet maSPCT, String ma) {
        sql = "update SanPhamChiTiet set IDSanPham = ?,IDMauSac =?,IDChatLieu = ?,IDSoNgan = ?,IDSize = ?,IDQuaiDeo = ?,IDHang = ?,Gia = ?,SoLuong= ?, TinhTrang = ? where MaSPCT = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            Integer idMaSP = null;
            if (maSPCT.getSanpham() != null) {
                idMaSP = maSPCT.getSanpham().getId();
            }
            ps.setInt(1, idMaSP);

            Integer idMauSac = null;
            if (maSPCT.getMausac() != null) {
                idMauSac = maSPCT.getMausac().getId();
            }
            ps.setInt(2, idMauSac);

            Integer idchatlieu = null;
            if (maSPCT.getChatlieu() != null) {
                idchatlieu = maSPCT.getChatlieu().getId();
            }
            ps.setInt(3, idchatlieu);

            Integer idsongan = null;
            if (maSPCT.getSongan() != null) {
                idsongan = maSPCT.getSongan().getId();
            }
            ps.setInt(4, idsongan);

            Integer idsize = null;
            if (maSPCT.getSize() != null) {
                idsize = maSPCT.getSize().getId();
            }
            ps.setInt(5, idsize);

            Integer idQuaiDeo = null;
            if (maSPCT.getQuaideo() != null) {
                idQuaiDeo = maSPCT.getQuaideo().getId();
            }
            ps.setInt(6, idQuaiDeo);

            Integer idhang = null;
            if (maSPCT.getHang() != null) {
                idhang = maSPCT.getHang().getId();
            }
            ps.setInt(7, idhang);

            ps.setDouble(8, maSPCT.getGia());
            ps.setInt(9, maSPCT.getSoluong());
            ps.setString(10, maSPCT.getTinhTrang());
            ps.setString(11, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Integer Xoa_SanPhamChiTiet(String ma) {
        sql = "UPDATE dbo.SanPhamChiTiet SET xoa = 1 WHERE MaSPCT = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public List<SanPhamChiTiet> getAll_CTSP1() {
        sql = " select MaSPCT,Sanpham.ID as'idSanPham',TenSP, MauSac.ID as'idMauSac',TenMau,\n"
                + "		ChatLieu.ID as'idChatLieu',TenChatLieu,SoNgan.ID as'idSoNgan', TenSoNgan,\n"
                + "		Size.ID as'idSize',TenSize, QuaiDeo.ID as'idQuaiDeo',TenQuaiDeo,\n"
                + "		Hang.ID as'idHang', TenHang,Gia, SanPhamChiTiet.SoLuong as'SoLuong', SanPhamChiTiet.TinhTrang as'TinhTrang' from SanPhamChiTiet\n"
                + "join SanPham on SanPham.ID = SanPhamChiTiet.IDSanPham\n"
                + "join MauSac on SanPhamChiTiet.IDMauSac = MauSac.ID\n"
                + "join Hang on SanPhamChiTiet.IDHang = Hang.ID\n"
                + "join QuaiDeo on SanPhamChiTiet.IDQuaiDeo = QuaiDeo.ID\n"
                + "join Size on SanPhamChiTiet.IDSize = Size.ID\n"
                + "join ChatLieu on SanPhamChiTiet.IDChatLieu= ChatLieu.ID\n"
                + "join SoNgan on SanPhamChiTiet.IDSoNgan = SoNgan.ID\n"
                + "where MaSP = 'SP001'";
        List<SanPhamChiTiet> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idSP = rs.getInt("idSanPham");
                int idMS = rs.getInt("idMauSac");
                int idCL = rs.getInt("idChatLieu");
                int idSN = rs.getInt("idSoNgan");
                int idSZ = rs.getInt("idSize");
                int idQD = rs.getInt("idQuaiDeo");
                int idHG = rs.getInt("idHang");

                String maspct = rs.getString("MaSPCT");
                String masan = rs.getString("TenSP");
                String mamau = rs.getString("TenMau");
                String machat = rs.getString("TenChatLieu");
                String maso = rs.getString("TenSoNgan");
                String masize = rs.getString("TenSize");
                String maquai = rs.getString("TenQuaiDeo");
                String mahang = rs.getString("TenHang");
                double gia = rs.getDouble("Gia");
                int sol = rs.getInt("SoLuong");
                String tt = rs.getString("TinhTrang");

                SanPham sp = new SanPham();
                sp.setId(idSP);
                sp.setTenSP(masan);

                MauSac ms = new MauSac();
                ms.setId(idMS);
                ms.setTenMau(mamau);

                ChatLieu cl = new ChatLieu();
                cl.setId(idCL);
                cl.setTenChatLieu(machat);

                SoNgan sn = new SoNgan();
                sn.setId(idSN);
                sn.setTenSoNgan(maso);

                Size sz = new Size();
                sz.setId(idSZ);
                sz.setTenSize(masize);

                QuaiDeo qd = new QuaiDeo();
                qd.setId(idQD);
                qd.setTenQuaiDeo(maquai);

                Hang h = new Hang();
                h.setId(idHG);
                h.setTenHang(mahang);

                SanPhamChiTiet cc = new SanPhamChiTiet(maspct, sp, ms, cl, sn, sz, qd, h, gia, sol, tt);
                list.add(cc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
