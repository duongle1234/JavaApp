/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.CHITIETHOADONDTO;
import DTO.HOADONDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class CHITIETHOADONDAO {
    
    public ArrayList<CHITIETHOADONDTO> Doc() {
        ArrayList<CHITIETHOADONDTO> dscthd=new ArrayList<CHITIETHOADONDTO>();
        try {
            
            String query="select * from chitiethoadon";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                CHITIETHOADONDTO hddto=new CHITIETHOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMASP(rs.getString(2));
                hddto.setDONGIA(rs.getString(3));
                hddto.setSOLUONG(rs.getString(4));
                hddto.setGIAMGIA(rs.getString(5));
                hddto.setTHANHTIEN(rs.getString(6));
                dscthd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dscthd;
    }
    public boolean sua( CHITIETHOADONDTO dto) throws SQLException{
        String qry="update chitiethoadon set DONGIA='"+dto.getDONGIA()+"',SOLUONG='"+dto.getSOLUONG()+"',GIAMGIA='"+dto.getGIAMGIA()+"',THANHTIEN='"+dto.getTHANHTIEN()+"' where MAHD='"+dto.getMAHD()+"' AND MASP='"+dto.getMASP()+"'";    
        Connect con=new Connect();
        int a=con.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        JOptionPane.showMessageDialog(null,"Sửa thất bại");
        return false;
    }
    public boolean Them(CHITIETHOADONDTO dto) throws SQLException{
        String query="Insert into chitiethoadon values ('" +dto.getMAHD()+"','"+dto.getMASP()+"','"+dto.getDONGIA()+"','"+dto.getSOLUONG()+"','"+dto.getGIAMGIA()+"','"+dto.getTHANHTIEN()+"')";
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
    public boolean Xoa(CHITIETHOADONDTO dto) throws Exception{
        String query="Delete from chitiethoadon where MAHD='"+dto.getMAHD()+ "' AND MASP='"+dto.getMASP()+"'";
        Connect conn=new Connect();
        int a=conn.excuteUpdate(query);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Xóa thành công");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Xóa thất bại trong DB");
            return false;
        }
    }
    public ArrayList<HOADONDTO> thongkehdsp(){
        ArrayList<HOADONDTO> dshd=new ArrayList<HOADONDTO>();
        try {
            
            String query="select MASP,SUM(SOLUONG) from chitiethoadon Group by MASP";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                HOADONDTO hddto=new HOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMAKH(rs.getString(2));
  
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dshd;
    }
}
