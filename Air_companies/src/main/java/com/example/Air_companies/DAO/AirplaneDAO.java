package com.example.Air_companies.DAO;

import com.example.Air_companies.models.Airplane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AirplaneDAO {

    private final JdbcTemplate jdbcTemplate;

    public AirplaneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void moveBetweenCompanies(int idAirplane,int idAirCompany){
        jdbcTemplate.update("UPDATE airplane SET airCompanyId=? where id=?",idAirCompany,idAirplane);
    }

    public void createNewAirplane(Airplane airplane){
        jdbcTemplate.update(
                "INSERT into airplane (name,factorySerialNumber,airCompanyId," +
                        "numberOfFlights,flightDistance,fuelCapacity,type,createdAt)" +
                        "values (?,?,?,?,?,?,?,?)",airplane.getName(),
                airplane.getFactorySerialNumber(),airplane.getAirCompanyId(),
                airplane.getNumberOfFlights(),airplane.getFlightDistance(),
                airplane.getFuelCapacity(),airplane.getType(),airplane.getCreatedAt());
    }


}
