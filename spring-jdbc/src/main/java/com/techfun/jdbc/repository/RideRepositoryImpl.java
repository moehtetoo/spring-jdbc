package com.techfun.jdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import com.techfun.jdbc.connectionhelper.ConnectionHelper;
import com.techfun.jdbc.model.Ride;
@Repository("rideRepository")
public class RideRepositoryImpl implements RideRepository {

	public void createRide(Ride ride) {

		String insertTableSQL = "INSERT INTO ride(name,duration) values(?,?)";

		try (Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL)	){

			preparedStatement.setString(1, ride.getName());
			preparedStatement.setInt(2, ride.getDuration());

			preparedStatement.executeUpdate();
			System.out.println("Record is inserted!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}
	
	public void updateRide(Ride ride) {

		String insertTableSQL = "UPDATE ride SET name = ?,duration = ? "
                + " WHERE id = ?";


		try (Connection dbConnection = ConnectionHelper.getDBConnection();
				PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL)	){

			preparedStatement.setString(1, ride.getName());
			preparedStatement.setInt(2, ride.getDuration());
			preparedStatement.setInt(3, ride.getId());

			preparedStatement.executeUpdate();
			System.out.println("Record is updated successfully!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}
	
	public void deleteRide(Ride ride) {

		String deleteTableSQL = "DELETE from ride WHERE id = ?";


		try (Connection dbConnection = ConnectionHelper.getDBConnection();
			PreparedStatement preparedStatement = dbConnection.prepareStatement(deleteTableSQL)	){

			preparedStatement.setInt(1, ride.getId());

			preparedStatement.executeUpdate();
			System.out.println("Record is deleted successfully!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} 
	}

}
