/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Connect;
import DAO.Connect;
import DTO.SANPHAMDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Phi Hung
 */
public class SANPHAMDAO {

    public SANPHAMDAO() {
    }
    
    public ArrayList DocSanPham(){
        ArrayList lssanpham=new ArrayList<SANPHAMDTO>();
        try{
            String query="select * from sanpham";
            Connect conn=new Connect();
            ResultSet rs = conn.excuteQuery(query);
            while(rs.next()){
                SANPHAMDTO sp= new SANPHAMDTO();
                sp.setMASP(rs.getString(1));
                sp.setTENSP(rs.getString(2));
                sp.setNGAYSX(rs.getString(3));
                sp.setSOLUONG(rs.getString(4));
                sp.setDONGIA(rs.getString(5));
                sp.setMALOAI(rs.getString(6));
                //hinh anh
                lssanpham.add(sp);
            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Quá trình tải bị lỗi");
        }
        return lssanpham;
    }   
    public boolean Them(SANPHAMDTO sp) throws SQLException{
        String query="Insert into sanpham values ('" +sp.getMASP()+"','"+sp.getTENSP()+"','"+sp.getNGAYSX()+"','"+sp.getSOLUONG()+"','"+sp.getDONGIA()+"','"+sp.getMALOAI()+"','"+sp.getMALOAI()+"')";
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
    public boolean Xoa(SANPHAMDTO sp) throws SQLException{
        String query="Delete from sanpham where MASP='"+sp.getMASP()+ "'";
        
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
    public boolean Sua(SANPHAMDTO sp) throws SQLException{
        String query="Update sanpham set TENSP='"+sp.getTENSP()+"',NGAYSX='"+sp.getNGAYSX()+"',SOLUONG='"+sp.getSOLUONG()+"',DONGIA='"+sp.getDONGIA()+"',MALOAI='"+sp.getMALOAI()+"',HINHANH='"+sp.getHINHANH()+"' where MASP='"+sp.getMASP()+ "'";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(query);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sữa thành công");
            return true;
        }
        return false;
    }
    public boolean Sua2(SANPHAMDTO sp) throws SQLException{
        String query="Update sanpham set TENSP='"+sp.getTENSP()+"',NGAYSX='"+sp.getNGAYSX()+"',SOLUONG='"+sp.getSOLUONG()+"',DONGIA='"+sp.getDONGIA()+"',MALOAI='"+sp.getMALOAI()+"',HINHANH='"+sp.getHINHANH()+"' where MASP='"+sp.getMASP()+ "'";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(query);
        if(a>0){
            
            return true;
        }
        return false;
    }
    public ArrayList<SANPHAMDTO> thongke(){
        ArrayList<SANPHAMDTO> tmp=new ArrayList<SANPHAMDTO>();
        try {
            String qr="Select maloai ,sum(SOLUONG) from sanpham group by maloai";
            Connect con=new Connect();
            ResultSet rs=con.excuteQuery(qr);
            while(rs.next()){
                SANPHAMDTO a=new SANPHAMDTO();
                a.setMALOAI(rs.getString(1));
                a.setSOLUONG(rs.getString(2));
                tmp.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SANPHAMDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
