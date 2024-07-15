/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIGABYTE
 */
public class SoNgan {
    private int id;
    private String maSoNgan,tenSoNgan;

    public SoNgan() {
    }

    public SoNgan(int id, String maSoNgan, String tenSoNgan) {
        this.id = id;
        this.maSoNgan = maSoNgan;
        this.tenSoNgan = tenSoNgan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSoNgan() {
        return maSoNgan;
    }

    public void setMaSoNgan(String maSoNgan) {
        this.maSoNgan = maSoNgan;
    }

    public String getTenSoNgan() {
        return tenSoNgan;
    }

    public void setTenSoNgan(String tenSoNgan) {
        this.tenSoNgan = tenSoNgan;
    }

    @Override
    public String toString() {
        return tenSoNgan;
    }
    
    
}
