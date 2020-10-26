package com.capg;

public class InvoiceSummary {
	private int noOfRides;
	private double totalFare;
	private double avgFare;

	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.avgFare = this.totalFare / this.noOfRides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + noOfRides;
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		InvoiceSummary other = (InvoiceSummary) obj;
//		if (Double.doubleToLongBits(avgFare) != Double.doubleToLongBits(other.avgFare))
//			return false;
//		if (noOfRides != other.noOfRides)
//			return false;
//		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
//			return false;
//		return true;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0
				&& Double.compare(that.avgFare, avgFare) == 0;
	}
}
