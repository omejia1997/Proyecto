/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministrationprj.model.Employee;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author SAOM
 */
public class FrmRemoveStaff extends javax.swing.JFrame {

    File fileEmployee = new File("Employees.txt");
    ArrayList<Employee> employees = new ArrayList<>();
    
    
    public FrmRemoveStaff() {
        initComponents();
    }
    
    public void removeEmployeeFromFrm(File file,ArrayList<Employee> employee, String id)
    {
        FileManager.createArrayEmployeeOfFile(employee, file);
                    String letter = "";
                    boolean validateId=false;
                    try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        validateId = Validations.validateId(file, employee, id);
                        if(validateId == true){
			for (int k = 0; k < employee.size(); k++) {
				if (employee.get(k).getId().equals(id)) {
                                    JOptionPane.showMessageDialog(null, "El usuario eliminado", TxtID.getText(), JOptionPane.INFORMATION_MESSAGE);
				} else {
                                letter = employee.get(k).getName() + ";" + employee.get(k).getId() +";" +employee.get(k).getGender()+";"+
                                        employee.get(k).getBirthDate().get(Calendar.YEAR)+";"+employee.get(k).getBirthDate().get(Calendar.MONTH)+
                                        ";"+employee.get(k).getBirthDate().get(Calendar.DAY_OF_MONTH)+";" + employee.get(k).getUserName()
						+ ";" + employee.get(k).getPassword();
                                        bw.write(letter);
                                bw.newLine();
                                }
			}
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Lo sentimos!!!","El usuario no se encuentra registrado" , JOptionPane.ERROR_MESSAGE);
                            for (int k = 0; k < employee.size(); k++) {
                            letter = employee.get(k).getName() + ";" + employee.get(k).getId() +";" +employee.get(k).getGender()+";"+
                                        employee.get(k).getBirthDate().get(Calendar.YEAR)+";"+employee.get(k).getBirthDate().get(Calendar.MONTH)+
                                        ";"+employee.get(k).getBirthDate().get(Calendar.DAY_OF_MONTH)+";" + employee.get(k).getUserName()
						+ ";" + employee.get(k).getPassword();
                                        bw.write(letter);
                                bw.newLine();
                            }
                            return;
                        }
			bw.close();
			employee.clear();

		} catch (Exception e) {System.out.println(e);}
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        BtnRemoveEmployee = new javax.swing.JButton();
        BtnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESE EL NUMERO DE CÉDULA DEL USUARIO QUE DESEA ELIMINAR");

        BtnRemoveEmployee.setText("ELIMINAR");
        BtnRemoveEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveEmployeeActionPerformed(evt);
            }
        });

        BtnReturn.setText("REGRESAR");
        BtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnRemoveEmployee)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnReturn)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(BtnRemoveEmployee)
                .addGap(18, 18, 18)
                .addComponent(BtnReturn)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRemoveEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveEmployeeActionPerformed
        removeEmployeeFromFrm(fileEmployee, employees, TxtID.getText());
    }//GEN-LAST:event_BtnRemoveEmployeeActionPerformed

    private void BtnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReturnActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRemoveStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRemoveStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRemoveStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRemoveEmployee;
    private javax.swing.JButton BtnReturn;
    private javax.swing.JTextField TxtID;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
