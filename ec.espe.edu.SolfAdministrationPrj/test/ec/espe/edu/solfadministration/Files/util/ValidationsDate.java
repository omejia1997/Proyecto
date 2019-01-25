/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.Files.util;

import ec.espe.edu.solfadministrationprj.model.Employee;
import ec.espe.edu.solfadministrationprj.model.Product;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Omar Mejia
 */
public class ValidationsDate {
    
    public ValidationsDate() {
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

    /**
     * Test of validation method, of class Validations.
     */
    @Test
    public void testValidation() {
        System.out.println("validation");
        int x = -2;
        int expResult = 0;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
    
    @Test
    public void testValidation2() {
        System.out.println("validation");
        int x = -99;
        int expResult = 0;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
    
    @Test
    public void testValidation3() {
        System.out.println("validation");
        int x = -99;
        int expResult = 0;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
    
    @Test
    public void testValidation4() {
        System.out.println("validation");
        int x = -6;
        int expResult = 0;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
    @Test
    public void testValidation5() {
        System.out.println("validation");
        int x = 100;
        int expResult = 1;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
    
    @Test
    public void testValidation6() {
        System.out.println("validation");
        int x = 5;
        int expResult = 1;
        int result = Validations.validation(x);
        assertEquals(expResult, result);
        System.out.println("result "+result+" expected result "+expResult +" sucessful");
    }
 
    /**
     * Test of validateProduct method, of class Validations.
     */
    @Test
    public void testValidateProduct() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "0";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct2() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "2";
        boolean expResult = true;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testValidateProduct3() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-2";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testValidateProduct4() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "20";
        boolean expResult = true;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testValidateProduct5() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-1100";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testValidateProduct6() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-99999999";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct7() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-999";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct8() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-500";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct9() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-9";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct10() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-100";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateProduct11() {
        System.out.println("validateProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String codeProduct = "-6";
        boolean expResult = false;
        boolean result = Validations.validateProduct(product, file, codeProduct);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of validateNameProduct method, of class Validations.
     */
    
    @Test
    public void testValidateNameProduct() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "RISKOS";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct2() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "Bubaloo";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct3() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "Bubaloo";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testValidateNameProduct4() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "FUZETEA";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testValidateNameProduct5() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "";
        boolean expResult = false;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct6() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "1";
        boolean expResult = false;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct7() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "caracter";
        boolean expResult = false;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct8() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "Camion";
        boolean expResult = false;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct9() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "FIDEO PACA";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct10() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "fideo";
        boolean expResult = false;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct11() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "CHISCAKE DE OREO";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateNameProduct12() {
        System.out.println("validateNameProduct");
        ArrayList<Product> product = new ArrayList<>();
        File file = new File("TestOfProduct.txt");
        String nameProduct = "AVENA";
        boolean expResult = true;
        boolean result = Validations.validateNameProduct(product, file, nameProduct);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createWordSize method, of class Validations.
     */
    @Test
    public void testCreateWordSize() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Chocolate", 0,0));
        Validations instance = new Validations();
        int expResult = 9;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
    
       @Test
        public void testCreateWordSize2() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "papel", 0, 0));
        Validations instance = new Validations();
        int expResult = 5;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
    
        @Test
        public void testCreateWordSize3() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Leche", 0, 0));
        Validations instance = new Validations();
        int expResult = 5;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }

        @Test
        public void testCreateWordSize4() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "HUEVOS", 0, 0));
        Validations instance = new Validations();
        int expResult = 6;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        @Test
        public void testCreateWordSize5() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "CIFRUT", 0, 0));
        Validations instance = new Validations();
        int expResult = 6;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        
        @Test
        public void testCreateWordSize6() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Pan", 0, 0));
        Validations instance = new Validations();
        int expResult = 3;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        @Test
        public void testCreateWordSize7() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Cama", 0, 0));
        Validations instance = new Validations();
        int expResult = 4;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        
        @Test
        public void testCreateWordSize8() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Ciruelas", 0, 0));
        Validations instance = new Validations();
        int expResult = 8;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        
        @Test
        public void testCreateWordSize9() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "Camión", 0, 0));
        Validations instance = new Validations();
        int expResult = 6;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        @Test
        public void testCreateWordSize10() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0", "", 0, 0));
        Validations instance = new Validations();
        int expResult = 0;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
        @Test
        public void testCreateWordSize11() {
        System.out.println("createWordSize");
        ArrayList<Product> product = new ArrayList<>();
        product.add(new Product("0","Golosinas", 0, 0));
        Validations instance = new Validations();
        int expResult = 9;
        int result = instance.createWordSize(product);
        assertEquals(expResult, result);
    }
    /**
     * Test of generateSpaces method, of class Validations.
     */
        @Test
        public void testGenerateSpaces() {
        System.out.println("generateSpaces");
        int num = 5;
        Validations instance = new Validations();
        String expResult = "     ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
    
        @Test
        public void testGenerateSpaces2() {
        System.out.println("generateSpaces");
        int num = 6;
        Validations instance = new Validations();
        String expResult = "      ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }

        @Test
        public void testGenerateSpaces3() {
        System.out.println("generateSpaces");
        int num = 0;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
       @Test
        public void testGenerateSpaces4() {
        System.out.println("generateSpaces");
        int num = -5;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
    
       @Test
        public void testGenerateSpaces5() {
        System.out.println("generateSpaces");
        int num = -100;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
         @Test
        public void testGenerateSpaces6() {
        System.out.println("generateSpaces");
        int num = 1;
        Validations instance = new Validations();
        String expResult = " ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
         @Test
        public void testGenerateSpaces7() {
        System.out.println("generateSpaces");
        int num = 3;
        Validations instance = new Validations();
        String expResult = "   ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
        @Test
        public void testGenerateSpaces8() {
        System.out.println("generateSpaces");
        int num = 8;
        Validations instance = new Validations();
        String expResult = "        ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
         @Test
        public void testGenerateSpaces9() {
        System.out.println("generateSpaces");
        int num = -12;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
         @Test
        public void testGenerateSpaces10() {
        System.out.println("generateSpaces");
        int num = 0;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
         @Test
        public void testGenerateSpaces11() {
        System.out.println("generateSpaces");
        int num = -1000;
        Validations instance = new Validations();
        String expResult = "";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }
        
         @Test
        public void testGenerateSpaces12() {
        System.out.println("generateSpaces");
        int num = 20;
        Validations instance = new Validations();
        String expResult = "                    ";
        String result = instance.generateSpaces(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of isNumeric method, of class Validations.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String cadena = "";
        boolean expResult = true;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }

    @Test
    public void testIsNumeric2() {
        System.out.println("isNumeric");
        String cadena = "222";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }

    
    @Test
    public void testIsNumeric3() {
        System.out.println("isNumeric");
        String cadena = "555555555555";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric4() {
        System.out.println("isNumeric");
        String cadena = "5050";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric5() {
        System.out.println("isNumeric");
        String cadena = "1111111111";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric6() {
        System.out.println("isNumeric");
        String cadena = "11ssss";
        boolean expResult = true;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    
    @Test
    public void testIsNumeric7() {
        System.out.println("isNumeric");
        String cadena = "1025s5";
        boolean expResult = true;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    
    @Test
    public void testIsNumeric8() {
        System.out.println("isNumeric");
        String cadena = "1a2d5s5";
        boolean expResult = true;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric9() {
        System.out.println("isNumeric");
        String cadena = "5555555555555555554s";
        boolean expResult = true;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    
    @Test
    public void testIsNumeric10() {
        System.out.println("isNumeric");
        String cadena = "-222222";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric11() {
        System.out.println("isNumeric");
        String cadena = "-1";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testIsNumeric12() {
        System.out.println("isNumeric");
        String cadena = "0";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
    
    
    @Test
    public void testIsNumeric13() {
        System.out.println("isNumeric");
        String cadena = "1";
        boolean expResult = false;
        boolean result = Validations.isNumeric(cadena);
        assertEquals(expResult, result);
        }
  
    
    /**
     * Test of validateCodeProduct method, of class Validations.
     */
   @Test
    public void testValidateCodeProduct() {
        System.out.println("validateCodeProduct");
        String cadena = "";
        boolean expResult = true;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
        }
    
    @Test
    public void testValidateCodeProduct2() {
        System.out.println("validateCodeProduct");
        String cadena = "4444";
        boolean expResult = false;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
    @Test
    public void testValidateCodeProduct3() {
        System.out.println("validateCodeProduct");
        String cadena = "0004";
        boolean expResult = false;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
    @Test
    public void testValidateCodeProduct4() {
        System.out.println("validateCodeProduct");
        String cadena = "pppp";
        boolean expResult = true;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
    @Test
    public void testValidateCodeProduct5() {
        System.out.println("validateCodeProduct");
        String cadena = "55555";
        boolean expResult = true;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
   @Test
    public void testValidateCodeProduct6() {
        System.out.println("validateCodeProduct");
        String cadena = "ppp1";
        boolean expResult = true;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
    @Test
    public void testValidateCodeProduct7() {
        System.out.println("validateCodeProduct");
        String cadena = "-0001";
        boolean expResult = true;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }
    
    @Test
    public void testValidateCodeProduct8() {
        System.out.println("validateCodeProduct");
        String cadena = "0000";
        boolean expResult = false;
        boolean result = Validations.validateCodeProduct(cadena);
        assertEquals(expResult, result);
       }

    /**
     * Test of validationOfIdCard method, of class Validations.
     */
    @org.junit.Test
    public void testValidationOfIdCard() {
        System.out.println("validationOfIdCard");
        String identification = "";
        boolean expResult = false;
        boolean result = Validations.validationOfIdCard(identification);
        assertEquals(expResult, result);
    }

    /**
     * Test of validationId method, of class Validations.
     */
    @org.junit.Test
    public void testValidationId() {
        System.out.println("validationId");
        long card = 0L;
        boolean expResult = true;
        boolean result = Validations.validationId(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class Validations.
     */
    @org.junit.Test
    public void testValidateDate() {
        System.out.println("validateDate");
        String bd = "";
        boolean expResult = false;
        boolean result = Validations.validateDate(bd);
        assertEquals(expResult, result);
    }

}
