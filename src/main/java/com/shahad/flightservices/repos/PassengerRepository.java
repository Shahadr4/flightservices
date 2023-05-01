/**
 * 
 */
package com.shahad.flightservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shahad.flightservices.entities.Passenger;



/**
 * @author Home
 *
 */
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {


}
