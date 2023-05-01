/**
 * 
 */
package com.shahad.flightservices.repos;




import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shahad.flightservices.entities.Flight;

/**
 * @author Home 
 *
 */
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	@Query("FROM Flight WHERE departureCity = :departureCity AND arrivalCity = :arrivalCity AND dateOfDeparture = :dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);


	
}
