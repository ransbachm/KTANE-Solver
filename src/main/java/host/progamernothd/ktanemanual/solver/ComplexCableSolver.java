package host.progamernothd.ktanemanual.solver;

import host.progamernothd.ktanemanual.KtanePlusPlusMain;
import host.progamernothd.ktanemanual.enums.ComplexCableFeature;
import host.progamernothd.ktanemanual.windows.MainWindow;

import static host.progamernothd.ktanemanual.enums.ComplexCableFeature.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ComplexCableSolver {
	
	public static List<ComplexCableFeature> r;
	public static List<ComplexCableFeature> b;
	public static List<ComplexCableFeature> s;
	public static List<ComplexCableFeature> l;
	public static List<ComplexCableFeature> rl;
	public static List<ComplexCableFeature> rb;
	public static List<ComplexCableFeature> rs;
	public static List<ComplexCableFeature> bl;
	public static List<ComplexCableFeature> bs;
	public static List<ComplexCableFeature> sl;
	public static List<ComplexCableFeature> rsl;
	public static List<ComplexCableFeature> bsl;
	public static List<ComplexCableFeature> rbs;
	public static List<ComplexCableFeature> rbl;
	public static List<ComplexCableFeature> rbsl;
	
	private static List<List<ComplexCableFeature>> lists;
	private static HashMap<List<ComplexCableFeature>, String> map = new HashMap<>();

	static {
		r = List.of(Red);
		b = List.of(Blue);
		s = List.of(Star);
		l = List.of(LED);
		rl = List.of(Red, Star);
		rb = List.of(Red, Blue);
		rs = List.of(Red, Star);
		bl = List.of(Blue, LED);
		bs = List.of(Blue, Star);
		sl = List.of(Star, LED);
		rsl = List.of(Red, Star, LED);
		bsl = List.of(Blue, Star, LED);
		rbs = List.of(Red, Blue, Star);
		rbl = List.of(Red, Blue, LED);
		rbsl = List.of(Red, Blue, Star, LED);
		
		lists = List.of(r,b,s,l,rl,rb,rs,bs,sl,rsl,bsl,rbs,rbl,rbsl);
		
		map.put(r, solveSerial());
		map.put(b, solveSerial());
		map.put(s, "cut");
		map.put(l, "Don't cut");
		map.put(rl, solveBatteries());
		map.put(rb, solveSerial());
		map.put(rs, "cut");
		map.put(bl, solveParallel());
		map.put(bs, "Don't cut");
		map.put(sl, solveBatteries());
		map.put(rsl, solveBatteries());
		map.put(bsl, solveParallel());
		map.put(rbs, solveParallel());
		map.put(rbl, solveSerial());
		map.put(rbsl, "Don't cut");
		
	
	}
	public static String solve(LinkedList<ComplexCableFeature> in) {
		for(List<ComplexCableFeature> crr : lists) {
			if(in.equals(crr)) {
				System.out.println("SAME! " + crr.toString() + " " + in.toString());
				return map.get(crr);
			}
			
		}
		
		return "cut";
	}
	
	private static String solveSerial() {
		if((getLastInt(MainWindow.serialID) & 1) == 0) {
			return "cut";
		}
		return "Don't cut";
	}
	private static String solveParallel() {
		if(KtanePlusPlusMain.mw.getParalellCheckbox().isSelected()) {
			return "cut";
		}
		return "Don't cut";
	}
	private static String solveBatteries() {
		if(KtanePlusPlusMain.mw.batteryComboBox.getSelectedIndex()>=2) {
			return "cut";
		}
		return "Don't cut";
	}
	
	private static LinkedList<ComplexCableFeature> toLinkedList(List<ComplexCableFeature> in) {
		return new LinkedList<>(in);
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
