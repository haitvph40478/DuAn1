/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GIGABYTE
 */
public class SanPhamChiTiet {
    private Integer id;
    private String maSPCT;
    private SanPham sanpham;
    private MauSac mausac;
    private ChatLieu chatlieu;
    private SoNgan songan;
    private Size size;
    private QuaiDeo quaideo;
    private Hang hang;
    private double gia;
    private int soluong;
    private String tinhTrang;

    public SanPhamChiTiet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SanPhamChiTiet(Integer id, String maSPCT, SanPham sanpham, MauSac mausac, ChatLieu chatlieu, SoNgan songan, Size size, QuaiDeo quaideo, Hang hang, double gia, int soluong, String tinhTrang) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.sanpham = sanpham;
        this.mausac = mausac;
        this.chatlieu = chatlieu;
        this.songan = songan;
        this.size = size;
        this.quaideo = quaideo;
        this.hang = hang;
        this.gia = gia;
        this.soluong = soluong;
        this.tinhTrang = tinhTrang;
    }

    public SanPhamChiTiet(String maSPCT, SanPham sanpham, MauSac mausac, ChatLieu chatlieu, SoNgan songan, Size size, QuaiDeo quaideo, Hang hang, double gia, int soluong, String tinhTrang) {
        this.maSPCT = maSPCT;
        this.sanpham = sanpham;
        this.mausac = mausac;
        this.chatlieu = chatlieu;
        this.songan = songan;
        this.size = size;
        this.quaideo = quaideo;
        this.hang = hang;
        this.gia = gia;
        this.soluong = soluong;
        this.tinhTrang = tinhTrang;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public MauSac getMausac() {
        return mausac;
    }

    public void setMausac(MauSac mausac) {
        this.mausac = mausac;
    }

    public ChatLieu getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(ChatLieu chatlieu) {
        this.chatlieu = chatlieu;
    }

    public SoNgan getSongan() {
        return songan;
    }

    public void setSongan(SoNgan songan) {
        this.songan = songan;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public QuaiDeo getQuaideo() {
        return quaideo;
    }

    public void setQuaideo(QuaiDeo quaideo) {
        this.quaideo = quaideo;
    }

    public Hang getHang() {
        return hang;
    }

    public void setHang(Hang hang) {
        this.hang = hang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
