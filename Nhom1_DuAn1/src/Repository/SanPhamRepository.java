/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {
    public SanPham getObj(String id){
       SanPham sp = new SanPham();
       String sql = "SELECT ID , MaSP, TenSP FROM dbo.SanPham WHERE ID = ?";
       try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                sp.setId(Integer.parseInt(rs.getString("ID")));
                sp.setMaSP(rs.getString("MaSP"));             
                sp.setTenSP(rs.getString("TenSP"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return sp;
         
    }
        
}
