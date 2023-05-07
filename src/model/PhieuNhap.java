/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class PhieuNhap {
    private String mHDNhap;
    private String tenloai;
    private float soLuong;
    private float giaNhap;
    private String mNV;
    private String ngayNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String mHDNhap, String tenloai, float soLuong, float giaNhap, String mNV, String ngayNhap) {
        this.mHDNhap = mHDNhap;
        this.tenloai = tenloai;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.mNV = mNV;
        this.ngayNhap = ngayNhap;
    }

    public String getmHDNhap() {
        return mHDNhap;
    }

    public void setmHDNhap(String mHDNhap) {
        this.mHDNhap = mHDNhap;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getmNV() {
        return mNV;
    }

    public void setmNV(String mNV) {
        this.mNV = mNV;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    
}
