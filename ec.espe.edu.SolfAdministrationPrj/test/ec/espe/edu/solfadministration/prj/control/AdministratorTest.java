/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministration.prj.control;

import ec.espe.edu.solfadministrationprj.model.Employee;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SAOM
 */
public class AdministratorTest {
    
    public AdministratorTest() {
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
     * Test of generateUser method, of class Administrator.
     */
    @Test
    public void testGenerateUser() 
    {
        System.out.println("generateUser1");
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 17);
        Administrator instance = new Administrator("1726134503","SEBASTIAN","Masculino",bd);
        String expResult = "SEBA261";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser2() 
    {
        System.out.println("generateUser2");
        Calendar bd = Calendar.getInstance();
        bd.set(1976, 04, 29);
        Administrator instance = new Administrator("1710898345","MAURICIO","Masculino",bd);
        String expResult = "MAUR108";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser3() 
    {
        System.out.println("generateUser3");
        Calendar bd = Calendar.getInstance();
        bd.set(1976, 8, 01);
        Administrator instance = new Administrator("1713704979","Sandra","Femenino",bd);
        String expResult = "SAND137";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser4() 
    {
        System.out.println("generateUser4");
        Calendar bd = Calendar.getInstance();
        bd.set(2003, 04, 27);
        Administrator instance = new Administrator("1726348707","SAMANTHA","femenino",bd);
        String expResult = "SAMA263";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser5() 
    {
        System.out.println("generateUser5");
        Calendar bd = Calendar.getInstance();
        bd.set(1988, 04, 12);
        Administrator instance = new Administrator("1721675385","DAYSI","femenino",bd);
        String expResult = "DAYS216";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser6() 
    {
        System.out.println("generateUser6");
        Calendar bd = Calendar.getInstance();
        bd.set(1961, 01, 15);
        Administrator instance = new Administrator("1706918149","monica","femenino",bd);
        String expResult = "MONI069";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCEESEED");
        
    }
     @Test
    public void testGenerateUser7() 
    {
        System.out.println("generateUser7");
        Calendar bd = Calendar.getInstance();
        bd.set(1963, 11, 02);
        Administrator instance = new Administrator("1707814909","anibal","masculino",bd);
        String expResult = "ANIB078";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser8() 
    {
        System.out.println("generateUser8");
        Calendar bd = Calendar.getInstance();
        bd.set(1974, 02, 14);
        Administrator instance = new Administrator("1712439395","silvia","femenino",bd);
        String expResult = "SILV124";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser9() 
    {
        System.out.println("generateUser9");
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 20);
        Administrator instance = new Administrator("1723709752","fabricio","Masculino",bd);
        String expResult = "FABR237";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     @Test
    public void testGenerateUser10() 
    {
        System.out.println("generateUser10");
        Calendar bd = Calendar.getInstance();
        bd.set(1990, 05, 21);
        Administrator instance = new Administrator("1724488190","andres","Masculino",bd);
        String expResult = "ANDR244";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
     
    @Test
    public void testGenerateUser11() 
    {
        System.out.println("generateUser11");
        Calendar bd = Calendar.getInstance();
        bd.set(1931, 9, 23);
        Administrator instance = new Administrator("1701449934","mercedez","Femenino",bd);
        String expResult = "MERC014";
        String result = instance.generateUser();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    /**
     * Test of generatePassword method, of class Administrator.
     */
    @Test
    public void testGeneratePassword() {
        System.out.println("generatePassword");
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 17);
        Administrator instance = new Administrator("1726134503","sebastian","Masculino",bd);
        String expResult = "Sm172613";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword1() {
        System.out.println("generatePassword1");
        Calendar bd = Calendar.getInstance();
        bd.set(1998,04, 25);
        Administrator instance = new Administrator("1710898345","Mauricio","Masculino",bd);
        String expResult = "Mm171089";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword2() {
        System.out.println("generatePassword2");
        Calendar bd = Calendar.getInstance();
        bd.set(1976, 8, 01);
        Administrator instance = new Administrator("1713704979","Sandra","Femenino",bd);
        String expResult = "Sf171370";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword3() {
        System.out.println("generatePassword3");
        Calendar bd = Calendar.getInstance();
        bd.set(2003, 04, 27);
        Administrator instance = new Administrator("1726348707","Samantha","femenino",bd);
        String expResult = "Sf172634";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword4() {
        System.out.println("generatePassword4");
        Calendar bd = Calendar.getInstance();
         bd.set(1988, 04, 12);
        Administrator instance = new Administrator("1721675385","Daysi","femenino",bd);
        String expResult = "Df172167";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword5() {
        System.out.println("generatePassword5");
        Calendar bd = Calendar.getInstance();
        bd.set(1961, 01, 15);
        Administrator instance = new Administrator("1706918149","monica","femenino",bd);
        String expResult = "Mf170691";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword6() {
        System.out.println("generatePassword6");
        Calendar bd = Calendar.getInstance();
         bd.set(1963, 11, 02);
        Administrator instance = new Administrator("1707814909","anibal","masculino",bd);
        String expResult = "Am170781";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword7() {
        System.out.println("generatePassword7");
        Calendar bd = Calendar.getInstance();
         bd.set(1974, 02, 14);
        Administrator instance = new Administrator("1712439395","silvia","femenino",bd);
        String expResult = "Sf171243";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword8() {
        System.out.println("generatePassword8");
        Calendar bd = Calendar.getInstance();
       bd.set(1997, 05, 20);
        Administrator instance = new Administrator("1723709752","fabricio","Masculino",bd);
        String expResult = "Fm172370";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword9() {
        System.out.println("generatePassword9");
        Calendar bd = Calendar.getInstance();
        bd.set(1990, 05, 21);
        Administrator instance = new Administrator("1724488190","andres","Masculino",bd);
        String expResult = "Am172448";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
    @Test
    public void testGeneratePassword10() {
        System.out.println("generatePassword10");
        Calendar bd = Calendar.getInstance();
        bd.set(1931, 9, 23);
        Administrator instance = new Administrator("1701449934","mercedez","Femenino",bd);
        String expResult = "Mf170144";
        String result = instance.generatePassword();
        assertEquals(expResult, result);
        System.out.println("SUCCESSED");
        
    }
    
   
    
   
    

    /**
     * Test of viewStaff method, of class Administrator.
     */
    @Test
    public void testViewStaff() 
    {
        System.out.println("viewStaff");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 17);
        Administrator instance = new Administrator("1726134503","Sebastian","Masculino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
    @Test
    public void testViewStaff1() 
    {
        System.out.println("viewStaff");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 17);
        Administrator instance = new Administrator("1726134503","Sebastian","Masculino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff2() 
    {
        System.out.println("viewStaff3");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1976, 8, 01);
        Administrator instance = new Administrator("1713704979","Sandra","Femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff3() 
    {
        System.out.println("viewStaff4");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
         bd.set(2003, 04, 27);
        Administrator instance = new Administrator("1726348707","Samantha","femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff4() 
    {
        System.out.println("viewStaff5");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
         bd.set(1988, 04, 12);
        Administrator instance = new Administrator("1721675385","Daysi","femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff5() 
    {
        System.out.println("viewStaff6");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
       bd.set(1961, 01, 15);
        Administrator instance = new Administrator("1706918149","monica","femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff6() 
    {
        System.out.println("viewStaff7");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1963, 11, 02);
        Administrator instance = new Administrator("1707814909","anibal","masculino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff7() 
    {
        System.out.println("viewStaff8");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1974, 02, 14);
        Administrator instance = new Administrator("1712439395","silvia","femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff8() 
    {
        System.out.println("viewStaff9");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1997, 05, 20);
        Administrator instance = new Administrator("1723709752","fabricio","Masculino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff9() 
    {
        System.out.println("viewStaff10");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1990, 05, 21);
        Administrator instance = new Administrator("1724488190","andres","Masculino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
     @Test
    public void testViewStaff10() 
    {
        System.out.println("viewStaff11");
        String fileName = "Employees.txt";
        ArrayList<Employee> employee = new ArrayList<>();
        Calendar bd = Calendar.getInstance();
        bd.set(1931, 9, 23);
        Administrator instance = new Administrator("1701449934","mercedez","Femenino",bd);
        instance.viewStaff(fileName, employee);
        System.out.println("SUCCESSEED");
        
    }
    
    
}
