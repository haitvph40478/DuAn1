/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIGABYTE
 */
public class QuaiDeo {
    private int id ;
    private String maQuaiDeo, tenQuaiDeo;

    public QuaiDeo() {
    }

    public QuaiDeo(int id, String maQuaiDeo, String tenQuaiDeo) {
        this.id = id;
        this.maQuaiDeo = maQuaiDeo;
        this.tenQuaiDeo = tenQuaiDeo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaQuaiDeo() {
        return maQuaiDeo;
    }

    public void setMaQuaiDeo(String maQuaiDeo) {
        this.maQuaiDeo = maQuaiDeo;
    }

    public String getTenQuaiDeo() {
        return tenQuaiDeo;
    }

    public void setTenQuaiDeo(String tenQuaiDeo) {
        this.tenQuaiDeo = tenQuaiDeo;
    }

    @Override
    public String toString() {
        return tenQuaiDeo;
    }
    
    
}
