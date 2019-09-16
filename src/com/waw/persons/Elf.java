package com.waw.persons;

import java.util.List;

import com.waw.accessories.Accessory;
import com.waw.activities.Activity;

public class Elf extends Person {

	/**
	 * 
	 */
	public Elf() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param lifepoints
	 * @param activity
	 * @param accessories
	 * @throws InvalidAccessoryException 
	 * @throws NullActivityException 
	 */
	public Elf(String name, int lifepoints, Activity activity, List<Accessory> accessories) {
		super(name, lifepoints, activity, accessories);
		// TODO Auto-generated constructor stub
	}

}
