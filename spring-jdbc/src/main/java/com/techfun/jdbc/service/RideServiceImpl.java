package com.techfun.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.repository.RideRepositoryImpl;
@Service("rideService")
public class RideServiceImpl implements RideService {
	
	@Autowired
	private RideRepositoryImpl rideRepositoryImpl;
	
	@Override
	public void createRide(Ride ride) {
		rideRepositoryImpl.createRide(ride);
	}
	
	@Override
	public void updateRide(Ride ride) {
		rideRepositoryImpl.updateRide(ride);
	}
	
	@Override
	public void deleteRide(Ride ride) {
		rideRepositoryImpl.deleteRide(ride);
	}

	@Override
	public List<Ride> getAllRide() {
		return rideRepositoryImpl.getAllRide();
	}
}
