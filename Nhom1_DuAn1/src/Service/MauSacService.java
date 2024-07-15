/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;
import Repository.MauSacRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MauSacService {
    MauSacRepository msRepo;

    public MauSacService() {
        msRepo = new MauSacRepository();
    }
    
    public List<MauSac> getAll(){
        return msRepo.getAll();
    }
    
    public MauSac getObj(String id){
        return msRepo.getObj(id);
    }
}
