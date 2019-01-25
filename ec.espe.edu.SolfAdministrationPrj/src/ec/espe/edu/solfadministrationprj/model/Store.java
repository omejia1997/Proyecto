/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.espe.edu.solfadministrationprj.model;

/**
 *
 * @author SAOM
 */
public class Store
{
    private String name;
    private String location;

    /**
     * @return the storeName
     */
    public String getStoreName() {
        return name;
    }

    /**
     * @param storeName the storeName to set
     */
    public void setStoreName(String storeName) {
        this.name = storeName;
    }

    /**
     * @return the storeLocation
     */
    public String getStoreLocation() {
        return location;
    }

    /**
     * @param storeLocation the storeLocation to set
     */
    public void setStoreLocation(String storeLocation) {
        this.location = storeLocation;
    }

    
    public Store() 
    {
        name = "";
        location = "";
    }
    
    
}
