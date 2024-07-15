/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class ThongKeView {
    private String thang,soLuong,doanThu;

    public ThongKeView() {
    }

    public ThongKeView(String thang, String soLuong, String doanThu) {
        this.thang = thang;
        this.soLuong = soLuong;
        this.doanThu = doanThu;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDoanThu() {
        return doanThu;
    }

    public void setDoanThu(String doanThu) {
        this.doanThu = doanThu;
    }
    
}
