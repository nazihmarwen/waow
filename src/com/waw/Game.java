package com.waw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.waw.accessories.weapon.magic.MagicWand;
import com.waw.accessories.weapon.melee.Axe;
import com.waw.accessories.weapon.melee.Sword;
import com.waw.accessories.weapon.range.Bow;
import com.waw.activities.civilian.Builder;
import com.waw.activities.civilian.Engineer;
import com.waw.activities.military.Archer;
import com.waw.activities.military.Military;
import com.waw.activities.military.Swordman;
import com.waw.activities.military.Wizard;
import com.waw.persons.Elf;
import com.waw.persons.Human;
import com.waw.persons.Orc;
import com.waw.persons.Person;

public class Game {

	public static void main(String[] args) {
		
//		scenario1();
		scenario2();
	}
	
	public static void scenario1() {

		// Civilian 

		Person gor = new Orc("Gor", 120, null, null);
		gor.setActivity(new Builder());
		
		System.out.println(gor);
		
		gor.setActivity(new Engineer());
		System.out.println(gor);
		
		gor.addAccessory(new Sword());
		gor.setCurrent_accessory(gor.getAccessories().get(0));
		
		System.out.println("Fin du scénario");
	}

	public static void scenario2() {
		
		Person illidan = new Elf("Illidan", 130, new Archer(), null);
		illidan.addAccessory(new Bow());
		
		Person thrall = new Orc("Thrall", 100, new Swordman(), null);
		thrall.addAccessory(new Axe());
		
		Person medivh = new Human("Medivh", 80, new Wizard(), null);
		medivh.addAccessory(new MagicWand());
		
		List<Person> fighters = new ArrayList<Person>(Arrays.asList(
				illidan, thrall, medivh
				));
		Collections.shuffle(fighters);
		
		do {
			Collections.shuffle(fighters);
			fight(fighters);
		} while (areSeveralFightersAlive(fighters));

		System.out.println("Fin du scénario");
	}
	
	@SuppressWarnings("rawtypes")
	public static void fight(List<Person> fighters) {

		for (Iterator iterator = fighters.iterator(); iterator.hasNext();) {
			
			Person current = (Person) iterator.next();
			
			if (!iterator.hasNext()) break;
			
			Person enemy = (Person) iterator.next();
			Military activity = (Military)current.getActivity();
			
			activity.attack(current, enemy);
			
			if (!enemy.isAlive()) {
				System.out.println(enemy.getName() + " fought well ! But died...");
				iterator.remove();
				System.out.println("Remaining fighters :");
				fighters.forEach((p) -> System.out.println(p.getName() + " "));
				System.out.println();
			}
		}
	}
	
	public static boolean areSeveralFightersAlive(List<Person> fighters) {
		return fighters.size() > 1;
	}
}
