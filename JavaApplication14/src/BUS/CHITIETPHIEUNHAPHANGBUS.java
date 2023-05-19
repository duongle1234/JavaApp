/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.CHITIETPHIEUNHAPHANGDAO;
import DTO.CHITIETPHIEUNHAPHANGDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CHITIETPHIEUNHAPHANGBUS {
    public static ArrayList<CHITIETPHIEUNHAPHANGDTO> dscthd;
    public void doc(){
        CHITIETPHIEUNHAPHANGDAO dao=new CHITIETPHIEUNHAPHANGDAO();
        dscthd=dao.Doc();
    }
    public boolean sua(CHITIETPHIEUNHAPHANGDTO dto) throws Exception{
        
        
        int kt=0;
        for(CHITIETPHIEUNHAPHANGDTO d: dscthd){
            if(d.getMAPNH().equals(dto.getMAPNH()) && d.getMASP().equals(dto.getMASP()))
            {
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"Cặp mã PNH và mã sản phẩm không tồn tại");
            return false;
        }
        CHITIETPHIEUNHAPHANGDAO dao=new CHITIETPHIEUNHAPHANGDAO();
        if(dao.sua(dto)==false)
            return false;
        
        for(int i=0;i<dscthd.size();++i){
            if(dscthd.get(i).getMAPNH().equals(dto.getMAPNH()) && dscthd.get(i).getMASP().equals(dto.getMASP()))
            {
                dscthd.set(i, dto);
            }
        }
        
        return true;
    }
    public  boolean them(CHITIETPHIEUNHAPHANGDTO dto) throws Exception{
        if(dto.getMASP().equals("Chọn Mã SP")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn mã sp");
            return false;
        }
        
        if(dto.getSOLUONG().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng"); 
            return false;
        }
        if(dto.getDONGIA().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng"); 
            return false;
        }
        
        try{
            Integer.parseInt(dto.getSOLUONG());
            if(Integer.parseInt(dto.getSOLUONG())<1){
                JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng > 0");
                return false;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng là số");
            return false;
        }
        
        try{
            Integer.parseInt(dto.getDONGIA());
            if(Integer.parseInt(dto.getDONGIA())<1){
                JOptionPane.showMessageDialog(null,"Vui lòng nhập đơn giá > 0");
                return false;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đơn giá là số");
            return false;
        }
        
        
        for(CHITIETPHIEUNHAPHANGDTO dto1: dscthd){
            if(dto.getMAPNH().equals(dto1.getMAPNH()) && dto.getMASP().equals(dto1.getMASP())){
                JOptionPane.showMessageDialog(null,"Cặp MÃ PNH và Mã sp đã tồn tại"); 
                return false;
            }
        }
        CHITIETPHIEUNHAPHANGDAO dao=new CHITIETPHIEUNHAPHANGDAO();
        if(dao.Them(dto)==false)
            return false;
                    
        dscthd.add(dto);
        return true;
    }
    public boolean Xoa(CHITIETPHIEUNHAPHANGDTO dto) throws Exception{
        CHITIETPHIEUNHAPHANGDAO dao= new CHITIETPHIEUNHAPHANGDAO();
        CHITIETPHIEUNHAPHANGBUS bus=new CHITIETPHIEUNHAPHANGBUS();
        if(dscthd==null)
            doc();
        if(dao.Xoa(dto)==true){   
            return true;
        }
        return false;
    }
    public void xoavitrids(int i){
        dscthd.remove(i);
    }
    public String timtheoma(CHITIETPHIEUNHAPHANGDTO dto){
        if(dscthd==null)
            doc();
        for(CHITIETPHIEUNHAPHANGDTO x: dscthd){
            if(x.getMASP().equals(dto.getMASP()))
                return x.getSOLUONG();
        }
        return "0";
    }
   
}
