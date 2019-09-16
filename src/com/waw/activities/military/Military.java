package com.waw.activities.military;

import com.waw.accessories.weapon.Weapon;
import com.waw.activities.Activity;
import com.waw.persons.Person;

public abstract class Military implements Activity {

	int strength;
	
	public void attack(Person current, Person enemy) {		
		
		System.out.println("======= NEW FIGHT !!! =======");
		System.out.println(current.getName() + " attacks " + enemy.getName() + " !");

		int damages = getTotalDamages(current);
		hurtEnemy(enemy, damages);
		
		System.out.println(current.getName() + " dealt " + damages + " damages to "+ enemy.getName() + " ! :O");
		System.out.println(enemy.getName() + " remaining life : " + enemy.getLifepoints());
		System.out.println("=============================");
		System.out.println();
	}
	
	public void hurtEnemy(Person enemy, int damages) {
		int enemy_lifepoints = enemy.getLifepoints();
		enemy.setLifepoints(enemy_lifepoints - damages);
	}
	
	public int getTotalDamages(Person current) {
		
		Weapon current_weapon = (Weapon)current.getCurrent_accessory();
		return current_weapon.getDamages() + strength;
	}
}
