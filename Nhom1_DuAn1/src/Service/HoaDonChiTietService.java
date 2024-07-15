/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDonChiTiet;
import Repository.HoaDonChiTietRepository;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietService {

    HoaDonChiTietRepository hdctRepo;

    public HoaDonChiTietService() {
        hdctRepo = new HoaDonChiTietRepository();
    }

    public List<HoaDonChiTiet> getAll() {
        return hdctRepo.getAll();
    }

    public List<HoaDonChiTiet> getAllByHoaDon(String idHd) {
        return hdctRepo.getAllByHoaDon(idHd);
    }

    public Boolean add(HoaDonChiTiet hdct) {
        return hdctRepo.add(hdct);
    }

    public Boolean update(String idHdct, HoaDonChiTiet hdct) {
        int soLuong = hdct.getSoLuong();
        BigDecimal giaTien = hdct.getGiaTien();
        BigDecimal thanhTien = giaTien.multiply(BigDecimal.valueOf(soLuong));
        hdct.setThanhTien(thanhTien);
        return hdctRepo.update(idHdct, hdct);
    }

    public Boolean delete(String idHdct) {
        return hdctRepo.delete(idHdct);
    }
}
