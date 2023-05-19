/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Phi Hung
 */
public class LoaiSanPhamDTO {
    private String maloai;
    private String tenloai;
    public LoaiSanPhamDTO(){}
    public LoaiSanPhamDTO(String maloai, String tenloai){
        this.maloai=maloai;
        this.tenloai=tenloai;
    }
    public String getMaloai(){
        return maloai;
    }
    public String getTenloai(){
        return tenloai;
    }
    public void setMaLoai(String maloai){
        this.maloai=maloai;
    }
    public void setTenLoai(String tenloai){
        this.tenloai=tenloai;
    }
}
