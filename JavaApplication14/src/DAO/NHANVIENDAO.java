/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NHANVIENDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class NHANVIENDAO {
    String host="";
    String username="root";
    String password="";
    String database="quanlicuahangaokhoac";
    String tabledb="NHANVIEN";
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    
    public NHANVIENDAO(){};
    public NHANVIENDAO(String host,String username,String password,String data){
        this.host=host;
        this.username=username;
        this.password=password;
        this.database=data;
    }
    
    protected void drivertest(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi kết nối Driver");
        }
    }
    
    protected Connection getConnection() throws Exception{
        if(this.connect==null){
            drivertest();
            String url="jdbc:mysql://"+this.host+":3306/"+this.database+"?useUnicode=true&characterEncoding=utf-8";
          
            try{
                this.connect=DriverManager.getConnection(url,this.username,this.password);
            }
            catch (SQLException E){
                System.out.println("Không thể kết nối DataBase");
            } 
        }
        return this.connect;
    }
    protected Statement getStatement() throws Exception{
        if(this.statement==null){
            this.statement=this.getConnection().createStatement();
     
        }
        return this.statement;
    }
    public ResultSet executeQuery(String Query) {
        try{
            this.result=this.getStatement().executeQuery(Query);
        }
        catch(Exception E){
            System.out.println("Lỗi thực thi câu truy vấn");
        }
        return this.result;
    }
    public void Close() throws Exception{
        if(this.result!=null && !this.result.isClosed()){
            this.result.close();
            this.result=null;
        }
        if(this.statement!=null && !this.statement.isClosed()){
            this.statement.close();
            this.statement=null;
        }
        if(this.connect!=null && !this.connect.isClosed()){
            this.connect.close();
            this.connect=null;
        }
    }
    
    public ArrayList doc() 
    {
        ArrayList dsnv=new ArrayList<NHANVIENDTO>();
        try{
            String qry="select * from "+this.tabledb;
            ResultSet rs=executeQuery(qry);
            while(rs.next()){
                NHANVIENDTO nv=new NHANVIENDTO();
                nv.setMANV(rs.getString(1));
                nv.setTENNV(rs.getString(2));
                nv.setGIOITINH(rs.getString(3));
                nv.setCHUCVU(rs.getString(4));
                nv.setLUONG(rs.getString(5));
                dsnv.add(nv);
            }
        }
        catch(Exception E){
            System.out.println("không thể đọc");
        }
       // Close();
        return dsnv;
    }
    
    public void them(NHANVIENDTO nv) {
        try{
            String qry="insert into nhanvien values("+"'"+nv.getMANV()+"','"+nv.getTENNV()+"','"+nv.getGIOITINH()+"','"+nv.getCHUCVU()+"','"+nv.getLUONG()+"')";
            getStatement().executeUpdate(qry);
        }
        catch(Exception e){
            System.out.println("Lỗi thêm");
        }
       // Close();
        
    }
    public boolean sua(NHANVIENDTO nv){
        try{
            String qry="update nhanvien set tennv='"+nv.getTENNV()+"',gioitinh='"+nv.getGIOITINH()+"',chucvu='"+nv.getCHUCVU()+"',luong='"+nv.getLUONG()+"' where manv='"+nv.getMANV()+"'";
            getStatement().executeUpdate(qry);
            return true;
        }
        catch(Exception e){
            System.out.println("lỗi sửa");
            return false;
        }
    }
    public boolean xoa(NHANVIENDTO nv){
        try{
            String qry="delete from nhanvien where manv='"+nv.getMANV()+"'";
            getStatement().executeUpdate(qry);
            return true;
        }
        catch(Exception e){
            System.out.println("lỗi xóa");
            return false;
        }
    }
}
