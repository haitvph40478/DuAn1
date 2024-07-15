/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.QuaiDeo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class QuaiDeoRepository {
    public QuaiDeo getObj(String id){
       QuaiDeo obj = new QuaiDeo();
       String sql = "SELECT * FROM dbo.QuaiDeo WHERE ID = ?";
       try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaQuaiDeo(rs.getString(2));             
                obj.setTenQuaiDeo(rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return obj;
         
    }
        
}
