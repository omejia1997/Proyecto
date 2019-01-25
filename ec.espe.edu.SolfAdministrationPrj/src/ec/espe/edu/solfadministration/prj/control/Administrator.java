/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.prj.control;

import ec.espe.edu.solfadministration.Files.util.Date;
import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministrationprj.model.Employee;
import ec.espe.edu.solfadministrationprj.model.Person;
import ec.espe.edu.solfadministrationprj.model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author SAOM
 */
public class Administrator extends Person {
	// SEBA261 Sm172613
	private String userName;
	private String password;
	Scanner scan = new Scanner(System.in);
	Validations validate = new Validations();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	//File fileEmployees = new File("Employees.txt");
	//File DataBases = new File("DataBases.txt");

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public Administrator(String id, String name, String gender, Calendar birthDate) {
		super(id, name, gender, birthDate);
		this.userName = "";
		this.password = "";
	}

	/**
	 * @return an user name generated into the method
	 * @author SAOM
	 */
	@Override
	public String generateUser() {
		String aux = "";
		String aux2 = "";
		for (int i = 0; i < 4; i++) {
			aux = aux + name.charAt(i);
		}
		for (int j = 2; j < 5; j++) {
			aux2 = aux2 + id.charAt(j);
		}
		userName = aux.toUpperCase() + aux2;
		return userName;
	}

	/**
	 * @author SAOM
	 * @return a password generated into the method
	 */
	@Override
	public String generatePassword() {
		String aux = "";
		String aux1 = "";
		aux1 = aux1 + name.charAt(0);

		for (int i = 0; i < 6; i++) {
			aux = aux + id.charAt(i);
		}
		password = aux1.toUpperCase() + gender.toLowerCase().charAt(0) + aux;

		return password;
	}

	/**
	 * @author SAOM This method can add employees
	 * 
	 */
	public void addEmployee() {
            File fileEmployee = new File("Employees.txt");
		int choice = 0;
		int i = 0;
		boolean bd = false;
                boolean validateId;

		String name = " ";
		String id = " ";
		String gender = " ";
		Calendar birthDate = Calendar.getInstance();
         
                userName="";
                password="";

                
		do {
                    FileManager.createArrayEmployeeOfFile(employees, fileEmployee);
                    
			System.out.println("Por favor ingrese el nombre del empleado ");
                        name = scan.nextLine().toUpperCase();
			System.out.println("Por favor ingrese el ID del empleado");
			do {

				id = scan.next();
                                validateId=false;
                                validateId=Validations.validateId(fileEmployee, employees, id);
				if (!Validations.validationOfIdCard(id)) {
					System.out.println("Identificacion no es correcto, vuleva a ingresar");
				}
                                if(validateId==true){
                                    System.out.println("Esta identificacion ya ha sido usada por otro usuario");
                                    System.out.println("Ingrese nuevamente el ID del empleado"); 
                                }
                                
			} while ((!Validations.validationOfIdCard(id))||(validateId==true));

			System.out.println("Por favor ingrese el género del empleado\nM: masculino\nF: Femenino");
			do {
				gender = scan.next().toUpperCase();

				if (!gender.equals("M") && !gender.equals("F")) {
					System.out.println("Favor, vuleva a ingresar el genero del empleado\nM: masculino\nF: Femenino");
				}
			} while (!gender.equals("M") && !gender.equals("F"));

			/*
			 * do {
			 * System.out.println("Por favor ingrese la fecha de nacimiento del empleado " +
			 * " YYYY MM DD"); BirthDate.set(Validations.validationOfInt(),
			 * Validations.validationOfInt(), Validations.validationOfInt()); bd =
			 * validate.validateDate(String.valueOf(BirthDate.get(Calendar.MONTH)) + "/" +
			 * String.valueOf(BirthDate.get(Calendar.DATE)) + "/" +
			 * String.valueOf(BirthDate.get(Calendar.YEAR))); } while (bd != true);
			 */
			Date correctDate = new Date(0, 0, 0);
			System.out.println("Ingrese la fecha de nacimiento del empleado:");
			do {
				System.out.print("YYYY: ");
				correctDate.setYear(Validations.validationOfInt());
				System.out.print("MM: ");
				correctDate.setMonth(Validations.validationOfInt());
				System.out.print("DD: ");
				correctDate.setDay(Validations.validationOfInt());

				correctDate = Validations.ValidateBirthDate(correctDate);
				if (correctDate.getYear() == -1 || correctDate.getMonth() == -1 || correctDate.getDay() == -1) {
					System.out.println("Fecha ingresada incorrecta, Favor vuelva a ingresar");
				}
			} while (correctDate.getYear() == -1 || correctDate.getMonth() == -1 || correctDate.getDay() == -1);
		
                        birthDate.set(correctDate.getYear(), correctDate.getMonth(), correctDate.getDay());
			Employee person = new Employee(id, name, gender,birthDate, userName, password);
                        person.setUserName(person.generateUser());
			person.setPassword(person.generatePassword());
                        employees.add(person);
                        System.out.println(employees.size());
			i++;
                      FileManager.saveArrayEmployeeFile(fileEmployee, employees);
                      employees.clear();
			scan.nextLine();
		} while (choice == 1);
                employees.clear();
	}

	/**
	 * @author Pancho
	 * This method can remove the employees of the system.
	 * @param fileName The name of the file of employees.
	 * @param idToRemove The id of the employee to remove.
	 */
        	public void removeEmployee(File file,ArrayList<Employee> employee, String id) {
                    FileManager.createArrayEmployeeOfFile(employee, file);
                    String letter = "";
                    boolean validateId=false;
                    try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        validateId = Validations.validateId(file, employee, id);
                        if(validateId == true){
			for (int k = 0; k < employee.size(); k++) {
				if (employee.get(k).getId().equals(id)) {
                                    System.out.println("El usuario " + employee.get(k).getName() + " con ID: "
                                    		+ employee.get(k).getId()+ " ha sido eliminado del Registro");
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
                            System.out.println("Lo sentimos!!! El usuario no se encuentra registrado");
                            for (int k = 0; k < employee.size(); k++) {
                            letter = employee.get(k).getName() + ";" + employee.get(k).getId() +";" +employee.get(k).getGender()+";"+
                                        employee.get(k).getBirthDate().get(Calendar.YEAR)+";"+employee.get(k).getBirthDate().get(Calendar.MONTH)+
                                        ";"+employee.get(k).getBirthDate().get(Calendar.DAY_OF_MONTH)+";" + employee.get(k).getUserName()
						+ ";" + employee.get(k).getPassword();
                                        bw.write(letter);
                                bw.newLine();
                            }
                        }
			bw.close();
			employee.clear();

		} catch (Exception e) {
		}
	}

	/**
	 * @author SAOM this method show all the employees into on the arraylist
	 * @param fileName
	 * @param employees
	 */
	public void viewStaff(String fileName, ArrayList<Employee> employees) {
                File file = new File(fileName);
                int p=0;
		ArrayList<String> viewEmployees = new ArrayList<>();

		System.out.println("<<<<<<LISTA DE EMPLEADOS>>>>>>");
                FileManager.createArrayStringOfEmployee(viewEmployees, file);
            Validations validation = new Validations();
            validation.addSpacesArrayEmployee(viewEmployees);
		System.out.println("---------------------------------------------------------------------------------------------------------------");
            for(int m=0;m<viewEmployees.size();m++){
            System.out.print(viewEmployees.get(m));
                System.out.print("\t");
            if(m-7==p){
            System.out.println("");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            p+=8;
            }
            }
            viewEmployees.clear();

	}

}
