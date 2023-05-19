/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.GIAMGIADAO;
import DTO.GIAMGIADTO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class GIAMGIABUS {
    public static ArrayList<GIAMGIADTO> dsgg=new ArrayList<>();
    public boolean them(GIAMGIADTO ggdto) throws SQLException{
        GIAMGIADAO ggdao1=new GIAMGIADAO();
        if(dsgg==null)
            dsgg=ggdao1.Doc();
        
        for(int i=0;i<dsgg.size();i++){
          
            if(ggdto.getMASP().equals(dsgg.get(i).getMASP())){
                JOptionPane.showMessageDialog(null,"MASP đã tồn tại");
                return false;    
            }
        }
        if(ggdto.getMAGG().equals("") || ggdto.getMASP().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Không được để MASP hoặc MAGG rỗng");
            return false;
        }
        
        GIAMGIADAO ggdao=new GIAMGIADAO();
         int ktngay=0;
        try{
            Date s=Date.valueOf(ggdto.getNGBD());
            Date s1=Date.valueOf(ggdto.getNGKT());
            ktngay=1;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Định dạng ngày bắt đầu hoặc ngày kết thúc không hợp lệ");
            return false;
        }
        if(ggdto.getNGBD().compareTo(ggdto.getNGKT())>0)
        {
            JOptionPane.showMessageDialog(null,"Ngày bắt đầu phải trước ngày kết thúc");
            return false;
        }
        if(ggdao.Them(ggdto)==false)
            return false;
        dsgg.add(ggdto);
        return true;
    }
    
    public boolean xoa(GIAMGIADTO ggdto) throws SQLException{
        GIAMGIADAO data= new GIAMGIADAO();
        GIAMGIABUS bus=new GIAMGIABUS();
        if(GIAMGIABUS.dsgg==null)        
            bus.hienthi();
        
        if(data.xoa(ggdto)==true){   
            return true;
        }
        return false;
    }
    public boolean sua(GIAMGIADTO ggdto) throws SQLException{
        GIAMGIADAO ggdao=new GIAMGIADAO();
        int co=0;
        for(GIAMGIADTO gg: dsgg)
            if(gg.getMAGG().equals(ggdto.getMAGG()))
            {
                co=1;
                gg.setMAGG(ggdto.getMAGG());
                gg.setMASP(ggdto.getMASP());
                gg.setPHANTRAM(ggdto.getPHANTRAM());
                gg.setNGBD(ggdto.getNGBD());
                gg.setNGKT(ggdto.getNGKT());                
                break;
            }
        if(co==0) return false;
        return ggdao.sua(ggdto);
    }
    public void hienthi(){
        GIAMGIADAO ggdao=new GIAMGIADAO();
        if (dsgg==null) dsgg=new ArrayList<GIAMGIADTO>();
        dsgg=ggdao.Doc();        
        
    }
    public ArrayList tknc(String MASP, String MAGG){
        ArrayList lstk=new ArrayList();        
        for(GIAMGIADTO gg: GIAMGIABUS.dsgg)
        {
            if(gg.getMASP().toUpperCase().indexOf(MASP.toUpperCase())!=-1 && gg.getMAGG().toUpperCase().indexOf(MAGG.toUpperCase())!=-1 )
                lstk.add(gg);                
        }
        return lstk;
    }
    public void xoa2(GIAMGIADTO a){
        hienthi();
        for(int i=0;i<dsgg.size();++i){
            if(dsgg.get(i).getMASP().equals(a.getMASP()))
            {
                dsgg.remove(i);
                return;
            }
        }
    }
}
