/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministrationprj.model.Inventory;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Mejia
 */
public class FrmInventory extends javax.swing.JFrame {

    ArrayList<Product> products = new ArrayList<>();
    File file = new File("Product.txt");
    Product product = new Product();
    Inventory inventory = new Inventory();
    /**
     * Creates new form ProductJFrame
     */
    
    public FrmInventory() {
        initComponents();
        this.getContentPane().setBackground(Color.lightGray);
        seeInventory(products);
        this.setLocationRelativeTo(null);
    }
    
    public void cleanTxtArea(){
        this.txtAreaInformation.setText("");
    }
    
    public void cleanComponents(){
        this.txtCode.setText("");
        this.txtCost.setText("");
        this.txtName.setText("");
        this.txtStock.setText("");
    }
    
    public void showMessage(String message){
        this.lblInformation.setText(message);
    }
    
    public boolean validateEmptyIncome(){
        boolean validate=false;
        if("".equals(txtCode.getText())) validate = true;
        if("".equals(txtName.getText())) validate = true;
        if("".equals(txtStock.getText())) validate = true;
        if("".equals(txtStock.getText())) validate = true;
        return  validate;
    }
    
    public boolean validateParameters(){
        boolean validate = false;
        if((Validations.isNumeric(txtCode.getText()))==true) validate = true;
        if((Validations.isNumeric(txtCost.getText()))==true) validate = true;
        if((Validations.isNumeric(txtStock.getText()))==true) validate = true;
        if((Validations.isNumeric(txtName.getText()))==false) validate = true;
        return validate;
    }
    
    public int validateIncome(){
        if(validateEmptyIncome()){
            JOptionPane.showMessageDialog(null, "Debe Ingresar todos los parámetros","Ingreso inválido",JOptionPane.WARNING_MESSAGE);        
            return -1;
        }
        if(validateParameters()){
            JOptionPane.showMessageDialog(null, "Revise sus entradas","Ingreso inválido",JOptionPane.WARNING_MESSAGE);        
            return -1;
        }
        if(Validations.validateProduct(products, file, txtCode.getText())){
            JOptionPane.showMessageDialog(null, "Este código ya ha sido usado para otro producto","Ingreso inválido",JOptionPane.WARNING_MESSAGE);       
            return -1;
                    }
        if(Validations.validateNameProduct(products, file, txtName.getText().toUpperCase())){
            JOptionPane.showMessageDialog(null, "Este nombre ya ha sido usado para otro producto","Ingreso inválido",JOptionPane.WARNING_MESSAGE);        
            return -1;
                    }
            return 1;
    }
    
    public void consulInformation(){
        try{
        int i;
        String costString;
        String stockString;
        FileManager.createArrayOfFile(products, file);
        i = Validations.numberOfArrayProduct(file, products, txtCode.getText());
        if( i != -1 ){
            costString = String.valueOf(products.get(i).getCost()) ;
            stockString = String.valueOf(products.get(i).getStock());    
            txtAreaInformation.setText("Código del producto: "+products.get(i).getCodeProduct()+"\n"+
                            "Nombre del producto: "+products.get(i).getNameProduct()+"\n"+
                            "Costo del producto: "+costString+"\n"+
                            "Cantidad de Stock "+stockString);
                            products.clear();
                        }else{
                                JOptionPane.showMessageDialog(null, "Lo sentimos.El producto no se encuentra en el inventario","Producto no registrado",JOptionPane.WARNING_MESSAGE);        
                                products.clear();
                                } 
            }catch(Exception e){
                                System.out.println("Se ha producido un Error");
        }
    }
    
    public boolean validateProduct(){
        boolean validate = false;
        return validate;
    }
    
