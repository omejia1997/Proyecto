/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Mejia
 */
public class FrmInventoryModify extends javax.swing.JFrame {
    File file = new File("Product.txt");
    ArrayList<Product> products = new ArrayList<>();
    Product product;

    /**
     * Creates new form ProductJFrame
     */
    public FrmInventoryModify() {
        initComponents();
        this.getContentPane().setBackground(Color.lightGray);
        
        seeInventory(products);
        this.setLocationRelativeTo(null);
    }
    
    private void cleanComponents(){
        this.txtCode.setText("");
        this.txtModify.setText("");
    }
    
    public boolean validateEmptyIncome(){
    boolean validate=false;
        if("".equals(txtCode.getText())) validate = true;
        if("".equals(txtModify.getText())) validate = true;
        return  validate;    
    }
    
    private void seeInventory(ArrayList<Product> product){
        FileManager.createArrayOfFile(products, file);
        String matriz[][] = new String[product.size()][4];
                for (int i = 0; i < product.size(); i++) {
                    matriz[i][0] = product.get(i).getCodeProduct();
                    matriz[i][1] = product.get(i).getNameProduct();
                    matriz[i][2] = String.valueOf(product.get(i).getCost());
                    matriz[i][3] = String.valueOf(product.get(i).getStock());
                    }
                tblInventory.setModel(new javax.swing.table.DefaultTableModel( matriz,new String []{"Codigo","Nombre","Costo","Stock"}));
                tblInventory.getColumnModel().getColumn(0).setPreferredWidth(20);
                tblInventory.getColumnModel().getColumn(1).setPreferredWidth(150);
                tblInventory.getColumnModel().getColumn(2).setPreferredWidth(20);
                tblInventory.getColumnModel().getColumn(3).setPreferredWidth(20);
    products.clear();
    }
    
    private int validateProduct(){
        if(validateEmptyIncome()){
            JOptionPane.showMessageDialog(null, "Debe Ingresar todos los parámetros","Ingreso inválido",JOptionPane.WARNING_MESSAGE);        
            return -1 ;
        }
        
        if(!Validations.validateProduct(products, file,txtCode.getText())){
                JOptionPane.showMessageDialog(null, "El producto no se encuentra registrado","Producto no Registrado",JOptionPane.WARNING_MESSAGE);        
            return -1;
            }
        
        if(cbxProduct.getSelectedItem().toString().equals("Elija una opción")){
            JOptionPane.showMessageDialog(null, "Elija una opción para modificar","Seleccione alguna opción",JOptionPane.WARNING_MESSAGE);        
            return -1;
        }
        return 1;
    }
    
