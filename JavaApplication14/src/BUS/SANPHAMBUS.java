/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SANPHAMDAO;
import DTO.LoaiSanPhamDTO;
import DTO.SANPHAMDTO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi Hung
 */
public class SANPHAMBUS {
    public static ArrayList<SANPHAMDTO> lssanpham;
    public void DocSanPham(){
        SANPHAMDAO data= new SANPHAMDAO();
        if(lssanpham==null) 
            lssanpham=new ArrayList();
        lssanpham=data.DocSanPham();
    }
    public boolean ThemSanPham(SANPHAMDTO sp) throws SQLException{
        SANPHAMDAO data=new SANPHAMDAO();
        if(sp.getMASP().equals("") || sp.getTENSP().equals("") || sp.getMALOAI().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ cả 3 thuộc tính mã sp, tên sp và mã loại sp");
            return false;
        }
        
        if(lssanpham==null)
            lssanpham=data.DocSanPham();
        
        for(SANPHAMDTO x: lssanpham)
            if(x.getMASP().equals(sp.getMASP())){
               JOptionPane.showMessageDialog(null,"MÃ sp đã tồn tại"); 
               return false;
            }
        
        int kt=0;
        LoaiSanPhamBUS lspbus=new LoaiSanPhamBUS();
        if(LoaiSanPhamBUS.loaisanpham==null)
            lspbus.DocLoaiSanPham();
        for(LoaiSanPhamDTO x:LoaiSanPhamBUS.loaisanpham){
            if(x.getMaloai().equals(sp.getMALOAI())){
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"MÃ loại sp không tồn tại"); 
               return false;
        }
        int ktngay=0;
        try{
            Date s=Date.valueOf(sp.getNGAYSX());
            ktngay=1;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày sản xuất không hợp lệ");
        }
        
        try{
            Integer.parseInt(sp.getSOLUONG());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
            
        }
        try{
            Integer.parseInt(sp.getDONGIA());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Đơn giá không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
            
        }
        if(ktngay==0)
            return false;
        if(data.Them(sp)==false)
            return false;
        lssanpham.add(sp);
        return true;
    }
    public boolean XoaSanPham(SANPHAMDTO sp) throws SQLException{
        SANPHAMDAO data= new SANPHAMDAO();
        SANPHAMBUS bus=new SANPHAMBUS();
        if(SANPHAMBUS.lssanpham==null)
            bus.DocSanPham();
        if(data.Xoa(sp)==true){   
            return true;
        }
        return false;
    }
    public boolean SuaSanPham(SANPHAMDTO sp) throws SQLException{
        SANPHAMDAO data= new SANPHAMDAO();
        if(sp.getMASP().equals("")){
            JOptionPane.showMessageDialog(null,"MASP không được để trống");
            return false;
        }
        if(sp.getTENSP().equals("")){
            JOptionPane.showMessageDialog(null,"Tên sản phẩm không được để trống");
            return false;
        }
        SANPHAMDAO spdao=new SANPHAMDAO();
        
        int kt=0;
        LoaiSanPhamBUS lspbus=new LoaiSanPhamBUS();
        if(LoaiSanPhamBUS.loaisanpham==null)
            lspbus.DocLoaiSanPham();
        for(LoaiSanPhamDTO x:LoaiSanPhamBUS.loaisanpham){
            if(x.getMaloai().equals(sp.getMALOAI())){
                kt=1;break;
            }
        }
        if(kt==0){
            JOptionPane.showMessageDialog(null,"MÃ loại sp không tồn tại"); 
               return false;
        }
        int ktngay=0;
        try{
            Date s=Date.valueOf(sp.getNGAYSX());
            ktngay=1;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"ngày sản xuất không hợp lệ");
        }
        
        if(ktngay==0)
            return false;
        
        try{
            Integer.parseInt(sp.getSOLUONG());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
            
        }
        try{
            Integer.parseInt(sp.getDONGIA());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Đơn giá không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
            
        }
                
        
        if(lssanpham==null) 
            lssanpham=new ArrayList<SANPHAMDTO>();
        lssanpham=spdao.DocSanPham();
        
