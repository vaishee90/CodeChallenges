import java.util.ArrayList;
import java.util.List;

public class APINumberPatternFinder {
	public static boolean isAPINumber(String s) {
		if(!s.equals(null)) {
			if(s.matches("(6[0-1]|[1-5][0-9]|[0][1-9])\\-[0-9]{3}\\-[0-9]{5}\\-[0-9]{2}\\-[0-9]{2}")) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<String> mlist = new ArrayList<String>();
		mlist.add("12-445-78954-00-12");
		mlist.add("We are all-good");
		mlist.add("01-904-77685-01-11");
		mlist.add("Ok-one-super-ok-ok");
		mlist.add("11-708-67493-03-56");
		
		for(String item: mlist) {
			if(isAPINumber(item))
				System.out.println(item);
		}
	}
}
