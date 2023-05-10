
package Form;

import Connection.DBContext;
import Event.EventClickButton;
import Event.EventClose;
import Model.Model_Card;
import Model.PhieuNhap;
import Model.ThietBi;
import Swing.ScrollBar;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {
    private EventClose event;
    
    public void addEventClose(EventClose event) {
        this.event = event;
    }
    List<ThietBi> tbData = new ArrayList<>();
    public Form_Home() throws Exception {
        initComponents();
        
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p =new JPanel();
        p.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        sp.getViewport().setBackground(Color.WHITE);
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/PNG/add.png")), "Thêm thiết bị", "", ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/PNG/edit.png")), "Sửa thiết bị", "", ""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/PNG/delete.png")), "Xoá thiết bị", "", ""));
        
        sp.setVerticalScrollBar(new ScrollBar());
        
        showData();
        loadTable();
        updateComboboxLoaiTB();
        updateComboboxTH();
        updateComboboxKho();
        addComboboxLoaiTB();
        addComboboxTH();
        addComboboxKho();
        
        Add_mTB_TF.disable();
    }
    public void loadTable() throws Exception{
        //Add Row Table
        table.removeAll();
        for (ThietBi tb : tbData) {          
            table.addRow(new Object[]{
                tb.getmTB(),
                tb.getmLTB(),
                tb.getmTH(),
                tb.getTenTB(),
                tb.getDvTinh(),
                tb.getGiaNhap(),
                tb.getmKho(),
                tb.getSoLuong()
            });
        }
        
        table.repaint();
        table.validate();
    }
     private String data;
    Connection conn;
    Statement st;
    ResultSet rs;   
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new Component.Card();
        card2 = new Component.Card();
        card3 = new Component.Card();
        hidePanel = new javax.swing.JPanel();
        panelBorder1 = new Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        table = new Swing.Table();
        panelBorder2 = new Swing.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTenThietBi = new javax.swing.JTextField();
        Add_mTB_TF = new javax.swing.JTextField();
        txtDonViTinh = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        Add_spHong_TF = new javax.swing.JTextField();
        Add_hsd_TF = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cbbThuongHieu = new Swing.ComboBoxSuggestion();
        cbbLoaiThietBi = new Swing.ComboBoxSuggestion();
        cbbKho = new Swing.ComboBoxSuggestion();
        header = new Swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();
        ButtonAdd = new Swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        panelBorder3 = new Swing.PanelBorder();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCapNhat_TenThietBi = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        txtCapNhat_DonViTinh = new javax.swing.JTextField();
        txtCapNhat_Gia = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        txtCapNhat_SoLuong = new javax.swing.JTextField();
        cboCapNhap_ThuongHieu = new Swing.ComboBoxSuggestion();
        cboCapNhap_LoaiThietBi = new Swing.ComboBoxSuggestion();
        cboCapNhap_Kho = new Swing.ComboBoxSuggestion();
        panelBorder5 = new Swing.PanelBorder();
        jLabel14 = new javax.swing.JLabel();
        lbBack2 = new javax.swing.JLabel();
        panelBorder9 = new Swing.PanelBorder();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 241, 241));
        setDoubleBuffered(false);

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        card1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1MouseClicked(evt);
            }
        });
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        card2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2MouseClicked(evt);
            }
        });
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        card3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card3MouseClicked(evt);
            }
        });
        panel.add(card3);

        hidePanel.setOpaque(false);
        hidePanel.setLayout(new java.awt.CardLayout());

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Danh sách thiết bị");

        sp.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Loại thiết bị", "Đơn vị tính", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        hidePanel.add(panelBorder1, "card2");

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã thiết bị:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên thiết bị:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Đơn vị tính:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá nhập:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Thương hiệu:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Mã Kho:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Loại thiết bị:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số lượng:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("HSD:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Sản phẩm hỏng:");

        txtTenThietBi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Add_mTB_TF.setText("Auto");
        Add_mTB_TF.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDonViTinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtGia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Add_spHong_TF.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Add_hsd_TF.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSoLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbThuongHieu.setOpaque(false);

        cbbLoaiThietBi.setOpaque(false);

        cbbKho.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenThietBi)
                    .addComponent(Add_mTB_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cbbLoaiThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cbbKho, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel7)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_hsd_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add_spHong_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(129, 129, 129))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbLoaiThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(Add_spHong_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_mTB_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(Add_hsd_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );

        header.setBackground(new java.awt.Color(142, 142, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thêm thiết bị");

        lbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assest/back.png"))); // NOI18N
        lbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbBack))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        ButtonAdd.setBackground(new java.awt.Color(142, 142, 250));
        ButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAddMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thêm mới");

        javax.swing.GroupLayout ButtonAddLayout = new javax.swing.GroupLayout(ButtonAdd);
        ButtonAdd.setLayout(ButtonAddLayout);
        ButtonAddLayout.setHorizontalGroup(
            ButtonAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAddLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ButtonAddLayout.setVerticalGroup(
            ButtonAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAddLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        hidePanel.add(panelBorder2, "card2");

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Mã thiết bị:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tên thiết bị:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Đơn vị tính:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giá nhập:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Thương hiệu:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Mã Kho:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Loại thiết bị:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Số lượng:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("HSD:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Sản phẩm hỏng:");

        txtCapNhat_TenThietBi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCapNhat_TenThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapNhat_TenThietBiActionPerformed(evt);
            }
        });

        jTextField9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        txtCapNhat_DonViTinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCapNhat_Gia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCapNhat_SoLuong.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCapNhat_TenThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(cboCapNhap_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cboCapNhap_LoaiThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(cboCapNhap_Kho, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jTextField9))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jTextField13)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel22))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCapNhat_DonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapNhat_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtCapNhat_SoLuong)))))
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtCapNhat_DonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtCapNhat_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtCapNhat_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboCapNhap_LoaiThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboCapNhap_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboCapNhap_Kho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCapNhat_TenThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBorder5.setBackground(new java.awt.Color(186, 123, 247));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Sửa thiết bị");

        lbBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assest/back.png"))); // NOI18N
        lbBack2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBack2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbBack2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBack2)
                    .addComponent(jLabel14))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelBorder9.setBackground(new java.awt.Color(186, 123, 247));
        panelBorder9.setPreferredSize(new java.awt.Dimension(150, 45));
        panelBorder9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBorder9MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText(" Thay đổi");

        javax.swing.GroupLayout panelBorder9Layout = new javax.swing.GroupLayout(panelBorder9);
        panelBorder9.setLayout(panelBorder9Layout);
        panelBorder9Layout.setHorizontalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel27)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelBorder9Layout.setVerticalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel27)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        hidePanel.add(panelBorder3, "card2");

        jLabel25.setForeground(new java.awt.Color(127, 127, 127));
        jLabel25.setText("Quản lý Thiết bị");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void showData() throws Exception {
        try {
            table.removeAll();
            String[] arr = { "mTB","mLTB","mTH","tenTB","dvTinh","giaNhap","mKho","soLuong"};
            DefaultTableModel model = new DefaultTableModel(arr,0) {
                @Override//Override lại phương thức isCellEditable
                public boolean isCellEditable(int row, int column) {
                    return false;//Trả về false không cho edit.
                }
                };
            DBContext db = new DBContext();
            conn = db.getConnection();

            String query = "SELECT *FROM ThietBi";
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            Vector vector = null;
            while (rs.next()) {
                vector = new Vector();
                vector.add(rs.getString("mTB"));
                vector.add(rs.getString("mLTB"));
                vector.add(rs.getString("mTH"));
                vector.add(rs.getString("tenTB"));
                vector.add(rs.getString("dvTinh"));
                vector.add(rs.getString("giaNhap"));
                vector.add(rs.getString("mKho"));
                vector.add(rs.getString("soLuong"));
                
                model.addRow(vector);
            }
            table.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateComboboxLoaiTB()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from LoaiThietBi";
       
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cboCapNhap_LoaiThietBi.addItem(rs.getString("tenLTB"));
            }
        } catch (Exception e) {
        }
    }
    
    public void updateComboboxTH()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from ThuongHieu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cboCapNhap_ThuongHieu.addItem(rs.getString("tenLTH"));
            }
        } catch (Exception e) {
        }
    }
    
    
    public void updateComboboxKho()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from kho";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cboCapNhap_Kho.addItem(rs.getString("tenKho"));
            }
        } catch (Exception e) {
        }
    }
    public void addComboboxLoaiTB()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from LoaiThietBi";
       
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cbbLoaiThietBi.addItem(rs.getString("tenLTB"));
            }
        } catch (Exception e) {
        }
    }
    
    public void addComboboxTH()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from ThuongHieu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cbbThuongHieu.addItem(rs.getString("tenLTH"));
            }
        } catch (Exception e) {
        }
    }
    
    
    public void addComboboxKho()throws Exception{
        DBContext db = new DBContext();
        conn = db.getConnection();
        String sql = "SELECT * from kho";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                cbbKho.addItem(rs.getString("tenKho"));
            }
        } catch (Exception e) {
        }
    }
    private void showDataUpdateForm(String idc)throws Exception{
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            //String sql1 = "SELECT * FROM ThietBi where mTB = '" + idc + "'";
            String sql = "select  *\n" +
                            "from ThietBi as tb\n" +
                            "inner join LoaiThietBi as ltb\n" +
                            "	on tb.mLTB = ltb.mLTB\n" +
                            "inner join kho as k \n" +
                            "	on tb.mKho = k.mKho\n" +
                            "inner join ThuongHieu as th\n" +
                            "	on tb.mTH = th.mTH\n" +
                            "where tb.mTB = '" + idc + "'" ;
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                txtCapNhat_TenThietBi.setText(rs.getString("tenTB"));
                txtCapNhat_SoLuong.setText(rs.getString("soLuong"));
                txtCapNhat_Gia.setText(rs.getString("giaNhap"));
                txtCapNhat_DonViTinh.setText(rs.getString("dvTinh"));
                cboCapNhap_LoaiThietBi.setSelectedItem(rs.getString("tenLTB"));
                cboCapNhap_ThuongHieu.setSelectedItem(rs.getString("tenLTH"));
                cboCapNhap_Kho.setSelectedItem(rs.getString("tenKho"));
            }
            conn.close();
        } catch (SQLException ex) {
        }
    }
    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        
        CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
        cardLayout.addLayoutComponent(panelBorder2, "2");
        cardLayout.show(hidePanel,"2");
    }//GEN-LAST:event_card1MouseClicked

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        if (table.getSelectedRow()==-1) {
            JOptionPane.showMessageDialog(this, "Chọn thiết bị muốn thay đổi","ERROR",JOptionPane.ERROR_MESSAGE);
            CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
            cardLayout.addLayoutComponent(panelBorder1, "1");
            cardLayout.show(hidePanel,"1");
        
        }else{
            int position = table.getSelectedRow();
            data = table.getModel().getValueAt(position, 0).toString();
            try {
                showDataUpdateForm(data);
            } catch (Exception ex) {
                
            }            
         
        CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
        cardLayout.addLayoutComponent(panelBorder3, "3");
        cardLayout.show(hidePanel,"3");
        }
        
        
    }//GEN-LAST:event_card2MouseClicked

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            int position = table.getSelectedRow();
            String idXoa = table.getModel().getValueAt(position, 0).toString();
            PreparedStatement comm = conn.prepareStatement("Delete ThietBi where mTB=?");
            comm.setString(1, idXoa);
            if(JOptionPane.showConfirmDialog(this, "Xóa thiết bị này?","Xác nhận",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
                comm.executeUpdate();
            }
            showData();
        } catch (Exception e) {
            System.out.println(e.toString());
        }      
    }//GEN-LAST:event_card3MouseClicked

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
        cardLayout.addLayoutComponent(panelBorder1, "1");
        cardLayout.show(hidePanel,"1");
    }//GEN-LAST:event_lbBackMouseClicked

    private void lbBack2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBack2MouseClicked
        CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
        cardLayout.addLayoutComponent(panelBorder1, "1");
        cardLayout.show(hidePanel,"1");
    }//GEN-LAST:event_lbBack2MouseClicked

    private void txtCapNhat_TenThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapNhat_TenThietBiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapNhat_TenThietBiActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void panelBorder9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder9MouseClicked
        // TODO add your handling code here:
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            String sql = "UPDATE ThietBi\n" +
             "SET tenTB = ?, soLuong = ?, giaNhap = ?, dvTinh = ?," +
             "mLTB = (select mLTB from LoaiThietBi where tenLTB = ?), " +
             "mKho = (select mKho from kho where tenKho = ?), " +
             "mTH =  (select mTH from ThuongHieu where tenLTH = ?) " +
             "WHERE mTB = ?";          
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtCapNhat_TenThietBi.getText());
            ps.setString(2, txtCapNhat_SoLuong.getText());
            ps.setString(3, txtCapNhat_Gia.getText());
            ps.setString(4, txtCapNhat_DonViTinh.getText());
            ps.setString(5, (String) cboCapNhap_LoaiThietBi.getSelectedItem());
            ps.setString(6, (String) cboCapNhap_Kho.getSelectedItem());
            ps.setString(7, (String) cboCapNhap_ThuongHieu.getSelectedItem());
            ps.setString(8, data); 

            ps.execute();
            showData();
            CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
            cardLayout.addLayoutComponent(panelBorder1, "1");
            cardLayout.show(hidePanel,"1");
            
        } catch (Exception ex) {
        } 
        
    }//GEN-LAST:event_panelBorder9MouseClicked

    private void ButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAddMouseClicked
        try {
            if(txtTenThietBi.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Chưa có tên thiết bị");
            }else{
                DBContext db = new DBContext();
                conn = db.getConnection();
                PreparedStatement ps1, ps2, ps3, ps4, ps5, ps;
                ResultSet rs, rs1, rs2, rs3, rs4;
                String mtb, mth, mltb,mkho;
                mtb = "";
                mltb = "";
                mth = "";
                mkho ="";
                String sql1 = "{? = CALL AUTO_IDTB()}";
                String sql2 = "Select mLTB from LoaiThietBi where tenLTB = N'"+cbbLoaiThietBi.getSelectedItem()+"'";
                String sql3 = "Select mTH from ThuongHieu where tenLTH = '"+cbbThuongHieu.getSelectedItem()+"'";
                String sql4 = "Select mKho from kho where tenKho = '"+cbbKho.getSelectedItem()+"'";
                String sql = "Insert into ThietBi(mTB,mLTB,mTH,tenTB,dvTinh,giaNhap,mKho,soLuong) values (?,?,?,?,?,?,?,?)";

                CallableStatement stmt = conn.prepareCall(sql1);
                stmt.registerOutParameter(1, Types.VARCHAR);
                ps2 = conn.prepareStatement(sql2);
                ps3 = conn.prepareStatement(sql3);
                ps4 = conn.prepareStatement(sql4);
                ps = conn.prepareStatement(sql);

                stmt.execute();
                rs2 = ps2.executeQuery();
                rs3 = ps3.executeQuery();
                rs4 = ps4.executeQuery();

                mtb = stmt.getString(1);
                if (rs2.next()) {
                    mltb = rs2.getString("mLTB"); 
                }
                if (rs3.next()) {
                    mth = rs3.getString("mTH");
                }
                if (rs4.next()) {
                    mkho = rs4.getString("mKho");
                }

                ps.setString(1, mtb);
                ps.setString(2, mltb);
                ps.setString(3, mth);
                ps.setString(4, txtTenThietBi.getText());
                ps.setString(5, txtDonViTinh.getText());
                ps.setString(6, txtGia.getText());    
                ps.setString(7, mkho);
                ps.setString(8, txtSoLuong.getText());
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                }
                showData();
                stmt.close();
                conn.close();
                CardLayout cardLayout = (CardLayout) hidePanel.getLayout();
                cardLayout.addLayoutComponent(panelBorder1, "1");
                cardLayout.show(hidePanel,"1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonAddMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Add_hsd_TF;
    private javax.swing.JTextField Add_mTB_TF;
    private javax.swing.JTextField Add_spHong_TF;
    private Swing.PanelBorder ButtonAdd;
    private Component.Card card1;
    private Component.Card card2;
    private Component.Card card3;
    private Swing.ComboBoxSuggestion cbbKho;
    private Swing.ComboBoxSuggestion cbbLoaiThietBi;
    private Swing.ComboBoxSuggestion cbbThuongHieu;
    private Swing.ComboBoxSuggestion cboCapNhap_Kho;
    private Swing.ComboBoxSuggestion cboCapNhap_LoaiThietBi;
    private Swing.ComboBoxSuggestion cboCapNhap_ThuongHieu;
    private Swing.PanelBorder header;
    private javax.swing.JPanel hidePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbBack2;
    private javax.swing.JLayeredPane panel;
    private Swing.PanelBorder panelBorder1;
    private Swing.PanelBorder panelBorder2;
    private Swing.PanelBorder panelBorder3;
    private Swing.PanelBorder panelBorder5;
    private Swing.PanelBorder panelBorder9;
    private javax.swing.JScrollPane sp;
    private Swing.Table table;
    private javax.swing.JTextField txtCapNhat_DonViTinh;
    private javax.swing.JTextField txtCapNhat_Gia;
    private javax.swing.JTextField txtCapNhat_SoLuong;
    private javax.swing.JTextField txtCapNhat_TenThietBi;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThietBi;
    // End of variables declaration//GEN-END:variables
}
