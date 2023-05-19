/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.PHIEUNHAPHANGDAO;
import DTO.PHIEUNHAPHANGDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class PHIEUNHAPHANGBUS {
    public static ArrayList<PHIEUNHAPHANGDTO> dspnh;
    public void doc(){
        PHIEUNHAPHANGDAO dao=new PHIEUNHAPHANGDAO();
        dspnh=dao.Doc();
    }
    public  boolean them(PHIEUNHAPHANGDTO dto) throws Exception{
        
        doc();
        if(dto.getMAPNH().equals("") || dto.getNGAYNHAP().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng điển đầy đủ cả mã pnh và ngày nhập"); 
            return false;
        }
        try{
            java.sql.Date s=java.sql.Date.valueOf(dto.getNGAYNHAP());
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày không hợp lệ");
            return false;
        }
        for(PHIEUNHAPHANGDTO dto1: dspnh){
            if(dto.getMAPNH().equals(dto1.getMAPNH())){
                JOptionPane.showMessageDialog(null,"MÃ PNH đã tồn tại"); 
                return false;
            }
        }
        PHIEUNHAPHANGDAO dao=new PHIEUNHAPHANGDAO();
        if(dao.Them(dto)==false)
            return false;
                    
        dspnh.add(dto);
        return true;
    }
    public boolean sua(PHIEUNHAPHANGDTO dto) throws Exception{
        
        doc();
        try{
            java.sql.Date s=java.sql.Date.valueOf(dto.getNGAYNHAP());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày nhập không hợp lệ");
            return false;
        }
        int kt=0;
        for(PHIEUNHAPHANGDTO d: dspnh){
            if(d.getMAPNH().equals(dto.getMAPNH()))
            {
                
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"mã hóa đơn không tồn tại");
            return false;
        }
        PHIEUNHAPHANGDAO dao=new PHIEUNHAPHANGDAO();
        if(dao.sua(dto)==false)
            return false;
        
        for(int i=0;i<dspnh.size();++i){
            if(dspnh.get(i).getMAPNH().equals(dto.getMAPNH()))
            {
                dspnh.set(i, dto);
            }
        }
        
        return true;
    }
    public boolean Xoa(PHIEUNHAPHANGDTO dto) throws Exception{
        
        doc();
        int kt=0;
        for(PHIEUNHAPHANGDTO dto1: dspnh){
            if(dto.getMAPNH().equals(dto1.getMAPNH())){
                kt=1;
                break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null, "Mã PN ko tồn tại để xóa");
            return false;
        }
        
        PHIEUNHAPHANGDAO dao= new PHIEUNHAPHANGDAO();
        
        if(dao.Xoa(dto)==true){   
            return true;
        }
        return false;
    }
    public void xoavitrids(int i){
        dspnh.remove(i);
    }
    public void sua2(PHIEUNHAPHANGDTO dto){
        try {
            PHIEUNHAPHANGDAO dao=new PHIEUNHAPHANGDAO();
            dao.sua2(dto);
        } catch (SQLException ex) {
            Logger.getLogger(PHIEUNHAPHANGBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public PHIEUNHAPHANGDTO tim(String ma){
        for(PHIEUNHAPHANGDTO d: dspnh){
            if(d.getMANCC().equalsIgnoreCase(ma))
                return d;
        }
        return null;
    }
}
