package com.learn.coffee;

public class BrewingUnit {

	public Coffee brew(CoffeeSelection selection, GroundCoffee groundCoffee,
			double quantity) {
		System.out.println("I am inside the brew");
		return new Coffee(selection, quantity);
	}

}
