
package com.bk.taxi24.trips;

import com.bk.taxi24.driver.Driver;
import com.bk.taxi24.rider.Rider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trips {
    @Id
    @GeneratedValue
    int id;
    String status;
    Double price;
    String start_point;
    String end_point;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Driver driver;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Rider rider;

    public Trips() {
    }

    public Trips(int id, String status, Double price, String start_point, String end_point) {
        this.id = id;
        this.status = status;
        this.price = price;
        this.start_point = start_point;
        this.end_point = end_point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
    
    @Override
    public String toString() {
        return "Trips{" + "id=" + id + ", status=" + status + ", price=" + price + ", start_point=" + start_point + ", end_point=" + end_point + '}';
    }
       
}
