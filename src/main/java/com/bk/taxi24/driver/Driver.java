package com.bk.taxi24.driver;

import com.bk.taxi24.trips.Trips;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    int id;
    String name;
    String status;
    String location;
    
    @OneToMany(mappedBy="driver")
    @JsonIgnore
    private List<Trips> trips;
    
    public Driver() {
    }

    public Driver(int id, String name, String status, String location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" + "id=" + id + ", name=" + name + ", status=" + status + ", location=" + location + ", trips=" + trips + '}';
    }
    
}
