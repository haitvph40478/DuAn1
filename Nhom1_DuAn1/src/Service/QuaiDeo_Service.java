/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.QuaiDeo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class QuaiDeo_Service {
        
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<QuaiDeo> getAll_QuaiDeo() {
        sql = " Select ID, MaQuaiDeo, TenQuaiDeo from QuaiDeo  ORDER BY ID DESC";
        List<QuaiDeo> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaQuaiDeo");
                String tenSP = rs.getString("TenQuaiDeo");
                
                QuaiDeo sp = new QuaiDeo();
                sp.setId(id);
                sp.setMaQuaiDeo(maSP);
                sp.setTenQuaiDeo(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public int them_QuaiDeo(QuaiDeo sp) {
        sql = " insert into QuaiDeo(MaQuaiDeo,TenQuaiDeo) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaQuaiDeo());
            ps.setObject(2, sp.getTenQuaiDeo());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua_QuaiDeo(QuaiDeo sp, String ma) {
        sql = " update QuaiDeo set TenQuaiDeo = ? where MaQuaiDeo = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenQuaiDeo());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public int Xoa_QuaiDeo(String ma) {
        sql = " Delete from QuaiDeo where MaQuaiDeo = ?";
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
