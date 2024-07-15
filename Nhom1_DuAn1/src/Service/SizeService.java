/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Size;
import Repository.SizeRepository;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SizeService {
    SizeRepository sizeRepo;

    public SizeService() {
        sizeRepo = new SizeRepository();
    }
    
    public List<Size> getAll(){
        return sizeRepo.getAll();
    }
    
    public Size getObj(String id){
        return sizeRepo.getObj(id);
    }
}
