package com.example.Air_companies.models;

import org.springframework.stereotype.Component;
import javax.persistence.*;

import java.time.LocalDateTime;

@Component
public class Flight {
    private int ID;
    public enum flightStatus{ACTIVE, COMPLETED, DELAYED, PENDING}
    private int AirCompanyID;
    private int airplaneID;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
    private LocalDateTime startedAt;

   @Enumerated(EnumType.STRING)
   flightStatus flightStatus;

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public Flight.flightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(Flight.flightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAirCompanyID() {
        return AirCompanyID;
    }

    public void setAirCompanyID(int airCompanyID) {
        AirCompanyID = airCompanyID;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(int estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
