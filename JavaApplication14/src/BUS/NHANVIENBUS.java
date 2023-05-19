/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DTO.NHANVIENDTO;
import DAO.NHANVIENDAO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class NHANVIENBUS {    
    public static ArrayList<NHANVIENDTO> dsnv=new ArrayList<>();
    public boolean them(NHANVIENDTO nvdto){
        NHANVIENDAO nvdao1=new NHANVIENDAO();
        if(dsnv==null)
            dsnv=nvdao1.doc();
        
        for(int i=0;i<dsnv.size();i++){
          
            if(nvdto.getMANV().equals(dsnv.get(i).getMANV())){
                JOptionPane.showMessageDialog(null,"MANV đã tồn tại");
                return false;    
            }
        }
        if(nvdto.getMANV().equals("") || nvdto.getTENNV().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Không được để manv hoặc tennv rỗng");
            return false;
        }
        
        NHANVIENDAO nvdao=new NHANVIENDAO();
            nvdao.them(nvdto);                        
        dsnv.add(nvdto);
        return true;
    }
    
    public boolean xoa(NHANVIENDTO nvdto)
    {
        NHANVIENDAO nvdao=new NHANVIENDAO();
        if(nvdao.xoa(nvdto)==true)
            return true;        
        return false;
        
    }
    public void xoavitri(int i){
        dsnv.remove(i);
    }
     public boolean sua(NHANVIENDTO nvdto){
        NHANVIENDAO nvdao=new NHANVIENDAO();
        int co=0;
        for(NHANVIENDTO nv: dsnv)
            if(nv.getMANV().equals(nvdto.getMANV()))
            {
                co=1;
                nv.setCHUCVU(nvdto.getCHUCVU());
                nv.setGIOITINH(nvdto.getGIOITINH());
                nv.setLUONG(nvdto.getLUONG());
                nv.setMANV(nvdto.getMANV());
                nv.setTENNV(nvdto.getTENNV());                
                break;
            }
        if(co==0) return false;
        return nvdao.sua(nvdto);
    }
     public void hienthi(){
        NHANVIENDAO nvdao=new NHANVIENDAO();
        if (dsnv==null) dsnv=new ArrayList<NHANVIENDTO>();
        dsnv=nvdao.doc();        
        
    }
    public ArrayList tknc(String tennv,String luongmin,String luongmax,String chucvu){
        ArrayList tkncl=new ArrayList();
        for(NHANVIENDTO x:dsnv)
        {
            if(chucvu.equals("Tất cả")){
                if(x.getTENNV().toUpperCase().indexOf(tennv.toUpperCase())!=-1 && Integer.parseInt(x.getLUONG())<= Integer.parseInt(luongmax) && Integer.parseInt(x.getLUONG())>=Integer.parseInt(luongmin))
                    tkncl.add(x);
            }
            else
                if(x.getTENNV().toUpperCase().indexOf(tennv.toUpperCase())!=-1 && Integer.parseInt(x.getLUONG())<= Integer.parseInt(luongmax) && Integer.parseInt(x.getLUONG())>=Integer.parseInt(luongmin) && chucvu.toUpperCase().equals(x.getCHUCVU().toUpperCase()))
                    tkncl.add(x);
            
        }
        return tkncl;
        
    }
    public NHANVIENDTO timkiemtheoma(String ma) throws Exception{        
        NHANVIENDAO nvdao=new NHANVIENDAO();
        dsnv=nvdao.doc();       
        NHANVIENDTO nv=new NHANVIENDTO();
        for(int i=0;i<dsnv.size();i++)
            if(dsnv.get(i).getMANV().equals(ma))
                nv=dsnv.get(i);                    
        return nv;
        
    }

    public ArrayList timkiemtheoten(String ten) throws Exception{
        ArrayList<NHANVIENDTO> nv=new ArrayList<>();
        NHANVIENDAO nvdao=new NHANVIENDAO();
        if(dsnv==null) dsnv=nvdao.doc();
        for(int i=0;i<dsnv.size();i++)
            if(dsnv.get(i).getTENNV()==ten)
            {
                nv.add(dsnv.get(i));
            }
        return nv;
        
    }    
    public Vector<String> combobox()
    {
        Vector<String> tmp=new Vector<String>();
        tmp.add("Nhân viên");
        return tmp;
        
    }
}
