package ec.espe.edu.solfadministrationprj.model;

import ec.espe.edu.solfadministration.Files.util.FileManager;
import ec.espe.edu.solfadministration.Files.util.Validations;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Billing {

	/**
	 *
	 * @author Pancho
	 */
	Scanner input = new Scanner(System.in);
	Store shop = new Store();
	Product product1 = new Product();

	private Inventory product;
	private int codeSaleProduct;
	private float quantityProductSold;
	private float iva;
	private float total;
	private int multiplicity;
	private String nameProduct;
	private float subtotal;
	private float totalSold;

	public float getTotalSold() {
		return totalSold;
	}

	ArrayList<Product> bill = new ArrayList<Product>();

	// construtor

	public Billing(Inventory product, int codeSaleProduct, int quantityProductSold, float iva, float total,
			int multiplicity, String nameProduct, File file3) {
		this.product = product;
		this.codeSaleProduct = codeSaleProduct;
		this.quantityProductSold = quantityProductSold;
		this.iva = iva;
		this.total = total;
		this.multiplicity = multiplicity;
		this.nameProduct = nameProduct;
		calculateSellValue(new File("Estadisticas de ventas.txt"), file3);
		generateBill(new File("Factura.txt"));
	}

	// methods of class
	public Billing() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	public Billing(int i, int i0, int i1) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	/**
	 * This method calculates a new sale and the value is also stored in a file for
	 * later viewing.
	 * 
	 * @return The value of total buy.
	 */
	public float calculateSellValue(File file, File file2) {
		ArrayList<Product> products = new ArrayList<Product>();
		Product actualProduct;

		// FileManager.createArrayOfFile(products,file2);

		DecimalFormatSymbols symbolFormat = new DecimalFormatSymbols();
		symbolFormat.setDecimalSeparator('.');

		DecimalFormat decimalFormat = new DecimalFormat("#.00", symbolFormat);
		boolean existence = false;
		System.out.println("Calculo de venta ");
		String x;

		subtotal = 0;
		int decicion = 0;
		do {

			boolean validate = false;
			do {

				System.out.println("Ingrese el nombre del producto");
				nameProduct = new Scanner(System.in).next().toUpperCase();
				System.out.println("Ingrese las unidades de este producto");
				multiplicity = Validations.validationInt(multiplicity);

				FileManager.createArrayOfFile(products, file2);
				for (int i = 0; i < products.size(); i++) {
					if (products.get(i).getNameProduct().equals(nameProduct)) {
						if (products.get(i).getStock() <= 0) {
							System.out.println("PRODUCTO NO DISPONIBLE");
							products.get(i).setStock(0);

							validate = true;

						} else {

							System.out.println("Seleciono: " + products.get(i).getNameProduct() + ", y su Precio: "
									+ products.get(i).getCost());

							// System.out.println(multiplicity);
							int totalStock = products.get(i).getStock() - multiplicity;
							total = products.get(i).getCost() * multiplicity;

							products.get(i).setStock(totalStock);
							System.out.println("LA CANTIDAD ACTUAL DE PRODUCTOS ES: " + totalStock);
							validate = true;
						}

					}
				}
				if (validate == false) {
					System.out.println("El producto no se encuentra en el inventario");

				} else {
					validate = true;
				}
			} while (validate == false);

			// System.out.println("Ingresos por producto " + actualProduct.getNameProduct()
			// + " es " + String.valueOf(Float.parseFloat(decimalFormat.format(total))));
			subtotal = subtotal + total;
			String y;
			y = String.valueOf(multiplicity);

			bill.add(new Product(nameProduct, y, total, quantityProductSold));

			System.out.println("Desea agregar otro producto");
			System.out.println("1. SI");
			System.out.println("2. NO");
			decicion = Validations.validationInt(decicion);
			FileManager.saveArrayInFile(file2, products);
			products.clear();
		} while (decicion == 1);
		totalSold = subtotal * getIva();
		iva = totalSold - subtotal;
		totalSold = Float.parseFloat(decimalFormat.format(totalSold));
		System.out.println(totalSold);
		x = String.valueOf(totalSold);
		FileManager.write(file, java.time.LocalDate.now() + ";" + x);
		System.out.println(x);
		return totalSold;

		/**
		 * This method can write the Billing on a file to print for the costumer
		 * 
		 * @param file
		 */
	}

	public void generateBill(File file) {
		
		System.out.println("FACTURA GENERADA");
		System.out.println("=>>> Factura <<<==");
		System.out.println((shop.getStoreName()));
		System.out.println("DIA DE FACTURACION: " + java.time.LocalDate.now());
		System.out.println("HORA DE FCATURACION: " + java.time.LocalTime.now());
		System.out.println("VALOR TOTAL A PAGAR : " + totalSold);
	}

	// setters and getters
	public Inventory getProduct() {
		return product;
	}

	public void setProduct(Inventory product) {
		this.product = product;
	}

	public int getCodeSaleProduct() {
		return codeSaleProduct;
	}

	public void setCodeSaleProduct(int codeSaleProduct) {
		this.codeSaleProduct = codeSaleProduct;
	}

	public float getQuantityProductSold() {
		return quantityProductSold;
	}

	public void setQuantityProductSold(int quantityProductSold) {
		this.quantityProductSold = quantityProductSold;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
