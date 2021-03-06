package com.bridgelabz.invoicegenerator;

/**
 * Invoice Generator class
 */
public class InvoiceService {

    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private RideRepository rideRepository;

    /**
     * @param distance-> Getting distance from testcase
     * @param time->     Getting distance from testcase
     * @return-> Returns the total fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    /**
     * @param rides ->Array and for each loop used
     * @return -> total Fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calculateCostOfRide(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public void  setRideRepository(RideRepository rideRepository){
        this.rideRepository = new RideRepository();
    }
}