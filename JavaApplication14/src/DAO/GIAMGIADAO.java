/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.GIAMGIADTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class GIAMGIADAO {
    public GIAMGIADAO(){};
    public ArrayList Doc(){
        ArrayList lshd=new ArrayList<GIAMGIADTO>();
        try{
            String query="select * from giamgia";
            Connect conn=new Connect();
            ResultSet rs = conn.excuteQuery(query);
            while(rs.next()){
                GIAMGIADTO hd= new GIAMGIADTO();
                hd.setMASP(rs.getString(1));
                hd.setMAGG(rs.getString(2));
                hd.setPHANTRAM(rs.getString(3));
                hd.setNGBD(rs.getString(4));
                hd.setNGKT(rs.getString(5));                
                //hinh anh
                lshd.add(hd);
            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return lshd;
    }
    public boolean Them(GIAMGIADTO gg) throws SQLException{
        String query="Insert into giamgia values ('" +gg.getMASP()+"','"+gg.getMAGG()+"','"+gg.getPHANTRAM()+"','"+gg.getNGBD()+"','"+gg.getNGKT()+"')";
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
     public boolean sua(GIAMGIADTO gg) throws SQLException{
        String qry="update giamgia set phantram='"+gg.getPHANTRAM()+"',ngbd='"+gg.getNGBD()+"',ngkt='"+gg.getNGKT()+"' where MAGG='"+gg.getMAGG()+"'";
        Connect conn=new Connect();
        int a =conn.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        return false;
    }
    public boolean xoa(GIAMGIADTO gg) throws SQLException{
        String query="Delete from giamgia where MAGG='"+gg.getMAGG()+ "'";
        
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
    
}
