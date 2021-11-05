package com.bridgelabz.invoicegenerator;

/**
 * Invoice Generator class
 */
public class InvoiceGenerator {

    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;

    /**
     * @param distance-> Getting distance from testcase
     * @param time->     Getting distance from testcase
     * @return-> Returns the total fare
     */
    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
    }
}
