package ui;

import dao.LocadorasDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import model.Locadora;

/**
 *
 * @author a1921843
 */
public class LocadoraJDialog extends javax.swing.JFrame {
    
    public LocadoraJDialog(java.awt.Frame parent, boolean modal) {
        initComponents();
        try {
            loadRecords();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 100, 40));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 100, 40));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 100, 40));

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 100, 40));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 100, 40));

        jPanel2.setBackground(new java.awt.Color(155, 155, 155));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jTextField1.setEnabled(false);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 230, 30));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jTextField2.setEnabled(false);
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 500, 30));

        jLabel1.setText("Cidade:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel2.setText("Registro de Locadora:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel3.setText("CNPJ:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 560, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CNPJ", "Cidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                                                                                                               
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        clearInputBoxes();
        enableButtons(true, false, false, false);
        addRecord = false;
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        addRecord = true;
        clearInputBoxes();
        
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        
        enableButtons(false, true, true, true);
        
        jTextField1.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja salvar esse registro?", "Confirmação?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRecord == true) {
                    addNew();
                } else {
                    updateRecord();
                }
                addRecord = false;
                
                jTextField1.setEnabled(false);
                jTextField2.setEnabled(false);
                
                enableButtons(true, false, false, true);
                
                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (!jTextField1.getText().isEmpty()) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esse registro?", "Confirmação?", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                try {
                    deleteRecord();
                    loadRecords();
                    clearInputBoxes();
                    enableButtons(true, false, false, false);
                    
                    jTextField2.setEnabled(false);
                    
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if (jTextField1.getText().length() >= 20 )
            evt.consume();     
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if (jTextField2.getText().length() >= 100 )
            evt.consume();  
    }//GEN-LAST:event_jTextField2KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    boolean addRecord = false;

    private void clearInputBoxes() {
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void addNew() throws SQLException {
        Locadora l = new Locadora();
        l.setCNPJ(jTextField1.getText());
        l.setCidade(jTextField2.getText());
        LocadorasDAO dao = new LocadorasDAO();
        dao.insert(l);
    }

    private void updateRecord() throws SQLException {
        Locadora p = new Locadora();
        p.setCNPJ(jTextField1.getText());
        p.setCidade(jTextField2.getText());
        LocadorasDAO dao = new LocadorasDAO();
        dao.update(p);
    }

    private void deleteRecord() throws SQLException {
        LocadorasDAO dao = new LocadorasDAO();
        dao.remove(jTextField1.getText());
    }

    private void loadRecords() throws SQLException {
        String sql = "SELECT CNPJ, cidade FROM mydb.Locadora ORDER BY CNPJ";
        ResultSetTableModel tableModel = new ResultSetTableModel(sql);
        jTable1.setModel(tableModel);
        
        jTable1.getColumnModel().getColumn(0).setWidth(50);
        jTable1.getColumnModel().getColumn(0).setMinWidth(50);
        //jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        
        jTable1.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (jTable1.getSelectedRow() >= 0) {
                    Object s = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
                    Object n = jTable1.getValueAt(jTable1.getSelectedRow(), 1);

                    jTextField1.setText(s.toString());
                    jTextField2.setText(n.toString());
                    
                    jTextField2.setEnabled(true);
                    enableButtons(true, true, true, true);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }
    
    public void enableButtons(boolean novo, boolean salvar, boolean cancelar, boolean remover){
        btnNovo.setEnabled(novo);
        btnSalvar.setEnabled(salvar);
        btnCancelar.setEnabled(cancelar);
        btnRemover.setEnabled(remover);
    }
}
