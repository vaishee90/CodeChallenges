
public class NewYearChaos {
	static void minimumBribes(int[] q) {
		int bribes = 0;
		for (int i = 0; i < q.length; i++) {
			if (q[i] != i+1) {
				if (q[i] < i - 1 || q[i] > i + 3) {
					System.out.println("Too chaotic");
					break;
				} else
					bribes++;
			}
		}

		System.out.println(bribes);

	}

	public static void main(String[] args) {
		NewYearChaos.minimumBribes(new int[] { 2, 1, 5, 3, 4 });
	}
}
