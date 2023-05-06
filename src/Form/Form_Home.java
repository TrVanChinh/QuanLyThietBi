
package Form;

import Model.Model_Card;
import Swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {

    public Form_Home() {
        initComponents();
        
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p =new JPanel();
        p.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        sp.getViewport().setBackground(Color.WHITE);
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/setting.png")), "Thêm thiết bị", "", ""));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/setting.png")), "Sửa thiết bị", "", ""));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/assets/setting.png")), "Xoá thiết bị", "", ""));
        
        sp.setVerticalScrollBar(new ScrollBar());
        
        //Add Row Table
        table.addRow(new Object[]{"TB01","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB02","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB03","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB04","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB05","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB06","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB07","Điện thoại Samsung","Điện thoại","Cái","123"});
        table.addRow(new Object[]{"TB08","Điện thoại Samsung","Điện thoại","Cái","123"});
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new Component.Card();
        card2 = new Component.Card();
        card3 = new Component.Card();
        panelBorder1 = new Swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        table = new Swing.Table();

        setBackground(new java.awt.Color(242, 241, 241));
        setDoubleBuffered(false);

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.Card card1;
    private Component.Card card2;
    private Component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane sp;
    private Swing.Table table;
    // End of variables declaration//GEN-END:variables
}
