/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import Model.ChucVu;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu Hieu
 */
public class ChucVuRepo {
        Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    public List<ChucVu> getAll() {

        ArrayList<ChucVu> list = new ArrayList<>();
        sql = "select MaCV , TenCV  from ChucVu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String MaCV = rs.getString("MaCV");
                String TenCV = rs.getString("TenCV");
    
                ChucVu cv = new ChucVu();
                cv.setMaCV(MaCV);
                cv.setTenCV(TenCV);


                list.add(cv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    

}
