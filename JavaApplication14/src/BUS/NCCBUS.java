/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NCCDAO;
import DTO.NCCDTO;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NCCBUS {
    public static ArrayList<NCCDTO> dsnccbus;

    public NCCBUS() {
    }
    public void doc(){
        NCCDAO data=new NCCDAO();
        if(dsnccbus==null) 
            dsnccbus=new ArrayList<NCCDTO>();
        dsnccbus=data.doc();
  
    }
    public void them(NCCDTO kh) throws SQLException{
        
        if(kh.getMANCC().equals("")){
            JOptionPane.showMessageDialog(null,"MANCC không được để trống");
            return;
        }
        if( kh.getTENNCC().equals("")){
            JOptionPane.showMessageDialog(null,"Tên NCC không được để trống");
            return;
        }
        NCCDAO data=new NCCDAO();
        if(dsnccbus==null) 
            dsnccbus=new ArrayList<NCCDTO>();
        dsnccbus=data.doc();
        
        for(NCCDTO kh1 : dsnccbus )
            if(kh1.getMANCC().equals(kh.getMANCC())){
                JOptionPane.showMessageDialog(null,"MANCC đã tồn tại");
                return;
            }
        NCCDAO dao=new NCCDAO();
        dao.them(kh);
        dsnccbus.add(kh);
    }
    public void sua(NCCDTO kh) throws SQLException{
        if(kh.getMANCC().equals("")){
            JOptionPane.showMessageDialog(null,"MANCC không được để trống");
            return;
        }
        if( kh.getTENNCC().equals("")){
            JOptionPane.showMessageDialog(null,"Tên NCC không được để trống");
            return;
        }
        NCCDAO data=new NCCDAO();
        if(dsnccbus==null) 
            dsnccbus=new ArrayList<NCCDTO>();
        dsnccbus=data.doc();
        
        int pos=-1;
        for(int i=0;i<dsnccbus.size();++i){
            if(dsnccbus.get(i).getMANCC().equals(kh.getMANCC()))
            {
                NCCDAO dao=new NCCDAO();
                pos=i;
                dsnccbus.get(i).setTENNCC(kh.getTENNCC());
                dao.sua(kh);
                break;
            }
        }
        if(pos==-1){
            JOptionPane.showMessageDialog(null,"Không tìm thấy MAKH");
            return;
        }
        
    }
    
    public void xoa(NCCDTO kh) throws SQLException{
        NCCDAO dao=new NCCDAO();
        dao.xoa(kh);
    }
    public NCCDTO timtheoma(String ma){
        if(dsnccbus==null) 
            dsnccbus=new ArrayList<NCCDTO>();
        NCCDAO data=new NCCDAO();
        dsnccbus=data.doc();
        for(NCCDTO kh:dsnccbus){
            if(kh.getMANCC().equals(ma)){
                return kh;
            }
        }
        return null;
    }
    public ArrayList<NCCDTO> timnc(String ss)
    {
        ArrayList<NCCDTO> tmp= new ArrayList<NCCDTO>();
        for(NCCDTO x: dsnccbus){
            if(x.getTENNCC().toUpperCase().indexOf(ss.toUpperCase())!=-1)
                tmp.add(x);      
        }
        return tmp;
    };

   
}
