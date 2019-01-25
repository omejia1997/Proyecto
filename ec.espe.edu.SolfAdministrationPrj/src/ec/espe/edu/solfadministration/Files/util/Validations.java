/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.Files.util;

import ec.espe.edu.solfadministrationprj.model.Employee;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Scanner;

/**
 *
 * @author Luis Loachamin
 */
public class Validations {
	// validation of number int
	static Scanner sc = new Scanner(System.in);

	public static int validation(int x) {
		if (x < 0) {
			System.out.println("!!!ERROR No se permiten números Negativos ");
			System.out.println("Ingrese un número entero positivo");
			return 0;
		} else
			return 1;
	}

	/**
	 * This method can validate de number of a Identification Card of Ecuador
	 * 
	 * @author Pancho
	 * @param The number of Identification Card of type String.
	 * @return validation Return true if the Identification Card is correct and
	 *         false if the Identification card is incorrect.
	 */
	public static boolean validationOfIdCard(String identification) {
		boolean validation = false;
		int countOfValidations = 0;
		int aux = 0;
		int topTen = 0;
		int coefficients = 0;
		ArrayList<Integer> idArray = new ArrayList<Integer>();
		if (identification.length() >= 10) {
			for (int i = 0; i < 10; i++) {
				// System.out.println(identification.charAt(i));
				idArray.add(Character.getNumericValue(identification.charAt(i)));
			}
			aux = 10 * idArray.get(0) + idArray.get(1);
			// System.out.println(idArray);
			if (aux < 24 && aux > 0 && idArray.get(2) < 6) {
				countOfValidations++;
			}
			for (int i = 0; i < 10; i += 2) {
				if (i < 8) {
					coefficients = coefficients + idArray.get(i) * 2;
					if (idArray.get(i) * 2 >= 10) {
						coefficients = coefficients - 9;
					}

					coefficients = coefficients + idArray.get(i + 1) * 1;
					if (idArray.get(i + 1) * 1 >= 10) {
						coefficients = coefficients - 9;
					}

				} else {
					coefficients = coefficients + idArray.get(i) * 2;
					if (idArray.get(i) * 2 >= 10) {
						coefficients = coefficients - 9;
					}

				}

			}
			topTen = coefficients / 10;
			topTen = (topTen + 1) * 10;
			if (topTen - coefficients == idArray.get(9)) {
				countOfValidations++;
			}
			if (countOfValidations == 2) {
				validation = true;
			} else {
				validation = false;
			}
		}

		return validation;
        
}
    public static boolean validationId(long card){
    int[] arrayId= new int[10];
    int digit;
    int addDigits=0;
    int subtractionNumber=0;
    int numberFinal=0;
    int coc;
    int res;

        for(int i=9;i>=0;i--){
        coc=(int) (card/10);
        res=(int) (card%10);
        card=coc;
        arrayId[i]=res;
    }
    for(int i=0;i<9;i++){
        if(i==0){
        arrayId[i]=arrayId[i]*2;
            if(arrayId[i]>=10){
                arrayId[i]=arrayId[i]-9;
                    }
        }
        if( (i%2==0) && (i != 0) ){
           arrayId[i]=arrayId[i]*2;
            if(arrayId[i]>=10){
            arrayId[i]=arrayId[i]-9;
            }
        }
       if( (i%2 != 0) && (i!=0) ){
        arrayId[i]=arrayId[i]*1;
       if(arrayId[i]>=10){
        arrayId[i]=arrayId[i]-9;
        }
       }

        }

        for(int i=0;i<9;i++){

        }

        for(int i=0;i<9;i++){
                addDigits=addDigits+arrayId[i];
            }


        if(addDigits >=20 && addDigits<=29){
       subtractionNumber=30-addDigits;
        }
       if(addDigits >=10 && addDigits<=19){
      subtractionNumber=20-addDigits;
         }
      if(addDigits >=30 && addDigits<=39){
       subtractionNumber=40-addDigits;
       }


     numberFinal=arrayId[9];
       if(subtractionNumber == numberFinal){
                  return true;

                
        }else {
                return false;
                
        }
           
            
 }

	public static int validationInt(int x) {
		// validation so you do not enter a character
		int ban;

		do {
			try {
				ban = 0;
				x = sc.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingreso de Caracter no valido: ");
				System.out.println("Porfavor ingrese nuevamente un numero entero positivo");
				ban = 1;
				sc.nextLine();
			}
	} while (ban != 0 || validation(x) != 1);
		return 1;
	}
//
//	public static int validationOfPositiveInt() {
//		int num = Validations.validationOfInt();
//		if (num <= 0) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}

