/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlythietbi.Dieu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.beans.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SigUp extends javax.swing.JFrame {

    /**
     * Creates new form SigUp
     */
    public SigUp() {
        initComponents();
        setLocationRelativeTo(null);
    }
//    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    final String Url = "jdbc:sqlserver://DESKTOP-JADGEKH\\SQLEXPRESS01:1433;databaseName=QuanlyThietBi";
//    final String user = "sa";
//    final String password = "39151111";
//    Statement st;
//    ResultSet rs;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        pass1 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JPasswordField();
        bttdangki120 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("FormDangKy");

        username.setBackground(new java.awt.Color(255, 204, 0));
        username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 51, 51));
        username.setText("UserName");

        pass.setBackground(new java.awt.Color(255, 0, 51));
        pass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass.setText("Password");

        pass1.setBackground(new java.awt.Color(255, 0, 51));
        pass1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pass1.setText("Mã Nhân Viên");

        bttdangki120.setBackground(new java.awt.Color(0, 204, 153));
        bttdangki120.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bttdangki120.setForeground(new java.awt.Color(255, 255, 255));
        bttdangki120.setText("Đăng Kí");
        bttdangki120.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bttdangki120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttdangki120ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addComponent(pass)
                    .addComponent(pass1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtuser)
                    .addComponent(txtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtmanv))
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(bttdangki120, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass1))
                .addGap(36, 36, 36)
                .addComponent(bttdangki120, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final String Url = "jdbc:sqlserver://DESKTOP-JADGEKH\\SQLEXPRESS01:1433;databaseName=QuanlyThietBi";
    final String user = "sa";
    final String password = "39151111";
    Statement st;
    ResultSet rs;

    private void bttdangki120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttdangki120ActionPerformed
        // TODO add your handling code here:
        int dk = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng kí?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (dk != JOptionPane.YES_OPTION) {
        return;
    }
    try {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(Url, user, password);
        String sql = "insert into NguoiDung values (?,?,?)"; // Thêm dấu ngoặc đóng vào đây
        PreparedStatement ps = con.prepareStatement(sql);
        if (txtuser.getText().equals("") || txtpass.getText().equals("") || txtmanv.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không để thông tin trống");
            return; // Thêm câu lệnh return ở đây
        }
        ps.setString(1, txtuser.getText());
        ps.setString(2, txtpass.getText());
        ps.setString(3, txtmanv.getText());
        int n = ps.executeUpdate();
        if (n != 0) {
            JOptionPane.showMessageDialog(this, "Đăng kí thành công");
            this.dispose(); // Đóng form hiện tại
            Login loginForm = new Login();
            loginForm.setVisible(true); // Mở form đăng nhập
        } else {
            JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
        }
        ps.close();
        con.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL: " + e.getMessage());
    }
    }//GEN-LAST:event_bttdangki120ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SigUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SigUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SigUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SigUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SigUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttdangki118;
    private javax.swing.JButton bttdangki119;
    private javax.swing.JButton bttdangki120;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel pass1;
    private javax.swing.JPasswordField txtmanv;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
