
package com.bk.taxi24.rider;

import com.bk.taxi24.trips.Trips;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rider {
    @Id
    @GeneratedValue
    int id;
    String name;
    String location;
    
    @OneToMany(mappedBy="rider")
    @JsonIgnore
    private List<Trips> trips;

    public Rider() {
    }

    public Rider(int id, String name, String location) {
        this.id = id;
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Rider{" + "id=" + id + ", name=" + name + ", location=" + location + '}';
    }
    
    
}
