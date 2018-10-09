import java.util.ArrayList;
import java.util.List;

public class APINumberFinder {
	
	private static boolean isInteger(String s) {
		if(s.matches("\\d+"))
			return true;
		return false;
	}
	
	public static List<String> FindAPINumbers(List<String> mylist) {
		List<String> APIList = new ArrayList<String>();
		if(!mylist.isEmpty()) {
			for(String item:mylist) {
				String[] parts = item.split("-");
				if(parts.length != 5) {
					continue;
				}
				else {
					if (!(parts[0].length() == 2 && isInteger(parts[0]) && Integer.parseInt(parts[0]) <= 61 && Integer.parseInt(parts[0]) >= 00)) {
						continue;
					}
					if(!(parts[1].length() == 3) && isInteger(parts[1])) {
						continue;
					}
					if(!(parts[2].length() == 5) && isInteger(parts[2])) {
						continue;
					}
					if(!(parts[3].length() == 2) && isInteger(parts[3])) {
						continue;
					}
					if(!(parts[4].length() == 2) && isInteger(parts[4])) {
						continue;
					}
					APIList.add(item);
				}
			}
		}
		return APIList;
	}
	
	public static void main(String[] args) {
		List<String> mlist = new ArrayList<String>();
		mlist.add("12-445-78954-00-12");
		mlist.add("We are all-good");
		mlist.add("00-904-77685-01-11");
		mlist.add("Ok-one-super-ok-ok");
		mlist.add("11-708-67493-03-56");
		
		List<String> result = FindAPINumbers(mlist);
		if(!result.isEmpty()) {
			for(String item : FindAPINumbers(mlist)) {
				System.out.println(item);
			}
		}
		System.out.println("Processed List");
	}
}
