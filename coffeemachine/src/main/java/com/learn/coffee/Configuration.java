package com.learn.coffee;

public class Configuration {

	private double quantityCoffee;
	private double quantityWater;

	public Configuration(double quantityCoffee, double quantityWater) {
		System.out.println("I am inside configuration const");
		this.quantityCoffee = quantityCoffee;
		this.quantityWater = quantityWater;
	}

	public double getQuantityCoffee() {
		return quantityCoffee;
	}

	public double getQuantityWater() {
		return quantityWater;
	}

	@Override
	public String toString() {
		return "Configuration [quantityCoffee=" + quantityCoffee + ", quantityWater=" + quantityWater + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(quantityCoffee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantityWater);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuration other = (Configuration) obj;
		if (Double.doubleToLongBits(quantityCoffee) != Double.doubleToLongBits(other.quantityCoffee))
			return false;
		if (Double.doubleToLongBits(quantityWater) != Double.doubleToLongBits(other.quantityWater))
			return false;
		return true;
	}

}
