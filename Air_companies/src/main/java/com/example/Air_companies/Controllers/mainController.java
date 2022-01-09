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

    //  AirCompany //
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("air-companies/{id}")
    public String getAirCompany(@PathVariable int id, Model model){
        model.addAttribute("air-company", airCompanyDAO.getAirCompany(id));
        return "airport/air-companies";
    }

    @GetMapping("air-companies")
    public String getAllAirCompanies(Model model){
        model.addAttribute("air-companies", airCompanyDAO.getAllAirCompanies());
        return "airport/air-companies";
    }

    @GetMapping("new-air-company")
    public String createNewAirCompany(Model model){
        model.addAttribute("air-company",new AirCompany());
        return "airport/new-air-company";
    }
//
    @PostMapping("new-air-company")
    public String saveInDbNewAirCompany(@ModelAttribute("air-company") AirCompany airCompany){
        airCompanyDAO.createNewAirCompany(airCompany);
        return "redirect:/airport";
    }

    @GetMapping("/edit-air-company/{id}")
    public String editAirCompany(Model model,@PathVariable("id") int id){
        model.addAttribute("air-company",airCompanyDAO.getAirCompany(id));
        return "airport/edit-air-company";
    }

    @PatchMapping("/{id}")
    public String updateInDbAirCompany(@ModelAttribute("air-company") AirCompany airCompany, @PathVariable int id){
        airCompanyDAO.updateAirCompany(airCompany,id);
        return "redirect:/airport";
    }

    @DeleteMapping("/{id}")
    public String deleteAirCompany(@PathVariable int id){
        airCompanyDAO.deleteAirCompany(id);
        return "redirect:/airport";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    // AirPlane //
/////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PatchMapping("air-plane_move_between_company/{idAirPlane}/{idAirCompany}")
    public String moveBetweenCompanies(@PathVariable("idAirCompany") int idAirCompany,
                                           @PathVariable("idAirPlane") int idAirPlane){
        airplaneDAO.moveBetweenCompanies(idAirPlane,idAirCompany);
        return "redirect:/airport";
    }

    @GetMapping("new-air-plane")
    public String createNewAirplane(Model model){
        model.addAttribute("air-plane", new Airplane());
        return "airport/new-air-plane";
    }
//
    @PostMapping("new-air-plane")
    public String saveNewAirplaneInBd(@ModelAttribute("air-plane") Airplane airplane){
        airplaneDAO.createNewAirplane(airplane);
        return "redirect:/airport";
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Flight //
/////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("get-all-flight-by-status-and-name-company/{status}/{name}")
    public String getAllFlightsByStatus(Model model, @PathVariable Flight.flightStatus status, @PathVariable String name){
        model.addAttribute("flights", flightDAO.getAllFlightsByStatus(name,status));
        return "airport/flights";
    }

    @GetMapping("get-all-flight-in-active-and-started-24-hour-ago")
    public String getAllFlightsInActiveAndStarted24HourAgo(Model model){
        model.addAttribute("flights",flightDAO.getAllFlightsInActiveAndStarted24HourAgo());
        return "airport/flights";
    }

    @GetMapping("new-flight")
    public String createNewFlight(Model model){
        model.addAttribute("flight",new Flight());
        return "airport/new-flight";
    }

    @PostMapping("new-flight")
    public String createNewFlightInBd(@ModelAttribute("flight") Flight flight){
        flightDAO.createNewFlight(flight);
        return "airport/flights";
    }

    @PatchMapping("change-flight-status/{idFlight}/{status}")
    public String changeFlightStatus(@PathVariable("idFlight") int idFlight, @PathVariable("status") Flight.flightStatus status){
        flightDAO.changeFlightStatus(idFlight,status);
        return "airport/flights";
    }

    @GetMapping("find-all-flights-in-completed-and-different-between-time")
    public String findAllFlightsInCompletedAndDifferentBetweenTime(Model model){
        model.addAttribute("flights", flightDAO.findAllFlightsInCompletedAndDifferentBetweenTime());
        List<Long> differentBetweenTime = null;
        for (Flight flight : flightDAO.findAllFlightsInCompletedAndDifferentBetweenTime()){
            differentBetweenTime.add(Duration.between(flight.getStartedAt(),flight.getEndedAt()).toHours());
        }
        model.addAttribute("different-between-time", differentBetweenTime);
        return "airport/flights";
    }
}
