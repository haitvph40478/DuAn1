/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Hang;
import Model.MauSac;
import Repository.HangRepository;
import Repository.MauSacRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HangService {
    HangRepository hangRepo;

    public HangService() {
        hangRepo = new HangRepository();
    }
    
    public List<Hang> getAll(){
        return hangRepo.getAll();
    }
    
    public Hang getObj(String id){
        return hangRepo.getObj(id);
    }
}
