/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KHACHHANGDAO;
import DTO.KHACHHANGDTO;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class KHACHHANGBUS {
    public static ArrayList<KHACHHANGDTO> dskhbus;

    public KHACHHANGBUS() {
    }
    public void doc() {
        KHACHHANGDAO data=new KHACHHANGDAO();
        if(dskhbus==null) 
            dskhbus=new ArrayList<KHACHHANGDTO>();
        dskhbus=data.doc();

  
    }
     public ArrayList tknc(String tenkh,String diachi,String sdt){
        ArrayList tkncl=new ArrayList();
        for(KHACHHANGDTO x:dskhbus)
        {
                if(x.getTENKH().toUpperCase().indexOf(tenkh.toUpperCase())!=-1 && x.getDIACHI().toUpperCase().indexOf(diachi.toUpperCase())!=-1 && x.getSDT().toUpperCase().indexOf(sdt.toUpperCase())!=-1) 
                    tkncl.add(x);
            
        }
        return tkncl;
        
    }
    public void them(KHACHHANGDTO kh) throws SQLException{
        
        if(kh.getMAKH().equals("")){
            JOptionPane.showMessageDialog(null,"MAKH không được để trống");
            return;
        }
        if( kh.getTENKH().equals("")){
            JOptionPane.showMessageDialog(null,"Tên khách hàng không được để trống");
            return;
        }
        KHACHHANGDAO data=new KHACHHANGDAO();
        if(dskhbus==null) 
            dskhbus=new ArrayList<KHACHHANGDTO>();
        dskhbus=data.doc();
        
        for(KHACHHANGDTO kh1 : dskhbus )
            if(kh1.getMAKH().equals(kh.getMAKH())){
                JOptionPane.showMessageDialog(null,"MAKH đã tồn tại");
                return;
            }
        KHACHHANGDAO dao=new KHACHHANGDAO();
        dao.them(kh);
        dskhbus.add(kh);
        JOptionPane.showMessageDialog(null,"Thêm thành công");
    }
    public void sua(KHACHHANGDTO kh) throws SQLException{
        if(kh.getMAKH().equals("")){
            JOptionPane.showMessageDialog(null,"MAKH không được để trống");
            return;
        }
        if( kh.getTENKH().equals("")){
            JOptionPane.showMessageDialog(null,"Tên khách hàng không được để trống");
            return;
        }
        KHACHHANGDAO data=new KHACHHANGDAO();
        if(dskhbus==null) 
            dskhbus=new ArrayList<KHACHHANGDTO>();
        dskhbus=data.doc();
        
        int pos=-1;
        for(int i=0;i<dskhbus.size();++i){
            if(dskhbus.get(i).getMAKH().equals(kh.getMAKH()))
            {
                KHACHHANGDAO dao=new KHACHHANGDAO();
                pos=i;
                dskhbus.get(i).setDIACHI(kh.getDIACHI());
                dskhbus.get(i).setTENKH(kh.getTENKH());
                dskhbus.get(i).setSDT(kh.getSDT());
                dao.sua(kh);
                break;
            }
        }
        if(pos==-1){
            JOptionPane.showMessageDialog(null,"Không tìm thấy MAKH");
            return;
        }
        
    }
    
    public void xoa(KHACHHANGDTO kh) throws SQLException{
        KHACHHANGDAO dao=new KHACHHANGDAO();
        dao.xoa(kh);
        for(int i=0;i<dskhbus.size();++i){
            if(dskhbus.get(i).getMAKH().equals(kh.getMAKH())){
                dskhbus.remove(i);
                return;
            }
        }
                
    }
    public KHACHHANGDTO timtheoma(String ma){
        if(dskhbus==null) 
            dskhbus=new ArrayList<KHACHHANGDTO>();
        KHACHHANGDAO data=new KHACHHANGDAO();
        dskhbus=data.doc();
        for(KHACHHANGDTO kh:dskhbus){
            if(kh.getMAKH().equals(ma)){
                return kh;
            }
        }
        return null;
    }

}
