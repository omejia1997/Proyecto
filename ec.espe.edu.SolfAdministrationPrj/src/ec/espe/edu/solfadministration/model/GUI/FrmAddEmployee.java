/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.model.GUI;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministrationprj.model.Employee;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author SAOM
 */
public class FrmAddEmployee extends javax.swing.JFrame {

   File fileEmployee = new File("Employees.txt");
   ArrayList<Employee> employees = new ArrayList<>(); 
    public FrmAddEmployee() {
        initComponents();
    }

    public void clearScr()
    {
        TxtName.setText(" ");
        TxtID.setText("");
        RBtnGenderMale.setSelected(false);
        RBtnGenderFemale.setSelected(false);
        ChooserBirthD.setCalendar(null);
    }
    
    public void AddEmployeFromFrm()
    {
         
		boolean bd = false;
                boolean validateId;

		String name = TxtName.getText();
		String id = TxtID.getText();
		String gender = "";
                String userName = " ";
                String password = " ";
		Calendar birthDate = Calendar.getInstance();
  
                FileManager.createArrayEmployeeOfFile(employees, fileEmployee);
                    
			
			do {
                                validateId=false;
                                validateId=Validations.validateId(fileEmployee, employees, id);
				if (!Validations.validationOfIdCard(id)) {
					JOptionPane.showMessageDialog(null, "Cédula Incorrecta!", id, JOptionPane.ERROR_MESSAGE);
                                        clearScr();
                                        return;
				}
                                if(validateId==true){
                                    JOptionPane.showMessageDialog(null, "Esta Cédula ya ha sido usada anteriormente", id, JOptionPane.INFORMATION_MESSAGE);
                                    clearScr();
                                    return;
                                }
                                
			} while ((!Validations.validationOfIdCard(id))||(validateId==true));
                        
                        if(RBtnGenderMale.isSelected() || RBtnGenderFemale.isSelected())
                        {
                            if(RBtnGenderMale.isSelected() != false)
                            {
                                gender = String.valueOf(RBtnGenderMale.getText().charAt(0));
                            }
                            else
                            {
                                gender = String.valueOf(RBtnGenderFemale.getText().charAt(0));
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Debe escoger al menos un género", "Género", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                       
                        String yearB = Integer.toString(ChooserBirthD.getCalendar().get(Calendar.YEAR));
                        String monthB = Integer.toString(ChooserBirthD.getCalendar().get(Calendar.MONTH)+1);
                        String dayB = Integer.toString(ChooserBirthD.getCalendar().get(Calendar.DAY_OF_MONTH));
                        
                        bd = Validations.validateDate(dayB+"/"+monthB+"/"+yearB);
                        
                        if(bd != false)
                        {
                            birthDate.set(Integer.parseInt(yearB),Integer.parseInt(monthB),Integer.parseInt(dayB));
                        }

			Employee person = new Employee(id, name, gender,birthDate, userName, password);
                        person.setUserName(person.generateUser());
			person.setPassword(person.generatePassword());
                        employees.add(person);
                        
                        FileManager.saveArrayEmployeeFile(fileEmployee, employees);
                         JOptionPane.showMessageDialog(null,"Usuario registrado con éxito", name, JOptionPane.INFORMATION_MESSAGE);
                      employees.clear();
		

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblName = new javax.swing.JLabel();
        LblId = new javax.swing.JLabel();
        LblGender = new javax.swing.JLabel();
        LblBirthDate = new javax.swing.JLabel();
        RBtnGenderMale = new javax.swing.JRadioButton();
        RBtnGenderFemale = new javax.swing.JRadioButton();
        ChooserBirthD = new com.toedter.calendar.JDateChooser();
        TxtName = new javax.swing.JTextField();
        TxtID = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMINISTRADOR");

        LblName.setText("Nombre");

        LblId.setText("Cédula de Identidad");

        LblGender.setText("Gender");

        LblBirthDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblBirthDate.setText("Fecha de Nacimiento");

        RBtnGenderMale.setText("Masculino");

        RBtnGenderFemale.setText("Femenino");

        ChooserBirthD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChooserBirthD.setDateFormatString("dd-MM-yyyy");

        BtnAdd.setText("Añadir");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(LblGender))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(LblName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LblId)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBtnGenderFemale)
                            .addComponent(RBtnGenderMale))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 45, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ChooserBirthD, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LblName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LblBirthDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(TxtName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChooserBirthD, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtID)
                        .addComponent(LblId)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(LblGender)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(RBtnGenderMale)
                        .addGap(18, 18, 18)
                        .addComponent(RBtnGenderFemale)
                        .addGap(47, 47, 47)
                        .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        AddEmployeFromFrm();
    }//GEN-LAST:event_BtnAddActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private com.toedter.calendar.JDateChooser ChooserBirthD;
    private javax.swing.JLabel LblBirthDate;
    private javax.swing.JLabel LblGender;
    private javax.swing.JLabel LblId;
    private javax.swing.JLabel LblName;
    private javax.swing.JRadioButton RBtnGenderFemale;
    private javax.swing.JRadioButton RBtnGenderMale;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtName;
    // End of variables declaration//GEN-END:variables
}
