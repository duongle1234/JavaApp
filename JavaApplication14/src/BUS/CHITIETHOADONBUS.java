/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.CHITIETHOADONDAO;
import DTO.CHITIETHOADONDTO;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class CHITIETHOADONBUS {
    public static ArrayList<CHITIETHOADONDTO> dscthd;
    public void doc(){
        CHITIETHOADONDAO dao=new CHITIETHOADONDAO();
        dscthd=dao.Doc();
    }
    public boolean sua(CHITIETHOADONDTO dto) throws Exception{
        
        
        int kt=0;
        for(CHITIETHOADONDTO d: dscthd){
            if(d.getMAHD().equals(dto.getMAHD()) && d.getMASP().equals(dto.getMASP()))
            {
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"Cặp mã hóa đơn và mã sản phẩm không tồn tại");
            return false;
        }
        CHITIETHOADONDAO dao=new CHITIETHOADONDAO();
        if(dao.sua(dto)==false)
            return false;
        
        for(int i=0;i<dscthd.size();++i){
            if(dscthd.get(i).getMAHD().equals(dto.getMAHD()) && dscthd.get(i).getMASP().equals(dto.getMASP()))
            {
                dscthd.set(i, dto);
            }
        }
        
        return true;
    }
    public  boolean them(CHITIETHOADONDTO dto) throws Exception{
        if(dto.getMASP().equals("Chọn Mã SP")){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn mã sp");
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
        if(dto.getSOLUONG().equals("") )
        {
            JOptionPane.showMessageDialog(null,"Vui lòng nhập số lượng"); 
            return false;
        }
        for(CHITIETHOADONDTO dto1: dscthd){
            if(dto.getMAHD().equals(dto1.getMAHD()) && dto.getMASP().equals(dto1.getMASP())){
                JOptionPane.showMessageDialog(null,"Cặp MÃ hóa đơn và Mã sp đã tồn tại"); 
                return false;
            }
        }
        CHITIETHOADONDAO dao=new CHITIETHOADONDAO();
        if(dao.Them(dto)==false)
            return false;
                    
        dscthd.add(dto);
        return true;
    }
    public boolean Xoa(CHITIETHOADONDTO dto) throws Exception{
        CHITIETHOADONDAO dao= new CHITIETHOADONDAO();
        CHITIETHOADONBUS bus=new CHITIETHOADONBUS();
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
    public ArrayList thongkehdsp(){
        ArrayList a=new ArrayList();
        CHITIETHOADONDAO dao=new CHITIETHOADONDAO();
        a=dao.thongkehdsp();
        return a;
    }
}
