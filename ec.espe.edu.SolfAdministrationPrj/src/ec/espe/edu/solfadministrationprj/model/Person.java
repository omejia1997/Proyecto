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
 * @author SAOM
 */
public abstract class Person
{
    protected String id;
    protected String name; 
    protected String gender;
    protected Calendar birthDate;
    protected Date birthDate2;
    
    public Date getBirthDate2() {
		return birthDate2;
	}

	public void setBirthDate2(Date birthDate2) {
		this.birthDate2 = birthDate2;
	}

	/**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Person(String id, String name, String gender, Calendar birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }




 

	public Person(String id2, String name2, String gender2, ec.espe.edu.solfadministration.Files.util.Date birthDate2) {
		// TODO Auto-generated constructor stub
	}

	/**
     * This method should generate an user for the system
     * @return
     */
    public abstract String generateUser();
    /**
     * This method should generate an password of an user for the system
     * @return
     */
    public abstract String generatePassword();
    
   
   

    
    

    
    
}
