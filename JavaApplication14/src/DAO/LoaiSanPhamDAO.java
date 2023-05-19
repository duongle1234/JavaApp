/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import DTO.LoaiSanPhamDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi Hung
 */
public class LoaiSanPhamDAO {
    public ArrayList DocLoaiSanPham(){
    ArrayList loaisanpham=new ArrayList<LoaiSanPhamDTO>();
    try{
        String query="select * from loaisanpham";
        Connect conn=new Connect();
        ResultSet rs = conn.excuteQuery(query);
        while(rs.next()){
            LoaiSanPhamDTO lsp= new LoaiSanPhamDTO();
            lsp.setMaLoai(rs.getString(1));
            lsp.setTenLoai(rs.getString(2));
            loaisanpham.add(lsp);
        }
      
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Quá trình tải bị lỗi");
    }
    return loaisanpham;
    }   
    public void Them(LoaiSanPhamDTO lsp) throws SQLException{
        String query="Insert into loaisanpham values ('" +lsp.getMaloai()+"','"+lsp.getTenloai()+"')";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(query); 
        if(a>0)
            JOptionPane.showMessageDialog(null,"Thêm thành công");
        else
            JOptionPane.showMessageDialog(null,"Lỗi thêm");
    }
    public boolean Xoa(LoaiSanPhamDTO lsp) throws SQLException{
        String query="Delete from loaisanpham where maloai='"+lsp.getMaloai()+ "'";
        
        Connect conn=new Connect();
        int a=conn.excuteUpdate(query);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Xóa thành công");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Không tìm thấy mã loại");
            return false;
        }
    }
    public boolean Sua(LoaiSanPhamDTO lsp) throws SQLException{
        String query="Update loaisanpham set tenloai='"+lsp.getTenloai()+"' where maloai='"+lsp.getMaloai()+ "'";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(query);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sữa thành công");
            return true;
        }
        return false;
    }
}
