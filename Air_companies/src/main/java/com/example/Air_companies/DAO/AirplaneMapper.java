package com.example.Air_companies.DAO;

import com.example.Air_companies.models.Airplane;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class AirplaneMapper implements RowMapper<Airplane> {
    @Override
    public Airplane mapRow(ResultSet rs, int rowNum) throws SQLException {
        Airplane airplane = new Airplane();

        airplane.setID(rs.getInt("id"));
        airplane.setAirCompanyId(rs.getString("airCompanyId"));
        airplane.setCreatedAt(rs.getDate("createdAt").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        airplane.setFlightDistance(rs.getInt("flightDistance"));
        airplane.setFactorySerialNumber(rs.getString("factorySerialNumber"));
        airplane.setFuelCapacity(rs.getInt("fuelCapacity"));
        airplane.setName(rs.getString("name"));
        airplane.setType(rs.getString("type"));
        airplane.setNumberOfFlights(rs.getInt("numberOfFlights"));

        return airplane;
    }
}
