package com.example.Air_companies.DAO;

import com.example.Air_companies.models.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FlightMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flight flight = new Flight();
        flight.setID(rs.getInt("id"));
        flight.setAirCompanyID(rs.getInt("AirCompanyID"));
        flight.setAirplaneID(rs.getInt("AirplaneID"));
        flight.setCreatedAt(rs.getDate("createdAt").toLocalDate());
        flight.setDelayStartedAt(rs.getDate("delayStartedAt").toLocalDate());
        flight.setDepartureCountry(rs.getString("departureCountry"));
        flight.setDistance(rs.getInt("distance"));
        flight.setDestinationCountry(rs.getString("DestinationCountry"));
        flight.setEndedAt(rs.getDate("endedAt").toLocalDate());
        flight.setEstimatedFlightTime(rs.getInt("EstimatedFlightTime"));
        flight.setStartedAt(rs.getDate("startedAt").toLocalDate());
        return flight;
    }
}
