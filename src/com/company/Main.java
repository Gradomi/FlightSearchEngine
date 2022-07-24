package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FlightDatabase database = new FlightDatabase();
        database.checkIfFlightExist("Paris","Madrid");
        database.displayFlightsFromCity("Paris");
        database.displayFlightsToCity("Warszawa");
        ArrayList<String> cities = database.getCities();
        System.out.println(cities);
        Flight cheapestFlight = database.getCheapestFlight();
        System.out.println("Cheapest flight:" + cheapestFlight.getDetails());
    }
}
    class Flight {
    String departure, arrival;
    int price;

    public Flight(String departure, String arrival, int price){
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }
    public String getDetails(){
        return "Flight from" + this.departure + " to " + this.arrival + " " + this.price;
    }
}

    class FlightDatabase {

        ArrayList<Flight> flightList = new ArrayList<Flight>();

    public FlightDatabase(){
        this.flightList.add(new Flight("Berlin","TOkio",200));
        this.flightList.add(new Flight("Berlin","Paris",400));
        this.flightList.add(new Flight("Berlin","Warszawa",50));
        this.flightList.add(new Flight("Berlin","Krakow",90));
        this.flightList.add(new Flight("Berlin","Barcelona",44));
        this.flightList.add(new Flight("Berlin","New York",65));
    }


    public void checkIfFlightExist(String start, String end) {



            for(int i=0; i<this.flightList.size(); i++){
                Flight flight =  this.flightList.get(i);
               if(start.equals(flight.departure) && start.equals(flight.arrival)){
                   System.out.println("Yes exist");
                   return;
               }
               }
             System.out.println("No exist");
    }


            public ArrayList<Flight> getFlightsFromCity(String city){
            ArrayList<Flight> results = new ArrayList<Flight>();
            for(int i=0; i< flightList.size(); i++){
                Flight flight = this.flightList.get(i);
                if(city.equals(flight.departure)) {
                    results.add(flight);
                }
                }
            return results;
            }


            public ArrayList<Flight> getFlightsToCity(String city){
            ArrayList<Flight> results = new ArrayList<Flight>();
            for(int i=0; i< flightList.size(); i++){
                Flight flight = this.flightList.get(i);
                if(city.equals(flight.arrival)) {
                    results.add(flight);
                }
                }
            return results;
                }


            public void displayFlights(ArrayList<Flight> results){
            if(results.isEmpty()) {
                System.out.println("Flight is not found");
            }
            for(int i=0; i<results.size(); i++){
                Flight flight = results.get(i);
                System.out.println(flight.getDetails());
            }

            }
            public void displayFlightsFromCity(String city){
            ArrayList<Flight> results = getFlightsFromCity(city);
            displayFlights(results);
            }
            public void displayFlightsToCity(String city){
            ArrayList<Flight> results = getFlightsToCity(city);
            displayFlights(results);
            }

            public ArrayList<String> getCities(){
            ArrayList<String> cities = new ArrayList<>();
            for(Flight flight : this.flightList){
                if(!cities.contains(flight.departure)) {
                    cities.add(flight.departure);
                }
                if(!cities.contains(flight.arrival)){
                    cities.add(flight.arrival);
                }
            }
            return cities;
            }
            public Flight getCheapestFlight(){
            Flight cheapestFlight = null;
            for(Flight flight : flightList){
                if(cheapestFlight == null || flight.price <cheapestFlight.price) {
                    cheapestFlight = flight;
                }
            }
            return cheapestFlight;
            }
            public Flight getCheapestFlightFromCity(String city){
            ArrayList<Flight> fromCity = getFlightsFromCity(city);
            Flight cheapestFlight = null;
            for(Flight flight : fromCity){
                if(cheapestFlight == null || flight.price < cheapestFlight.price){
                    cheapestFlight = flight;
                }
            }
            return cheapestFlight;

            }
            }



