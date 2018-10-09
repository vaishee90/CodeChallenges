import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GenericsExample {
	
	public static <T> Set<T> gift(Set<T> s){
		return s;
	}
	
	public static void add(int a, int b) {
		
	}
	
	public void add() {
		
	}
	
	public static void main(String[] args) {
		Set<Integer> sit = new HashSet();
		sit.add(1);
		sit.add(2);
		Set<?> s1 = gift(sit);
		System.out.println(s1.size());
		Set<String> sit2 = new HashSet();
		sit2.add("abc");
		sit2.add("2");
		sit2.add("3");
		Set<?> s2 = gift(sit2);
		System.out.println(s2.size());
	}
}

