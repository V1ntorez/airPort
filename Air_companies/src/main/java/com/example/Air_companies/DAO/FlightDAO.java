package com.example.Air_companies.DAO;

import com.example.Air_companies.models.AirCompany;
import com.example.Air_companies.models.Flight;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class FlightDAO {

    private final JdbcTemplate jdbcTemplate;

    public FlightDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flight> getAllFlightsByStatus(String nameCompany, Flight.flightStatus status){
        AirCompany idCompany = jdbcTemplate.query("Select * from airCompany where name=? ",new AirCompanyMapper(),nameCompany)
                .stream().findAny().orElse(null);
        return jdbcTemplate.query("Select * from flight where airCompanyId=? and flightStatus=?",new FlightMapper(),idCompany.getID(),status.name());
    }

    public List<Flight> getAllFlightsInActiveAndStarted24HourAgo(){
        List<Flight> flights = jdbcTemplate.query("SELECT * from flight where flightStatus=?",new FlightMapper(),
                Flight.flightStatus.ACTIVE.name());
        for (int i=0;i<flights.size()-1;i++){
            if (LocalDate.now().minusDays(1).isBefore(flights.get(i).getStartedAt()))
                flights.remove(i);
        }
    return flights;
    }

    public void createNewFlight(Flight flight){
        jdbcTemplate.update(
                "INSERT into flight (flightstatus, aircompanyid, airplaneid, distance, estimatedflighttime ," +
                        "endedat,delaystartedat,createdat,departurecountry,destinationcountry,startedat) " +
                        "values (?,?,?,?,?,?,?,?,?,?,?)",Flight.flightStatus.PENDING.name(),flight.getAirCompanyID(),
                flight.getAirplaneID(),flight.getDistance(),flight.getEstimatedFlightTime(),
                flight.getEndedAt(),flight.getDelayStartedAt(),
                flight.getCreatedAt(),flight.getDepartureCountry(),flight.getDestinationCountry(),
                flight.getStartedAt());
    }

    public void changeFlightStatus(int IdFlight ,Flight.flightStatus status){
        if (status==Flight.flightStatus.ACTIVE) {
              jdbcTemplate.update("UPDATE flight SET flightStatus=? , startedAt=? where id=?",
                      status.name(),LocalDate.now() ,IdFlight);
        }
        else if (status==Flight.flightStatus.DELAYED){
            jdbcTemplate.update("UPDATE flight SET flightStatus=? , delayStartedAt=? where id=?",
                    status.name(), LocalDate.now() ,IdFlight);
        }
        else if (status==Flight.flightStatus.COMPLETED){
            jdbcTemplate.update("UPDATE flight SET flightStatus=? , endedAt=? where id=?",
                    status.name(), LocalDate.now() ,IdFlight);
        }
    }

    public List<Flight> findAllFlightsInCompletedAndDifferentBetweenTime(){
        return jdbcTemplate.query("SELECT * from flight where flightStatus=?",new FlightMapper(),
                        Flight.flightStatus.COMPLETED.name());
    }

}
