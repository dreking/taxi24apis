
package com.bk.taxi24.invoice;

public class Invoice {
    String name;
    String driver_id;
    String rider_id;
    double price;
    
    public Invoice(String name, String driver_id, String rider_id, double price) {
        this.name = name;
        this.driver_id = driver_id;
        this.rider_id = rider_id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Invoice{" + "name=" + name + ", driver_id=" + driver_id + ", rider_id=" + rider_id + ", price=" + price + '}';
    }
    
    
}
