
package serviece;

import java.util.List;
import Model.HoaDonNhapBean;
import Model.HoaDonXuatBean;

/**
 *
 * @author DELL
 */
public interface ThongKeService {
    public List<HoaDonNhapBean>getListByHoaDonNhap();
    public List<HoaDonXuatBean>getListByHoaDonXuat();
}