    private void seeInventory(ArrayList<Product> product){
        FileManager.createArrayOfFile(product, file);
        
        String matriz[][] = new String[product.size()][4];
                for (int i = 0; i < product.size(); i++) {
                    matriz[i][0] = product.get(i).getCodeProduct();
                    matriz[i][1] = product.get(i).getNameProduct();
                    matriz[i][2] = String.valueOf(product.get(i).getCost());
                    matriz[i][3] = String.valueOf(product.get(i).getStock());
                    }
                
                tblInventory.setModel(new javax.swing.table.DefaultTableModel( matriz,new String []{"Codigo","Nombre","Costo","Cantidad (Stock)"}));
                tblInventory.getColumnModel().getColumn(0).setPreferredWidth(20);
                tblInventory.getColumnModel().getColumn(1).setPreferredWidth(150);
                tblInventory.getColumnModel().getColumn(2).setPreferredWidth(20);
                tblInventory.getColumnModel().getColumn(3).setPreferredWidth(20);
                product.clear();
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblName = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventory = new javax.swing.JTable();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnConsult = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblInformation = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaInformation = new javax.swing.JTextArea();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setBackground(new java.awt.Color(102, 102, 102));
        lblName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName.setText("Nombre del producto:");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lblCode.setBackground(new java.awt.Color(51, 51, 51));
        lblCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCode.setText("Código  :");
        getContentPane().add(lblCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        lblStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStock.setText("Cantidad - Stock :");
        getContentPane().add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        lblCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCost.setText("Costo :");
        getContentPane().add(lblCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

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
        tblInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblInventory.setGridColor(new java.awt.Color(255, 255, 255));
        tblInventory.setRowHeight(20);
        jScrollPane1.setViewportView(tblInventory);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 580, 130));

        txtCode.setBackground(new java.awt.Color(51, 51, 51));
        txtCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCode.setForeground(new java.awt.Color(255, 255, 255));
        txtCode.setToolTipText("Ingrese un código para su producto de 4 dígitos");
        txtCode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, -1));

        txtName.setBackground(new java.awt.Color(51, 51, 51));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setToolTipText("Ingrese el nombre de su producto");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 118, 110, -1));

        txtStock.setBackground(new java.awt.Color(51, 51, 51));
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setToolTipText("Ingrese el número de productos disponibles");
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 153, 110, -1));

        txtCost.setBackground(new java.awt.Color(51, 51, 51));
        txtCost.setForeground(new java.awt.Color(255, 255, 255));
        txtCost.setToolTipText("Ingrese el costo unitario del producto");
        txtCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostActionPerformed(evt);
            }
        });
        txtCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostKeyTyped(evt);
            }
        });
        getContentPane().add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 110, -1));

        btnSave.setBackground(new java.awt.Color(51, 51, 51));
        btnSave.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 223, 80, 24));

        btnRemove.setBackground(new java.awt.Color(51, 51, 51));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Eliminar");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 80, -1));

        btnConsult.setBackground(new java.awt.Color(51, 51, 51));
        btnConsult.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsult.setForeground(new java.awt.Color(255, 255, 255));
        btnConsult.setText("Consultar");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsult, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        btnMenu.setBackground(new java.awt.Color(51, 51, 51));
        btnMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnMenu.setText("Menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, 24));

        lblInformation.setBackground(new java.awt.Color(0, 0, 51));
        lblInformation.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        lblInformation.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lblInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 190, 20));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 0, 0));
        jLabel1.setText("INVENTARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 270, 40));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 51));

        txtAreaInformation.setBackground(new java.awt.Color(51, 51, 51));
        txtAreaInformation.setColumns(20);
        txtAreaInformation.setRows(5);
        txtAreaInformation.setEnabled(false);
        txtAreaInformation.setSelectionColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(txtAreaInformation);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 280, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
       
    }//GEN-LAST:event_txtCodeActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostActionPerformed
        
    }//GEN-LAST:event_txtCostActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    try{
        if(validateIncome()!=-1) {
        product.addProduct(file, txtCode.getText(), txtName.getText().toUpperCase(),txtStock.getText(), txtStock.getText());
        seeInventory(this.products);
        cleanComponents();     
        showMessage("Producto Ingresado");
        }else{
        showMessage("Producto no Ingresado");    
        }
    }catch(Exception e){
        showMessage("Producto no Ingresado");
       }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        
        if(Validations.validateProduct(products, file, txtCode.getText())){
         inventory.deleteProductOfinventory(file, products, txtCode.getText());
        JOptionPane.showMessageDialog(null, "producto eliminado del Inventario","Producto Eliminado",JOptionPane.WARNING_MESSAGE);   
        }
        else{
        JOptionPane.showMessageDialog(null, "producto no registrado","Atención",JOptionPane.WARNING_MESSAGE);   
        }
       seeInventory(products);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
       consulInformation();     
    }//GEN-LAST:event_btnConsultActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        FrmAdminMenu frmAdminMenu =new FrmAdminMenu();
        frmAdminMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeKeyPressed

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
        if(txtCode.getText().length()>=4){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane,"Solo se admite el ingreso de 4 dígitos");
        }
        if(txtCode.getText().length()>=0){
            cleanTxtArea();
        }
    }//GEN-LAST:event_txtCodeKeyTyped

    private void txtCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostKeyTyped

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
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InventoryJFrame().cleanComponents();
                new FrmInventory().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTable tblInventory;
    private javax.swing.JTextArea txtAreaInformation;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
