/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connect {
    
    private String Host="localhost";
    private String UserName="root";
    private String PassWord="";
    private String DataBase="quanlycuahangaokhoac";
    private Connection con= null;
    private Statement st=null;
    private ResultSet rs=null;
    public Connect(){}
    public Connect(String Host, String UserName, String PassWord, String DataBase){
        this.Host=Host;
        this.UserName=UserName;
        this.PassWord=PassWord; 
        this.DataBase=DataBase;
    }
    protected void driverTest(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Driver not found");
        }
    }   
    protected Connection getConnect(){
        if(con==null){
            driverTest();
            String url="jdbc:mysql://"+Host+":3306/"+DataBase+"?useUnicode=true&characterEncoding=utf-8";
            try {
                con=DriverManager.getConnection(url,UserName,PassWord);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Không thế kết nối đến CSDL "+DataBase);
            }           
        }
        return con;
    }
    protected Statement getStatement() throws SQLException{
        
            st=getConnect().createStatement();
        
        return st;
    } 
    public ResultSet excuteQuery(String query) throws SQLException{
        try{
            rs=getStatement().executeQuery(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"lỗi thực thi in con");
        }
        return rs;
    }
    public int excuteUpdate(String query) throws SQLException{
        int res=Integer.MIN_VALUE;
        try{
            res=getStatement().executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Update");
        }
        finally{
            this.Close();
        }
        return res;
    }
    public void Close() {
        try {
            if(rs!=null){
                rs.close();
                rs=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KHACHHANGDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(st!=null ){
                st.close();
                st=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KHACHHANGDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(con!=null ){
                con.close();
                con=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KHACHHANGDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
