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
        flight.setCreatedAt(rs.getTimestamp("createdAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        flight.setDelayStartedAt(rs.getTimestamp("delayStartedAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        flight.setDepartureCountry(rs.getString("departureCountry"));
        flight.setDistance(rs.getInt("distance"));
        flight.setDestinationCountry(rs.getString("DestinationCountry"));
        flight.setEndedAt(rs.getTimestamp("endedAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        flight.setEstimatedFlightTime(rs.getInt("EstimatedFlightTime"));
        flight.setStartedAt(rs.getTimestamp("startedAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return flight;
    }
}
