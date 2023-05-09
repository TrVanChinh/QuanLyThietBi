/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class HoaDonNhapBean {
    private String ngayNhap;
    private int soLuongNhap;


    public HoaDonNhapBean() {
    }

   

    public HoaDonNhapBean(String ngayNhap, int soLuongNhap) {
        this.ngayNhap = ngayNhap;
        this.soLuongNhap = soLuongNhap;
 
    }


    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }
    
}
