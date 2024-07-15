/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Hang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class Hang_Service {
        
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Hang> getAll_Hang() {
        sql = " Select ID, MaHang, TenHang from Hang ORDER BY ID DESC";
        List<Hang> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaHang");
                String tenSP = rs.getString("TenHang");
                
                Hang sp = new Hang();
                sp.setId(id);
                sp.setMaHang(maSP);
                sp.setTenHang(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public int them_Hang(Hang sp) {
        sql = " insert into Hang(MaHang,TenHang) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaHang());
            ps.setObject(2, sp.getTenHang());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua_Hang(Hang sp, String ma) {
        sql = " update Hang set TenHang = ? where MaHang = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenHang());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public int Xoa_Hang(String ma) {
        sql = " Delete from Hang where MaHang = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
