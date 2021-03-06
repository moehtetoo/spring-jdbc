package com.techfun.jdbc.application;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techfun.jdbc.model.Ride;
import com.techfun.jdbc.service.RideService;

public class RideMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		RideService rideService = (RideService) ctx.getBean("rideService");
		Ride ride = new Ride();
//		testCreateRide(ride, rideService);
//		testUpdateRide(ride,rideService);
//		testDeleteRide(ride, rideService);	
		testGetAllEmployee(rideService);
	}
	
	private static void testCreateRide(Ride ride,RideService rideService) {
		ride.setName("Phyo Paing");
		ride.setDuration(15);
		rideService.createRide(ride);
		System.out.println("Process Successful completed!");
	}
	
	private static void testUpdateRide(Ride ride,RideService rideService) {
		ride.setName("Moe Htet Oo");
		ride.setDuration(11);
		ride.setId(1);
		rideService.updateRide(ride);
		System.out.println("Process Successful completed!");
	}
	
	private static void testDeleteRide(Ride ride, RideService rideService) {
		ride.setId(5);
		rideService.deleteRide(ride);
		System.out.println("Process Successful completed!");
	}
	
	private static void testGetAllEmployee(RideService rideService) {
		List<Ride> rideList = rideService.getAllRide();
		rideList.forEach(ride -> System.out.println("Ride Id : "+ride.getId()+" Ride Name : "+ride.getName()
									+" Ride Duration : "+ride.getDuration()));
	}
}
