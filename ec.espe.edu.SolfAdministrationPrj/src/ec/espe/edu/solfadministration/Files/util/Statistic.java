/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.Files.util;

import ec.espe.edu.solfadministrationprj.model.Billing;
import ec.espe.edu.solfadministrationprj.model.Inventory;
import ec.espe.edu.solfadministrationprj.model.Product;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Pancho
 * @author SAOM
 *
 */
public class Statistic {

    private ArrayList<Product> product;
    private static float valueExpenses;
    private static float valueIncome;
    private Billing bill;
    private Inventory inventory;

    // construtor
    // methods of class
    public Statistic() {
        valueIncome = 0;
    }

    public static ArrayList<String> viewStatisticsByMonth() {
        ArrayList<String> sales = FileManager.dataRescue(new File("Estadisticas de ventas.txt"));

        DecimalFormatSymbols symbolFormat = new DecimalFormatSymbols();
        symbolFormat.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbolFormat);
        String date = "";
        String dayOfSale = "";
        String monthOfSale = "";
        String yearOfSale = "";
 ArrayList<String> objetiveSales = new ArrayList<String>();
       
        float daySale = 0;
        float totalSales = 0;

        Calendar actualDate = Calendar.getInstance();
        int actualDay = actualDate.get(Calendar.DAY_OF_MONTH);
        int actualMonth = actualDate.get(Calendar.MONTH) + 1;
        int actualYear = actualDate.get(Calendar.YEAR);
        System.out.println("Ventas del dia");
        System.out.println("-------------------------------------");
        System.out.println("Fecha\t     \tPrecio de venta");
        System.out.println("-------------------------------------");
        for (String p : sales) {
            //System.out.println(p);
            date = p.split(";")[0];
            yearOfSale = date.split("-")[0];
            yearOfSale = yearOfSale.replaceFirst("^0*", "");
            monthOfSale = date.split("-")[1];
            monthOfSale = monthOfSale.replaceFirst("^0*", "");
            dayOfSale = date.split("-")[2];
            dayOfSale = dayOfSale.replaceFirst("^0*", "");

            daySale = Float.parseFloat(p.split(";")[1]);
            //System.out.println(actualDay+" ---"+actualMonth+"---" +actualYear);
            //System.out.println(  dayOfSale+" ---"+monthOfSale+"---" +yearOfSale);

            if (monthOfSale.equals(String.valueOf(actualMonth))
                    && yearOfSale.equals(String.valueOf(actualYear))) {

                totalSales = totalSales + daySale;

                System.out.println(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])) + " $");
                objetiveSales.add(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])));
            }

        }
        System.out.println("Ingresos del mes: " + totalSales + " $ \n");
        valueIncome = Float.parseFloat(decimalFormat.format(valueIncome));

        return objetiveSales;
    }

    /**
     * * This method show the sales of the daya its total
     *
     * @author Pancho
     * @param sales This should be an ArrayList of strings that has all the
     * dates and the sales of the system
     */
    public static ArrayList<String> viewStatisticsByDay() {

        ArrayList<String> sales = FileManager.dataRescue(new File("Estadisticas de ventas.txt"));

        DecimalFormatSymbols symbolFormat = new DecimalFormatSymbols();
        symbolFormat.setDecimalSeparator('.');
 ArrayList<String> objetiveSales = new ArrayList<String>();
       
        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbolFormat);
        String date = "";
        String dayOfSale = "";
        String monthOfSale = "";
        String yearOfSale = "";

        float daySale = 0;
        float totalSales = 0;

        Calendar actualDate = Calendar.getInstance();
        int actualDay = actualDate.get(Calendar.DAY_OF_MONTH);
        int actualMonth = actualDate.get(Calendar.MONTH) + 1;
        int actualYear = actualDate.get(Calendar.YEAR);
        System.out.println("Ventas del dia");
        System.out.println("-------------------------------------");
        System.out.println("Fecha\t     \tPrecio de venta");
        System.out.println("-------------------------------------");
        for (String p : sales) {
            //System.out.println(p);
            date = p.split(";")[0];
            yearOfSale = date.split("-")[0];
            yearOfSale = yearOfSale.replaceFirst("^0*", "");
            monthOfSale = date.split("-")[1];
            monthOfSale = monthOfSale.replaceFirst("^0*", "");
            dayOfSale = date.split("-")[2];
            dayOfSale = dayOfSale.replaceFirst("^0*", "");

            daySale = Float.parseFloat(p.split(";")[1]);
            //System.out.println(actualDay+" ---"+actualMonth+"---" +actualYear);
            //System.out.println(  dayOfSale+" ---"+monthOfSale+"---" +yearOfSale);

            if (dayOfSale.equals(String.valueOf(actualDay)) && monthOfSale.equals(String.valueOf(actualMonth))
                    && yearOfSale.equals(String.valueOf(actualYear))) {

                totalSales = totalSales + daySale;

                System.out.println(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])) + " $");
                objetiveSales.add(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])));
            }

        }
        System.out.println("Ingresos de hoy: " + totalSales + " $ \n");
        valueIncome = Float.parseFloat(decimalFormat.format(valueIncome));

        return objetiveSales;
    }

    /**
     * This method can give a ArrayList of strings that has the sales of the
     * specific date
     *
     * @author Pancho
     * @param sales Array List of strings
     * @param year The year of de specific Date
     * @param month The month of de specific Date
     * @param day The day of de specific Date
     * @return An ArrayList of Strings that has the sales of de Specific date
     */
    public static ArrayList<String> viewStatisticsBySpecificDate(int year, int month, int day) {

        ArrayList<String> sales = FileManager.dataRescue(new File("Estadisticas de ventas.txt"));
        DecimalFormatSymbols symbolFormat = new DecimalFormatSymbols();
        symbolFormat.setDecimalSeparator('.');
        ArrayList<String> objetiveSales = new ArrayList<String>();
        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbolFormat);
        String date = "";
        String dayOfSale = "";
        String monthOfSale = "";
        String yearOfSale = "";

        float daySale = 0;
        float totalSales = 0;

        Calendar actualDate = Calendar.getInstance();

        Date specificDate = new Date(0, 0, 0);

        System.out.println("-------------------------------------");
        System.out.println("Fecha\t     \tPrecio de venta");
        System.out.println("-------------------------------------");

        for (String p : sales) {
            //System.out.println(p);
            date = p.split(";")[0];
            yearOfSale = date.split("-")[0];
            yearOfSale = yearOfSale.replaceFirst("^0*", "");
            monthOfSale = date.split("-")[1];
            monthOfSale = monthOfSale.replaceFirst("^0*", "");
            dayOfSale = date.split("-")[2];
            dayOfSale = dayOfSale.replaceFirst("^0*", "");

            daySale = Float.parseFloat(p.split(";")[1]);

            if (dayOfSale.equals(String.valueOf(day)) && monthOfSale.equals(String.valueOf(month))
                    && yearOfSale.equals(String.valueOf(year))) {

                totalSales = totalSales + daySale;

                System.out.println(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])) + " $");
                objetiveSales.add(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])));
            }

        }
        System.out.println("Ingresos de  " + year + "-" + month + "-" + day + " :" + totalSales + " $ \n");
        valueIncome = Float.parseFloat(decimalFormat.format(totalSales));

        return objetiveSales;
    }

    /**
     * @author Pancho This method has an ArrayList of Strings and makes a sum of
     * the values, to see the utility of the store.
     * @param sales This should be an ArrayList of strings that has all the
     * dates and the sales of the system
     * @return totalSales Return the value of all sales.
     */
    public static float calculateIncome(ArrayList<String> sales) {
        DecimalFormatSymbols symbolFormat = new DecimalFormatSymbols();
        symbolFormat.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbolFormat);
        String date = "";
        float totalSales = 0;

        System.out.println("----------- | -----------------------");
        System.out.println("Fecha\t    |  \tPrecio de venta");
        System.out.println("----------- | -----------------------");
        for (String p : sales) {
            //System.out.println(p);
            totalSales = totalSales + Float.parseFloat(p.split(";")[1]);
            date = p.split(";")[0];
            System.out.println(date + "  |\t" + String.valueOf(Float.parseFloat(p.split(";")[1])) + " $");
        }
        System.out.println("Ingresos actuales: " + totalSales + " $ \n");
        valueIncome = Float.parseFloat(decimalFormat.format(valueIncome));
        return totalSales;

    }

    /**
     * This methond calculate the expenses with and ArrayList of Products
     *
     * @param product
     * @return
     */
    public static float calculateExpenses(ArrayList<Product> product) {
        for (int i = 0; i < product.size(); i++) {
            valueIncome = valueIncome + product.get(i).getCost();
        }
        return valueExpenses;
    }

    // setters and getters
    /*
	 * public Product[] getProduct() { return product; } public void
	 * setProduct(Product[] product) { this.product = product; }
     */
    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    public float getValueExpenses() {
        return valueExpenses;
    }

    public void setValueExpenses(float valueExpenses) {
        this.valueExpenses = valueExpenses;
    }

    public static float getValueIncome() {
        return valueIncome;
    }

    public void setValueIncome(float valueIncome) {
        this.valueIncome = valueIncome;
    }

    public Billing getBill() {
        return bill;
    }

    public void setBill(Billing bill) {
        this.bill = bill;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
