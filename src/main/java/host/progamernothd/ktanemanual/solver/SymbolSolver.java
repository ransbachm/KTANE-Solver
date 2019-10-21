package host.progamernothd.ktanemanual.solver;

import java.util.LinkedList;
import java.util.List;

import host.progamernothd.ktanemanual.enums.KTANESymbol;

import static host.progamernothd.ktanemanual.enums.KTANESymbol.*;

public class SymbolSolver {
	static {
		// Initialize the rows with the symbols that belong there
		row1 = List.of(Spoon, AT, SnA, Wave, Kraken, SnH, SnCTurnedwP);
		row2 = List.of(SnE, Spoon, SnCTurnedwP, Breeze, EmptyStar, SnH, TurnedQM);
		row3 = List.of(Copyright, SnW, Breeze, SnX, Sn3down, SnA, EmptyStar);
		row4 = List.of(Turned9, SnP, TB, Kraken, SnX, TurnedQM, Smiley);
		row5 = List.of(CandleHolder, Smiley, TB, SnCwP, SnP, Sn3all, FilledStar);
		row6 = List.of(Turned9, SnE, Lego, AE, CandleHolder, SnN, Omaga);
		
	}
	public static List<KTANESymbol> solve(List<KTANESymbol> list) {
		List<List<KTANESymbol>> rows = List.of(row1, row2, row3, row4, row5, row6);
		System.out.println(rows.get(5).containsAll(list));
		
		for(List<KTANESymbol> crr : rows) {
			if(crr.containsAll(list)) {
				List<KTANESymbol> cr2 = new LinkedList<>(crr);
				cr2.retainAll(list);
				return cr2;
			}
		}
		throw new IllegalArgumentException("No row found");
	}
	
	private static List<KTANESymbol> row1;
	private static List<KTANESymbol> row2;
	private static List<KTANESymbol> row3;
	private static List<KTANESymbol> row4;
	private static List<KTANESymbol> row5;
	private static List<KTANESymbol> row6;

}
