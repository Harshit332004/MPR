package GUI;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JLabel;






/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class FINDFACILITIES extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    
    /**
     * Creates new form FINDFACILITIES
     */
    public FINDFACILITIES() {
        initComponents();
        table_update();
         
        
        
       



    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\SWIMMINGGRADIANT.jpg")); // NOI18N
        jLabel1.setText("UPAR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 90));

        jLabel2.setFont(new java.awt.Font("Swis721 BlkCn BT", 3, 29)); // NOI18N
        jLabel2.setText("FIND OUR FACILITIES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 350, 40));

        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AREA", "ADDRESS", "SPORT1", "SPORT2"
            }
        ));
        TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLE);
        if (TABLE.getColumnModel().getColumnCount() > 0) {
            TABLE.getColumnModel().getColumn(0).setMinWidth(180);
            TABLE.getColumnModel().getColumn(0).setPreferredWidth(180);
            TABLE.getColumnModel().getColumn(0).setMaxWidth(180);
            TABLE.getColumnModel().getColumn(2).setMinWidth(180);
            TABLE.getColumnModel().getColumn(2).setPreferredWidth(180);
            TABLE.getColumnModel().getColumn(2).setMaxWidth(180);
            TABLE.getColumnModel().getColumn(3).setMinWidth(180);
            TABLE.getColumnModel().getColumn(3).setPreferredWidth(180);
            TABLE.getColumnModel().getColumn(3).setMaxWidth(180);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1460, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 200, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("SEARCH :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 140, 40));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 190, 40));

        jLabel4.setText("SPORT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, -1, -1));

        jLabel5.setText("AREA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, -1, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\SWIMMINGGRADIANT.jpg")); // NOI18N
        jLabel7.setText("PURA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1490, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void table_update() {
        int CC;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost/mpr", "root", "MyNewPass");
            pst = con.prepareStatement("SELECT * FROM CityAddress");
            rs = pst.executeQuery();

            ResultSetMetaData RSMD = rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) TABLE.getModel();
            DFT.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(rs.getString("City"));
                    v2.add(rs.getString("Address"));
                     v2.add(rs.getString("Sport1"));
                      v2.add(rs.getString("Sport2"));
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
private void filterTable() {
    DefaultTableModel tableModel = (DefaultTableModel) TABLE.getModel();
    TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
    TABLE.setRowSorter(rowSorter);

    String areaText = jTextField1.getText().toLowerCase();
    String sportText = jTextField2.getText().toLowerCase();

    RowFilter<DefaultTableModel, Object> areaFilter = RowFilter.regexFilter("(?i)" + areaText, 0); // 0 is the column index for "Area"
    RowFilter<DefaultTableModel, Object> sportFilter = RowFilter.regexFilter("(?i)" + sportText, 2, 3); // 2 and 3 are the column indices for "Sport1" and "Sport2"

    if (areaText.trim().isEmpty() && sportText.trim().isEmpty()) {
        rowSorter.setRowFilter(null);
    } else {
        List<RowFilter<DefaultTableModel, Object>> filters = new ArrayList<>();
        filters.add(areaFilter);

        if (!sportText.trim().isEmpty()) {
            filters.add(sportFilter);
        }

        // Combine the filters to require the area filter and optionally the sport filter
        RowFilter<DefaultTableModel, Object> combinedFilter = RowFilter.andFilter(filters);
        rowSorter.setRowFilter(combinedFilter);
    }
}



    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
filterTable();



// DefaultTableModel tableModel = (DefaultTableModel) TABLE.getModel();
//    TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
//    TABLE.setRowSorter(rowSorter);
//
//    String text = jTextField1.getText().toLowerCase();
//    if (text.trim().length() == 0) {
//        rowSorter.setRowFilter(null);
//    } else {
//        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0, 2, 3)); // 0, 2, and 3 are the column indices for "Area", "Sport1", and "Sport2"
//    }
       
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
 filterTable();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEMouseClicked
        int column = TABLE.getSelectedColumn();

    if (column >= 0) {
        openGoogleMaps();
    }
}

private void openGoogleMaps() {
    try {
        String url = "https://www.google.com/maps";
        java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }//GEN-LAST:event_TABLEMouseClicked

   
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
            java.util.logging.Logger.getLogger(FINDFACILITIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FINDFACILITIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FINDFACILITIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FINDFACILITIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FINDFACILITIES().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void setTextFieldHint(JTextField jTextField1, String area) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}