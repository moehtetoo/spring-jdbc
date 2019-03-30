package com.techfun.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.util.RideRowMapper;

@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createRide(Ride ride) {
		String insertTableSQL = "INSERT INTO ride(name,duration) values(?,?)";
		jdbcTemplate.update(insertTableSQL, ride.getName(), ride.getDuration());
	}
	
	@Override
	public void updateRide(Ride ride) {
		String insertTableSQL = "UPDATE ride SET name = ?,duration = ? "
                + " WHERE id = ?";
		jdbcTemplate.update(insertTableSQL, ride.getName(),ride.getDuration(),ride.getId());
	}
	
	@Override
	public void deleteRide(Ride ride) {
		String deleteTableSQL = "DELETE from ride WHERE id = ?";
		jdbcTemplate.update(deleteTableSQL, ride.getId());
	}

	@Override
	public List<Ride> getAllRide() {
		String selectSQL = "SELECT * FROM RIDE ORDER BY ID";
		return jdbcTemplate.query(selectSQL, new RideRowMapper());
	}
}
