/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serviece;

import java.util.List;
import Model.HoaDonNhapBean;
import Model.HoaDonXuatBean;

/**
 *
 * @author DELL
 */
public interface ThongKeDao {
    public List<HoaDonNhapBean>getListByHoaDonNhap();
    public List<HoaDonXuatBean>getListByHoaDonXuat();
}
