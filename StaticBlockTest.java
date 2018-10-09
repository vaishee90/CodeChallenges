import java.util.ArrayList;
import java.util.List;

class Counter{
	static int count = 0;
	static {
		count++;	
		System.out.println("Inside static block");
	}
	Counter(){
		System.out.println("Inside constructor block");
	}
	static void getCount() {
		System.out.println(count);
	}
}

public class StaticBlockTest {
	static {
		System.out.println("Inside static block in main class");
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Inside main method");
		String s2 = new String("Apple");
		String s1 = "Apple";
		
		
		System.out.println(s1.equals(s2));
		System.out.println(s2==s1);
//		List<Counter> list = new ArrayList<>();
//		int count = 100;
//		for(int i=0;i<count;i++) {
//			list.add(new Counter());
//		}
//		Counter c = null;
		//Counter c = new Counter();
	}
}
