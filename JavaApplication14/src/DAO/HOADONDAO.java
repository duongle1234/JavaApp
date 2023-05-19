/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.HOADONDTO;
import GUI.Hoadon;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class HOADONDAO {
    
    public ArrayList<HOADONDTO> Doc() {
        ArrayList<HOADONDTO> dshd=new ArrayList<HOADONDTO>();
        try {
            
            String query="select * from hoadon";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                HOADONDTO hddto=new HOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMAKH(rs.getString(2));
                hddto.setMANV(rs.getString(3));
                hddto.setNGAYGD(rs.getString(4));
                String query2="select sum(thanhtien) from chitiethoadon where mahd='"+rs.getString(1)+"'";
                ResultSet rs2=con.excuteQuery(query2);
                while(rs2.next())
                    hddto.setTONGTIEN(rs2.getString(1));
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dshd;
    }
    public boolean sua( HOADONDTO dto) throws SQLException{
        String qry="update hoadon set MAKH='"+dto.getMAKH()+"',MANV='"+dto.getMANV()+"',NGAYGD='"+dto.getNGAYGD()+"',TONGTIEN='"+dto.getTONGTIEN()+"' where MAHD='"+dto.getMAHD()+"'";    
        Connect con=new Connect();
        int a=con.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        JOptionPane.showMessageDialog(null,"Sửa thất bại");
        return false;
    }
    public void sua2( HOADONDTO dto) {
        try {
            String qry="update hoadon set MAKH='"+dto.getMAKH()+"',MANV='"+dto.getMANV()+"',NGAYGD='"+dto.getNGAYGD()+"',TONGTIEN='"+dto.getTONGTIEN()+"' where MAHD='"+dto.getMAHD()+"'";
            Connect con=new Connect();
            int a=con.excuteUpdate(qry);
            return ;
        } catch (SQLException ex) {
            Logger.getLogger(HOADONDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean Them(HOADONDTO dto) throws SQLException{
        String query="Insert into hoadon values ('" +dto.getMAHD()+"','"+dto.getMAKH()+"','"+dto.getMANV()+"','"+dto.getNGAYGD()+"','"+dto.getTONGTIEN()+"')";
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
    public boolean Xoa(HOADONDTO dto) throws Exception{
        String query="Delete from hoadon where MAHD='"+dto.getMAHD()+ "'";
        
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
    
    public ArrayList<HOADONDTO> thongkehdnvnam(){
        ArrayList<HOADONDTO> dshd=new ArrayList<HOADONDTO>();
        try {
            
            String query="select MANV,YEAR(NGAYGD),SUM(TONGTIEN) from hoadon  Group by MANV,YEAR(NGAYGD)";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                HOADONDTO hddto=new HOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMANV(rs.getString(2));
                hddto.setMAKH(rs.getString(3));
  
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dshd;
    }
    public ArrayList<HOADONDTO> thongkehdspnvnam(){
        ArrayList<HOADONDTO> dshd=new ArrayList<HOADONDTO>();
        try {
            
            String query="SELECT chitiethoadon.MASP,hoadon.MANV,YEAR(hoadon.NGAYGD),SUM(thanhtien) FROM chitiethoadon,hoadon WHERE chitiethoadon.MAHD=hoadon.MAHD GROUP by chitiethoadon.MASP,hoadon.MANV";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                HOADONDTO hddto=new HOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMANV(rs.getString(2));
                hddto.setMAKH(rs.getString(3));
                hddto.setTONGTIEN(rs.getString(4));
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dshd;
    }
    public ArrayList<HOADONDTO> thongkehd4tc(){
        ArrayList<HOADONDTO> dshd=new ArrayList<HOADONDTO>();
        try {
            
            String query="SELECT chitiethoadon.MASP,hoadon.MANV,YEAR(hoadon.NGAYGD),hoadon.MAKH,SUM(thanhtien) FROM chitiethoadon,hoadon WHERE chitiethoadon.MAHD=hoadon.MAHD GROUP by chitiethoadon.MASP,hoadon.MANV,YEAR(hoadon.NGAYGD),hoadon.MAKH";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                HOADONDTO hddto=new HOADONDTO();
                hddto.setMAHD(rs.getString(1));
                hddto.setMANV(rs.getString(2));
                hddto.setNGAYGD(rs.getString(3));
                hddto.setMAKH(rs.getString(4));
                hddto.setTONGTIEN(rs.getString(5));
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dshd;
    }
    public void report(){

        
    }
}
