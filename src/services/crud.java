/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Connection.connection;
import java.util.ArrayList;
import java.util.List;
import model.Kho;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietPhieuNhap;
import model.ModelGeneral;
import model.PhieuNhap;

/**
 *
 * @author trunghuynh
 */
public class crud {

    static Connection conn = connection.getJDBCConnection();

    public static List<Kho> getALLKho() {
        List<Kho> KhoData = new ArrayList<Kho>();
        try {
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
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KhoData;
    }

    public static List<PhieuNhap> getALLPN() {
        List<PhieuNhap> PnData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT phieuNhap.mPhieuNhap, phieuNhap.ngayNhap, nhaCungCap.tenNCC AS ncc, SUM(ChiTietPhieuNhap.soLuong) AS sl \n" +
"FROM phieuNhap\n" +
"JOIN ChiTietPhieuNhap ON phieuNhap.mPhieuNhap = ChiTietPhieuNhap.mPhieuNhap\n" +
"JOIN nhaCungCap ON nhaCungCap.mNCC = phieuNhap.mNCC\n" +
"GROUP BY phieuNhap.mPhieuNhap");
            ResultSet result = ps.executeQuery();
            int i = 1;
            while (result.next()) {
                PhieuNhap phieuNhap = new PhieuNhap();
                phieuNhap.setIndex(i + "");
                phieuNhap.setId(result.getString("mPhieuNhap"));
                phieuNhap.setName(result.getString("ncc"));
                phieuNhap.setQuantity(result.getString("sl"));
                phieuNhap.setDate(result.getString("ngayNhap"));
                PnData.add(phieuNhap);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PnData;
    }

    public static ChiTietPhieuNhap getChitietpn(String maPn, String maTb) {
        ChiTietPhieuNhap phieuNhap = new ChiTietPhieuNhap();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT ChiTietPhieuNhap.mNV, phieuNhap.mPhieuNhap, ChiTietPhieuNhap.mTB as mtb, phieuNhap.ngayNhap, nhaCungCap.tenNCC as ncc, nhaCungCap.diachiNCC as diachi, nhaCungCap.sdt as sdt, ChiTietPhieuNhap.soLuong as sl, ChiTietPhieuNhap.giaNhap as gia, ThietBi.tenTB as tenTB\n" +
"FROM phieuNhap JOIN ChiTietPhieuNhap \n" +
"	ON phieuNhap.mPhieuNhap = ChiTietPhieuNhap.mPhieuNhap \n" +
"JOIN nhaCungCap \n" +
"	ON nhaCungCap.mNCC = phieuNhap.mNCC \n" +
"JOIN Thietbi \n" +
"	ON ChiTietPhieuNhap.mTB = Thietbi.mTB \n" +
"WHERE phieuNhap.mPhieuNhap = ? and ChiTietPhieuNhap.mTB =?");
            ps.setString(1, maPn);
            ps.setString(2, maTb);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                phieuNhap.setId(result.getString("mPhieuNhap"));
                phieuNhap.setAddress(result.getString("diachi"));
                phieuNhap.setDate(result.getString("ngayNhap"));
                phieuNhap.setMail("huynhtrung@gmail.com");
                phieuNhap.setName(result.getString("tenTB"));
                phieuNhap.setNcc(result.getString("ncc"));
                phieuNhap.setPhone(result.getString("sdt"));
                phieuNhap.setPrice(result.getDouble("gia"));
                phieuNhap.setProduct(result.getString("mtb"));
                phieuNhap.setQuantity(result.getString("sl"));
                phieuNhap.setTotal(Integer.parseInt(result.getString("sl")) * result.getDouble("gia"));
                phieuNhap.setWebsite("www.khovn.com");
                phieuNhap.setMnv(result.getString("mNV"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhap;
    }
    public static List<ModelGeneral> getALLCTPN(String mPN) {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT phieuNhap.mPhieuNhap,ChiTietPhieuNhap.mTB, ThietBi.tenTB from phieuNhap join ChiTietPhieuNhap on phieuNhap.mPhieuNhap = ChiTietPhieuNhap.mPhieuNhap join ThietBi on ChiTietPhieuNhap.mTB = ThietBi.mTB WHERE phieuNhap.mPhieuNhap = ?");
            ps.setString(1, mPN);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("mPhieuNhap"));
                ncc.setName(result.getString("mTB"));
                ncc.setmTb(result.getString("tenTB"));
                NccData.add(ncc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }
    

    public static List<ModelGeneral> getALLNcc() {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT mNCC,tenNCC from nhaCungCap");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("mNCC"));
                ncc.setName(result.getString("tenNCC"));
                NccData.add(ncc);

            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static List<ModelGeneral> getALLTb() {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT mTB,tenTB from ThietBi");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("mTB"));
                ncc.setName(result.getString("tenTB"));
                NccData.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static List<ModelGeneral> getALLxa(String mH) {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT mPX,tenPX from Phuong WHERE maQH = ?");
            ps.setString(1, mH);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("mPX"));
                ncc.setName(result.getString("tenPX"));
                NccData.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static List<ModelGeneral> getALLHuyen(String mH) {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT maQH,tenHuyen from Huyen WHERE maTT = ?");
            ps.setString(1, mH);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("maQH"));
                ncc.setName(result.getString("tenHuyen"));
                NccData.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static List<ModelGeneral> getALLTinh() {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT maTT,tenTT from TinhThanh");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("maTT"));
                ncc.setName(result.getString("tenTT"));
                NccData.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static List<ModelGeneral> getALLNV() {
        List<ModelGeneral> NccData = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT mNV,tenNhanVien from NhanVien");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                ModelGeneral ncc = new ModelGeneral();
                ncc.setId(result.getString("mNV"));
                ncc.setName(result.getString("tenNhanVien"));
                NccData.add(ncc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NccData;
    }

    public static String insertPN(String id, String idNcc, String date) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO phieuNhap (mPhieuNhap, mNCC, ngayNhap) VALUES (?, ?, ?);");
            ps.setString(1, id);
            ps.setString(2, idNcc);
            ps.setString(3, date);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được chèn thành công!";
            } else {
                result = "Không thể chèn dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static String insertCTPN(String mPhieuNhap, String mTB, String soLuong,String giaNhap, String mNV) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ChiTietPhieuNhap (mPhieuNhap, mTB, soLuong, giaNhap, mNV) VALUES (?,?,?,?,?);");
            ps.setString(1, mPhieuNhap);
            ps.setString(2, mTB);
            ps.setString(3, soLuong);
            ps.setString(4, giaNhap);
            ps.setString(5, mNV);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được chèn thành công!";
            } else {
                result = "Không thể chèn dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String getIdPn() {
        String id = "pn001";
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT mPhieuNhap FROM PhieuNhap ORDER BY mPhieuNhap DESC LIMIT 1");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                String idpn = result.getString("mPhieuNhap");
                String[] parts = idpn.split("pn");
                int idN = Integer.parseInt(parts[1])+1;
                id = "pn" + String.format("%03d", idN);
            }
        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static String updateCTPN(String mPhieuNhap, String mTB, String soLuong,String giaNhap, String mNV) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE ChiTietPhieuNhap SET mTB = ?, soLuong = ?, giaNhap = ?, mNV = ? WHERE (mPhieuNhap = ?) and (mTB = ?);");
            ps.setString(5, mPhieuNhap);
            ps.setString(1, mTB);
            ps.setString(2, soLuong);
            ps.setString(3, giaNhap);
            ps.setString(4, mNV);
            ps.setString(6, mTB);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được cập nhật thành công!";
            } else {
                result = "Không thể cập nhật dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static String updatePN(String id, String idNcc, String date) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE phieuNhap SET mNCC = ?, ngayNhap = ? WHERE (mPhieuNhap = ?)");
            ps.setString(3, id);
            ps.setString(1, idNcc);
            ps.setString(2, date);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được cập nhật thành công!";
            } else {
                result = "Không thể cập nhật dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static String DeleteCTPN(String mPN, String mTB) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ChiTietPhieuNhap WHERE (mPhieuNhap = ?) and (mTB = ?);");
            ps.setString(1, mPN);
            ps.setString(2, mTB);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được xoá thành công!";
            } else {
                result = "Không thể xoá dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static String DeletePN(String mPN) {
        String result = "";
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM ChiTietPhieuNhap WHERE (mPhieuNhap = ?);");
            ps.setString(1, mPN);
            int rowsInserted = ps.executeUpdate();
            ps = conn.prepareStatement("DELETE FROM PhieuNhap WHERE (mPhieuNhap = ?);");
            ps.setString(1, mPN);
            rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                result = "Dữ liệu đã được xoá thành công!";
            } else {
                result = "Không thể xoá dữ liệu!";
            }
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(services.crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    

    public static void main(String[] args) {
        System.out.println(getIdPn());
        //


    }
}
