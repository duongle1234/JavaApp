/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PHIEUNHAPHANGDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class PHIEUNHAPHANGDAO {
    public ArrayList<PHIEUNHAPHANGDTO> Doc() {
        ArrayList<PHIEUNHAPHANGDTO> dspnh=new ArrayList<PHIEUNHAPHANGDTO>();
        try {
            
            String query="select * from phieunhaphang";
            Connect con=new Connect();
            ResultSet rs= con.excuteQuery(query);
            while(rs.next()){
                PHIEUNHAPHANGDTO pnhdto=new PHIEUNHAPHANGDTO();
                pnhdto.setMAPNH(rs.getString(1));
                pnhdto.setMANCC(rs.getString(2));
                pnhdto.setMANV(rs.getString(3));
                pnhdto.setNGAYNHAP(rs.getString(4));
                String query2="select sum(thanhtien) from chitietphieunhaphang where MAPNH='"+rs.getString(1)+"'";
                ResultSet rs2=con.excuteQuery(query2);
                while(rs2.next())
                    pnhdto.setTONGTIEN(rs2.getString(1));
                dspnh.add(pnhdto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Quá trình đọc bị lỗi");
        }
        return dspnh;
    }
    public boolean sua(PHIEUNHAPHANGDTO dto) throws SQLException{
        String qry="update phieunhaphang set MAPNH='"+dto.getMAPNH()+"',MANCC='"+dto.getMANCC()+"',MANV='"+dto.getMANV()+"',NGAYNHAP='"+dto.getNGAYNHAP()+"',TONGTIEN='"+dto.getTONGTIEN()+"' where MAPNH='"+dto.getMAPNH()+"'";    
        Connect con=new Connect();
        int a=con.excuteUpdate(qry);
        if(a>0){
            JOptionPane.showMessageDialog(null,"Sửa thành công");
            return true;
        }
        JOptionPane.showMessageDialog(null,"Sửa thất bại");
        return false;
    }
    public void sua2(PHIEUNHAPHANGDTO dto) throws SQLException{
        String qry="update phieunhaphang set MAPNH='"+dto.getMAPNH()+"',MANCC='"+dto.getMANCC()+"',MANV='"+dto.getMANV()+"',NGAYNHAP='"+dto.getNGAYNHAP()+"',TONGTIEN='"+dto.getTONGTIEN()+"' where MAPNH='"+dto.getMAPNH()+"'";    
        Connect con=new Connect();
        int a=con.excuteUpdate(qry);
        
    }
    public boolean Them(PHIEUNHAPHANGDTO dto) throws SQLException{
        String query="Insert into phieunhaphang values ('" +dto.getMAPNH()+"','"+dto.getMANCC()+"','"+dto.getMANV()+"','"+dto.getNGAYNHAP()+"','"+dto.getTONGTIEN()+"')";
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
    public boolean Xoa(PHIEUNHAPHANGDTO dto) throws Exception{
        String query="Delete from phieunhaphang where MAPNH='"+dto.getMAPNH()+ "'";
        
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
