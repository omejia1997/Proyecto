/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.Files.util;


import ec.espe.edu.solfadministrationprj.model.Inventory;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Loachamin
 */
public class ValidationsBilling {
    
    public ValidationsBilling() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
     public void testValidation1() {
         System.out.println("Test Validation 1\n ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "PIPAS";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation2() {
         System.out.println("Test Validation 2\n ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "TANGO";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

					
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation3() {
          System.out.println("Test Validation 3\n ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "K-CHITOS";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation4() {
         System.out.println("Calculo de venta ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "PIPAS";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation5() {
         System.out.println("TEST 5 ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "AGUA CIELO";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation6() {
         System.out.println("TEST 6 ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "AVENA";
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     @Test
     public void testValidation7() {
         System.out.println("Calculo de venta ");
         Inventory inventory = new Inventory();
         File fileProduct = new File("Product.txt");
         ArrayList<Product> products = new ArrayList<>();
         boolean expResult = true;
         boolean result = false ;		
        String  nameProduct = "TANGO";
        int quantity=12;
        FileManager.createArrayOfFile(products, fileProduct);
		for (int i = 0; i < products.size(); i++) {
		    if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							result = false;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
						
							result = true;
						}

					}
				}
				if (result == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					result = true;
				}
        FileManager.saveArrayInFile(fileProduct, products);
        products.clear();
       assertEquals(expResult, result);
     }
     
     
        
     
     
     
}
