import java.io.IOException;
import java.util.*;

public class PoisonousPlants {
	
	private static final Scanner scanner = new Scanner(System.in);

	// Complete the poisonousPlants function below.
	static int poisonousPlants(int[] p) {
		boolean isPoison = false;
		int prev, curr;
		List<Integer> l = new ArrayList<>();
			
			prev = p[0];
			l.add(prev);
			for(int i=1;i<p.length;i++) {
				curr = p[i];
				if(prev > curr)
					l.add(curr);
				else
					isPoison = true;
				prev = curr;
			}
			
		int[] ans = new int[l.size()];
		for(int i=0;i<l.size();i++)
			ans[i] = l.get(i);
		
		if(isPoison)
			return 1 + poisonousPlants(ans);
		else
			return 0;

	}

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		System.out.println(poisonousPlants(p));

		scanner.close();
	}
}
