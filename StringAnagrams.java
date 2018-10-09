import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StringAnagrams {
	
	public static List<List<String>> getAnagrams(List<String> strList){
		HashMap<String, List<String>> anagramMap = new LinkedHashMap<>(); 
		
		for(String s:strList) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sortedString = new String(c);
			if(anagramMap.containsKey(sortedString)) {
				anagramMap.get(sortedString).add(s);
			}
			else {
				List<String> item = new ArrayList<>();
				item.add(s);
				anagramMap.put(sortedString, item);
			}
		}
		
		List<List<String>> res = new ArrayList<>();
		for(String key : anagramMap.keySet()) {
			res.add(anagramMap.get(key));
		}
		
		//return res;
		return new ArrayList<List<String>>(anagramMap.values());
	}
	
	public static void main(String[] args) {
		//["eat", "tea", "tan", "ate", "nat", "bat"]
		List<String> strList = new ArrayList<>();
		strList.add("ant");
		strList.add("tan");
		strList.add("bat");
		strList.add("ate");
		strList.add("eat");
		strList.add("tea");
		System.out.println(getAnagrams(strList));
	}
}
