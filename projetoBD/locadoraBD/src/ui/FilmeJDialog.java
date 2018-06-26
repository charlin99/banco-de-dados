package ui;

import dao.FilmesDAO;
import dao.CategoriasDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import model.Filme;
import model.Categoria;

/**
 *
 * @author Carlos
 */
public class FilmeJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ProdutoJDialog
     */
    public FilmeJDialog(java.awt.Frame parent, boolean modal) throws IOException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        try {
            loadRecords();
            fillCBCategoria();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPreço = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CBFilme = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Filme", "Nome", "Preço", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 556, 280));

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel2.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 100, 40));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 100, 40));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 100, 40));

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 100, 40));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 100, 40));

        jPanel3.setBackground(new java.awt.Color(155, 155, 155));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));
        jPanel3.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 500, 30));

        jLabel8.setText("Nome:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel10.setText("Registro de Produtos:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel11.setText("Id do Produto:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel3.add(txtPreço, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 30));

        jLabel12.setText("Preço:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel13.setText("Categoria:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        CBFilme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(CBFilme, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 560, 240));

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtNome.setEnabled(false);
        txtID.setEnabled(false);
        CBFilme.setEnabled(false);
        txtPreço.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        addRecord = true;
        clearInputBoxes();
        CBFilme.requestFocus();
        enableButtons(false, true, true, false);
        txtID.setEnabled(true);
        txtNome.setEnabled(true);
        txtPreço.setEnabled(true);
        CBFilme.setEnabled(true);
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
                loadRecords();
                enableButtons(true, false, false, false);
                txtID.setEnabled(false);
                txtNome.setEnabled(false);
                txtPreço.setEnabled(false);
                CBFilme.setEnabled(false);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } 
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir esse registro?", "Confirmação?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                deleteRecord();
                loadRecords();
                clearInputBoxes();
                enableButtons(true, false, false, false);
                txtID.setEnabled(false);
                txtNome.setEnabled(false);
                txtPreço.setEnabled(false);
                CBFilme.setEnabled(false);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBFilme;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreço;
    // End of variables declaration//GEN-END:variables
    
    boolean addRecord = false;

    private void clearInputBoxes() {
        txtID.setText("");
        txtNome.setText("");
    }
    
    private void addNew() throws SQLException {
        CategoriasDAO cDao = new CategoriasDAO(); 
        Filme f = new Filme();
        f.setId(Integer.parseInt(txtID.getText()));
        f.setNome(txtNome.getText());
        f.setPreco(Float.parseFloat(txtPreço.getText()));
        f.setCategoria(cDao.find((String) CBFilme.getSelectedItem()));
        FilmesDAO dao = new FilmesDAO();
        dao.insert(f);
    }
    
    private void updateRecord() throws SQLException {
        CategoriasDAO cDao = new CategoriasDAO(); 
        Filme f = new Filme();
        f.setId(Integer.parseInt(txtID.getText()));
        f.setNome(txtNome.getText());
        f.setPreco(Float.parseFloat(txtPreço.getText()));
        f.setCategoria(cDao.find((String) CBFilme.getSelectedItem()));
        FilmesDAO dao = new FilmesDAO();
        dao.update(f);
    }

    private void deleteRecord() throws SQLException {
        FilmesDAO dao = new FilmesDAO();
        dao.remove(Integer.parseInt(txtID.getText()));
    }
    
    private void loadRecords() throws SQLException {
        String sql = "SELECT ID, Nome, Preço, Categoria FROM mydb.Filme ORDER BY ID;";
        ResultSetTableModel tableModel = new ResultSetTableModel(sql);
        jTable1.setModel(tableModel);
        
        jTable1.getColumnModel().getColumn(0).setWidth(50);
        jTable1.getColumnModel().getColumn(0).setMinWidth(50);
        
       
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                try {
                    if (jTable1.getSelectedRow() >= 0) {
                        
                        Object ID = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
                        Object Nome = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1);
                        Object Preço = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2);
                        Object Categoria = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3);
                        
                        txtID.setText(ID.toString());
                        txtNome.setText(Nome.toString());
                        txtPreço.setText(Preço.toString());
                        CBFilme.setSelectedItem(Categoria.toString());
                        
                        enableButtons(false, true, true, true);
                        txtID.setEnabled(true);
                        txtNome.setEnabled(true);
                        txtPreço.setEnabled(true);
                        CBFilme.setEnabled(true);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }  

    private void fillCBCategoria() throws SQLException, IOException, ClassNotFoundException {
        CategoriasDAO dao = new CategoriasDAO();
        List<Categoria> categorias = dao.list();
        CBFilme.removeAllItems();
        for(Categoria c : categorias){
            CBFilme.addItem((c.getSigla()));
        }     
    } 
    
    public void enableButtons(boolean novo, boolean salvar, boolean cancelar, boolean remover){
        btnNovo.setEnabled(novo);
        btnSalvar.setEnabled(salvar);
        btnCancelar.setEnabled(cancelar);
        btnRemover.setEnabled(remover);
    }
}