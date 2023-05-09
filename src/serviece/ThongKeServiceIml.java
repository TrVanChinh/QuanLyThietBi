
package serviece;

import Connection.ThongKeDaoImpl;
import java.util.List;
import Model.HoaDonNhapBean;
import Model.HoaDonXuatBean;

/**
 *
 * @author DELL
 */
public class ThongKeServiceIml implements ThongKeService{

    private ThongKeDao thongKeDao = null;

    public ThongKeServiceIml() {
        this.thongKeDao = new ThongKeDaoImpl();
    }
    
   
    @Override
    public List<HoaDonXuatBean> getListByHoaDonXuat() {
        return thongKeDao.getListByHoaDonXuat();
    
    }
     @Override
    public List<HoaDonNhapBean> getListByHoaDonNhap() {
        return thongKeDao.getListByHoaDonNhap();
    }

}
