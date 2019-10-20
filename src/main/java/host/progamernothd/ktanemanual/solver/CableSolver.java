package host.progamernothd.ktanemanual.solver;

import java.util.List;

import host.progamernothd.ktanemanual.enums.KTANEColor;
import host.progamernothd.ktanemanual.windows.MainWindow;

public class CableSolver {
	public static int solve(List<KTANEColor> list) {
		// https://bombmanual.github.io/german/
		
		switch(list.size()) {
		case 3:
			return solve3Cables(list);
		case 4:
			return solve4Cables(list);
		case 5:
			return solve5Cables(list);
		case 6:
			return solve6Cables(list);
		}
			
		throw new IndexOutOfBoundsException("Wrong cable count");
	}
	
	private static int solve6Cables(List<KTANEColor> list) {
		// If no yellow cables && last number of serial odd -> 3
		if(list.stream().filter(e->e == KTANEColor.Yellow).count() == 0 && (getLastInt(MainWindow.serialID) & 1) == 1) {
			return 3;
		}
		// If one yellow cable && more than one white cable -> 4
		if(list.stream().filter(e->e == KTANEColor.Yellow).count() == 1 && list.stream().filter(e->e == KTANEColor.White).count() > 1) {
			return 4;
		}
		if(list.stream().filter(e->e == KTANEColor.Red).count() == 0) {
			return 6;
		}
		return 4;
	}

	private static int solve5Cables(List<KTANEColor> list) {
		// If last cable black && last number of serial odd -> 4
		if(list.get(list.size()-1) == KTANEColor.Black && (getLastInt(MainWindow.serialID) & 1) == 1) {
			return 4;
		}
		// If 1 red && more than 1 yellow -> 1
		if(list.stream().filter(e->e == KTANEColor.Red).count() == 1 && list.stream().filter(e->e == KTANEColor.Yellow).count() > 1) {
			return 1;
		}
		// If no black cables -> 2
		if(list.stream().filter(e->e == KTANEColor.Black).count() == 0) {
			return 2;
		}
		return 1;
	}

	private static int solve4Cables(List<KTANEColor> list) {
		// If more than 1 red && last char of number of serial odd
		if(list.stream().filter(e->e == KTANEColor.Red).count() >= 2 && 
				(getLastInt(MainWindow.serialID) & 1) == 1) {
			return list.lastIndexOf(KTANEColor.Red) + 1;
		}
		// If last cable yellow && no red cables
		if(list.get(list.size()-1) == KTANEColor.Yellow && list.stream().filter(e->e == KTANEColor.Red).count() <=0) {
			return 1;
		}
		// If one blue cable
		if(list.stream().filter(e->e == KTANEColor.Blue).count() == 1) {
			return 1;
		}
		// If morre than 1 yello cable
		if(list.stream().filter(e->e == KTANEColor.Yellow).count() > 1) {
			return 4;
		}
		return 2;
	}

	private static int solve3Cables(List<KTANEColor> list) {
		// If no cable is red -> 2.
		if(!list.contains(KTANEColor.Red)) {
			return 2;
		} 
		// If last cable is white -> 3.
		if(list.subList(list.size() - 1, list.size()).contains(KTANEColor.White)) {
			return 3;
		}
		// If more than one blue -> last blue
		if(list.stream().filter(e->e == KTANEColor.Blue).count() >= 2) {
			return list.lastIndexOf(KTANEColor.Blue) + 1;
		}
		return 3;
	}
	private static int getLastInt(String serialID) {
		for(int i=serialID.length()-1; i>0; i--) {
			char crr = serialID.charAt(i);
			if(!Character.isDigit(crr)) continue;
			return Integer.parseInt(Character.toString(crr));
		}
		throw new IllegalArgumentException("No int found!");
	}

}
