package com.example.Air_companies.models;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Airplane {
    private int ID;
    private String name;
    private String factorySerialNumber;
    private String airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private LocalDate createdAt;

    public Airplane() {}

    public Airplane(String name, String factorySerialNumber, int numberOfFlights,
                    int flightDistance, int fuelCapacity, String type, LocalDate createdAt) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Airplane(String name, String factorySerialNumber, String airCompanyId,
                    int numberOfFlights, int flightDistance, int fuelCapacity,
                    String type, LocalDate createdAt) {
        this.name = name;
        this.factorySerialNumber = factorySerialNumber;
        this.airCompanyId = airCompanyId;
        this.numberOfFlights = numberOfFlights;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = createdAt;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public String getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(String airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getNumberOfFlights() {
        return numberOfFlights;
    }

    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
