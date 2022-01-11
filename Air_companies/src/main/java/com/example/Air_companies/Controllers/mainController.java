package com.example.Air_companies.Controllers;

import com.example.Air_companies.DAO.AirCompanyDAO;
import com.example.Air_companies.DAO.AirplaneDAO;
import com.example.Air_companies.DAO.FlightDAO;
import com.example.Air_companies.models.AirCompany;
import com.example.Air_companies.models.Airplane;
import com.example.Air_companies.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@Controller
@RequestMapping ("airport")
public class mainController {

    private AirCompanyDAO airCompanyDAO;
    private AirplaneDAO airplaneDAO;
    private FlightDAO flightDAO;

    @Autowired
    public mainController(AirCompanyDAO airCompanyDAO, AirplaneDAO airplaneDAO, FlightDAO flightDAO) {
        this.airCompanyDAO = airCompanyDAO;
        this.airplaneDAO = airplaneDAO;
        this.flightDAO = flightDAO;
    }

public Flight.flightStatus statusRes (int status){
    Flight.flightStatus statusRes = Flight.flightStatus.PENDING;
    if (status == 1)
        statusRes= Flight.flightStatus.ACTIVE;
    else if (status == 2)
        statusRes= Flight.flightStatus.COMPLETED;
    else if (status == 3)
        statusRes= Flight.flightStatus.DELAYED;
    else if (status==4)
        statusRes= Flight.flightStatus.PENDING;
    return statusRes;
}
    //  AirCompany //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //good
    @GetMapping("air-companies/{id}")
    public String getAirCompany(@PathVariable int id, Model model){
        model.addAttribute("airCompany", airCompanyDAO.getAirCompany(id));
        return "airport/air-company";
    }
    //good
    @GetMapping("air-companies")
    public String getAllAirCompanies(Model model){
        model.addAttribute("airCompanies", airCompanyDAO.getAllAirCompanies());
        return "airport/air-companies";
    }
    //good
    @GetMapping("/new-air-company")
    public String createNewAirCompany(Model model){
        model.addAttribute("airCompany",new AirCompany());
        return "airport/new-air-company";
    }
    //good
    @PostMapping("/new-air-company")
    public String saveInDbNewAirCompany(@ModelAttribute("airCompany") AirCompany airCompany){
        airCompanyDAO.createNewAirCompany(airCompany);
        return "redirect:/airport/air-companies";
    }
    //good
    @GetMapping("edit-air-company/{id}")
    public String editAirCompany(Model model,@PathVariable("id") int id){
        model.addAttribute("airCompany",airCompanyDAO.getAirCompany(id));
        return "airport/edit-air-company";
    }
    //good
    @PatchMapping("edit-air-company/{id}")
    public String updateInDbAirCompany(@ModelAttribute("airCompany") AirCompany airCompany, @PathVariable int id){
        airCompanyDAO.updateAirCompany(airCompany,id);
        return "redirect:/airport/air-companies";
    }
    //good
    @DeleteMapping("delete-air-company/{id}")
    public String deleteAirCompany(@PathVariable int id){
        airCompanyDAO.deleteAirCompany(id);
        return "redirect:/airport/air-companies";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    // AirPlane //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //good
    @GetMapping("air-plane-move-between-company/{idAirPlane}/{idAirCompany}")
    public String moveBetweenCompanies(@PathVariable("idAirCompany") int idAirCompany,
                                           @PathVariable("idAirPlane") int idAirPlane){
        airplaneDAO.moveBetweenCompanies(idAirPlane,idAirCompany);
        return "redirect:/airport/air-companies";
    }
    //good
    @GetMapping("new-air-plane")
    public String createNewAirplane(Model model){
        model.addAttribute("airPlane", new Airplane());
        return "airport/new-air-plane";
    }
    //good
    @PostMapping("new-air-plane")
    public String saveNewAirplaneInBd(@ModelAttribute("airPlane") Airplane airplane){
        airplaneDAO.createNewAirplane(airplane);
        return "redirect:/airport/air-companies";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Flight //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    //good
    @GetMapping("get-all-flight-by-status-and-name-company/{status}/{name}")
    public String getAllFlightsByStatus(Model model, @PathVariable int status, @PathVariable String name){
        model.addAttribute("flights", flightDAO.getAllFlightsByStatus(name,statusRes(status)));
        return "airport/flights";
    }
    //bad
    @GetMapping("get-all-flight-in-active-and-started-24-hour-ago")
    public String getAllFlightsInActiveAndStarted24HourAgo(Model model){
        model.addAttribute("flights",flightDAO.getAllFlightsInActiveAndStarted24HourAgo());
        return "airport/flights";
    }
    //good
    @GetMapping("new-flight")
    public String createNewFlight(Model model){
        model.addAttribute("flight",new Flight());
        return "airport/new-flight";
    }
    //good
    @PostMapping("new-flight")
    public String createNewFlightInBd(@ModelAttribute("flight") Flight flight){
        flightDAO.createNewFlight(flight);
        return "redirect:/airport/menu";
    }
    //good
    @GetMapping("change-flight-status/{idFlight}/{status}")
    public String changeFlightStatus(@PathVariable("idFlight") int idFlight, @PathVariable("status") int status){
        flightDAO.changeFlightStatus(idFlight,statusRes(status));
        return "airport/menu";
    }
    // не пробував :)
    @GetMapping("find-all-flights-in-completed-and-different-between-time")
    public String findAllFlightsInCompletedAndDifferentBetweenTime(Model model){
        model.addAttribute("flights", flightDAO.findAllFlightsInCompletedAndDifferentBetweenTime());
        List<Long> differentBetweenTime = null;
        for (Flight flight : flightDAO.findAllFlightsInCompletedAndDifferentBetweenTime()){
            differentBetweenTime.add(Duration.between(flight.getStartedAt(),flight.getEndedAt()).toHours());
        }
        model.addAttribute("different-between-time", differentBetweenTime);
        return "airport/different-between-time";
    }
}
