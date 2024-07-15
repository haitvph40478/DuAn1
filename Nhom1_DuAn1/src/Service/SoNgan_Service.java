/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.SoNgan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class SoNgan_Service {
    
    Connection con = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SoNgan> getAll_SoNgan() {
        sql = " Select ID, MaSoNgan, TenSoNgan from SoNgan  ORDER BY ID DESC";
        List<SoNgan> list = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String maSP = rs.getString("MaSoNgan");
                String tenSP = rs.getString("TenSoNgan");
                
                SoNgan sp = new SoNgan();
                sp.setId(id);
                sp.setMaSoNgan(maSP);
                sp.setTenSoNgan(tenSP);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
       public int them_SoNgan(SoNgan sp) {
        sql = " insert into SoNgan(MaSoNgan,TenSoNgan) values(?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSoNgan());
            ps.setObject(2, sp.getTenSoNgan());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua_SoNgan(SoNgan sp, String ma) {
        sql = " update SoNgan set TenSoNgan = ? where MaSoNgan = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSoNgan());
            ps.setObject(2, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int Xoa_SoNgan(String ma) {
        sql = " Delete from SoNgan where MaSoNgan = ?";
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
