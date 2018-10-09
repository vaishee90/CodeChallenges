
public class RotateLeft {
    static int[] rotLeft(int[] a, int d) {
        int oldPos = 0;
        int newPos = 0;
        int arrLen = a.length;
        int valToRotate = a[oldPos];
        int count = 0;
        
        if(arrLen == 1 || d % arrLen == 0)
            return a;
        
        while (count <= arrLen) {
            newPos = (oldPos + (arrLen - (d % arrLen))) % arrLen;

            valToRotate = valToRotate + a[newPos];
            a[newPos] = valToRotate - a[newPos];
            valToRotate = valToRotate - a[newPos];

            if (count !=0 && count % 2 == 0 && d == arrLen / 2) {
                oldPos = newPos + 1;
                valToRotate = a[oldPos%arrLen];
            }
            else
                oldPos = newPos;
                      
            count++;
        }

        return a;
    }

	public static void main(String[] args) {
		int[] ans = rotLeft(new int[] { 1, 2, 3, 4, 5, 6 , 7, 8, 9, 10}, 5);
		for (int i : ans) {
			System.out.println(i);
		}
	}
}
