package com.example.Air_companies.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate endedAt;
        @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate delayStartedAt;
       @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
      @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate startedAt;



   @Enumerated(EnumType.STRING)
   flightStatus flightStatus;


    @Override
    public String toString() {
        return "Flight{" +
                "ID=" + ID +
                ", AirCompanyID=" + AirCompanyID +
                ", airplaneID=" + airplaneID +
                ", departureCountry='" + departureCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", distance=" + distance +
                ", estimatedFlightTime=" + estimatedFlightTime +
                ", endedAt=" + endedAt +
                ", delayStartedAt=" + delayStartedAt +
                ", createdAt=" + createdAt +
                ", startedAt=" + startedAt +
                ", flightStatus=" + flightStatus +
                '}';
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

    public LocalDate getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDate endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDate getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDate delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }
}
