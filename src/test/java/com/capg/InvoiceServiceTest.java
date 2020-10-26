package com.capg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	InvoiceGenerator invoiceGenerator;
	InvoiceService invoiceService;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceTimeReturnFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceTimeReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		Invoice invoice = new Invoice();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.NORMAL), new Ride(0.1, 1, Ride.RideType.NORMAL) };
		InvoiceSummary summary = invoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
		String userId="a@b.com";
		RideRepository rideRepository = new RideRepository();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.NORMAL), new Ride(0.1, 1, Ride.RideType.PREMIUM) };
		rideRepository.addRides(userId, rides);
		Ride[] userRides = rideRepository.getRides(userId);
		Assert.assertEquals(rides[1], userRides[1]);
	}
	
	@Test
	public void givenMultipleTypeRideReturnInvoiceSummary() {
		Invoice invoice = new Invoice();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.PREMIUM), new Ride(0.1, 1, Ride.RideType.NORMAL) };
		InvoiceSummary summary = invoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
}
