import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rodCutting {
    static int[] cutTheSticks(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        
        int[] sticksLengthWiseCount = new int[max+1];
        
        for(int i=0;i<arr.length;i++){
            sticksLengthWiseCount[arr[i]] += 1;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        ans.add(arr.length);
        
        while(min <= max && max > 0){
            int min_idx = Integer.MAX_VALUE;
            for(int j=min;j<=max;j++) {
                if(j!= min && j-min < min_idx && sticksLengthWiseCount[j] > 0)
                    min_idx = (j-min);
                sticksLengthWiseCount[j-min] += sticksLengthWiseCount[j];
                sticksLengthWiseCount[j] = 0;
            }
            max -= min;
            min = min_idx;
            if(sticksLengthWiseCount[0] != arr.length)
            	ans.add(arr.length - sticksLengthWiseCount[0]);
        }
        
        return ans.stream().mapToInt(i->i).toArray();

    }
    
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(cutTheSticks(new int[] {1, 2, 3, 4, 3, 3, 2, 1})));
	}
}