    public int useCmbox(String choose){
        switch(choose){
                case "Código":
                    if(!Validations.isNumeric(txtModify.getText())  && !Validations.validateProduct(products, file, txtModify.getText()) && txtModify.getText().length() == 4){
                    product.modifyCodeProduct(txtCode.getText(),txtModify.getText(), products, file);  
                    JOptionPane.showMessageDialog(rootPane,"Su producto ha sido correctamente modificado");
                    }else if(Validations.validateProduct(products, file, txtModify.getText())){
                    JOptionPane.showMessageDialog(null, "El nuevo código ya ha sido asignado para otro Producto","Ingreso inválido",JOptionPane.WARNING_MESSAGE);       
                    return -1;
                    
                    }else if(Validations.isNumeric(txtModify.getText())){
                    JOptionPane.showMessageDialog(null, "No se admite el ingreso de caracteres no Númericos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
                    return -1;
                    }
                    else if(txtModify.getText().length() < 4){
                    JOptionPane.showMessageDialog(null, "Debe ingresar 4 dígitos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
                    return -1;   
                    }
                    break;
            
                case "Nombre":
                    if(Validations.isNumeric(txtModify.getText()) && !Validations.validateNameProduct(products, file, txtModify.getText().toUpperCase())){
                    product.modifyNameProduct(txtCode.getText(), txtModify.getText(),products, file);
                    JOptionPane.showMessageDialog(rootPane,"Su producto ha sido correctamente modificado");
                    }else if(Validations.validateNameProduct(products, file, txtModify.getText().toUpperCase())){
                    JOptionPane.showMessageDialog(null, "El nuevo nombre del producto ya ha sido asignado para otro Producto","Ingreso inválido",JOptionPane.WARNING_MESSAGE);        
                    return -1;
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "No se admite el ingreso de dígitos numéricos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);    
                    return -1;
                    }
                    break;
                    
                case "Costo":
                    if(!Validations.isNumeric(txtModify.getText()) && Validations.validateDecimals(txtModify.getText())){
                    product.modifyCostProduct(txtCode.getText(), txtModify.getText(),products,file);
                    JOptionPane.showMessageDialog(rootPane,"Su producto ha sido correctamente modificado");
                    }else if(!Validations.validateDecimals(txtModify.getText())){
                    JOptionPane.showMessageDialog(null, "Valor de Costo inválido","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
                    return -1;
                    }else{
                    JOptionPane.showMessageDialog(null, "Solo se admite el ingreso de digitos numéricos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);    
                    return -1;
                    }
                    break;
                    
                case "Stock":
                    if(!Validations.isNumeric(txtModify.getText()) && Validations.validateIntStock(txtModify.getText()) ){
                    product.modifyStockProduct(txtCode.getText(), txtModify.getText(),products,file);
                    JOptionPane.showMessageDialog(rootPane,"Su producto ha sido correctamente modificado");
                    }else if(!Validations.validateIntStock(txtModify.getText())){
                    JOptionPane.showMessageDialog(null, "Revise su entrada de Datos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);
                    return -1;
                    }else{
                    JOptionPane.showMessageDialog(null, "Solo se admite el ingreso de digitos numéricos","Ingreso inválido",JOptionPane.WARNING_MESSAGE);    
                    return -1;
                    }
                    break;
        }
        return 1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModify = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        lblInventary = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        txtModify = new javax.swing.JTextField();
        cbxProduct = new javax.swing.JComboBox<>();
        txtCode = new javax.swing.JTextField();
        jBtnSave = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        lblModify.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblModify.setText("¿Que desea modificar?  :");

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCode.setText("Ingrese el código del producto :");

        lblChange.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChange.setText("Ingrese el nuevo parámetro :");

        lblInventary.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        lblInventary.setForeground(new java.awt.Color(102, 0, 0));
        lblInventary.setText("INVENTARIO");

        tblInventory.setBackground(new java.awt.Color(51, 51, 51));
        tblInventory.setForeground(new java.awt.Color(255, 255, 255));
        tblInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Costo", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventory.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblInventory);

        txtModify.setBackground(new java.awt.Color(51, 51, 51));
        txtModify.setForeground(new java.awt.Color(255, 255, 255));
        txtModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModifyActionPerformed(evt);
            }
        });
        txtModify.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModifyKeyTyped(evt);
            }
        });

        cbxProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opción", "Código", "Nombre", "Costo", "Stock" }));
        cbxProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductActionPerformed(evt);
            }
        });

        txtCode.setBackground(new java.awt.Color(51, 51, 51));
        txtCode.setForeground(new java.awt.Color(255, 255, 255));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        jBtnSave.setBackground(new java.awt.Color(51, 51, 51));
        jBtnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnSave.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSave.setText("Guardar Cambios");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        btnMenu.setBackground(new java.awt.Color(51, 51, 51));
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jBtnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(lblChange)
                            .addGap(22, 22, 22)
                            .addComponent(txtModify, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCode)
                                    .addGap(24, 24, 24)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblModify)
                                    .addGap(21, 21, 21)
                                    .addComponent(cbxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(9, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblInventary, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblInventary, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMenu))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModify)
                    .addComponent(cbxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChange)
                    .addComponent(txtModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jBtnSave)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        product = new Product();
        
        String choose;
        choose =cbxProduct.getSelectedItem().toString();
        
        if(validateProduct()==-1){
        return;
            }else if(useCmbox(choose)==-1){
            return;
                    }else{
                         cleanComponents();
                         cbxProduct.setSelectedIndex(0);
                         seeInventory(products);
        }
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void txtModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModifyActionPerformed
       
    }//GEN-LAST:event_txtModifyActionPerformed

    private void cbxProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductActionPerformed
       
    }//GEN-LAST:event_cbxProductActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
      
    }//GEN-LAST:event_formKeyTyped

    private void txtModifyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModifyKeyTyped
    }//GEN-LAST:event_txtModifyKeyTyped

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
       if(txtCode.getText().length()>=4){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Solo se admite el ingreso de 4 dígitos");
        }
    }//GEN-LAST:event_txtCodeKeyTyped

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        FrmAdminMenu frmAdminMenu =new FrmAdminMenu();
        frmAdminMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInventoryModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInventoryModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInventoryModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInventoryModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInventoryModify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cbxProduct;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblInventary;
    private javax.swing.JLabel lblModify;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtModify;
    // End of variables declaration//GEN-END:variables
}
