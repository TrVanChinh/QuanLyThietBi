/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import Model.HoaDonNhapBean;
import Model.HoaDonXuatBean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import serviece.ThongKeService;
import serviece.ThongKeServiceIml;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author DELL
 */
public class QuanLyThongKeController {
    private ThongKeService thongKeService = null;
   

    public QuanLyThongKeController() {
        this.thongKeService = new ThongKeServiceIml();
    }
    
    public void setDataToChart1(JPanel jpnItem){
        List<HoaDonNhapBean> listItem = thongKeService.getListByHoaDonNhap();
        
        
        if(listItem != null ){
             DefaultCategoryDataset dataset = new DefaultCategoryDataset();
             for(HoaDonNhapBean item : listItem){
                 dataset.addValue(item.getSoLuongNhap(), "Số lượng nhập ",item.getNgayNhap());
                 
             }
             JFreeChart chart = ChartFactory.createBarChart("Thống kê số lượng nhập".toUpperCase(), "Thời gian", "Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);
             ChartPanel chartPanel = new ChartPanel(chart);
             chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(),300));
             jpnItem.removeAll();
             jpnItem.setLayout(new CardLayout());
             jpnItem.add(chartPanel);
             jpnItem.validate();
             jpnItem.repaint();
        }
       
    }
    public void setDataToChart2(JPanel jpnItem){
        List<HoaDonXuatBean> listItem = thongKeService.getListByHoaDonXuat();
        
        
        if(listItem != null ){
             DefaultCategoryDataset dataset = new DefaultCategoryDataset();
             for(HoaDonXuatBean item : listItem){
                 dataset.addValue(item.getSoLuong(), "Số lượng xuất ",item.getNgayXuat());
                 
             }
             JFreeChart chart = ChartFactory.createBarChart("Thống kê số lượng xuất".toUpperCase(), "Thời gian", "Số lượng", dataset, PlotOrientation.VERTICAL, false, true, false);
             ChartPanel chartPanel = new ChartPanel(chart);
             chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(),300));
             jpnItem.removeAll();
             jpnItem.setLayout(new CardLayout());
             jpnItem.add(chartPanel);
             jpnItem.validate();
             jpnItem.repaint();
        }
       
    }
}
