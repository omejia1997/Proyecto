/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministrationprj.model;

import java.util.Calendar;

import ec.espe.edu.solfadministration.Files.util.Date;
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author Omar Mejia
 */
public class Employee extends Person
{
    private String userName;
    private String password;
    
    public Employee(String id, String name, String gender, Calendar birthDate,String userName,String password) {
        super(id, name, gender, birthDate);
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
    }
    public Employee(String id, String name, String gender, Date birthDate2,String userName,String password) {
		// TODO Auto-generated constructor stub
    	 super(id, name, gender, birthDate2);
        this.userName = userName;
        this.password = password;
        this.birthDate2 = birthDate2;
	}
    @Override
	public String toString() {
    	String line;
		line=getId()+","+getName()+","+getGender()+","+getBirthDate().YEAR;
		return line;
    	
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    
    

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }
    
    
    @Override
    public String generateUser()
    {
        String aux = "";
        String aux2="";
        for(int i=0; i<4; i++)
        {
            aux = aux + name.charAt(i);
        }
        for(int j=2; j<5;j++)
        {
            aux2 = aux2 + id.charAt(j);
        }
        userName = aux.toUpperCase()+aux2;
        return userName;
    }

    @Override
    public String generatePassword()
    {
        String aux="";
        String aux1="";
        aux1 = aux1 + name.charAt(0);
        
        for(int i=0;i<6;i++)
        {
            aux = aux+id.charAt(i);
        }
        password = aux1.toUpperCase()+gender.toLowerCase().charAt(0)+aux;
        return password;
    }

  
   

}
