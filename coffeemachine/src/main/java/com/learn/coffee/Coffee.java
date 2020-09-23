package com.learn.coffee;

public class Coffee {

	private CoffeeSelection selection;
	
	private double quantity;

	public Coffee (CoffeeSelection selection, double quantity) {
		System.out.println("I am inside the coffee constructor");
		this.selection = selection;
		this.quantity = quantity;
	}
	
	public CoffeeSelection getSelection() {
		return selection;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Coffee [selection=" + selection + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((selection == null) ? 0 : selection.hashCode());
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
		Coffee other = (Coffee) obj;
		if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
			return false;
		if (selection != other.selection)
			return false;
		return true;
	}
}
