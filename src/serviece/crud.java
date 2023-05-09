/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviece;

import Connection.DBContext;
import java.util.ArrayList;
import java.util.List;
import Model.Kho;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ChiTietPhieuNhap;
import Model.PhieuNhap;

/**
 *
 * @author trunghuynh
 */
public class crud {

    public static List<Kho> getALLKho() throws Exception {
        List<Kho> KhoData = new ArrayList<Kho>();
        
        Connection conn;
        
        try {
            DBContext db = new DBContext();
                    conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from kho");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Kho kho = new Kho();

                kho.setId(result.getInt("mKho"));
                kho.setName(result.getString("tenKho"));
                kho.setArea(result.getString("dienTich"));
                kho.setArea_empty(result.getString("dienTichTrong"));
                kho.setAddress(result.getString("diaChi"));
                kho.setIdP(result.getString("idxa"));
                KhoData.add(kho);
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviece.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KhoData;
    }

    public static List<PhieuNhap> getALLPN() throws Exception {
        List<PhieuNhap> PnData = new ArrayList<>();
        Connection conn ;

        try {
            DBContext db = new DBContext();
                    conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT hoaDonNhap.mHDNhap,hoaDonNhap.ngayNhap,nhaCungCap.tenNCC as ncc, ChiTietHoaDonNhap.soLuongNhap as sl FROM hoaDonNhap,ChiTietHoaDonNhap,nhaCungCap\n"
                    + "WHERE hoaDonNhap.mHDNhap = ChiTietHoaDonNhap.mHDNhap and nhaCungCap.mNCC = hoaDonNhap.mNCC;");
            ResultSet result = ps.executeQuery();
            int i = 1;
            while (result.next()) {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setIndex(i + "");
                phieuNhap.setId(result.getString("mHDNhap"));
                phieuNhap.setName(result.getString("ncc"));
                phieuNhap.setQuantity(result.getString("sl"));
                phieuNhap.setDate(result.getString("ngayNhap"));
                PnData.add(phieuNhap);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviece.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PnData;
    }

    public static ChiTietPhieuNhap getChitietpn(String maPn) throws Exception {
        Connection conn ;
        ChiTietPhieuNhap phieuNhap = null;
        try {
            DBContext db = new DBContext();
                    conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT hoaDonNhap.mHDNhap, hoaDonNhap.ngayNhap, nhaCungCap.tenNCC as ncc, nhaCungCap.diachiNCC as diachi, nhaCungCap.sdt as sdt, ChiTietHoaDonNhap.soLuongNhap as sl, ChiTietHoaDonNhap.giaNhap as gia, ThietBi.tenTB as tenTB FROM hoaDonNhap JOIN ChiTietHoaDonNhap ON hoaDonNhap.mHDNhap = ChiTietHoaDonNhap.mHDNhap JOIN nhaCungCap ON nhaCungCap.mNCC = hoaDonNhap.mNCC JOIN Thietbi ON ChiTietHoaDonNhap.mTB = Thietbi.mTB WHERE hoaDonNhap.mHDNhap = ?");
            ps.setString(1, maPn);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                phieuNhap = new ChiTietPhieuNhap();
                phieuNhap.setId(result.getString("mHDNhap"));
                phieuNhap.setAddress(result.getString("diachi"));
                phieuNhap.setDate(result.getString("ngayNhap"));
                phieuNhap.setMail("huynhtrung@gmail.com");
                //phieuNhap.setName(result.getString("tenTB"));
                phieuNhap.setNcc(result.getString("ncc"));
                phieuNhap.setPhone(result.getString("sdt"));
                phieuNhap.setPrice(result.getDouble("gia"));
                phieuNhap.setProduct(result.getString("tenTB"));
                phieuNhap.setQuantity(result.getString("sl"));
                phieuNhap.setTotal(Integer.parseInt(result.getString("sl"))*result.getDouble("gia"));
                phieuNhap.setWebsite("www.khovn.com");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviece.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhap;
    }


public static void main(String[] args) throws Exception {    
        List<PhieuNhap> PnData = new ArrayList<>();
        PnData= getALLPN();
        for (int i = 0; i < 10; i++) {
            System.out.println(PnData.get(i).getId());
    }
        
    }
}
