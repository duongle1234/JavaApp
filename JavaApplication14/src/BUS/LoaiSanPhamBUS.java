/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.LoaiSanPhamDAO;
import DTO.LoaiSanPhamDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi Hung
 */
public class LoaiSanPhamBUS {
    public static ArrayList<LoaiSanPhamDTO> loaisanpham;
    public void DocLoaiSanPham(){
        LoaiSanPhamDAO data= new LoaiSanPhamDAO();
        if(loaisanpham==null) 
            loaisanpham=new ArrayList();
        loaisanpham=data.DocLoaiSanPham();
    }
    public boolean ThemLoaiSanPham(LoaiSanPhamDTO lsp) throws SQLException{
        LoaiSanPhamDAO data=new LoaiSanPhamDAO();
        if(lsp.getMaloai()==null || lsp.getTenloai()==null){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ");
            return false;
        }
        
        if(loaisanpham==null)
            loaisanpham=data.DocLoaiSanPham();
        
        for(LoaiSanPhamDTO x: loaisanpham)
            if(x.getMaloai().equals(lsp.getMaloai())){
               JOptionPane.showMessageDialog(null,"MÃ sp đã tồn tại"); 
               return false;
            }
        data.Them(lsp);
        loaisanpham.add(lsp);
        return true;
    }
    public boolean XoaLoaiSanPham(LoaiSanPhamDTO lsp) throws SQLException{
        LoaiSanPhamDAO data= new LoaiSanPhamDAO();
        if(data.Xoa(lsp)==true){
            loaisanpham.remove(lsp);
            return true;
        }
        return false;
    }
    public boolean SuaLoaiSanPham(LoaiSanPhamDTO lsp) throws SQLException{
        LoaiSanPhamDAO data= new LoaiSanPhamDAO();
        if(data.Sua(lsp)==true)
            return true;
        return false;
    }   
}
