/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIGABYTE
 */
public class MauSac {
    private int id;
    private String maMau,tenMau;

    public MauSac() {
    }

    public MauSac(int id, String maMau, String tenMau) {
        this.id = id;
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return tenMau;
    }
    
    
}
