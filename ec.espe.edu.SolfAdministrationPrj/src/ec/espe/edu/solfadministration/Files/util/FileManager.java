/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.Files.util;

import ec.espe.edu.solfadministration.model.GUI.BillingMode;
import ec.espe.edu.solfadministrationprj.model.Employee;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Mejia
 * @author Sebastian Ochoa
 * @author Luis Loachamin
 */
public class FileManager {
	/**
	 * @author Pancho This method can Read de path of the actual proyect
	 * @return Path the path of the proyect in a String
	 */
    
    
    
    
	public static String readPath() {
		String Path = "";
		File miDir = new File(".");
		try {
			Path = miDir.getCanonicalPath();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("can't read the file path");
		}
		return Path;

	}

	/**
	 * This method write on a file with the given String.
	 * 
	 * @param file
	 * @param text
	 */
	public static void write(File file, String text) {
		FileWriter fileWriter;
		BufferedWriter salida;
		try {
			fileWriter = new FileWriter(file, true);
			salida = new BufferedWriter(fileWriter);
			
			salida.write(text);
			salida.newLine();
			salida.close();
		} catch (IOException e) {
			System.out.println("Can't read the file");
		}
	}


	/**
	 * @author Pancho
	 * This method can override files with a String
	 * @param fileName The file to override
	 * @param text The new text of the file
	 */
	public static void overrideFile(String fileName, String text) {
		FileWriter fileWriter;
		BufferedWriter salida;
		try {
			fileWriter = new FileWriter(new File(fileName), false);
			salida = new BufferedWriter(fileWriter);
			
			salida.write(text);
			salida.newLine();
			salida.close();
		} catch (IOException e) {
			System.out.println("Can't read the file");
		}
	}
	
	
	/**
	 * @author Pancho This mehod can rescue the data of a file and save this data on
	 *         ArrayLidy of String.
	 * @param file
	 * @return A ArrayList of Strings
	 */
	public static ArrayList<String> dataRescue(File file) {
		ArrayList<String> array = new ArrayList<String>();
		String read;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader input = new BufferedReader(fileReader);
			read = input.readLine();
			while (read != null) {
				array.add(read);
				read = input.readLine();
			}
		} catch (IOException e) {
			System.out.println("Ocurrio un Error");
		}
		// System.out.println(array);
		return array;
	}

	/**
	 * This method can read and print the content of a file.
	 * 
	 * @param file
	 */
	public static void read(File file) {
		String read;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader input = new BufferedReader(fileReader);
			read = input.readLine();
			while (read != null) {
				System.out.println(read);
				read = input.readLine();
			}
		} catch (IOException e) {
			System.out.println("Ocurrio un Error");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method allows you to create an array of objects in the file where the
	 * inventory is located
	 * 
	 * @param product: This parameter allows e to save the array in that variable
	 *        ArrayList
	 * @param file:This parameter is the file where the inventory is located
	 * @return The file with the registered products and the information of each one
	 */
	public static ArrayList<Product> createArrayOfFile(ArrayList<Product> product, File file) {
		String codeProduct;
		String nameProduct;
		float cost;
		int stock;
		try {
			String read;
			try (FileReader archedad = new FileReader(file)) {
				BufferedReader br = new BufferedReader(archedad);
				read = br.readLine();
				while ((read != null)) {
					if (read.contains(";")) {
						codeProduct = read.split(";")[0];
						nameProduct = read.split(";")[1];
						stock = Integer.parseInt(read.split(";")[2]);
						cost = Float.parseFloat(read.split(";")[3]);
						product.add(new Product(codeProduct, nameProduct, stock, cost));
					}
					read = br.readLine();
				}
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un Error");
			System.out.println(e.toString());
                        System.out.println(e.getMessage());
		}
		return product;
	}

	/**
	 * This method allows you to save an array of objects Product in a file
	 * 
	 * @param file    :This parameter is the name of the file where the information
	 *                of the products of the inventory will be stored
	 * @param product :This parameter is an Object Arrangement that will contain the
	 *                products registered in the file
	 */
	public static void saveArrayInFile(File file, ArrayList<Product> product) {
		String letter = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int k = 0; k < product.size(); k++) {
				letter = product.get(k).getCodeProduct() + ";" + product.get(k).getNameProduct() + ";"
						+ product.get(k).getStock() + ";" + product.get(k).getCost();
				bw.write(letter);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
			System.out.println(e.getMessage());
		}
	}


	/**
	 * @author Omar Mejia
	 * @param file
	 * @param employee this method save the info of arraylist of type employee into
	 *                 a file
	 */
	public static void saveArrayEmployeeFile(File file, ArrayList<Employee> employee) {
		String text = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int k = 0; k < employee.size(); k++) {
				text = employee.get(k).getName() + ";" + employee.get(k).getId() +";" +employee.get(k).getGender()+";"+
                                        employee.get(k).getBirthDate().get(Calendar.YEAR)+";"+employee.get(k).getBirthDate().get(Calendar.MONTH)+
                                        ";"+employee.get(k).getBirthDate().get(Calendar.DAY_OF_MONTH)+";" + employee.get(k).getUserName()
						+ ";" + employee.get(k).getPassword();
				bw.write(text);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
			System.out.println(e.getMessage());
		}
                employee.clear();
	}

	/**
	 * @author SAOM
	 * @param file
	 * @param employee this method extract the data of employee as user name and
	 *                 password and save it into a file
	 */
	public static void extractEmployeeData(File file, ArrayList<Employee> employee) {
		String text = "";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int k = 0; k < employee.size(); k++) {
				text = employee.get(k).getUserName() + ";" + employee.get(k).getPassword();
				bw.write(text);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error");
		}

	}

	/**
	 * @author SAOM
	 * @param file
	 * @return This method put the info of a file into a collection
	 */
	public static ArrayList<Employee> createArrayEmployeeOfFile(ArrayList<Employee> employee, File file) {
		String name;
		String id;
		String gender;
                int year;
                int month;
                int day;
                Calendar birthDate = Calendar.getInstance();
                String user;
                String password;
		try {
			String read;
			try (FileReader archedad = new FileReader(file)) {
				BufferedReader br = new BufferedReader(archedad);
				read = br.readLine();
				while ((read != null)) {
					if (read.contains(";")) {
						name = read.split(";")[0];
						id = read.split(";")[1];
                                                gender = read.split(";")[2];
                                                year = Integer.parseInt(read.split(";")[3]);
                                                month = Integer.parseInt(read.split(";")[4]);
                                                day = Integer.parseInt(read.split(";")[5]);
                                                user = read.split(";")[6];
                                                password = read.split(";")[7];
                                                
                                                birthDate= new GregorianCalendar(year, month, day);
						employee.add(new Employee(id, name, gender, birthDate, user, password));
					}
					read = br.readLine();
				}
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un Error");
			System.out.println(e.toString());
		}
		return employee;
	}

	public static void saveArrayInFileOfBilling(File file, ArrayList<Product> product, float subtotal, float iva,
			float total1,String name,long Ci,String tlf,String location) {
		String letra = "";
		String letra2 = "";
		String letra3 = "";
         
     
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			letra2 = "\t=>>> TIENDA Y PANADERIA<<<==" + "\r\n" + "\tFACTURA" + "\r\n" + "CLIENTE: " + name + "\r\n"
					+ "DIRECCION: " + location + "\r\n" + "CI: " + Ci + "\r\n" + "\r\n" + "\r\n" + "Cantidad" + "\t"
					+ "Producto" + "\t" + "precio" + "\t" + "\tprecio total";
			bw.write(letra2);
			for (int k = 0; k < product.size(); k++) {

				letra = "\r\n" + product.get(k).getCodeProduct() + "\t\t" + product.get(k).getNameProduct() + "\t\t"
						+ product.get(k).getCost() + "\t\t" + product.get(k).getTotal();
				bw.write(letra);
				bw.newLine();
			}
			letra3 = "\r\n" + "\t\t\t\t\t" + "Subtotal: " + subtotal + "\r\n" + "\t\t\t\t\t" + "IVA 12%: " + iva
					+ "\r\n" + "\t\t\t\t\t" + "Valor a Pagar: " + total1;
			bw.write(letra3);
			bw.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error \n Factura no generada");
		}

	}
        public static void saveArrayInFileOfBillingConsumerEnd(File file, ArrayList<Product> product, float subtotal, float iva,
			float total1) {
		String letra = "";
		String letra2 = "";
		String letra3 = "";
		String Name = null;
		String Location = null;
		
	

			Name = "Consumidor Final";
			Location = "-------";
                        long Ci=999999999;
                    
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			letra2 = "\t=>>> TIENDA Y PANADERIA<<<==" + "\r\n" + "\tFACTURA" + "\r\n" + "CLIENTE: " + Name + "\r\n"
					+ "DIRECCION: " + Location + "\r\n" + "CI: " + Ci + "\r\n" + "\r\n" + "\r\n" + "Cantidad" + "\t"
					+ "Producto" + "\t" + "precio" + "\t" + "\tprecio total";
			bw.write(letra2);
			for (int k = 0; k < product.size(); k++) {

				letra = "\r\n" + product.get(k).getCodeProduct() + "\t\t" + product.get(k).getNameProduct() + "\t\t"
						+ product.get(k).getCost() + "\t\t" + product.get(k).getTotal();
				bw.write(letra);
				bw.newLine();
			}
			letra3 = "\r\n" + "\t\t\t\t\t" + "Subtotal: " + subtotal + "\r\n" + "\t\t\t\t\t" + "IVA 12%: " + iva
					+ "\r\n" + "\t\t\t\t\t" + "Valor a Pagar: " + total1;
			bw.write(letra3);
			bw.close();
		} catch (IOException e) {
			System.out.println("Ocurrio un error \n Factura no generada");
		}

	}

	public static ArrayList<String> createArrayStringOfProduct(ArrayList<String> product, File file) {
		String codeProduct;
		String nameProduct;
		String cost;
		String stock;
		product.add("Codigo");
		product.add("Nombre del producto");
		product.add("Cantidad(Stock)");
		product.add("Costo");

		try {
			String read;
			try (FileReader archedad = new FileReader(file)) {
				BufferedReader br = new BufferedReader(archedad);
				read = br.readLine();
				while ((read != null)) {
					if (read.contains(";")) {
						codeProduct = read.split(";")[0];
						nameProduct = read.split(";")[1];
						stock = read.split(";")[2];
						cost = read.split(";")[3];
						product.add(codeProduct);
						product.add(nameProduct);
						product.add(stock);
						product.add(cost);
					}
					read = br.readLine();
				}
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un Error");
			System.out.println(e.toString());
		}
		return product;
	}
        
        public static ArrayList<String> createArrayStringOfEmployee(ArrayList<String> employee, File file) {
		String name;
		String id;
		String gender;
                String year;
                String month;
                String day;
                Calendar birthDate = Calendar.getInstance();
                String user;
                String password;
                employee.add("NOMBRE");
                employee.add("CEDULA");
                employee.add("GENERO");
                employee.add("AÑO DE N.");
                employee.add("MES DE N.");
                employee.add("DIA DE N.");
                employee.add("USUARIO ");
                employee.add("CONTRASEÑA");
		try {
			String read;
			try (FileReader archedad = new FileReader(file)) {
				BufferedReader br = new BufferedReader(archedad);
				read = br.readLine();
				while ((read != null)) {
					if (read.contains(";")) {
						name = read.split(";")[0];
						id = read.split(";")[1];
                                                gender = read.split(";")[2];
                                                year = read.split(";")[3];
                                                month = read.split(";")[4];
                                                day = read.split(";")[5];
                                                user = read.split(";")[6];
                                                password = read.split(";")[7];
                                                employee.add(name);
                                                employee.add(id);
                                                employee.add(gender);
                                                employee.add(year);
                                                employee.add(month);
                                                employee.add(day);
                                                employee.add(user);
                                                employee.add(password);
					}
					read = br.readLine();
				}
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un Error");
			System.out.println(e.toString());
		}
		return employee;
	}

}
