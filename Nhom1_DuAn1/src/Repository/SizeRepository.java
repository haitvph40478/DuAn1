/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SizeRepository {

    public List<Size> getAll() {
        List<Size> lst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.Size WHERE xoa IS null";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size obj = new Size();
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaSize(rs.getString(2));
                obj.setTenSize(rs.getString(3));
                lst.add(obj);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;

    }

    public Size getObj(String id) {
        Size obj = new Size();
        String sql = "SELECT * FROM dbo.Size WHERE ID = ?";
        try ( Connection conn = DBConnect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                obj.setId(Integer.parseInt(rs.getString(1)));
                obj.setMaSize(rs.getString(2));
                obj.setTenSize(rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

}
