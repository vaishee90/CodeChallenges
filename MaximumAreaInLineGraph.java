
public class MaximumAreaInLineGraph {
    public static int maxArea(int[] height) {
        int newArea = 0;
        int max_area = 0;
        for(int i=0,j=height.length-1;i<height.length;){
                newArea = Math.min(height[i], height[j]) * (j-i);
                if(newArea > max_area){
                    max_area = newArea;
                    j--; 
                }
                else{
//                    j = height.length - 1;
                    i++;
                }
            
                //if(j-i < 2)
                    //break;
        }
        return max_area;
    }
}
