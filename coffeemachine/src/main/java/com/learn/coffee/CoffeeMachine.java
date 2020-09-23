package com.learn.coffee;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

	private Map<CoffeeSelection, Configuration> configMap;
	
	private Map<CoffeeSelection, CoffeeBean> beans;
	
	private Grinder grinder;
	
	private BrewingUnit brewingUnit;

	public CoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
		this.beans = beans;
		this.grinder = new Grinder();
		this.brewingUnit = new BrewingUnit();
		
		this.configMap = new HashMap<CoffeeSelection, Configuration>();
		this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
	}
	
	public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
		System.out.println("I am inside brew coffee of coffee machine");
		switch (selection) {
			case FILTER_COFFEE:
				return brewFilterCoffee();
				
			case ESPRESSO:
				return brewEspresso();
							
			default:
				throw new CoffeeException("CoffeeSelection ["+selection+"] not supported!");
		}
	}

	private Coffee brewEspresso() {
		System.out.println("I am inside brew brewEspresso of coffee machine");
		Configuration config = configMap.get(CoffeeSelection.ESPRESSO);
		System.out.println(" getQuantityCoffee  " +config.getQuantityCoffee());
		System.out.println(" getQuantityWater  " +config.getQuantityWater());
		// grind the coffee beans
		GroundCoffee groundCoffee = this.grinder.grind(this.beans.get(CoffeeSelection.ESPRESSO), config.getQuantityCoffee());
		System.out.println(groundCoffee.toString());
		// brew an espresso
		return this.brewingUnit.brew(CoffeeSelection.ESPRESSO, groundCoffee, config.getQuantityWater());
	}

	private Coffee brewFilterCoffee() {
		System.out.println("I am inside brew brewFilterCoffee of coffee machine");
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);
		
		// grind the coffee beans
		GroundCoffee groundCoffee = this.grinder.grind(this.beans.get(CoffeeSelection.FILTER_COFFEE), config.getQuantityCoffee());
		
		// brew a filter coffee
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee, config.getQuantityWater());
	}
}
