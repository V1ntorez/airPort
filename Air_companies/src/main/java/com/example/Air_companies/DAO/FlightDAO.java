package com.example.Air_companies.DAO;

import com.example.Air_companies.models.AirCompany;
import com.example.Air_companies.models.Flight;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FlightDAO {

    private final JdbcTemplate jdbcTemplate;

    public FlightDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flight> getAllFlightsByStatus(String nameCompany, Flight.flightStatus status){
        AirCompany idCompany = jdbcTemplate.query("Select id from airCompany where name=? limit 1",new AirCompanyMapper(),nameCompany)
                .stream().findAny().orElse(null);
        return jdbcTemplate.query("Select * from flight where airCompanyId=?,flightStatus=?",new FlightMapper(),idCompany.getID(),status.name());
    }

    public List<Flight> getAllFlightsInActiveAndStarted24HourAgo(){
        List<Flight> flights = jdbcTemplate.query("SELECT * from flight where flightStatus=?",new FlightMapper(),
                Flight.flightStatus.ACTIVE.name());
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.plusHours(24);
        for (Flight flight: flights){
            if(flight.getEndedAt().isBefore(localDateTime)){
                flights.remove(flight);
            }
        }
    return flights;
    }

    public void createNewFlight(Flight flight){
        jdbcTemplate.update(
                "INSERT into flight (flightStatus,airCompanyId,airplaneId,distance," +
                        "estimatedFlightTime,endedAt,delayStartedAt,createdAt,departureCountry," +
                        "destinationCountry,startedAt) " +
                        "values (?,?,?,?,?,?,?,?,?,?,?)",Flight.flightStatus.PENDING.name(),flight.getAirCompanyID(),
                flight.getAirplaneID(),flight.getDistance(),flight.getEstimatedFlightTime(),
                flight.getEndedAt(),flight.getDelayStartedAt(),LocalDateTime.now(),
                flight.getDepartureCountry(),flight.getDestinationCountry(),flight.getStartedAt());
    }

    public void changeFlightStatus(int IdFlight ,Flight.flightStatus status){
        if (status==Flight.flightStatus.ACTIVE) {
              jdbcTemplate.update("UPDATE flight SET flightStatus=?,startedAt where id=?",
                      status.name(),LocalDateTime.now() ,IdFlight);
        }
        else if (status==Flight.flightStatus.DELAYED){
            jdbcTemplate.update("UPDATE flight SET flightStatus=?,delayStartedAt=? where id=?",
                    status.name(), LocalDateTime.now() ,IdFlight);
        }
        else if (status== Flight.flightStatus.COMPLETED){
            jdbcTemplate.update("UPDATE flight SET flightStatus=?,endedAt=? where id=?",
                    status.name(), LocalDateTime.now() ,IdFlight);
        }
    }

    public List<Flight> findAllFlightsInCompletedAndDifferentBetweenTime(){
        return jdbcTemplate.query("SELECT * from flight where flightStatus=?",new FlightMapper(),
                        Flight.flightStatus.COMPLETED.name());
    }

}
