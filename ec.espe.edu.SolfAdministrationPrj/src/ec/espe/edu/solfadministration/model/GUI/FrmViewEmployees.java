/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministrationprj.model.Employee;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SAOM
 */
public class FrmViewEmployees extends javax.swing.JFrame {

    File fileEmployee = new File("Employees.txt");
    ArrayList<Employee> employees = new ArrayList<>();
    
    public FrmViewEmployees() {
        initComponents();
        viewStaff(employees);
    }

    private void viewStaff(ArrayList<Employee> employees)
    {
        FileManager.createArrayEmployeeOfFile(employees, fileEmployee);
        String table[][] = new String[employees.size()][4];
        for(int i=0;i<employees.size();i++)
        {
            table[i][0] = employees.get(i).getName();
            table[i][1] = employees.get(i).getId();
            table[i][2] = employees.get(i).getGender();
            table[i][3] = Integer.toString(employees.get(i).getBirthDate().get(Calendar.YEAR))+"/"+Integer.toString(employees.get(i).getBirthDate().get(Calendar.MONTH))+"/"+Integer.toString(employees.get(i).getBirthDate().get(Calendar.DAY_OF_MONTH));
        }
        
        TblReportEmployees.setModel(new javax.swing.table.DefaultTableModel( table,new String []{"Nombre","Cédula","Género","Fecha de Nacimiento"}));
        TblReportEmployees.getColumnModel().getColumn(0).setPreferredWidth(30);
        TblReportEmployees.getColumnModel().getColumn(1).setPreferredWidth(100);
        TblReportEmployees.getColumnModel().getColumn(2).setPreferredWidth(30);
        TblReportEmployees.getColumnModel().getColumn(3).setPreferredWidth(100);
        employees.clear();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TblReportEmployees = new javax.swing.JTable();
        BtnReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblReportEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TblReportEmployees);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnReturn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BtnReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmViewEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmViewEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmViewEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmViewEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmViewEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnReturn;
    private javax.swing.JTable TblReportEmployees;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
