
package com.bk.taxi24.rider;

import com.bk.taxi24.driver.DriverRepository;
import com.bk.taxi24.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {
    
    @Autowired
    RiderRepository riderRepository;
    
    @Autowired
    DriverRepository driverRepository;
    
    //Get All Riders
    @GetMapping("/riders")
    public List<Rider> retrieveAllRiders(){
        return riderRepository.findAll();
    }
    
    //Get Riders by Id
    @GetMapping("/riders/{id}")
    public Optional<Rider> retrieveOneRider(@PathVariable int id) {
        Optional<Rider> rider = riderRepository.findById(id);
        if(!rider.isPresent()) {
            throw new UserNotFoundException("id-"+id+" Not Found");
        }
        return rider; 
    }
    
    
}