	/**
	 * @author Pancho This method should read an value type int of the console and
	 *         return it if it is an integer. And if it is not, should print a
	 *         message
	 * @return number The entered number
	 */
	public static int validationOfInt() {
		boolean correct = false;
		int number = 0;
		while (correct != true) {
			try {
				correct = true;
				number = new Scanner(System.in).nextInt();
				// System.out.println(" bien"+number);
			} catch (java.lang.RuntimeException e) {
				correct = false;

				// System.out.println("mal " +number);
				System.out.println("No es correcto, debe ingresar un entero, vuelva a ingresar");
			}
		}
		return number;

	}

	/**
	 * @author Pancho This method should read an value type float of the console and
	 *         return it if it is an float. And if it is not, should print a message
	 * @return number The entered number
	 */
	public static float validationOfFloat() {
		boolean correct = false;
		float number = 0;
		while (correct != true) {
			try {
				correct = true;
				number = new Scanner(System.in).nextFloat();

				// System.out.println(" bien"+number);
			} catch (java.lang.RuntimeException e) {
				correct = false;

				// System.out.println("mal " +number);
				System.out.println("Forma de Inreso inválida");
				System.out.println("Porfavor Ingrese nuevamente");
			}

		}
		return number;
	}

	/**
	 * @author Pancho This method should read an value type float of the console and
	 *         return it if it is an float and also if is positive. And if it is
	 *         not, should print a message
	 * @return number The entered number
	 */
	public static float validationOfPositiveFloat() {
		float num = 0;
		do {
			num = validationOfFloat();
			if (num < 0) {

				System.out.println("Ingreso un numero negativo");
			}
		} while (num < 0);
		return num;

	}

	/**
	 * This method allows to validate if a product has already been registered or
	 * not
	 * 
	 * @param product       :This parameter is an Object Arrangement that will contain the
	 *                      products registered in the file
	 * @param file          :This parameter is the name of the file where the
	 *                      information of the products of the inventory will be stored
	 * @param codeProduct   : This parameter is a code entered by the user to
	 *                      add a product
	 * @return a boolean expression where if it returns true is that a product has
	 *         already been registereds
	 */
	public static boolean validateProduct(ArrayList<Product> product, File file, String codeProduct) {
		boolean validateCode = false;
		FileManager.createArrayOfFile(product, file);
		for (int i = 0; i < product.size(); i++) {
			if (product.get(i).getCodeProduct().equals(codeProduct)) {
				validateCode = true;
			}
		}
		product.clear();
		return validateCode;
	}

	/**
	 * 
	 * @param product     :This parameter is an Object Arrangement that will contain
	 *                    the products registered in the file
	 * @param             file:This parameter is the name of the file where the
	 *                    information of the products of the inventory will be
	 *                    stored
	 * @param nameProduct
	 * @return a boolean expression where if it returns true is that a product has
	 *         already been registereds
	 */
	public static boolean validateNameProduct(ArrayList<Product> product, File file, String nameProduct) {
		boolean validateName = false;
		FileManager.createArrayOfFile(product, file);
		for (int i = 0; i < product.size(); i++) {
			if (product.get(i).getNameProduct().equals(nameProduct)) {
				validateName = true;
			}
		}
		product.clear();
		return validateName;
	}

	public static String validateString(String x) {
		String s1 = "";
		System.out.println(x);
		while (s1.equals("")) {
			s1 = sc.nextLine();
			if (!s1.matches("^[A-Za-z ]*$")) {
				s1 = "";
				System.out.println("ERROR.. Ingrese solo caracteres porfavor");
			}
		}
		return s1;

	}

	public static boolean validateDate(String bd) {
		try {
			DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
			formatDate.setLenient(false);
			formatDate.parse(bd);
		} catch (ParseException e) {
			System.out.println("FECHA INGRESADA NO VALIDA");
			return false;
		}
		return true;
	}

