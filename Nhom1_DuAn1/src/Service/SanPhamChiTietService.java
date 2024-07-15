/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPhamChiTiet;
import Repository.SanPhamChiTietRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamChiTietService {

    private SanPhamChiTietRepository ctspRepo;

    public SanPhamChiTietService() {
        ctspRepo = new SanPhamChiTietRepository();
    }

    public List<SanPhamChiTiet> getAll() {
        return ctspRepo.getAll();
    }
    public SanPhamChiTiet getObj(String id) {
        return ctspRepo.getObj(id);
    }
    public List<SanPhamChiTiet> getAllByTinhTrang(String tinhTrang) {
        return ctspRepo.getAllByTinhTrang(tinhTrang);
    }
    
    public List<SanPhamChiTiet> getAllByTenAndTinhTrang(String ten, String tinhTrang) {
        return ctspRepo.getAllByTenAndTinhTrang(ten, tinhTrang);
    }
    
    public List<SanPhamChiTiet> getAllByTenAndTinhTrangAndCombobox(String ten, String size, String mauSac, String hang, String tinhTrang) {
        return ctspRepo.getAllByTenAndTinhTrangAndCombobox(ten, size,mauSac,hang,tinhTrang);
    }
    
    public Boolean update(String id, SanPhamChiTiet spct){
        return ctspRepo.update(id, spct);
    }
}
