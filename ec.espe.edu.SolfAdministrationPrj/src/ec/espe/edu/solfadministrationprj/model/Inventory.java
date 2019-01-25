/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministrationprj.model;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Omar Mejia
 */
public class Inventory {
	ArrayList<Product> products = new ArrayList<Product>();

	/**
	 * This method allows you to create a menu for the visualization of everything
	 * related to the inventory
	 * 
	 * @param file : This parameter is the name of the file that contains the
	 *             products
	 * @param      product: This parameter is the name of the file where it contains
	 *             the products
	 */
	public void openProductStatus(File file, ArrayList<Product> product) {
		Scanner input = new Scanner(System.in);
		Product product1 = new Product();
		int option;
		int option2;
		String code;
		do {
			System.out.println("\nMENU DE INVENTARIO\n1. Revisar el Inventario "
					+ "\n2. Agregar un nuevo producto al inventario " + "\n3. Modificar la Información del Producto "
					+ "\n4. Eliminar un Producto del inventario" + "\n5. Regresar al Menú principal"
					+ "\n6. finalizar Programa");
			option = Validations.validationOfInt();
			switch (option) {
			case 1:
				viewInventory(file);
				break;
			case 2:
				//product1.addProduct(file);
				break;
			case 3:
				do {
					System.out.println("\tQue parametro desea modificar");
					System.out.println("1. Codigo del producto \n2. Nombre del producto \n3.Costo del producto "
							+ "\n4. Cantidad de Stock del producto \n5. Regresar al menú anterior \n6. Finalizar Programa");
					option2 = Validations.validationOfInt();
					switch (option2) {
					case 1:
                                                viewInventory(file);
						System.out.println("Ingrese el codigo del producto que desea modificar");
						code = input.next();
						//product1.modifyCodeProduct(file, product, code);
						break;
					case 2:
                                                viewInventory(file);
						System.out.println("Ingrese el codigo del producto que desea modificar");
						code = input.next();
						//product1.modifyNameProduct(file, product, code);
						break;
					case 3:
                                                viewInventory(file);
						System.out.println("Ingrese el codigo del producto que desea modificar");
						code = input.next();
						//product1.modifyCostProduct(file, product, code);
						break;
					case 4:
                                                viewInventory(file);
						System.out.println("Ingrese el codigo del producto que desea modificar");
						code = input.next();
						//product1.modifyStockProduct(file, product, code);
						break;
					case 6:
						System.exit(0);
					default:
						if (option2 != 5)
							System.out.println("Opcion no valida. Intentelo nuevamente ");
					}
				} while (option2 != 5);
				break;
			case 4:
				System.out.println("Ingrese el codigo del producto que desea eliminar");
				code = input.next();
				FileManager.createArrayOfFile(product, file);
				deleteProductOfinventory(file, product, code);
				product.clear();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				if (option != 5)
					System.out.println("Opcion no valida. Intentelo nuevamente ");
				break;
			}
		} while (option != 5);
	}

	/**
	 * This method allows to visualize the inventory with the information of the
	 * products
	 * 
	 * @param file :This parameter is the name of the file that contains the
	 *             products
	 */

	public void viewInventory(File file) {
            int p=0;
            ArrayList<String> viewProduct = new ArrayList<>();
			System.out.println("\t <<<<<<INVENTARIO>>>>>>");
            FileManager.createArrayStringOfProduct(viewProduct, file);
            Validations validation = new Validations();
            validation.addSpacesArray(viewProduct);
            System.out.println("------------------------------------------------------------");
            for(int m=0;m<viewProduct.size();m++){
            System.out.print(viewProduct.get(m));
                System.out.print("\t");
            if(m-3==p){
                System.out.println("");
            System.out.println("------------------------------------------------------------");
            p+=4;
            }
            }
            viewProduct.clear();
        }


	/**
	 * 
	 * @param         file: This parameter is the name of the file that contains the
	 *                products
	 * @param product :This parameter is an Object Arrangement that will contain the
	 *                products registered in the file
	 * @param code    :This parameter is the product code entered by the user to
	 *                remove the product
	 */

	public void deleteProductOfinventory(File file, ArrayList<Product> product, String code) {
		String letter = "";
                FileManager.createArrayOfFile(product, file);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int k = 0; k < product.size(); k++) {
				if (product.get(k).getCodeProduct().equals(code)) {
                                    System.out.println("Se encontro el producto");
                                    System.out.println("El producto " + product.get(k).getNameProduct() + " con codigo "
                                    		+ product.get(k).getCodeProduct() + " ha sido eliminado del Inventario");
				} else {
                                letter = product.get(k).getCodeProduct() + ";" + product.get(k).getNameProduct() + ";"
                                       + product.get(k).getStock() + ";" + product.get(k).getCost();
                                        bw.write(letter);
                                bw.newLine();
                                }
			}

			bw.close();
			product.clear();

		} catch (Exception e) {
		}
	}
}