	public static Date ValidateBirthDate(Date date) {
		Calendar actualDate = Calendar.getInstance();
		Date age;
		int actualDay = actualDate.get(Calendar.DAY_OF_MONTH);
		int actualMonth = actualDate.get(Calendar.MONTH);
		int actualYear = actualDate.get(Calendar.YEAR);
		int maxDay = actualDate.getActualMaximum(Calendar.DATE);
		boolean verification = false;
		int theMonth, leapYear;
		theMonth = date.getMonth();
		if (date.getMonth() < 1 || date.getDay() < 1 || date.getYear() < 1900 || date.getMonth() > 12
				|| date.getYear() > actualYear) {

			verification = false;
		}
		else {
			verification = true;
		}
		if (theMonth == 1 || theMonth == 3 || theMonth == 5 || theMonth == 7 || theMonth == 8 || theMonth == 10
				|| theMonth == 12) {
			
			if (date.getDay() > 31) {
				verification = false;
			}

		} else if (theMonth == 4 || theMonth == 6 || theMonth == 9 || theMonth == 11) {
			if (date.getDay() > 30) {
				verification = false;
			}

		} else if(theMonth == 2 ){

			if (date.getDay() == 29) {
				leapYear = date.getYear() % 4;
				if (leapYear == 0) {

				} else {

					verification = true;
				}
			}
		}
		else {
		}

		if (!verification) {
			 age = new Date(-1, -1, -1);
		}else {
			 age = new Date(date.getYear(), date.getMonth(), date.getDay());
			
		}

		return age;
	}

	/**
	 * This method allows me to generate a larger word number
	 * 
	 * @param product :This parameter is an Object Arrangement that will contain the
	 *                products registered in the file
	 * @return The highest String number
	 */

	public int createWordSize(ArrayList<Product> product) {
		int size;
		int biggerNumber = 0;
		for (int i = 0; i < product.size(); i++) {
			size = product.get(i).getNameProduct().length();
			if (size > biggerNumber) {
				biggerNumber = size;
			}
		}
		return biggerNumber;
	}

	/**
	 * This method generates empty spaces
	 * 
	 * @param num this parameter is the highest word number
	 * @return this parameter is the highest word number
	 */
	public String generateSpaces(int num) {
		int cont = 0;
		String space = "";
		while (cont < num) {
			space += " ";
			cont++;
		}
		return space;
	}

	/**
	 * This method generates empty spaces
	 * 
	 * @param product :This parameter is an Object Arrangement that will contain the
	 *                products registered in the file
	 * @return Spaces generated in the array
	 */
	public ArrayList<Product> addSpaces(ArrayList<Product> product) {
		int biggerNumber = createWordSize(product);
		String genereateSpaces;
		String nameProduct;
		int numVariable;
		for (int i = 0; i < product.size(); i++) {
			if (product.get(i).getNameProduct().length() < biggerNumber) {
				numVariable = biggerNumber - product.get(i).getNameProduct().length();
				genereateSpaces = generateSpaces(numVariable);
				nameProduct = product.get(i).getNameProduct();
				product.get(i).setNameProduct(nameProduct + genereateSpaces);
			}
		}
		return product;
	}
        
        public static boolean validateDecimals(String attribute) {
        boolean validate = false;
        int parteEntera;
        int parteEntera2;
        int residuo = 0;
        double resultado;
        float valorInicial = Float.parseFloat(attribute);
        resultado = valorInicial;
        parteEntera = (int) Math.floor(resultado);//nos quedamos con la parte entera
        parteEntera2 = (int) Math.floor((resultado-parteEntera)*Math.pow(10,3));
        
        residuo = parteEntera2 % 10;
        if(valorInicial<=0){
            validate = false;
            return validate;
        }
        if((parteEntera2 % 10)==0){
            validate = true;
        }
                return validate;
}
        
        public static boolean validateIntStock(String attribute){
            int stock;
            boolean validate= true;
            try{
                stock =Integer.parseInt(attribute);
                if(stock<=0){
                    validate =false;
                    return validate;
                }
            }catch( NumberFormatException e){
                validate=false;
            }
            return validate;
        }

