/**
 * 
 */
package com.shahad.flightservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shahad.flightservices.entities.Reservation;

/**
 * @author Home
 *
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
