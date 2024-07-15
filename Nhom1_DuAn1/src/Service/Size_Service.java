/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Size;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class Size_Service {
        
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Size> getAll_Size() {
        sql = " Select ID, MaSize, TenSize from Size  ORDER BY ID DESC";
        List<Size> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaSize");
                String tenSP = rs.getString("TenSize");
                
                Size sp = new Size();
                sp.setId(id);
                sp.setMaSize(maSP);
                sp.setTenSize(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
       public int them_Size(Size sp) {
        sql = " insert into Size(MaSize,TenSize) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSize());
            ps.setObject(2, sp.getTenSize());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua_Size(Size sp, String ma) {
        sql = " update Size set TenSize = ? where MaSize = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSize());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public int Xoa_Size(String ma) {
        sql = " Delete from Size where MaSize = ?";
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
