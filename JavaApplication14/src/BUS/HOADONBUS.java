/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.HOADONDAO;
import DTO.HOADONDTO;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class HOADONBUS {
    public static ArrayList<HOADONDTO> dshd;
    public void doc(){
        HOADONDAO dao=new HOADONDAO();
        dshd=dao.Doc();
    }
    public boolean sua(HOADONDTO dto) throws Exception{
        try{
            java.sql.Date s=java.sql.Date.valueOf(dto.getNGAYGD());
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày giao dịch không hợp lệ");
            return false;
        }
        int kt=0;
        for(HOADONDTO d: dshd){
            if(d.getMAHD().equals(dto.getMAHD()))
            {
                
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"mã hóa đơn không tồn tại");
            return false;
        }
        HOADONDAO dao=new HOADONDAO();
        if(dao.sua(dto)==false)
            return false;
        
        for(int i=0;i<dshd.size();++i){
            if(dshd.get(i).getMAHD().equals(dto.getMAHD()))
            {
                dshd.set(i, dto);
            }
        }
        
        return true;
    }
    public void sua2(HOADONDTO dto){
        HOADONDAO dao=new HOADONDAO();
        dao.sua2(dto);
    }
    public  boolean them(HOADONDTO dto) throws Exception{
        try{
            java.sql.Date s=java.sql.Date.valueOf(dto.getNGAYGD());
           
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày không hợp lệ");
            return false;
        }
        if(dto.getMAHD().equals("") || dto.getNGAYGD().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Vui lòng điển đầy đủ cả mã hd và ngày gd"); 
            return false;
        }
        for(HOADONDTO dto1: dshd){
            if(dto.getMAHD().equals(dto1.getMAHD())){
                JOptionPane.showMessageDialog(null,"MÃ HD đã tồn tại"); 
                return false;
            }
        }
        HOADONDAO dao=new HOADONDAO();
        if(dao.Them(dto)==false)
            return false;
                    
        dshd.add(dto);
        return true;
    }
    public boolean Xoa(HOADONDTO dto) throws Exception{
        HOADONDAO dao= new HOADONDAO();
        HOADONBUS bus=new HOADONBUS();
        if(dshd==null)
            doc();
        if(dao.Xoa(dto)==true){   
            return true;
        }
        return false;
    }
    public void xoavitrids(int i){
        dshd.remove(i);
    }
    public ArrayList timnangcao(String x,String y){
        ArrayList<HOADONDTO> tmp=new ArrayList<HOADONDTO>();
        try{
            double xx=Double.parseDouble(x);
            double yy=Double.parseDouble(y);
            if(dshd==null)
                doc();
            for(HOADONDTO hd: dshd){
                if(hd.getTONGTIEN()==null)
                    continue;
                double aa=Double.parseDouble(hd.getTONGTIEN());
                
                if(aa>=Double.parseDouble(x) && aa<=Double.parseDouble(y))
                    tmp.add(hd);
            }
            
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập khoảng sô ( 0 < xxx < 2 tỷ)");
        }
        return tmp;
    }
    
    public ArrayList thongkehdnvnam(){
        ArrayList a=new ArrayList();
        HOADONDAO dao=new HOADONDAO();
        a=dao.thongkehdnvnam();
        return a;
    }
    public ArrayList thongkehdspnvnam(){
        ArrayList a=new ArrayList();
        HOADONDAO dao=new HOADONDAO();
        a=dao.thongkehdspnvnam();
        return a;
    }
    public ArrayList thongkehd4tc(){
        ArrayList a=new ArrayList();
        HOADONDAO dao=new HOADONDAO();
        a=dao.thongkehd4tc();
        return a;
    }
    public void report(){
        HOADONDAO dao=new HOADONDAO();
        dao.report();
    }
}
