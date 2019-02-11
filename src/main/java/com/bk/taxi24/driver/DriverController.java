
package com.bk.taxi24.driver;

import com.bk.taxi24.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {
    @Autowired
    DriverRepository driverRepository;
    
    //Get All Drivers
    @GetMapping("/drivers")
    public List<Driver> retrieveAllDrivers(){
        return driverRepository.findAll();
    }
    
    //Get Driver by ID
    @GetMapping("drivers/{id}")
    public Optional<Driver> retrieveOneDriver(@PathVariable int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if(!driver.isPresent()){
            throw new UserNotFoundException("id-"+id+" Not Found");
        }
        return driver;
    }
    
    //Get Available Drivers
    @GetMapping("drivers/status/{status}")
    public List<Driver> retrieveAvailableDrivers(@PathVariable String status) {
        return driverRepository.findByStatusContaining(status);
    }
    
    //Get Available drivers for a rider
    @GetMapping("drivers/near/{location}")
    public List<Driver> retrieveNearByDrivers(@PathVariable String location) {
        String status = "available";
        return driverRepository.findTop3ByLocationGreaterThanEqualOrLocationLessThanEqualAndStatusContaining(location,location,status);
    }
} 
