
package com.bk.taxi24.driver;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    public List<Driver> findByStatusContaining(String status);

    public List<Driver> findTop3ByLocationGreaterThanEqualOrLocationLessThanEqualAndStatusContaining(String location1,String location2, String status);
    
}

