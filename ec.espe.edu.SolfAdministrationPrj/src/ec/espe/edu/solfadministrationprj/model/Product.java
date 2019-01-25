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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Omar Mejia
 */
public class Product {
	Scanner input = new Scanner(System.in);

	private String name;
	private String code;
	private float total;
	private int stock;
	private float cost;

	public Product() {

	}
	public String toString() {
		String line=getNameProduct()+";"+getCodeProduct()+";"+getTotal()+";"+getStock()+";"+getCost()+"\n";
		return line;
	}

	public Product(String nameProduct, String codeProduct, float total, float cost) {
		this.name = nameProduct;
		this.code = codeProduct;
		this.total = total;
		this.cost = cost;
	}

	public Product(String codeProduct, String nameProduct, int stock, float cost) {
		this.name = nameProduct;
		this.code = codeProduct;
		this.stock = stock;
		this.cost = cost;
	}

	public String getNameProduct() {
		return name;
	}

	public void setNameProduct(String nameProduct) {
		this.name = nameProduct;
	}

	public String getCodeProduct() {
		return code;
	}

	public void setCodeProduct(String codeProduct) {
		this.code = codeProduct;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * This method allows you to add a new product to the file
	 * 
	 * @param file :This parameter is the name of the file that contains the
	 *             products
	 */
	public void addProduct(File file,String codeStr,String nameStr, String stockStr,String costStr) {
                String products;
		//cost = Validations.validationOfFloat();
		products = codeStr + ";" + nameStr + ";" + stockStr + ";" + costStr;
		FileManager.write(file, products);
	}

	/**
	 * 
	 * @param      file: This parameter is the name of the file that contains the
	 *             products
	 * @param      product:This parameter is an Object Arrangement that will contain
	 *             the products registered in the file
	 * @param code :This parameter is the product code entered by the user to remove
	 *             the stock pf product
	 */

	public void removeStock(File file, ArrayList<Product> product, String code) {
		String letter;
		int quantSold;
		try {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				for (int k = 0; k < product.size(); k++) {
					if (product.get(k).getCodeProduct() != code) {
						letter = product.get(k).getCodeProduct() + ";" + product.get(k).getNameProduct() + ";"
								+ product.get(k).getStock() + ";" + product.get(k).getCost();
						bw.write(letter);
						bw.newLine();
					} else {
						System.out.println("Ingrese la cantidad vendida del producto");
						quantSold = input.nextInt();
						product.get(k).setStock(stock - quantSold);
					}
				}
			}

		} catch (IOException e) {
		}
	}

	/**
	 * 
	 * @param         file: This parameter is the name of the file that contains the
	 *                products
	 * @param product :This parameter is an Object Arrangement that will contain the
	 *                products registered in the file
	 * @param code    :This parameter is the product code entered by the user to
	 *                midify the code of product
	 */

	public void modifyCodeProduct(String code , String attribute , ArrayList<Product> products,File file){
        FileManager.createArrayOfFile(products, file);
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCodeProduct().equals(code))   products.get(i).setCodeProduct(attribute);
        }
        FileManager.saveArrayInFile(file, products);
        products.clear();
    }

        
	public void modifyNameProduct(String code , String attribute , ArrayList<Product> products,File file){
		
                FileManager.createArrayOfFile(products, file);
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCodeProduct().equals(code))   products.get(i).setNameProduct(attribute.toUpperCase());
        }
        FileManager.saveArrayInFile(file, products);
        products.clear();
    }
        
        

	public void modifyCostProduct(String code , String attribute , ArrayList<Product> products,File file) {
           FileManager.createArrayOfFile(products, file);
        float newCost;
        newCost = Float.parseFloat(attribute);
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCodeProduct().equals(code))   products.get(i).setCost(newCost);
        }
        FileManager.saveArrayInFile(file, products);
        products.clear();
    }


	public void modifyStockProduct(String code , String attribute , ArrayList<Product> products,File file) {
        FileManager.createArrayOfFile(products, file);
        int stock;
        stock = Integer.parseInt(attribute);
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCodeProduct().equals(code))   products.get(i).setStock(stock);
        }
        FileManager.saveArrayInFile(file, products);
        products.clear();
    }
}
