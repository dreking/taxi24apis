
package com.bk.taxi24.trips;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {
    
    public List<Trips> findByStatusContaining(String status);

    public Optional<Trips> findByIdAndStatusContaining(int id, String status);
    
}