	public ArrayList<String> addSpacesArray(ArrayList<String> viewProduct) {
		int p1 = 0;
		int p2 = 0;
		int size1 = 0;
		int size2 = 0;
		int size3 = 0;
		int size4 = 0;
		int biggerNumber1 = 0;
		int biggerNumber2 = 0;
		int biggerNumber3 = 0;
		int biggerNumber4 = 0;

		for (int i = 0; i < viewProduct.size(); i++) {
			if (i % 4 == 0) {
				size1 = viewProduct.get(i).length();
				if (size1 > biggerNumber1) {
					biggerNumber1 = size1;
				}
			} else if (i - 1 == p1) {
				size2 = viewProduct.get(i).length();
				if (size2 > biggerNumber2) {
					biggerNumber2 = size2;
				}
				p1 += 4;
			} else if (i - 2 == p2) {
				size3 = viewProduct.get(i).length();
				if (size3 > biggerNumber3) {
					biggerNumber3 = size3;
					p2 += 4;
				}
			} else {
				size4 = viewProduct.get(i).length();
				if (size4 > biggerNumber4) {
					biggerNumber4 = size4;
				}
			}
		}
		String generateSpace1;
		String generateSpace2;
		String generateSpace3;
		String generateSpace4;
		String newWord;
		String replaceAll;

		p1 = 0;
		p2 = 0;

		int tam1 = 0;
		int tam2 = 0;
		int tam3 = 0;
		int tam4 = 0;

		for (int i = 0; i < viewProduct.size(); i++) {
			if (i % 4 == 0) {
				if (viewProduct.get(i).length() < biggerNumber1) {
					tam1 = biggerNumber1 - viewProduct.get(i).length();
					generateSpace1 = generateSpaces(tam1);
					newWord = viewProduct.get(i);
					viewProduct.set(i, newWord + generateSpace1);

				}
			} else if (i - 1 == p1) {
				p1 += 4;
				if (viewProduct.get(i).length() < biggerNumber2) {
					tam2 = biggerNumber2 - viewProduct.get(i).length();
					generateSpace2 = generateSpaces(tam2);
					newWord = viewProduct.get(i);
					viewProduct.set(i, newWord + generateSpace2);

				}
			} else if (i - 2 == p2) {
				p2 += 4;
				if (viewProduct.get(i).length() < biggerNumber3) {
					tam3 = biggerNumber3 - viewProduct.get(i).length();
					generateSpace3 = generateSpaces(tam3);
					newWord = viewProduct.get(i);
					viewProduct.set(i, newWord + generateSpace3);

				}
			} else {
				if (viewProduct.get(i).length() < biggerNumber4) {
					tam4 = biggerNumber4 - viewProduct.get(i).length();
					generateSpace4 = generateSpaces(tam4);
					newWord = viewProduct.get(i);
					viewProduct.set(i, newWord + generateSpace4);
				}
			}
		}
		return viewProduct;
	}
        
