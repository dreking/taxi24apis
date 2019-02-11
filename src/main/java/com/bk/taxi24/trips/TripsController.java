
package com.bk.taxi24.trips;

import com.bk.taxi24.driver.Driver;
import com.bk.taxi24.driver.DriverRepository;
import com.bk.taxi24.exception.UserNotFoundException;
import com.bk.taxi24.invoice.Invoice;
import com.bk.taxi24.rider.Rider;
import com.bk.taxi24.rider.RiderRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TripsController {
    
    @Autowired
    TripsRepository tripRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    RiderRepository riderRepository;    
    
    //Get All Active Trips
    @GetMapping("/trips/active/{status}")
    public List<Trips> retrieveAllActiveTrips(@PathVariable String status){
        return tripRepository.findByStatusContaining(status);
    }
    
    //Complete an active trip and sends invoice
    @GetMapping("/trips/{id}/{status}")
    public String CompleteTrip(@PathVariable int id, @PathVariable String status) {
        Optional<Trips> t = tripRepository.findByIdAndStatusContaining(id,status);
        if(!t.isPresent()){
            throw new UserNotFoundException("Trip id: "+id+" Not Found");
        }
        Trips trip = t.get();
        trip.setStatus("complete");
        
        tripRepository.save(trip);
        Invoice invoice = new Invoice("Invoice From Taxi24",
                                trip.getDriver().getName(),
                                trip.getRider().getName(),
                                trip.getPrice());
        return invoice.toString();
    } 
    
    //Add a new trip
    @PostMapping("/trips/{rider_id}/{driver_id}/create")
    public ResponseEntity AddNewTrip(@PathVariable int rider_id, @PathVariable int driver_id, @RequestBody Trips trip){
        Optional<Driver> driverOptional= driverRepository.findById(driver_id);
        if(!driverOptional.isPresent()){
            throw new UserNotFoundException("id-"+driver_id+" Not Found");
        }
        Driver driver = driverOptional.get();
        
        Optional<Rider> riderOptional= riderRepository.findById(rider_id);
        if(!driverOptional.isPresent()){
            throw new UserNotFoundException("id-"+rider_id+" Not Found");
        }
        Rider rider = riderOptional.get();
        
        trip.setDriver(driver);
        trip.setRider(rider);
        
        tripRepository.save(trip);
        //return created status
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(trip.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
