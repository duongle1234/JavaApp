/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CHITIETPHIEUNHAPHANGDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class CHITIETPHIEUNHAPHANG {
     public ArrayList<CHITIETPHIEUNHAPHANGDTO> Doc() {
        ArrayList<CHITIETPHIEUNHAPHANGDTO> dsctpnh=new ArrayList<CHITIETPHIEUNHAPHANGDTO>();
        try {
            
            String query="select * from chitietphieunhaphang";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                CHITIETPHIEUNHAPHANGDTO ctpnhdto=new CHITIETPHIEUNHAPHANGDTO();
                ctpnhdto.setMAPNH(rs.getString(1));
                ctpnhdto.setMASP(rs.getString(2));
                ctpnhdto.setDONGIA(rs.getString(3));
                ctpnhdto.setSOLUONG(rs.getString(4));
                ctpnhdto.setTHANHTIEN(rs.getString(5));                
                dsctpnh.add(ctpnhdto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dsctpnh;
    }
    public boolean sua(CHITIETPHIEUNHAPHANGDTO dto) throws SQLException{
        String qry="update chitietphieunhaphang set MAPNH='"+dto.getMAPNH()+"',MASP='"+dto.getMASP()+"',DONGIA='"+dto.getDONGIA()+"',SOLUONG='"+dto.getSOLUONG()+"',THANHTIEN='"+dto.getTHANHTIEN()+"' where MAPNH='"+dto.getMAPNH()+"'";    
        Connect con=new Connect();
        int a=con.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        JOptionPane.showMessageDialog(null,"Sửa thất bại");
        return false;
    }
    public boolean Them(CHITIETPHIEUNHAPHANGDTO dto) throws SQLException{
        String query="Insert into chitietphieunhaphang values ('" +dto.getMAPNH()+"','"+dto.getMASP()+"','"+dto.getDONGIA()+"','"+dto.getSOLUONG()+"','"+dto.getTHANHTIEN()+"')";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(query); 
        if(a>0)
            JOptionPane.showMessageDialog(null,"Thêm thành công");
        else{
            JOptionPane.showMessageDialog(null,"Lỗi thêm");
            return false;
        }
        return true;
    }
    public boolean Xoa(CHITIETPHIEUNHAPHANGDTO dto) throws Exception{
        String query="Delete from chitietphieunhaphang where MAPNH='"+dto.getMAPNH()+ "'";
        
        Connect conn=new Connect();
        int a=conn.excuteUpdate(query);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Xóa thành công");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Xóa thất bại");
            return false;
        }
    }
    
}
