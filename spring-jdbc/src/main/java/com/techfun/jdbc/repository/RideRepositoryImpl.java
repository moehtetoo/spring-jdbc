package com.techfun.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.techfun.jdbc.model.Ride;
@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void createRide(Ride ride) {
		String insertTableSQL = "INSERT INTO ride(name,duration) values(?,?)";
		jdbcTemplate.update(insertTableSQL, ride.getName(), ride.getDuration());
	}
	
	public void updateRide(Ride ride) {

		String insertTableSQL = "UPDATE ride SET name = ?,duration = ? "
                + " WHERE id = ?";
		jdbcTemplate.update(insertTableSQL, ride.getName(),ride.getDuration(),ride.getId());
	}
	
	public void deleteRide(Ride ride) {

		String deleteTableSQL = "DELETE from ride WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, ride.getId());
	}

}
