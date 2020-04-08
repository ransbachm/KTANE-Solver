package host.progamernothd.ktanemanual.solver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PasswordSolver {
	
	static String[] passwords = new String[] {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn", "never", "other", "place", 
			"plant", "point", "right", "small", "sound", "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write"};
	
	public static List<String> solve(String text) {
		List<String> possiblePasswords = new LinkedList<>();
		
		char[][] parts = deformatInputString(text);
		System.out.println("possiblrPasswords :" + possiblePasswords);
		System.out.println("parts :" + Arrays.deepToString(parts));
		
		for(String password : passwords) {
			if(wordMatches(password, parts))
				possiblePasswords.add(password);
		}
		
		return possiblePasswords;
	}
	
	// well.. it works
	private static char[][] deformatInputString(String text) {
		String [] partsBuf;
		char [][] parts; 
		List<char []> partsList = new LinkedList<char []>(); // hope that works
		if(text.indexOf(";") != -1) {
			partsBuf = text.split(";");
			for(String crr : partsBuf) {
				partsList.add(crr.toCharArray());
			}
			parts = new char[partsList.size()][];
			for(int i=0; i<partsList.size(); i++) {
				parts[i] = partsList.get(i);
			}
			
		} else {
			parts = new char[][] {text.toCharArray()};
		}
		return parts;
	}
	
	// same here
	private static boolean wordMatches(String wordString, char[][] charsToMatch) {
		char [] word = wordString.toCharArray();
		for(int i=0; i<word.length; i++) {
			System.out.println("word : " + new String(word) + " " + i);
			if(i==charsToMatch.length) {
				System.out.println("overflow");
				return true;
			}
			char crrChar = word[i];
			// check if any chartomatch matches
			if(!charInWordMatchesChars(crrChar, charsToMatch[i])) {
				return false;
			}
		}
		return true;
		
		
	}
	
	// same here
	private static boolean charInWordMatchesChars(char c, char[] chars) {
		for(char crr : chars) {
			if(c == crr) {
				return true;
			}
		}
		return false;
	}
	
	

}
