/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class NguoiDung {
    private String sodienthoai;
    private String matkhau;
    private String hovaten;
    private String cmnd;
    private String ngaySinh;
    private String diaChi;
    
    public NguoiDung() {
        
    }

    public NguoiDung(String sodienthoai, String matkhau, String hovaten, String cmnd, String ngaySinh, String diaChi) {
        this.sodienthoai = sodienthoai;
        this.matkhau = matkhau;
        this.hovaten = hovaten;
        this.cmnd = cmnd;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

   
}
