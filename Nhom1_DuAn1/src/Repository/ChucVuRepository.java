/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ChucVuRepository {
    public ChucVu getObj(String id){
        ChucVu cv = new ChucVu();
        String sql = "SELECT ID, MaCV, TenCV FROM dbo.ChucVu WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cv.setId(rs.getInt("ID"));
                cv.setMaCV(rs.getString("MaCV"));
                cv.setTenCV(rs.getString("TenCV"));
            }
        } catch (Exception e) {
        }
        
        return cv;
    }
    
}
