/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIGABYTE
 */
public class SanPham_Service {

    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SanPham> getAll_SanPham() {
        sql = " Select ID, MaSP, TenSP from SanPham";
        List<SanPham> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaSP");
                String tenSP = rs.getString("TenSP");
                
                SanPham sp = new SanPham();
                sp.setId(id);
                sp.setMaSP(maSP);
                sp.setTenSP(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int them(SanPham sp) {
        sql = " insert into SanPham(MaSP,TenSP) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(SanPham sp, String ma) {
        sql = " update SanPham set TenSP = ? where MaSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public List<SanPham> TimKiem_Ten(String tensp) {
        sql = " Select MaSP, TenSP from SanPham Where TenSP like ?";
        List<SanPham> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tensp + "%");
            rs = ps.executeQuery();

            while(rs.next()){
                String id = rs.getString("MaSP");
                String ten = rs.getString("TenSP");
                SanPham sp = new SanPham();
                sp.setMaSP(id);
                sp.setTenSP(ten);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