        int pos=-1;
        for(int i=0;i<lssanpham.size();++i){
            if(lssanpham.get(i).getMASP().equals(sp.getMASP()))
            {
                SANPHAMDAO dao=new SANPHAMDAO();
                pos=i;
                lssanpham.get(i).setTENSP(sp.getTENSP());
                lssanpham.get(i).setSOLUONG(sp.getSOLUONG());
                lssanpham.get(i).setNGAYSX(sp.getNGAYSX());
                lssanpham.get(i).setDONGIA(sp.getDONGIA());
                lssanpham.get(i).setMALOAI(sp.getMALOAI());
                lssanpham.get(i).setHINHANH(sp.getHINHANH());
                dao.Sua(sp);
                break;
            }
        }
        if(pos==-1){
            JOptionPane.showMessageDialog(null,"Không tìm thấy MÃ SP");
            return false;
        }
        return true;
    }
    public void SuaSanPham2(SANPHAMDTO sp) throws SQLException{
        SANPHAMDAO data= new SANPHAMDAO();
        
        SANPHAMDAO spdao=new SANPHAMDAO();
        
        
        LoaiSanPhamBUS lspbus=new LoaiSanPhamBUS();
        if(LoaiSanPhamBUS.loaisanpham==null)
            lspbus.DocLoaiSanPham();                
        
        if(lssanpham==null) 
            lssanpham=new ArrayList<SANPHAMDTO>();
        lssanpham=spdao.DocSanPham();
        
        int pos=-1;
        for(int i=0;i<lssanpham.size();++i){
            if(lssanpham.get(i).getMASP().equals(sp.getMASP()))
            {
                SANPHAMDAO dao=new SANPHAMDAO();
                pos=i;
                lssanpham.get(i).setTENSP(sp.getTENSP());
                lssanpham.get(i).setSOLUONG(sp.getSOLUONG());
                lssanpham.get(i).setNGAYSX(sp.getNGAYSX());
                lssanpham.get(i).setDONGIA(sp.getDONGIA());
                lssanpham.get(i).setMALOAI(sp.getMALOAI());
                lssanpham.get(i).setHINHANH(sp.getHINHANH());
                dao.Sua2(sp);
                break;
            }
        }
        
    }
    public SANPHAMDTO timtheoma(String m){
        if(lssanpham==null) 
            lssanpham=new ArrayList<SANPHAMDTO>();
        SANPHAMDAO data=new SANPHAMDAO();
        lssanpham=data.DocSanPham();
        for(SANPHAMDTO kh:lssanpham){
            if(kh.getMASP().equals(m)){
                return kh;
            }
        }
        return null;
    }
    public ArrayList<SANPHAMDTO> timnangcao(String ten,String giamin,String giamax,String ngbd,String ngkt) throws ParseException{
        ArrayList<SANPHAMDTO> tmp=new ArrayList<SANPHAMDTO>();
        for(SANPHAMDTO x: lssanpham){
            int teni=x.getTENSP().toUpperCase().indexOf(ten.toUpperCase());
            int giai=-1;
            if(Integer.parseInt(giamin) <= Integer.parseInt(x.getDONGIA()) && Integer.parseInt(giamax)>= Integer.parseInt(x.getDONGIA())){
               giai=1;
            }
            int di=-1;

            Date date1=Date.valueOf(ngbd);
            Date date2=Date.valueOf(ngkt);
            Date date3=Date.valueOf(x.getNGAYSX());
            if(date3.compareTo(date1)>=0 && date3.compareTo(date2)<=0)
                di=1;
            
            if(di!=-1 && giai!=-1 && teni!=-1)
                tmp.add(x);
        }
        return tmp;
    }
    public void xoavitrids(int i){
        lssanpham.remove(i);
    }
    public ArrayList<SANPHAMDTO> thongke(){
        SANPHAMDAO dao=new SANPHAMDAO();
        return dao.thongke();
    }
}
