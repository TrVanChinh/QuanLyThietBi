/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class HoaDonXuatBean {
    private String ngayXuat;
    private int soLuong;

    public HoaDonXuatBean() {
    }

    public HoaDonXuatBean(String ngayXuat, int soLuong) {
        this.ngayXuat = ngayXuat;
        this.soLuong = soLuong;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
