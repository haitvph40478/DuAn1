/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.ChatLieu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class ChatLieu_Service {
        
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<ChatLieu> getAll_ChatLieu() {
        sql = " Select ID, MaChatLieu, TenChatLieu from ChatLieu";
        List<ChatLieu> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaChatLieu");
                String tenSP = rs.getString("TenChatLieu");
                
                ChatLieu sp = new ChatLieu();
                sp.setId(id);
                sp.setMaChatLieu(maSP);
                sp.setTenChatLieu(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public int them_ChatLieu(ChatLieu sp) {
        sql = " insert into ChatLieu(MaChatLieu,TenChatLieu) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaChatLieu());
            ps.setObject(2, sp.getTenChatLieu());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(ChatLieu sp, String ma) {
        sql = " update ChatLieu set TenChatLieu = ? where MaChatLieu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenChatLieu());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public int Xoa_ChatLieu(String ma) {
        sql = " Delete from ChatLieu where MaChatLieu = ?";
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
