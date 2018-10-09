import java.util.Arrays;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index1 = 0;
		int index2 = 0;
		int indexF = 0;

		int[] ans = new int[nums1.length];

		while (n > 0 && m > 0) {
			if (nums1[index1] <= nums2[index2]) {
				ans[indexF++] = nums1[index1];
				m--;
				index1++;
			} else {
				ans[indexF++] = nums2[index2];
				n--;
				index2++;
			}
			if (m == 0 && n!=0) {
				while (n !=0) {
					ans[indexF++] = nums2[index2++];
					n--;
				}	
			}
			if (n == 0 && m!=0) {
				while (m != 0) {
					ans[indexF++] = nums1[index1++];
					m--;
				}	
			}
		}

		System.out.println(Arrays.toString(ans));
	}
	
	public static void main(String[] args) {
		merge(new int[]{1,2,3,0,0,0},3,new int[]{2,4,5},3);
	}
}
