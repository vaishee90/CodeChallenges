import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//adada abacd 
public class FindingTwin {
	
	static boolean isTwin(String s1, String s2) {
		List<Character> oddList = new ArrayList<>();
		List<Character> evenList = new ArrayList<>();
		boolean ans = false;
		if(s1.length() == s2.length()) {
			for(int i=0;i<s1.length();i++) {
				if(i%2 == 0) {
					evenList.add(s1.charAt(i));
				}
				else {
					oddList.add(s1.charAt(i));
				}
			}
			for(int i=0;i<s2.length();i++) {
				if(i%2 == 0) {
					evenList.remove(new Character(s2.charAt(i)));
				}
				else {
					oddList.remove(new Character(s2.charAt(i)));
				}
			}
			
			if(evenList.size() == 0 && oddList.size() == 0)
				ans = true;
		}
		else
			ans = false;
		
		return ans;
	}
}
