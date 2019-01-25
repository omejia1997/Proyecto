/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.prj.control.Administrator;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Loachamin
 */
public class AdministratorJframe extends javax.swing.JFrame {

    /**
     * Creates new form AdministratorJframe
     */
    public AdministratorJframe() {
        initComponents();
    }

   public void giveAccesToAdmin()
   {
       Calendar BirthDate = Calendar.getInstance();
        Administrator adminUser; 
        adminUser= new Administrator("1726134503", "Sebastian", "Male", BirthDate);
	adminUser.generateUser();
	adminUser.generatePassword();
        if(jTextFieldAdminUser.getText().equals(adminUser.getUserName()) && jPasswordFieldAdmin.getText().equals(adminUser.getPassword()))
        {
           FrmAdminMenu frmAdminMenu = new FrmAdminMenu();
          
           frmAdminMenu.setVisible(true);
           frmAdminMenu.setResizable(false);
           frmAdminMenu.setLocationRelativeTo(null);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Algo salio mal", "Usuario Incorrecto",JOptionPane.ERROR_MESSAGE);
        }  

   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jTextFieldAdminUser = new javax.swing.JTextField();
        jPasswordFieldAdmin = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuUser = new javax.swing.JMenu();
        MainMenu = new javax.swing.JMenuItem();
        MenuReturn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuItemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\usuario\\Documents\\GitHub\\SolfAdministration\\ec.espe.edu.SolfAdministrationPrj\\src\\ec\\espe\\edu\\solfadministration\\images\\BackgroundStore.png")); // NOI18N

        lblUser.setText("Usuario");

        lblPassword.setText("Contraseña");

        jTextFieldAdminUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdminUserActionPerformed(evt);
            }
        });

        btnEnter.setText("Ingresar");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO");

        MenuUser.setText("Usuario");

        MainMenu.setText("Menú Principal");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });
        MenuUser.add(MainMenu);

        MenuReturn.setText("Volver");
        MenuReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuReturnActionPerformed(evt);
            }
        });
        MenuUser.add(MenuReturn);

        jMenuBar1.add(MenuUser);

        jMenu2.setText("Ayuda");

        MenuItemInfo.setText("Informacion");
        MenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemInfoActionPerformed(evt);
            }
        });
        jMenu2.add(MenuItemInfo);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdminUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdminUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdminUserActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
       giveAccesToAdmin();
    }//GEN-LAST:event_btnEnterActionPerformed

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        StoreJframe storeJframe = new StoreJframe();
        storeJframe.setLocationRelativeTo(null);
        storeJframe.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_MainMenuActionPerformed

    private void MenuReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuReturnActionPerformed
        MenuJframe menuJframe = new MenuJframe(); 
        menuJframe.setLocationRelativeTo(null);
        menuJframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_MenuReturnActionPerformed

    private void MenuItemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemInfoActionPerformed

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
            java.util.logging.Logger.getLogger(AdministratorJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MainMenu;
    private javax.swing.JMenuItem MenuItemInfo;
    private javax.swing.JMenuItem MenuReturn;
    private javax.swing.JMenu MenuUser;
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPasswordFieldAdmin;
    private javax.swing.JTextField jTextFieldAdminUser;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
