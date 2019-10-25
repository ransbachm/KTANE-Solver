package host.progamernothd.ktanemanual.solver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WhosOnFirstSolverStage1 {
	private static List<String> /*feint - */ words;	
	private static List<Integer> ints;	
	static HashMap<String, Integer> combos = new HashMap<>();
	
	static {
		words = List.of("YES", "FIRST", "DISPLAY", "OKAY", "SAYS", "NOTHING ", "[nothing]", "BLANK", "NO", "LED", "LEAD", 
				"READ", "RED", "REED", "LEED", "HOLD  ON", "YOU", "YOUARE", "YOUR", "YOU\'RE", "UR", "THERE", "THEY\'RE", 
				"THEIR", "THEYARE", "SEE", "C", "CEE");
		
		ints = List.of(3,2,6,2,6,3,5,4,6,3,6,4,4,5,5,6,4,6,4,4,1,6,5,4,4,6,2,6);
		Iterator<Integer>  iterator = ints.iterator();
		for(String crr : words) {
			combos.put(crr, iterator.next());
		}
		
		
	}
	
	public static Integer solve(String s) {
		s = s.toUpperCase();
		if(combos.containsKey(s)) {
			return combos.get(s);
		}
		throw new IllegalArgumentException("Not in map");
	}

}
