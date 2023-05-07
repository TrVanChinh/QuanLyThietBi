/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;
import static dbconnection.DBContext.JDBCConnection;
import model.PhieuNhap;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class QuanLyDao {
    public List<PhieuNhap> getAllUsers_PhieuNhap() {
        List<PhieuNhap> ltl = new ArrayList<PhieuNhap>();

        Connection connection = JDBCConnection();
        String sql = "select * from ChiTietHoaDonNhap";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PhieuNhap tl = new PhieuNhap();
                tl.setmHDNhap(rs.getString("MaHDNhap"));
                tl.setTenloai(rs.getString("mTB"));
                tl.setSoLuong(rs.getFloat("soLuongNhap"));
                ltl.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ltl;
    }
}
