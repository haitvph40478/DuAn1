/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Hang;
import Model.Hang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HangRepository {
    public List<Hang> getAll() {
        List<Hang> lst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Hang WHERE xoa IS null";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hang obj = new Hang();
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaHang(rs.getString(2));
                obj.setTenHang(rs.getString(3));
                lst.add(obj);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }
    
    public Hang getObj(String id){
       Hang obj = new Hang();
       String sql = "SELECT * FROM dbo.Hang WHERE ID = ?";
       try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaHang(rs.getString(2));             
                obj.setTenHang(rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return obj;
         
    }
        
}
