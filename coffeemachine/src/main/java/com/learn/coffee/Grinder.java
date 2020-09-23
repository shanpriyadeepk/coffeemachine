package com.learn.coffee;


public class Grinder {

	public GroundCoffee grind(CoffeeBean coffeeBean, double quantityCoffee) {
		System.out.println("I am inside the grind");
		return new GroundCoffee();
	}

}
