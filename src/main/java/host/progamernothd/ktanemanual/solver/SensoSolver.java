package host.progamernothd.ktanemanual.solver;

import java.util.LinkedList;
import java.util.List;

import host.progamernothd.ktanemanual.enums.KTANEColor;
import static host.progamernothd.ktanemanual.enums.KTANEColor.*;
import host.progamernothd.ktanemanual.windows.MainWindow;

public class SensoSolver {
	static {
		v0 = List.of(Blue, Red, Yellow, Green);
		v1 = List.of(Yellow, Green, Blue, Red);
		v2 = List.of(Green, Red, Yellow, Blue);
		nv0 = List.of(Blue, Yellow, Green, Red);
		nv1 = List.of(Red, Blue, Yellow, Green);
		nv2 = List.of(Yellow, Green, Blue, Red);
	}
	public static LinkedList<KTANEColor> solve(LinkedList<KTANEColor> combination) {
		
		if(serialContainsVocals()) {
			switch(getStrikes()) {
			case 0:
				System.out.println("v0");return generateOrder(combination, v0);
			case 1:
				System.out.println("v1");return generateOrder(combination, v1);
			case 2:
				System.out.println("v2");return generateOrder(combination, v2);
			}
		} else {
			switch(getStrikes()) {
			case 0:
				System.out.println("nv0");return generateOrder(combination, nv0);
			case 1:
				System.out.println("nv1");return generateOrder(combination, nv1);
			case 2:
				System.out.println("nv2");return generateOrder(combination, nv2);
			}
		}
		
		throw new IllegalArgumentException("Dunno wrong input" + combination.toString());
	}
	
	private static LinkedList<KTANEColor> generateOrder(LinkedList<KTANEColor> in, List<KTANEColor> sort) {
		LinkedList<KTANEColor> out = new LinkedList<>();
		for(KTANEColor crr : in) {
			/* KEEP IN THIS ORDER, otherwise this "table" processing will not work!
			 * The lists are sorted to work with this
			 */
			
			if(crr==Red) {
				out.add(sort.get(0));
				continue;
			}
			if(crr==Blue) {
				out.add(sort.get(1));
				continue;
			}
			if(crr==Green) {
				out.add(sort.get(2));
				continue;
			}
			if(crr==Yellow) {
				out.add(sort.get(3));
				continue;
			}
			
		}
		System.out.printf("Debug: %s %s %s%n", in, sort, out);
		return out;
	}
	
	private static int getStrikes() {
		return MainWindow.strikes;
	}
	
	private static boolean serialContainsVocals() {
		String serial = MainWindow.serialID;
		for(int i=0; i<serial.length(); i++) {
			char crr = serial.charAt(i);
			if(isVowel(crr)) {
				return true;
			}
		}
		
		return false;
	}
	private static boolean isVowel(Character c) {
		//You can just use regex.... now it works so it stays that way
		if(c=='a' ||  c=='e' ||  c=='i' ||  c=='o' ||  c=='u' ||  c=='A' ||  c=='E' ||  c=='I' ||  c=='O' ||  c=='U') {
			return true;
		}
		return false;
	}
	
	//v = vocal nv = no vocal 1,2,3 = errors
	private static List<KTANEColor> v0;
	private static List<KTANEColor> v1;
	private static List<KTANEColor> v2;
	private static List<KTANEColor> nv0;
	private static List<KTANEColor> nv1;
	private static List<KTANEColor> nv2;
	

}
