/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HoaDonNhapBean;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import serviece.ThongKeService;
import serviece.ThongKeServiceIml;

/**
 *
 * @author Anh Duc
 */
public class TestExcel {

    public static void main(String[] args) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Học viên");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ngày nhập");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số lượng nhập");


            ThongKeService hocVienService = new ThongKeServiceIml();

            List<HoaDonNhapBean> listItem = hocVienService.getListByHoaDonNhap();

            for (int i = 0; i < listItem.size(); i++) {
                HoaDonNhapBean hoaDon = listItem.get(i);
                System.out.println(hoaDon.getNgayNhap());
                row = spreadsheet.createRow(4 + i);
                
                cell = row.createCell(0,CellType.NUMERIC);
                cell.setCellValue(i + 1);
                
                cell = row.createCell(1,CellType.STRING);
                cell.setCellValue(hoaDon.getNgayNhap());
                
                cell = row.createCell(2,CellType.NUMERIC);
                cell.setCellValue(hoaDon.getSoLuongNhap());
                
            }
            File file = new File("D:/hv.xlsx");
            try {
                FileOutputStream out = new FileOutputStream(file);
                workbook.write(out);
                out.close();
            } catch (FileNotFoundException e) {
                    e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}