/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.MauSac;
import Model.MauSac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MauSacRepository {
     public List<MauSac> getAll() {
        List<MauSac> lst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.MauSac WHERE xoa IS null";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac obj = new MauSac();
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaMau(rs.getString(2));
                obj.setTenMau(rs.getString(3));
                lst.add(obj);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }
    
    public MauSac getObj(String id){
       MauSac ms = new MauSac();
       String sql = "SELECT ID, MaMau, TenMau FROM dbo.MauSac WHERE ID = ?";
       try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ms.setId(Integer.parseInt(rs.getString("ID")));
                ms.setMaMau(rs.getString("MaMau"));             
                ms.setTenMau(rs.getString("TenMau"));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ms;
         
    }
    
        
}
