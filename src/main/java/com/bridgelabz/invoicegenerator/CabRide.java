package com.bridgelabz.invoicegenerator;

public enum CabRide {
    NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

    private final double costPerKm;
    private final double costPerMin;
    private final double minimumFare;

    CabRide(double costPerKm, double costPerMin, double minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minimumFare = minimumFare;
    }

    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(rideCost, minimumFare);
    }
}
