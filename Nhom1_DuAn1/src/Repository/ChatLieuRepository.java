/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChatLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ChatLieuRepository {
    public ChatLieu getObj(String id){
       ChatLieu cl = new ChatLieu();
       String sql = "SELECT * FROM dbo.ChatLieu WHERE ID = ?";
       try(Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cl.setId(Integer.parseInt(rs.getString(1)));
                cl.setMaChatLieu(rs.getString(2));             
                cl.setTenChatLieu(rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return cl;
         
    }
        
}
