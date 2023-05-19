/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.KHACHHANGDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class KHACHHANGDAO {

    public ArrayList doc() 
    {
        ArrayList dsnv=new ArrayList<KHACHHANGDTO>();
        try{
            String qry="select * from khachhang ";
            Connect conn=new Connect();
            ResultSet rs = conn.excuteQuery(qry);
            while(rs.next()){
                KHACHHANGDTO nv=new KHACHHANGDTO();
                nv.setMAKH(rs.getString(1));
                nv.setTENKH(rs.getString(2));
                nv.setDIACHI(rs.getString(3));
                nv.setSDT(rs.getString(4));
                dsnv.add(nv);
            }
        }
        catch(Exception E){
            System.out.println("không thể đọc");
        }
 
        return dsnv;
    }
    
    public void them(KHACHHANGDTO nv) throws SQLException {
        String qry="insert into khachhang values("+"'"+nv.getMAKH()+"','"+nv.getTENKH()+"','"+nv.getDIACHI()+"','"+nv.getSDT()+"')";
        Connect conn =new Connect();
        int a = conn.excuteUpdate(qry);
        if(a>0)
            JOptionPane.showMessageDialog(null,"Thêm thành công");
        else
            JOptionPane.showMessageDialog(null,"Lỗi thêm");
        
    }
    public boolean sua(KHACHHANGDTO nv) throws SQLException{
        String qry="update khachhang set tenkh='"+nv.getTENKH()+"',diachi='"+nv.getDIACHI()+"',SDT='"+nv.getSDT()+"' where makh='"+nv.getMAKH()+"'";
        Connect conn=new Connect();
        int a=conn.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Không tìm thấy mã loại");
            return false;
        }
    }
    public boolean xoa(KHACHHANGDTO nv) throws SQLException{

        String qry="delete from khachhang where makh='"+nv.getMAKH()+"'";
        Connect conn=new Connect();
        int a=conn.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Xóa thành công");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Không tìm thấy mã loại");
            return false;
        }
    }

}
