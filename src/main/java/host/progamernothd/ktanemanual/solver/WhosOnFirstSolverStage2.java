package host.progamernothd.ktanemanual.solver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class WhosOnFirstSolverStage2 {
	
	private static HashMap<String, String[]> combos = new HashMap<>();
	
	static {
		combos.put("READY", new String[] {"YES","OKAY","WHAT","MIDDLE","LEFT","PRESS","RIGHT","BLANK","READY","NO","FIRST","UHHH","NOTHING","WAIT"});
		combos.put("FIRST", new String[] {"LEFT","OKAY","YES","MIDDLE","NO","RIGHT","NOTHING","UHHH","WAIT","READY","BLANK","WHAT","PRESS","FIRST"});
		combos.put("NO", new String[] {"BLANK","UHHH","WAIT","FIRST","WHAT","READY","RIGHT","YES","NOTHING","LEFT","PRESS","OKAY","NO","MIDDLE"});
		combos.put("BLANK", new String[] {"WAIT","RIGHT","OKAY","MIDDLE","BLANK","PRESS","READY","NOTHING","NO","WHAT","LEFT","UHHH","YES","FIRST"});
		combos.put("NOTHING", new String[] {"UHHH","RIGHT","OKAY","MIDDLE","YES","BLANK","NO","PRESS","LEFT","WHAT","WAIT","FIRST","NOTHING","READY"});
		combos.put("YES", new String[] {"OKAY","RIGHT","UHHH","MIDDLE","FIRST","WHAT","PRESS","READY","NOTHING","YES","LEFT","BLANK","NO","WAIT"});
		combos.put("WHAT", new String[] {"UHHH","WHAT","LEFT","NOTHING","READY","BLANK","MIDDLE","NO","OKAY","FIRST","WAIT","YES","PRESS","RIGHT"});
		combos.put("UHHH", new String[] {"READY","NOTHING","LEFT","WHAT","OKAY","YES","RIGHT","NO","PRESS","BLANK","UHHH","MIDDLE","WAIT","FIRST"});
		combos.put("LEFT", new String[] {"RIGHT","LEFT","FIRST","NO","MIDDLE","YES","BLANK","WHAT","UHHH","WAIT","PRESS","READY","OKAY","NOTHING"});
		combos.put("RIGHT", new String[] {"YES","NOTHING","READY","PRESS","NO","WAIT","WHAT","RIGHT","MIDDLE","LEFT","UHHH","BLANK","OKAY","FIRST"});
		combos.put("MIDDLE", new String[] {"BLANK","READY","OKAY","WHAT","NOTHING","PRESS","NO","WAIT","LEFT","MIDDLE","RIGHT","FIRST","UHHH","YES"});
		combos.put("OKAY", new String[] {"MIDDLE","NO","FIRST","YES","UHHH","NOTHING","WAIT","OKAY","LEFT","READY","BLANK","PRESS","WHAT","RIGHT"});
		combos.put("WAIT", new String[] {"UHHH","NO","BLANK","OKAY","YES","LEFT","FIRST","PRESS","WHAT","WAIT","NOTHING","READY","RIGHT","MIDDLE"});
		combos.put("PRESS", new String[] {"RIGHT","MIDDLE","YES","READY","PRESS","OKAY","NOTHING","UHHH","BLANK","LEFT","FIRST","WHAT","NO","WAIT"});
		combos.put("YOU", new String[] {"SURE","YOUARE","YOUR","YOU'RE","NEXT","UHHUH","UR","HOLD","WHAT?","YOU","UHUH","LIKE","DONE","U"});
		combos.put("YOU ARE", new String[] {"YOUR","NEXT","LIKE","UHHUH","WHAT?","DONE","UHUH","HOLD","YOU","U","YOU'RE","SURE","UR","YOUARE"});
		combos.put("YOUR", new String[] {"UHUH","YOUARE","UHHUH","YOUR","NEXT","UR","SURE","U","YOU'RE","YOU","WHAT?","HOLD","LIKE","DONE"});
		combos.put("YOU'RE", new String[] {"YOU","YOU'RE","UR","NEXT","UHUH","YOUARE","U","YOUR","WHAT?","UHHUH","SURE","DONE","LIKE","HOLD"});
		combos.put("UR", new String[] {"DONE","U","UR","UHHUH","WHAT?","SURE","YOUR","HOLD","YOU'RE","LIKE","NEXT","UHUH","YOUARE","YOU"});
		combos.put("U", new String[] {"UHHUH","SURE","NEXT","WHAT?","YOU'RE","UR","UHUH","DONE","U","YOU","LIKE","HOLD","YOUARE","YOUR"});
		combos.put("UH HUH", new String[] {"UHHUH","YOUR","YOUARE","YOU","DONE","HOLD","UHUH","NEXT","SURE","LIKE","YOU'RE","UR","U","WHAT?"});
		combos.put("UH UH", new String[] {"UR","U","YOUARE","YOU'RE","NEXT","UHUH","DONE","YOU","UHHUH","LIKE","YOUR","SURE","HOLD","WHAT?"});
		combos.put("WHAT?", new String[] {"YOU","HOLD","YOU'RE","YOUR","U","DONE","UHUH","LIKE","YOUARE","UHHUH","UR","NEXT","WHAT?","SURE"});
		combos.put("DONE", new String[] {"SURE","UHHUH","NEXT","WHAT?","YOUR","UR","YOU'RE","HOLD","LIKE","YOU","U","YOUARE","UHUH","DONE"});
		combos.put("NEXT", new String[] {"WHAT?","UHHUH","UHUH","YOUR","HOLD","SURE","NEXT","LIKE","DONE","YOUARE","UR","YOU'RE","U","YOU"});
		combos.put("HOLD", new String[] {"YOUARE","U","DONE","UHUH","YOU","UR","SURE","WHAT?","YOU'RE","NEXT","HOLD","UHHUH","YOUR","LIKE"});
		combos.put("SURE", new String[] {"YOUARE","DONE","LIKE","YOU'RE","YOU","HOLD","UHHUH","UR","SURE","U","WHAT?","NEXT","YOUR","UHUH"});
		combos.put("LIKE", new String[] {"YOU'RE","NEXT","U","UR","HOLD","DONE","UHUH","WHAT?","UHHUH","YOU","LIKE","SURE","YOUARE","YOUR"});
	}

	public static String[] solve(String s) {
		s = s.toUpperCase();
		
		Iterator<Entry<String, String[]>> iterator = combos.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String[]> crr = iterator.next();
			if(s.equals(crr.getKey())) {
				return crr.getValue();
			}
		}
		
		throw new IllegalArgumentException("Not in list");		
	}
	
}
