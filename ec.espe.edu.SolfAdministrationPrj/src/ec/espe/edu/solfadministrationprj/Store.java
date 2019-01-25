
package ec.espe.edu.solfadministrationprj;

public class Store {
    private String storeName;
    private String Location;

    public Store(String storeName, String Location) {
        this.storeName = storeName;
        this.Location = Location;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
}
