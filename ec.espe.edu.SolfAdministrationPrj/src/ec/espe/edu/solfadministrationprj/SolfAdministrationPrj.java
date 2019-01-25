package ec.espe.edu.solfadministrationprj;

import ec.espe.edu.solfadministration.Files.util.FileManager;

import ec.espe.edu.solfadministration.Files.util.Validations;
import ec.espe.edu.solfadministration.Files.util.Statistic;
import ec.espe.edu.solfadministration.prj.control.Administrator;
import ec.espe.edu.solfadministrationprj.model.Billing;
import ec.espe.edu.solfadministrationprj.model.Inventory;
import ec.espe.edu.solfadministrationprj.model.Product;
import ec.espe.edu.solfadministrationprj.model.Store;
import ec.espe.edu.solfadministrationprj.model.Employee;
import ec.espe.edu.solfadministrationprj.model.Person;
import java.io.File;

import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

public class SolfAdministrationPrj {

	public static void main(String[] args) {

		int choose;
		int opc = 0;
                boolean validateUser=false;
                boolean validatePassword=false;

		float totalIncome;
		Product product = new Product();
		ArrayList<Product> productInventory = new ArrayList<>();
		File fileProduct = new File("Product.txt");
		File employeesFile = new File("Employees.txt");
		ArrayList<String> userInformation = new ArrayList<String>();
		Inventory inventory = new Inventory();
		Validations val = new Validations();
		ArrayList<Employee> employeeArray = new ArrayList<>();
		File fileDataBases = new File("DataBases.txt");
		Scanner input = new Scanner(System.in);
		String key;
		String keyE;
		String user;
		String search;
		String userE;
		Store shop = new Store();
		System.out.println("Welcome to our system");
		shop.setStoreName("Tienda");
		shop.setStoreLocation("Quitumbe");
		System.out.println(shop.getStoreName());
		System.out.println(shop.getStoreLocation());
		Calendar BirthDate = Calendar.getInstance();

		do {
			System.out.println("MENÙ DE USUARIO");
			System.out.println("Ingresar como: \n1. ADMINISTRADOR\n2. EMPLEADO \n3. SALIR");
			choose = Validations.validationOfInt();
			switch (choose) {
			case 1:
				Administrator adminUser; 
                                adminUser= new Administrator("1726134503", "Sebastian", "Male", BirthDate);
				adminUser.generateUser();
				adminUser.generatePassword();
                                System.out.println("usuario"+adminUser.getUserName());
                                 System.out.println("contraseña"+adminUser.getPassword());
				System.out.println("Porfavor ingrese su usuario");
				user = input.next();
				System.out.println("Porfavor ingrese su contraseña");
				key = input.next();
				if (user.equals(adminUser.getUserName()) && key.equals(adminUser.getPassword())) {
					System.out.println("******Bienvenido Administrador********");
					do {
						System.out.println("ELIGA UNA OPCION A REALIZAR");
						System.out.println(
								"1. Registrar Emplead@(s)\n2. Retirar Emplead@(s)\n3. Ver Pesonal Laboral \n4. Ingresar al Inventario"
										+ "\n5 Revisar Estadisticas\n6 Salir");
						opc = val.validationInt(opc);
						switch (opc) {
						case 1:
							adminUser.addEmployee();
							break;
						case 2:
							System.out.println("Ingrese el ID del emplead@ a eliminar");
							search = input.next();
                                                        adminUser.removeEmployee(employeesFile,employeeArray, search);
							break;
						case 3:
							adminUser.viewStaff("Employees.txt", employeeArray);
							break;
						case 4:
							inventory.openProductStatus(fileProduct, productInventory);
							break;
						case 5:
							//MENU OF STATISTICS
							System.out.println("MENU DE ESTADISTICAS");
							do {
								System.out.println("Que desea hacer ?\n1. Ver ventas del dia\n2. Ver ventas del mes\n"
										+ "3. Ver ventas en total\n4. Ver ventas por fecha concreta\n5. Salir");

								choose=Validations.validationOfInt();
								switch (choose) {
								case 1:

							//		Statistic.viewStatisticsByDay(
							//				FileManager.dataRescue(new File("Estadisticas de ventas.txt")));
									break;
									
								case 2:

							//		Statistic.viewStatisticsByMonth(
							//				FileManager.dataRescue(new File("Estadisticas de ventas.txt")));
									break;
									
								case 4:

							//		Statistic.viewStatisticsBySpecificDate(
							//				FileManager.dataRescue(new File("Estadisticas de ventas.txt")),0,0,0);
									break;
								case 3:

									totalIncome = Statistic.calculateIncome(
											FileManager.dataRescue(new File("Estadisticas de ventas.txt")));
									break;
								}
							}while(choose!=5);
							
							break;
						default:
							if (opc != 6)
								System.out.println("No es una opcion");
							break;
						}
					} while (opc != 6);

				} else {
					System.out.println("Usuario o clave incorrectos..... Porfavor reviselos\n");
				}

				break;

			case 2:
				
				FileManager.createArrayEmployeeOfFile(employeeArray, employeesFile);
                                System.out.println("Porfavor ingrese su usuario");
				userE = input.next();
				System.out.println("Porfavor ingrese su contraseña");
				keyE = input.next();
                                validateUser = Validations.validateUser(employeesFile, employeeArray, userE);
                                validatePassword = Validations.validatePassword(employeesFile, employeeArray, keyE);
				if ((validateUser ==true)&& (validatePassword ==true)) {
					System.out.println("******Bienvenido Empleado********");
					do {
						System.out.println("MENU DE EMPLEADO");
						System.out.println("Eliga la Opcion:");
						System.out.println("1. Revisar Inventario \n2. Generar Factura \n3.  SALIR!");

						opc = Validations.validationOfInt();
						switch (opc) {
						case 1:
							inventory.viewInventory(fileProduct);
							break;
						case 2:
							Billing bill = new Billing(inventory, 0, 0, 1.12f, 0f, 0, "",fileProduct);
							break;
						case 3:
							break;
						default:
							System.out.println("No es una opcion");
							break;
						}

					} while (opc != 3);
				} else {

					System.out.println("Usuario o clave incorrectos");

				}
                                employeeArray.clear();
				break;
			case 3:
				System.out.println("Cerrando");
				break;
			default:
				System.out.println("Esa no es una opcion, vuelva a ingresar");
				break;
			}

		} while (choose != 3);
	}
}
