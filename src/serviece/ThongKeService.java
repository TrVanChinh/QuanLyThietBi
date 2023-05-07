
package serviece;

import java.util.List;
import model.HoaDonNhapBean;
import model.HoaDonXuatBean;

/**
 *
 * @author DELL
 */
public interface ThongKeService {
    public List<HoaDonNhapBean>getListByHoaDonNhap();
    public List<HoaDonXuatBean>getListByHoaDonXuat();
}
