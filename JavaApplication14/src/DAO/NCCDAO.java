/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NCCDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NCCDAO {
  
    public ArrayList doc() 
    {
        ArrayList dsnv=new ArrayList<NCCDTO>();
        try{
            
            String qry="select * from ncc";
            Connect conn=new Connect();
            ResultSet rs = conn.excuteQuery(qry);
            while(rs.next()){
                NCCDTO nv=new NCCDTO();
                nv.setMANCC(rs.getString(1));
                nv.setTENNCC(rs.getString(2));
                dsnv.add(nv);
            }
        }
        catch(Exception E){
            System.out.println("không thể đọc");
        }
        return dsnv;
    }
    
    public void them(NCCDTO nv) throws SQLException {

        
        String qry="insert into ncc values('"+nv.getMANCC()+"','"+nv.getTENNCC()+"')";
        Connect conn =new Connect();
        int a = conn.excuteUpdate(qry);
        if(a>0)
            JOptionPane.showMessageDialog(null,"Thêm thành công");
        else
            JOptionPane.showMessageDialog(null,"Lỗi thêm");
        
    }
    public boolean sua(NCCDTO nv) throws SQLException{
        String qry="update ncc set tenncc='"+nv.getTENNCC()+"' where mancc='"+nv.getMANCC()+"'";
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
    public boolean xoa(NCCDTO nv) throws SQLException{
        String qry="delete from ncc where mancc='"+nv.getMANCC()+"'";
        Connect conn=new Connect("localhost","root","","quanlicuahangaokhoac");
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
