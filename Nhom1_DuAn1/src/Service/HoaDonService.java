/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Repository.HoaDonRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonService {

    HoaDonRepository hdRepo;

    public HoaDonService() {
        hdRepo = new HoaDonRepository();
    }

    public List<HoaDon> getAll() {
        return hdRepo.getAll();
    }

    public List<HoaDon> getAllByTrangThai(String trangThai) {
        return hdRepo.getAllByTrangThai(trangThai);
    }

    public HoaDon getObj(String id) {
        return hdRepo.getObj(id);
    }

    public HoaDon getObjByMa(String maHd) {
        return hdRepo.getObjByMa(maHd);
    }

    public boolean add(HoaDon hd) {
        String maHd = "";
        List<HoaDon> lst = hdRepo.getAll();
        for (int i = 0; i < lst.size() + 1; i++) {
            maHd = "HD0" + i;
            if (hdRepo.getObjByMa(maHd).getMaHoaDon() == null) {
               hd.setMaHoaDon(maHd);
            }
        }
        System.out.println(maHd);
        hd.setNgayTao(new Date());
        hd.setNgaySua(new Date());
        hd.setTrangThai("0");
        return hdRepo.add(hd);
    }
    
    public boolean update(String id, HoaDon hd) {
        return hdRepo.update(id, hd);
    }
}
