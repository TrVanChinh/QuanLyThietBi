
package dbconnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDonNhapBean;
import model.HoaDonXuatBean;
import serviece.ThongKeDao;

/**
 *
 * @author DELL
 */
public class ThongKeDaoImpl implements ThongKeDao{

    @Override
    public List<HoaDonNhapBean> getListByHoaDonNhap() {
        
        try {
            Connection con = DBContext.JDBCConnection();
            String sql  ="Select  ngayNhap, sum(soLuongNhap) as soLuongNhap from ChiTietHoaDonNhap group by ngayNhap";
            List<HoaDonNhapBean> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                HoaDonNhapBean hoaDonNhapBean = new HoaDonNhapBean();
           
                hoaDonNhapBean.setNgayNhap(rs.getString("ngayNhap"));
                hoaDonNhapBean.setSoLuongNhap(rs.getInt("soLuongNhap"));
                list.add(hoaDonNhapBean);
            }
            return list;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
                return null;
        }

    @Override
    public List<HoaDonXuatBean> getListByHoaDonXuat() {
        
        try {
            Connection con = DBContext.JDBCConnection();
            String sql  ="Select  ngayXuat, sum(soLuong) as soLuong from ChiTietPhieuXuat group by ngayXuat";
            List<HoaDonXuatBean> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                HoaDonXuatBean hoaDonXuatBean = new HoaDonXuatBean();
                hoaDonXuatBean.setNgayXuat(rs.getString("ngayXuat"));
                hoaDonXuatBean.setSoLuong(rs.getInt("soLuong"));
                list.add(hoaDonXuatBean);
            }
            return list;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
                return null;
        }
    
     
    
}