         public ArrayList<String> addSpacesArrayEmployee(ArrayList<String> viewEmployee) {
		int p1 = 0;
		int p2 = 0;
                int p3 = 0;
                int p4 = 0;
                int p5 = 0;
                int p6 = 0;
                                       
		int size1 = 0;
		int size2 = 0;
		int size3 = 0;
		int size4 = 0;
                int size5 = 0;
                int size6 = 0;
                int size7 = 0;
                int size8 = 0;
                        
		int biggerNumber1 = 0;
		int biggerNumber2 = 0;
		int biggerNumber3 = 0;
		int biggerNumber4 = 0;
                int biggerNumber5 = 0;
                int biggerNumber6 = 0;
                int biggerNumber7 = 0;
                int biggerNumber8 = 0;
                
		for (int i = 0; i < viewEmployee.size(); i++) {
			if (i % 8 == 0) {
				size1 = viewEmployee.get(i).length();
				if (size1 > biggerNumber1) {
					biggerNumber1 = size1;
				}
			} else if (i - 1 == p1) {
				size2 = viewEmployee.get(i).length();
				if (size2 > biggerNumber2) {
					biggerNumber2 = size2;
				}
				p1 += 8;
			} else if (i - 2 == p2) {
				size3 = viewEmployee.get(i).length();
				if (size3 > biggerNumber3) {
					biggerNumber3 = size3;
					
				}
                                p2 += 8;
			} else if (i - 3 == p3) {
				size4 = viewEmployee.get(i).length();
				if (size4 > biggerNumber4) {
					biggerNumber4 = size4;
				}
                                 p3 +=8;
			}else if (i - 4 == p4){
                                size5 = viewEmployee.get(i).length();
                                if(size5 > biggerNumber5){
                                    biggerNumber5 = size5;
                                }
                                p4 +=8;
                        }else if(i - 5 == p5){
                            size6 = viewEmployee.get(i).length();
                            if(size6 > biggerNumber6){
                                    biggerNumber6 = size6;
                                }
                            p5 +=8;
                        }else if(i - 6 == p6){
                            size7 = viewEmployee.get(i).length();
                            if(size7 > biggerNumber7){
                                    biggerNumber7 = size7;
                                    }
                            p6 += 8;
                        }else{
                            size8 = viewEmployee.get(i).length();
                            if(size8 > biggerNumber8){
                                    biggerNumber8 = size8;
                                }
                        }
                }
		String generateSpace1;
		String generateSpace2;
		String generateSpace3;
		String generateSpace4;
                String generateSpace5;
                String generateSpace6;
                String generateSpace7;
                String generateSpace8;
		String newWord;
		String replaceAll;

		p1 = 0;
		p2 = 0;
                p3 = 0;
                p4 = 0;
		p5 = 0;
                p6 = 0;
               
                int tam1 = 0;
		int tam2 = 0;
		int tam3 = 0;
		int tam4 = 0;
                int tam5 = 0;
                int tam6 = 0;
                int tam7 = 0;
                int tam8 = 0;

		for (int i = 0; i < viewEmployee.size(); i++) {
			if (i % 8 == 0) {
				if (viewEmployee.get(i).length() < biggerNumber1) {
					tam1 = biggerNumber1 - viewEmployee.get(i).length();
					generateSpace1 = generateSpaces(tam1);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace1);

				}
			} else if (i - 1 == p1) {
				p1 += 8;
				if (viewEmployee.get(i).length() < biggerNumber2) {
					tam2 = biggerNumber2 - viewEmployee.get(i).length();
					generateSpace2 = generateSpaces(tam2);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace2);

				}
			} else if (i - 2 == p2) {
				p2 += 8;
				if (viewEmployee.get(i).length() < biggerNumber3) {
					tam3 = biggerNumber3 - viewEmployee.get(i).length();
					generateSpace3 = generateSpaces(tam3);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace3);

				}
			} else if (i -3 == p3){
                                p3 +=8;
				if (viewEmployee.get(i).length() < biggerNumber4) {
					tam4 = biggerNumber4 - viewEmployee.get(i).length();
					generateSpace4 = generateSpaces(tam4);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace4);
				}
			}else if (i -4 == p4){
                                p4 +=8;
				if (viewEmployee.get(i).length() < biggerNumber5) {
                                        tam5 = biggerNumber5 - viewEmployee.get(i).length();
					generateSpace5 = generateSpaces(tam5);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace5);
                                }
                        }else if (i -5 == p5){
                                p5 +=8;
				if (viewEmployee.get(i).length() < biggerNumber5) {
					tam6 = biggerNumber6 - viewEmployee.get(i).length();
					generateSpace6 = generateSpaces(tam6);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace6);
                                }
                        }else if (i -6 == p6){
                                p6 +=8;
				if (viewEmployee.get(i).length() < biggerNumber5) {
					tam7 = biggerNumber7 - viewEmployee.get(i).length();
					generateSpace7 = generateSpaces(tam7);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace7);
                                }
                        }else {
				if (viewEmployee.get(i).length() < biggerNumber5) {
                                        tam8 = biggerNumber8 - viewEmployee.get(i).length();
					generateSpace8 = generateSpaces(tam8);
					newWord = viewEmployee.get(i);
					viewEmployee.set(i, newWord + generateSpace8);
                                }
                        }
		}
		return viewEmployee;
	}
         
         public static boolean isNumeric(String cadena){
	try {
		Double.parseDouble(cadena);
		return false;
	} catch (NumberFormatException nfe){
		return true;
	}
}
        public static boolean validateCodeProduct(String cadena){
            
            if((cadena.length()== 4)&& isNumeric(cadena)==false){
                    return false;
                                    }else{
                                            return true;
            }
        } 
         public static boolean validateUser(File file,ArrayList<Employee> employee,String user){
             boolean validate=false;
             FileManager.createArrayEmployeeOfFile(employee, file);
             for(int i=0;i<employee.size();i++){
                 if(employee.get(i).getUserName().equals(user)){
                     validate =true;
                 }
             }
             return validate;
} 
         
         public static boolean validatePassword(File file,ArrayList<Employee> employee,String password){
             boolean validate=false;
             FileManager.createArrayEmployeeOfFile(employee, file);
             for(int i=0;i<employee.size();i++){
                 if(employee.get(i).getPassword().equals(password)){
                     validate =true;
                 }
             }
             return validate;            
} 
         public static boolean validateId(File file,ArrayList<Employee> employee,String id){
             boolean validate=false;
             for(int i=0;i<employee.size();i++){
                 if(employee.get(i).getId().equals(id)){
                     validate =true;
                 }
             }
             return validate;            
}
         public static int numberOfArrayProduct(File file,ArrayList<Product> product,String code){
             int j = -1;
             System.out.println(product.get(0).getCodeProduct());
             for(int i=0;i < product.size();i++){
                 if(product.get(i).getCodeProduct().equals(code)){
                     
                     j = i;
                     return j;
         }
        }
             return j;
    }
         
}